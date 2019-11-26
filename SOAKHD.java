import java.io.*;

class SOAKHD {

    public static void main() throws IOException {
        File file = new File("C:\\Users\\Student.ICSELAB-16\\Desktop\\bino\\jeff.bin");
        file.createNewFile();
        FileOutputStream s = new FileOutputStream(file);
        DataOutputStream dout = new DataOutputStream(s);
        dout.writeUTF("jeff");
        dout.close();
        s.close();
    }
}
