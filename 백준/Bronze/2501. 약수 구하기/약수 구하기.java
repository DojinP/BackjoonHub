import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int cnt = 1;

        for(int i=1; i<=n; i++) {
            if(n % i == 0) {
                if(cnt == k) {
                    System.out.println(i);
                    return;
                }
                cnt++;
            }
        }

        System.out.println(0);
    }
}