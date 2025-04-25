import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> v = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] command = sc.nextLine().split(" ");

            switch (command[0]) {
                case "push_back":
                    int a = Integer.parseInt(command[1]);
                    v.add(a);
                    break;

                case "pop_back":
                    if (!v.isEmpty()) {
                        v.remove(v.size() - 1);
                    }
                    break;

                case "size":
                    System.out.println(v.size());
                    break;

                case "get":
                    int k = Integer.parseInt(command[1]) - 1; // 1-based index
                    if (k >= 0 && k < v.size()) {
                        System.out.println(v.get(k));
                    } else {
                        System.out.println("Error");
                    }
                    break;
            }
        }

        sc.close();
    }
}