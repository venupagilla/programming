from langchain_classic.text_splitter import CharacterTextSplitter
from langchain_community.document_loaders import PyPDFLoader

txtloader=PyPDFLoader("data\iot.pdf")
text1=txtloader.load()
textsplitter=CharacterTextSplitter(
    chunk_size=20,
    chunk_overlap=5,
    separator=""
)
print(len(text1))
splitted=textsplitter.split_documents(text1)
print("length of splitted docs" , len(splitted),"\n")
print(f"types of splitted = {type(splitted)} \n splitted data is : \n")
# print(splitted)