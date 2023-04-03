import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;

        // Logic
        while(sc.hasNext()){
            input = sc.nextInt();
            // Escape
            if(input == 0){
                break;
            }

            String str = Integer.toString(input);
            
            StringBuffer sb = new StringBuffer(str);
            String rev_str = sb.reverse().toString();

            if(str.equals(rev_str)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
