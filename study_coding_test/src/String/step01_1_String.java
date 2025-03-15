package String;

import java.util.Scanner;
/*
 * 문제)
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
   대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다. (대소문자 구분 x)
 * */

/* 내 풀이 (잘못된 풀이)
 * 문자열을 문자 단위로 쪼개기 -> 쪼갠 문자와 입력 받은 문자를 비교해서 카운트 세기
 * 
 * ! 문제 !
 * 문자열을 문자 단위로 쪼개려고 하는데 배열을 사용하게 되면 배열 크기를 지정해줘야 하는 문제 발생
 * -> arrayList?로 -> (정의) List<> 이름 = new ArrayList<>();
 * 근데 문자열을 어떻게 쪼개지? split? 으로 ""를 구분해서 한 단어씩 자를 수 있음
 * 
 * 배열로 구해보기
 * 문자열 길이로 배열 크기 지정 가능할 것 같음
 * 근데 어떻게 쪼개지? subString(인덱스 시작, 끝) > 문자열은 인덱스 0부터 시작
 * 
 * 문자(열) 비교
 * .equals
 * 
 * 알파벳 구분 x
 * ??
 * */

class Main{
	public int solution(String str, char t) {
		int answer = 0;
		
		// 대소문자 구분 x = 받아온 값인 str과 t를 대문자로 바꾸던지 or 소문자로 바꾸기
		str = str.toUpperCase(); 
		t = Character.toUpperCase(t);
		// System.out.println(str + " " + t);
	
		// 문자 비교 방법 1
		/*for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == t) {
				answer ++;
			}
		}	
		*/
		
		// 문자 비교 방법 2
		for(char x : str.toCharArray()){ // 오른쪽에는 문자열이 올 수 없음 (배열이나 리스트 가능)
			if (x == t) {
				answer++;
			}
		}
		
		return answer;
	}
}

public class step01_1_String {

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
	    String str = kb.next(); // 문자열
	    // 문자 : char 타입으로 입력값을 받을 수 없으므로 .next().charAt(0)으로 입력한 문자열의 가장 첫 단어만 가져오는 것으로 
	    char c = kb.next().charAt(0); 
	    
	    System.out.println(T.solution(str, c));
	    
	
	}

}
