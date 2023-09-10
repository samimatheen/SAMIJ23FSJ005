package edu.disease.asn2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class NonInfectiousDiseaseTest {
	
	@Test
	public void testGetExample() {
		NonInfectiousDisease nfd = new NonInfectiousDisease();
		String[] expectedExamples= {"Asthma",
				"Skin Infection",
				"Wheezing",
				"Cancer"};
		assertArrayEquals(expectedExamples,nfd.getExample());
	}
}
