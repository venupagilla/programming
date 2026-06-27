from langchain_community.document_loaders import PyPDFLoader
loader=PyPDFLoader(file_path="data/iot.pdf",mode="single")
docs=loader.load()
print(docs[0].page_content)