package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure;

public class DiseaseControlManagerImpl implements DiseaseControlManager{

	private Disease[] diseases;
	private Patient[] patients;
	
	public DiseaseControlManagerImpl(int maxDiseases,int maxPatients) {
		if(maxDiseases<=0 || maxPatients<=0) {
			throw new IllegalArgumentException("Supplied integer shoud be grater then 0 ");
		}
		this.diseases=new Disease[maxDiseases];
		this.patients=new Patient[maxPatients];
	}
	@Override
	public Disease addDisease(String name, Boolean isInfection) {
		if(isDiseaseArrayFull()) {
			throw new IllegalAccessError("Disease Array Is Full....");
		}
		Disease newDisease;		
		
		if(isInfection){
			newDisease = new InfectiousDisease();
		}else {
			newDisease = new NonInfectiousDisease();
		}
		newDisease.setName(name);
		newDisease.setDiseaseId(UUID.randomUUID());
		
		for(int i=0; i<diseases.length; i++) {
			if(diseases[i]==null) {
				diseases[i]=newDisease;
				break;
			}
		}
		return newDisease;
	}
	
	public boolean isDiseaseArrayFull() {
		for(Disease d : diseases) {
			if(d==null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Disease getDisease(UUID diseaseId) {
		for(Disease d : diseases) {
			if(d.getDiseaseId().equals(diseaseId));
				return d;
		}
		return null;
	}

	@Override
	public Patient addPatient(String firstName, String LastName,int maxDiseases, int maxExposures) {

		if(isPatientArrayFull()) {
			throw new IllegalStateException("Patient Array Is Full...");
		}
		
		Patient patient = new Patient(maxDiseases,maxExposures);
		patient.setFirstName(firstName);
		patient.setLastName(LastName);
		patient.setPatientId(UUID.randomUUID());
	
		for(int i=0; i<patients.length;i++) {
			if(patients[i]==null) {
				patients[i]=patient;
				break;
			}
		}
	return patient;
	}

	public boolean isPatientArrayFull() {
		for(Patient p: patients) {
			if(p==null) {
				return false;
			}
		}
		return true;
	}

	public Patient getPatients(UUID patientId) {
		for(Patient p : patients) {
			if(p.getPatientId().equals(patientId)) {
				return p;
			}
		}
		return null;
	}
	
	@Override
	public void addDiseaseToPatient(UUID patientId, UUID diseaseId) {
		for(Patient p : patients) {
			if(p.getPatientId().equals(patientId)) {
				for(Disease d : diseases) {
					if(d.getDiseaseId().equals(diseaseId)) {
						p.addDiseaseId(d.getDiseaseId());
						return;
					}else {
						throw new IllegalArgumentException("DiseaseId is not accociated");
					}
				}
				}
			else {
				throw new IllegalArgumentException("PatientId Is Not Associated..");
			}
		}
		
	}

	
	public void addExposureToPatient(UUID patientId, Exposure exposure) {
		for(Patient p : patients) {
			if(p.getPatientId().equals(patientId)) {
				p.addExposure(exposure);
				return;
			}else {
				throw new IllegalArgumentException("PatientId Is Not Associated...");
			}
		}
	}
	@Override
	public Patient getPatient(UUID patientId) {
		// TODO Auto-generated method stub
		return null;
	}

}