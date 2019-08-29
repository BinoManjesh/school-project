import java.util.Scanner;
import java.util.StringTokenizer;


class Average {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter integers separated by \',\': ");
        String input = sc.nextLine();
        StringTokenizer st = new StringTokenizer(input, ",");
        int n = st.countTokens();
        int sum = 0;
        while(st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
        float avg = sum / n;
        System.out.print("Average: " + avg);
    }
}