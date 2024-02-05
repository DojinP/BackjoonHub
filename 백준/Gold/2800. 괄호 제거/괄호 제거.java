import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
    static char[] expCharArr;
    static List<Point> posList;
    static boolean[] posCheck;
    static TreeSet<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        expCharArr = br.readLine().toCharArray();
        posList = new ArrayList<>();
        result = new TreeSet<>();

        /* 괄호 위치 저장 */
        saveBracketPos(expCharArr, posList);

        /* 결과 저장 (재귀) */
        saveResult(0);

        /* 결과 출력 */
        StringBuilder sb = new StringBuilder();
        for(String s : result) {
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }

    private static void saveResult(int times) {
        if(times == posList.size()) {
            StringBuilder sb = new StringBuilder();
            List<Integer> exceptedPos = new ArrayList<>();
            // 출력 안되는 Pos 구하기
            for(int i=0; i<posCheck.length; i++) {
                if(!posCheck[i]) {
                    exceptedPos.add(posList.get(i).x);
                    exceptedPos.add(posList.get(i).y);
                }
            }

            for(int i=0; i<expCharArr.length; i++) {
                if(exceptedPos.contains(i)) continue;
                sb.append(expCharArr[i]);
            }

            if(sb.toString().length() != expCharArr.length){
                result.add(sb.toString());
            }

            return;
        }

        posCheck[times] = true;
        saveResult(times+1);
        posCheck[times] = false;
        saveResult(times+1);
    }

    private static void saveBracketPos(char[] expCharArr, List<Point> posList) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i< expCharArr.length; i++){
            char now = expCharArr[i];
            if(now == '(') {
                stack.push(i);
            }else if (now == ')') {
                posList.add(new Point(stack.pop(), i));
            }
        }

        posCheck = new boolean[posList.size()];
    }
}