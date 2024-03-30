package application;

import java.util.Random;

public class LabaRandomNumber {
    
    public static int generateRandomNumber() {
        Random random = new Random();
        int high = 80;
        int low = 40;
        return random.nextInt(high - low) + low;
    }

    public static void main(String[] args) {
        int randomNumber = generateRandomNumber();
        System.out.println("Случайное число в диапазоне от 40 до 80: " + randomNumber);
    }
}