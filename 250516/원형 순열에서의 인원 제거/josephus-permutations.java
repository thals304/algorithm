import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int k = sc.nextInt(); 

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            // k-1명은 다시 맨 뒤로 보냄
            for (int i = 0; i < k - 1; i++) {
                q.add(q.poll());
            }
            // k번째 사람 제거
            result.add(q.poll());
        }

        // 출력 형식
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}