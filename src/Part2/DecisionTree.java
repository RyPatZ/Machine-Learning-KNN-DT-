package Part2;

import Part1.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Decision tree.
 */
public class DecisionTree {
    /**
     * The Category names.
     */
    List<String> categoryNames= new ArrayList<>();
    /**
     * The Instance list.
     */
    List<Instance> instanceList;
    /**
     * The Test instance list.
     */
    List<Instance> testInstanceList;

    /**
     * The Tree.
     */
    Node tree ;

    /**
     * Instantiates a new Decision tree.
     *
     * @param trainFilePath the train file path
     * @param testFilePath  the test file path
     */
    public DecisionTree(String trainFilePath,String testFilePath){
        Parser2 parser = new Parser2(trainFilePath);
        this.instanceList = parser.getAllInstances();
        this.categoryNames = parser.getCategoryNames();
        Node n =buildTree(parser.getAllInstances(),parser.getCategoryNames());
        this.tree=n;
    }


    /**
     * Build tree node.
     *
     * @param instances  the instances
     * @param attributes the attributes
     * @return the node
     */
    public Node buildTree(List<Instance> instances, List<String> attributes){
        if(attributes.size()==1){attributes.remove("Class");}
        List<String> att = categoryNames;
        if(instances.isEmpty()){
            Node leafNode= new Node(getMostProbableClass(instanceList),getProbability(instanceList));
            return leafNode;
        }
        else if (getProbability(instances)==1){
            Node leafNode= new Node(getMostProbableClass(instances),1);
            return leafNode;
        }
        else if (attributes.isEmpty()){
            Node leafNode= new Node(getMostProbableClass(instances),getProbability(instances));
            return leafNode;
        }
        List<Instance> besttrueInstances = new ArrayList<>();
        List<Instance> bestfalseInstances = new ArrayList<>();
        String bestAttribute = "";
        double bestImpurity = Double.MAX_VALUE;
         for(String a:attributes){
             if (!a.equals("Class")) {
             List<Instance> trueInstances = new ArrayList<>();
             List<Instance> falseInstances = new ArrayList<>();
                 int num = att.indexOf(a);
             for(Instance ins : instances) {
                 boolean val = ins.getVals().get( num- 1);
                 if (val==true) {
                     trueInstances.add(ins);
                 } else if (val==false) {
                     falseInstances.add(ins);
                 }
             }
                 double impurityTrue =0;
                 double impurityFalse =0;
                 if (!trueInstances.isEmpty()) {
                     impurityTrue = getImpurity(trueInstances);
                 }
                 if (!falseInstances.isEmpty()) {
                     impurityFalse = getImpurity(falseInstances);
                 }
                 //System.out.println(impurityFalse);

                 double weightedAvgImpurity = 0;
                 weightedAvgImpurity = impurityTrue * ((double) trueInstances.size() / (double) instances.size())
                         + impurityFalse * ((double) falseInstances.size() / (double) instances.size());
                 if (weightedAvgImpurity < bestImpurity) {
                     bestAttribute = a;
                     besttrueInstances = trueInstances;
                     bestfalseInstances = falseInstances;
                     bestImpurity = weightedAvgImpurity;
                 }
             }
         }

        List<String> Attributes1 =new ArrayList<>(attributes);
        List<String> Attributes2 =new ArrayList<>(attributes);
        Attributes1.remove(bestAttribute);
        Attributes2.remove(bestAttribute);

        Node LeftChild = buildTree(besttrueInstances,Attributes1);
        Node RightChild = buildTree(bestfalseInstances,Attributes2);
        Node n = new Node(LeftChild,RightChild,bestAttribute);
        return n;

    }
//    BuildTree (Set instances, List attributes)
//if instances is empty:
//            return a leaf node that contains the name and probability of the most probable
//    class across the whole training set (i.e. the ‘‘baseline’’ predictor)
//            else if instances are pure (i.e. all belong to the same class):
//            return a leaf node that contains the name of the class and probability 1
//            else if attributes is empty:
//            return a leaf node that contains the name and probability of the majority
//    class of instances (chosen randomly if classes are equal)
//            else find best attribute:
//            for each attribute:
//    separate instances into two sets:
//            1) instances for which the attribute is true, and
//2) instances for which the attribute is false
//    compute purity of each set.
//if weighted average purity of these sets is best so far:
//    bestAtt = this attribute
//            bestInstsTrue = set of true instances
//            bestInstsFalse = set of false instances
//    build subtrees using the remaining attributes:
//    left = BuildTree(bestInstsTrue, attributes - bestAtt)
//    right = BuildTree(bestInstsFalse, attributes


    /**
     * Gets most probable class.
     *
     * @param instances the instances
     * @return the most probable class
     */
    public String getMostProbableClass(List<Instance> instances) {
        double countLive = 0.0;
        double countDie = 0.0;
        for (Instance ins: instances) {
            if(ins.getClassName().equalsIgnoreCase(("live"))) { countLive++; }
            else if(ins.getClassName().equalsIgnoreCase("die")) { countDie++; }
        }
        if(countLive > countDie) { return ("live"); }
        return "die";
    }

    /**
     * Gets probability.
     *
     * @param instances the instances
     * @return the probability
     */
    public double getProbability(List<Instance> instances) {
        double countLive = 0.0;
        double countDie = 0.0;
        for (Instance ins: instances) {
            if(ins.getClassName().equals(("live"))) { countLive++; }
            else if(ins.getClassName().equals("die"))  { countDie++; }
        }
        double prob = 0.5;
        if(countLive > countDie) {
            prob = countLive/(instances.size());
        }
        else if(countDie > countLive){
            prob = countDie/(instances.size());
        }
        return prob;
    }

