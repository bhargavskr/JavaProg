import java.util.*;

class AlgorithmDemo
{
	public static void main(String Arg[])
	{
		LinkedList<Integer> l=new LinkedList<Integer>();
		l.add(2);
		l.add(287);
		l.add(76);
		
		Comparator<Integer> r=Collections.reverseOrder();
		Collections.sort(l,r);
		
		for(int k:l)
		System.out.print(k+" ");
		
		System.out.println();
		
		Collections.shuffle(l);

		for( int k:l)
		System.out.println(k);
		
		System.out.println("min "+Collections.min(l));
		
		System.out.println(" max "+Collections.max(l));
		
		
			
		
	}












}
