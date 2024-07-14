import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int k;
    static ArrayList<Integer> arr[];
    static boolean[] isVisit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1]; // 좌표를 그대로 받아들이기 위해 +1 사용
        isVisit = new boolean[n + 1];
        sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) { // 간선 열결 상태 저장
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }

        dfs(k);
        isVisit = new boolean[n + 1];
        sb.append("\n");
        bfs(k);
        System.out.println(sb);
    }

    // 시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출해준다.
    public static void dfs(int index) {
        isVisit[index] = true;
        sb.append(index + " "); // 현재 방문한 값 저장

        for(int i : arr[index]) { // i의 변수에 현재 방문한 노드에 해당하는 리스트에 담겨있는 값들을 하나씩 할당
            if(!isVisit[i]) {
                dfs(i); // 다음 방문할 노드 값으로 바꾸어 재귀 함수 실행
            }
        }
    }

    public static void bfs(int index) {
        isVisit[index] = true;
        // 시작점도 Queue에 넣어줘야 한다.
        Queue<Integer> q = new LinkedList<>();
        q.add(index);

        // Queue가 empty 될 때까지 반복하고 방문 정점을 확인, 출력 후 Queue에 넣어 순서대로 확인해준다.
        while(!q.isEmpty()) {
            int a = q.poll();
            sb.append(a + " ");

            for(int i : arr[a]) {
                if(!isVisit[i]) {
                    q.add(i);
                    isVisit[i] = true;
                }
            }
        }
    }
}