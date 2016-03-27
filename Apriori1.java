
/**
 *File:
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

public class Apriori1 {

    public static void main(String[] args) {
	    AprioriCalculation ap = new AprioriCalculation();
          
        ap.aprioriProcess();
    }
}
/******************************************************************************
 * Class Name   : AprioriCalculation
 * Purpose      : generate Apriori itemsets
 *****************************************************************************/
class AprioriCalculation
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
    public void aprioriProcess()
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

        System.out.println("Apriori algorithm has started.\n");

        //start timer
        d = new Date();
        end = d.getTime();

        //display the execution time
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
	   
	   //System.out.println("1 item threshold "+threshold_index);
	  System.out.println(" End of 1 frequent Itemset");						
/*************************************************************************************************Start of 2 Candidate list ***********************************************************/
	   
	   int Candid_limit=0;
	   for(int g=1;g<threshold_index;g++)
	   {
	                Candid_limit+=g;
	   
	   }
	   //System.out.println("2 item sets lenght"+Candid_limit); 
	   String twoVal[]=new String[Candid_limit];
	   int count2[]=new int[Candid_limit];
	   int j=0,q;
           

    /*    for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}
	  */ 
	 for(int u=0;u<=threshold_index-1;u++)
		{   
           //System.out.println("u"+u);
		for(q=u+1;q<=(threshold_index-1);q++)
            {
			 //    System.out.println("q"+q);
				 for(int z=0;z<numTransactions;z++)
                      {		
					             List<String> array=Arrays.asList(transac[z].split(" "));
				          if(array.contains(oneVal[u]) && array.contains(oneVal[q]))
				         {
				//		         System.out.println("j"+j);
                                  count2[j]++;  
								  if(Integer.parseInt(oneVal[u])<Integer.parseInt(oneVal[q]))
                                  twoVal[j]=oneVal[u]+" "+oneVal[q];		
                                  else 
                                  twoVal[j]=oneVal[q]+" "+oneVal[u];   								  
                               		
					     }
					//	 System.out.println(count2[j]);
						//  System.out.println(twoVal[j]);
			//		          file_out.write("count"+count2[j]+" 2 item set value "+twoVal[j]+" index "+j+"\n");		
					  }	 
					j++;  
			}
		}
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=Candid_limit-1;e++)
		{          for(int r=0;r<(Candid_limit-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count2[r])<(count2[r+1]))
				{
					String s1=new String();
					int x;
					s1=twoVal[r];
				//	System.out.println("e= "+e+" r"+r);
					twoVal[r]=twoVal[r+1];
					twoVal[r+1]=s1;
					x=count2[r];
					
					count2[r]=count2[r+1];
					count2[r+1]=x;
				}
			}
		}        

     int threshold_index1=0;
       int v;
      // System.out.println(minSup);
	   for(v=0;v<=Candid_limit-1;v++)
       {
                   
		  if(count2[v]<minSup) 
            {
			     System.out.println("2 item sets with support"+v);
		         threshold_index1=v;	
                  break;
				  
				  
            }	
			else if(v==Candid_limit-1)
			threshold_index1=Candid_limit;
	   }
 for(int w=threshold_index1;w<twoVal.length;w++)
	   {
	           twoVal[w]=null;
			   Integer m=new  Integer(count2[w]);
		       m=null;
		}
          rt.gc();	

	   
System.out.println(" End of 2 frequent Itemset");
/*************************************************************************************************End of 2 Candidate list and start of 3 Candidate ***********************************************************/
  /*       int Candid_limit2=0;
	   for(int g1=1;g1<threshold_index1;g1++)
	   {
	                Candid_limit2+=g1;
	   
	   }
*/	   
       int array_limit=(threshold_index1*(threshold_index1-1))/2; 
          
	   String threeVal[]=new String[array_limit];
	   int count3[]=new int[array_limit];
	   
           //    System.out.println("array size3"+array_limit);
		           

    /*   for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}*/
			int h=0;
			int flag1=0;
			 for(int x=0;x<=threshold_index1-1;x++)
		     {   
                       //System.out.println("x"+x);
		               for(int a=x+1;a<=(threshold_index1-1);a++)
                       {
					       // file_out.write(twoVal[x]+" index is "+x+" : "+twoVal[a]+" index is "+a+"\n");
					   
			                StringTokenizer str1=new StringTokenizer(twoVal[x]);
			                StringTokenizer str2=new StringTokenizer(twoVal[a]);
			                String val1=str1.nextToken();   
				            String val2=str2.nextToken();   
				        
				            if(val1.equals(val2))
				         {
                                  String val2_2=str2.nextToken(); 						          
                                  String val1_2=str1.nextToken();
								  
								   if(Integer.parseInt(val1_2)<Integer.parseInt(val2_2))
                                       threeVal[h]=twoVal[x]+" "+val2_2;		
                                  else {
								            
								       threeVal[h]= new StringBuffer(twoVal[x]).insert(twoVal[x].length()-val1_2.length(),val2_2+" ").toString();
								  
								  }
                                  	
                                         								  
					           flag1=1;    			  
				//	    file_out.write(twoVal[x]+" :"+val2_2+":3 item set"+ threeVal[h]+" index"+h+"\n");
						 }
						// System.out.println(count2[f]);
						 if(flag1==1)
						 {
						 h++;
						 flag1=0;
						 }
					    
					  }	 
					  
			}
			
		for(int t=0;t<h;t++)
		 {
              		//System.out.println(t);
			StringTokenizer stri=new StringTokenizer(threeVal[t]);
			String val1=stri.nextToken();
			String val2=stri.nextToken();
			String val3=stri.nextToken();
			//	System.out.println("1st num"+val1+"2nd num"+val2+"3rd num"+val3+"\n");
	        for(int z=0;z<numTransactions;z++)
            {	
			             List<String> array1=Arrays.asList(transac[z].split(" "));
			             if(array1.contains(val1)&& array1.contains(val2) && array1.contains(val3))
                         {
						  //   System.out.println("count3[t]");
							 
                            count3[t]++;
                             
							  

                         }						 
		 
		    }
	
						//  file_out.write(count3[t]+":index:"+t+"\n");

		 }
       	
	
	
	
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=h-1;e++)
		{          for(int r=0;r<(h-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count3[r])<(count3[r+1]))
				{
					String s1=new String();
					int x;
					s1=threeVal[r];
				//	System.out.println("e= "+e+" r"+r);
					threeVal[r]=threeVal[r+1];
					threeVal[r+1]=s1;
					x=count3[r];
					
					count3[r]=count3[r+1];
					count3[r+1]=x;
				}
			}
		}             				
     int threshold_index2=0;
       int y;
      // System.out.println(minSup);
	   for(y=0;y<=h-1;y++)
       {
                   
		  if(count3[y]<minSup) 
            {
			   //  System.out.println(v);
		         threshold_index2=y;	
                  break;
				  
            }	
		   else if(y==h-1)
              threshold_index2=h;		   
		} 		
	   //System.out.println("threshold of 3 item set"+threshold_index2);

 for(int w=threshold_index2;w<threeVal.length;w++)
	   {
	           threeVal[w]=null;
			   Integer m=new  Integer(count3[w]);
		       m=null;
			   
		}
          rt.gc();	
	   System.out.println(" End of 3 frequent Itemset");
