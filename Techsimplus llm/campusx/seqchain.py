from langchain_groq import ChatGroq
from langchain_core.prompts import PromptTemplate
from langchain_core.output_parsers import StrOutputParser
from langchain_core.runnables import RunnableSequence
from dotenv import load_dotenv
load_dotenv()


#creation 
model=ChatGroq(model="openai/gpt-oss-120b")
temp1=PromptTemplate.from_template(
    "Create a clear 2 page report on the topic {topic}"
)
temp2=PromptTemplate.from_template(
    "summarize the below text in 2 lines: {info}"
)
parser=StrOutputParser()

#Sequential chain creation
#type 1
# chain1=temp1 | model | parser | temp2 | model | parser

#type2
chain1=RunnableSequence(temp1,model,parser,temp2,model,parser)

#getting response 
resp1=chain1.invoke({"topic":"Prabhas"})
print("\n"+resp1+"\n")
print(chain1.get_graph().print_ascii())