package edu.disease.asn1;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.UUID;


public class PatientTest {
 

	@Test
	public void withNoParamenter() {
		Patient p1 = new Patient();
		Patient p2 = new Patient();
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		boolean result = p1.equals(p2);
		assertFalse(result);
	}
	@Test
	public void withTwoParameterSameName() {
		Patient p1 = new Patient("SAMIULLAH" , "MOHAMMED");
		Patient p2 = new Patient("SAMIULLAH" , "MOHAMMED");
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		boolean result = p1.equals(p2);
		assertTrue(result);
	}
	@Test
	public void withTwoParameterDifferentName() {
		Patient p1 = new Patient("SAMIULLAH" , "MOHAMMED");
		Patient p2 = new Patient("SAMIULLAH" , "MATHEEN");
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		boolean result = p1.equals(p2);
		assertFalse(result);
	}

	@Test
	public void testPatientConstructor() throws unknownException {
		int maxDiseases = 2;
		int maxExposures= 2;
		
		Patient patientObj = new Patient(maxDiseases,maxExposures);
		
		assertEquals(maxDiseases,patientObj.getDiseaselds().length);
		assertEquals(maxExposures, patientObj.getExposures().length);
	}
	
	@Test
	public void testNames() {
		Patient patientObj = new Patient();
		patientObj.setFirstName("MOHAMMED");
		
		assertEquals("MOHAMMED",patientObj.getFirstName());
	}
//	@Test
//	public void testToString() throws unknownException {
//		Patient patientObj = new Patient(2,2);
//		patientObj.setPatientId(UUID.randomUUID());
//		patientObj.setFirstName("MOHAMMED");
//		patientObj.setLastName("SAMIULLAH");
//		
//		String expected = "Patient [patientId= "+ patientObj.getPatientId()
//		+", firstName = MOHAMMED, LastName = SAMIULLAH, exposures = [null,null], diseaseIds = [null,null]]";
//			
//		assertEquals(expected, patientObj.toString());
//	}
	
	@Test
	public void testAddDiseaseId() throws unknownException {
		int maxDiseases = 2;
		int maxExposures = 2;
		
		Patient patientObj = new Patient(maxDiseases,maxExposures);
		
		UUID diseaseId1 = UUID.randomUUID();
		UUID diseaseId2 = UUID.randomUUID();
				
		patientObj.addDiseaseId(diseaseId1);
		patientObj.addDiseaseId(diseaseId2);
				
		UUID[] diseaseIds = patientObj.getDiseaselds();
		
		assertEquals(diseaseId1,diseaseIds[0]);
		assertEquals(diseaseId2,diseaseIds[1]);
	}
	
//	@Test(expected =IndexOutOfBoundsException.class)
//	public void testOutOfBoundAddDiseaseId() throws unknownException {
//		int maxDiseases = 2;
//		int maxExposures = 2;
//		
//		Patient patientObj = new Patient(maxDiseases,maxExposures);
//		
//		UUID diseaseId1 = UUID.randomUUID();
//		UUID diseaseId2 = UUID.randomUUID();
//		UUID diseaseId3 = UUID.randomUUID();
//		
//		patientObj.addDiseaseId(diseaseId1);
//		patientObj.addDiseaseId(diseaseId2);
//		patientObj.addDiseaseId(diseaseId3);
//		
//		UUID[] diseaseIds = patientObj.getDiseaselds();
//		
//		assertEquals(diseaseId1,diseaseIds[0]);
//		assertEquals(diseaseId2,diseaseIds[1]);
//		assertEquals(diseaseId3,diseaseIds[2]);
//	}
	
	@Test
	public void testAddExposureId() throws unknownException {
		int maxDiseases=2;
		int maxExposures=2;
		
		Patient patientObj = new Patient(maxDiseases,maxExposures);
		
		String e1 = "D";
		String e2 = "I";
		
		Exposure exposure1 = new Exposure(e1);
		Exposure exposure2 = new Exposure(e2);
		
		patientObj.addExposure(exposure1);
		patientObj.addExposure(exposure2);
		
		Exposure[] exposures = patientObj.getExposures();
		
		assertEquals(exposure1,exposures[0]);
		assertEquals(exposure2,exposures[1]);
	}
}
