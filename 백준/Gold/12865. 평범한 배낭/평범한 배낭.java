import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Q_12865
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, K 읽기
        String[] cur_line = br.readLine().split(" ");
        int n = Integer.parseInt(cur_line[0]);
        int k = Integer.parseInt(cur_line[1]);

        // W, V 읽기
        int[] weights = new int[n];
        int[] values = new int[n];

        for(int i=0; i<n; i++) {
            cur_line = br.readLine().split(" ");
            weights[i] = Integer.parseInt(cur_line[0]);
            values[i] = Integer.parseInt(cur_line[1]);
        }

        // DP 테이블
        int[][] dp = new int[n+1][k+1];

        // DP 테이블 채우기
        // dp[i][j] : i번째 아이템까지 고려했을 때, j 가 최대 무게인 경우의 최대 가치
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (weights[i-1] <= j) {
                    // dp[i-1][j] : 이전 아이템(i-1) 을 선택하지 않았을 때의 최대 가치
                    // dp[i-1][j-weight[i-1]] + values[i-1] : 이전 아이템을 선택했을 때의 최대 가치
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]] + values[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // 출력
        System.out.println(dp[n][k]);
    }
}
