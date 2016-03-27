
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

public class FPGrowth {

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
    String outputFile="apriori-output.txt";//output file
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
file_out.write(" String Form "+Str2[i]+"\n");  



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
		
	
System.out.println("Contenst of Trans"+Arraylist1);
}

/**************************************************************************************************Conditional FP tree******************************************************************************************/

HashMap<String,Integer> tree1=new HashMap<String,Integer>();
int support1=0;
int p=Arraylist.size();
String Str3=new String();
for(int k=p-1;k>0;k--)
{
  String x=Arraylist.get(k);
  System.out.println("Element"+x);
   for(int s=0;s<Str2.length;s++)
   {
           List<String> list1=Arrays.asList(Str2[s].split(" "));
           //    System.out.println("List"+list1);
	          if(list1.contains(x))
                {
                   int o=list1.indexOf(x);
				//	System.out.println("index"+o);
			
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
					if(tree1.containsKey(Str3)) 
                  {                            
				     
				    support1=tree1.get(Str3); 
                     support1++;					
		            //tree.remove(key);
					tree1.put(Str3,support1);
					//System.out.println(key+":"+support);
        		  }        
				  else
				  {
				     
				     tree1.put(Str3,1);  
				  }
					
				}		
					

	} 
				 
		Set<Map.Entry<String,Integer>> set1=tree1.entrySet();
	for(Map.Entry<String,Integer> x1:set1)
		file_out.write("FP Conditional base for :"+x+" is "+x1.getKey()+":"+x1.getValue()+"\n");			
/************************************************************************************gOt conditional pattern base*************************************************************************************************/					
    String str4[]=new String[tree1.size()];        
    int    sup[]=new int[tree1.size()];   
	int j=0;          
	//Set<Map.Entry<String,Integer>> set1=tree.entrySet();
	for(Map.Entry<String,Integer> x1:set1)
	{
    	System.out.println("Processing for FP tree conditional "+x1.getKey()+":"+x1.getValue());			
                str4[j]=x1.getKey();
				sup[j]=x1.getValue();
	             j++;
	} 
              
	System.out.println("Check point 1");
	HashMap<String,Integer> branch2=new HashMap<String,Integer>();
    HashMap<String,Integer> branch_new=new HashMap<String,Integer>();	
	HashMap<String,Integer> branch1=new HashMap<String,Integer>();
    Set<String> set2=branch1.keySet();   
    Set<Map.Entry<String,Integer>> set3=branch1.entrySet();
	Set<Map.Entry<String,Integer>> set4=branch2.entrySet();
    Set<Map.Entry<String,Integer>> set6=branch_new.entrySet();
	Set<String> set5=branch2.keySet();
ArrayList<String> branch1_id=new ArrayList<String>();
ArrayList<Integer> branch1_sup=new ArrayList<Integer>();
ArrayList<String> branch2_id=new ArrayList<String>();
ArrayList<Integer> branch2_sup=new ArrayList<Integer>();
ArrayList<String> branch_new_id=new ArrayList<String>();
ArrayList<Integer> branch_new_sup=new ArrayList<Integer>();       
	

// Set<Map.Entry<String,Integer>> set3=branch1.entrySet();
		
	int branch1_sub=0;
	int branch2_sub=0;
	System.out.println("Check point 2");
	
   
	for(int y=0;y<str4.length;y++)                                
    {
	          List<String> list3=Arrays.asList(str4[y].split(" "));
				int initial_ele2=0;
				int intial_ele=0;
            System.out.println("Checking for branch "+list3); 
         


		// int entry_flag1=0,entry_flag2=0;			

				if(branch1_id.isEmpty())
				  {
			        	     
					 for(int p2=0;p2<list3.size();p2++)	            
                     {   
				                   
				         branch1_id.add(list3.get(p2));
						 branch1_sup.add(sup[y]);
					 
					 
				     }
                     for(int c1=0;c1<branch1_id.size();c1++)
	            	   System.out.println("Branch 1 "+branch1_id.get(c1)+":"+branch1_sup.get(c1));
                   if(!branch1_id.isEmpty())
				   {
				   file_out.write("FP tree Conditional: "+branch1_id+"\n");
						file_out.write("FP tree Conditional and its support: "+branch1_sup+"\n");
					}					   
			   }                 
               else if(branch2_id.isEmpty())
			   {
			        	     
					 for(int p3=0;p3<list3.size();p3++)	            
                     {   
				                           
				         branch2_id.add(list3.get(p3));
						 branch2_sup.add(sup[y]);  
				     
					 
					 
				     }
					 for(int c2=0;c2<branch2_id.size();c2++)
	            	System.out.println("Branch 2 "+branch2_id.get(c2)+":"+branch2_sup.get(c2));	               
			      if(!branch2_id.isEmpty())
					{
					file_out.write("FP tree Conditional: "+branch2_id+"\n");
						file_out.write("FP tree Conditional and its support: "+branch2_sup+"\n");
					}
				  
				  
				  
              }  
              else{
                 for(int p1=0;p1<list3.size();p1++)	            
                {  
								if(branch1_id.contains(list3.get(0))) 
										intial_ele=1;  
								if(branch2_id.contains(list3.get(0))) 
										initial_ele2=1;  
								System.out.println("Checking first element for match in baranch1 "+intial_ele+" branch2 "+initial_ele2);			 
					if(intial_ele==1) 
					{    
										//  int branch1_sub=0;
										String[] str5=new String[branch1_id.size()]; 				  
										List<String> sub_list=list3.subList(0,p1+1);  				  
										int index_comp=0;
										for(int c=0;c<branch1_id.size();c++)
										{
											str5[index_comp]=branch1_id.get(c);
											index_comp++;
                                         System.out.println("match sub list string array"+str5[c]);    										
										}
										int flag_check=0;
										int support2=0;									
									System.out.println("match sub list"+sub_list);
					             for(int u=0;u<sub_list.size();u++)
								{
                                   			
                                      											
											if(str5[u].equals(sub_list.get(u)))
											{
										        flag_check++;     		
											   							 
														if(flag_check==sub_list.size())
														{
														support2=branch1_sup.get(u); 
														support2+=sup[y];					
														branch1_sup.remove(u);   
														branch1_sup.add(u,support2);
														}
					//System.out.println(key+":"+support);
												  
											}
											else 
											{
														branch1_sub=1;
														break;
											}
									 		 
								}         		 
				 }
                else if(initial_ele2==1)				 
				 {
				               String[] str5=new String[branch2_id.size()]; 				  
                    List<String> sub_list=list3.subList(0,p1+1);  				  
                    int index_comp=0;
				    for(int c=0;c<branch2_id.size();c++)
                    {
						str5[index_comp]=branch2_id.get(c);
                        index_comp++;
                             System.out.println("match sub list string array in left tree "+str5[c]);    										
															
					}
					int support3=0;
                   int flag_check=0;
							System.out.println("match sub list in left tree"+sub_list);
				
					for(int u=0;u<sub_list.size();u++)
					 {
					      
					         if(str5[u].equals(sub_list.get(u)))
							 {
							      flag_check++;
                             
                             if(flag_check==sub_list.size())
                              {							 
				                 			support3=branch2_sup.get(u); 
														support3+=sup[y];					
														branch2_sup.remove(u);   
														branch2_sup.add(u,support3);
										
                               }  
							  }
							  else 
							  {
							     branch2_sub=1;
								 break;
							  }
					}         
                 }    				  
				  

				 if(branch1_sub==1)
				   {
				         intial_ele=0;
				          String str6[]=new String[p1];
						  int sup1[]=new int[p1];
	                    int index_bran=0;
						for(int x1=0;x1<branch1_id.size();x1++)
						{
							System.out.println("New sub branch intial making"+branch1_id.get(x1)+":"+branch1_sup.get(x1));			
							if(index_bran<p1)
							{
							str6[index_bran]=branch1_id.get(x1);
							sup1[index_bran]=branch1_sup.get(x1);
							index_bran++;
							}
						}	
							for(int h=0;h<str6.length;h++)
					        {
                                       branch_new_id.add(str6[h]);
                                       branch_new_sup.add(sup1[h]);  									   
							}
							
	                         for(int h2=p1;h2<list3.size();h2++) 
                             {							 
							           branch_new_id.add(list3.get(h2));
                                       branch_new_sup.add(sup[y]);  	
									   
                             }
							       
							 // branch_new.put(list3.get(p1),sup[y]);
							 System.out.println("New sub branch "+branch_new_id);
								System.out.println("New sub branch sup "+branch_new_sup);
                             
							 break;							 
						}			    
				                     
				     if(branch2_sub==1)
				   {
				         initial_ele2=0;
				          String str6[]=new String[p];
						  int sup1[]=new int[p1];
	                    int index_bran=0;
						for(int x1=0;x1<branch2_id.size();x1++)
						{
							System.out.println("New sub branch intial making"+branch2_id.get(x1)+":"+branch2_sup.get(x1));			
							if(index_bran<p1)
							{
							str6[index_bran]=branch2_id.get(x1);
							sup1[index_bran]=branch2_sup.get(x1);
							index_bran++;
							}
						}	
							for(int h=0;h<str6.length;h++)
					        {
                                       branch_new_id.add(str6[h]);
                                       branch_new_sup.add(sup1[h]);  									   
							}
							
	                         for(int h2=p1;h2<list3.size();h2++) 
                             {							 
							           branch_new_id.add(list3.get(h2));
                                       branch_new_sup.add(sup[y]);  	
									   
                             }
							       
							 // branch_new.put(list3.get(p1),sup[y]);
							 System.out.println("New sub branch "+branch_new_id);
								System.out.println("New sub branch sup "+branch_new_sup);
				                 
				   
				            break;
				   
				   }
				}/***********next elemnet in a  branch**********/   
		
				   branch1_sub=0;
				   branch2_sub=0;
					int g=0,g1=0,g2=0;
				   String left_str[]=new String[branch1.size()];
				   String right_str[]=new String[branch2.size()];
				   String branchnew_str[]=new String[branch_new.size()];
				   int branchnew_support[]=new int[branch_new.size()];
				   int left_sup[]=new int[branch1.size()];
				   int right_sup[]=new int[branch2.size()];
		           	
				   for(int x1=0;x1<branch1_id.size();x1++)
					{
					    System.out.println("left branch "+branch1_id.get(x1)+":"+branch1_sup.get(x1));	
					/*	if(x1.getValue()>=minSup)
						{
						left_str[g]=x1.getKey();
						left_sup[g]=x1.getValue();
						g++;
						}*/
					}
						
					  for(int x1=0;x1<branch2_id.size();x1++)
					{
					    
						System.out.println("right branch "+branch2_id.get(x1)+":"+branch2_sup.get(x1));	
					/*	if(x1.getValue()>=minSup)
						{
						left_str[g]=x1.getKey();
						left_sup[g]=x1.getValue();
						g++;
						}*/
					}				  



				  if(!branch_new_id.isEmpty())
				   {
				   file_out.write("FP tree Conditional: "+branch_new_id+"\n");
						file_out.write("FP tree Conditional and its support: "+branch_new_sup+"\n");
					}	
					  for(int x1=0;x1<branch_new_id.size();x1++)
					{
					    
						System.out.println("new branch "+branch_new_id.get(x1)+":"+branch_new_sup.get(x1));	
					/*	if(x1.getValue()>=minSup)
						{
						left_str[g]=x1.getKey();
						left_sup[g]=x1.getValue();
						g++;
						}*/
					}
				   
				  
			 } 	   /*************end of else***************/			
				   
          }/******new string new transaction *****************/
			
					
			  
			  
			 branch1_id.clear();
			 branch1_sup.clear();
			 branch2_id.clear();
			 branch2_sup.clear();
			 branch_new_id.clear();
			 branch_new_sup.clear();
			  tree1.clear();
			//  list1.clear();
			//  list3.clear();
			  
			  
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
	  