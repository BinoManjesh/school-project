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
            if(Character.isUpperCase(e))
            {
                h+=(char)(((int)e + b -65)%26 + 65);
                if((int)e<65)
                {
                    h+=(char)(90 - e + 64);
                }
            }
            else if(Character.isLowerCase(e))
            {
                h+=(char)(((int)e + b -97)%26 + 97);
            }
        }
        System.out.println(h);
    }
}