/****************************************************************************4th Candidate begins***********************************************************************************************/
        array_limit=(threshold_index2*(threshold_index2-1))/2;

		
	   String fourVal[]=new String[array_limit];
	   int count4[]=new int[array_limit];
	     //     System.out.println("array size4"+array_limit);
		
           

    /*   for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}*/
			int h4=0;
			int flag4=0;
			 for(int x=0;x<=threshold_index2-1;x++)
		     {   
                       //System.out.println("4itemx"+x);
		               for(int a=x+1;a<=(threshold_index2-1);a++)
                       {
					   //     file_out.write(threeVal[x]+":"+threeVal[a]+"\n");
					   
			                StringTokenizer str1=new StringTokenizer(threeVal[x]);
			                StringTokenizer str2=new StringTokenizer(threeVal[a]);
			                String val1=str1.nextToken();   
				            String val2=str2.nextToken();   
				            String val1_2=str1.nextToken();   
				            String val2_2=str2.nextToken();   
				        
							
				            if(val1.equals(val2) && val1_2.equals(val2_2))
				         {
                                  String val2_3=str2.nextToken(); 						          
                                  String val1_3=str1.nextToken(); 						          
                                  if(Integer.parseInt(val1_3)<Integer.parseInt(val2_3))
                                       fourVal[h4]=threeVal[x]+" "+val2_3;		
                                  else {
								            
								       fourVal[h4]= new StringBuffer(threeVal[x]).insert(threeVal[x].length()-val1_3.length(),val2_3+" ").toString();
								  
								  }
								  
                                  	
                                         								  
					           flag4=1;    			  
					//      file_out.write(val1+" :"+val1_2+" : "+val1_3+" : "+val2_3+":"+ fourVal[h4]+" index"+h4+"\n");
						 }
						// System.out.println(count2[f]);
						 if(flag4==1)
						 {
						 h4++;
						 flag4=0;
						 }
					    
					  }	 
					  
			}
			
	for(int t=0;t<h4;t++)
		 {
              //		System.out.println(t);
			StringTokenizer stri=new StringTokenizer(fourVal[t]);
			String val1=stri.nextToken();
			String val2=stri.nextToken();
			String val3=stri.nextToken();
			String val4=stri.nextToken();
			
			//	System.out.println("1st num"+val1+"2nd num"+val2+"3rd num"+val3+"\n");
	        for(int z=0;z<numTransactions;z++)
            {	
			             List<String> array1=Arrays.asList(transac[z].split(" "));
			             if(array1.contains(val1)&& array1.contains(val2) && array1.contains(val3) && array1.contains(val4))
                         {
						  //   System.out.println("count3[t]");
							 
                            count4[t]++;
                             
							  

                         }						 
		 
		    }
	
						//  file_out.write(count3[t]+":index:"+t+"\n");

		 }
       	
	
	
	
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=h4-1;e++)
		{          for(int r=0;r<(h4-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count4[r])<(count4[r+1]))
				{
					String s1=new String();
					int x;
					s1=fourVal[r];
				//	System.out.println("e= "+e+" r"+r);
					fourVal[r]=fourVal[r+1];
					fourVal[r+1]=s1;
					x=count4[r];
					
					count4[r]=count4[r+1];
					count4[r+1]=x;
				}
			}
		}             				
     int threshold_index3=0;
       int t1;
    //  System.out.println(minSup+"h4"+h4);
	   for(t1=0;t1<=h4-1;t1++)
       {
                   
		  if(count4[t1]<minSup) 
            {
			   //  System.out.println(t1);
		         threshold_index3=t1;	
                  break;
				  
            }	
		   if(t1==h4-1)
              threshold_index3=h4;		   
	   } 		
     System.out.println(" free Memory Space"+rt.freeMemory());	
     
	   
 for(int w=threshold_index3;w<fourVal.length;w++)
	   {
	           fourVal[w]=null;
			   Integer m=new  Integer(count4[w]);
		       m=null;
			   
		}
          rt.gc();
          System.out.println(" free Memory Space"+rt.freeMemory());	
           		  
		 System.out.println("item set 4 threshold"+threshold_index3);
	  		   System.out.println(" End of 4 frequent Itemset");
/**************************************************************************************5 item set*******************************************************************************************/				   
				   array_limit=(threshold_index3*(threshold_index3-1))/2;
String fiveVal[]=new String[array_limit];
	   int count5[]=new int[array_limit];
	   
   //           System.out.println("array size5"+array_limit);
		   

    /*   for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}*/
			int h5=0;
			int flag5=0;
			 for(int x=0;x<=threshold_index3-1;x++)
		     {   
                       //System.out.println("4itemx"+x);
		               for(int a=x+1;a<=(threshold_index3-1);a++)
                       {
//					        file_out.write(fourVal[x]+"::"+x+":"+fourVal[a]+"::"+a+"\n");
					   
			                StringTokenizer str1=new StringTokenizer(fourVal[x]);
			                StringTokenizer str2=new StringTokenizer(fourVal[a]);
			                String val1=str1.nextToken();   
				            String val2=str2.nextToken();   
				            String val1_2=str1.nextToken();   
				            String val2_2=str2.nextToken();   
				            String val1_3=str1.nextToken();   
				            String val2_3=str2.nextToken();   
				           
							
				            if(val1.equals(val2) && val1_2.equals(val2_2) && val1_3.equals(val2_3))
				         {
                                  String val2_4=str2.nextToken(); 						          
                                  String val1_4=str1.nextToken(); 						          
                                            
                                  if(Integer.parseInt(val1_4)<Integer.parseInt(val2_4))
                                       fiveVal[h5]=fourVal[x]+" "+val2_4;	
                                  else {
								            
								       fiveVal[h5]= new StringBuffer(fourVal[x]).insert(fourVal[x].length()-val1_4.length(),val2_4+" ").toString();
								  
								  }
                                  //fiveVal[h5]=fourVal[x]+" "+val2_4;	
                                         								  
					           flag5=1;    			  
					    //  file_out.write(val1+" :"+val1_2+" : "+val1_3+" : "+val1_4+" : "+val2_4+":"+ fiveVal[h5]+" index"+h5+"\n");
						 }
						// System.out.println(count2[f]);
						 if(flag5==1)
						 {
						 h5++;
						 flag5=0;
						 }
					    
					  }	 
					  
			}
			
	for(int t=0;t<h5;t++)
		 {
              //		System.out.println(t);
			StringTokenizer stri=new StringTokenizer(fiveVal[t]);
			String val1=stri.nextToken();
			String val2=stri.nextToken();
			String val3=stri.nextToken();
			String val4=stri.nextToken();
			String val5=stri.nextToken();
			
			//	System.out.println("1st num"+val1+"2nd num"+val2+"3rd num"+val3+"\n");
	        for(int z=0;z<numTransactions;z++)
            {	
			             List<String> array1=Arrays.asList(transac[z].split(" "));
			             if(array1.contains(val1)&& array1.contains(val2) && array1.contains(val3) && array1.contains(val4) && array1.contains(val5))
                         {
						  //   System.out.println("count3[t]");
							 
                            count5[t]++;
                             
							  

                         }						 
		 
		    }
	
						  //file_out.write(count5[t]+":index:"+t+"\n");

		 }
       	
	
	
	
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=h5-1;e++)
		{          for(int r=0;r<(h5-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count5[r])<(count5[r+1]))
				{
					String s1=new String();
					int x;
					s1=fiveVal[r];
				//	System.out.println("e= "+e+" r"+r);
					fiveVal[r]=fiveVal[r+1];
					fiveVal[r+1]=s1;
					x=count5[r];
					
					count5[r]=count5[r+1];
					count5[r+1]=x;
				}
			}
		}             				
     int threshold_index4=0;
       int t2;
    //  System.out.println(minSup+"h4"+h4);
	   for(t2=0;t2<=h5-1;t2++)
       {
                   
		  if(count5[t2]<minSup) 
            {
			  //   System.out.println(t);
		         threshold_index4=t2;	
                  break;
				  
            }	
		   if(t2==h5-1)
              threshold_index4=h5;		   
	   } 		
				   System.out.println(" End of 5 frequent Itemset");
/****************************************************************************************6th item set*******************************************************************************************/	   
				  array_limit=(threshold_index4*(threshold_index4-1))/2; 
