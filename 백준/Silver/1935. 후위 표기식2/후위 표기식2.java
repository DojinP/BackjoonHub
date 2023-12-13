import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int size = Integer.parseInt(reader.readLine());
        String target = reader.readLine();
        int[] valArr = new int[size];

        for(int i=0; i<size; i++) {
            valArr[i] = Integer.parseInt(reader.readLine());
        }

        for(int i=0; i<target.length(); i++) {
            char ch = target.charAt(i);

            if(ch >= 'A' && ch <= 'Z') {
                stack.push((double)valArr[ch-'A']);
            }else {

                double oper2 = stack.pop();
                double oper1 = stack.pop();

                switch (ch){
                    case '+' :
                        stack.push(oper1 + oper2);
                        break;
                    case '-' :
                        stack.push(oper1 - oper2);
                        break;
                    case '*' :
                        stack.push(oper1 * oper2);
                        break;
                    case '/' :
                        stack.push(oper1 / oper2);
                        break;
                    case '%' :
                        stack.push(oper1 % oper2);
                        break;
                }
            }
        }

        System.out.printf("%.2f", stack.pop());

    }
}
