import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int set_cnt = sc.nextInt();
        int str_list_cnt = sc.nextInt();

        sc.nextLine();

        List<String> set = new ArrayList<>();

        initiate(sc, set_cnt, set);

        int answer = 0;
        for(int i = 0; i<str_list_cnt; i++){
            String now = sc.nextLine();

            if(set.contains(now)) answer++;
        }

        System.out.println(answer);

    }

    private static void initiate(Scanner sc, int set_cnt, List<String> set) {
        for(int i = 0; i< set_cnt; i++){
            set.add(sc.nextLine());
        }
    }
}