    /**
     * Gets impurity.
     *
     * @param instances the instances
     * @return the impurity
     */
    public double getImpurity(List<Instance> instances) {
        double countLive = 0.0;
        double countDie = 0.0;
        double impurity = 0.0;
        for (Instance ins: instances) {
            if(ins.getClassName().equalsIgnoreCase(("live"))) { countLive++; }
            else if(ins.getClassName().equalsIgnoreCase("die")) { countDie++; }
        }
        if (countDie==0||countLive==0){
            impurity = 0.0;
        }
        else if (countDie==countLive){
            impurity= Double.MAX_VALUE;
        }
        else{impurity=countLive*countDie/Math.pow((countLive+countDie),2); }
        return impurity;
    }

    /**
     * Predict string.
     *
     * @param n   the n
     * @param ins the ins
     * @return the string
     */
    public String predict(Node n, Instance ins) {
        if(n.isLeaf()) {
            return n.getClassN();
        }
        else {
            int num = categoryNames.indexOf(n.getBestAttr());
            if(ins.getVals().get(num-1) == true) {
                Node left = n.getLeftChild();
                return predict(left, ins);
            }
            else {
                Node right = n.getRightChild();
                return predict(right, ins);
            }
        }
    }

    /**
     * Print tree.
     *
     * @param n the n
     */
    public void printTree(Node n){
        System.out.println("-----------------------------------------------");
        System.out.println("The Decision Tree :");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        n.report("");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
    }

    /**
     * Gets tree.
     *
     * @return the tree
     */
    public Node getTree() {
        return tree;
    }

    /**
     * Test accuracy.
     * normal
     *
     * @param n            the n
     * @param testFilePath the test file path
     */
    public void testAccuracy(Node n,String testFilePath){
        Parser2 parser1 = new Parser2(testFilePath);
        this.testInstanceList = parser1.getAllInstances();
        this.categoryNames = parser1.getCategoryNames();
        double correctness_count = 0;
        double count =0;
        for (Instance ins: testInstanceList) {
            String prediction = predict(n, ins);
            if(prediction.equals(ins.getClassName())) { correctness_count++; }
            count++;
        }
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("Decision Tree Classifier");
        System.out.println("Correct predicted instances: " + correctness_count);
        System.out.println("Total unseen instances: " + count);
        double accuracy = (correctness_count / count) * 100;
        System.out.printf("Accuracy: %.2f%%", accuracy);
        System.out.println("\n------------------------------------------------");
        System.out.println(correctness_count + " out of " + count);
        System.out.println("------------------------------------------------");
        System.out.println("Baseline classifier: " + getMostProbableClass(instanceList));
        double baseLineCount =0;
        for (Instance ins: testInstanceList) {
            String predict = getMostProbableClass(instanceList);
            if(predict.equals(ins.getClassName())) { baseLineCount++; }
        }
        System.out.println("Correct predicted instances(baseline): " + baseLineCount + "  Total unseen instances: " + count);
        double acc_b = (baseLineCount / count) * 100;
        System.out.printf("Accuracy(Baseline): %.2f%%", acc_b);
        System.out.println("\n------------------------------------------------");
    }

    /**
     * Ten fold cross validation .
     *
     * @param trainPath the train path
     * @param testPath  the test path
     * @return the double
     */
    public double tenFoldCrossValidation(String trainPath,String testPath){
        Parser2 parser1 = new Parser2(trainPath);
        Parser2 parser2 = new Parser2(testPath);
        //get rain dataset
        List<Instance> train = parser1.allInstances;
        List<String> att = parser1.getCategoryNames();
        List<Double> accuracyList = new ArrayList<>();

        //Put both train and test data test into a whole set
        for(Instance t:parser2.allInstances){
            train.add(t);
        }
        //chop the whole set into 10 subsets each contains 14 wine datas and the last subset have 11
        //run 10 times
        for(int i =0; i<=train.size()-11;i+=14){
            List<Instance> testSet=new ArrayList<>();
            //create subsets and make the current subset the testset
            if(i+11!=train.size()) {
                testSet = train.subList(i, i + 14);
            }
            else {
                testSet = train.subList(i,i+11);
            }
            List<Instance> trainSet = new ArrayList<>(train);
            //create train set which is the remaining 9 sets
            for(Instance ins : testSet){
                trainSet.remove(ins);
            }
            //Train classifier using the training set
            Node n = buildTree(trainSet,att);
            double correctness_count = 0;
            double count =0;
            //apply to the test set
            for (Instance ins: testSet) {
                String prediction = predict(n, ins);
                if(prediction.equals(ins.getClassName())) { correctness_count++; }
                count++;
            }
            //get accuracy for the current subsets
            double accuracy = (correctness_count / count) * 100;
            //add it into the accuracy list
            accuracyList.add(accuracy);
        }
        //get average accuracy
        double total =0;
        for(Double a:accuracyList){
            total += a;
        }
        double accuracy = total/10;
        return accuracy;
    }

    /**
     * Test ten.
     *
     * @param directory the directory
     */
    public void testTen(String directory){
        double average = 0;
        //apply 10 fold cross validation to 10 tests provided
        for(int i = 0; i < 10; i++) {
            average+=tenFoldCrossValidation(directory + "hepatitis-training-run-" + i, directory + "hepatitis-test-run-" + i);
        }
        average = (average/10);
        System.out.println("-----------------------------------------------");
        System.out.printf("Average accuracy Of ten fold cross validation = %.2f%% ", average);
        System.out.println("\n-----------------------------------------------");
        System.out.println("-----------------------------------------------");
    }
}
