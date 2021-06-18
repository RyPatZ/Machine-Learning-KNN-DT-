package Part2;

/**
 * The type Node.
 */
public class Node {
    private String ClassN = null;
    private double probability = 0.0;
    private Node leftChild = null;
    private Node rightChild = null;
    private String bestAttr = null;
    private boolean isLeaf;

    /**
     * Instantiates a new Node.
     *
     * @param left  the left
     * @param right the right
     * @param bestA the best a
     */
    public Node( Node left, Node right, String bestA) {
        leftChild = left;
        rightChild = right;
        bestAttr = bestA;
        isLeaf = false;
    }

    /**
     * Instantiates a new Node.
     *
     * @param cn   the cn
     * @param Prob the prob
     */
    public Node(String cn, double Prob){
        ClassN = cn;
        probability = Prob;
        isLeaf = true;
    }

    /**
     * Gets class n.
     *
     * @return the class n
     */
    public String getClassN() {
        return ClassN;
    }

    /**
     * Gets probability.
     *
     * @return the probability
     */
    public double getProbability() {
        return probability;
    }

    /**
     * Gets left child.
     *
     * @return the left child
     */
    public Node getLeftChild() {
        return leftChild;
    }

    /**
     * Gets right child.
     *
     * @return the right child
     */
    public Node getRightChild() {
        return rightChild;
    }

    /**
     * Gets best attr.
     *
     * @return the best attr
     */
    public String getBestAttr() {
        return bestAttr;
    }

    /**
     * Is leaf boolean.
     *
     * @return the boolean
     */
    public boolean isLeaf() {
        return isLeaf;
    }

    /**
     * Report.
     *
     * @param indent the indent
     */
    public void report(String indent){
        if(!isLeaf) {
            //System.out.println(isLeaf);
            System.out.printf("%s%s = True:%n", indent, bestAttr);
            leftChild.report(indent + "\t");
            System.out.printf("%s%s = False:%n", indent, bestAttr);
            rightChild.report(indent + "\t");
        }
        else {
            if (probability==0){ //Error-checking
                System.out.printf("%sUnknown%n", indent);
            }else{
                System.out.printf("%sClass %s, prob=%.2f%n", indent, ClassN, probability);
            }
        }
    }
}
