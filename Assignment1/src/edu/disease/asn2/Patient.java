package edu.disease.asn2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import edu.disease.asn1.Exposure;

public class Patient {
	private UUID patientId;
	private String firstName;
	private String LastName;
	private Exposure[] exposures;
	private UUID[] diseaselds;
	
	Patient(int maxDiseases, int maxExposures){
		this.diseaselds=new UUID[maxDiseases];
		this.exposures=new Exposure[maxExposures];
	}
	
	// No parameter constructor
	Patient() {
		
	}
	
	// With two parameter constructor
	Patient(String firstName, String LastName){
		this.firstName=firstName;
		this.LastName=LastName;
	}
	


	public void addDiseaseId(UUID diseaselds){
		for(int i=0; i<this.diseaselds.length;i++) {
			if(this.diseaselds[i]==null) {
			this.diseaselds[i]=diseaselds;
		}
		}
		throw new IllegalArgumentException("IndexOutOfBondsException");
	}
	
	public void addExposure(Exposure exposure) {
		for(int i=0; i<exposures.length;i++) {
			if(exposures[i]==null) {
				exposures[i]=exposure;
				return;
			}
		}
		throw new IndexOutOfBoundsException("IndexOutOfBondsException");
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
	public UUID[] getDiseaselds() {return diseaselds;}
	public void setDiseaselds(UUID[] diseaselds) {this.diseaselds = diseaselds;}

//	hashCode
	@Override
	public int hashCode() {
		//This hashCode for no parameter constructor
		if(patientId!=null && firstName!=null && LastName!=null && exposures!=null && diseaselds!=null) {
			return patientId.hashCode() + firstName.hashCode() + LastName.hashCode() + exposures.hashCode() + diseaselds.hashCode();
		}
		// This hashCode for firstName and lastName comparator constructor
		else if(patientId==null && firstName!=null && LastName!=null && exposures==null && diseaselds==null){
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
		if(patientId!=null && firstName!=null && LastName!=null && exposures!=null && diseaselds!=null) {
			if(hashCode()==other.hashCode()) {
				return true;
		}
		}
		// This equals for firstName and lastName comparator constructor
		else if(patientId==null && firstName!=null && LastName!=null && exposures==null && diseaselds==null) {
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
				+ ", exposures=" + Arrays.toString(exposures) + ", diseaselds=" + Arrays.toString(diseaselds)
				+ ", getPatientId()=" + getPatientId() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getExposures()=" + Arrays.toString(getExposures()) + ", getDiseaselds()="
				+ Arrays.toString(getDiseaselds()) + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}	
}
