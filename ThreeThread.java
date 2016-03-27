import java.lang.Throwable;
class ThreeThreads implements Runnable
{
Thread t;
String s;
int n;
ThreeThreads(String x,int n)
{
s=x;
t=new Thread(this,x);
this.n=n;
t.start();
}
public void run()
{
try
{
while(true)
{
System.out.println(s);
t.sleep(n);
}
}
catch(InterruptedException e)
{
System.out.println("InterruptedException"+e);
}
}
}
class ThreeThread
{
public static void main(String args[])
{
new ThreeThreads("Good Morning",1000);
new ThreeThreads("Hello",2000);
new ThreeThreads("Welcome",3000);
System.out.println(" press ctrl+c to stop ");


}
}
