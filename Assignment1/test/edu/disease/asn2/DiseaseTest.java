package edu.disease.asn2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiseaseTest {
	
	private Disease disease;
	
	@BeforeEach
	void setUp() {
		disease = new Disease() {
			
			@Override
			String[] getExample() {
				
				return new String[0];
			}
		};
	}
	
	@Test
	public void testSetAndGetDiseaseId() {
		UUID uuid = UUID.randomUUID();
		disease.setDiseaseId(uuid);
		assertEquals(uuid, disease.getDiseaseId());
	}
	
	@Test
	public void testSetAndGet() {
		String name = "SAMI";
		disease.setName(name);
		assertEquals(name, disease.getName());
	}
	
//	@Test
//	public void testEqualsAndHashCode() {
//		UUID uuid1 = UUID.randomUUID();
//		UUID uuid2 = UUID.randomUUID();
//		disease.setDiseaseId(uuid1);
//		
//		Disease sameIdDisease = new Disease() {
//
//			@Override
//			String[] getExample() {
//				return new String[0];
//			}
//		};
//		sameIdDisease.setDiseaseId(uuid1);
//		
//		Disease differentIdDisease = new Disease() {
//			
//			@Override
//			String[] getExample() {
//				return new String[0];
//			}
//		};
//		differentIdDisease.setDiseaseId(uuid2);
//		
//		assertEquals(disease.hashCode(), sameIdDisease.hashCode());
//		assertEquals(disease, sameIdDisease);
//		assertNotEquals(disease, differentIdDisease);
//	}
}
