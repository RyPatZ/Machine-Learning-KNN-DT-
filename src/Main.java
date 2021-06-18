import Part1.KNearestNeighbour;
import Part1.Parser;
import Part2.DecisionTree;
import Part2.Parser2;
import Part3.Parser3;
import Part3.Perceptron;

import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {


        if (args.length==0) {
            Scanner sc1 = new Scanner(System.in);
            System.out.printf("Enter part number");
            int p = Integer.parseInt(sc1.next());
            if (p == 1) {
//            String trainFilepath = args[1];
//            String testFilepath = args[2];
                Scanner sc2 = new Scanner(System.in);
                System.out.printf("Enter train path");
                //String trainFilepath = "/Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part1/wine-training";
                String trainFilepath =sc2.next();
                //String testFilepath = "/Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part1/wine-test";
                Scanner sc3 = new Scanner(System.in);
                System.out.printf("Enter test path");
                String testFilepath = sc3.next();

                Scanner sc = new Scanner(System.in);
                System.out.printf("Enter the 'K' Value: 	");
                int k = Integer.parseInt(sc.next());
                System.out.println("k =" + k);
                Parser parser = new Parser(trainFilepath, testFilepath);
                KNearestNeighbour knn = new KNearestNeighbour(parser, k);
            }


            if (p == 2) {
//                String trainFilepath = "/Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part2/hepatitis-training";
//                String testFilepath = "/Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part2/hepatitis-test";
                Scanner sc2 = new Scanner(System.in);
                System.out.printf("Enter train path");
                String trainFilepath =sc2.next();
                Scanner sc3 = new Scanner(System.in);
                System.out.printf("Enter test path");
                String testFilepath = sc3.next();
                DecisionTree DT = new DecisionTree(trainFilepath, testFilepath);
                DT.printTree(DT.getTree());
                DT.testAccuracy(DT.getTree(), testFilepath);
                Scanner sc5 = new Scanner(System.in);
                System.out.printf("\nDo you want to apply 10-fold cross-validation? (y/n)");
                if(sc5.next().equalsIgnoreCase("y")) {
                    Scanner sc4 = new Scanner(System.in);
                    System.out.printf("Enter test directory path");
                    String directory = sc4.next();
                    DT.testTen(directory);
                    //String directory = "/Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part2/";
                }
            }

            if (p == 3) {
                Scanner sc2 = new Scanner(System.in);
                System.out.printf("Enter image file path");
                String imageFilepath =sc2.next();
                //String imageFilepath = "/Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part3/image1.data";
                Perceptron perceptron = new Perceptron(imageFilepath);
            }
        }
        else if (args[0].equals("part1")){
            //java Main.java part1 /Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part1/wine-training /Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part1/wine-test
            //String trainFilepath = "/Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part1/wine-training";
            String trainFilepath =args[1];
            //String testFilepath = "/Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part1/wine-test";
            String testFilepath = args[2];
            Scanner sc = new Scanner(System.in);
            System.out.printf("Enter the 'K' Value: 	");
            int k = Integer.parseInt(sc.next());
            System.out.println("k =" + k);
            Parser parser = new Parser(trainFilepath, testFilepath);
            KNearestNeighbour knn = new KNearestNeighbour(parser, k);
        }
        else if (args[0].equals("part2")){
            //java Main part2 /Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part2//hepatitis-training /Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part2/hepatitis-test
            String trainFilepath =args[1];
            String testFilepath = args[2];
            DecisionTree DT = new DecisionTree(trainFilepath, testFilepath);
            DT.printTree(DT.getTree());
            DT.testAccuracy(DT.getTree(), testFilepath);

            Scanner sc5 = new Scanner(System.in);
            System.out.printf("\nDo you want to apply 10-fold cross-validation? (y/n)");
            if(sc5.next().equalsIgnoreCase("y")) {
                Scanner sc4 = new Scanner(System.in);
                System.out.printf("Enter test directory path");
                String directory = sc4.next();
                DT.testTen(directory);
                //String directory = "/Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part2/";
            }
        }
        else if (args[0].equals("part3")) {
            //java Main part3 /Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part3/image.data
            String imageFilepath =args[1];
            //String imageFilepath = "/Users/patrickzhang/Desktop/COMP307/COMP307A1/ass1_data/part3/image1.data";
            Perceptron perceptron = new Perceptron(imageFilepath);
        }


    }




}

