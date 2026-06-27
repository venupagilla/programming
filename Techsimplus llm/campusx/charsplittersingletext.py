from langchain_classic.text_splitter import CharacterTextSplitter
from langchain_community.document_loaders import TextLoader

txtloader=TextLoader("data\prabhas.txt",encoding='utf-8')
text1=txtloader.load()
textsplitter=CharacterTextSplitter(
    chunk_size=20,
    chunk_overlap=5,
    separator=""
)
print(len(text1))
splitted=textsplitter.split_text(text1[0].page_content)
print(len(splitted))
print(splitted[0])