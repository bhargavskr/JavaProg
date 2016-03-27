import java.io.*;
import java.util.*;

public class AssocRuleMining  {


    protected class RuleNode {
                protected  int[] antecedent;
                protected  int[] consequent;
                double confidenceForRule=0.0;
                RuleNode next = null;
               
                protected RuleNode( int[] ante,  int[]cons, double confValue)
                {
                    antecedent        = ante;
                    consequent        = cons;
                    confidenceForRule = confValue;
                }
        }
       
    protected RuleNode startRulelist = null;    
    protected  int[][] dataArray = null;
    protected int[][] conversionArray   = null;
    protected  int[] reconversionArray = null;
       
    private static final double MIN_SUPPORT = 0.0;
    private static final double MAX_SUPPORT = 100.0;
    private static final double MIN_CONFIDENCE = 0.0;
    private static final double MAX_CONFIDENCE = 100.0;
   
    protected String  fileName   = null;
    protected int     numCols    = 0;
    protected int     numRows    = 0;
    protected double  support    = 20.0;
    protected double  minSupport = 0;
    protected double  confidence = 80.0;
    protected int numOneItemSets = 0;

    protected boolean errorFlag  = true;
    protected boolean inputFormatOkFlag = true;
    private boolean haveDataFlag = false;
    protected boolean isOrderedFlag = false;
    protected boolean isPrunedFlag = false;

    protected BufferedReader fileInput;
    protected File filePath = null;

    public AssocRuleMining(String[] args)
    {

                for(int index=0;index<args.length;index++) idArgument(args[index]);
       
                if (errorFlag) CheckInputArguments();
                else outputMenu();
    }

    protected void idArgument(String argument) {

        if (argument.charAt(0) == '-') {
            char flag = argument.charAt(1);
            argument = argument.substring(2,argument.length());
            switch (flag) {
                case 'C':
                    confidence = Double.parseDouble(argument);
                    break;
                case 'F':
                    fileName = argument;
                    break;
                case 'S':
                    support = Double.parseDouble(argument);
                    break;
                default:
                    System.out.println("INPUT ERROR: Unrecognise command " +
                                "line  argument -" + flag + argument);
                    errorFlag = false;
                }
            }
        else {
            System.out.println("INPUT ERROR: All command line arguments " +
                                "must commence with a '-' character (" +
                                                        argument + ")");
            errorFlag = false;
            }
        }

    protected void CheckInputArguments()
    {

        checkSupportAndConfidence();

        checkFileName();

        if (errorFlag) outputSettings();
        else outputMenu();
        }

    protected void checkSupportAndConfidence()
    {
        if ((support < MIN_SUPPORT) || (support > MAX_SUPPORT))
        {
                        System.out.println("INPUT ERROR: Support must be specified " +
                                                "as a percentage (" + MIN_SUPPORT +
                                                        " - " + MAX_SUPPORT + ")");
                    errorFlag = false;
            }
        if ((confidence < MIN_CONFIDENCE) || (confidence > MAX_CONFIDENCE))
        {
                        System.out.println("INPUT ERROR: Confidence must be " +
                                       "specified as a percentage (" + MIN_CONFIDENCE +
                                                " - " + MAX_CONFIDENCE + ")");
                    errorFlag = false;
            }
        }

    protected void checkFileName()
    {
                if (fileName == null)
                {
                    System.out.println("INPUT ERROR: Must specify file name (-F)");
                    errorFlag = false;
                }
        }

    public void inputDataSet()
    {
        readFile();

                if (inputFormatOkFlag)
                {
                    if (checkOrdering())
                    {
                        System.out.println("Number of records = " + numRows);
                        countNumCols();
                        System.out.println("Number of columns = " + numCols);
                        minSupport = (numRows * support)/100.0;
                        System.out.println("Min support       = " +
                                        twoDecPlaces(minSupport) + " (records)");
                        }
                    else
                    {
                        System.out.println("Error reading file: " + fileName + "\n");
                        closeFile();
                        System.exit(1);
                        }
                }
        }

