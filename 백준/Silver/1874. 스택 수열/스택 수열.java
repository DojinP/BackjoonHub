import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();

        int last = 0;

        for(int times = 0; times < size; times++) {
            int target = Integer.parseInt(reader.readLine());

            if(target > last) {
                for(int i=last; i<target; i++) {
                    stack.push(i+1);
                    sb.append("+\n");
                }
                last = target;
            }

            int peek = stack.peek();

            if (target == peek) {
                stack.pop();
                sb.append("-\n");
            }else {
                writer.write("NO");

                reader.close();

                writer.flush();
                writer.close();
                return;
            }

        }

        writer.write(sb.toString());

        reader.close();

        writer.flush();
        writer.close();

    }
}
