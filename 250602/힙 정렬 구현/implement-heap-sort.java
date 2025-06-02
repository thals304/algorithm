import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
            heapSort(arr);                     // 힙 정렬 수행

        // 결과 출력
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 힙 정렬 메서드
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1. 배열을 max-heap으로 만들기
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 2. 루트(max값)과 마지막 값을 교환하고, heap 크기 줄인 후 재정렬
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);             // 최대값을 끝으로 보냄
            heapify(arr, i, 0);          // 줄어든 힙에 대해 heapify
        }
    }

    // 특정 루트에 대해 max-heap 성질 유지
    public static void heapify(int[] arr, int size, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            swap(arr, root, largest);
            heapify(arr, size, largest);  // 재귀적으로 자식 노드도 정렬
        }
    }

    // 배열의 두 원소 교환
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
}