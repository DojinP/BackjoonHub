import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        // 함수형 인터페이스를 매개변수로 받아 배열을 채우는 메서드
        Arrays.setAll(arr, (i) -> i+1);

        StringBuilder sb = new StringBuilder("<");
        int idx = 0;
        int count = 0;
        int times = 1;

        while(count != n) {
            if (arr[idx % n] == 0) {
                idx++;
                continue;
            }

            if(times == k) {
                sb.append(arr[idx % n] + ", ");
                arr[idx % n] = 0;
                count++;
                times = 0;
            }

            idx++;
            times++;

        }

        // ", " 지우기
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.println(sb);

    }
}
