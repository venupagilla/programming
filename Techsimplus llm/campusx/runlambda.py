from langchain_core.runnables import RunnableLambda

def add(values):
    return values["a"]+values["b"]

run_add=RunnableLambda(add)
resp=run_add.invoke({"a":10,"b":20})
print(resp)

'''
or
def add(values):
    return values[0]+values[1]

run_add=RunnableLambda(add)
resp=run_add.invoke((10,20))
print(resp)
'''