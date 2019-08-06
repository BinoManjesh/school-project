import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class Overflow {
    
    public static void main() throws FileNotFoundException, IOException {
        int i = 0;
        while(true) {
            File file = new File("C:\\Users\\Student.ICSELAB-16\\Desktop\\bino\\" + i + ".txt");
            file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            pw.println("My name jeff");
            pw.close();
        }
    }
}
