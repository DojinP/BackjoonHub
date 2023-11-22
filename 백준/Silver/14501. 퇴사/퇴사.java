import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] table;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // n = 1 ~ 15

        table = new int[N][2];

        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }

        // logic
        int ans = recurSchedule(0, 0, 0);

        System.out.println(ans);
    }

    public static int recurSchedule(int now, int cnt, int pay){
        // 마지막 날
        if(now == N){
            // 남아있는 상담이 있는 경우
            if(cnt > 0) return 0;
            // 남은 상담 없을 시 total pay 반환
            else return pay;
        }

        int result;

        // 오늘의 상담을 넘기는 경우
        result = recurSchedule(now + 1, cnt - 1, pay);

        // 오늘의 상담을 받는 경우 (현재 진행중인 상담이 없다는 조건 필요)
        if(cnt <= 0)
            result = Math.max(result, recurSchedule(now + 1, table[now][0] - 1, table[now][1]) + pay);

        return result;

    }

}
