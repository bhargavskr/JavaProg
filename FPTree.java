import java.util.Vector;

public class FPtree extends TotalSupportTree {
        public Vector<FPItemSet> longestPattern = new Vector<FPItemSet>();
        public int maxOrder = 0;
   
    protected class FPtreeNode {
        private FPgrowthItemPrefixSubtreeNode node = null;
        private FPtreeNode[] childRefs = null;
       
        protected FPtreeNode() {
            }  
           
       
        protected FPtreeNode(FPgrowthItemPrefixSubtreeNode newNode) {
            node = newNode;
            }
        }
   
    private class FPgrowthItemPrefixSubtreeNode {
        private  int itemName;
        private int itemCount;
        private FPgrowthItemPrefixSubtreeNode parentRef = null;
        private FPgrowthItemPrefixSubtreeNode nodeLink = null;
       
        private FPgrowthItemPrefixSubtreeNode() {       }
       
        private FPgrowthItemPrefixSubtreeNode( int name, int support,
                        FPgrowthItemPrefixSubtreeNode backRef) {
            itemName = name;
            itemCount = support;
            parentRef = backRef;
            }
        }
   
    protected class FPgrowthHeaderTable
    {
        protected  int itemName;
        protected FPgrowthItemPrefixSubtreeNode nodeLink = null;
       
        protected FPgrowthHeaderTable ( int columnNum)
        {
                itemName = columnNum;
            }  
    }
       
    private class FPgrowthSupportedSets {
        private  int[] itemSet = null;
        private int support;
        private FPgrowthSupportedSets nodeLink = null;
       
                private FPgrowthSupportedSets( int[] newitemSet, int newSupport,
                                FPgrowthSupportedSets newNodeLink)
                {
                    itemSet = newitemSet;
                support = newSupport;
                    nodeLink = newNodeLink;
                }
        }
   
    private class FPgrowthColumnCounts {
        private  int columnNum;
        private int support=0;
       
        private FPgrowthColumnCounts(int column)
        {
                columnNum = ( int) column;
            }  
       
                private FPgrowthColumnCounts(int column, int sup)
                {
                    columnNum = ( int) column;
                    support = sup;
                }  
        }  
       
    protected FPtreeNode rootNode = null;
    protected FPgrowthHeaderTable[] headerTable;
    private static FPgrowthSupportedSets startTempSets = null;
   
   
    private int tempIndex  = 0;        
    private int numberOfNodes;
   
    public FPtree(String[] args)
    {
        super(args);
       
        rootNode = new FPtreeNode();
       
        headerTable = new FPgrowthHeaderTable[numOneItemSets+1];
       
        for (int index=1;index<headerTable.length;index++)
        {
                headerTable[index] = new FPgrowthHeaderTable(( int) index);
            }
        }      
   
    public FPtree(String[] args, int maxLength)
    {
        super(args);
       
        rootNode = new FPtreeNode();
       
        headerTable = new FPgrowthHeaderTable[numOneItemSets+1];
       
        for (int index=1;index<headerTable.length;index++) {
            headerTable[index] = new FPgrowthHeaderTable(( int) index);
            }
       
        this.maxOrder = maxLength;
        }
       
     public void createFPtree()
     {      
         headerTable = new FPgrowthHeaderTable[numOneItemSets+1];
       
         for (int index=1;index<headerTable.length;index++)
         {
                 headerTable[index] = new FPgrowthHeaderTable(( int) index);
         }
           

         for (int index=0;index<dataArray.length;index++)
         {
                 if (dataArray[index] != null)
                         addToFPtree(rootNode,0,dataArray[index],1,headerTable);
         }                                                                
        }

   
    private void addToFPtree(FPtreeNode ref, int place,  int[] itemSet,
                                int support, FPgrowthHeaderTable[] headerRef) {  
        if (place < itemSet.length) {
            if (!addToFPtree1(ref,place,itemSet,support,headerRef))
                        addToFPtree2(ref,place,itemSet,support,headerRef);
            }
        }
         
