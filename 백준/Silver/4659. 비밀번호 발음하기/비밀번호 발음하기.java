import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pw;
        char[] pass;
        String P = "> is acceptable. \n";
        String F = "> is not acceptable. \n";
        StringBuilder sb = new StringBuilder();
        boolean flag;
        char prev;
        int count;

        while (!(pw = br.readLine()).equals("end")) {
            pass = pw.toCharArray();
            prev = '.';
            count = 0;

            flag = false;
            for (char c : pass) {
                if (condition(c)) flag = true;

                if (condition(c) != condition(prev)) {
                    count = 1;
                } else {
                    count++;
                }

                if (count > 2 || (prev == c && (c != 'e' && c != 'o'))) {
                    flag = false;
                    break;
                }

                prev = c;
            }

            if (flag) {
                sb.append('<').append(pw).append(P);
            } else {
                sb.append('<').append(pw).append(F);
            }
        }

        System.out.println(sb);
    }

    public static boolean condition(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}