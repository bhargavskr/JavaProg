import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface mymarker
{
  }
class marker
{
  @mymarker
  public static void meth()
  {
    try
    {
      marker ob=new marker();
      Class c=ob.getClass();
      Method m=c.getMethod("meth"); 
      if(m.isAnnotationPresent(mymarker.class))
        System.out.println(" mymarker is present ");
    }
   catch(NoSuchMethodException e)
   {
       System.out.println(" no such method ");
   }
  }
  public static void main(String arg[])
  {
     meth();
  }
}	