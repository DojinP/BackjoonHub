import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean[] check;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M+1];
        check = new boolean[N+1];
        sb = new StringBuilder();

        dfs(0);

        System.out.println(sb);

    }

    private static void dfs(int depth) {

        if (depth == M) {

            for (int i = 0; i < M; i++) {

                sb.append(arr[i]);
                sb.append(" ");

            }

            sb.append("\n");
            return;

        }

        for (int i = 0; i < N; i++) {

            if(!check[i]) {

                check[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                check[i] = false;

            }
            
        }

    }

}
