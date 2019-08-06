import java.util.*;
class CEASER_CIPHER
{
    public static void main()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the string");
        String a=sc.next();
        System.out.println("enter the number");
        int b=sc.nextInt();
        int i;
        char e;
        String h="";
        for(i=0;i<a.length();i++)
        {
            e=a.charAt(i);
            e= Character.toUpperCase(e);
            int d= (((int)e + b -65)%26 + 65);
            if(d<65)
            {
               d+=26;
            }

            h+=(char)(d);
        }
        System.out.println(h);
    }
}