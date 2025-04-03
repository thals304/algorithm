package string;

import java.util.Scanner;
/*
 * 문제
 * 앞에서 읽을 때나 뒤에서 읽을 때 같은 문자열을 회문 문자열이라고 함
 * 문자열이 입력되면 해당 문자열이면 YES, 회문 문자열이 아니면 NO를 출력하는 프로그램을 작성하시오
 * 
 * 입력
 * 첫 줄에 길이 100을 넘기지 않은 공백이 없는 문자열이 주어짐
 * 
 * 출력
 * 첫 번째 줄에 회문 문자열인지의 결과를 YES, NO로 출력
 * */
/*
 * 나의 풀이
 * 받아온 문자열을 대문자/소문자로 바꾸기 toUpperCase() / toLowerCase()
 * -> 배열 어레이로 만들기 toCharArray()
 * -> 배열 길이 / 2 까지만 for문 돌리면서 짝꿍 문자랑 직접 비교
 * " 짝꿍 문자 규칙성 : 문자 배열 길이 = 현재 인덱스 + 짝꿍 인덱스 + 1 "
 * */
class Main7{
	public String solution(String str) {
		String answer = "YES";
		
		// 일단 문자열을 대문자/소문자로 변경 -> 문자 어레이로 바꿔서 시작
		String upperStr = str.toUpperCase();
		
		char[] chr = new char[str.length()];
		int i = 0;
		
		for (char x : upperStr.toCharArray()) {
			chr[i] = x;
			i++;
		}
		
		// 인덱스 0 ~ 중간 값(홀수인 경우 중간 값 전)까지
		// for문 돌면서 0 1 2 3 4 5 짝꿍끼리 규칙성 찾아야함 = 합이 length - 1
		
		for (int j = 0; j < chr.length / 2; j++) {
			if (chr[j] != chr[chr.length - j - 1]) return answer = "NO";
		} 
		
		
		/*
		 * 방법 1)
		 * str = str.toUpperCase();
		 * int len = str.length;
		 * for(int i = 0; i < len/2; i++){
		 * 
		 * 	if(str.charAt(i) != str.charAt(len - i - 1) return answer;
		 * 
		 * }
		 * 
		 * return answer = "YES";
		 * 
		 * */
		
		/*
		 * 방법 2) 뒤집어서 비교
		 * String tmp = new StringBuilder(str).reverse().toString();
		 * if(str.equals(tmp)) return answer = "YES";
		 * 
		 * */
			
		return answer;
	}
}
public class step01_7_String {

	public static void main(String[] args) {
		Main7 T = new Main7();
		Scanner kb = new Scanner(System.in);
		
		String str = kb.next();
		System.out.println(T.solution(str));
	}

}
