from langchain_core.output_parsers import StrOutputParser
from langchain_core.prompts import PromptTemplate
from langchain_ollama import ChatOllama

#defining everything
model=ChatOllama(model="gemma3:270m")
parser=StrOutputParser()
template=PromptTemplate.from_template(
    "create a 5 line summary about {topic}"
)
inp=input("Enter the topic name : ")

#chain
chain1=template | model | parser
resp=chain1.invoke({"topic":inp})
print(resp)