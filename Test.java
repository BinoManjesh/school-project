import java.io.*;
import java.util.*;

class Test {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("cube.obj");
		Scanner sc = new Scanner(fin);
		while (sc.hasNextLine()) {
			Scanner lineSc = new Scanner(sc.nextLine());
			lineSc.useDelimiter("[ /]");
			while(lineSc.hasNext()) {
				System.out.print(lineSc.next() + "|");
			}
			System.out.println();
		}
	}
}