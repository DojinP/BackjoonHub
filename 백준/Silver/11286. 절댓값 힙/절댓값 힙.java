import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // 11286. 절댓값 힙
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
            if (Math.abs(i1) == Math.abs(i2)) {
                return i1 - i2;
            }

            return Math.abs(i1) - Math.abs(i2);
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0 && pq.size() == 0) {
                sb.append(0 + "\n");
                continue;
            }

            if (input == 0) {
                sb.append(pq.poll() + "\n");
            } else {
                pq.add(input);
            }

        }

        System.out.println(sb);
        
    }
}
