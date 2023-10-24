import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] answer = {"factor", "multiple", "neither"};
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            //sc.nextLine();
            if(a == 0 && b == 0) return;

            if(b % a == 0) {
                System.out.println(answer[0]);
            }else if(a % b == 0) {
                System.out.println(answer[1]);
            }else {
                System.out.println(answer[2]);
            }

        }

    }
}
