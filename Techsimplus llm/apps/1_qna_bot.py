#importing necessary libraries
import dotenv
from langchain_google_genai import ChatGoogleGenerativeAI
import streamlit as st

#loading the env variables
dotenv.load_dotenv()

#creating llm object
model=ChatGoogleGenerativeAI(model="gemini-2.5-flash-lite")

#UI initialization
st.title("AI ChatBot")
st.markdown("This is a basic chat bot using gemini flash 2.5")

#creating a session state variable in streamlit to store all the message in the chat
if "messages" not in st.session_state:
    st.session_state.messages=[]

#loop to display all the history stored in messages
for message in st.session_state.messages:
    role=message["role"]
    content=message["content"]
    st.chat_message(role).markdown(content)

#chat logic
query=st.chat_input("Ask anything")
if query:
    st.session_state.messages.append({"role":"user","content":query})
    st.chat_message("user").markdown(query)
    resp=model.invoke(query)
    st.session_state.messages.append({"role":"ai","content":resp.content})
    st.chat_message("ai").markdown(resp.content)




