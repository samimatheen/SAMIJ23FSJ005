package edu.disease.asn2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class DiseaseControlManagementImplTest {

	private DiseaseControlManager dcm;
	
	@Test
	public void testValidIntialization() {
		dcm = new DiseaseControlManagerImpl(10,10);
		assertNotNull(dcm);
	}
	
	@Test
	public void testZeroMaxDiseaseAndPatients() {
		assertThrows(IllegalArgumentException.class, () -> {
			dcm = new DiseaseControlManagerImpl(0,0);
		});
	}
	
	@Test
	public void testNegativeMaxDiseaseAndPatients() {
		assertThrows(IllegalArgumentException.class, () -> {
			dcm = new DiseaseControlManagerImpl(-10,-5);
		});
	}
	
	@Test
	public void testZeroMaxDisease() {
		assertThrows(IllegalArgumentException.class, () -> {
			dcm = new DiseaseControlManagerImpl(0,6);
		});
	}
	
	@Test
	public void testZeroMaxPatients() {
		assertThrows(IllegalArgumentException.class, () -> {
			dcm = new DiseaseControlManagerImpl(7,0);
		});
	}
	
	@Test
	public void testAddInfectionDisease() {
		dcm = new DiseaseControlManagerImpl(3, 3);
		Disease disease = dcm.addDisease("COVID-19", true);
		assertTrue(disease instanceof InfectiousDisease);
		assertEquals("COVID-19",disease.getName());
		//assertNotNull(disease.getDiseaseId());
	}
	
	@Test
	public void testAddNonInfectionDisease() {
		dcm = new DiseaseControlManagerImpl(3, 3);
		Disease disease = dcm.addDisease("Asthma", false);
		assertTrue(disease instanceof NonInfectiousDisease);
		assertEquals("Asthma",disease.getName());
		//assertNotNull(disease.getDiseaseId());
	}
	
	@Test
	public void testAddPatient() {
		dcm = new DiseaseControlManagerImpl(2, 2);
		
		String firstName = "Mohammed";
		String LastName = "Samiullah";
		int maxDiseases = 5;
		int maxExposures = 5;
		
		Patient p1 = dcm.addPatient(firstName, LastName, maxDiseases, maxExposures);
		
		//assertNotNull(p1);
		assertEquals(firstName,p1.getFirstName());
		assertEquals(LastName,p1.getLastName());
	}
	
	@Test
	public void testAddDiseaseToPatient() {
		dcm = new DiseaseControlManagerImpl(2, 2);
		Disease disease = dcm.addDisease("COVID-19", true); 
		Patient patient = dcm.addPatient("Mohammed", "Samiullah", 2,2);
		
		UUID retriveDiseaseId = disease.getDiseaseId();
		UUID retrivePatientId = patient.getPatientId();
		
		dcm.addDiseaseToPatient(retrivePatientId, retriveDiseaseId);
		
		Patient retrivePatient = dcm.getPatient(retrivePatientId);
		assertNotNull(retrivePatient);
		
		assertEquals(retrivePatientId,retrivePatient.getPatientId());
		
		Disease retriveDisease = dcm.getDisease(retriveDiseaseId);
		assertNotNull(retriveDisease);
		
		assertTrue(arrayContainsDiseaseId(retrivePatient.getDiseaselds(),retriveDisease));
	}
	private boolean arrayContainsDiseaseId(UUID[] array, Disease uuid) {
		for(UUID id : array) {
			System.out.println("Id " + id);
			System.out.println("Disease " + uuid);
			
			if(id!=null) {
				if(id.equals(uuid)) {
					return true;
				}
			}
		}
		return false;
	}
}