String sixVal[]=new String[array_limit];
	   int count6[]=new int[array_limit];
	   
           

    /*   for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}*/
			int h6=0;
			int flag6=0;
			 for(int x=0;x<=threshold_index4-1;x++)
		     {   
                       //System.out.println("itemx"+x);
		               for(int a=x+1;a<=(threshold_index4-1);a++)
                       {
					       //file_out.write(fiveVal[x]+":"+fiveVal[a]+"\n");
					   
			                StringTokenizer str1=new StringTokenizer(fiveVal[x]);
			                StringTokenizer str2=new StringTokenizer(fiveVal[a]);
			                String val1=str1.nextToken();   
				            String val2=str2.nextToken();   
				            String val1_2=str1.nextToken();   
				            String val2_2=str2.nextToken();   
				            String val1_3=str1.nextToken();   
				            String val2_3=str2.nextToken();   
				              String val1_4=str1.nextToken();   
				            String val2_4=str2.nextToken();   
				           
							
				            if(val1.equals(val2) && val1_2.equals(val2_2) && val1_3.equals(val2_3) && val1_4.equals(val2_4))
				         {
                                  String val2_5=str2.nextToken(); 						          
                                  String val1_5=str1.nextToken(); 						          
                                  if(Integer.parseInt(val1_5)<Integer.parseInt(val2_5))
                                       sixVal[h6]=fiveVal[x]+" "+val2_5;		
                                  else {
								            
								       sixVal[h6]= new StringBuffer(fiveVal[x]).insert(fiveVal[x].length()-val1_5.length(),val2_5+" ").toString();
								  
								  }   
                                  //sixVal[h6]=fiveVal[x]+" "+val2_5;	
                                         								  
					           flag6=1;    			  
					      //file_out.write(val1+" :"+val1_2+" : "+val1_3+" : "+val1_4+" : "+val1_5+" : "+val2_5+":"+ sixVal[h6]+" index"+h6+"\n");
						 }
						// System.out.println(count2[f]);
						 if(flag6==1)
						 {
						 h6++;
						 flag6=0;
						 }
					    
					  }	 
					  
			}
			
	for(int t=0;t<h6;t++)
		 {
              	//	System.out.println(t);
			StringTokenizer stri=new StringTokenizer(sixVal[t]);
			String val1=stri.nextToken();
			String val2=stri.nextToken();
			String val3=stri.nextToken();
			String val4=stri.nextToken();
			String val5=stri.nextToken();
			String val6=stri.nextToken();
			
			//	System.out.println("1st num"+val1+"2nd num"+val2+"3rd num"+val3+"\n");
	        for(int z=0;z<numTransactions;z++)
            {	
			             List<String> array1=Arrays.asList(transac[z].split(" "));
			             if(array1.contains(val1)&& array1.contains(val2) && array1.contains(val3) && array1.contains(val4) && array1.contains(val5) && array1.contains(val6))
                         {
						  //   System.out.println("count3[t]");
							 
                            count6[t]++;
                             
							  

                         }						 
		 
		    }
	
						//  file_out.write(count3[t]+":index:"+t+"\n");

		 }
       	
	
	
	
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=h6-1;e++)
		{          for(int r=0;r<(h6-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count6[r])<(count6[r+1]))
				{
					String s1=new String();
					int x;
					s1=sixVal[r];
				//	System.out.println("e= "+e+" r"+r);
					sixVal[r]=sixVal[r+1];
					sixVal[r+1]=s1;
					x=count6[r];
					
					count6[r]=count6[r+1];
					count6[r+1]=x;
				}
			}
		}             				
     int threshold_index5=0;
       int t3;
    //  System.out.println(minSup+"h4"+h4);
	   for(t3=0;t3<=h6-1;t3++)
       {
                   
		  if(count6[t3]<minSup) 
            {
			  //   System.out.println(t);
		         threshold_index5=t3;	
                  break;
				  
            }	
		   if(t3==h6-1)
              threshold_index5=h6;		   
	   } 
	   System.out.println(" End of 6 frequent Itemset");
/**************************************************************************************7th item set*************************************************************************************************/

 array_limit=(threshold_index5*(threshold_index5-1))/2;
String sevenVal[]=new String[array_limit];
	   int count7[]=new int[array_limit];
	   
           

    /*   for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}*/
			int h7=0;
			int flag7=0;
			 for(int x=0;x<=threshold_index5-1;x++)
		     {   
                       //System.out.println("itemx"+x);
		               for(int a=x+1;a<=(threshold_index5-1);a++)
                       {
					    //   file_out.write(sixVal[x]+":"+sixVal[a]+"\n");
					   
			                StringTokenizer str1=new StringTokenizer(sixVal[x]);
			                StringTokenizer str2=new StringTokenizer(sixVal[a]);
			                String val1=str1.nextToken();   
				            String val2=str2.nextToken();   
				            String val1_2=str1.nextToken();   
				            String val2_2=str2.nextToken();   
				            String val1_3=str1.nextToken();   
				            String val2_3=str2.nextToken();   
				              String val1_4=str1.nextToken();   
				            String val2_4=str2.nextToken();   
				               String val1_5=str1.nextToken();   
				            String val2_5=str2.nextToken();   
				           
							
				            if(val1.equals(val2) && val1_2.equals(val2_2) && val1_3.equals(val2_3) && val1_4.equals(val2_4) && val1_5.equals(val2_5))
				         {
                                  String val2_6=str2.nextToken(); 						          
                                  String val1_6=str1.nextToken(); 						          
									
								     if(Integer.parseInt(val1_6)<Integer.parseInt(val2_6))
                                       sevenVal[h7]=sixVal[x]+" "+val2_6;		
                                  else {
								            
								       sevenVal[h7]= new StringBuffer(sixVal[x]).insert(sixVal[x].length()-val1_6.length(),val2_6+" ").toString();
								  
								  } 			

								  
                    //              sevenVal[h7]=sixVal[x]+" "+val2_6;	
                                         								  
					           flag7=1;    			  
					 //     file_out.write(val1+" :"+val1_2+" : "+val1_3+" : "+val1_4+" : "+val1_5+" : "+val1_6+" : "+val2_6+":"+ sevenVal[h7]+" index"+h7+"\n");
						 }
						// System.out.println(count2[f]);
						 if(flag7==1)
						 {
						 h7++;
						 flag7=0;
						 }
					    
					  }	 
					  
			}
			
	for(int t=0;t<h7;t++)
		 {
              	//	System.out.println(t);
			StringTokenizer stri=new StringTokenizer(sevenVal[t]);
			String val1=stri.nextToken();
			String val2=stri.nextToken();
			String val3=stri.nextToken();
			String val4=stri.nextToken();
			String val5=stri.nextToken();
			String val6=stri.nextToken();
			String val7=stri.nextToken();
			
			//	System.out.println("1st num"+val1+"2nd num"+val2+"3rd num"+val3+"\n");
	        for(int z=0;z<numTransactions;z++)
            {	
			             List<String> array1=Arrays.asList(transac[z].split(" "));
			             if(array1.contains(val1)&& array1.contains(val2) && array1.contains(val3) && array1.contains(val4) && array1.contains(val5) && array1.contains(val6) && array1.contains(val7))
                         {
						  //   System.out.println("count3[t]");
							 
                            count7[t]++;
                             
							  

                         }						 
		 
		    }
	
						//  file_out.write(count3[t]+":index:"+t+"\n");

		 }
       	
	
	
	
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=h7-1;e++)
		{          for(int r=0;r<(h7-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count7[r])<(count7[r+1]))
				{
					String s1=new String();
					int x;
					s1=sevenVal[r];
				//	System.out.println("e= "+e+" r"+r);
					sevenVal[r]=sevenVal[r+1];
					sevenVal[r+1]=s1;
					x=count7[r];
					
					count7[r]=count7[r+1];
					count7[r+1]=x;
				}
			}
		}             				
     int threshold_index6=0;
       int t4;
    //  System.out.println(minSup+"h4"+h4);
	   for(t4=0;t4<=h7-1;t4++)
       {
                   
		  if(count7[t4]<minSup) 
            {
			  //   System.out.println(t);
		         threshold_index6=t4;	
                  break;
				  
            }	
		   if(t4==h7-1)
              threshold_index6=h7;		   
	   } 
