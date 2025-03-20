package sortingAndSearching;

import java.util.Scanner;

/*
 * 문제
 * 선택정렬
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 * 정렬하는 방법은 선택 정렬입니다.
 * 
 * 입력
 * 첫 번째 줄에 자연수 N 주어짐
 * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됨
 * 
 * 선택정렬이란?
 * 정렬되지 않은 데이터들에 대해 가장 작은 데이터를 찾아 가장 앞의 데이터와 교환해나가는 방식이다.
 * */
/*
 * 내 풀이 (내 풀이는 삽입정렬을 구한 것임)
 * 배열 인덱스가 0인 것 빼고 key를 1부터 ~ 배열 길이 - 1까지 돌면서 본인 앞에 있는 인덱스들과
 * 비교해서 작으면 위치를 바꿔야함 
 * 위치를 바꾼다는 의미는 일단 앞에 있는 인덱스를 본인 위치보다 한칸 뒤의 인덱스로 이동시키고 
 * key가 앞에 있는 인덱스랑 비교 후 위치를 다 바꿨다면 조건인 j >= 0 && key < arr[j]를 
 * 만족하지 않은 인덱스 + 1에 key를 위치시키기 
 * 
 * ---
 * 선택정렬 풀이
 * 배열의 i = 0 ~ n-2 까지의 값과 j = 1 ~ n-1까지의 갑을 이중 for문을 통해 
 * 크기를 비교해서 i의 값보다 j의 값이 더 작으면 둘이 위치 교환
 * */
class Main{
	public int[] solution(int n, int[] arr) {
		
		/*int i, key, j;
		for (i = 1; i < n; i++) {
			key = arr[i];
			j = i - 1;
			while(j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}*/
		
		for (int i = 0; i < n - 1; i++) {
			int idx = i;
			for(int j = i + 1; j < n; j++) {
				if (arr[j] < arr[idx]) {
					idx = j; // 이렇게 해서 가장 작은 idx를 찾아냄
				}
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		
		return arr;
	}
}
public class step01_1_sorting {

	public static void main(String[] args) {
		Main T = new Main(); 
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt(); 
		
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = kb.nextInt();
		}
		
		T.solution(n, arr);
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		
		// 이렇게 바로 함수 호출 및 적용 + 출력하는게 더 나음
		// for (int x : T.solution(n, arr)) System.out.print(x + " ");
	}

}
