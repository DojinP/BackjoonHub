import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int n;
    static int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> decreasing_number = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if(n >= 1024) {
            // 10개의 수를 각각 선택하냐 마느냐는 2^10 의 가지수로 표현될 수 있으며, 이는 최대 1024개를 넘지 않는다는 의미가 된다.
            // 즉, 1024번째를 넘어서는 줄어드는 수는 존재하지 않는다.
            System.out.println(-1);
            return;
        }

        // dfs 실행이 완료되면 decreasing_number 에는 모든 줄어드는 수가 저장되어 있다.
        dfs(0, 0);

        // 오름차순으로 정렬
        Collections.sort(decreasing_number);
        
        // n번째 수 출력
        System.out.println(decreasing_number.get(n-1));

    }

    // int 는 2억개밖에 표현 못하므로 long 타입 설정
    private static void dfs(long now, int idx) {
        if(!decreasing_number.contains(now)) {
            decreasing_number.add(now);
        }

        // 9876543210 이 최대
        if(idx == 10) return;

        dfs((now * 10) + digits[idx], idx+1);   // 현재 자리 수 추가
        dfs(now, idx+1);                            // 현재 자리 수 추가 안 함
    }
}
