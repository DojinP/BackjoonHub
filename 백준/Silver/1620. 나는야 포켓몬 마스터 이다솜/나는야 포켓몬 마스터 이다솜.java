import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first_input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(first_input[0]);
        int quiz_len = Integer.parseInt(first_input[1]);

        HashMap<Integer, String> library_for_name = new HashMap<>();
        HashMap<String, Integer> library_for_number = new HashMap<>();

        /* Map 초기화 */
        for(int i=1; i<=size; i++) {
            String name = br.readLine();
            library_for_name.put(i, name);
            library_for_number.put(name, i);
        }

        /* 퀴즈 풀이 */
        for(int i=0; i<quiz_len; i++) {
            String quiz = br.readLine();
            String answer;

            if('0' <= quiz.charAt(0) && quiz.charAt(0) <= '9') {
                // 도감 번호에 따른 포켓몬 이름을 맞춰야하는 경우
                answer = library_for_name.get(Integer.parseInt(quiz));
            }else {
                // 포켓몬 이름에 따른 도감 번호를 맞춰야하는 경우
                answer = String.valueOf(library_for_number.get(quiz));
            }

            sb.append(answer + '\n');
        }

        System.out.println(sb);

    }
}
