from langchain_classic.retrievers import ContextualCompressionRetriever
from langchain_classic.retrievers.document_compressors import LLMChainExtractor
from langchain_ollama import ChatOllama
from langchain_ollama import OllamaEmbeddings
from langchain_community.vectorstores import Chroma

# Base retriever
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
base_retriever = vectorstore.as_retriever()

# LLM used for compression
llm = ChatOllama(model="llama3:8b")

# Compressor
compressor = LLMChainExtractor.from_llm(llm)

# Contextual Compression Retriever
compression_retriever = ContextualCompressionRetriever(
    base_compressor=compressor,
    base_retriever=base_retriever
)

docs = compression_retriever.invoke(
    "What are the benefits of Kafka?"
)

for doc in docs:
    print(doc.page_content)