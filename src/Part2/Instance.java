package Part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Instance.
 */
public class Instance {

    private int category;
    private List<Boolean> vals;
    /**
     * The Category names.
     */
    List<String> categoryNames;
    private String className;

    /**
     * Instantiates a new Instance.
     *
     * @param cat the cat
     * @param s   the s
     */
    public Instance(int cat, Scanner s){
        category = cat;
        vals = new ArrayList<Boolean>();
        className = s.next();
        while (s.hasNextBoolean()) vals.add(s.nextBoolean());
    }

    /**
     * Get att boolean.
     *
     * @param index the index
     * @return the boolean
     */
    public boolean getAtt(int index){
        return vals.get(index);
    }

    /**
     * Get category int.
     *
     * @return the int
     */
    public int getCategory(){
        return category;
    }

    /**
     * Gets vals.
     *
     * @return the vals
     */
    public List<Boolean> getVals() {
        return vals;
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
     * Gets class name.
     *
     * @return the class name
     */
    public String getClassName() {
        return className;
    }

//    public String toString(){
//        StringBuilder ans = new StringBuilder(categoryNames.get(category));
//        ans.append(" ");
//        for (Boolean val : vals)
//            ans.append(val?"true  ":"false ");
//        return ans.toString();
//    }

}
