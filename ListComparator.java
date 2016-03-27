import java.lang.*;
import java.util.*;
import java.io.*;
public class ListComparator
{
public static void main(String arg[])
{
String array[]={"55","3","23","6","7","19"}; 
String str[]=new String[2];
 str[0]="2 3 4 6 7 23 55";
 str[1]="2 3 4 5 7 9 10 11 19 23 55";
int support=0;
int flag=0;
ArrayList<String> Arraylist=new ArrayList<String>();
for(String x:array)
Arraylist.add(x);
 // List<String> array1=Arrays.asList(str.split(" "));
System.out.println("Contenst of list"+Arraylist);
HashMap<String,Integer> tree=new HashMap<String,Integer>();
// ArrayList<String> CheckArraylist=new ArrayList<String>();
Set<Map.Entry<String,Integer>> set=tree.entrySet();
//System.out.println("Contenst of STring"+array1);
for(int i=0;i<2;i++)
{
if(i==0)
flag=1;
if(i==1)
flag=0;

System.out.println(i);
 List<String> list=Arrays.asList(str[i].split(" "));
 ArrayList<String> Arraylist1=new ArrayList<String>();
for(String y:Arraylist)
{
  
  if(list.contains(y))
 {        
		 Arraylist1.add(y);
		 
  }

  
  
  }
System.out.println("Contenst of 0 "+Arraylist1.get(0));  

for(int j=0;j<Arraylist1.size();j++)
{

      String key=Arraylist1.get(j);
        
        if(flag==1)
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
 
}

		     
//Set<Map.Entry<String,Integer>> me=tree.entrySet();
	for(Map.Entry<String,Integer> x:set)
		System.out.println(x.getKey()+":"+x.getValue());
		
	
	//System.out.println("Contenst of Trans"+Arraylist1);
}



} 


}
