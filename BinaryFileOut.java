import java.io.*;

class BinaryFileOut {
    
    public static void main() throws IOException {
        FileOutputStream fout = new FileOutputStream("jeff.bin");
        DataOutputStream dout = new DataOutputStream(fout);
        dout.writeChar('f');
        dout.close();
        fout.close();
    }
}