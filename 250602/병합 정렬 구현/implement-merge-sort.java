import java.util.Scanner;

class MergeSort {
    public int[] solution(int n, int[] arr) {
        int low = 0;
        int high = n - 1;

        arr = merge_sort(arr, low, high);

        return arr;
    }

    public int[] merge_sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            merge_sort(arr, low, mid);
            merge_sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
        return arr;
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int idx = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[idx++] = arr[left++];
        }

        while (right <= high) {
            temp[idx++] = arr[right++];
        }

        // 복사
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
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

        MergeSort m = new MergeSort();
        int[] result = m.solution(n, arr);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
