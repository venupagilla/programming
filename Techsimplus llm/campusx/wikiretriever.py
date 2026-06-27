from langchain_community.retrievers import WikipediaRetriever
import wikipedia
wikipedia.set_user_agent("MyApp/1.0 (langchain_bot)")
retriever=WikipediaRetriever(top_k_results=2,lang="en")
resp=retriever.invoke("prabhas")
for i in range(2):
    print(i+1,"\n")
    print(resp[i].page_content,"\n\n\n\n")
