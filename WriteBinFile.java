import java.io.*;

class WriteBinFile {
    
    public static void main() throws IOException {
        FileOutputStream fout = new FileOutputStream("jeff.bin");
        DataOutputStream dout = new DataOutputStream(fout);
        for (int i = 0; i < 10; ++i) {
            dout.writeInt(i);
        }
        dout.close();
        fout.close();
    }
}