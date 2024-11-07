package dynamic_programming;

import java.util.Arrays;

/*
 * [ 정수 삼각형 ]
 * 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 한다.
 * 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽으로 또는 왼쪽으로만 이동 가능 합니다.
 * 삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return하도록 함수를 완성하시오
 *  - 조건
 *  	- 삼각형의 높이는 1 이상 500 이하
 *  	- 삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수
 * 
 * (x,y) = [x,y] + Max (x+1, y) or (x+1, y+1)
 * */

public class step03_basic {
	private final static int[][] mem = new int[501][501];
	
	private static int max(int x, int y, int[][] triangle) {
		if (x == triangle.length) return 0; // 삼각형의 끝에 도달했을 때 0 반환 > 높이(행)과 관련
		
		if (mem[x][y] != -1) return mem[x][y];
		
		return mem[x][y] = triangle[x][y] + Math.max(max(x+1, y, triangle), max(x+1,y+1, triangle));
	}
	
	public static void main(String[] args) {
		int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		
		// 2차원 배열을 초기화하려면 각 행(= 하나의 1차원 배열)을 개별적으로 초기화
		for (int i = 0; i < mem.length; i++ ) {
			Arrays.fill(mem[i], -1); // Arrays.fill은 1차원 배열에 대해서 초기화 가능
		}
		System.out.println(max(0,0,triangle));

	}

}
