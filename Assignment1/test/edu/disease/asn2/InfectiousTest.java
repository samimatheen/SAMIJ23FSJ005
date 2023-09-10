package edu.disease.asn2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class InfectiousTest {

	@Test
	public void testInfectious() {
		
		InfectiousDisease id = new InfectiousDisease();
		
		String[] examples = {"COVID-19",
				"Dengue",
				"Malaria",
				"Influenza"};
		
		assertArrayEquals(examples, id.getExample());
		
}
}