    protected void readFile()
    {
        try
        {
                    inputFormatOkFlag=true;
                    numRows = getNumberOfLines(fileName);
                    if (inputFormatOkFlag)
                    {
                        dataArray = new  int[numRows][];
                        System.out.println("Reading input file: " + fileName);
                        readInputDataSet();
                        }
                    else
                        System.out.println("Error reading file: " + fileName + "\n");
                }
        catch(IOException ioException)
        {
                    System.out.println("Error reading File");
                    closeFile();
                    System.exit(1);
            }
        }

    protected int getNumberOfLines(String nameOfFile) throws IOException
    {
        int counter = 0;

        if (filePath==null) openFileName(nameOfFile);
        else openFilePath();

        String line = fileInput.readLine();
        while (line != null)
        {
                    checkLine(counter+1,line);
                    StringTokenizer dataLine = new StringTokenizer(line);
                int numberOfTokens = dataLine.countTokens();
                    if (numberOfTokens == 0) break;
                    counter++;
                    line = fileInput.readLine();
            }

        closeFile();
        return(counter);
        }

    protected void checkLine(int counter, String str)
    {

        for (int index=0;index <str.length();index++)
        {
            if (!Character.isDigit(str.charAt(index)) &&
                                !Character.isWhitespace(str.charAt(index)))
            {
                System.err.println("FILE INPUT ERROR:\n" +
                                        "charcater on line " + counter +
                                        " is not a digit or white space");
                inputFormatOkFlag = false;
                haveDataFlag = false;
                break;
            }
            }
        }


    public void readInputDataSet() throws IOException {
        readInputDataSet(fileName);
        }


    protected void readInputDataSet(String fName) throws IOException {
        int rowIndex=0;

        if (filePath==null) openFileName(fName);
        else openFilePath();

        String line = fileInput.readLine();

        while (line != null) {
            if (!processInputLine(line,rowIndex)) break;
            rowIndex++;
            line = fileInput.readLine();
            }

        closeFile();
        }


    protected void readInputDataSetSeg(String fName, int startRowIndex,
                                        int endRowIndex) throws IOException {
        int rowIndex=startRowIndex;

        if (filePath==null) openFileName(fName);
        else openFilePath();

        String line = fileInput.readLine();
        for (int index=startRowIndex;index<endRowIndex;index++) {
            processInputLine(line,index);
            line = fileInput.readLine();
            }

        closeFile();
        }


    private boolean processInputLine(String line, int rowIndex) {
        if (line==null) return(false);

        StringTokenizer dataLine = new StringTokenizer(line);
        int numberOfTokens = dataLine.countTokens();

        if (numberOfTokens == 0) return(false);

         int[] code = binConversion(dataLine,numberOfTokens);

        int codeLength = code.length;
        dataArray[rowIndex] = new  int[codeLength];
        for (int colIndex=0;colIndex<codeLength;colIndex++)
                                dataArray[rowIndex][colIndex] = code[colIndex];

        return(true);
        }


    protected boolean checkOrdering() {
        boolean result = true;

        for(int index=0;index<dataArray.length;index++) {
            if (!checkLineOrdering(index+1,dataArray[index])) {
                haveDataFlag = false;
                result=false;
                }
            }

        return(result);
        }


    protected boolean checkLineOrdering(int lineNum,  int[] itemSet) {
        for (int index=0;index<itemSet.length-1;index++) {
                    if (itemSet[index] >= itemSet[index+1])
                    {
                        System.err.println("FILE FORMAT ERROR:\n" +
                                        "Attribute data in line " + lineNum +
                                                " not in numeric order");
                        return(false);
                        }
        }

        return(true);
        }

    protected void countNumCols()
    {
        int maxAttribute=0;

        for(int index=0;index<dataArray.length;index++)
        {
                    int lastIndex = dataArray[index].length-1;
                    if (dataArray[index][lastIndex] > maxAttribute)
                                maxAttribute = dataArray[index][lastIndex];
            }
                numCols        = maxAttribute;
                numOneItemSets = numCols;       // default value only
        }

    protected void openFileName(String nameOfFile)
    {
                try
                {
                    FileReader file = new FileReader(nameOfFile);
                    fileInput = new BufferedReader(file);
                }
                catch(IOException ioException)
                {
                        System.err.println("Error Opening File");
                    System.exit(1);
                }
        }

    protected void openFilePath() {
        try
        {
                    FileReader file = new FileReader(filePath);
                    fileInput = new BufferedReader(file);
            }
        catch(IOException ioException)
        {
                        System.err.println("Error Opening File");
                    System.exit(1);
            }
    }