    private boolean addToFPtree1(FPtreeNode ref, int place,  int[] itemSet,
                        int support, FPgrowthHeaderTable[] headerRef)
    {  
                if (ref.childRefs != null)
                {
                    for (int index=0;index<ref.childRefs.length;index++)
                    {
                        if (itemSet[place] == ref.childRefs[index].node.itemName) {
                            ref.childRefs[index].node.itemCount =
                                         ref.childRefs[index].node.itemCount + support;
                            numUpdates++;
                            addToFPtree(ref.childRefs[index],place+1,itemSet,support,
                                        headerRef);
                            return(true);
                        }
                        if (itemSet[place] < ref.childRefs[index].node.itemName)
                                                return(false);
                        }
                }      
       
                return(false);
        }

    private void addToFPtree2(FPtreeNode ref, int place,  int[] itemSet,
                                int support, FPgrowthHeaderTable[] headerRef)
    {  
       
        FPgrowthItemPrefixSubtreeNode newPrefixNode = new
                        FPgrowthItemPrefixSubtreeNode(itemSet[place],support,ref.node);
        FPtreeNode newFPtreeNode = new FPtreeNode(newPrefixNode);
        addRefToFPgrowthHeaderTable(itemSet[place],newPrefixNode,headerRef);
        ref.childRefs = reallocFPtreeChildRefs(ref.childRefs,newFPtreeNode);
        addRestOfitemSet(ref.childRefs[tempIndex],newPrefixNode,place+1,itemSet,
                                support,headerRef);
        }
   
   
    private void addRestOfitemSet(FPtreeNode ref, FPgrowthItemPrefixSubtreeNode backRef,
                                int place,  int[] itemSet, int support,
                                                FPgrowthHeaderTable[] headerRef)
    {
        if (place<itemSet.length)
        {
                FPgrowthItemPrefixSubtreeNode newPrefixNode = new
                        FPgrowthItemPrefixSubtreeNode(itemSet[place],support,backRef);
                FPtreeNode newFPtreeNode = new FPtreeNode(newPrefixNode);
                addRefToFPgrowthHeaderTable(itemSet[place],newPrefixNode,headerRef);
                ref.childRefs = reallocFPtreeChildRefs(ref.childRefs,newFPtreeNode);
                addRestOfitemSet(ref.childRefs[tempIndex],newPrefixNode,place+1,
                                                itemSet,support,headerRef);
            }
        }
           
    private void addRefToFPgrowthHeaderTable( int columnNumber,
                     FPgrowthItemPrefixSubtreeNode newNode,
                     FPgrowthHeaderTable[] headerRef)
    {
        FPgrowthItemPrefixSubtreeNode tempRef;

        for (int index=1;index<headerRef.length;index++)
        {
                if (columnNumber == headerRef[index].itemName)
                {
                        tempRef = headerRef[index].nodeLink;
                        headerRef[index].nodeLink = newNode;
                        newNode.nodeLink = tempRef;
                        break;
                }
            }  
    }

    public void startLoFIAMining() {
        System.out.println("LoFIA Mining ");    
        startMining(headerTable,null);
        System.out.println("Finishing mining T-tree");
    }
   
    private void startMining(FPgrowthHeaderTable[] tableRef,
                                                        int[] itemSetSofar)
    {
        int headerTableEnd = tableRef.length-1;
        FPgrowthColumnCounts[] countArray = null;
        FPgrowthHeaderTable[] localHeaderTable = null;
        FPtreeNode localRoot;
        int support;
         int[] newCodeSofar;
       
        for (int index=headerTableEnd;index>=1;index--)
        {
                if (tableRef[index].nodeLink != null)
                {
                        boolean process = true;
                        if (itemSetSofar !=null)
                                if (index < this.maxOrder - itemSetSofar.length)
                                        process = false;
                        if (process)
                                startMining(tableRef[index].nodeLink,tableRef[index].itemName,
                                                                itemSetSofar);
                }
            }
        }
       
