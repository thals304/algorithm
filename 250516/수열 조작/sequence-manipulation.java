import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Please write your code here.
        int n = sc.nextInt();

        Deque<Integer> dp = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dp.addLast(sc.nextInt());
        }

        while (dp.size() > 1) {
            dp.pollFirst();       // 맨 앞 제거
            dp.addLast(dp.pollFirst());  // 맨 앞 값을 뒤로 이동
        }

        System.out.println(dp.peekFirst());
    }
}