#importing necessary libraries
from langchain_community.utilities import GoogleSerperAPIWrapper
from langchain_groq import ChatGroq
from langchain.agents import create_agent
from langgraph.checkpoint.memory import MemorySaver
from dotenv import load_dotenv

#setting up models and other necessary components
load_dotenv()
model=ChatGroq(model="openai/gpt-oss-120b")
search=GoogleSerperAPIWrapper()

#creating agent
agent=create_agent(
    model=model,
    tools=[search.run],
    system_prompt="you are an agent who can search anything in google",
    checkpointer=MemorySaver()
)

#chat code
while True:
    ques=input("User : ")
    resp=agent.invoke({"messages":[{"role":"user","content":ques}]},
                      {"configurable":{"thread_id":"1"}})
    print(f"AI : {resp["messages"][-1].content}")