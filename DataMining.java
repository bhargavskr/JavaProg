import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataMining{
	static String str;
	static int j=0;
	static int m=0;

	static int []v;
	//static String []val;
	List<String> al;
	static String []s;
	static int k;
//	int l=0;
	static List<String> l=new ArrayList<String>();
	private static BufferedReader bufferedReader;
	public static void main(String []args) throws IOException{

	//	val=new String[60578];
	bufferedReader = new BufferedReader(new FileReader("C:\\Study\\2\\bhargav\\transa.txt"));
	//bufferedReader.readLine();
	if((str=bufferedReader.readLine())!=null){
		System.out.println(str);
		s=str.split(" ");
		System.out.println(s);
		
//		for(int i=0;i<s.length;i++)
//		{
//			System.out.println("VALUE"+i+ "   "+s[i]);
//			
//		}
	}
		System.out.println(str);
		for(k=1;k<=60000;k++){
			if(m<s.length){
			int r=Integer.parseInt(s[m]);
			if(k==r){
//				val[j]="t";
//				l.add("t");
				System.out.print(r+",");
				String y=r+"";
				l.add(y);
				m++;
			}
			
			
				else
//					val[j]="?";
//					l.add("?");
					System.out.print("?,");
					l.add("?");
			}
			else{ System.out.print("?,");l.add("?"); }
			//j++;
			}
		//}
		System.out.println("m is"+m);
		System.out.println("k is"+k);
		System.out.println("s is"+s.length);
	
		System.out.println("SIZE"+l.size());
BufferedWriter bw=new BufferedWriter(new FileWriter(new File("C:\\Study\\2\\bhargav\\output.txt")));
		
		for(String st:l){
//		System.out.print("  "+st+"\t");
		bw.write(st);
		
   }
	}
}
