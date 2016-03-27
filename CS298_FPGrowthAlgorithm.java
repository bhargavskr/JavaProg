/* FP growth Algorithm Implementation for finding frequent Itemsets */

import java.util.*;
import java.util.Date;
import java.io.*;
import java.sql.*;
//import oracle.jdbc.driver.*;
import java.util.Set;

public class CS298_FPGrowthAlgorithm 
{

	public static void main(String args[]) throws Exception{
		FPGrowth FP = new FPGrowth();
		
		/* Start time */
		Date d=new Date();
		long starttime,endtime;
		d=new Date();
		starttime=d.getTime();
		FP.loadCylinderData();
				
		d=new Date();
		endtime=d.getTime();
		System.out.println("FPGrowth Algorithm takes "+ ((starttime-endtime)/1000)+ "seconds");
		System.out.println("-------------this is the test for output fptree-----------------");
	}
}

class FPGrowth{

	public static final int MAX_CYLINDERS =1257;
	public static final int MAX_CAMPARTMENT =9;
	public static final int INTEGERS_IN_CYLINDER =2048;
	public static final int INTEGERCOUNT_DISK_1_2 =896;
	public static final int MAX_TRANSACTIONS = 65536;
	static int[][] cylinder1=new int[MAX_CYLINDERS][INTEGERS_IN_CYLINDER];//the input file, represent database
	static int cylinderindex=0;
	static int[] Cylinder_Count = new int[MAX_CYLINDERS]; 
	public String[] FP_FrequentItemsets ;
	
	// Maintain the hashmap for finding the frequent items	
	HashMap<Integer,Integer> ItemCount = new HashMap<Integer,Integer>();
	//HashMap<String,Integer> ItemCount = new HashMap<String,Integer>();
	
	// Maintain hashmap<Integer(recordnumber),List<Integers(columnnumbers)> 
	//HashMap<Integer,List<Integer>> transactionFrequentItems = new HashMap<Integer,List<Integer>>();
	HashMap<Integer,HashMap<Integer,Integer>> transactionFrequentItems = new HashMap<Integer,HashMap<Integer,Integer>>();
	
		
	/* Load the diskfiles data into memory */
	public void loadCylinderData() throws Exception{

		File disk1 = new File("diskfile1.txt");
	    if(!disk1.exists())
		{
					    System.out.println("File does not exist.");
					    System.exit(0);
		}

	File disk2 = new File("diskfile2.txt");
		 if(!disk2.exists())
		{
					    System.out.println("File does not exist.");
					    System.exit(0);
		}
	File disk3 = new File("diskfile3.txt");
		 if(!disk3.exists())
		{
					    System.out.println("File does not exist.");
					    System.exit(0);
		}
		
             
	RandomAccessFile rand1 = new RandomAccessFile(disk1,"rw");
	RandomAccessFile rand2 = new RandomAccessFile(disk2,"rw");
	RandomAccessFile rand3 = new RandomAccessFile(disk3,"rw");	
		
		
		int diskptr=56,diskptr1=56,diskptr2=56;
		for(int j=0;j<1257;j++){
		for(int intval=0;intval<896;intval++){
		try{
			rand1.seek(diskptr);  
			cylinder1[j][intval]=rand1.readInt();  
			//System.out.println("integer value "+cylinder1[intval]);
			diskptr+=4;
			}
		catch(IOException e){
			System.out.println(e.getMessage()); }
		}
		for(int intval1=896;intval1<1792;intval1++){
		try{
			rand2.seek(diskptr1);  
			cylinder1[j][intval1]=rand2.readInt();  
			diskptr1+=4;
			}
		catch(IOException e){
			System.out.println(e.getMessage()); }
		}
		
		for(int intval2=1792;intval2<2048;intval2++){
		try{
			rand3.seek(diskptr2);  
			cylinder1[j][intval2]=rand3.readInt();  
			diskptr2+=4;
			}
		catch(IOException e){
			System.out.println(e.getMessage()); }
		} 
		diskptr+=52; // already incremented 4 bytes in the loop
		diskptr1+=52;
		diskptr2+=52;
		}
			
			cylinderCount(cylinder1);	//for 1-itemset support
			transactionItemset(cylinder1);	
			}
	
	/* Calculate the each cylinder bitcount */
	
	public void cylinderCount(int[][] cylinder){
		int countval=0;
			
		for(int cols=0;cols<MAX_CYLINDERS;cols++)//1257
		{ 
			for(int colval=0;colval<INTEGERS_IN_CYLINDER;colval++)//2048
			{	
				int firstcolumn=cylinder1[cols][colval];
				boolean check = false; 
			/* Checking whether the intergers are -Ve or +Ve */
					if(firstcolumn < 0)
					{
						firstcolumn = -firstcolumn;
						check = true;
					}
					if(check == true){
							countval++;
							}
					countval += Integer.bitCount(firstcolumn);
			
			}
					//System.out.println(cols  +"    countval is  "+ countval);
					Cylinder_Count[cols]=countval;
					// Minimum support 50 % --- 32766 , 75% -- 49150, 0.01% -6 
					
					//the 6 means the threshold
					if(countval > 540 ){
						ItemCount.put(cols,countval);//put it into the hashmap
						//ItemCount.put(Integer.toString(cols),countval);
					}
					countval=0;
					
			}
			System.out.println("Hash map Values"+ ItemCount);
			}
			
