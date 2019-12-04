import java.util.*;
import javax.swing.*;
public class graph extends JFrame
{
    static String xCO;static int xCo;static String yCO;static int yCo;
    static void equation()
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("enter the equation");
        String h=sc.next();int g=0;;
        for(int f=0;f<h.length();f++)
        {
          if(){}   
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
              break;
            }
         
        }
        System.out.println(xCo+" "+yCo);
    }
}