System.out.println(" End of 7 frequent Itemset");
/******************************************************************************************8th item set********************************************************************************************************/
array_limit=(threshold_index6*(threshold_index6-1))/2;
String eightVal[]=new String[array_limit];
	   int count8[]=new int[array_limit];
	   
           

    /*   for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}*/
			int h8=0;
			int flag8=0;
			 for(int x=0;x<=threshold_index6-1;x++)
		     {   
                       //System.out.println("itemx"+x);
		               for(int a=x+1;a<=(threshold_index6-1);a++)
                       {
					    //   file_out.write(sixVal[x]+":"+sixVal[a]+"\n");
					   
			                StringTokenizer str1=new StringTokenizer(sevenVal[x]);
			                StringTokenizer str2=new StringTokenizer(sevenVal[a]);
			                String val1=str1.nextToken();   
				            String val2=str2.nextToken();   
				            String val1_2=str1.nextToken();   
				            String val2_2=str2.nextToken();   
				            String val1_3=str1.nextToken();   
				            String val2_3=str2.nextToken();   
				              String val1_4=str1.nextToken();   
				            String val2_4=str2.nextToken();   
				               String val1_5=str1.nextToken();   
				            String val2_5=str2.nextToken();   
				             String val1_6=str1.nextToken();   
				            String val2_6=str2.nextToken();   
				           
							
				            if(val1.equals(val2) && val1_2.equals(val2_2) && val1_3.equals(val2_3) && val1_4.equals(val2_4) && val1_5.equals(val2_5)  && val1_6.equals(val2_6))
				         {
                                  String val2_7=str2.nextToken(); 						          
                                  String val1_7=str1.nextToken(); 						          
                     		     if(Integer.parseInt(val1_7)<Integer.parseInt(val2_7))
                                     eightVal[h8]=sevenVal[x]+" "+val2_7;	
                                 else {
								            
								       eightVal[h8]= new StringBuffer(sevenVal[x]).insert(sevenVal[x].length()-val1_7.length(),val2_7+" ").toString();
								  
								  } 			
                
//                                  eightVal[h8]=sevenVal[x]+" "+val2_7;	
                                         								  
					           flag8=1;    			  
					 //     file_out.write(val1+" :"+val1_2+" : "+val1_3+" : "+val1_4+" : "+val1_5+" : "+val1_6+" : "+val2_6+":"+ sevenVal[h7]+" index"+h7+"\n");
						 }
						// System.out.println(count2[f]);
						 if(flag8==1)
						 {
						 h8++;
						 flag8=0;
						 }
					    
					  }	 
					  
			}
			
	for(int t=0;t<h8;t++)
		 {
              	//	System.out.println(t);
			StringTokenizer stri=new StringTokenizer(eightVal[t]);
			String val1=stri.nextToken();
			String val2=stri.nextToken();
			String val3=stri.nextToken();
			String val4=stri.nextToken();
			String val5=stri.nextToken();
			String val6=stri.nextToken();
			String val7=stri.nextToken();
			String val8=stri.nextToken();
			
			//	System.out.println("1st num"+val1+"2nd num"+val2+"3rd num"+val3+"\n");
	        for(int z=0;z<numTransactions;z++)
            {	
			             List<String> array1=Arrays.asList(transac[z].split(" "));
			             if(array1.contains(val1)&& array1.contains(val2) && array1.contains(val3) && array1.contains(val4) && array1.contains(val5) && array1.contains(val6) && array1.contains(val7) && array1.contains(val8))
                         {
						  //   System.out.println("count3[t]");
							 
                            count8[t]++;
                             
							  

                         }						 
		 
		    }
	
						//  file_out.write(count3[t]+":index:"+t+"\n");

		 }
       	
	
	
	
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=h8-1;e++)
		{          for(int r=0;r<(h8-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count8[r])<(count8[r+1]))
				{
					String s1=new String();
					int x;
					s1=eightVal[r];
				//	System.out.println("e= "+e+" r"+r);
					eightVal[r]=eightVal[r+1];
					eightVal[r+1]=s1;
					x=count8[r];
					
					count8[r]=count8[r+1];
					count8[r+1]=x;
				}
			}
		}             				
     int threshold_index7=0;
       int t5;
    //  System.out.println(minSup+"h4"+h4);
	   for(t5=0;t5<=h8-1;t5++)
       {
                   
		  if(count8[t5]<minSup) 
            {
			  //   System.out.println(t);
		         threshold_index7=t5;	
                  break;
				  
            }	
		   if(t5==h8-1)
              threshold_index7=h8;		   
	   } 
System.out.println(" End of 8 frequent Itemset");
/***************************************************************************************9 item set********************************************************************************************/
array_limit=(threshold_index7*(threshold_index7-1))/2;
String nineVal[]=new String[array_limit];
	   int count9[]=new int[array_limit];
	   
           

    /*   for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}*/
			int h9=0;
			int flag9=0;
			 for(int x=0;x<=threshold_index7-1;x++)
		     {   
                       //System.out.println("itemx"+x);
		               for(int a=x+1;a<=(threshold_index7-1);a++)
                       {
					    //   file_out.write(eightVal[x]+":"+eightVal[a]+"\n");
					   
			                StringTokenizer str1=new StringTokenizer(eightVal[x]);
			                StringTokenizer str2=new StringTokenizer(eightVal[a]);
			                String val1=str1.nextToken();   
				            String val2=str2.nextToken();   
				            String val1_2=str1.nextToken();   
				            String val2_2=str2.nextToken();   
				            String val1_3=str1.nextToken();   
				            String val2_3=str2.nextToken();   
				              String val1_4=str1.nextToken();   
				            String val2_4=str2.nextToken();   
				               String val1_5=str1.nextToken();   
				            String val2_5=str2.nextToken();   
				             String val1_6=str1.nextToken();   
				            String val2_6=str2.nextToken();   
				               String val1_7=str1.nextToken();   
				            String val2_7=str2.nextToken();   
				           
							
				            if(val1.equals(val2) && val1_2.equals(val2_2) && val1_3.equals(val2_3) && val1_4.equals(val2_4) && val1_5.equals(val2_5)  && val1_6.equals(val2_6) && val1_7.equals(val2_7))
				         {
                                  String val2_8=str2.nextToken(); 						          
                                  String val1_8=str1.nextToken(); 						          
                                 if(Integer.parseInt(val1_8)<Integer.parseInt(val2_8))
                                    nineVal[h9]=eightVal[x]+" "+val2_8;	
                                  else {
								            
								       nineVal[h9]= new StringBuffer(eightVal[x]).insert(eightVal[x].length()-val1_8.length(),val2_8+" ").toString();
								  
								  } 			
                    
                //                  nineVal[h9]=eightVal[x]+" "+val2_8;	
                                         								  
					           flag9=1;    			  
					 //     file_out.write(val1+" :"+val1_2+" : "+val1_3+" : "+val1_4+" : "+val1_5+" : "+val1_6+" : "+val1_7+" : "+val1_8+" : "+val2_6+":"+ ninwVal[h9]+" index"+h9+"\n");
						 }
						// System.out.println(count2[f]);
						 if(flag9==1)
						 {
						 h9++;
						 flag9=0;
						 }
					    
					  }	 
					  
			}
			
	for(int t=0;t<h9;t++)
		 {
              	//	System.out.println(t);
			StringTokenizer stri=new StringTokenizer(nineVal[t]);
			String val1=stri.nextToken();
			String val2=stri.nextToken();
			String val3=stri.nextToken();
			String val4=stri.nextToken();
			String val5=stri.nextToken();
			String val6=stri.nextToken();
			String val7=stri.nextToken();
			String val8=stri.nextToken();
		    	String val9=stri.nextToken();
		 	
			//	System.out.println("1st num"+val1+"2nd num"+val2+"3rd num"+val3+"\n");
	        for(int z=0;z<numTransactions;z++)
            {	
			             List<String> array1=Arrays.asList(transac[z].split(" "));
			             if(array1.contains(val1)&& array1.contains(val2) && array1.contains(val3) && array1.contains(val4) && array1.contains(val5) && array1.contains(val6) && array1.contains(val7) && array1.contains(val8) && array1.contains(val9))
                         {
						  //   System.out.println("count3[t]");
							 
                            count9[t]++;
                             
							  

                         }						 
		 
		    }
	
						//  file_out.write(count3[t]+":index:"+t+"\n");

		 }
       	
	
	
	
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=h9-1;e++)
		{          for(int r=0;r<(h9-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count9[r])<(count9[r+1]))
				{
					String s1=new String();
					int x;
					s1=nineVal[r];
				//	System.out.println("e= "+e+" r"+r);
					nineVal[r]=nineVal[r+1];
					nineVal[r+1]=s1;
					x=count9[r];
					
					count9[r]=count9[r+1];
					count9[r+1]=x;
				}
			}
		}             				
     int threshold_index8=0;
       int t6;
    //  System.out.println(minSup+"h4"+h4);
	   for(t6=0;t6<=h9-1;t6++)
       {
                   
		  if(count9[t6]<minSup) 
            {
			  //   System.out.println(t);
		         threshold_index8=t6;	
                  break;
				  
            }	
		   if(t6==h9-1)
              threshold_index8=h9;		   
	   } 
	   
	   System.out.println(" End of 9 frequent Itemset");