	/* Find FrequentItem set for each transaction */
		public void transactionItemset(int[][] cylinderdata)
		{   
			int[][] colbits;
			//List<Integer> frequentItemsList = null;
			Map<Integer,Integer> frequentItemsMap = null;
			int transactionId=0; 
			
			for(int colval =0;colval < 2048;colval++) // INTEGERS_IN_CYLINDER
			{	
				colbits = new int[MAX_CYLINDERS][32];
				// Calculating each integer 32 bit binary value and storing in a array
				for(int cols=0;cols<MAX_CYLINDERS;cols++)
				{	
					int index=0;
					int integervalue = cylinder1[cols][colval];
					if( integervalue < 0)
					{	
						integervalue = -integervalue;
						colbits[cols][31] = 1;
						}
					else 
						colbits[cols][31] = 0;
					int leadingZerosCount = Integer.numberOfLeadingZeros(integervalue); // cylinder1[cols][colval]
					String binary = Integer.toBinaryString(integervalue); // cylinder1[cols][colval]
					
					
					for(int bitval=0;bitval<31;bitval++)
					{	
						if(bitval < leadingZerosCount)	
							colbits[cols][bitval] = 0;
						else
						{	//colbits[cols][bitval] = binary.charAt(index);
							Character c= new Character(binary.charAt(index));
							colbits[cols][bitval] = Integer.parseInt(c.toString());
							index++;
							}
						//System.out.print(colbits[cols][bitval]);
						}
				}
				
				/*for(int j=0;j<32;j++)
					System.out.println( "bit value" +colbits[0][j]);
				*/
				// Find the frequent items for 32 transactions
				
				for(int transaction =0;transaction < 32;transaction++)
				{	
					for(int colnum=0;colnum < MAX_CYLINDERS;colnum++)
					{	
					
					// Maintain list of frequent items 
						if(colbits[colnum][transaction] == 1)
						{ 		
							//frequentItemsList=transactionFrequentItems.get(transactionId);
							frequentItemsMap=transactionFrequentItems.get(transactionId);
							//if (frequentItemsList == null)
							if (frequentItemsMap == null)
							{
								//transactionFrequentItems.put(transactionId, frequentItemsList=new ArrayList<Integer>());
								frequentItemsMap=new HashMap<Integer,Integer>();
								//frequentItemsMap.put(colnum,ItemCount.get(colnum));
								transactionFrequentItems.put((Integer)transactionId,(HashMap<Integer,Integer>)frequentItemsMap);
								//System.out.println("Transaction id value"+ transactionId);
																
							}
							//else
							//frequentItemsList.add(colnum);
							if(ItemCount.get(colnum) != null)
								frequentItemsMap.put(colnum,ItemCount.get(colnum));
						}
					}
					transactionId++;
					
					
				}
			}
			//ItemCount = null;  -- comment on 12.31.2011
			//List<Integer> lst = Arrays.asList(cylinder1[]);
			//lst.clear();
			eachTransaction_FPTreeOrder(transactionFrequentItems); // commented on sep 25 for testing
			

			System.out.println("HashMap is"+ transactionFrequentItems);
			System.out.println("Transaction Id "+ transactionId);//only one
				
		}
		
		// Sort the Each transaction based on the Cylinder count Order and insert into FP tree-- Added on 7/18/2011
		public void eachTransaction_FPTreeOrder(HashMap<Integer,HashMap<Integer,Integer>> transactionFrequentItems){
		
		FP_FrequentItemsets = new String[transactionFrequentItems.size()]; //transactionFrequentItems.size()
		int i =0;
		//call here, the tree object, insert into the tree
		FPTree fptreeObject = new FPTree();
		for (int transactionId =0; transactionId < MAX_TRANSACTIONS;transactionId++){
		Map<Integer,Integer> frequentItemsMap = null;
		if( transactionFrequentItems.get(transactionId) != null){
		frequentItemsMap = transactionFrequentItems.get(transactionId);
		frequentItemsMap = sortItems(frequentItemsMap);
		//System.out.println(" After Sorting items "+ frequentItemsMap);		
		
		Set<Integer> itemnames= frequentItemsMap.keySet();  // Large dataset
		Iterator<Integer> itr = itemnames.iterator();
		StringBuilder frequentItems = new StringBuilder();
		while(itr.hasNext()){
			String str = Integer.toString(itr.next());
			frequentItems.append(str);
			frequentItems.append(" ");
			}
			FP_FrequentItemsets[i++] = frequentItems.toString();		
			}
			}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Inserting the frequent items into the fp tree
		// CAlling the fptree, java file
		////here is how the fptree is built!
		for(int j=0; j< FP_FrequentItemsets.length;j++)
		{		
			fptreeObject.insert(FP_FrequentItemsets[j]);//the ordered transaction items!!!!!
		}
		//call the search function here, put the function defination in FPTree.java
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("transaction itemsize"+transactionFrequentItems.size()+" fp tree trans size"+FP_FrequentItemsets.length);
				//fptreeObject.printFPTree();
		}
		
		// END - 7/18/2011
		public Map<Integer,Integer> sortItems (Map<Integer,Integer> unsortedItems) {
   	 
        List<Map.Entry<Integer,Integer>> list = new LinkedList<Map.Entry<Integer,Integer>>(unsortedItems.entrySet());
        //sort list using Comparator
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {
             public int compare(Map.Entry<Integer,Integer> entry1, Map.Entry<Integer,Integer> entry2) {
	           return (entry2.getValue()).compareTo(entry1.getValue());
             }
	});
	
     //System.out.println("list of sorted values "+ list);
//////////////////////////////////////////////////////////////////////list is for the tree	 
        //put sorted list into map again
	Map<Integer,Integer> sortedItems = new LinkedHashMap<Integer,Integer>();
	for (Iterator<Map.Entry<Integer,Integer>> it = list.iterator(); it.hasNext();) {
	     Map.Entry<Integer,Integer> entry = it.next();
	     sortedItems.put(entry.getKey(), entry.getValue());
	}
	list=null;
	return sortedItems;
   }

}