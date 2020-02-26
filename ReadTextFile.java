import java.io.*;
import java.util.*;

class ReadTextFile {
    
    public static void main() throws IOException {
        FileInputStream fin = new FileInputStream("jeff.txt");
        Scanner sc = new Scanner(fin);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
        fin.close();
    }
}
