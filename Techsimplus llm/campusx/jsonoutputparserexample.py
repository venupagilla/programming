from langchain_core.prompts import PromptTemplate
from langchain_core.output_parsers import JsonOutputParser
from langchain_ollama import ChatOllama

#creation
parser=JsonOutputParser()
template=PromptTemplate.from_template("give name,age and city of a fictional person . /n {format_instructions}").partial(format_instructions=parser.get_format_instructions())
llm=ChatOllama(model="gemma3:270m")
resp=template | llm | parser

#testing
ans=resp.invoke({})
print(ans)

