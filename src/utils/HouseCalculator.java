package utils;

public class HouseCalculator {

    public static double calculateTotalPrice(double length, double width, int floorCount, String roofMaterial, String wallMaterial, String foundationType) {
        // Вычисление площади дома
        double area = length * width;

        // Вычисление периметра стен
        double wallPerimeter = (length + width) * 2 * floorCount;

        // Вычисление стоимости фундамента
        double foundationPrice = foundationType.equals("Свайный") ? 2000 * area : 1600 * area;

        // Вычисление стоимости стен
        double wallPrice = calculateWallPrice(wallMaterial, wallPerimeter);

        // Вычисление стоимости крыши
        double roofPrice = calculateRoofPrice(roofMaterial, area);

        // Вычисление общей стоимости
        return roofPrice + wallPrice + foundationPrice;
    }

    private static double calculateWallPrice(String wallMaterial, double wallPerimeter) {
        switch (wallMaterial) {
            case "сруб":
                return wallPerimeter * 3000;
            case "газоблок":
                return wallPerimeter * 700;
            case "кирпич":
                return wallPerimeter * 5000;
            default:
                return 0;
        }
    }

    private static double calculateRoofPrice(String roofMaterial, double area) {
        switch (roofMaterial) {
            case "односкатная":
                return area * 3000;
            case "двускатная":
                return area * 5000;
            case "прямая":
                return area * 7000;
            default:
                return 0;
        }
    }
}
