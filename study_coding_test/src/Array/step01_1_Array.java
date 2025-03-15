package Array;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제
 * 큰 수 출력하기
 * N(1<=N<=100)개의 정수를 입력받아 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요
 * (첫 번째 수는 무조건 출력)
 * 
 * 첫 줄에 자연수 N이 주어지고, 그 다음 줄에 N개의 정수가 입력된다. 
 * 
 * */

/*
 * 내 풀이 (정답이지만, 어레이 리스트와 answer 출력까지 마무리 연습 필요!)
 * 자연수 N 입력 & 정수 N개 입력해서 solution에 넘기는 건 문제 없음
 * solution에서 자신의 바로 앞 수보다 큰 수를 저장하는 answer을 배열로 가능한가? 아니면 리스트로?
 * 일단 배열은 크기에 대한 초기화를 해줘야 해서 어레이 리스트로 -> return 값도 arraylist로!
 * 
 * */
class Main{
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(arr[0]);
		
		for(int i = 1 ; i < 5; i++) { // 1 2 3 4 5 인덱스만
			if (arr[i] < arr[i + 1]) {
				answer.add(arr[i + 1]); 
			}
		}
		
		return answer;

	}
}
public class step01_1_Array {

	public static void main(String[] args) {
		
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt(); // 자연수 N
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int x : T.solution(n, arr)) {
			System.out.println(x + " ");
		}
	}

}
