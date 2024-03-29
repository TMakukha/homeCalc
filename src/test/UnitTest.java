package test;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.HouseCalculator;

public class UnitTest {

	@Test
    public void testCalculateTotalPrice() {
        double length = 10.0;
        double width = 8.0;
        int floorCount = 2;
        String roofMaterial = "односкатная";
        String wallMaterial = "сруб";
        String foundationType = "Свайный";

        double expectedTotalPrice = 216000 + 240000 + 160000;

        double actualTotalPrice = HouseCalculator.calculateTotalPrice(length, width, floorCount, roofMaterial, wallMaterial, foundationType);

        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01);
    }

}