/*************************************************************************************10 item set ******************************************************************************************************/
array_limit=(threshold_index8*(threshold_index8-1))/2;
String tenVal[]=new String[array_limit];
	   int count10[]=new int[array_limit];
	   
           

    /*   for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}*/
			int h10=0;
			int flag10=0;
			 for(int x=0;x<=threshold_index8-1;x++)
		     {   
                 //      System.out.println("item9"+x);
		               for(int a=x+1;a<=(threshold_index8-1);a++)
                       {
					     //  file_out.write(nineVal[x]+":"+nineVal[a]+"\n");
					   
			                StringTokenizer str1=new StringTokenizer(nineVal[x]);
			                StringTokenizer str2=new StringTokenizer(nineVal[a]);
			                String val1=str1.nextToken();   
				            String val2=str2.nextToken();   
				            String val1_2=str1.nextToken();   
				            String val2_2=str2.nextToken();   
				            String val1_3=str1.nextToken();   
				            String val2_3=str2.nextToken();   
				              String val1_4=str1.nextToken();   
				            String val2_4=str2.nextToken();   
				               String val1_5=str1.nextToken();   
				            String val2_5=str2.nextToken();   
				             String val1_6=str1.nextToken();   
				            String val2_6=str2.nextToken();   
				               String val1_7=str1.nextToken();   
				            String val2_7=str2.nextToken();   
				            String val1_8=str1.nextToken();   
				            String val2_8=str2.nextToken();   
				           
					//		System.out.println("a1");
				            if(val1.equals(val2) && val1_2.equals(val2_2) && val1_3.equals(val2_3) && val1_4.equals(val2_4) && val1_5.equals(val2_5)  && val1_6.equals(val2_6) && val1_7.equals(val2_7) && val1_8.equals(val2_8))
				         {
                                  String val2_9=str2.nextToken(); 						          
                                  String val1_9=str1.nextToken(); 						          
                                     
                                 if(Integer.parseInt(val1_9)<Integer.parseInt(val2_9))
                                       tenVal[h10]=nineVal[x]+" "+val2_9;	
                              else {
								            
								       tenVal[h10]= new StringBuffer(nineVal[x]).insert(nineVal[x].length()-val1_9.length(),val2_9+" ").toString();
								  
								  } 			
                              //    tenVal[h10]=nineVal[x]+" "+val2_9;	
                                         								  
					           flag10=1;    			  
					      //file_out.write(val1+" :"+val1_2+" : "+val1_3+" : "+val1_4+" : "+val1_5+" : "+val1_6+" : "+val1_7+" : "+val1_8+": "+val1_9+" : "+val2_9+":"+ tenVal[h10]+" index"+h10+"\n");
						 }
						// System.out.println(count2[f]);
						 if(flag10==1)
						 {
						 h10++;
						 flag10=0;
						 }
					    
					  }	 
					  
			}
			
	for(int t=0;t<h10;t++)
		 {
              	//	System.out.println(t);
			StringTokenizer stri=new StringTokenizer(tenVal[t]);
			String val1=stri.nextToken();
			String val2=stri.nextToken();
			String val3=stri.nextToken();
			String val4=stri.nextToken();
			String val5=stri.nextToken();
			String val6=stri.nextToken();
			String val7=stri.nextToken();
			String val8=stri.nextToken();
		    String val9=stri.nextToken();
		 	String val10=stri.nextToken();

			//	System.out.println("1st num"+val1+"2nd num"+val2+"3rd num"+val3+"\n");
	        for(int z=0;z<numTransactions;z++)
            {	
			             List<String> array1=Arrays.asList(transac[z].split(" "));
			             if(array1.contains(val1)&& array1.contains(val2) && array1.contains(val3) && array1.contains(val4) && array1.contains(val5) && array1.contains(val6) && array1.contains(val7) && array1.contains(val8) && array1.contains(val9) && array1.contains(val10))
						 
                         {
						  //   System.out.println("count3[t]");
							 
                            count10[t]++;
                             
							  

                         }						 
		 
		    }
	
						//  file_out.write(count3[t]+":index:"+t+"\n");

		 }
       	
	
	
	
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=h10-1;e++)
		{          for(int r=0;r<(h10-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count10[r])<(count10[r+1]))
				{
					String s1=new String();
					int x;
					s1=tenVal[r];
				//	System.out.println("e= "+e+" r"+r);
					tenVal[r]=tenVal[r+1];
					tenVal[r+1]=s1;
					x=count10[r];
					
					count10[r]=count10[r+1];
					count10[r+1]=x;
				}
			}
		}             				
     int threshold_index9=0;
       int t7;
    //  System.out.println(minSup+"h4"+h4);
	   for(t7=0;t7<=h10-1;t7++)
       {
                   
		  if(count10[t7]<minSup) 
            {
			  //   System.out.println(t);
		         threshold_index9=t7;	
                  break;
				  
            }	
		   if(t7==h10-1)
              threshold_index9=h10;		   
	   } 
	   
System.out.println(" End of 10 frequent Itemset");

/**********************************************************11 item set**********************************************************************************************************************************************/


