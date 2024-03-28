import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    // 2075. N번째 큰 수
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String[] inputs = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                pq.add(Integer.parseInt(inputs[j]));
            }
        }

        while(pq.size() > n) {
            pq.poll();
        }

        System.out.println(pq.peek());
    }
}
