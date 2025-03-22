package string;

import java.util.Scanner;
/*
 * 문제
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하시오.
 * 문장속의 각 단어는 공백으로 구분됩니다.
 * 
 * 입력
 * 첫 줄의 길이가 100을 넘지 않는 한 개의 문장이 주어집니다.
 * 문장을 영어 알파벳으로만 구성되어 있습니다.
 * 
 * 출력
 * 첫 줄의 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우
 * 가장 앞쪽에 위치한 단어를 답으로 한다.
 * 
 * */
/*
 * 내 풀이
 * 일단 입력받은 문자열을 공백 기준으로 자르는 방법 ? 문자열.split()
 * 각 문자를 배열/어레이리스트에 담아 각 인덱스에 들어 있는 문자열의 수(length())를
 * 계산해 비교해서 큰 값 = 가장 길이가 긴 단어
 * */
class Main3{
	public String solution(String str) {
		String answer = "";
		
		int m = Integer.MIN_VALUE, pos;
		
		// 방법 1
		String[] s = str.split(" ");
		for(String x : s) {
			if(m < x.length()) {
				m = x.length();
				answer = x;
			}
		}
		
		// 방법 2
		while((pos = str.indexOf(' ')) != -1) { // -1은 ' '가 문자열에 아예 존재하지 않는 경우를 말함
			String tmp = str.substring(0, pos);
			int len = tmp.length();
			if(len > m) {
				m = len;
				answer = tmp;
			}
			str = str.substring(pos + 1);
		}
		
		if(str.length() > m) { // 마지막 단어가 whlie에서 처리가 안되므로 따로 처리
			answer = str;
		}
		
		return answer;
	}
}
public class step01_3_String {

	public static void main(String[] args) {
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		
		String str = kb.nextLine(); // 한 줄 입력
		
		System.out.println(T.solution(str));

	}

}
