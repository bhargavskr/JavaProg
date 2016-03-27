import java.util.*;
import java.io.*;
class Student 
{
	int id;
	String name;
	Student(int id,String name)
	{
		this.id=id;
		this.name=name;
	
	
	}
public 	int getId()
	{
		
		return id;
	}
public 	String getName()
	{
	
		return name;
		
	
	}
	
	public void setId(int id)
	{
		this.id=id;
		
	}
	
	public void setName(String name)
	{
		this.name=name;
		
	}
	
}
kjkljkkjkkllklkdaldsalkasdksaka 
class StudentSort implements Comparator 
{

public int compare(Object a,Object b)
		{
		Student	s1=(Student)a;
		Student s2=(Student)b;
		int aId,bId;
			String aSt,bSt;
			aId=s1.getId();
			aSt=s1.getName();
			bId=s2.getId();
			bSt=s2.getName();
			
			
			
			
			return aSt.compareTo(bSt);
			
			
	}


}

class StudentSortName
{

	public static void main(String arg[])
	{
	TreeSet<Student > s=new TreeSet<Student>(new StudentSort());
	Student a=new Student(2,"Lucy");
	s.add(a);
			a=new Student(4,"Andrew");
	s.add(a);
			a=new Student(3,"Thomas");
		
	s.add(a);
			a=new Student(1,"Alex");
	s.add(a);

	for(Student st:s)
	    System.out.println(st.getId()+" "+st.getName());
		
	
	
	
	
	}
	

}
		
	
