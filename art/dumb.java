package art;import java.util.*;import art.Graph;
import javax.swing.*;
public class dumb extends Graph
{
    double Y=0.0;
    static String xCO;static int xCo;static String yCO;static int yCo;
    String h;int g=0;char sign=' ';
    @Override
    double getY(double x) { 
         if(sign=='+')
        {Y=(-1*(x*xCo))/yCo;}
        
         else
         {Y=((x*xCo))/yCo;}

        return Y;        
        
        
    }
    
     void equation()
    {
        super.xScale = 1;
        super.yScale = 1;
        Scanner sc = new Scanner (System.in);
        System.out.println("enter the equation");
         h=sc.next();
           int g=0;char sign=' ';
        for(int f=0;f<h.length();f++)
        {
            if(h.charAt(f)=='+' || h.charAt(f)=='+')
            {sign='+';}
            else if(h.charAt(f)=='-' || h.charAt(f)=='-')
            {sign='-';}
            if(h.charAt(f)=='x' || h.charAt(f)=='X')
            {
              xCO=h.substring(0,f);
              xCo=Integer.parseInt(xCO);
              g=f;
              break;
            }
        }
        
        for(int f=0;f<h.length();f++)
        {if(h.charAt(f)=='y' || h.charAt(f)=='Y')
            {
              yCO=h.substring(g+2,f);
              yCo=Integer.parseInt(yCO);
             
            }
         
        }
        
        int X=1;
        
        
    }
}
