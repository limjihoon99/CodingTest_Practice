import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 랭킹 리스트의 가장 작은 순위보다 점수가 낮다면 랭킹 리스트에 추가 x
        if (N == P && score <= list[list.length - 1]) {
            System.out.println(-1);
        } else {
            int rank = 1;

            for (int i = 0; i < list.length; i++) {
                if (score < list[i]) {
                    rank++;
                } else {
                    break;
                }
            }

            System.out.println(rank);
        }
    }
}