import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface myanno
{
 String str() default "testing";
 int val() default 999;
}
class Meta3
{
  @myanno()
  public static void meth()
  {
    Meta3 ob=new Meta3();
    try
    {
        Class c=ob.getClass();
        Method m=c.getMethod("meth");
        myanno anno=m.getAnnotation(myanno.class);
        System.out.println(anno.str()+"   "+anno.val());
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
    