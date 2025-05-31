package UAP.uapmains;

import UAP.uapmodels.Torus;
import UAP.uapmodels.Sphere;

public class KalkulatorPabrik {
    public static void main(String[] args) {
        // Menampilkan header program
        System.out.println("=============================================");
        System.out.println("Kalkulator Pabrik Cetakan Donat Rumahan");
        System.out.println("FIRDAUS DEWANSYAH"); 
        System.out.println("245150707111005");          
        System.out.println("=============================================");
        
        // Donat dengan lubang (Bentuk Torus)
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
        
        // Donat tanpa lubang (Bentuk Bola)
        System.out.println("Donat tanpa lubang");
        System.out.println("=============================================");
        
        double radius = 21;
        
        System.out.println("Isikan radius   : " + formatNumber(radius));
        System.out.println("=============================================");
        
        Sphere sphere = new Sphere(radius);
        sphere.printInfo();
        
        System.out.println("=============================================");
    }
    
    private static String formatNumber(double value) {
        if (value == (int) value) {
            return String.valueOf((int) value);
        } else {
            return String.valueOf(value);
        }
    }
}