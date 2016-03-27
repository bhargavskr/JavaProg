/**
 *
 *
 * File:
 * Input files needed:
 *      1. config.txt - three lines, each line is an integer
 *          line 1 - number of items per transaction
 *          line 2 - number of transactions
 *          line 3 - minsup
 *      2. transa.txt - transaction file, each line is a transaction, items are separated by a space
 */

/*package apriori;*/
import java.io.*;
import java.util.*;

public class FPWeka {

    public static void main(String[] args) {
        FPGrowthCalculation fp = new FPGrowthCalculation();

        fp.fpProcess();
    }
}
/******************************************************************************
 * Class Name   : AprioriCalculation
 * Purpose      : generate Apriori itemsets
 *****************************************************************************/
class FPGrowthCalculation
{
    Vector<String> candidates=new Vector<String>(); //the current candidates
    String configFile="config.txt"; //configuration file
    String transaFile="transa.txt"; //transaction file
    String outputFile="weka-output.txt";//output file
    int numItems; //number of items per transaction
    int numTransactions; //number of transactions
    double minSup; //minimum support for a frequent itemset
    String oneVal[]; //array of value per column that will be treated as a '1'
    String itemSep = " "; //the separator value for items in the database

    /************************************************************************
     * Method Name  : aprioriProcess
     * Purpose      : Generate the apriori itemsets
     * Parameters   : None
     * Return       : None
     *************************************************************************/
    public void fpProcess()
    {
        Date d; //date object for timing purposes
        long start, end; //start and end time
        int itemsetNumber=0; //the current itemset being looked at
        //get config
        getConfig();

        System.out.println("FPGrowth algorithm has started.\n");

        //start timer
        d = new Date();
        start = d.getTime();

        //while not complete
    }

    /************************************************************************
     * Method Name  : getInput
     * Purpose      : get user input from System.in
     * Parameters   : None
     * Return       : String value of the users input
     *************************************************************************/
    public static String getInput()
    {
        String input="";
        //read from System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //try to get users input, if there is an error print the message
        try
        {
            input = reader.readLine();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return input;
    }

    /************************************************************************
     * Method Name  : getConfig
     * Purpose      : get the configuration information (config filename, transaction filename)
     *              : configFile and transaFile will be change appropriately
     * Parameters   : None
     * Return       : None
     *************************************************************************/
    private void getConfig()
    {
        FileWriter fw;
        BufferedWriter file_out;
        //oneVal=new String[5000]; 
        String input="";
		 Runtime rt=Runtime.getRuntime();
        //ask if want to change the config
        System.out.println("Default Configuration: ");
        System.out.println("\tRegular transaction file with '" + itemSep + "' item separator.");
        System.out.println("\tConfig File: " + configFile);
        System.out.println("\tTransa File: " + transaFile);
        System.out.println("\tOutput File: " + outputFile);
        System.out.println("\nPress 'C' to change the item separator, configuration file and transaction files");
        System.out.print("or any other key to continue.  ");
        input=getInput();
		oneVal=new String[10000];  
			 int count[]=new int[10000];
           String transac[]=new String[1000];
			  
		if(input.compareToIgnoreCase("c")==0)
        {
            System.out.print("Enter new transaction filename (return for '"+transaFile+"'): ");
            input=getInput();
            if(input.compareToIgnoreCase("")!=0)
                transaFile=input;

            System.out.print("Enter new configuration filename (return for '"+configFile+"'): ");
            input=getInput();
            if(input.compareToIgnoreCase("")!=0)
                configFile=input;

            System.out.print("Enter new output filename (return for '"+outputFile+"'): ");
            input=getInput();
            if(input.compareToIgnoreCase("")!=0)
                outputFile=input;

            System.out.println("Filenames changed");

            System.out.print("Enter the separating character(s) for items (return for '"+itemSep+"'): ");
            input=getInput();
            if(input.compareToIgnoreCase("")!=0)
                itemSep=input;


        }

        try
        {
             fw= new FileWriter(outputFile);
            file_out = new BufferedWriter(fw);
        
			FileInputStream file_in = new FileInputStream(configFile);
             BufferedReader data_in = new BufferedReader(new InputStreamReader(file_in));
             //number of items
			//   System.out.println("a"); 
             numItems=Integer.valueOf(data_in.readLine()).intValue();
             //  System.out.println("a");  
             //number of transactions
             numTransactions=Integer.valueOf(data_in.readLine()).intValue();
            // System.out.println("a"); 
             //minsup
             minSup=(Double.valueOf(data_in.readLine()).doubleValue());
              //   System.out.println("a"); 
             //output config info to the user
             System.out.print("\nInput configuration: "+numItems+" items, "+numTransactions+" transactions, ");
             System.out.println("minsup = "+minSup);
             System.out.println();
             
             //  System.out.println("a"); 
			 
			  // System.out.println("a"); 
                          
			  // System.out.println("a"); 
			 int flag=0;
			 
			  // System.out.println("a"); 
			   
              FileInputStream file_in1 = new FileInputStream(transaFile);
             BufferedReader data_in1 = new BufferedReader(new InputStreamReader(file_in1));     
			 int value_index=0;
			// System.out.println("read");
			// String First_line=data_in1.readLine();
			 // StringTokenizer st=new StringTokenizer(First_line);
            for(int i2=1;i2<=65000;i2++)
			 {
			          String header=new String();
					  header="@attribute 'API"+i2+"' { t}";
			 	file_out.write(header+"\n");	
			 }			 
			
			for(int i=0;i<numTransactions;i++)
			 {
			   String out=new String();
			  String First_line=data_in1.readLine();
			    // file_out.write(First_line); 
					List<String> list3=Arrays.asList(First_line.split(" "));             
                //  System.out.println(list3); 
				                
				for(int i1=1;i1<=65000;i1++)
                      { 
					  
					  StringBuilder x1=new StringBuilder();
					  x1.append(i1);
					        
					        String x=x1.toString();
//file_out.write(x);     
                 
					  if(list3.contains(x))
                            {
                                       out+="t,";
                            }									   
							else
                            {
                                   out+="?,";
                            } 								   

                      }							
								   
					file_out.write(out+"\n");			   
								   
			  
			 }
			
			file_out.close();
			  
	    }
		
         catch(Exception e)
		 {
		      System.out.println(e);
		}		
           
	}
}		
	   