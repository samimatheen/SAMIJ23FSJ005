package edu.disease.asn1;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import edu.disease.asn1.*;


public class Exposure{

	private UUID patientId;
	 private LocalDateTime dateTime;
	 private String exposureType;
	 
	public Exposure(UUID patientId){
		 this.patientId=patientId;
	 }

	public Exposure(String exposureType) {
		this.exposureType=exposureType;
	}
	
	public Exposure(LocalDateTime dateTime) {
		this.dateTime=dateTime;
	}
	
	public Exposure() {
		
	}
	public Exposure(UUID patientId, String exposureType, LocalDateTime dateTime) {
		this.patientId=patientId;
		this.exposureType=exposureType;
		this.dateTime=dateTime;
	}

	public UUID getPatientId() {
		return patientId;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getExposureType() {
		return exposureType;
	}
	public static final String DirectExposure = "D";
	public static final String InDirectExposure = "I";
	
	public void setExposureType(String exposureType) throws unknownException {
		if(exposureType.equals(DirectExposure) || exposureType.equals(InDirectExposure)) {
			this.exposureType = exposureType;
		}else {
			throw new unknownException("Illegal Argument Exception...");
		}

		
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateTime, exposureType, patientId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exposure other = (Exposure) obj;
		if(patientId.hashCode()==other.patientId.hashCode() 
				&& exposureType.hashCode()==other.exposureType.hashCode() 
				&& dateTime.hashCode()==other.dateTime.hashCode()) {
			
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Exposure [patientId=" + patientId + ", dateTime=" + dateTime + ", exposureType=" + exposureType + "]";
	}
		
}
