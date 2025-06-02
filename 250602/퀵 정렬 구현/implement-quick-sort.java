import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);

        // 결과 출력
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // 퀵 정렬 함수
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);   // 피벗 왼쪽 부분 정렬
            quickSort(arr, pivotIndex + 1, right);  // 피벗 오른쪽 부분 정렬
        }
    }

    // 분할 함수 - 피벗을 기준으로 작은 값은 왼쪽, 큰 값은 오른쪽으로 분리
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];  // 오른쪽 끝 원소를 피벗으로 선택
        int i = left - 1;        // 피벗보다 작은 값의 경계 인덱스

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);  // 피벗을 올바른 위치로 이동
        return i + 1;
    }

    // 배열 두 원소 교환 함수
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
