from langchain_classic.text_splitter import RecursiveCharacterTextSplitter
from langchain_community.document_loaders import PyPDFLoader,TextLoader

txtloader=TextLoader("data\prabhas.txt",encoding='utf-8')
text1=txtloader.load()
textsplitter=RecursiveCharacterTextSplitter(
    chunk_size=100,
    chunk_overlap=10,
)
print(len(text1))
splitted=textsplitter.split_text(text1[0].page_content)
print("length of splitted docs" , len(splitted),"\n")
print(f"types of splitted = {type(splitted)} \n splitted data is : \n")
print(splitted)