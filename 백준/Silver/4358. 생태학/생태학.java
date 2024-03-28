import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    static int count = 0;
    // 4358. 생태학
    public static void main(String[] args) throws IOException {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp;

        // treeMap 초기화
        while((temp = br.readLine()) != null) {
            // 첫 입력일 경우 count 1로 저장
            if(treeMap.get(temp) == null) {
                treeMap.put(temp, 1);
                count++;
                continue;
            }

            int value = treeMap.get(temp);
            treeMap.put(temp, value+1);
            count++;

        }

        StringBuilder sb = new StringBuilder();
        Object[] keySet = treeMap.keySet().toArray();

        for(int i=0; i<keySet.length; i++) {
            int value = treeMap.get(keySet[i]);
            double ratio = ((double) value / (double) count) * 100;
            sb.append(keySet[i] + " " + String.format("%.4f", ratio) + "\n");
        }

        System.out.println(sb);

    }

}
