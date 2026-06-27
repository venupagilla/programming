from langchain_groq import ChatGroq
from dotenv import load_dotenv
import streamlit as st
from langchain_core.prompts import PromptTemplate
load_dotenv()

model = ChatGroq(model="openai/gpt-oss-120b", temperature=0.9, streaming=True)
st.title("Introduction to prompts")


tit=st.selectbox("Select a topic", ["What is a prompt?", "Types of prompts", "How to write effective prompts?"])

template=PromptTemplate.from_template("explain the below question clearly and concisely: {question}")
prompt = template.format(question=tit)
response = model.invoke(prompt)
st.chat_message("assistant").markdown(response.content)