import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface myanno
{
 String str();
 int val();
}
@Retention(RetentionPolicy.RUNTIME)
@interface what{
String des();
}
@what(des="an annotation test class ")
@myanno(str="testing",val=10)
class Meta2
{
  
@what(des="an annotation test class ")
@myanno(str="testing",val=9)
public static void mymeth()
{
  Meta2 ob=new Meta2();
  try
  {
      Annotation annos[]=ob.getClass().getAnnotations();
      System.out.println(" all annotations for meta2 ");
      for(Annotation a:annos)
         System.out.println(a);
      System.out.println();
      Method m=ob.getClass().getMethod("mymeth");
      annos=m.getAnnotations();
      System.out.println(" all annotatios for mymeth");
      for(Annotation a:annos)
      System.out.println(a);
  }
  catch(NoSuchMethodException ex)
  {
      System.out.println(" method not found ");
  }
 }
public static void main(String arg[])
{
 mymeth();
 }
}     

