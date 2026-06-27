import code
from fastapi import FastAPI,Path,HTTPException
from fastapi.middleware.cors import CORSMiddleware
import json
app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_methods=["*"],
    allow_headers=["*"],
)



def load_data():
    with open("patients.json","r") as f:
        patients = json.load(f)
    return patients

@app.get("/")
def hello():
    return {"message": "Hospital Management System API"}

@app.get("/about")
def about():
    return {"message": "This is the Hospital Management System API"}

@app.get("/patients")
def get_patients():
    return load_data()

@app.get("/patient/{patient_id}")
def get_patient(patient_id: int =Path(...,description="The ID of the patient to retrieve",example=3)):
    patients = load_data()
    for patient in patients.values():
        if patient["id"] == patient_id:
            return patient
    raise HTTPException(status_code=404,detail="Patient record not available")