    protected void startMining(FPgrowthItemPrefixSubtreeNode nodeLink,  
                                 int itemName,  int[] itemSetSofar)
    {
       
                int support = genSupHeadTabItem(nodeLink);
                 int[] newCodeSofar = realloc2(itemSetSofar,itemName);
                if (newCodeSofar.length > this.maxOrder) {
                        System.out.println("Number current found items: "
                                        + longestPattern.size());
                        this.longestPattern.clear();
                        this.maxOrder = newCodeSofar.length;
                        System.out.println("- Processing at order: "
                                        + newCodeSofar.length);
                }
                if (newCodeSofar.length == this.maxOrder) {
                         int [] temp = new  int[newCodeSofar.length];
                        for (int i = 0; i < temp.length; i++)
                                temp[i] = reconversionArray[newCodeSofar[i]];
                        FPItemSet item = new FPItemSet(temp, support);
                        longestPattern.addElement(item);
                }
               
                startTempSets=null;
                generateAncestorCodes(nodeLink);
               
                if (startTempSets != null)
                {
                    FPgrowthColumnCounts[] countArray = countFPgrowthSingles();
                    FPgrowthHeaderTable[] localHeaderTable =
                                                createLocalHeaderTable(countArray);
                    if (localHeaderTable != null)
                    {
                        pruneAncestorCodes(countArray);
                    FPtreeNode localRoot = generateLocalFPtree(localHeaderTable);
                    int depthTree = depthFPtree(localRoot);
                    if (depthTree + newCodeSofar.length >= maxOrder)
                    {
                        startMining(localHeaderTable,newCodeSofar);
                    }
                        }
                }
        }
    private int depthFPtree(FPtreeNode node) {
        return depthFPtree2(node.childRefs, 0);
    }
   
    private int depthFPtree2(FPtreeNode ref[], int level)
    {
        if (ref == null) return level;
        int res = -1;
        for (int index =0; index < ref.length; index++)
        {
                int temp = depthFPtree2(ref[index].childRefs, level+1);
                if (temp > res) res = temp;
        }
        return res;
    }          
       
    private int genSupHeadTabItem(FPgrowthItemPrefixSubtreeNode nodeLink)
    {
        int counter = 0;        
        while(nodeLink != null)
        {
                    counter = counter+nodeLink.itemCount;
                    numUpdates++;
                    nodeLink = nodeLink.nodeLink;
            }  
       
        return(counter);
        }
       
   
    private void generateAncestorCodes(FPgrowthItemPrefixSubtreeNode ref)
    {
         int[] ancestorCode = null;
        int support;
       
        while(ref != null)
        {
                    support = ref.itemCount;
                    ancestorCode = getAncestorCode(ref.parentRef);
                    if (ancestorCode != null) startTempSets =
                                        new FPgrowthSupportedSets(ancestorCode,support,
                                                                        startTempSets);
                    ref = ref.nodeLink;
            }  
        }
   
    private  int[] getAncestorCode(FPgrowthItemPrefixSubtreeNode ref)
    {
         int[] itemSet = null;
       
        if (ref == null) return(null);
       
        while (ref != null)
        {
                itemSet = realloc2(itemSet,ref.itemName);
                ref = ref.parentRef;
            }
                return(itemSet);
        }
   
    private void pruneAncestorCodes(FPgrowthColumnCounts[] countArray)
    {
        FPgrowthSupportedSets ref = startTempSets;
       
        while(ref != null)
        {
                for(int index=0;index<ref.itemSet.length;index++)
                {
                        if (countArray[ref.itemSet[index]].support < minSupport)
                                ref.itemSet = removeElementN(ref.itemSet,index);
                }
                ref = ref.nodeLink;
            }
        }
                               
       
    private FPgrowthColumnCounts[] countFPgrowthSingles()
    {
        int index, place=0;
        FPgrowthSupportedSets nodeLink = startTempSets; // Start of linked list
       
        FPgrowthColumnCounts[] countArray = new
                                        FPgrowthColumnCounts[numOneItemSets+1];
       
        for (index=1;index<numOneItemSets+1;index++) countArray[index] =
                                new FPgrowthColumnCounts(index);
           
       
        while (nodeLink != null)
        {
                    for (index=0;index<nodeLink.itemSet.length;index++) {
                                place = nodeLink.itemSet[index];
                                countArray[place].support = countArray[place].support +
                                        nodeLink.support;
                                numUpdates++;
                    }
                    nodeLink = nodeLink.nodeLink;
        }    
                                                                         
        return(countArray);
        }

   
    private FPgrowthHeaderTable[]
                createLocalHeaderTable(FPgrowthColumnCounts[] countArray) {
        int index;
        FPgrowthHeaderTable[] localHeaderTable;
       
        localHeaderTable = localHeadTabUnordered(countArray);
       
       
        return(localHeaderTable);
        }              
   
   
    private FPgrowthHeaderTable[]
                localHeadTabUnordered(FPgrowthColumnCounts[] countArray)
    {
        int counter = 1;
       
        for (int index=1;index<countArray.length;index++)
        {
                if (countArray[index].support >= minSupport) counter++;
            }
           
        if (counter == 1) return(null);
        FPgrowthHeaderTable[] localHeaderTable =
                                        new FPgrowthHeaderTable[counter];
           
        int place=1;
                for (int index=1;index<countArray.length;index++)
                {
                    if (countArray[index].support >= minSupport)
                    {
                        localHeaderTable[place] = new
                            FPgrowthHeaderTable(( int) countArray[index].columnNum);    
                        place++;
                    }
                }    
       
                return(localHeaderTable);
        }


