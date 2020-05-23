import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class BrainDuck {

    public static void main(String[] args) throws IOException {
        FileInputStream fin = getStream(args[0], 0);
        boolean debug = false;
        int mem = 0;
        if (args.length > 1 && args[1].equals("d")) {
            debug = true;
            System.out.print("Enter number of bytes to see:");
            Scanner sc = new Scanner(System.in);
            mem = sc.nextInt();
        }
        byte[] memory = new byte[65536];
        for (int i = 0; i < 65536; i++) {
            memory[i] = -128;
        }
        int pointer = 0;
        int chars = 0;
        Stack<Integer> foo = new Stack<>();
        int c = fin.read();
        while (c != -1) {
            chars++;
            boolean isCommand = false;
            switch ((char) c) {
                case '>':
                    pointer++;
                    isCommand = true;
                    break;
                case '<':
                    pointer--;
                    isCommand = true;
                    break;
                case '+':
                    memory[pointer]++;
                    isCommand = true;
                    break;
                case '-':
                    memory[pointer]--;
                    isCommand = true;
                    break;
                case ',':
                    System.out.print("Enter:");
                    memory[pointer] = (byte) (System.in.read() - 128);
                    System.in.read();
                    isCommand = true;
                    break;
                case '.':
                    System.out.format("%s (%d)", (char) (memory[pointer] + 128), memory[pointer] + 128);
                    isCommand = true;
                    break;
                case '[':
                    if (memory[pointer] == -128) {
                        chars += goToMatchingBracket(fin);
                    } else {
                        foo.push(chars);
                    }
                    isCommand = true;
                    break;
                case ']':
                    if (memory[pointer] != -128) {
                        fin.close();
                        fin = getStream(args[0], foo.peek());
                        chars = foo.peek();
                    } else {
                        foo.pop();
                    }
                    isCommand = true;
                    break;
            }
            if (debug & isCommand) {
                System.out.format("Chars:%d Command:%s Pointer:%d [", chars, "" + (char) c, pointer);
                for (int i = 0; i < mem; i++) {
                    System.out.print((memory[i] + 128) + " ");
                }
                System.out.print(']');
                while ((char) System.in.read() != '\n') ;
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

    private static int goToMatchingBracket(FileInputStream fin) throws IOException {
        int brackets = 1;
        int chars = 0;
        while (brackets > 0) {
            char c = (char) fin.read();
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