package recursive;

import java.util.ArrayList;
import java.util.List;

/*
 * 24.11.12.화 14:50-14:58
 * 재귀함수 - 하노이탑
 * 일단 리스트 안에 배열이 있는 것이 아직 어색하다.
 * 그리고 List.of(new int[] {})와 .addAll을 아직 정확히 알지 못하고 사용한 느낌이라
 * 리스트에 대해 더 공부해야 될 것 같다.
 * */
public class step03_practice1 {

	public static List<int[]> hanoi(int n, int from, int to) {
		
		List<int[]> result = new ArrayList<int[]>();
		
		// 종료 조건
		if (n == 1) {
			result.add(new int[] {from, to}); // return List.of(new int[] {from, to});
			return result;
		}
		
		int empty = (1+2+3) - from - to;
		
		
		result.addAll(hanoi(n-1, from, empty)); 
		result.addAll(hanoi(1, from, to));
		result.addAll(hanoi(n-1, empty, to));
		
		return result;
		
	}
	
	public static void main(String[] args) {
		List<int[]> answers = hanoi(3, 1, 3);
		
		for (int[] answer : answers) {
			System.out.println(answer[0] + "->" + answer[1]);
		}

	}

}