    private void orderLocalHeaderTable(FPgrowthHeaderTable[] localHeaderTable,
                                FPgrowthColumnCounts[] countArray)
    {          
                boolean isOrdered;
                FPgrowthHeaderTable temp;
                int index, place1, place2;
       
        do {
            index = 1;
            isOrdered=true;
            while (index < (localHeaderTable.length-1))
            {
                place1 = localHeaderTable[index].itemName;
                place2 = localHeaderTable[index+1].itemName;
                if (countArray[place1].support > countArray[place2].support)
                {
                        isOrdered=false;
                    temp = localHeaderTable[index];
                    localHeaderTable[index] = localHeaderTable[index+1];
                    localHeaderTable[index+1] = temp;
                    }
                index++;
            }
            }
        while (isOrdered==false);
        }
   
    private FPtreeNode generateLocalFPtree(FPgrowthHeaderTable[] tableRef)
    {
         FPgrowthSupportedSets ref = startTempSets;
         FPtreeNode localRoot = new FPtreeNode();
         
         while(ref != null) {    
                 if (ref.itemSet != null) addToFPtree(localRoot,0,ref.itemSet,
                                ref.support,tableRef);  
                ref = ref.nodeLink;
         }
         return(localRoot);
        }
       
       
    private FPtreeNode[] reallocFPtreeChildRefs(FPtreeNode[] oldArray,
                        FPtreeNode newNode) {    
        if (oldArray == null)
        {
                    FPtreeNode[] newArray = {newNode};
                    tempIndex = 0;
                    return(newArray);
            }
       
        int oldArrayLength = oldArray.length;
        FPtreeNode[] newArray = new FPtreeNode[oldArrayLength+1];
        for (int index1=0;index1 < oldArrayLength;index1++)
        {
                if (newNode.node.itemName < oldArray[index1].node.itemName)
                {
                        newArray[index1] = newNode;
                        for (int index2=index1;index2<oldArrayLength;index2++)
                                newArray[index2+1] = oldArray[index2];
                        tempIndex = index1;
                        return(newArray);
                }
                newArray[index1] = oldArray[index1];
            }
       
                newArray[oldArrayLength] = newNode;
                tempIndex = oldArrayLength;
                return(newArray);
        }
               
   
   
    public void outputItemPrefixSubtree() {
        int flag;
        System.out.println("PREFIX SUBTREE FROM HEADER TABLE");
        for(int index=1;index<headerTable.length;index++) {
            System.out.println("Header = " +
                               reconvertItem(headerTable[index].itemName));
            flag = outputItemPrefixTree(headerTable[index].nodeLink);
            if (flag!=1) System.out.println();
            }
        System.out.println();
        }
   
    private void outputItemPrefixSubtree(FPgrowthHeaderTable[] tableRef) {
        int flag;
        System.out.println("PREFIX SUBTREE FROM LOCAL HEADER TABLE");
        for(int index=1;index<tableRef.length;index++) {
            System.out.println("Header = " +
                                   reconvertItem(tableRef[index].itemName));
            flag = outputItemPrefixTree(tableRef[index].nodeLink);
            if (flag!=1) System.out.println();
            }
        System.out.println();
        }

