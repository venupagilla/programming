#Importing the required libraries
from dotenv import load_dotenv
from langchain_community.utilities import SQLDatabase
from langchain_community.agent_toolkits import SQLDatabaseToolkit
from langchain_groq import ChatGroq
from langgraph.checkpoint.memory import InMemorySaver
from langchain.agents import create_agent
import streamlit as st

#loading the env variables
load_dotenv()

#creating database if not exists
db=SQLDatabase.from_uri("sqlite:///mytasks.db")
print(db)
print("Database created successfully ✅")

#creating table inside the database
db.run("""
CREATE TABLE IF NOT EXISTS tasks(
       id INTEGER PRIMARY KEY AUTOINCREMENT,
       title TEXT NOT NULL,
       description TEXT,
       status TEXT CHECK(status IN ('pending','in_progress','completed')) DEFAULT 'pending',
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
       );
""")    
print("Table created successfully ✅")

#llm,tools,memory,system_prompt
llm=ChatGroq(model="meta-llama/llama-4-scout-17b-16e-instruct")
toolkit=SQLDatabaseToolkit(db=db,llm=llm)
tools=toolkit.get_tools()

system_prompt = """
You are a task management assistant that interacts with a SQL database containing a 'task' table

TASK RULES:
1. Limit SELECT queries to 10 results max with ORDER BY created_at DESC
2. After CREATE/UPDATE/DELETE, confirm with SELECT query
3. If the user requests a list of tasks, present the output in a structured table format to ensure a clean and organized display in the browser

CRUD OPERATIONS:
CREATE: INSERT INTO tasks(title, description, status)
READ: SELECT * FROM tasks WHERE ... LIMIT 10
UPDATE: UPDATE tasks SET status =? WHERE id =? OR title =?
DELETE: DELETE FROM tasks WHERE id =? OR title =?

Table schema: id, title, description, status(pending/progress/completed), created_at
"""

st.cache_resource
def get_agent():
    agent=create_agent(
        model=llm,
        tools=tools,
        system_prompt=system_prompt,
        checkpointer=InMemorySaver()
    )
    return agent

agent=get_agent()

st.subheader("AI powered todo")
if "messages" not in st.session_state:
    st.session_state.messages=[]

for message in st.session_state.messages:
    role=message["role"]
    content=message["content"]
    st.chat_message(role).markdown(content)


prompt=st.chat_input("Tell me what to do")
if prompt:
    st.chat_message("user").markdown(prompt)
    st.session_state.messages.append({"role":"user","content":prompt})
    with st.chat_message("ai"):
        with st.spinner("Processing....."):
            resp=agent.invoke(
                {"messages":[{"role":"user","content":prompt}]},
                {"configurable":{"thread_id":"1"}}
            )
            answer=resp["messages"][-1].content
            st.session_state.messages.append({"role":"ai","content":answer})
            st.markdown(answer)
    
    