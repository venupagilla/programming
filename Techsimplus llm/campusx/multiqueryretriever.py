from langchain_chroma import Chroma
from langchain_ollama import ChatOllama, OllamaEmbeddings
from langchain_classic.retrievers import MultiQueryRetriever

# Embeddings
embeddings = OllamaEmbeddings(
    model="llama3:8b"
)
# Vector Store
vectorstore = Chroma.from_texts(
    [
        "Kafka provides high scalability.",
        "Kafka supports real-time stream processing.",
        "Kafka offers fault tolerance through replication."
    ],
    embedding=embeddings
)

# Base Retriever
retriever = vectorstore.as_retriever(search_kwargs={"k": 3})

# LLM for query generation
llm = ChatOllama(model="llama3:8b")

# Multi Query Retriever
multi_query_retriever = MultiQueryRetriever.from_llm(
    retriever=retriever,
    llm=llm
)

# Retrieve documents
docs = multi_query_retriever.invoke(
    "What are the benefits of Kafka?"
)

for doc in docs:
    print(doc.page_content)