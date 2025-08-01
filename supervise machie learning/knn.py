import streamlit as st
import pandas as pd
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split

# Load and prepare your data
df = pd.read_csv("C:\\Users\\pagil\\OneDrive\\Documents\\Programming\\Datasets\\Multiclass Diabetes Dataset.csv")
x = df.drop("Class", axis=1)
y = df["Class"]
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.2)

# Fit your model
knn = KNeighborsClassifier(n_neighbors=10)
knn.fit(x_train, y_train)

# Streamlit UI
st.title("Diabetes Prediction with KNN")
st.write("Enter the following parameters:")

# Input fields for each feature
gender = st.number_input("Gender (0=Male, 1=Female)", min_value=0, max_value=1)
age = st.number_input("Age", min_value=0)
urea = st.number_input("Urea")
cr = st.number_input("Cr")
hba1c = st.number_input("HbA1c")
chol = st.number_input("Chol")
tg = st.number_input("TG")
hdl = st.number_input("HDL")
ldl = st.number_input("LDL")
vldl = st.number_input("VLDL")
bmi = st.number_input("BMI")

# Submit button
if st.button("Predict"):
    input_features = [[gender, age, urea, cr, hba1c, chol, tg, hdl, ldl, vldl, bmi]]
    prediction = knn.predict(input_features)[0]
    st.write(f"Predicted Class: {prediction}")
