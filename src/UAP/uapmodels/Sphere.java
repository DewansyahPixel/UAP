package UAP.uapmodels;

import UAP.uapbases.Shape;
import UAP.uapinterfaces.ThreeDimensional;
import UAP.uapinterfaces.MassCalculable;
import UAP.uapinterfaces.MassConverter;
import UAP.uapinterfaces.ShippingCostCalculator;
import UAP.uapinterfaces.PIRequired;

public class Sphere extends Shape implements ThreeDimensional, MassCalculable, MassConverter, ShippingCostCalculator, PIRequired {
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