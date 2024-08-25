import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 수강신청 중복 제거, 수강신청 순서 유지
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // set에 학생이 존재한다면, 기존 위치 제거한 후 다시 추가
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            if (set.contains(s)) {
                set.remove(s);
            }
            set.add(s);
        }

        // set에 저장된 데이터 배열로 변환 후 순차적으로 출력
        for (Object o : set.toArray()) {
            if (l > 0) {
                System.out.println(o);
                l--;
            }
        }
    }
}