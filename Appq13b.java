import javax.swing.*;
import java.awt.*;
/*<applet code="Appq13b.class" height=310 width=400>
</applet>*/	
public class Appq13b extends JApplet
{
public void init()
{
Container contentpane=getContentPane();
contentpane.setLayout(new BorderLayout());
final String[] colHeads = { "Name", "Phone", "Fax." };
final Object[][] data = {
			{"vijay","1234","1234"},
   			{"Vinod","3456","3456"},
 			{"siva","1256","1256"}
		};
JTable table=new JTable(data,colHeads);
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
JScrollPane jsp=new JScrollPane(table,v,h);
contentpane.add(jsp,BorderLayout.CENTER);
}
}