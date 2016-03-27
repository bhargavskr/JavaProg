
/**
 *
 * @author Nathan Magnus, under the supervision of Howard Hamilton
 * Copyright: University of Regina, Nathan Magnus and Su Yibin, June 2009.
 * No reproduction in whole or part without maintaining this copyright notice
 * and imposing this condition on any subsequent users.
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

public class FPGrowth1 {

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
    String transaFile="textbookexample.txt"; //transaction file
    String outputFile="FP-output.txt";//output file
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
			 
			 for(int i=0;i<numTransactions;i++)
			 {
			  String First_line=data_in1.readLine();
		        transac[i]=First_line;  
         		StringTokenizer st=new StringTokenizer(First_line);
			//   System.out.println("a1");
			    if(i!=0)
                { 
                   while(st.hasMoreTokens())  
                   {				   
				//    System.out.println("a3");
                     String File_ID=st.nextToken();   
                        flag=0;
			           for(int k=0;k<=value_index-1;k++)
					   { 
					    //   System.out.println(k);
					      if(File_ID.equals(oneVal[k]))
						  {
						//   System.out.println("a6");
  						     flag=1;
						     count[k]++;
						     break;
						  }
                        }  
                             if(flag==0)
							 {
					//	  System.out.println("a5");
						      count[value_index]++;    
                              oneVal[value_index]=File_ID;
						      value_index++; 
						     }
						   
					}
                }       
                
              				
                else
                {				
         //      int a=0;				
				  while(st.hasMoreTokens())
			      {
				
			//	  System.out.println("a"+a);
			      count[value_index]++; 
			      oneVal[value_index]=st.nextToken();
				  value_index++;
				//  System.out.println("a8"); 
			  //    a++;
				  }
			 } 
			}
			//System.out.println("a21");
		System.out.println("1 item set's items "+value_index);				 
       for(int e=0;e<=value_index-1;e++)
		{          for(int r=0;r<=(value_index-(e+1));r++)
			{
				if((count[r])<(count[r+1]))
				{
					String s1=new String();
					int x;
					s1=oneVal[r];
					//System.out.println(s1);
					oneVal[r]=oneVal[r+1];
					oneVal[r+1]=s1;
					x=count[r];
					
					count[r]=count[r+1];
					count[r+1]=x;
				}
			}
		}             				
       int threshold_index=0;
       int b;
       for(b=0;b<=value_index-1;b++)
       {
            if(count[b]<minSup) 
            {
		         threshold_index=b;	
                  break;
				  
            }
           else if(b==value_index-1)
                 threshold_index=value_index;		   
	   }
	   for(int w=threshold_index;w<oneVal.length;w++)
	   {
	           oneVal[w]=null;
			Integer m=new  Integer(count[w]);
		       m=null;
		}
          rt.gc();		
	   System.gc();
	   //System.out.println("1 item threshold "+threshold_index);
	  System.out.println(" End of 1 frequent Itemset");						

	   for(int m=0;m<=threshold_index-1;m++)
             {
		//	 System.out.println("a9");
                 file_out.write("File ID is "+oneVal[m]+" and its count is "+count[m]+" and "+m+ "\n");
			    
			 }
/*********************************************************************************************1 frequent item set obtained and Conditional pattern base**************************************************************************************/	

int support=0;
int flag1=0;
String Str2[]=new String[numTransactions];

ArrayList<String> Arraylist=new ArrayList<String>();
for(int l=0;l<threshold_index;l++)
Arraylist.add(oneVal[l]);
 // List<String> array1=Arrays.asList(str.split(" "));
file_out.write("Contenst of list"+Arraylist+"\n");
HashMap<String,Integer> tree=new HashMap<String,Integer>();
// ArrayList<String> CheckArraylist=new ArrayList<String>();
Set<Map.Entry<String,Integer>> set=tree.entrySet();
//System.out.println("Contenst of STring"+array1);
for(int i=0;i<numTransactions;i++)
{
if(i==0)
flag1=1;
if(i==1)
flag1=0;

System.out.println(i);
 List<String> list=Arrays.asList(transac[i].split(" "));
 ArrayList<String> Arraylist1=new ArrayList<String>();
	for(String y:Arraylist)
	{
  
  if(list.contains(y))
	{        
		 Arraylist1.add(y);
		 
	}

  
  
	}
//System.out.println("Contenst of 0 "+Arraylist1.get(0));  


for(String n : Arraylist1)
{
if(Arraylist1.indexOf(n)==0)
Str2[i]=n+ " ";
else
Str2[i]+=  n +" ";
}
file_out.write("Transaction "+i+" Conatins String Form "+Str2[i]+"\n");  



/*for(int j=0;j<Arraylist1.size();j++)
{

      String key=Arraylist1.get(j);
        
        if(flag1==1)
        {
		            tree.put(Arraylist1.get(j),1);    
		}
        else	
		{ 
		       			   
			//	System.out.println("key hash"+x.getKey());
				  if(tree.containsKey(key)) 
                  {                            
				     
				    support=tree.get(key); 
                     support++;					
		            //tree.remove(key);
					tree.put(key,support);
					//System.out.println(key+":"+support);
        		  }        
				  else
				  {
				     
				     tree.put(key,1);  
				  }
				
		 }
 
}*/

		     
//Set<Map.Entry<String,Integer>> me=tree.entrySet();
//	for(Map.Entry<String,Integer> x:set)
	//	System.out.println(x.getKey()+":"+x.getValue());
		
	
System.out.println(" Transactions that contain minimum support elements"+Arraylist1);
}

