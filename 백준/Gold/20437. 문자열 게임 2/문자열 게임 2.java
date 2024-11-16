import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String string = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26];
            for (int j = 0; j < string.length(); j++) {
                alpha[string.charAt(j) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (int j = 0; j < string.length(); j++) {
                if (alpha[string.charAt(j) - 'a'] < K) {
                    continue;
                }

                int count = 1;
                for (int l = j + 1; l < string.length(); l++) {
                    if (string.charAt(j) == string.charAt(l)) {
                        count++;
                    }

                    if (count == K) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == -1) {
                System.out.println("-1");
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}