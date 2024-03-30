package test;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import application.LabaRandomNumber;

public class LabaRandomNumberTest {

    @Test
    public void testGenerateRandomNumber() {
        int randomNumber = LabaRandomNumber.generateRandomNumber();
        assertTrue("Случайное число должно быть больше или равно 40", randomNumber >= 40);
        assertTrue("Случайное число должно быть меньше или равно 80", randomNumber <= 80);
    }
}