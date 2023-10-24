import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> primes;

        while(sc.hasNext()) {
            int now = sc.nextInt();
            int sum = 0;
            primes = new ArrayList<>();

            if(now == -1) return;

            for(int i=1; i<now; i++) {
                if(now % i == 0) {
                    sum += i;
                    primes.add(i);
                }
            }

            if(sum == now) {
                System.out.printf(now + " = " + primes.get(0));
                for(int i=1; i<primes.size(); i++){
                    System.out.printf(" + " + primes.get(i));
                }
                System.out.println();
            }else{
                System.out.println(now + " is NOT perfect.");
            }
        }
    }
}
