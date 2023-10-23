import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        // 2차원 맵
        int[][] map = new int[n][n];
        boolean[] visited = new boolean[n];

        // 맵 초기화
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a-1][b-1] = 1;
            map[b-1][a-1] = 1;
        }

        System.out.printf(v + " ");
        visited[v-1] = true;
        dfs(map, visited, v-1);

        visited = new boolean[n];

        System.out.println();
        bfs(map, visited, v);
    }

    public static void dfs(int[][] map, boolean[] visited, int v) {
        for(int i=0; i<map[0].length; i++) {
            if(i == v) continue;
            if(map[v][i] == 1 && !visited[i]) {
                System.out.printf((i+1) + " ");
                visited[i] = true;
                dfs(map, visited, i);
            }
        }
    }

    public static void bfs(int[][] map, boolean[] visited, int v) {
        Queue<Integer> queue = new LinkedList<>();

        visited[v-1] = true;
        queue.add(v-1);

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.printf((now+1) + " ");

            for(int i=0; i<map[0].length; i++){
                if(i == now) continue;

                if(map[now][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}