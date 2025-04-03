package stack;

import java.util.Scanner;
import java.util.Stack;
/*
 * 문제
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약, 3*(5+2)-9를 후위 연산식으로 표현하면 352+*9-로 표현되며 그 결과는 12입니다
 * 
 * 입력 
 * 첫 줄에 후위연산식이 주어짐
 * 
 * 출력
 * 연산한 결과를 출력합니다.
 * 
 * */
/*
 * 풀이
 * 스택을 사용한 후위연산식
 * -> 숫자를 스택에 push
 * -> 연산기호를 만나면 마지막에 넣은 숫자 2개 pop 해서 연산기호와 계산 후 다시 push
 * */
class Main2{
	public int solution(String str) {
		int answer = 0;
		
		Stack<Integer> stack = new Stack<Integer>(); 
		
		// 고민 : 문자열에서 숫자인지 부호인지 구분하는 방법? Character.isDigit()
		for(char x : str.toCharArray()) {
			if(Character.isDigit(x)) {
				// 숫자이면 push
				stack.push(x - 48); // 문자를 숫자로 변경하는 방법 : 0 - (아스키코드) 48, 1 - 49 
			}
			else { // 연산기호인 경우 pop 2번 해서 연산 후 다시 push 
				int tmp2 = stack.pop();
				int tmp1 = stack.pop();
				if (x == '+') stack.push(tmp1 + tmp2);
				else if (x == '-') stack.push(tmp1 - tmp2);
				else if (x == '*') stack.push(tmp1 * tmp2);
				else if (x == '/') stack.push(tmp1 / tmp2);
			}
			
		}
		
		answer = stack.get(0);
		
		return answer;
	}
}
public class step01_2_Stack {

	public static void main(String[] args) {
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		
		String str = kb.next();
		System.out.println(T.solution(str));
	}

}