    private int outputItemPrefixTree(FPgrowthItemPrefixSubtreeNode ref)
    {
        int counter = 1;
        while (ref != null)
        {
            System.out.print("(" + counter + ") " +
                    (reconvertItem(ref.itemName)) + ":" + ref.itemCount + " ");
            counter++;
            ref = ref.nodeLink;
            }
       
        return(counter);
        }
   
    public void outputFPtree()
    {
        System.out.println("FP TREE");
        outputFPtreeNode1();
        System.out.println();
        }
   
    private void outputFPtreeNode(FPtreeNode ref)
    {
        System.out.println("LOCAL FP TREE");
        outputFPtreeNode2(ref.childRefs,"");
        System.out.println();
        }

    private void outputFPtreeNode1()
    {
        outputFPtreeNode2(rootNode.childRefs,"");
    }

    private void outputFPtreeNode2(FPtreeNode ref[],String nodeID)
    {
        if (ref == null) return;
       
        for (int index=0;index<ref.length;index++)
        {
                    System.out.print("(" + nodeID + (index+1) + ") ");
                    outputItemPrefixSubtreeNode(ref[index].node);
                    outputFPtreeNode2(ref[index].childRefs,nodeID+(index+1)+".");
            }
        }
   
    public void outputItemPrefixSubtreeNode(FPgrowthItemPrefixSubtreeNode ref)
    {
        System.out.print((reconvertItem(ref.itemName)) + ":" + ref.itemCount);
        if (ref.nodeLink != null)
        {
                System.out.println(" (ref to " +
                                 (reconvertItem(ref.nodeLink.itemName)) + ":" +
                                                 ref.nodeLink.itemCount + ")");
            }  
        else System.out.println(" (ref to null)");
        }
   
   
    private void outputAncesterTrail()
    {
        int flag;
        System.out.println("ANCESTOR TRAIL FROM HEADER TABLE");
        for(int index=1;index<headerTable.length;index++)
        {
                System.out.println("Header = " +
                                 (reconvertItem(headerTable[index].itemName)));
                outputAncestorTrail1(headerTable[index].nodeLink);
            }
        System.out.println();
        }
   
    private void outputAncesterTrail(FPgrowthHeaderTable[] tableRef)
    {
        int flag;
        System.out.println("ANCESTOR TRAIL FROM LOCAL HEADER TABLE");
        for(int index=1;index<tableRef.length;index++)
        {
                System.out.println("Header = " +
                                    (reconvertItem(tableRef[index].itemName)));
                outputAncestorTrail1(tableRef[index].nodeLink);
            }
        System.out.println();
        }

   
    private void outputAncestorTrail1(FPgrowthItemPrefixSubtreeNode ref)
    {
        while (ref != null)
        {
                    System.out.print("\t");
                    outputAncestorTrail2(ref);
                    ref = ref.nodeLink;
                    System.out.println();
            }
        }

    private void outputAncestorTrail2(FPgrowthItemPrefixSubtreeNode ref)
    {
        while (ref != null)
        {
                System.out.print("(" + (reconvertItem(ref.itemName)) + ":" +
                                                        ref.itemCount + ") ");
                ref = ref.parentRef;
            }
        }
   
    public void outputFPtreeStorage()
    {
        int storage=8;  // 8 Bytes for root node
        numberOfNodes = 1;   // For root node
        storage = calculateStorage(rootNode.childRefs,storage);
       
       
        storage = storage + (headerTable.length*6);
        System.out.println("FP tree storage = " + storage + " (bytes)");
        System.out.println("FP tree updates = " + numUpdates);
        System.out.println("FP tree nodes   = " + numberOfNodes);
        }
   
    private int calculateStorage(FPtreeNode[] ref, int storage) {
        if (ref == null) return(storage);

       
        for (int index=0;index<ref.length;index++)
        {
                    storage = storage + 14 + 8;
                    numberOfNodes++;
                    storage = calculateStorage(ref[index].childRefs,storage);
            }
       
       
        return(storage);
        }
               
   
    private void outputColumnCount(FPgrowthColumnCounts[] countArray)
    {
        for(int index=1;index<countArray.length;index++)
        {
                System.out.print("Col " + countArray[index].columnNum + " : ");
                if (countArray[index].support == 0)
                                        System.out.println("Unsupported");
                else System.out.println(countArray[index].support);
            }
        System.out.println();
        }
}

