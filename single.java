import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface mysingle
{
  int value();
}
class single
{
  @mysingle(100)
  public static void meth()
  {
    try
    {
     single ob=new single();
     Class c=ob.getClass();
     Method m=c.getMethod("meth");
     mysingle anno=m.getAnnotation(mysingle.class);
     System.out.println(anno.value());
    }
  catch(NoSuchMethodException e)
  {
      System.out.println("method not found ");
  }
 }
 public static void main(String arg[])
 {
   meth();
 }
}