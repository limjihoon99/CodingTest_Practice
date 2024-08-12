import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int[][] graph, result;
    public static boolean[][] visited;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];
        result = new int[n][m];
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    x = i;
                    y = j;
                } else if (graph[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        bfs(x, y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    result[i][j] = -1;
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        result[nx][ny] = result[cur[0]][cur[1]] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}