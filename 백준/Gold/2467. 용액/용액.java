import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터 초기화
        int left = 0;
        int right = n - 1;

        int minSum = Integer.MAX_VALUE;
        int minLeft = left;
        int minRight = right;

        // 최소 합 찾기
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                minLeft = left;
                minRight = right;
            }

            // 합이 0보다 작으면 left를 증가시켜 더 큰 값을 향해 이동하고, 합이 0보다 크면 right를 감소시켜 더 작은 값을 향해 이동
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(arr[minLeft] + " " + arr[minRight]);
    }
}