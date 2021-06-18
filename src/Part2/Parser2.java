package Part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.*;


/**
 * The type Parser 2.
 */
public class Parser2 {
   private int numCategories;
   private int numAtts;
   private List<String> categoryNames;
   private List<String> attNames;


    /**
     * Instantiates a new Parser 2.
     *
     * @param filePath the file path
     */
    public Parser2(String filePath ){
        readDataFile(filePath);
    }


    /**
     * Gets num categories.
     *
     * @return the num categories
     */
    public int getNumCategories() {
        return numCategories;
    }

    /**
     * Gets num atts.
     *
     * @return the num atts
     */
    public int getNumAtts() {
        return numAtts;
    }

    /**
     * Gets category names.
     *
     * @return the category names
     */
    public List<String> getCategoryNames() {
        return categoryNames;
    }

    /**
     * Gets att names.
     *
     * @return the att names
     */
    public List<String> getAttNames() {
        return attNames;
    }

    /**
     * Gets all instances.
     *
     * @return the all instances
     */
    public List<Instance> getAllInstances() {
        return allInstances;
    }

    /**
     * The All instances.
     */
    List<Instance> allInstances;


    private void readDataFile(String fname) {
        /* format of names file:
         * names of categories, separated by spaces
         * names of attributes
         * category followed by true's and false's for each instance
         */
//        System.out.println("Reading data from file " + fname);
        try {
            Scanner din = new Scanner(new File(fname));

            categoryNames = new ArrayList<String>();
            Scanner s = new Scanner(din.nextLine());
            while( s.hasNext() ) {categoryNames.add(s.next());}
            numCategories = categoryNames.size();
            //System.out.println(categoryNames);
            //System.out.println(numCategories + " categories");

            attNames = new ArrayList<String>();
            s = new Scanner(din.nextLine());
            while (s.hasNext()) attNames.add(s.next());
            numAtts = attNames.size();
            //System.out.println(numAtts + " attributes");

            Scanner din1 = new Scanner(new File(fname));
            din1.nextLine();
            allInstances = readInstances(din1);
            din.close();
        } catch (IOException e) {
            throw new RuntimeException("Data File caused IO exception");
        }
    }


    private List<Instance> readInstances(Scanner din) {
        /* instance = classname and space separated attribute values */
        List<Instance> instances = new ArrayList<Instance>();
        String ln;
        int count = 0;
        while (din.hasNext()) {
            Scanner line = new Scanner(din.nextLine());
            instances.add(new Instance(count, line));
            count ++;
        }
        //System.out.println("Read " + instances.size() + " instances");
        return instances;
    }
}