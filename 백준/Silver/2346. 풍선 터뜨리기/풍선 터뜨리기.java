import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<Pair> deque = new ArrayDeque<>();

        int[] values = Arrays.stream(br.readLine().split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();

        for(int i=0; i<n; i++) {
            deque.addLast(new Pair(i, values[i]));
        }


        while(!deque.isEmpty()){
            Pair target = deque.pollFirst();
            int target_index = target.getIdx();
            int target_value = target.getVal();
            sb.append((target_index + 1) + " ");

            if(target_value >= 0) {

                for(int i=0; i<target_value-1; i++){
                    Pair temp = null;
                    if(!deque.isEmpty()) temp = deque.pollFirst();
                    if(temp != null) deque.addLast(temp);
                }

            }else {

                for(int i=0; i<-target_value; i++){
                    Pair temp = null;
                    if(!deque.isEmpty()) temp = deque.pollLast();
                    if(temp != null) deque.addFirst(temp);
                }

            }

        }

        System.out.println(sb.toString());

    }
}

class Pair{
    private int idx;
    private int val;

    public Pair(int idx, int val){
        this.idx = idx;
        this.val = val;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "idx=" + idx +
                ", val=" + val +
                '}';
    }
}