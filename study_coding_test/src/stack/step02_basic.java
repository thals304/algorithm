package stack;

import java.util.Stack;
/*
 * [ 올바른 괄호 ]
 * ()(), (())()는 올바른 괄호
 * )()(, (()(는 올바르지 않은 괄호
 * 문자열 s가 올바른 괄호이면 true를 return, 올바르지 않으면 false return
 * 
 * */
public class step02_basic {

	public static void main(String[] args) {
		
		Boolean answer = true;
		
		String s = "()(";
		
		Stack<Character> stack = new Stack<>();
		
		for (char c : s.toCharArray() ) { // toCharArray() : String을 char 단위로 쪼개 array(배열)로 저장
			switch(c) {
			case '(' -> stack.push(c); // .push()와 .add() 차이
			case ')' -> {
				if (stack.isEmpty()) {
					answer = false; // 모든 원소를 검사한 후 스택이 비어 있으면
					break;
				}
				stack.pop(); // 짝이 맞는 것
			}
			}
		}
		if (!stack.isEmpty()) { // 스택에 남은 '('가 있으면 false
			answer = false;
		}
		
		System.out.println(answer);
	}

}
