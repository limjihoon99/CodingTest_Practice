import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int cnt;
    static int n;
    static int m;
    static int k;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] isVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        isVisited = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(arr.get(i));
        }

        cnt = 1;
        dfs(k);

        for (int i = 1; i < isVisited.length; i++) {
            sb.append(isVisited[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int index) {
        isVisited[index] = cnt;

        for (int i = 0; i < arr.get(index).size(); i++) {
            int a = arr.get(index).get(i);
            if (isVisited[a] == 0) {
                cnt++;
                dfs(a);
            }
        }
    }
}