    protected void closeFile() {
        if (fileInput != null) {
            try {
                fileInput.close();
                }
            catch (IOException ioException) {
                System.err.println("Error Closing File");
                System.exit(1);
                }
            }
        }

    protected  int[] binConversion(StringTokenizer dataLine,
                                int numberOfTokens)
    {
         int number;
         int[] newItemSet = null;

        for (int tokenCounter=0;tokenCounter < numberOfTokens;tokenCounter++)
        {
            number = Integer.parseInt(dataLine.nextToken());
            newItemSet = realloc1(newItemSet,number);
            }

        return(newItemSet);
        }

    public void idInputDataOrdering()
    {
       
            int[][] countArray = countSingles();
               
                orderCountArray(countArray);
               
                defConvertArrays(countArray);
               
                isOrderedFlag = true;
        }
           
    protected int[][] countSingles()
    {
       
                int[][] countArray = new int[numCols+1][2];
                for (int index=0;index<countArray.length;index++)
                {
                    countArray[index][0] = index;
                    countArray[index][1] = 0;
                }
                   
                for(int rowIndex=0;rowIndex<dataArray.length;rowIndex++)
                {
                        if (dataArray[rowIndex] != null)
                        {
                                for (int colIndex=0;colIndex<dataArray[rowIndex].length;
                                        colIndex++)
                        countArray[dataArray[rowIndex][colIndex]][1]++;
                        }
            }
       
                return(countArray);
        }
       
       
    private void orderCountArray(int[][] countArray)
    {
        int attribute, quantity;        
        boolean isOrdered;
        int index;
               
        do {
            isOrdered = true;
            index     = 1;
            while (index < (countArray.length-1))
            {
                if (countArray[index][1] >= countArray[index+1][1]) index++;
                else
                {
                            isOrdered=false;
                            attribute              = countArray[index][0];
                            quantity               = countArray[index][1];
                            countArray[index][0]   = countArray[index+1][0];
                            countArray[index][1]   = countArray[index+1][1];
                        countArray[index+1][0] = attribute;
                            countArray[index+1][1] = quantity;
                            index++;  
                    }
            }    
            } while (isOrdered==false);
    }
   
    protected void orderFirstNofCountArray(int[][] countArray, int endIndex)
    {
        int attribute, quantity;
        boolean isOrdered;
        int index;

        do {
                    isOrdered = true;
                index     = 1;
            while (index < endIndex)
            {
                if (countArray[index][1] >= countArray[index+1][1]) index++;
                else
                {
                            isOrdered=false;
                                    attribute              = countArray[index][0];
                                    quantity               = countArray[index][1];
                            countArray[index][0]   = countArray[index+1][0];
                            countArray[index][1]   = countArray[index+1][1];
                        countArray[index+1][0] = attribute;
                            countArray[index+1][1] = quantity;
                            index++;
                    }
            }
            } while (isOrdered==false);
    }

    protected void defConvertArrays(int[][] countArray)
    {

        conversionArray   = new int[numCols+1][2];
        reconversionArray = new  int[numCols+1];

        for(int index=1;index<countArray.length;index++)
        {
            conversionArray[countArray[index][0]][0] = index;
            conversionArray[countArray[index][0]][1] = countArray[index][1];
            reconversionArray[index] = ( int) countArray[index][0];
            }

        }

    public void recastInputData()
    {
         int[] itemSet;
        int attribute;


        for(int rowIndex=0;rowIndex<dataArray.length;rowIndex++)
        {
                    itemSet = new  int[dataArray[rowIndex].length];
                    for(int colIndex=0;colIndex<dataArray[rowIndex].length;colIndex++)
                    {
                        attribute = dataArray[rowIndex][colIndex];
                        itemSet[colIndex] = ( int) conversionArray[attribute][0];
                        }
                    sortItemSet(itemSet);
                    dataArray[rowIndex] = itemSet;
            }
        }

