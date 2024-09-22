import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][] matrix = new int[N][2];
        int tall = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());

            // 가장 큰 기둥 높이 구하기
            tall = Math.max(matrix[i][1], tall);
        }

        // x 좌표 순서로 정렬
        Arrays.sort(matrix, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        // 가장 큰 기둥 중 왼쪽에 있는 기둥
        int first = 0;
        for (int i = 0; i < N; i++) {
            if (matrix[i][1] == tall) {
                first = i;
            }
        }

        // tall은 따로 더해줘야 하기 때문에 제일 처음에 넣기
        int size = tall;

        // 제일 첫 기둥
        int prevX = matrix[0][0];
        int prevY = matrix[0][1];

        // 왼쪽 탐색
        for (int i = 1; i <= first; i++) {
            // 이전 기둥보다 큰 기둥이 나타나면 넓이 구하기
            if (matrix[i][1] >= prevY) {
                size += (matrix[i][0] - prevX) * prevY;

                // 현재 기둥 정보 갱신
                prevX = matrix[i][0];
                prevY = matrix[i][1];
            }
        }

        // 마지막 기둥
        prevX = matrix[N - 1][0];
        prevY = matrix[N - 1][1];

        // 오른쪽 탐색
        for (int i = N - 1; i >= first; i--) {
            // 이전 기둥보다 큰 기둥이 나타나면 넓이 구하기
            if (matrix[i][1] >= prevY) {
                size += (prevX - matrix[i][0]) * prevY;

                //현재 기둥 정보 갱신
                prevX = matrix[i][0];
                prevY = matrix[i][1];
            }
        }

        System.out.println(size);
    }
}