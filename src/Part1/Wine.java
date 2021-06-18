package Part1;


import java.util.ArrayList;
import java.util.List;

/**
 * The type Wine.
 */
public class Wine {
    /**
     * The Alcohol.
     */
// field wine
    //Alcohol, Malic acid, Ash, Alcalinity of ash, Magnesium, Total phenols, Flavanoids, Nonflavanoid phenols, Proanthocyanins, Color intensity, Hue, OD280/OD315 of diluted wines, and
    //Proline
    double Alcohol;
    /**
     * The Malic acid.
     */
    double Malic_acid;
    /**
     * The Ash.
     */
    double Ash;
    /**
     * The Alcalinity ash.
     */
    double Alcalinity_ash;
    /**
     * The Magnesium.
     */
    double Magnesium;
    /**
     * The Total phenols.
     */
    double Total_Phenols;
    /**
     * The Flavanoids.
     */
    double Flavanoids;
    /**
     * The Nonflavanoid phenols.
     */
    double Nonflavanoid_phenols;
    /**
     * The Proanthocyanins.
     */
    double  Proanthocyanins;
    /**
     * The Color.
     */
    double Color;
    /**
     * The Intensity.
     */
    double Intensity;
    /**
     * The Hue.
     */
    double Hue;
    /**
     * The Od diluted wines.
     */
    double OD_diluted_wines;
    /**
     * The Proline class.
     */
    double Proline_class;

    /**
     * The Kn.
     */
    List<Wine> KN = new ArrayList<>();

    /**
     * Instantiates a new Wine.
     *
     * @param alcohol              the alcohol
     * @param malic_acid           the malic acid
     * @param ash                  the ash
     * @param alcalinity_ash       the alcalinity ash
     * @param magnesium            the magnesium
     * @param total_Phenols        the total phenols
     * @param flavanoids           the flavanoids
     * @param nonflavanoid_phenols the nonflavanoid phenols
     * @param proanthocyanins      the proanthocyanins
     * @param color                the color
     * @param intensity            the intensity
     * @param hue                  the hue
     * @param od_diluted_wines     the od diluted wines
     * @param proline_class        the proline class
     */
    public Wine(double alcohol,double malic_acid,double ash,double alcalinity_ash,double magnesium,double total_Phenols,double flavanoids,double nonflavanoid_phenols,double proanthocyanins,double color,double intensity,double hue,double od_diluted_wines,double proline_class){
        this.Alcohol= alcohol;
        this.Malic_acid=malic_acid;
        this.Ash=ash;
        this.Alcalinity_ash=alcalinity_ash;
        this.Magnesium=magnesium;
        this.Total_Phenols=total_Phenols;
        this.Flavanoids=flavanoids;
        this.Nonflavanoid_phenols=nonflavanoid_phenols;
        this.Proanthocyanins=proanthocyanins;
        this.Color=color;
        this.Intensity=intensity;
        this.Hue=hue;
        this.OD_diluted_wines=od_diluted_wines;

        this.Proline_class=proline_class;
    }

    /**
     * Gets kn.
     *
     * @return the kn
     */
    public List<Wine> getKN() {
        return KN;
    }

    /**
     * Set kn.
     *
     * @param kn the kn
     */
    public void setKN(List<Wine> kn){
        this.KN =kn;
    }

    /**
     * Gets malic acid.
     *
     * @return the malic acid
     */
    public double getMalic_acid() {
        return Malic_acid;
    }

    /**
     * Gets ash.
     *
     * @return the ash
     */
    public double getAsh() {
        return Ash;
    }

    /**
     * Gets alcalinity ash.
     *
     * @return the alcalinity ash
     */
    public double getAlcalinity_ash() {
        return Alcalinity_ash;
    }

    /**
     * Gets magnesium.
     *
     * @return the magnesium
     */
    public double getMagnesium() {
        return Magnesium;
    }

    /**
     * Gets total phenols.
     *
     * @return the total phenols
     */
    public double getTotal_Phenols() {
        return Total_Phenols;
    }

    /**
     * Gets flavanoids.
     *
     * @return the flavanoids
     */
    public double getFlavanoids() {
        return Flavanoids;
    }

    /**
     * Gets nonflavanoid phenols.
     *
     * @return the nonflavanoid phenols
     */
    public double getNonflavanoid_phenols() {
        return Nonflavanoid_phenols;
    }

    /**
     * Gets proanthocyanins.
     *
     * @return the proanthocyanins
     */
    public double getProanthocyanins() {
        return Proanthocyanins;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public double getColor() {
        return Color;
    }

    /**
     * Gets intensity.
     *
     * @return the intensity
     */
    public double getIntensity() {
        return Intensity;
    }

    /**
     * Gets hue.
     *
     * @return the hue
     */
    public double getHue() {
        return Hue;
    }

    /**
     * Gets od diluted wines.
     *
     * @return the od diluted wines
     */
    public double getOD_diluted_wines() {
        return OD_diluted_wines;
    }

    /**
     * Gets proline class.
     *
     * @return the proline class
     */
    public double getProline_class() {
        return Proline_class;
    }

    /**
     * Gets alcohol.
     *
     * @return the alcohol
     */
    public double getAlcohol() {
        return Alcohol;
    }
}
