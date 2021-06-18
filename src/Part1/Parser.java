package Part1;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * The type Parser.
 */
public class Parser {
    private List<String> featureList = new ArrayList<>();
    private List<Wine> trainList = new ArrayList<>();
    private List<Wine> testList = new ArrayList<>();
    private List <Double> min = new ArrayList<>();
    private List<Double> max = new ArrayList<>();
    private List<Double> ranges = new ArrayList<>();


    /**
     * The Train featuresize.
     */
    int trainFeaturesize;
    private List<Wine> trainFeatures = new ArrayList<>();

    /**
     * Instantiates a new Parser.
     *
     * @param wine_train_filepath the wine train filepath
     * @param wine_test_filepath  the wine test filepath
     */
    public Parser(String wine_train_filepath, String wine_test_filepath) {
        this.trainList = getList(wine_train_filepath, true);
        this.testList = getList(wine_test_filepath, false);
        for (int i = 0; i < 13; i++) {
            double range = min.get(i)-max.get(i);
            ranges.add(range);
        }
    }

    /**
     * Gets train list.
     *
     * @return the train list
     */
    public List<Wine> getTrainList() {
        return trainList;
    }

    /**
     * Gets test list.
     *
     * @return the test list
     */
    public List<Wine> getTestList() {
        return testList;
    }

    /**
     * Gets list.
     *
     * @param filePath the file path
     * @param istrain  the istrain
     * @return the list
     */
    public List<Wine> getList(String filePath, boolean istrain) {
        List<Wine> List = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String features = br.readLine();
            if(featureList.isEmpty()) {
                if (features != null) {
                    String[] feature = features.split(" ");
                    for (int i = 0; i < 13; i++) {
                        this.featureList.add(feature[i]);
                    }
                }
            }
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(" ");
                Wine wine = new Wine(Double.parseDouble(attributes[0]), Double.parseDouble(attributes[1]), Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]), Double.parseDouble(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]), Double.parseDouble(attributes[9]), Double.parseDouble(attributes[10]), Double.parseDouble(attributes[11]), Double.parseDouble(attributes[12]), Double.parseDouble(attributes[13]));
                List.add(wine);
                if(istrain){
                    if(min.isEmpty()||max.isEmpty()) {
                        for (int i = 0; i < 13; i++) {
                            min.add(Double.parseDouble(attributes[i]));
                            max.add(Double.parseDouble(attributes[i]));
                        }
                    }
                    else {
                        for (int i = 0; i < 13; i++) {
                            if(Double.parseDouble(attributes[i])< min.get(i)){
                                min.set(i,Double.parseDouble(attributes[i]));
                            }
                            if (Double.parseDouble(attributes[i])>max.get(i)){
                                max.set(i,Double.parseDouble(attributes[i]));
                            }
                        }
                    }
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: 1" + e.getMessage());
        }
        return List;
    }

    /**
     * Gets feature list.
     *
     * @return the feature list
     */
    public List<String> getFeatureList() {
        return featureList;
    }

    /**
     * Gets ranges.
     *
     * @return the ranges
     */
    public List<Double> getRanges() {
        return ranges;
    }
}
