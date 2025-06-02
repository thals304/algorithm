import java.util.Scanner;

class MergeSort{
    public int[] solution(int n, int[] arr){
        
        int low = 0;
        int high = n - 1;

        arr = merge_sort(arr, low, high);

        return arr;
    } 

    public int[] merge_sort(int[] arr, int low, int high){
        if (low < high){
            int mid = (low + mid) / 2;
            merge_sort(arr, low, mid);
            merge_sort(arr, mid + 1, high);
            merge(arr, low, mid, high);

            return arr;
        }
    }

    public merge(int[] arr, int low, int high){

    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        MergeSort m = new MergeSort();
        for (int x : m.solution(n, arr)){
            System.out.print(x + " ");
        }

    }
}