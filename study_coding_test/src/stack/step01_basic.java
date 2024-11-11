package stack;

import java.util.Stack;

/*
 * 스택 (stack)
 * LIFO (Last In First Out)
 * 
 * 자바에서 내장 제네릭 클래스로 Stack 지원함
 * - 스택 선언
 * Stack<Integer> stack = new Stack<>(); // import java.util.Stack;
 * - 스택 메서드
 * add() : 원소 추가
 * pop() : 원소 삭제 + 제거된 원소 반환
 * (단, 스택이 비어 있는 상태에서 pop()을 하면 EmptyStackException 발생 > 스택 비어있는지 확인 isEmpty())
 * peek() : 스택에서 값을 제거하지 않고 스택의 가장 위의 있는 값을 얻는 것
 * (단, 스택이 비어 있는 상태에서 pop()을 하면 EmptyStackException 발생)
 * */
public class step01_basic {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.add(1);
		stack.add(2);
		stack.add(3);
		
		System.out.println(stack.pop()); // 3
		System.out.println(stack.pop()); // 2
		
		System.out.println(stack.isEmpty()); // false
		
		System.out.println(stack.peek()); // 1

	}

}
