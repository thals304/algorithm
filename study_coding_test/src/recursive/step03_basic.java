package recursive;

import java.util.ArrayList;
import java.util.List;

/*
 * [ 하노이의 탑 ]
 * 하노이의 탑은 퍼즐의 일종입니다.
 * 세 개의 기둥과 이 기둥에 꽂을 수 있는 크기가 다양한 원판들이 있고, 퍼즐을 시작하기 전에는 한 기둥에 원판들이 작은 것이 위에 있도록
 * 순서대로 쌓여 있습니다. 게임의 목적은 다음 두 가지의 조건을 만족시키면서, 한 기둥에 꽂힌 원판들을 그 순서 그대로 다른 기둥으로 옮겨서 쌓는 것입니다.
 * - 한 번에 하나의 원판만 옮길 수 있습니다.
 * - 큰 원판을 3번 원판으로 최소 횟수로 옮기려고 합니다.
 * */
/*
 * 24.11.08
 * 너무 당연하게 상태 정의에서 기둥이 3개니까 x,y,z로 해야지 했는데
 * 원판 개수인 n, 어디에서 from, 어디로 to 였다는 점, 상태 정의부터 못하는 나 자신 진짜 반성해야겠다.
 * 그리고 empty인 기둥을 찾아 내는 것이 6 - from - to 라는 것은 암기해도 될 것 같다.
 * 이전 문제보다는 분석하기 간단했다고 느꼈지만, 리스트에 대해 공부가 더 필요하다는 것을 느꼈다.
 * 그리고 다음에 이 문제를 개수를 구하는 문제로 풀어보던지 아니면 최적화 하도록 풀어볼 것이다. 
 * 
 * */
public class step03_basic {

	private static List<int[]> hanoi(int n, int from, int to){
		if (n == 1) return List.of(new int[] {from, to}); // List.of : 변경 불가능한 (immutable) 리스트를 생성
		
		int empty = (1+2+3) - from - to;
		
		List<int[]> result = new ArrayList<int[]>(); // 최적화 필요한 부분 (구해 놓은 과정을 전부 순회하며 이어 붙이므로)
		result.addAll(hanoi(n-1, from, empty)); // .add : 단일 요소를 리스트에 추가 vs .addAll : 다른 컬렉션의 모든 요소를 현재 리스트에 추가(List에 한 번에 여러 요소를 추가할 때 유용)
		result.addAll(hanoi(1, from, to));
		result.addAll(hanoi(n-1, empty, to));
		
		return result;
	}
	public static void main(String[] args) {
		int n = 3;
		List<int[]> moves = hanoi(n,1,3);
		for (int[] move : moves) {
			System.out.println(move[0] + " -> " + move[1]);
		}
	}

}
