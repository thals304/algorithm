package string;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * 문제
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 함
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES" 아니면 "NO"를 출력하는 프로그램을 작성하세요
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자 구분하지 않음
 * 알파벳 이외의 숫자는 무시함
 * 
 * 입력
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어짐
 * 
 * 출력
 * 첫 번째 줄에 팰린드롬의 결과를 YES, NO로 출력
 * */

/*
 * 내 풀이
 * 1. 받은 문자열을 소문자/대문자로 전환
 * 2. 알파벳 이외의 숫자를 무시 = 즉, 숫자 제외 따로 문자열 만들기
 * 3. 문자열만 팰린드롬인지 확인
 * 
 * -> StringBuilder 사용할 줄 알아야 될 것 같음
 * */
class Main8 {
	public String solution(String str) {
		String answer = "NO";
		
		// 대/소문자 변환 하면서 특수문자, 숫자 바로 걸러내기
		str = str.toLowerCase(); //.replaceAll("[^A-Z]", ""); 
		
		String temp = "";
		for(char x : str.toCharArray()) {
			if (Character.isAlphabetic(x)) {
				temp += x;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if (temp.equals(sb.reverse().toString())) {
			answer = "YES";
		}
		
		return answer;
	}
} 
public class step01_8_String {

	public static void main(String[] args) {
		Main8 T = new Main8();
		Scanner kb = new Scanner(System.in);	
		
		String str = kb.nextLine();
		System.out.println(T.solution(str));
	}

}
