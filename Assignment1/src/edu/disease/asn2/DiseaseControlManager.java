package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure;

public interface DiseaseControlManager {

	/*
	 * @param name,isInfection
	 * It will return new Disease to the application
	 */
	public Disease addDisease(String name, Boolean isInfection);
	/*
	 * @param diseaseId
	 * @return Returns the disease or null if not found
	 */
	public Disease getDisease(UUID diseaseId);
	/*
	 * @param firstName,lastName,maxDiseases,maxExposures
	 * Add new patient to the application
	 */
	public Patient addPatient(String firstName, String LastName, int maxDiseases, int maxExposures);
	/*
	 * 
	 */
	public void addDiseaseToPatient(UUID patientId, UUID diseaseId);
	/*
	 * 
	 */
	public void addExposureToPatient(UUID patientId, Exposure exposure);
	public Patient getPatient(UUID patientId);
	

}

