from typing import Dict
import pandas as pd
from sklearn.datasets import load_iris
from sklearn import svm
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel

#model training
model = svm.SVC()
iris = load_iris(as_frame=True)
X = iris.data
y = iris.target
feature_names = iris.feature_names
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
model.fit(X_train, y_train)
y_pred = model.predict(X_test)
print(accuracy_score(y_test, y_pred))
print("Feature names:", X.columns.tolist())
print(X_test.head())

#pydantic models
class IrisData(BaseModel):
    sepal_length: float
    sepal_width: float
    petal_length: float
    petal_width: float

#app
app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.post("/iristest")
def iris_test(data:IrisData)->Dict[str, float]:
    val = [[data.sepal_length, data.sepal_width, data.petal_length, data.petal_width]]
    return {"prediction": model.predict(val)[0]}
