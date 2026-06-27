
from langchain_community.vectorstores import Chroma
from langchain_ollama import ChatOllama,OllamaEmbeddings
from langchain_core.prompts import PromptTemplate
from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel

class QueryRequest(BaseModel):
    query:str

app=FastAPI()
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)
llm=ChatOllama(model="llama3:8b")
embeddings=OllamaEmbeddings(model="llama3:8b")
vector_store=Chroma(embedding_function=embeddings,persist_directory="C:\\Users\\pagil\\OneDrive\\Documents\\Programming\\Techsimplus llm\\campusx\\youtube_rag")


@app.post("/ask")
def ask_question(query:QueryRequest):
    query = query.query.strip()
    if not query:
        raise HTTPException(status_code=400, detail="Query cannot be empty")

    try:
        retrieved_docs = vector_store.similarity_search(query=query, k=3)

    except Exception as e:
        raise HTTPException(status_code=500, detail=f"Retrieval failed: {str(e)}")

    context = " ".join([i.page_content for i in retrieved_docs])
    if not context:
        return {"response": "I can't answer your question because the video doesn't contain information regarding the question asked.","length":len(retrieved_docs),"Count": vector_store._collection.count()}

#     prompt_template=PromptTemplate.from_template(
#         """
# You are an assistant.
# Answer only using the provided context.
# If the answer is not present in context, reply exactly:
# I can't answer your question because the video doesn't contain information regarding the question asked.


# Question: {query}
# Context:
# {context}
# """
#     )

    prompt_template=PromptTemplate.from_template(
        """
You are an assistant.answer the question from the context

Question: {query}
Context:
{context}
"""
    )
    prompt = prompt_template.invoke({"query": query, "context": context})
    response = llm.invoke(prompt)
    return {"response": response.content.strip(), "length": len(retrieved_docs), "Count": vector_store._collection.count(),"context":context}