array_limit=(threshold_index9*(threshold_index9-1))/2;
String e11Val[]=new String[array_limit];
	   int count11[]=new int[array_limit];
	   
           

    /*   for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}*/
			int h11=0;
			int flag11=0;
			 for(int x=0;x<=threshold_index9-1;x++)
		     {   
                 //      System.out.println("item9"+x);
		               for(int a=x+1;a<=(threshold_index9-1);a++)
                       {
					     //  file_out.write(tenVal[x]+":"+tenVal[a]+"\n");
					   
			                StringTokenizer str1=new StringTokenizer(tenVal[x]);
			                StringTokenizer str2=new StringTokenizer(tenVal[a]);
			                String val1=str1.nextToken();   
				            String val2=str2.nextToken();   
				            String val1_2=str1.nextToken();   
				            String val2_2=str2.nextToken();   
				            String val1_3=str1.nextToken();   
				            String val2_3=str2.nextToken();   
				              String val1_4=str1.nextToken();   
				            String val2_4=str2.nextToken();   
				               String val1_5=str1.nextToken();   
				            String val2_5=str2.nextToken();   
				             String val1_6=str1.nextToken();   
				            String val2_6=str2.nextToken();   
				               String val1_7=str1.nextToken();   
				            String val2_7=str2.nextToken();   
				            String val1_8=str1.nextToken();   
				            String val2_8=str2.nextToken();   
				            String val1_9=str1.nextToken();   
				            String val2_9=str2.nextToken();   
				           
					//		System.out.println("a1");
				            if(val1.equals(val2) && val1_2.equals(val2_2) && val1_3.equals(val2_3) && val1_4.equals(val2_4) && val1_5.equals(val2_5)  && val1_6.equals(val2_6) && val1_7.equals(val2_7) && val1_8.equals(val2_8) && val1_9.equals(val2_9))
				         {
                                  String val2_10=str2.nextToken(); 						          
                                  String val1_10=str1.nextToken(); 						          
                                     
                                  if(Integer.parseInt(val1_10)<Integer.parseInt(val2_10))
                                       e11Val[h11]=tenVal[x]+" "+val2_10;		
                              else {
								            
								       e11Val[h11]= new StringBuffer(tenVal[x]).insert(tenVal[x].length()-val1_10.length(),val2_10+" ").toString();
								  
								  }
								  //e11Val[h11]=tenVal[x]+" "+val2_10;	
                                         								  
					           flag11=1;    			  
				//	      file_out.write(val1+" :"+val1_2+" : "+val1_3+" : "+val1_4+" : "+val1_5+" : "+val1_6+" : "+val1_7+" : "+val1_8+": "+val1_9+" : "+val1_10+": "+val2_10+":"+ e11Val[h11]+" index"+h11+"\n");
						 }
						// System.out.println(count2[f]);
						 if(flag11==1)
						 {
						 h11++;
						 flag11=0;
						 }
					    
					  }	 
					  
			}
			
	for(int t=0;t<h11;t++)
		 {
              	//	System.out.println(t);
			StringTokenizer stri=new StringTokenizer(e11Val[t]);
			String val1=stri.nextToken();
			String val2=stri.nextToken();
			String val3=stri.nextToken();
			String val4=stri.nextToken();
			String val5=stri.nextToken();
			String val6=stri.nextToken();
			String val7=stri.nextToken();
			String val8=stri.nextToken();
		    String val9=stri.nextToken();
		 	String val10=stri.nextToken();
            String val11=stri.nextToken();
		
			//	System.out.println("1st num"+val1+"2nd num"+val2+"3rd num"+val3+"\n");
	        for(int z=0;z<numTransactions;z++)
            {	
			             List<String> array1=Arrays.asList(transac[z].split(" "));
			             if(array1.contains(val1)&& array1.contains(val2) && array1.contains(val3) && array1.contains(val4) && array1.contains(val5) && array1.contains(val6) && array1.contains(val7) && array1.contains(val8) && array1.contains(val9) && array1.contains(val10) && array1.contains(val11))
						 
                         {
						  //   System.out.println("count3[t]");
							 
                            count11[t]++;
                             
							  

                         }						 
		 
		    }
	
						//  file_out.write(count3[t]+":index:"+t+"\n");

		 }
       	
	
	
	
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=h11-1;e++)
		{          for(int r=0;r<(h11-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count11[r])<(count11[r+1]))
				{
					String s1=new String();
					int x;
					s1=e11Val[r];
				//	System.out.println("e= "+e+" r"+r);
					e11Val[r]=e11Val[r+1];
					e11Val[r+1]=s1;
					x=count11[r];
					
					count11[r]=count11[r+1];
					count11[r+1]=x;
				}
			}
		}             				
     int threshold_index10=0;
       int t8;
    //  System.out.println(minSup+"h4"+h4);
	   for(t8=0;t8<=h11-1;t8++)
       {
                   
		  if(count11[t8]<minSup) 
            {
			  //   System.out.println(t);
		         threshold_index10=t8;	
                  break;
				  
            }	
		   if(t8==h11-1)
              threshold_index10=h11;		   
	   } 
	   
System.out.println(" End of 11 frequent Itemset");

/*****************************************************************************12 item set****************************************************************************************************/

array_limit=(threshold_index10*(threshold_index10-1))/2;
String t12Val[]=new String[array_limit];
	   int count12[]=new int[array_limit];
	   
           

    /*   for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}*/
			int h12=0;
			int flag12=0;
			 for(int x=0;x<=threshold_index10-1;x++)
		     {   
                 //      System.out.println("item9"+x);
		               for(int a=x+1;a<=(threshold_index10-1);a++)
                       {
					     //  file_out.write(tenVal[x]+":"+tenVal[a]+"\n");
					   
			                StringTokenizer str1=new StringTokenizer(e11Val[x]);
			                StringTokenizer str2=new StringTokenizer(e11Val[a]);
			                String val1=str1.nextToken();   
				            String val2=str2.nextToken();   
				            String val1_2=str1.nextToken();   
				            String val2_2=str2.nextToken();   
				            String val1_3=str1.nextToken();   
				            String val2_3=str2.nextToken();   
				              String val1_4=str1.nextToken();   
				            String val2_4=str2.nextToken();   
				               String val1_5=str1.nextToken();   
				            String val2_5=str2.nextToken();   
				             String val1_6=str1.nextToken();   
				            String val2_6=str2.nextToken();   
				               String val1_7=str1.nextToken();   
				            String val2_7=str2.nextToken();   
				            String val1_8=str1.nextToken();   
				            String val2_8=str2.nextToken();   
				            String val1_9=str1.nextToken();   
				            String val2_9=str2.nextToken();   
				                  String val1_10=str1.nextToken();   
				            String val2_10=str2.nextToken();   
				     
					//		System.out.println("a1");
				            if(val1.equals(val2) && val1_2.equals(val2_2) && val1_3.equals(val2_3) && val1_4.equals(val2_4) && val1_5.equals(val2_5)  && val1_6.equals(val2_6) && val1_7.equals(val2_7) && val1_8.equals(val2_8) && val1_9.equals(val2_9) && val1_10.equals(val2_10))
				         {
                                  String val2_11=str2.nextToken(); 						          
                                  String val1_11=str1.nextToken(); 						          
                                   
                                  if(Integer.parseInt(val1_11)<Integer.parseInt(val2_11))
                                      t12Val[h12]=e11Val[x]+" "+val2_11;	
 		
                              else {
								            
								       t12Val[h12]= new StringBuffer(e11Val[x]).insert(e11Val[x].length()-val1_11.length(),val2_11+" ").toString();
								  
								  }  
 //                                 t12Val[h12]=e11Val[x]+" "+val2_11;	
                                         								  
					           flag12=1;    			  
				//	      file_out.write(val1+" :"+val1_2+" : "+val1_3+" : "+val1_4+" : "+val1_5+" : "+val1_6+" : "+val1_7+" : "+val1_8+": "+val1_9+" : "+val1_10+" : "+val1_11+": "+val2_11+":"+ t12Val[h12]+" index"+h12+"\n");
						 }
						// System.out.println(count2[f]);
						 if(flag12==1)
						 {
						 h12++;
						 flag12=0;
						 }
					    
					  }	 
					  
			}
			
	for(int t=0;t<h12;t++)
		 {
              	//	System.out.println(t);
			StringTokenizer stri=new StringTokenizer(t12Val[t]);
			String val1=stri.nextToken();
			String val2=stri.nextToken();
			String val3=stri.nextToken();
			String val4=stri.nextToken();
			String val5=stri.nextToken();
			String val6=stri.nextToken();
			String val7=stri.nextToken();
			String val8=stri.nextToken();
		    String val9=stri.nextToken();
		 	String val10=stri.nextToken();
            String val11=stri.nextToken();
            String val12=stri.nextToken();
		
			//	System.out.println("1st num"+val1+"2nd num"+val2+"3rd num"+val3+"\n");
	        for(int z=0;z<numTransactions;z++)
            {	
			             List<String> array1=Arrays.asList(transac[z].split(" "));
			             if(array1.contains(val1)&& array1.contains(val2) && array1.contains(val3) && array1.contains(val4) && array1.contains(val5) && array1.contains(val6) && array1.contains(val7) && array1.contains(val8) && array1.contains(val9) && array1.contains(val10) && array1.contains(val11) && array1.contains(val12))
						 
                         {
						  //   System.out.println("count3[t]");
							 
                            count12[t]++;
                             
							  

                         }						 
		 
		    }
	
						//  file_out.write(count3[t]+":index:"+t+"\n");

		 }
       	
	
	
	
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=h12-1;e++)
		{          for(int r=0;r<(h12-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count12[r])<(count12[r+1]))
				{
					String s1=new String();
					int x;
					s1=t12Val[r];
				//	System.out.println("e= "+e+" r"+r);
					t12Val[r]=t12Val[r+1];
					t12Val[r+1]=s1;
					x=count12[r];
					
					count12[r]=count12[r+1];
					count12[r+1]=x;
				}
			}
		}             				
     int threshold_index11=0;
       int t9;
    //  System.out.println(minSup+"h4"+h4);
	   for(t9=0;t9<=h12-1;t9++)
       {
                   
		  if(count12[t9]<minSup) 
            {
			  //   System.out.println(t);
		         threshold_index11=t9;	
                  break;
				  
            }	
		   if(t9==h12-1)
              threshold_index11=h12;		   
	   } 
	   
System.out.println(" End of 12 frequent Itemset");