    public void recastInputDataAndPruneUnsupportedAtts()
    {
         int[] itemSet;
        int attribute;

        for(int rowIndex=0;rowIndex<dataArray.length;rowIndex++)
        {
                    if (dataArray[rowIndex]!= null)
                    {
                        itemSet = null;
                        for(int colIndex=0;colIndex<dataArray[rowIndex].length;colIndex++)
                        {
                            attribute = dataArray[rowIndex][colIndex];
                                    if (conversionArray[attribute][1] >= minSupport)
                                    {
                                        itemSet = reallocInsert(itemSet,
                                                        ( int) conversionArray[attribute][0]);
                                    }
                            }
                        dataArray[rowIndex] = itemSet;
                        }
        }

        isPrunedFlag=true;
        numOneItemSets = getNumSupOneItemSets();
        }

    protected int getNumSupOneItemSets()
    {
        int counter = 0;


        for (int index=1;index < conversionArray.length;index++)
        {
                if (conversionArray[index][1] >= minSupport) counter++;
            }

                return(counter);
        }

    public void resizeInputData(double percentage)
    {
        numRows = (int) ((double) numRows*(percentage/100.0));
        System.out.println("Recast input data, new num rows = " + numRows);

         int[][] trainingSet = new  int[numRows][];
        for (int index=0;index<numRows;index++)
                                trainingSet[index] = dataArray[index];

        dataArray = trainingSet;

        minSupport = (numRows * support)/100.0;
        }

    protected  int[] reconvertItemSet( int[] itemSet)
    {
        if (reconversionArray==null) return(itemSet);
       
        if (itemSet==null) return(null);
       
         int[] newItemSet = new  int[itemSet.length];
       
        for(int index=0;index<newItemSet.length;index++) {
                    newItemSet[index] = reconversionArray[itemSet[index]];
            }
       
        return(newItemSet);    
    }

    protected  int reconvertItem( int item)
    {
        if (reconversionArray==null) return(item);
       
        return(reconversionArray[item]);
        }
       
    protected void insertRuleintoRulelist( int[] antecedent,
                                 int[] consequent, double confidenceForRule)
    {
                RuleNode newNode = new RuleNode(antecedent,consequent,
                                                                confidenceForRule);
                if (startRulelist == null) {
                    startRulelist = newNode;
                    return;
                    }
       
                if (confidenceForRule > startRulelist.confidenceForRule)
                {
                    newNode.next = startRulelist;
                    startRulelist  = newNode;
                    return;
                }
       
                RuleNode markerNode = startRulelist;
                RuleNode linkRuleNode = startRulelist.next;
                while (linkRuleNode != null)
                {
                    if (confidenceForRule > linkRuleNode.confidenceForRule)
                    {
                        markerNode.next = newNode;
                        newNode.next    = linkRuleNode;
                        return;
                        }
                        markerNode = linkRuleNode;
                        linkRuleNode = linkRuleNode.next;
                }
       
                markerNode.next = newNode;
        }

    protected  int[] reallocInsert( int[] oldItemSet,  int newElement)
    {
                if (oldItemSet == null)
                {
                     int[] newItemSet = {newElement};
                    return(newItemSet);
                }
       
                int oldItemSetLength = oldItemSet.length;
                 int[] newItemSet = new  int[oldItemSetLength+1];
       
       
                int index1;
                for (index1=0;index1 < oldItemSetLength;index1++)
                {
                    if (newElement < oldItemSet[index1])
                    {
                                newItemSet[index1] = newElement;
                                for(int index2 = index1+1;index2<newItemSet.length;index2++)
                                                newItemSet[index2] = oldItemSet[index2-1];
                                return(newItemSet);
                        }
                        else newItemSet[index1] = oldItemSet[index1];
                }
       
                newItemSet[newItemSet.length-1] = newElement;
       
                return(newItemSet);
        }

    protected  int[] realloc1( int[] oldItemSet,  int newElement)
    {
                if (oldItemSet == null) {
                     int[] newItemSet = {newElement};
                    return(newItemSet);
                    }
       
                int oldItemSetLength = oldItemSet.length;
                 int[] newItemSet = new  int[oldItemSetLength+1];
       
                int index;
                for (index=0;index < oldItemSetLength;index++)
                        newItemSet[index] = oldItemSet[index];
                newItemSet[index] = newElement;
       
                return(newItemSet);
        }

