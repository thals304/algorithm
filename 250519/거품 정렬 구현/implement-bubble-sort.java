import java.util.Scanner;

class BubbleSort{
    public int[] solution(int n, int[] arr){

        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - 1 - i; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        BubbleSort b = new BubbleSort();
        // Please write your code here.
        for (int x : b.solution(n, arr)){
            System.out.print(x + " ");
        }
    }
}