/************************************************************************************13 item set*****************************************************************************************************/
	
array_limit=(threshold_index11*(threshold_index11-1))/2;

String t13Val[]=new String[array_limit];
	   int count13[]=new int[array_limit];
	   
           

    /*   for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}*/
			int h13=0;
			int flag13=0;
			 for(int x=0;x<=threshold_index11-1;x++)
		     {   
                 //      System.out.println("item9"+x);
		               for(int a=x+1;a<=(threshold_index11-1);a++)
                       {
					     //  file_out.write(tenVal[x]+":"+tenVal[a]+"\n");
					   
			                StringTokenizer str1=new StringTokenizer(t12Val[x]);
			                StringTokenizer str2=new StringTokenizer(t12Val[a]);
			                String val1=str1.nextToken();   
				            String val2=str2.nextToken();   
				            String val1_2=str1.nextToken();   
				            String val2_2=str2.nextToken();   
				            String val1_3=str1.nextToken();   
				            String val2_3=str2.nextToken();   
				              String val1_4=str1.nextToken();   
				            String val2_4=str2.nextToken();   
				               String val1_5=str1.nextToken();   
				            String val2_5=str2.nextToken();   
				             String val1_6=str1.nextToken();   
				            String val2_6=str2.nextToken();   
				               String val1_7=str1.nextToken();   
				            String val2_7=str2.nextToken();   
				            String val1_8=str1.nextToken();   
				            String val2_8=str2.nextToken();   
				            String val1_9=str1.nextToken();   
				            String val2_9=str2.nextToken();   
				                  String val1_10=str1.nextToken();   
				            String val2_10=str2.nextToken();   
				                 String val1_11=str1.nextToken();   
				            String val2_11=str2.nextToken();   
				     
					 
					//		System.out.println("a1");
				            if(val1.equals(val2) && val1_2.equals(val2_2) && val1_3.equals(val2_3) && val1_4.equals(val2_4) && val1_5.equals(val2_5)  && val1_6.equals(val2_6) && val1_7.equals(val2_7) && val1_8.equals(val2_8) && val1_9.equals(val2_9) && val1_10.equals(val2_10) && val1_11.equals(val2_11))
				         {
                                  String val2_12=str2.nextToken(); 						          
                                  String val1_12=str1.nextToken(); 						          
                                  if(Integer.parseInt(val1_12)<Integer.parseInt(val2_12))
                                    t13Val[h13]=t12Val[x]+" "+val2_12;	
                                   else {
								            
								       t13Val[h13]= new StringBuffer(t12Val[x]).insert(t12Val[x].length()-val1_12.length(),val2_12+" ").toString();
								  
								  }   
                                //  t13Val[h13]=t12Val[x]+" "+val2_12;	
                                         								  
					           flag13=1;    			  
		//			      file_out.write(val1+" :"+val1_2+" : "+val1_3+" : "+val1_4+" : "+val1_5+" : "+val1_6+" : "+val1_7+" : "+val1_8+": "+val1_9+" : "+val1_10+" : "+val1_11+" : "+val1_12+": "+val2_12+"::"+ t13Val[h13]+" index"+h13+"\n");
						 }
						// System.out.println(count2[f]);
						 if(flag13==1)
						 {
						 h13++;
						 flag13=0;
						 }
					    
					  }	 
					  
			}
			
	for(int t=0;t<h13;t++)
		 {
              	//	System.out.println(t);
			StringTokenizer stri=new StringTokenizer(t13Val[t]);
			String val1=stri.nextToken();
			String val2=stri.nextToken();
			String val3=stri.nextToken();
			String val4=stri.nextToken();
			String val5=stri.nextToken();
			String val6=stri.nextToken();
			String val7=stri.nextToken();
			String val8=stri.nextToken();
		    String val9=stri.nextToken();
		 	String val10=stri.nextToken();
            String val11=stri.nextToken();
            String val12=stri.nextToken();
	        String val13=stri.nextToken();
		
			//	System.out.println("1st num"+val1+"2nd num"+val2+"3rd num"+val3+"\n");
	        for(int z=0;z<numTransactions;z++)
            {	
			             List<String> array1=Arrays.asList(transac[z].split(" "));
			             if(array1.contains(val1)&& array1.contains(val2) && array1.contains(val3) && array1.contains(val4) && array1.contains(val5) && array1.contains(val6) && array1.contains(val7) && array1.contains(val8) && array1.contains(val9) && array1.contains(val10) && array1.contains(val11) && array1.contains(val12) && array1.contains(val13))
						 
                         {
						  //   System.out.println("count3[t]");
							 
                            count13[t]++;
                             
							  

                         }						 
		 
		    }
	
						//  file_out.write(count3[t]+":index:"+t+"\n");

		 }
       	
	
	
	
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=h13-1;e++)
		{          for(int r=0;r<(h13-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count13[r])<(count13[r+1]))
				{
					String s1=new String();
					int x;
					s1=t13Val[r];
				//	System.out.println("e= "+e+" r"+r);
					t13Val[r]=t13Val[r+1];
					t13Val[r+1]=s1;
					x=count13[r];
					
					count13[r]=count13[r+1];
					count13[r+1]=x;
				}
			}
		}             				
     int threshold_index12=0;
       int t10;
    //  System.out.println(minSup+"h4"+h4);
	   for(t10=0;t10<=h13-1;t10++)
       {
                   
		  if(count13[t10]<minSup) 
            {
			  //   System.out.println(t);
		         threshold_index12=t10;	
                  break;
				  
            }	
		   if(t10==h13-1)
              threshold_index12=h13;		   
	   } 
	   
