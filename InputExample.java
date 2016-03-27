import java.util.*;


class InputExample
{
public static void main(String arg[])
{
	Scanner input= new Scanner(System.in);
	System.out.println(" Enter your age ");
	int age=input.nextInt();
	System.out.println(" Enter Maximum heart rate ");
	double rate=input.nextDouble();
	double fb=(rate-age)*0.65;
	System.out.println("fat buring heart rate is "+fb);
	System.out.print(" Enter integer ");
	while(!input.hasNextInt()){
	System.out.println("1");
	System.out.println(input.nextLine());
		System.out.println("2");
	System.out.print("not integer");
		System.out.println("3");
	}

	int i=input.nextInt();
	System.out.println("Integer is :"+i);
	
	
	
	
	
					

}

}