    protected  int[] realloc2( int[] oldItemSet,  int newElement)
    {
                if (oldItemSet == null) {
                     int[] newItemSet = {newElement};
                    return(newItemSet);
                    }
       
                int oldItemSetLength = oldItemSet.length;
                 int[] newItemSet = new  int[oldItemSetLength+1];
       
                newItemSet[0] = newElement;
                for (int index=0;index < oldItemSetLength;index++)
                        newItemSet[index+1] = oldItemSet[index];
       
                return(newItemSet);
        }
       
    protected  int[] removeElementN( int [] oldItemSet, int n)
    {
        if (oldItemSet.length <= n)
                return(oldItemSet);
        else
        {
                 int[] newItemSet = new  int[oldItemSet.length-1];
                for (int index=0;index<n;index++)
                        newItemSet[index] =     oldItemSet[index];
                for (int index=n+1;index<oldItemSet.length;index++)
                        newItemSet[index-1] = oldItemSet[index];
                return(newItemSet);
            }
        }
       
   
    protected  int[] complement( int[] itemSet1,  int[] itemSet2)
    {
        int lengthOfComp = itemSet2.length-itemSet1.length;
       
        if (lengthOfComp<1) return(null);
       
         int[] complement  = new  int[lengthOfComp];
        int complementIndex = 0;
        for(int index=0;index<itemSet2.length;index++) {
            if (notMemberOf(itemSet2[index],itemSet1)) {
                complement[complementIndex] = itemSet2[index];
                complementIndex++;
                }      
            }
       
        return(complement);
        }

    protected void sortItemSet( int[] itemSet)
    {
         int temp;
        boolean isOrdered;
        int index;

        do
        {
                isOrdered = true;
                index     = 0;
            while (index < (itemSet.length-1))
            {
                if (itemSet[index] <= itemSet[index+1])
                        index++;
                else
                {
                        isOrdered=false;
                        temp = itemSet[index];
                        itemSet[index] = itemSet[index+1];
                    itemSet[index+1] = temp;
                    index++;
                    }
            }
            } while (isOrdered==false);
    }  

   
    protected boolean notMemberOf( int number,  int[] itemSet)
    {
       
                for(int index=0;index<itemSet.length;index++)
                {
                    if (number < itemSet[index]) return(true);
                    if (number == itemSet[index]) return(false);
                }
               
                return(true);
        }


    protected  int[][] combinations( int[] inputSet)
    {
        if (inputSet == null) return(null);
        else
        {
                     int[][] outputSet = new  int[getCombinations(inputSet)][];
                    combinations(inputSet,0,null,outputSet,0);
                    return(outputSet);
            }
        }


    private int combinations( int[] inputSet, int inputIndex,
                 int[] sofar,  int[][] outputSet, int outputIndex)
    {
         int[] tempSet;
        int index=inputIndex;

        while(index < inputSet.length)
        {
            tempSet = realloc1(sofar,inputSet[index]);
            outputSet[outputIndex] = tempSet;
            outputIndex = combinations(inputSet,index+1,
                copyItemSet(tempSet),outputSet,outputIndex+1);
            index++;
            }

        return(outputIndex);
    }  

    private int getCombinations( int[] set)
    {
        int counter=0, numComb;

        numComb = (int) Math.pow(2.0,set.length)-1;
           
        return(numComb);
    }

    protected  int[] copyItemSet( int[] itemSet)
    {
        if (itemSet == null) return(null);
       
         int[] newItemSet = new  int[itemSet.length];
        for(int index=0;index<itemSet.length;index++)
        {
                newItemSet[index] = itemSet[index];
            }        
        return(newItemSet);
        }

    public void outputDataArray()
    {
        if (isPrunedFlag)
                System.out.println("DATA SET (Ordered and Pruned)\n" +
                                        "-----------------------------");
        else {
                if (isOrderedFlag)
                        System.out.println("DATA SET (Ordered)\n" +
                                        "------------------");
                else System.out.println("DATA SET\n" + "--------");
            }

        for(int index=0;index<dataArray.length;index++)
        {
                    outputItemSet(dataArray[index]);
                    System.out.println();
            }
        }

    protected void outputDataArray( int[][] dataSet)
    {
        if (dataSet==null)
        {
                System.out.println("null");
                return;
            }

        for(int index=0;index<dataSet.length;index++)
        {
                outputItemSet(dataSet[index]);
                System.out.println();
            }
        }

