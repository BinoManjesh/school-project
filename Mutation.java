import java.util.*;
/**
 * Write a description of class Mutation here.
 *
 * @author Rahil, Bino
 * @version 0.0.2v
 */
public class Mutation
{
    long a,b,c,d,e,f,g,h,a2,b2,c2,d2,e2,f2,g2,h2,chancnum,generationNumber;float rand;float speed,speedMultiplier; String s;
    String dot="0.0",chance; float roundOff; int mutationNumber,numberOfGens,numMuts,numNorms;float mutChance; static boolean isMutation,isInfinite; String generations;
    
    long startTime;
    void init(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Speed Multiplier");
        System.out.println("\t(KEY)");
        System.out.println("1 --> 1 Generation/second");
        System.out.println("2 --> 2 Generations/second");
        System.out.println("2.5 --> 5 Generation/2 seconds  (STANDARD)");
        System.out.println("0.5 --> 1 Generation/2 seconds");
        System.out.println("Higher the number, higher the speed; lower the number, lower the speed ");
        s=sc.nextLine();
        s=s.concat("f");
        speedMultiplier=Float.parseFloat(s);
        System.out.println("\tHow many generations?");
        System.out.println("Enter number for specfic number of generations");
        System.out.println("Enter Infinite or unspecified for infinite generations");
        generations=sc.nextLine();
        if(generations.toLowerCase().contains("in")||generations.toLowerCase().contains("un")){
            numberOfGens=0;
            isInfinite=true;
        }
        else{
            numberOfGens=Integer.parseInt(generations);
            isInfinite=false;
        }
        System.out.println("Enter 2 single digit numbers, 8 times, each separated by \"b\"");
        s=sc.nextLine();
        a=s.charAt(0);
        a2=s.charAt(2);
        s=sc.nextLine();
        b=s.charAt(0);
        b2=s.charAt(2);
        s=sc.nextLine();
        c=s.charAt(0);
        c2=s.charAt(2);
        s=sc.nextLine();
        d=s.charAt(0);
        d2=s.charAt(2);
        s=sc.nextLine();
        e=s.charAt(0);
        e2=s.charAt(2);
        s=sc.nextLine();
        f=s.charAt(0);
        f2=s.charAt(2);
        s=sc.nextLine();
        g=s.charAt(0);
        g2=s.charAt(2);
        s=sc.nextLine();
        h=s.charAt(0);
        h2=s.charAt(2);
        isMutation=false;
        mutChance=0.1f;
        generationNumber=1;
        speed=1000/speedMultiplier;
        numMuts=0;
        numNorms=0;
    }

