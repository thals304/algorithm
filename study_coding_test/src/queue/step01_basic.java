package queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 큐(queue)
 * 먼저 삽입한 우너소가 먼저 나오는 구조 FIFO
 * 큐를 구현하는 클래스인 LinkedList 클래스 사용해야함
 * - 큐 선언
 * Queue<Integer> queue = new LinkedList<>();
 * - 큐 메서드
 * .add() : 원소 삽입
 * .poll() : 원소 제거 + 해당 원소 반환
 * */
public class step01_basic {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		
		System.out.println(queue.poll()); // 1
		System.out.println(queue.poll()); // 2
		
		System.out.println(queue.isEmpty()); // false

	}

}
