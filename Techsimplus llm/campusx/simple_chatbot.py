from langchain_groq import ChatGroq
from dotenv import load_dotenv
load_dotenv()
model=ChatGroq(model="openai/gpt-oss-120b")
history=[]
while True:
    usr_input=input("You : ")
    history.append({"role":"user","content":usr_input})
    if usr_input=="exit":
        break
    resp=model.invoke(history)
    history.append({"role":"ai","content":resp.content})
    if resp:
        print("AI : "+resp.content)

print(history)