    protected void outputItemSet( int[] itemSet)
    {
        if (itemSet == null) System.out.print(" null ");
        else {
                 int[] tempItemSet = reconvertItemSet(itemSet);
            int counter = 0;
            for (int index=0;index<tempItemSet.length;index++)
            {
                if (counter == 0)
                {
                    counter++;
                    System.out.print(" {");
                }
                else System.out.print(" ");
                System.out.print(tempItemSet[index]);
                }
            System.out.print("} ");
            }
        }

    public void outputDataArraySize()
    {
        int numRecords = 0;
        int numElements = 0;

        for (int index=0;index<dataArray.length;index++)
        {
                if (dataArray[index] != null)
                {
                        numRecords++;
                        numElements = numElements+dataArray[index].length;
                }
            }
        System.out.println("Number of records        = " + numRecords);
        System.out.println("Number of elements       = " + numElements);
        double density = (double) numElements/ (numCols*numRecords);
        System.out.println("Data set density   = " + twoDecPlaces(density) +
                                                                "%");
        }

    public void outputConversionArrays()
    {
        System.out.println("Conversion Array = ");
        for(int index=1;index<conversionArray.length;index++)
        {
                System.out.println("(" + index + ") " + conversionArray[index][0] +
                                " = " + conversionArray[index][1]);
            }

        System.out.println("Reonversion Array = ");
        for(int index=1;index<reconversionArray.length;index++)
        {
                System.out.println("(" + index + ") " + reconversionArray[index]);
            }
        }


    protected void outputMenu()
    {
        System.out.println();
        System.out.println("-F  = File name");
        System.out.println("-S  = Support (default 20%)");
        System.out.println();
        System.exit(1);
        }


    protected void outputSettings()
    {
        System.out.println("SETTINGS\n--------");
        System.out.println("File name                = " + fileName);
        System.out.println("Support (default 20%)    = " + support);
        System.out.println();
    }


    protected void outputSettings2()
    {
        System.out.println("SETTINGS\n--------");
        System.out.println("Number of records        = " + numRows);
        System.out.println("Number of columns        = " + numCols);
        System.out.println("Support (default 20%)    = " + support);
        System.out.println("Confidence (default 80%) = " + confidence);
        System.out.println("Min support              = " + minSupport +
                                        " (records)");
        System.out.println("Num one itemsets         = " + numOneItemSets);
        }


    public void outputSuppAndConf()
    {
        System.out.println("Support = " + twoDecPlaces(support) +
                        ", Confidence = " + twoDecPlaces(confidence));
    }
       
    public void outputRules() {
        outputRules(startRulelist);
        }
       
    public void outputRules(RuleNode ruleList)
    {
        if (ruleList==null) System.out.println("No rules generated!");
       
        int number = 1;
        RuleNode linkRuleNode = ruleList;
        while (linkRuleNode != null)
        {
                System.out.print("(" + number + ") ");
                outputRule(linkRuleNode);
            System.out.println(" " +
                        twoDecPlaces(linkRuleNode.confidenceForRule) + "%");
            number++;
            linkRuleNode = linkRuleNode.next;
            }
        }

    private void outputRule(RuleNode rule)
    {
        outputItemSet(rule.antecedent);
        System.out.print(" -> ");
        outputItemSet(rule.consequent);
        }

    public void outputRulesWithDefault()
    {
        int number = 1;
        RuleNode linkRuleNode = startRulelist;

        while (linkRuleNode != null)
        {
                System.out.print("(" + number + ") ");
                if (linkRuleNode.next==null) System.out.print("Default -> ");
                else {
                        outputItemSet(linkRuleNode.antecedent);
                        System.out.print(" -> ");
                }
            outputItemSet(linkRuleNode.consequent);
            System.out.println(" " +
                        twoDecPlaces(linkRuleNode.confidenceForRule) + "%");
            number++;
            linkRuleNode = linkRuleNode.next;
            }
        }
                       
    public double outputDuration(double time1, double time2)
    {
        double duration = (time2-time1)/1000;
        System.out.println("Generation time = " + twoDecPlaces(duration) +
                        " seconds (" + twoDecPlaces(duration/60) + " mins)");
        return(duration);
        }

    protected double twoDecPlaces(double number)
    {
        int numInt = (int) ((number+0.005)*100.0);
        number = ((double) numInt)/100.0;
        return(number);
        }    
}


