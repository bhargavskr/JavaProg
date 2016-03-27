
import java.io.*;
import java.util.*;


public class TtreeNode {
   
    public int support = 0;
   
    public TtreeNode[] childRef = null;

    public static int numberOfNodes = 0;
   
       
    public TtreeNode() {
        numberOfNodes++;
        }
       
       
    public TtreeNode(int sup) {
        support = sup;
        numberOfNodes++;
        }
   
   
    public static int getNumberOfNodes() {
        return(numberOfNodes);
        }
    }


