import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class BuffTest {
    
    public static void main() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter something: ");
        String sent = r.readLine();
        System.out.println("You entered: " + sent);
    }
}
