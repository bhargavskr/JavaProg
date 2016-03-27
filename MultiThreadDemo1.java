class NewThread implements Runnable
{
	Thread t;
	NewThread(String n)
	{
		t=new Thread(this,n);
		System.out.println("Thread begin"+t);
		t.start();
	}
	
	
	public void run()
	{
		try
		{
			
				for(int n=5;n>0;n--) 
				{
					System.out.println(t+" "+n);
					Thread.sleep(500);
				
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println("Child Thread end");
		
	}
}

class MultiThreadDemo1
{
		public static void main(String args[])
		{
				NewThread one=new NewThread("one");
				NewThread two=new NewThread("two");
				NewThread three=new NewThread("three");
			try
			{
			
				for(int n=5;n>0;n--) 
				{
					System.out.println(n);
					Thread.sleep(1000);
				
				}
				
			}	
			catch(Exception e)
			{
			  System.out.println("main problem ");
			
			}
			System.out.println("Main end");
			
		}
		
}