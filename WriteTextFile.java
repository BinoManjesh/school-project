import java.io.*;
import java.util.*;

class WriteTextFile {
    
    public static void main() throws IOException {
        FileOutputStream fout = new FileOutputStream("jeff.txt");
        PrintWriter pw = new PrintWriter(fout, true);
        pw.println("wowwowowowowowow");
        pw.close();
        fout.close();
    }
}
