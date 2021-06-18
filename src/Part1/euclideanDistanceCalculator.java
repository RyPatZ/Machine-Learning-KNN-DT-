package Part1;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Euclidean distance calculator.
 */
public class euclideanDistanceCalculator {
    /**
     * The Distance.
     */
    double distance;

    /**
     * Instantiates a new Euclidean distance calculator.
     *
     * @param start  the start
     * @param end    the end
     * @param ranges the ranges
     */
    public euclideanDistanceCalculator(Wine start, Wine end,List<Double> ranges){
        double Alcohol = end.getAlcohol()-start.getAlcohol();
        double Malic_acid= end.getMalic_acid()-start.getMalic_acid();
        double Ash = end.getAsh()-start.getAsh();
        double Alcalinity_ash=end.getAlcalinity_ash()-start.getAlcalinity_ash();
        double Magnesium= end.getMagnesium()-start.getMagnesium();
        double Total_Phenols=end.getTotal_Phenols()-start.getTotal_Phenols();
        double Flavanoids=end.getFlavanoids()-start.getFlavanoids();
        double Nonflavanoid_phenols=end.getNonflavanoid_phenols()-start.getNonflavanoid_phenols();
        double  Proanthocyanins = end.getProanthocyanins() - start.getProanthocyanins();
        double Color=end.getColor()-start.getColor();
        double Intensity=end.getIntensity()-start.getIntensity();
        double Hue= end.getHue()-start.getHue();
        double OD_diluted_wines= end.getOD_diluted_wines()-start.getOD_diluted_wines();

        this.distance = Math.sqrt((Math.pow(Alcohol, 2.0)/(Math.pow(ranges.get(0),2.0)))+(Math.pow(Malic_acid, 2.0)/(Math.pow(ranges.get(1),2.0)))+(Math.pow(Ash, 2.0)/(Math.pow(ranges.get(2),2.0)))+(Math.pow(Alcalinity_ash, 2.0)/(Math.pow(ranges.get(3),2.0)))+(Math.pow(Magnesium, 2.0)/(Math.pow(ranges.get(4),2.0)))+(Math.pow(Total_Phenols, 2.0)/(Math.pow(ranges.get(5),2.0)))+(Math.pow(Flavanoids, 2.0)/(Math.pow(ranges.get(6),2.0)))+(Math.pow(Nonflavanoid_phenols, 2.0)/(Math.pow(ranges.get(7),2.0)))+(Math.pow(Proanthocyanins, 2.0)/(Math.pow(ranges.get(8),2.0)))+(Math.pow(Color, 2.0)/(Math.pow(ranges.get(9),2.0)))+(Math.pow(Intensity, 2.0)/(Math.pow(ranges.get(10),2.0)))+(Math.pow(Hue, 2.0)/(Math.pow(ranges.get(11),2.0)))+(Math.pow(OD_diluted_wines, 2.0)/(Math.pow(ranges.get(12),2.0))));
    }

    /**
     * Gets distance.
     *
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

}
