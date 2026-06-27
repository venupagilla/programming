from typing import Annotated,List
from pydantic import BaseModel, Field
import json
from fastapi import FastAPI
from fastapi.responses import JSONResponse

app = FastAPI()

class Patient(BaseModel):
    id: Annotated[int, Field(...,title="Patient ID", description="ID of the patient")]
    name: Annotated[str, Field(...,title="Name", description="Patient name")]
    age: Annotated[int, Field(title="Age", description="Patient age")]
    gender: Annotated[List["male","female","others"], Field(title="Gender", description="Patient gender")]
    diagnosis: Annotated[str, Field(title="Diagnosis", description="Medical diagnosis")]
    admitted: Annotated[bool, Field(title="Admitted", description="Admission status")]
    height: Annotated[float, Field(title="Height", description="Height in centimeters")]
    weight: Annotated[float, Field(title="Weight", description="Weight in kilograms")]

    def get_bmi(self) -> float:
        """Calculate BMI using the formula: weight (kg) / (height (m))²"""
        height_in_meters = self.height / 100
        bmi = self.weight / (height_in_meters ** 2)
        return round(bmi, 1)


@app.post("/add_content")
def add_patient(patient: Patient):
    return {"message": "Patient added successfully", "patient": patient.model_dump()}

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)


