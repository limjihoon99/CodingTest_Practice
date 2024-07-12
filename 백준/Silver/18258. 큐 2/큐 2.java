import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int back = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("push")) {
                back = Integer.parseInt(st.nextToken());
                q.offer(back);
            } else if(s.equals("pop")) {
                if(q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
            } else if(s.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if(s.equals("empty")) {
                if(q.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if(s.equals("front")) {
                if(q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.peek()).append("\n");
                }
            } else if(s.equals("back")) {
                if(q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(back).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}