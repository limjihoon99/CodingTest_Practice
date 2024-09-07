import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int [] num;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long ans = 0;
            num = new int[N];

            // 주식의 시세 정보
            for (int j = 0; j < N; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            // 마지막 값을 가장 큰 시세로 설정
            int max = num[N - 1];

            // 역방향 탐색
            for (int j = N - 2; j >= 0; j--) {
                // 가장 큰 시세보다 작은 시세일 때 판매
                if (num[j] <= max) {
                    ans += max - num[j];
                // 가장 큰 시세보다 큰 시세 탐색시 바꾸기
                } else {
                    max = num[j];
                }
            }
            // 시세 차익의 합 저장
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}