import java.io.*;

class Useless {

    public static void main() throws IOException {
        File file = new File("C:\\Users\\Student.ICSELAB-16\\Desktop\\bino\\jeff.bin");
        file.createNewFile();
        FileOutputStream s = new FileOutputStream(file);
        DataOutputStream dout = new DataOutputStream(s);
    }
}
