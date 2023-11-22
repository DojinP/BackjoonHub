import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        /* 완전탐색의 경우 100,000,000 회 이상의 연산까지는 적용의 기준으로 삼을만 하다. */
        /* 완전 탐색으로 접근 */

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        /* 1 <= n <= 10000 */
        int n = Integer.parseInt(st.nextToken());

        int count = 1;
        int target = 666;

        while(count < n){

            target++;

            if(isDoomNum(target)) count++;

        }

        sb.append(target);

        System.out.println(sb.toString());
    }

    private static boolean isDoomNum(int target) {
        String str = String.valueOf(target);

        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '6'){
                cnt++;
                if (cnt > 2) return true;
            }else{
                cnt = 0;

            }
        }

        return false;
    }


}
