class NewThread implements Runnable
{
	Thread t;
	NewThread()
	{
		t=new Thread(this,"Demo Thread");
		System.out.println("child thread "+t);
		t.start();
	}
	
	
	public void run()
	{
		try
		{
			
				for(int n=5;n>0;n--) 
				{
					System.out.println(n);
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

class ThreadDemo1
{
		public static void main(String args[])
		{
				new NewThread();
				
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
		