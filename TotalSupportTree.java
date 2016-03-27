public class TotalSupportTree extends AssocRuleMining {

       
    protected TtreeNode[] startTtreeRef;

    protected int numFrequentsets =0;
    protected long numUpdates   = 0l;
    protected String duration = null;


    public TotalSupportTree(String[] args) {
        super(args);
        }

    public void addToTtree( int[] itemSet, int support)
    {
        int endIndex = itemSet.length-1;
       
        startTtreeRef = addToTtree(startTtreeRef,numOneItemSets+1,
                        endIndex,itemSet,support);
        }
               
    protected TtreeNode[] addToTtree(TtreeNode[] linkRef, int size, int endIndex,
                                 int[] itemSet, int support)
    {
                if (linkRef == null) {
                    linkRef = new TtreeNode[size];
                    for(int index=1;index<linkRef.length;index++)
                                linkRef[index] = null;
                    }
               
                int currentAttribute = itemSet[endIndex];
                if (linkRef[currentAttribute] == null)
                                linkRef[currentAttribute] = new TtreeNode();
               
                if (endIndex == 0) {
                    linkRef[currentAttribute].support =
                                        linkRef[currentAttribute].support + support;
                    return(linkRef);
                    }
                   
                linkRef[currentAttribute].childRef =
                                addToTtree(linkRef[currentAttribute].childRef,
                                        currentAttribute,endIndex-1,itemSet,support);
                return(linkRef);
        }

    protected int getSupportForItemSetInTtree( int[] itemSet)
    {
                int endInd = itemSet.length-1;
       
                if (startTtreeRef[itemSet[endInd]] != null)
                {
                    if (endInd == 0) return(startTtreeRef[itemSet[0]].support);
                    else
                    {
                        TtreeNode[] tempRef = startTtreeRef[itemSet[endInd]].childRef;
                        if (tempRef != null) return(getSupForIsetInTtree2(itemSet,
                                                                   endInd-1,tempRef));
                        else return(0);
                    }
                }
            else return(0);
        }

    private int getSupForIsetInTtree2( int[] itemSet, int index,
                                                        TtreeNode[] linkRef)
    {
        if (linkRef[itemSet[index]] != null)
        {
                    if (index == 0) return(linkRef[itemSet[0]].support);
                    else if (linkRef[itemSet[index]].childRef != null)
                                          return(getSupForIsetInTtree2(itemSet,index-1,
                                                    linkRef[itemSet[index]].childRef));
                    else return(0);
            }  
        else return(0);    
    }

    public void generateARs()
    {
                System.out.println("GENERATE ARs:\n-------------");
       
                startRulelist = null;
       
                generateARs2();
        }

    protected void generateARs2()
    {
        for (int index=1;index <= numOneItemSets;index++)
        {
                if (startTtreeRef[index] !=null)
                {
                        if (startTtreeRef[index].support >= minSupport)
                        {
                                 int[] itemSetSoFar = new  int[1];
                                itemSetSoFar[0] = ( int) index;
                                generateARs(itemSetSoFar,index,
                                startTtreeRef[index].childRef);
                        }
                }
            }
        }

    protected void generateARs( int[] itemSetSofar, int size,
                                                        TtreeNode[] linkRef)
    {

                if (linkRef == null) return;
       
                for (int index=1; index < size; index++)
                {
                    if (linkRef[index] != null)
                    {
                        if (linkRef[index].support >= minSupport) {
                             int[] tempItemSet = realloc2(itemSetSofar,( int) index);
                            generateARsFromItemset(tempItemSet,linkRef[index].support);
                            generateARs(tempItemSet,index,linkRef[index].childRef);
                        }
                        }
                }
        }
     
   
     
    private void generateARsFromItemset( int[] itemSet, double support)
    {
         int[][] combinations = combinations(itemSet);

        for(int index=0;index<combinations.length;index++)
        {
                 int[] complement = complement(combinations[index],itemSet);
                if (complement != null) {
                        double confidenceForAR = getConfidence(combinations[index],
                                                                support);
                        if (confidenceForAR >= confidence)
                        {
                                insertRuleintoRulelist(combinations[index],
                                                   complement,confidenceForAR);
                        }
                }
            }
        }

   
    protected double getConfidence( int[] antecedent, double support) {
        double supportForAntecedent = (double)
                                getSupportForItemSetInTtree(antecedent);
                               
        double confidenceForAR = ((double) support/supportForAntecedent)*10000;
        int tempConf = (int) confidenceForAR;
        confidenceForAR = (double) tempConf/100;
        return(confidenceForAR);
        }
                       
    public void setNumOneItemSets() {
        numOneItemSets=getNumSupOneItemSets();
        }

    public void outputTtree()
    {
        int number = 1;
       
        if (startTtreeRef == null)
        {
                System.out.println("No tree is built...");
                return;
        }
        for ( int index=1; index < startTtreeRef.length; index++)
        {
                if (startTtreeRef[index] !=null)
                {
                        String itemSetSofar =
                                            Integer.toString(index);
                        System.out.print("[" + number + "] {" + itemSetSofar);
                        System.out.println("} = " + startTtreeRef[index].support);
                        outputTtree(new Integer(number).toString(),itemSetSofar,
                                                        startTtreeRef[index].childRef);
                        number++;
                }
            }  
        }
       
    private void outputTtree(String number, String itemSetSofar,
                                TtreeNode[] linkRef)
    {
                int num=1;
                number = number + ".";
                itemSetSofar = itemSetSofar + " ";
               
                if (linkRef == null) return;
               
                for ( int index=1;index<linkRef.length;index++)
                {
                    if (linkRef[index] != null)
                    {
                        String newItemSet = itemSetSofar + (reconvertItem(index));
                        System.out.print("[" + number + num + "] {" + newItemSet);
                        System.out.println("} = " + linkRef[index].support);
                        outputTtree(number + num,newItemSet,linkRef[index].childRef);
                        num++;
                        }
                }    
        }

    public void outputFrequentSets()
    {
                int number = 1;
       
                System.out.println("FREQUENT (LARGE) ITEM SETS:\n" +
                                        "---------------------------");
                System.out.println("Format: [N] {I} = S, where N is a sequential " +
                        "number, I is the item set and S the support.");
       
       
                for ( int index=1; index <= numOneItemSets; index++)
                {
                    if (startTtreeRef[index] !=null)
                    {
                        if (startTtreeRef[index].support >= minSupport)
                        {
                            String itemSetSofar =
                                           Integer.toString(index);
                            System.out.println("[" + number + "] {" + itemSetSofar +
                                               "} = " + startTtreeRef[index].support);
                            number = outputFrequentSets(number+1,itemSetSofar,
                                                 index,startTtreeRef[index].childRef);
                            }
                        }
                }
       
                System.out.println("\n");
        }

    private int outputFrequentSets(int number, String itemSetSofar, int size,
                                                        TtreeNode[] linkRef)
    {
                if (linkRef == null) return(number);
       
                itemSetSofar = itemSetSofar + " ";
                for ( int index=1; index < size; index++)
                {
                    if (linkRef[index] != null)
                    {
                        if (linkRef[index].support >= minSupport)
                        {
                            String newItemSet = itemSetSofar + (reconvertItem(index));
                            System.out.println("[" + number + "] {" + newItemSet +
                                                     "} = " + linkRef[index].support);
                            number = outputFrequentSets(number + 1,newItemSet,index,
                                                             linkRef[index].childRef);
                        }
                        }
                }
       
                return(number);
        }
       
    public void outputNumFreqSets()
    {
                if (startTtreeRef== null) System.out.println("Number of frequent " +
                                                "sets = 0");
                else System.out.println("Number of frequent sets = " +
                                                countNumFreqSets());
        }
   
    protected int countNumFreqSets()
    {
        if (startTtreeRef ==  null) return(0);

        int num=0;
        for (int index=1; index <= numOneItemSets; index++)
        {
                if (startTtreeRef[index] !=null)
                {
                        if (startTtreeRef[index].support >= minSupport)
                                num = countNumFreqSets(index,
                                        startTtreeRef[index].childRef,num+1);
                }
            }  
        return(num);
        }
       
    protected int countNumFreqSets(int size, TtreeNode[] linkRef, int num)
    {
        if (linkRef == null) return(num);
       
        for (int index=1; index < size; index++)
        {
                if (linkRef[index] != null)
                {
                        if (linkRef[index].support >= minSupport)
                                        num = countNumFreqSets(index,
                                linkRef[index].childRef,num+1);
                }
            }
       
        return(num);
        }

    public void outputTtreeStats()
    {
        System.out.println("T-TREE STATISTICS\n-----------------");    
                System.out.println(calculateStorage() + " (Bytes) storage");
                System.out.println(TtreeNode.getNumberOfNodes() + " nodes");
                System.out.println(countNumFreqSets() + " frequent sets");
                System.out.println(numUpdates + " support value increments");
                System.out.println(duration);
        }
       
    public void outputNumUpdates()
    {
                System.out.println("Number of Nodes created = " +
                                TtreeNode.getNumberOfNodes());
                System.out.println("Number of Updates       = " + numUpdates);
        }
               
    public void outputStorage() {
                if (startTtreeRef ==  null) return;
                       
                System.out.println("T-tree Storage          = "
                                + calculateStorage() + " (Bytes)");
        }      
   
    protected int calculateStorage()
    {
        if (startTtreeRef ==  null) return(0);
               
        int storage = 4;        
                for (int index=1; index <= numOneItemSets; index++)
                {
                    if (startTtreeRef[index] !=null) storage = storage + 12 +
                                calculateStorage(0,startTtreeRef[index].childRef);
                    else storage = storage+4;
                }
                return(storage);
        }
       
    private int calculateStorage(int localStorage, TtreeNode[] linkRef)
    {  
                if (linkRef == null) return(0);
               
                for (int index=1; index < linkRef.length; index++)
                {
                    if (linkRef[index] !=null) localStorage = localStorage + 12 +
                                calculateStorage(0,linkRef[index].childRef);
                    else localStorage = localStorage + 4;
                }  
                 
                return(localStorage+4); 
    }
}
    
