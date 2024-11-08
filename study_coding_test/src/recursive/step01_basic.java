package recursive;
// 재귀함수
/* 
 * 재귀 정의하는 방법
 * 	1. 상태 정의하기
 * 	  답을 결정하는 변수를 사용해 상태 정의하기
 * 	2. 종료 조건
 * 	  답이 나오는 상태를 검사해 답을 반환하는 종료조건 찾기 (상태가 작아지는 것 찾기)
 * 	3. 점화식
 *    상태를 전이시키는 규칙을 식으로 찾아내기
 * 
 * */
public class step01_basic {

	private static int power(int n, int m) {
		if (m == 0) return 1;
		if (n == 1) return 1;
		if (n == 0) return 1;
		
		return n * power(n, m-1);
	}
	
	public static void main(String[] args) {
		// n, m이 주어졌을 때 n^m을 구하시오
		int n = 3;
		int m = 5;
		System.out.println(power(n,m));
	}

}
