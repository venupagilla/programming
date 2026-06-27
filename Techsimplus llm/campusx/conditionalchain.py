from dotenv import load_dotenv

from langchain_groq import ChatGroq
from langchain_core.prompts import PromptTemplate
from langchain_core.output_parsers import StrOutputParser
from langchain_core.runnables import RunnableBranch
load_dotenv()

# LLM
model = ChatGroq(model="openai/gpt-oss-120b")

# Prompts
temp1 = PromptTemplate.from_template("Create a clear 5-line report on the topic: {topic}")
temp2 = PromptTemplate.from_template("Create a clear 10-line report on the topic: {topic}")
parser = StrOutputParser()

# Chains
five_line_chain = temp1 | model | parser
ten_line_chain = temp2 | model | parser

# Branch Logic
branch_chain = RunnableBranch(
    (lambda x: x["report_type"] == "five",five_line_chain),
    (lambda x: x["report_type"] == "ten",ten_line_chain),
    five_line_chain  # default branch
)

# Execute
response = branch_chain.invoke(
    {
        "topic": "Prabhas",
        "report_type": "five"
    }
)

print(response)

# Graph
branch_chain.get_graph().print_ascii()