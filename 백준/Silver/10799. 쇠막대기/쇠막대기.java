import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] pipeLine = reader.readLine().toCharArray();
        int count = 0;

        Stack<Character> stack = new Stack<>();
        char recentPipe = 0;

        for(int i=0; i<pipeLine.length; i++) {
            if(pipeLine[i] == '(') {
                stack.push(pipeLine[i]);
            }else if(pipeLine[i] == ')') {
                if(recentPipe == 0) continue;

                if(recentPipe == '(') {
                    stack.pop();
                    count += stack.size();
                }else if(recentPipe == ')') {
                    stack.pop();
                    count++;
                }
            }
            recentPipe = pipeLine[i];
        }

        System.out.println(count);
    }
}
