from langchain_groq import ChatGroq
from langchain_core.prompts import PromptTemplate
from langchain_core.output_parsers import StrOutputParser
from langchain_core.runnables import RunnableParallel
from dotenv import load_dotenv
load_dotenv()

model=ChatGroq(model="openai/gpt-oss-120b")
temp1=PromptTemplate.from_template(
    "Create a clear 5 line report on the topic {topic}"
)
temp2=PromptTemplate.from_template(
    "Create a clear 10 line report on the topic {topic}"
)
parser=StrOutputParser()


parachain=RunnableParallel(
    {
        "five":temp1 | model | parser,
        "ten":temp2 | model | parser
    }
)
resp=parachain.invoke({"topic":"prabhas"})
print(f"\n Information from first chain : \n  {resp["five"]} \n\n Information from second chain : \n {resp["ten"]} \n Chain graph : {parachain.get_graph().print_ascii()}")