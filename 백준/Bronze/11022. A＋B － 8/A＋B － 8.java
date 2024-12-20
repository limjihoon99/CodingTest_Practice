import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int A;
        int B;
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            System.out.println("Case #" + i + ": " + A + " + " + B + " = " + (A+B));
        }
        br.close();
    }
}