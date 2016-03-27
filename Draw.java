import java.applet.*;
import java.awt.*;
/*<applet code="Draw.class" width=200 height=200>
  </applet>*/
public void Draw extends Applet
{
   public void paint(Graphics g)
   {
     g.drawOval(150,150,50,50);
     g.setColor(Color.RED)
     g.fillOval(150,150,50,50);
     g.drawLine(150,200,50,0);
     g.setColor(color.RED);
     g.drawRect(150,250,50,50);
     g.setColor(Color.red);
     g.fillRect(150,250,50,50);
   }
}