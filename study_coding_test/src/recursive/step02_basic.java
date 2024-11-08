package recursive;

import java.util.Arrays;

/*
 * [ 쿼드 압축 후 개수 세기 ]
 * 
 *  0과 1로 구성된 2n x 2n 크기의 2차원 정수 배열 arr이 있습니다. 당신은 이 arr을 쿼드 트리와 같은 방식으로 압축하고자 합니다.
 *  1. 당신이 압축하고자 하는 특정 영역을 S라고 정의
 *  2. 만약 S 내부에 있는 모든 수가 같은 값이면 S를 해당 수 하나로 압축시킵니다.
 *  3. 그렇지 않다면 S를 정확히 네 개의 균일한 정사각형 영역으로 쪼갠 후 각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.
 *  
 *  arr이 매개변수로 주어집니다. 이런 방식으로 arr를 압축했을 때, 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아 출력하도록 함수를 완성해주세요.
 * 
 * */
/*
 * 24.11.08 
 * 느낀점
 * 재귀를 푸는 방식으로 상태 정의 -> 종료 조건 -> 점화식인데
 * 상태 정의에서 x,y가 필요하다는 것은 알았지만 길이인 size가 필요한 것 까지는 처음에 생각이 안났다.
 * 그리고 종료 조건이 모두 0, 모두 1인 경우라는 것은 캐치를 했다.
 * 점화식은 사각형의 사이즈를 줄이고 쪼갠 사각형을 재귀로 계산해야겠다는 생각은 했지만, 상태 정의에서 size를 생각하지 못했다보니
 * 점화식 계산을 생각하는 것도 막막했던 것 같다.
 * 그리고 자바를 다시 오랜만에 해서 그런지 클래스를 만들어야 되는지 함수를 만들어야 되는지, 클래스를 만들었을 때 메서드는 어떻게 처리 했었는지
 * 이런 것도 지금 객체지향에 대한 부족함이 있는 것 같아 코테 알고리즘 공부를 하면서 얼른 채워넣어야겠다. 
 * */
public class step02_basic {

	private static class Count { // 0,1의 개수를 한 번에 담을 수 있는 Count 클래스
		public final int zero;
		public final int one;
		
		public Count(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}

		public Count add(Count other) { // Count 클래스에 두 Count 객체를 합하는 메서드
			return new Count(zero + other.zero, one + other.one);
		}
		
	}
	
	private static Count count(int offsetX, int offsetY, int size, int[][] arr) { // 재귀 메서드
		int h = size / 2; 
		for (int x = offsetX; x < offsetX + size; x++) {
			for (int y = offsetY; y < offsetY + size; y++) {
				if (arr[y][x] != arr[offsetY][offsetX]) { // y : 행 // for문을 돌려 사각형에 있는 값이 모두 같은 값이 아닌 경우
					return count(offsetX, offsetY, h, arr)
							.add(count(offsetX + h , offsetY, h, arr))
							.add(count(offsetX, offsetY + h, h, arr))
							.add(count(offsetX + h, offsetY + h, h, arr));
				}
			}
		}
		
		if (arr[offsetY][offsetX] == 1) { // 모두 1인 경우
			return new Count(0,1);
		}
		return new Count(1,0); // 모두 0인 경우
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		Count count = count(0,0,arr.length, arr);
		
		int[] res = {count.zero, count.one};
		System.out.println(Arrays.toString(res)); // // Arrays.toString() 사용하여 배열 내용 출력
	}

}