System.out.println(" End of 13 frequent Itemset");	
/**********************************************************************************14 item set************************************************************************************************/	
	
	array_limit=(threshold_index12*(threshold_index12-1))/2;
	String f14Val[]=new String[array_limit];
	   int count14[]=new int[array_limit];
	   
           

    /*   for(int l=0;l<threshold_index;l++)
            {    System.out.println(oneVal[l]);		   
                   if(transac[0].indexOf(oneVal[1])!=-1);
				       String a=oneVal[l] +" "+ oneVal[l+1];
					   System.out.println(a);
					   
			}*/
			int h14=0;
			int flag14=0;
							System.out.println("a1");
			
			 for(int x=0;x<=threshold_index12-1;x++)
		     {   
                 //      System.out.println("item9"+x);
		               for(int a=x+1;a<=(threshold_index12-1);a++)
                       {
					     //  file_out.write(tenVal[x]+":"+tenVal[a]+"\n");
					   
			                StringTokenizer str1=new StringTokenizer(t13Val[x]);
			                StringTokenizer str2=new StringTokenizer(t13Val[a]);
			                String val1=str1.nextToken();   
				            String val2=str2.nextToken();   
				            String val1_2=str1.nextToken();   
				            String val2_2=str2.nextToken();   
				            String val1_3=str1.nextToken();   
				            String val2_3=str2.nextToken();   
				              String val1_4=str1.nextToken();   
				            String val2_4=str2.nextToken();   
				               String val1_5=str1.nextToken();   
				            String val2_5=str2.nextToken();   
				             String val1_6=str1.nextToken();   
				            String val2_6=str2.nextToken();   
				               String val1_7=str1.nextToken();   
				            String val2_7=str2.nextToken();   
				            String val1_8=str1.nextToken();   
				            String val2_8=str2.nextToken();   
				            String val1_9=str1.nextToken();   
				            String val2_9=str2.nextToken();   
				                  String val1_10=str1.nextToken();   
				            String val2_10=str2.nextToken();   
				                 String val1_11=str1.nextToken();   
				            String val2_11=str2.nextToken();   
				            String val1_12=str1.nextToken();   
				            String val2_12=str2.nextToken();   
				     
					 
					//		System.out.println("a1");
				            if(val1.equals(val2) && val1_2.equals(val2_2) && val1_3.equals(val2_3) && val1_4.equals(val2_4) && val1_5.equals(val2_5)  && val1_6.equals(val2_6) && val1_7.equals(val2_7) && val1_8.equals(val2_8) && val1_9.equals(val2_9) && val1_10.equals(val2_10) && val1_11.equals(val2_11) && val1_12.equals(val2_12))
				         {
                                  String val2_13=str2.nextToken(); 						          
                                  String val1_13=str1.nextToken(); 						          
                                  if(Integer.parseInt(val1_13)<Integer.parseInt(val2_13))
                                   f14Val[h14]=t13Val[x]+" "+val2_13;	
                                   else {
								            
								       f14Val[h14]= new StringBuffer(t13Val[x]).insert(t13Val[x].length()-val1_13.length(),val2_13+" ").toString();
								  
								  }   
                                  //f14Val[h14]=t13Val[x]+" "+val2_13;	
                                         								  
					           flag14=1;    			  
					//      file_out.write(val1+" :"+val1_2+" : "+val1_3+" : "+val1_4+" : "+val1_5+" : "+val1_6+" : "+val1_7+" : "+val1_8+": "+val1_9+" : "+val1_10+" : "+val1_11+" : "+val1_12+" : "+val1_13+": "+val2_13+"::"+ f14Val[h14]+" index"+h14+"\n");
						 }
						// System.out.println(count2[f]);
						 if(flag14==1)
						 {
						 h14++;
						 flag14=0;
						 }
					    
					  }	 
					  
			}
							System.out.println("a2");
			
	for(int t=0;t<h14;t++)
		 {
              	//	System.out.println(t);
			StringTokenizer stri=new StringTokenizer(f14Val[t]);
			String val1=stri.nextToken();
			String val2=stri.nextToken();
			String val3=stri.nextToken();
			String val4=stri.nextToken();
			String val5=stri.nextToken();
			String val6=stri.nextToken();
			String val7=stri.nextToken();
			String val8=stri.nextToken();
		    String val9=stri.nextToken();
		 	String val10=stri.nextToken();
            String val11=stri.nextToken();
            String val12=stri.nextToken();
	        String val13=stri.nextToken();
            String val14=stri.nextToken();
  		
			//	System.out.println("1st num"+val1+"2nd num"+val2+"3rd num"+val3+"\n");
	        for(int z=0;z<numTransactions;z++)
            {	
			             List<String> array1=Arrays.asList(transac[z].split(" "));
			             if(array1.contains(val1)&& array1.contains(val2) && array1.contains(val3) && array1.contains(val4) && array1.contains(val5) && array1.contains(val6) && array1.contains(val7) && array1.contains(val8) && array1.contains(val9) && array1.contains(val10) && array1.contains(val11) && array1.contains(val12) && array1.contains(val13) && array1.contains(val14))
						 
                         {
						  //   System.out.println("count3[t]");
							 
                            count14[t]++;
                             
							  

                         }						 
		 
		    }
	
						//  file_out.write(count3[t]+":index:"+t+"\n");

		 }
       	
	
	
	
	//   System.out.println(Candid_limit);
	 //  System.out.println(count2.length);
	//   System.out.println(twoVal.length);
	  
     for(int e=0;e<=h14-1;e++)
		{          for(int r=0;r<(h14-(e+1));r++)
			{
			 // System.out.println("e= "+e+" r"+r);
						if((count14[r])<(count14[r+1]))
				{
					String s1=new String();
					int x;
					s1=f14Val[r];
				//	System.out.println("e= "+e+" r"+r);
					f14Val[r]=f14Val[r+1];
					f14Val[r+1]=s1;
					x=count14[r];
					
					count14[r]=count14[r+1];
					count14[r+1]=x;
				}
			}
		}             				
     int threshold_index13=0;
       int t11;
    //  System.out.println(minSup+"h4"+h4);
	   for(t11=0;t11<=h14-1;t11++)
       {
                   
		  if(count14[t11]<minSup) 
            {
			  //   System.out.println(t);
		         threshold_index13=t11;	
                  break;
				  
            }	
		   if(t11==h14-1)
              threshold_index13=h14;		   
	   } 
	   
System.out.println(" End of 14 frequent Itemset");	
	
	
	
	
	
	
	//fw= new FileWriter(outputFile);
         //   file_out = new BufferedWriter(fw);
/*****************************************************************************************Display part****************************************************************************/	   
	   for(int m=0;m<=threshold_index-1;m++)
             {
		//	 System.out.println("a9");
                 file_out.write("File ID is "+oneVal[m]+" and its count is "+count[m]+" and "+m+ "\n");
			    
			 }
			  file_out.write("\n ");
          for(int s=0;s<=threshold_index1-1;s++)
             {
			 
		//	 System.out.println("a9");
                 file_out.write("File ID is "+twoVal[s]+" and its count is "+count2[s]+" and "+s+ "\n");
			
			 } 			
			  file_out.write("\n "); 
		    for(int s=0;s<=threshold_index2-1;s++)
             {
			 
		  // System.out.println("a9");
                 file_out.write("File ID is "+threeVal[s]+" and its count is "+count3[s]+" and "+s+ "\n");
			
			 }  	
			  file_out.write("\n "); 
			 for(int s=0;s<=threshold_index3-1;s++)
             {
			 
		  // System.out.println("a9");
                 file_out.write("File ID is "+fourVal[s]+" and its count is "+count4[s]+" and "+s+ "\n");
			
			 } 
			   file_out.write("\n "); 
			 for(int s=0;s<=threshold_index4-1;s++)
             {
			 
		  // System.out.println("a9");
                 file_out.write("File ID is "+fiveVal[s]+" and its count is "+count5[s]+" and "+s+ "\n");
			
			 } 
             	   file_out.write("\n "); 
			 for(int s=0;s<=threshold_index5-1;s++)
             {
			 
		  // System.out.println("a9");
                 file_out.write("File ID is "+sixVal[s]+" and its count is "+count6[s]+" and "+s+ "\n");
			
			 } 
                file_out.write("\n "); 
			 for(int s=0;s<=threshold_index6-1;s++)
             {
			 
		  // System.out.println("a9");
                 file_out.write("File ID is "+sevenVal[s]+" and its count is "+count7[s]+" and "+s+ "\n");
			
			 } 			
		             file_out.write("\n "); 
			 for(int s=0;s<=threshold_index7-1;s++)
             {
			 
		  // System.out.println("a9");
                 file_out.write("File ID is "+eightVal[s]+" and its count is "+count8[s]+" and "+s+ "\n");
			
			 } 			
	         	             file_out.write("\n "); 
			 for(int s=0;s<=threshold_index8-1;s++)
             {
			 
		  // System.out.println("a9");
                 file_out.write("File ID is "+nineVal[s]+" and its count is "+count9[s]+" and "+s+ "\n");
			
			 } 			
			   	             file_out.write("\n "); 
			 for(int s=0;s<=threshold_index9-1;s++)
             {
			 
		  // System.out.println("a9");
                 file_out.write("File ID is "+tenVal[s]+" and its count is "+count10[s]+" and "+s+ "\n");
			
			 } 			
			 	   	             file_out.write("\n "); 
			 for(int s=0;s<=threshold_index10-1;s++)
             {
			 
		  // System.out.println("a9");
                 file_out.write("File ID is "+e11Val[s]+" and its count is "+count11[s]+" and "+s+ "\n");
			
			 } 			
			   	             file_out.write("\n "); 
			 for(int s=0;s<=threshold_index11-1;s++)
             {
			 
		  // System.out.println("a9");
                 file_out.write("File ID is "+t12Val[s]+" and its count is "+count12[s]+" and "+s+ "\n");
			
			 } 			
		  	             file_out.write("\n "); 
			 for(int s=0;s<=threshold_index12-1;s++)
             {
			 
		  // System.out.println("a9");
                 file_out.write("File ID is "+t13Val[s]+" and its count is "+count13[s]+" and "+s+ "\n");
			
			 }
  	             file_out.write("\n "); 
			 for(int s=0;s<=threshold_index13-1;s++)
             {
			 
		  // System.out.println("a9");
                 file_out.write("File ID is "+f14Val[s]+" and its count is "+count14[s]+" and "+s+ "\n");
			
			 }
	    	    
		file_out.close();
			  
	    }
		
         catch(Exception e)
		 {
		      System.out.println(e);
		}		
           
	}
}	