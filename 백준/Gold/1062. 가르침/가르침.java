import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int WORD_CNT = 26;
    static boolean[] studied;
    static String[] words;
    static int n, k;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        // 1062. 가르침

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n 은 제시되는 단어의 개수
        n = Integer.parseInt(st.nextToken());
        // k 는 선생이 가르칠 수 있는 알파벳의 개수
        k = Integer.parseInt(st.nextToken());

        // 가르친 알파벳이 5개 미만인 경우, 필수로 포함되는 "anti", "tica" 를 표현할 수 없으므로 0을 반환
        // 모든 알파벳 (26개) 을 가르칠 수 있는 경우, 제시된 모든 단어 (n개)를 표현할 수 있으므로, n을 반환
        if(k < 5) {
            System.out.println(0);
            return;
        }

        if(k == 26) {
            System.out.println(n);
            return;
        }

        // 학습한 알파벳의 상태를 저장하기 위한 배열 studied 초기화
        studied = new boolean[WORD_CNT];
        // 제시 단어 저장을 위한 배열 words 초기화
        words = new String[n];

        for(int i=0; i<n; i++) {
            String target = br.readLine();
            words[i] = target.substring(4, target.length() - 4);
        }

        // "anti", "tica" 는 알고 있기 때문에, 'a', 'c', 'i', 'n', 't' 는 알고 있는 단어입니다.
        studied[0] = true; // a
        studied[2] = true; // c
        studied['i'-'a'] = true; // i
        studied['n'-'a'] = true; // n
        studied['t'-'a'] = true; // t

        backtracking(0, 0);

        System.out.println(max);

        br.close();
    }

    private static void backtracking(int cursor, int len) {
        if(len + 5 == k) {
            int count = 0;
            // 단어 순회
            for(int i=0; i<n; i++) {
                boolean check = true;
                for(int j=0; j<words[i].length(); j++) {
                    // 현재 체크 중인 알파벳이 배우지 않은 알파벳인 경우
                    if(!studied[words[i].charAt(j) - 'a']) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        // 백트래킹
        for(int i=cursor; i<WORD_CNT; i++) {
            if(!studied[i]) {
                studied[i] = true;
                backtracking(i+1, len+1);
                studied[i] = false;
            }
        }
    }
}
