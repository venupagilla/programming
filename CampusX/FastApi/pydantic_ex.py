import string
from pydantic import BaseModel,EmailStr,Field,field_validator
from typing import List,Dict,Optional,Annotated

class Patient(BaseModel):
    name:Annotated[str,Field(max_length=5,title="name of the patient",description="Enter the name of the patient in this field")]
    age:int=Field(gt=0,lt=130)
    email:EmailStr="123@default.com"
    allergies:Optional[List[str]]=None
    contact_details:Dict[str,str]

    @field_validator("name")
    @classmethod
    def name_conv(cls,val):
        return val.upper()
        

def insert_patient(patient:Patient):
    name=patient.name
    age=patient.age
    email=patient.email
    allergies=patient.allergies
    contact_details=patient.contact_details
    print(f"Patient name is {name} and his/her age is {age} email : {email} allergies {allergies} contact details {contact_details}")

cur_patient_info={"name":"singam","age":35,"contact_details":{"email":"vnrvjiet@gmail.com","ph":"1234567890"}}
patient_obj=Patient(**cur_patient_info)
insert_patient(patient_obj)
