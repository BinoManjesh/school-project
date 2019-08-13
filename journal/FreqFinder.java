package journal;

import java.util.Scanner;

class FreqFinder {
    
    int getFreq(String str, String subStr) {
        int freq = 0;
        int subLen = subStr.length();
        for (int i = 0; i < str.length() - subLen + 1; i++) {
            if (str.substring(i, i + subLen).equals(subStr)) {
                freq++;
            }
        }
        return freq;
    }
    
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter a substring: ");
        String subStr = sc.nextLine();
        
        FreqFinder obj = new FreqFinder();
        System.out.println(obj.getFreq(str, subStr));
    }
}
