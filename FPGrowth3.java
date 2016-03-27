
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

public class FPGrowth3 {

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
          Runtime rt1=Runtime.getRuntime();
        System.out.println(" free Memory Space before start"+rt1.freeMemory());
		long fr1=rt1.freeMemory();	
        Date d; //date object for timing purposes
        long start, end; //start and end time
        int itemsetNumber=0; //the current itemset being looked at
        //get config
		 d = new Date();
        start = d.getTime();
        getConfig();

        System.out.println("FPGrowth algorithm has started.\n");

        //start timer
       
		d = new Date();
        end = d.getTime();
         System.out.println("Execution time is: "+((double)(end-start)/1000) + " seconds.");
        Runtime rt2=Runtime.getRuntime();
        System.out.println(" free Memory Space after start"+rt2.freeMemory());
		
		long fr2=rt2.freeMemory();
		long fr=fr2-fr1;
		System.out.println("used memory is"+fr);
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
//String Str2[]=new String[numTransactions];
ArrayList<String> list_Mod_Trans=new ArrayList<String>();

ArrayList<String> Arraylist=new ArrayList<String>();
for(int l=0;l<threshold_index;l++)
Arraylist.add(oneVal[l]);
 // List<String> array1=Arrays.asList(str.split(" "));
file_out.write("Contenst of list"+Arraylist+"\n");
HashMap<String,Integer> tree=new HashMap<String,Integer>();
// ArrayList<String> CheckArraylist=new ArrayList<String>();
Set<Map.Entry<String,Integer>> set=tree.entrySet();
//System.out.println("Contenst of STring"+array1);
int i1=0;
for(int i=0;i<numTransactions;i++)
{
if(i==0)
flag1=1;
if(i==1)
flag1=0;

//System.out.println(i);
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

if(!Arraylist1.isEmpty())
{ String sam=new String();
   for(String n : Arraylist1)
  {
    if(Arraylist1.indexOf(n)==0)
    sam=n+ " ";
    else
    sam+=  n +" ";
  }
  list_Mod_Trans.add(sam);
file_out.write("Transaction "+i+" Conatins String Form "+sam+"\n"); 
 
   
 }  




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
		
	
//System.out.println(" Transactions that contain minimum support elements"+Arraylist1);
}
//file_out.write("i1"+i1);
/**************************************************************************************************Conditional FP tree******************************************************************************************/
//System.out.println("check");
HashMap<String,Integer> tree1=new HashMap<String,Integer>();
int support1=0;
int p=Arraylist.size();
//file_out.write("check string 2 length"+list_Mod_Trans.size());

for(int k=p-1;k>0;k--)
{
  String x=Arraylist.get(k);
  //System.out.println("Element"+x);
   for(int s=0;s<list_Mod_Trans.size();s++)
   {
               String Str3=new String();
                 Str3=" ";                 
				 List<String> list1=Arrays.asList(list_Mod_Trans.get(s).split(" "));
  //             System.out.println("List"+list1);
	          if(list1.contains(x))
                {
                   int o=list1.indexOf(x);
	//			 file_out.write("index"+o);
		//	     System.out.println("index"+o);
			
				   if(list1.size()==1)
				   {
				       Str3=list1.get(o);          
				   }
				   else{
				   for(int r=0;r<o;r++)
                    {
					      if(r==0)
							Str3=list1.get(r)+ " ";
						else
							Str3+=list1.get(r)+" ";
					}
					}
			//		System.out.println("check 3");
		    //  file_out.write(" index "+s+"After removal of "+x+" List "+Str3+"\n");			
		//	System.out.println(" After removal of "+x+" List "+Str3+"\n");			
			/*
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
			//		System.out.println("check 4");
					
				}		
		//			System.out.println("check 5");
					
                
	} 
				 
		Set<Map.Entry<String,Integer>> set1=tree1.entrySet();
	for(Map.Entry<String,Integer> x1:set1)
		file_out.write("FP Conditional base for "+x+" is ::"+x1.getKey()+":"+x1.getValue()+"\n");	
      	file_out.write("\n");	
      		
/************************************************************************************gOt conditional pattern base*************************************************************************************************/					
   
     String Str4[]=new String[tree1.size()];        
    int    sup[]=new int[tree1.size()];   
	int j=0;          
	//Set<Map.Entry<String,Integer>> set1=tree.entrySet();
	for(Map.Entry<String,Integer> x1:set1)
	{
    //	System.out.println("Processing for FP tree conditional "+x1.getKey()+":"+x1.getValue());			
                Str4[j]=x1.getKey();
				sup[j]=x1.getValue();
	             j++;
	}
 	
  HashMap<String,Integer> tree2=new HashMap<String,Integer>();
int support3=0;
int k1;
for(k1=k-1;k1>=0;k1--)
{
  String x1=Arraylist.get(k1);
 // System.out.println()
   for(int t=0;t<Str4.length;t++)
   {
                 List<String> list2=Arrays.asList(Str4[t].split(" "));
                 if(list2.contains(x1))
				 {
                             String ind=x1+" ";
                             String link=new String();
                       /*  if(list2.size()==1)
                         {						 
                            
                         }
						 else
						 {*/
							for(int g2=0;g2<=list2.indexOf(x1);g2++)
					        {
					          //   System.out.println("G2 value"+g2);
                           
					              if(g2==0)
						            	link=list2.get(g2)+ " ";
						           else
						            	link+=list2.get(g2)+" ";
					
					        }
                       //  } 						   
						if(ind.equals(link))
                         {						
							if(tree2.containsKey(ind))
                               {
                                     support3=tree2.get(ind);
                                     support3+=sup[t];
                                     tree2.remove(ind);
                                     tree2.put(ind,support3); 									 
								}									
						        else
								{
								         
								      tree2.put(ind,sup[t]);
								}
						 }
                         else
                         {
						         if(tree2.containsKey(ind))
                               {
                                     support3=tree2.get(ind);
                                     support3+=sup[t];
                                     tree2.remove(ind);
                                     tree2.put(ind,support3); 									 
								}									
						        else
								{
								         
								      tree2.put(ind,sup[t]);
								}
								
						         if(tree2.containsKey(link))
                               {
                                     support3=tree2.get(link);
                                     support3+=sup[t];
                                     tree2.remove(link);
                                     tree2.put(link,support3); 									 
								}									
						        else
								{
								         
								      tree2.put(link,sup[t]);
								}
                         }						 
                 }				 
   
   
   }
		
           

	}	// end of resurcsion
	Set<Map.Entry<String,Integer>> set2=tree2.entrySet();
	for(Map.Entry<String,Integer> x2:set2)
		file_out.write("FP Conditional base support for "+x+" is ::"+x2.getKey()+":"+x2.getValue()+"\n");	
      	file_out.write("\n");	
    int j1=0;
	String Str6[]=new String[tree2.size()];
    int sup3[]=new int[tree2.size()];	
	for(Map.Entry<String,Integer> x3:set2)
	{
    	//System.out.println("Processing for FP tree conditional "+x3.getKey()+":"+x3.getValue());			
              if(x3.getValue()>=minSup)
              {			  
		         Str6[j1]=x3.getKey();
				sup3[j1]=x3.getValue();
	             j1++;
			  }	 
	}	  
    ArrayList<String> Arraylist7=new ArrayList<String>();
    for(int l4=0;l4<Str6.length;l4++)
    {   
   if(Str6[l4]!=null)
   Arraylist7.add(Str6[l4]+" "+x+"::"+sup3[l4]);	
	
	}
	file_out.write("final list is "+Arraylist7+"\n");
	 tree2.clear();		
	 


   int support4=0;
for(int k2=k-1;k2>=0;k2--)
{
  String x2=Arraylist.get(k2);
   System.out.println("Elemnet 2"+x2);
   for(int t=0;t<Str6.length;t++)
   {
                 List<String> list3=Arrays.asList(Str6[t].split(" "));
                 if(list3.contains(x2))
				 {
                             String ind=x2+" ";
                             String link=new String();
							 System.out.println("list3 contains "+list3);
                       /*  if(list2.size()==1)
                         {						 
                            
                         }
						 else
						 {*/
							for(int g2=0;g2<=list3.indexOf(x2);g2++)
					        {
					          //   System.out.println("G2 value"+g2);
                           
					              if(g2==0)
						            	link=list3.get(g2)+ " ";
						           else
						            	link+=list3.get(g2)+" ";
					
					        }
                       //  } 						   
						if(ind.equals(link))
                         {						
							if(tree2.containsKey(ind))
                               {
                                     support4=tree2.get(ind);
                                     support4+=sup[t];
                                     tree2.remove(ind);
                                     tree2.put(ind,support4); 									 
								}									
						        else
								{
								         
								      tree2.put(ind,sup3[t]);
								}
						 }
                         else
                         {
						         if(tree2.containsKey(ind))
                               {
                                     support4=tree2.get(ind);
                                     support4+=sup[t];
                                     tree2.remove(ind);
                                     tree2.put(ind,support4); 									 
								}									
						        else
								{
								         
								      tree2.put(ind,sup3[t]);
								}
								
						         if(tree2.containsKey(link))
                               {
                                     support3=tree2.get(link);
                                     support3+=sup[t];
                                     tree2.remove(link);
                                     tree2.put(link,support4); 									 
								}									
						        else
								{
								         
								      tree2.put(link,sup3[t]);
								}
                         }						 
                 }				 
   
   
   }
		
           

	}	// end of resurcsion
//	Set<Map.Entry<String,Integer>> set2=tree2.entrySet();
	for(Map.Entry<String,Integer> x4:set2)
		file_out.write("FP Conditional base support2 for "+x+" is ::"+x4.getKey()+":"+x4.getValue()+"\n");	
      	file_out.write("\n");	
    int j2=0;
	String Str7[]=new String[tree2.size()];
    int sup4[]=new int[tree2.size()];	
	for(Map.Entry<String,Integer> x5:set2)
	{
    	//System.out.println("Processing for FP tree conditional "+x3.getKey()+":"+x3.getValue());			
              if(x5.getValue()>=minSup)
              {			  
		         Str7[j2]=x5.getKey();
				sup4[j2]=x5.getValue();
	             j2++;
			  }	 
	}	  
    ArrayList<String> Arraylist8=new ArrayList<String>();
    for(int l4=0;l4<Str7.length;l4++)
    {
	if(Str7[l4]!=null)
	Arraylist8.add(Str7[l4]+" "+x+"::"+sup4[l4]);	
	}
	file_out.write("final2 list is 2"+Arraylist8+"\n");
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
	  