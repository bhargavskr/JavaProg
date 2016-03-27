import java.io.*;

public class LoFIAApp {
   
    public static void main(String[] args) throws IOException
    {
       		PrintWriter writer = new PrintWriter("Rohit2.txt","UTF-8");
                FPtree newFPtree = new FPtree(args, 0);
               
                newFPtree.inputDataSet();
               
                newFPtree.idInputDataOrdering();
                newFPtree.recastInputDataAndPruneUnsupportedAtts();
                newFPtree.setNumOneItemSets();
                double time1 = (double) System.currentTimeMillis();
                newFPtree.createFPtree();
                newFPtree.outputDuration(time1,(double) System.currentTimeMillis());
                newFPtree.outputFPtreeStorage();                        
                time1 = (double) System.currentTimeMillis();
                newFPtree.startLoFIAMining();
               //System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("Rohit3.txt"))));
                System.out.println("Longest frequent patterns: ");
                for (int i = 0; i < newFPtree.longestPattern.size(); i++)
                {
                        System.out.println(newFPtree.longestPattern.elementAt(i).toString());
			writer.write(newFPtree.longestPattern.elementAt(i).toString());
                }
               
                newFPtree.outputDuration(time1,(double)
                                                System.currentTimeMillis());           
		writer.close(); 
        }
}