    void calc(){
        try{
            while(true){
                startTime = System.nanoTime();
                Thread.sleep((long)speed);
                chancnum=(int)((Math.random()*100.0))%100;
                chance=dot.concat(String.valueOf(chancnum));
                roundOff=Float.parseFloat(chance);
                if(roundOff>=mutChance){//Mutation happens}
                    isMutation=true;
                    numMuts++;
                    mutChance=mutChance+0.001f;
                    mutationNumber=(int)roundOff*1000;
                    a=(long)(Math.pow(a,((Math.random())*10.5))*1000);   //HEAVY CALCULATION
                    b=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    c=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    d=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    e=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    f=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    g=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    h=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    a2=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    b2=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    c2=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    d2=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    e2=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    f2=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    g2=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    h2=(long)(Math.pow(a,((Math.random())*10.5))*1000);
                    print(generationNumber);
                }
                else{
                    numNorms++;
                    if(Math.random()>0.5){
                        a=(long)(a+(Math.random())*1.2);
                        a2=(long)(a-(Math.random())*1.2);
                    }
                    else{
                        a=(long)(a-(Math.random())*1.2);
                        a2=(long)(a+(Math.random())*1.2);
                    }
                    if(Math.random()>0.5){
                        b=(long)(a+(Math.random())*1.2);
                        b2=(long)(a-(Math.random())*1.2);
                    }
                    else{
                        b=(long)(a-(Math.random())*1.2);
                        b2=(long)(a+(Math.random())*1.2);
                    }
                    if(Math.random()>0.5){
                        c=(long)(a+(Math.random())*1.2);
                        c2=(long)(a-(Math.random())*1.2);
                    }
                    else{
                        c=(long)(a-(Math.random())*1.2);
                        c2=(long)(a+(Math.random())*1.2);
                    }
                    if(Math.random()>0.5){
                        d=(long)(a+(Math.random())*1.2);
                        d2=(long)(a-(Math.random())*1.2);
                    }
                    else{
                        d=(long)(a-(Math.random())*1.2);
                        d2=(long)(a+(Math.random())*1.2);
                    }
                    if(Math.random()>0.5){
                        e=(long)(a+(Math.random())*1.2);
                        e2=(long)(a-(Math.random())*1.2);
                    }
                    else{
                        e=(long)(a-(Math.random())*1.2);
                        e2=(long)(a+(Math.random())*1.2);
                    }
                    if(Math.random()>0.5){
                        f=(long)(a+(Math.random())*1.2);
                        f2=(long)(a-(Math.random())*1.2);
                    }
                    else{
                        f=(long)(a-(Math.random())*1.2);
                        f2=(long)(a+(Math.random())*1.2);
                    }
                    if(Math.random()>0.5){
                        g=(long)(a+(Math.random())*1.2);
                        g2=(long)(a-(Math.random())*1.2);
                    }
                    else{
                        g=(long)(a-(Math.random())*1.2);
                        g2=(long)(a+(Math.random())*1.2);
                    }
                    if(Math.random()>0.5){
                        h=(long)(a+(Math.random())*1.2);
                        h2=(long)(a-(Math.random())*1.2);
                    }
                    else{
                        h=(long)(a-(Math.random())*1.2);
                        h2=(long)(a+(Math.random())*1.2);
                    }
                    print(generationNumber);
                    if(Math.random()>0.5){mutChance=mutChance+0.2f;}
                    else{mutChance=mutChance-0.05f;}
                }
                generationNumber++;
                if(!(isInfinite)){
                    if(generationNumber>numberOfGens){
                        break;
                    }
                }
            }
        }
        catch(InterruptedException io){
            System.out.println("Error in program. Terminating now");
            System.exit(0);
        }
    }

    void print(long genNum){
        if(isMutation){
            System.out.println("\n\n\n\nGeneraton Number: "+genNum+"\n------THIS IS A MUTATION------");
            System.out.println(a+"---"+a2);
            System.out.println(b+"---"+b2);
            System.out.println(c+"---"+c2);
            System.out.println(d+"---"+d2);
            System.out.println(e+"---"+e2);
            System.out.println(f+"---"+f2);
            System.out.println(g+"---"+g2);
            System.out.println(h+"---"+h2);
            System.out.println("---------------XXX------------");
        }
        else{
            System.out.println("\n\n\n\nGeneration Number: "+genNum+"\n---------------XXX------------");
            System.out.println(a+"---"+a2);
            System.out.println(b+"---"+b2);
            System.out.println(c+"---"+c2);
            System.out.println(d+"---"+d2);
            System.out.println(e+"---"+e2);
            System.out.println(f+"---"+f2);
            System.out.println(g+"---"+g2);
            System.out.println(h+"---"+h2);
            System.out.println("---------------XXX------------");
        }
    }

    void results(){
        System.out.println("\tSIMULATION RESULTS ARE HERE:");
        System.out.println("Total generations:"+generationNumber);
        System.out.println("Normal generations:"+numNorms);
        System.out.println("Mutational generations:"+numMuts);
        System.out.println((System.nanoTime() - startTime) * 1E-9);
    }

    public static void main(){
        System.out.print("\u000C");
        Mutation o=new Mutation();
        o.init();
        o.calc();
        
        if(!(isInfinite)){
            o.results();
        }
    }
}