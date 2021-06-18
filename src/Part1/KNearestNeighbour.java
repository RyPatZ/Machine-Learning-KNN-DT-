package Part1;


import java.util.ArrayList;
import java.util.List;

/**
 * The type K nearest neighbour.
 */
public class KNearestNeighbour {
    /**
     * The Train list.
     */
    List<Wine> trainList = new ArrayList<>();
    /**
     * The Test list.
     */
    List<Wine> testList = new ArrayList<>();

    private List<Double> ranges = new ArrayList<>();


    /**
     * Instantiates a new K nearest neighbour.
     *
     * @param p the p
     * @param k the k
     */
    public KNearestNeighbour(Parser p, int k) {
        this.trainList = p.getTrainList();
        this.testList = p.getTestList();
        this.ranges = p.getRanges();
        double count = testList.size();
        double correctness_count = 0;
        int test_count =1;

        for (Wine test : testList) {
            List<Wine> kNeighbours = new ArrayList<>();
            for (Wine train : trainList) {
                euclideanDistanceCalculator edc = new euclideanDistanceCalculator(train, test,ranges);
                double distance = edc.getDistance();
                //double distancekn = 0;

                if (kNeighbours.size() >= k) {
                    double smallestD = 100;
                    //System.out.println(kNeighbours.get(0).getProline_class());
                    boolean replace = false;
                    Wine remove = null;

                    for (Wine kn : kNeighbours) {
                        euclideanDistanceCalculator edc1 = new euclideanDistanceCalculator(kn, test,ranges);
                        double distancekn = edc1.getDistance();
                        if (distancekn < smallestD) {
                            smallestD = distancekn;
                        }
                        if (distancekn > distance) {
                            replace = true;
                            remove = kn;
                            smallestD = distance;
                        }
                    }

                    if (replace) {
                        kNeighbours.remove(remove);
                        kNeighbours.add(train);
                    }

                    //for(Wine kn : kNeighbours){}
                } else {
                    kNeighbours.add(train);
                }
            }
            test.setKN(kNeighbours);
            int class1 = 0;
            int class2 = 0;
            int class3 = 0;
            int pc = 0;
            for (Wine kn : kNeighbours) {
                if (kn.getProline_class() == 1) {
                    class1++;
                }
                if (kn.getProline_class() == 2) {
                    class2++;
                }
                if (kn.getProline_class() == 3) {
                    class3++;
                }
            }
            if (class1 > class2 && class1 > class3) {
                pc = 1;
            }
            if (class2 > class1 && class2 > class3) {
                pc = 2;
            }
            if (class3 > class2 && class3 > class1) {
                pc = 3;
            }
            System.out.println("-----------------------------------------------");
            System.out.println("Number " + test_count + "test wine");
            System.out.println("Predicted class:" + (double)pc);
            System.out.println("Actual class:" + test.getProline_class());
            test_count++;
            if (pc == test.getProline_class()) {
                correctness_count++;
            }
        }

        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("K value = "+ k );
        System.out.println("Correct classified instances: " + correctness_count);
        System.out.println("Total unseen instances: " + count);
        double accuracy = (correctness_count / count) * 100;
        System.out.printf("Accuracy: %.2f%%", accuracy);
        System.out.println("\n------------------------------------------------");
    }

}
