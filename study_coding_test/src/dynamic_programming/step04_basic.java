package dynamic_programming;

import java.util.Arrays;

/* 
 * [ 등굣길 ]
 * 격자의 크기 m,n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다.
 * 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단 경로의 개수를 1,000,000,007로 나눈 나머지를 return 하는 함수를 작성하세요
 *  - 조건
 *  	- 격자의 크기 m,n은 1이상 100 이하의 자연수입니다 > 메모이제이션 배열 크기와 연관
 *  	- 물에 잠긴 지역은 0개 이상 10개 이하입니다,
 *  	- 집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다
 *  ex) m = 4(col), n = 3(row), puddles [[2,2]], return 4
 * 
 * */
/*
 * 느낀점
 * 메모이제이션에 대한 전반적인 과정인 배열은 선언하고 초기화하고 재귀 표현에서 메모이제이션 조건 써주는 등은 이해를 했지만,
 * 아직 문제에 대한 점화식이라던지 종료 조건, 완료 조건에 대한 생각하기가 더 필요하다고 느꼈음
 * */
public class step04_basic {
	private static final int[][] mem = new int[101][101];
	
	private static int count(int x, int y, int w, int h, boolean[][] isPuddle) {
		// 행(h) = y, 열 = x
		
		// 종료 조건
		if (x > w || y > h) return 0; // 격자 밖을 벗어났을 경우 = 경로 만들 수 없음
		if (isPuddle[y][x]) return 0; // 물웅덩이일 때 = 경로 만들 수 없음
		
		if (x == w && y == h) return 1; // 학교에 도착한 경우 = 경로 하나 찾음
		
		if(mem[x][y] != -1) return mem[x][y]; // 유효하지 않는 부분보다 뒤에 있어야함
		
		int total = count(x+1,y,w,h,isPuddle) + count(x,y+1,w,h,isPuddle);
		return mem[x][y] = total % 100000007;
		
	}

	public static void main(String[] args) {
		int n = 3; // 행
		int m = 4; // 열
		
		for (int[] row : mem) {
			Arrays.fill(row, -1);
		}
		
		boolean[][] isPuddle = new boolean[n+1][m+1]; // 물울덩이도 격자 전체를 담을 수 있는 2차원 배열로 선언
		int[][] puddles = {{2,2}};
		
		for(int[] p: puddles) {
			isPuddle[p[1]][p[0]] = true;
		}
		
		System.out.println(count(1,1,m,n,isPuddle));

	}


}
