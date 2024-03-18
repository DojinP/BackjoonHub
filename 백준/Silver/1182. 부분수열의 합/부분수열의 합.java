import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static int n, s;
    static int count = 0;
    static int[] set;
    static List<List<Integer>> subset_list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        /* 부분수열의 합 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        set = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            set[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        for(List<Integer> list : subset_list) {
            int sum = list.stream().mapToInt(i -> i).sum();
            if(sum == s) count++;
        }

        System.out.println(count);
    }

    private static void dfs(int idx) {
        if(idx == set.length) return;

        if(!subset_list.isEmpty()) {
            int len = subset_list.size();
            for(int i=0; i<len; i++) {
                List<Integer> target = subset_list.get(i);
                List<Integer> temp = new ArrayList<>();
                for(int el : target) {
                    temp.add(el);
                }
                temp.add(set[idx]);

                subset_list.add(temp);
            }
        }

        List<Integer> new_inst = new ArrayList<>();
        new_inst.add(set[idx]);
        subset_list.add(new_inst);

        dfs(idx+1);

    }
}
