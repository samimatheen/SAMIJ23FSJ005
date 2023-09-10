package edu.disease.asn1;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.junit.jupiter.api.Test;

import edu.disease.asn1.*;

public class ExposureTest {


	@Test
	public void testExposureConstructorAndGetters() {
		
		UUID patientId = UUID.randomUUID();
		Exposure exposureObj = new Exposure(patientId);
		
		assertEquals(patientId, exposureObj.getPatientId());
	}
	
	@Test
	public void testExposureTypeValid() {
		
		String exposureType = Exposure.DirectExposure;
		Exposure exposureObj = new Exposure(exposureType);
		
		assertEquals(exposureType,exposureObj.getExposureType());
	}
	
	@Test
	public void testDateAndTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		Exposure exposureObj = new Exposure(dateTime);
	}
	
	@Test
	public void testEmptyConstructor() throws unknownException {
		UUID patientId = UUID.randomUUID();
		String exposureType = Exposure.DirectExposure;
		LocalDateTime dateTime = LocalDateTime.now();
		
		Exposure exposureObj = new Exposure();
		exposureObj.setPatientId(patientId);
		exposureObj.setDateTime(dateTime);
		exposureObj.setExposureType(exposureType);
		
		
		assertEquals(patientId,exposureObj.getPatientId());
		assertEquals(dateTime,exposureObj.getDateTime());
		assertEquals(exposureType, exposureObj.getExposureType());
	}
	
	@Test
	public void testHashAndEqualsMethod1() {
		UUID patientId1 = UUID.randomUUID();
		String exposureType1 = Exposure.DirectExposure;
		LocalDateTime dateTime1 = LocalDateTime.now();
		Exposure e1 = new Exposure(patientId1,exposureType1,dateTime1);
		
		UUID patientId2 = patientId1;
		String exposureType2 = Exposure.DirectExposure;
		LocalDateTime dateTime2 = LocalDateTime.now();
		Exposure e2 = new Exposure(patientId2,exposureType2,dateTime2);
		
		boolean result = e1.equals(e2);
		assertTrue(result);
		assertEquals(e1.hashCode(),e2.hashCode());
	}
	
	@Test
	public void testHashAndEqualsMethod2() {
		UUID patientId1 = UUID.randomUUID();
		String exposureType1 = Exposure.DirectExposure;
		LocalDateTime dateTime1 = LocalDateTime.now();
		Exposure e1 = new Exposure(patientId1,exposureType1,dateTime1);
		
		UUID patientId2 = UUID.randomUUID();
		String exposureType2 = Exposure.DirectExposure;
		LocalDateTime dateTime2 = LocalDateTime.now();
		Exposure e2 = new Exposure(patientId2,exposureType2,dateTime2);
		
		
		assertFalse(e1.equals(e2));
		assertNotEquals(e1.hashCode(),e2.hashCode());
	}
	
	@Test
	public void testToString() {
		UUID patientId = UUID.randomUUID();
		String exposureType = Exposure.DirectExposure;
		LocalDateTime dateTime = LocalDateTime.now();
		
		Exposure e = new Exposure(patientId,exposureType,dateTime);
		String expected = "Exposure [patientId=" + patientId + ", dateTime=" + dateTime + ", exposureType=" + exposureType + "]";
		
		assertEquals(expected,e.toString());
	}
}
