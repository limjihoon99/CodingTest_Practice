import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        // 중복된 사람 제외
        HashSet<String> players = new HashSet<>();

        for (int i = 0; i < N; i++) {
            players.add(br.readLine());
        }

        int number = players.size();
        int name = 0;

        if (game == 'Y') {
            name = number;
        } else if (game == 'F') {
            name = number / 2;
        } else if (game == 'O') {
            name = number / 3;
        }

        System.out.println(name);
    }
}