public class PabrikCetakanDonut {
    public static void main(String[] args) {
        // Menampilkan header program
        System.out.println("=============================================");
        System.out.println("Kalkulator Pabrik Cetakan Donat Rumahan");
        System.out.println("FIRDAUS DEWANSYAH"); 
        System.out.println("245150707111005");         
        System.out.println("=============================================");
        System.out.println("Donat dengan lubang");
        System.out.println("=============================================");

        double majorRadius = 7;
        double minorRadius = 3.5;
        
        System.out.println("Isikan Radius   : " + formatNumber(majorRadius));
        System.out.println("Isikan radius   : " + formatNumber(minorRadius));
        System.out.println("=============================================");
        Torus torus = new Torus(majorRadius, minorRadius);
        torus.printInfo();
        System.out.println("=============================================");
        System.out.println("Donat tanpa lubang");
        System.out.println("=============================================");
        
        double radius = 21;
        
        System.out.println("Isikan radius   : " + formatNumber(radius));
        System.out.println("=============================================");
        
        // Membuat objek Sphere dan menampilkan hasil perhitungan
        Sphere sphere = new Sphere(radius);
        sphere.printInfo();     
        System.out.println("=============================================");
    }
    
    // Metode untuk memformat angka: tanpa desimal jika bilangan bulat
    private static String formatNumber(double value) {
        if (value == (int) value) {
            return String.valueOf((int) value);
        } else {
            return String.valueOf(value);
        }
    }
}

interface ThreeDimensional {
    double getVolume();
    double getSurfaceArea();
}

interface ShippingCostCalculator {
    int PRICE_PER_KG = 2000;
    double calculateCost();
}

interface MassConverter {
    int DENOMINATOR = 1000;
    double gramToKilogram();
}

interface PIRequired {
    double PI = 22.0 / 7.0;
}

interface MassCalculable {
    int DENSITY = 8;        
    double THICKNESS = 0.5;  
    double getMass();
}

abstract class Shape {
    private String name;
    
    public Shape(String name) {
        this.name = name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract void printInfo();
}

class Torus extends Shape implements ThreeDimensional, MassCalculable, MassConverter, ShippingCostCalculator, PIRequired {
    private double majorRadius;
    private double minorRadius;

    public Torus(double majorRadius, double minorRadius) {
        super("Torus");
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    @Override
    public double getVolume() {
        return 2 * Math.pow(PI, 2) * majorRadius * Math.pow(minorRadius, 2);
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.pow(PI, 2) * majorRadius * minorRadius;
    }

    @Override
    public double getMass() {
        return DENSITY * getSurfaceArea() * THICKNESS;
    }

    @Override
    public double gramToKilogram() {
        return getMass() / DENOMINATOR;
    }

    @Override
    public double calculateCost() {
        return Math.ceil(gramToKilogram()) * PRICE_PER_KG;
    }

    @Override
    public void printInfo() {
        System.out.printf("Volume          : %.2f%n", getVolume());
        System.out.printf("Luas permukaan  : %.2f%n", getSurfaceArea());
        System.out.printf("Massa           : %.2f gram%n", getMass());
        System.out.printf("Massa dalam kg  : %.2f kg%n", gramToKilogram());
        System.out.printf("Biaya kirim     : Rp%,d%n", (int) calculateCost());
    }
}

class Sphere extends Shape implements ThreeDimensional, MassCalculable, MassConverter, ShippingCostCalculator, PIRequired {
    private double radius;

    public Sphere(double radius) {
        super("Sphere");
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * PI * Math.pow(radius, 3);
    }

    @Override
    public double getSurfaceArea() {
        return 4 * PI * Math.pow(radius, 2);
    }

    @Override
    public double getMass() {
        return DENSITY * getSurfaceArea() * THICKNESS;
    }

    @Override
    public double gramToKilogram() {
        return getMass() / DENOMINATOR;
    }

    @Override
    public double calculateCost() {
        return Math.ceil(gramToKilogram()) * PRICE_PER_KG;
    }

    @Override
    public void printInfo() {
        System.out.printf("Volume          : %.2f%n", getVolume());
        System.out.printf("Luas permukaan  : %.2f%n", getSurfaceArea());
        System.out.printf("Massa           : %.2f gram%n", getMass());
        System.out.printf("Massa dalam kg  : %.2f kg%n", gramToKilogram());
        System.out.printf("Biaya kirim     : Rp%,d%n", (int) calculateCost());
    }
}