import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> l = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            l.get(a).add(b);
            l.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(l.get(i));
        }

        bfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int count = 1;

        q.offer(start);
        visited[start] = count++;

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int i = 0; i < l.get(a).size(); i++) {
                int nextV = l.get(a).get(i);

                if (visited[nextV] != 0) {
                    continue;
                }

                q.offer(nextV);
                visited[nextV] = count++;
            }
        }
    }
}