import java.io.*;

class ReadBinFile {
    
    public static void main() throws IOException {
        FileInputStream fin = new FileInputStream("jeff.bin");
        DataInputStream din = new DataInputStream(fin);
        boolean end = false;
        while (!end) {
            try {
                System.out.println(din.readInt());
            } catch (EOFException e) {
                end = true;
            }
        }
        din.close();
        fin.close();
    }
}