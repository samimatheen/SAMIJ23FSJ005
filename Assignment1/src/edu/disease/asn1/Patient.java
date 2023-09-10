package edu.disease.asn1;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Patient {
	private UUID patientId;
	private String firstName;
	private String LastName;
	private Exposure[] exposures ;
	private UUID[] diseaseIds;
	
	Patient(int maxDiseases, int maxExposures) throws unknownException{
		if(maxDiseases<=0 || maxExposures<=0) {
			throw new unknownException("maxDisease or maxExposure having no value");
		}
		this.diseaseIds=new UUID[maxDiseases];
		this.exposures=new Exposure[maxExposures];
	}
	
	public void addDiseaseId(UUID diseaseId){
		if(isDiseaseIdsFull()) {
			throw new IndexOutOfBoundsException("Disease Array Is Full...");
		}
		
		for(int i=0; i<this.diseaseIds.length;i++) {
			if(diseaseIds[i]==null) {
			diseaseIds[i]=diseaseId;
			return;
			}
		}
		throw new IllegalArgumentException("IndexOutOfBondsException");
	}
	
	public boolean isDiseaseIdsFull() {
		for(UUID diseaseId : diseaseIds) {
			if(diseaseId != null) {
				return true;
			}
		}
		return false;
	}
	
	public void addExposure(Exposure exposure) {
		if(isExposureArrayFull()) {
			throw new IndexOutOfBoundsException("Exposure Array Is Full...");
		}
		for(int i=0; i<exposures.length;i++) {
			if(exposures[i]==null) {
				exposures[i]=exposure;
				return;
			}
		}
		throw new IndexOutOfBoundsException("IndexOutOfBondsException");
	}
	public boolean isExposureArrayFull() {
		for(Exposure e : exposures) {
			if(e==null) {
				return false;
			}
		}
		return true;
	}
	
	// No parameter constructor
	Patient() {
		
	}
	
	// With two parameter constructor
	Patient(String firstName, String LastName){
		this.firstName=firstName;
		this.LastName=LastName;
	}
	
	//Getters and Setters
	public UUID getPatientId() {return patientId;}
	public void setPatientId(UUID patientId) {this.patientId = patientId;}
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public String getLastName() {return LastName;}
	public void setLastName(String lastName) {LastName = lastName;}
	public Exposure[] getExposures() {return exposures;}
	public void setExposures(Exposure[] exposures) {this.exposures = exposures;}
	public UUID[] getDiseaselds() {return diseaseIds;}
	public void setDiseaselds(UUID[] diseaselds) {this.diseaseIds = diseaseIds;}

//	hashCode
	@Override
	public int hashCode() {
		//This hashCode for no parameter constructor
		if(patientId!=null && firstName!=null && LastName!=null && exposures!=null && diseaseIds!=null) {
			return patientId.hashCode() + firstName.hashCode() + LastName.hashCode() + exposures.hashCode() + diseaseIds.hashCode();
		}
		// This hashCode for firstName and lastName comparator constructor
		else if(patientId==null && firstName!=null && LastName!=null && exposures==null && diseaseIds==null){
			return firstName.hashCode() + LastName.hashCode();
		}
		return 0;
	}

//	equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		//This equals for no parameter constructor
		if(patientId!=null && firstName!=null && LastName!=null && exposures!=null && diseaseIds!=null) {
			if(hashCode()==other.hashCode()) {
				return true;
		}
		}
		// This equals for firstName and lastName comparator constructor
		else if(patientId==null && firstName!=null && LastName!=null && exposures==null && diseaseIds==null) {
			if(firstName==other.firstName && LastName==other.LastName) {
				if(hashCode()==other.hashCode()) {
					return true;
				}
				
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", LastName=" + LastName
				+ ", exposures=" + Arrays.toString(exposures) + ", diseaseIds=" + Arrays.toString(diseaseIds) + "]";
	}

}