/**************************************************************************************************Conditional FP tree******************************************************************************************/

HashMap<String,Integer> tree1=new HashMap<String,Integer>();
int support1=0;
int p=Arraylist.size();

for(int k=p-1;k>0;k--)
{
  String x=Arraylist.get(k);
 // System.out.println("Element"+x);
   for(int s=0;s<Str2.length;s++)
   {
               String Str3=new String();
                 Str3=" ";                 
				 List<String> list1=Arrays.asList(Str2[s].split(" "));
           //    System.out.println("List"+list1);
	          if(list1.contains(x))
                {
                   int o=list1.indexOf(x);
				 file_out.write("index"+o);
			
				   for(int r=0;r<o;r++)
                    {
					      if(r==0)
							Str3=list1.get(r)+ " ";
						else
							Str3+=list1.get(r)+" ";
					}
		      file_out.write(" After removal of "+x+" List "+Str3+"\n");			
			/*		for(String c:list1)
					{
						if(list1.indexOf(c)==0)
							Str3=c+ " ";
						else
							Str3+=c+" ";
					}*/
					if(tree1.containsKey(Str3) && Str3!=" ") 
                  {                            
				     
				    support1=tree1.get(Str3); 
                     support1++;					
		            tree1.remove(Str3);
					tree1.put(Str3,support1);
					//System.out.println(key+":"+support);
        		  }        
				  else if(Str3!=" ")
				  {
				     
				     tree1.put(Str3,1);  
				  }
					
				}		
					
                
	} 
				 
		Set<Map.Entry<String,Integer>> set1=tree1.entrySet();
	for(Map.Entry<String,Integer> x1:set1)
		file_out.write("FP Conditional base for "+x+" is ::"+x1.getKey()+":"+x1.getValue()+"\n");	
      		
/************************************************************************************gOt conditional pattern base*************************************************************************************************/					
   
     String Str4[]=new String[tree1.size()];        
    int    sup[]=new int[tree1.size()];   
	int j=0;          
	//Set<Map.Entry<String,Integer>> set1=tree.entrySet();
	for(Map.Entry<String,Integer> x1:set1)
	{
    	System.out.println("Processing for FP tree conditional "+x1.getKey()+":"+x1.getValue());			
                Str4[j]=x1.getKey();
				sup[j]=x1.getValue();
	             j++;
	} 
           
   HashMap<String,Integer> tree2=new HashMap<String,Integer>();
int support2=0;

    //          System.out.println("Check");

for(int k1=0;k1<Arraylist.size();k1++)
{
  String x1=Arraylist.get(k1);
  //file_out.write("Element"+x1+"\n");
   for(int s1=0;s1<Str4.length;s1++)
   {
           String Str5=new String();
		   Str5=" ";
           List<String> list2=Arrays.asList(Str4[s1].split(" "));
           //    System.out.println("List"+list1);
	          if(list2.contains(x1))
                {
                   int o1=list2.indexOf(x1);
		               file_out.write("index"+o1);
			
				   for(int r1=0;r1<=o1;r1++)
                    {
					      if(r1==0)
							Str5=list2.get(r1)+ " ";
						else
							Str5+=list2.get(r1)+" ";
					}
		      file_out.write(" After removal from tree "+x1+" List "+Str5+"\n");			
			/*		for(String c:list1)
					{
						if(list1.indexOf(c)==0)
							Str3=c+ " ";
						else
							Str3+=c+" ";
					}*/
					if(tree2.containsKey(Str5) && Str5!=" ") 
                  {                            
				     
				    support2=tree2.get(Str5); 
                     support2+=sup[s1];					
		            tree2.remove(Str5);
					tree2.put(Str5,support2);
					//System.out.println(key+":"+support);
        		  }        
				  else if(Str5!=" ")
				  {
				     
				     tree2.put(Str5,sup[s1]);  
				  }
					
				}		
					

	} 
	//Set<Map.Entry<String,Integer>> set2=tree2.entrySet();
	//for(Map.Entry<String,Integer> x2:set2)
//		file_out.write("FP Conditional tree for "+x1+"is : "+x2.getKey()+" : "+x2.getValue()+"\n");		
		
   }// tree conditional close
   		 
      //   System.out.println("Check");
	
   
   
 		Set<Map.Entry<String,Integer>> set2=tree2.entrySet();
	/* System.out.println("Check");
	for(Map.Entry<String,Integer> x2:set2)
	{
	 System.out.println("Check 3");
	       int value=x2.getValue();
		   String key=x2.getKey();
		    System.out.println("Check");
         System.out.println("FP Conditional tree for is : "+key+" : "+value+"\n");	
      	 
		 file_out.write("FP Conditional tree for is : "+key+" : "+value+"\n");	
      	    System.out.println("Check");
		   if(value<minSup)
					value=tree2.remove(key);
  			System.out.println("Check 8");
		   
            
   }
             System.out.println("Check");
*/
   
   for(Map.Entry<String,Integer> x2:set2)
	     file_out.write("FP Conditional tree  is: "+x2.getKey()+" : "+x2.getValue()+"\n");	
ArrayList<String> Str6=new ArrayList<String>();
ArrayList<Integer> sup1=new ArrayList<Integer>();

	//	 String Str6[]=new String[tree2.size()];        
    //int    sup1[]=new int[tree2.size()];   
	         
	//Set<Map.Entry<String,Integer>> set1=tree.entrySet();
	for(Map.Entry<String,Integer> x3:set2)
	{
    //	System.out.println("Processing for FP tree conditional "+x1.getKey()+":"+x1.getValue());			
              if(x3.getValue()>=minSup)
			  {
    			  Str6.add(x3.getKey());
				sup1.add(x3.getValue());
	             
			}	 
	} 
  for(int g4=0;g4<Str6.size();g4++)
		   {
System.out.println("Str 6 "+Str6.get(g4)+" Support "+sup1.get(g4));		     

}
	// System.out.println("Check");
   HashMap<String,Integer> tree3=new HashMap<String,Integer>();
int support3=0;
		  for(int g=0;g<Str6.size();g++)
		   {
		         
		      System.out.println(" Str 6 lenght"+Str6.size());
		     List<String> list3=Arrays.asList(Str6.get(g).split(" "));
               for(int g1=0;g1<list3.size();g1++)
			   { 
			          System.out.println("List 3 size"+list3.size());
			   System.out.println("G value"+g+" G1 value "+g1);
			  			String Str7=new String();
					  int ind=g1;
					  String Str8=new String();
          		 if(Arraylist.contains(list3.get(g1)))
				{
				}		
			     	  for(int g2=0;g2<=ind;g2++)
					  {
					       System.out.println("G2 value"+g2);
                          Str8=list3.get(g1)+" ";    
					      if(g2==0)
							Str7=list3.get(g2)+ " ";
						else
							Str7+=list3.get(g2)+" ";
					
					  }   
						System.out.println("Str8 "+Str8+"Str 7"+Str7);
						   if(tree3.containsKey(Str8))  
				          {
                             support3=tree3.get(Str8);
                             if(support3<sup1.get(g))
                             {
                                 support3=sup1.get(g);  		 					 
				             }
							 else if(support3==sup1.get(g) && g1!=0)
						     {
							       support3=support3+sup1.get(g);
                              }							 
							  tree3.remove(Str8);
							  tree3.put(Str8,support3);
						} 
                          else
                          {
						     tree3.put(Str8,sup1.get(g));
                          }
						  
						  System.out.println("Check1");
						  
						  if(!tree3.containsKey(Str7))  
				          {
                            
						     tree3.put(Str7,sup1.get(g));
                          }
	System.out.println("Check2");					  
				
			   }
		   
		   }
 		Set<Map.Entry<String,Integer>> set3=tree3.entrySet();
     
		for(Map.Entry<String,Integer> x4:set3)
		file_out.write("FP tree Conditional Modified  "+x+" is ::"+x4.getKey()+":"+x4.getValue()+"\n");	
  
	  
   
  	
	
	
	
	
	
	
	
	file_out.write("\n");			
   
   
   
   
   
   
   tree3.clear();
   tree2.clear();
    tree1.clear();
   
   
   
			  

	}/*****new item in the min sup list**************/
  
  
		


	






/************************************************************************************************************************************************************************************/
file_out.close();
			  
	    }
		
         catch(Exception e)
		 {
		      System.out.println(e);
		}		
           
	}
}		
	  