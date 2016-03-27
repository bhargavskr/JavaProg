/*	
Name: Bhargav S.K. Ravuri
Date:  8th February, 2015
Purpose: To Print all Prime numbers below or equal to given an whole number and count how many prime number are there.
*/
import java.io.*;

class Number
{

	int i=1,j,n,nof,nop=0;
/* 
	Parameter less constructor for Number class where the variable j is initialized to 1, and variable nof which represent number of factors is initialized to 0 
*/
	Number()
	{
		j=1;
		nof=0;
	}
/*
	getData() methods does the processing of finding prime numbers given an whole number as input
*/
	void getData(int n)
	{
                System.out.println("Prime numbers are: "); 
/*
	The while loop checks the each number below and equal to the input whether it is prime number or not
*/	
		while(i<=n)
		{
/*
	After one number is checked nof and j are set to default values. 	
*/			j=1;
			nof=0;
/*
	j is used to represent the a number to check whether the number represented by i is divisible by j or not
*/
			while(j<=i)
			{
/*
	if the number i is divisible by j then remainder will be zero. increment the number of factors and increment j to check whether i is divisible by j or not
*/			
				if(i%j==0)
				nof++;
				j++;
			}
/*
	if number of factors is 2 then print the number and increment nop which keep track of number of prime numbers below n. 
*/                        
			if(nof==2)
			{
				System.out.print(i+" ");
				nop++;
			}
/*
	increment the value of i which to check whether the next number is prime number or not and it is less than or equal to n
*/
			
		        i++;
		}

/*
	Once all the number equal to and below n are checked then print total number of prime numbers identified 
*/
		System.out.println("\nNo. of Prime Numbers :"+nop);
	}
}
/*

	Class that contains the main method where the call to getData() method of Number class is made
*/
class Prime
{
	public static void main(String str[])throws IOException
	{
/*
	Object of Number class is created
*/
		Number pr= new Number();
		
                int x;
/*
	Object of DataInputStream is created to accept input from command line 
*/		
	   DataInputStream dis=new DataInputStream(System.in);
       System.out.println(" Enter any whole number example 0, 1, 2, etc. ");
/*
	The input is read into the Prime class file as String, which is parsed into an Integer 
*/		
	x=Integer.parseInt(dis.readLine());
/*
	a call to getData() method of Number class.	
*/	
	pr.getData(x);
	}
}