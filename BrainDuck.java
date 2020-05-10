import java.io.*;
import java.util.Stack;

class BrainDuck {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fin = getStream(args[0], 0);
		byte[] memory = new byte[65536];
		for (int i = 0; i < 65536; i++) {
			memory[i] = -127;
		}
		int pointer = 0;
		int chars = 0;
		Stack<Integer> s = new Stack<>();
		int c = fin.read();
		while (c != -1) {
			chars++;
			//System.out.format("chars:%d command:%s%n", chars, "" + (char)c);
			switch ((char)c) {
				case '>':
					pointer++;break;
				case '<':
					pointer--;break;
				case '+':
					memory[pointer]++;break;
				case '-':
					memory[pointer]--;break;
				case ',':
					memory[pointer] = (byte)(System.in.read() - 127);break;
				case '.':
					System.out.print((char)(memory[pointer] + 127));break;
				case '[':
					if (memory[pointer] == -127) {
						chars += goToMatchingBracket(fin);
					} else {
						s.push(chars);
					}
					break;
				case ']':
					if (memory[pointer] != -127) {
						fin.close();
						fin = getStream(args[0], s.peek());
						chars = s.peek();
					} else {
						s.pop();
					}
					break;
			}
			c = fin.read();
		}
		fin.close();
	}
	
	private static FileInputStream getStream(String fileName, int skip) throws IOException {
		FileInputStream fin = new FileInputStream(fileName);
		while (skip > 0) {
			skip -= fin.skip(skip);
		}
		return fin;
	}
	
	private static int goToMatchingBracket(FileInputStream fin)throws IOException {
		int brackets = 1;
		int chars = 0;
		while (brackets > 0) {
			char c = (char)fin.read();
			chars++;
			if (c == '[') {
				brackets++;
			} else if (c == ']') {
				brackets--;
			}
		}
		return chars;
	}
}