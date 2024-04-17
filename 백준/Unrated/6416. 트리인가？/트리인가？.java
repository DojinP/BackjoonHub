import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 6416. 트리인가? */
public class Main {
    private static Map<Integer, Integer> vertexCountMap;
    private static Set<Integer> pointedNodeSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        tc_init:
        for(int tc=1; ; tc++) {
            vertexCountMap = new HashMap<>();
            pointedNodeSet = new HashSet<>();
            boolean isNotTree = false;

            st = new StringTokenizer(br.readLine());

            while(true) {
                // 더 남은 토큰이 없다면 다음 줄 입력
                if(!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if(u == 0 || v == 0) {
                    // u, v 가 0 이면, testcase 종료
                    break;
                }

                if(u == -1 || v == -1) {
                    // u, v 가 -1 이면, 프로그램 종료
                    break tc_init;
                }

                if(!pointedNodeSet.add(v)) {
                    // v가 중복인 경우, Tree 가 아니다.
                    isNotTree = true;
                }

                // 맵에 간선 추가 (기존 간선이 있다면
                vertexCountMap.put(u, vertexCountMap.getOrDefault(u, 0) + 1);
            }

            // !!중요!! 간선이 없는 경우 루트 노드만 있다고 생각하고 트리로 간주한다.
            if(!pointedNodeSet.isEmpty()){
                int rootCount = 0;
                for(int key : vertexCountMap.keySet()) {
                    if(!pointedNodeSet.contains(key)) rootCount++;
                }

                if(rootCount != 1) isNotTree = true;
            }

            if(isNotTree) {
                sb.append("Case " + tc + " is not a tree.\n");
            }else {
                sb.append("Case " + tc + " is a tree.\n");
            }

        }

        System.out.println(sb);
    }
}
