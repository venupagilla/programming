from langchain_classic.output_parsers import StructuredOutputParser , ResponseSchema
from langchain_ollama import ChatOllama
from langchain_core.prompts import PromptTemplate

#creation
model=ChatOllama(model="llama3.2:1b")
schema=[
    ResponseSchema(name="name",description="name of the person"),
    ResponseSchema(name="age",description="age of the person"),
    ResponseSchema(name="city",description="city of the person")
]
parser=StructuredOutputParser.from_response_schemas(schema)
template=PromptTemplate.from_template("Give details of an imaginary person who is living in {state} \n {format_instructions}").partial(format_instructions=parser.get_format_instructions())

#invoking and prininting
print(f"original template : {template}")
print(f"original schema : {schema}")
chain=template | model | parser
state1=input("Enter the preferred state : ")
resp=chain.invoke({"state":state1})
print(resp)