package tree;
/*
 * [ 트리 ]
 * 트리는 노드로 이루어져 있음
 * 노드는 계층 구조를 갖는데 한 노드는 상위 노드를 부모 노드, 하위 노드를 자식 노드라고 함
 * 하나의 노드는 최대 1개의 부모와 여러 개의 자식 노드를 가질 수 있음
 * - 트리의 구조
 * 루트 노드 : 최상위 노드
 * 리프 노드 : 자식이 없는 노드
 * 트리의 깊이/높이 : 노드의 깊이
 * - 트리의 구현
 * 트리는 재귀적 특성을 가짐(트리는 노드를 재귀적으로 정의함으로 표현할 수 있음)
 * 서브 트리 : 트리를 구성하는 임의의 노드를 선택했을 때, 해당 노드를 루트로 하는 트리
 * > 하나의 노드는 데이터, 부모 노드, 자식 노드(들)을 가짐
 * class Node {
 * 	int data;
 * 	Node parent;
 * 	List<Node> children;
 * }
 * 
 * [ 이진 트리 ]
 * 트리를 구성하는 모든 노드가 최대 2개의 자식 노드를 가지는 트리
 * 최대 2개의 자식을 가지므로, left child / right child라고 함
 * class Node{
 * 	int data;
 *  Node parent;
 * 	Node right;
 * 	Node left;
 * }
 * - 이진 트리의 순회
 * 트리는 여러 개의 자식을 가질 수 있으므로 재귀를 이용해 쉽게 순회할 수 있음
 * 전위 순회 : 노드 -> 왼쪽 서브 트리 -> 오른쪽 서브 트리
 * void pre(Node node){
 * 	if (node == null) return;
 *  // 노드 방문
 * 	System.out.println(node.data); 
 *  
 *  pre(node.left); // 왼쪽 자식 노드 방문
 *  pre(node.right); // 오른쪽 자식 노드 방문
 * }
 * 중위 순회 : 왼쪽 서브 트리 -> 노드 -> 오른쪽 서브 트리
 * void in(Node node){
 * 	if(node == null) return;
 * 
 * 	pre(node.left);
 *  
 *  System.out.println(node.data); 
 *  
 *  pre(node.right);
 *  
 * }
 * 후위 순회 : 양쪽 서브 트리 -> 노드
 * void post(Node node){
 * 	if(node == null) return;
 * 
 * 	pre(node.left);
 *  pre(node.right);
 *  
 *  System.out.println(node.data);
 *  
 * } 
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * [ 길 찾기 게임 ]
 * */

class Node{
	int value; // 노드 숫자
	int x; 
	int y;
	
	Node left;
	Node right;
	
	Node(int value, int x, int y){
		this.value = value;
		this.x = x;
		this.y = y;
	}
}

public class step01_basic { 
	
	private static void insert(Node root, Node node) {
		if (node.x < root.x) { // 왼쪽 서브 트리
			if (root.left == null) { // 루트의 왼쪽 서브 트리가 비어있다면, 해당 노드가 왼쪽 서브 트리의 루트 노드
				root.left = node;
			}
			else {
				insert(root.left, node); // 비어있지 않다면 그냥 왼쪽에 삽입
			}
		}
		else { // 오른쪽 서브 트리
			if (root.right == null) {
				root.right = node; // 루트의 오른쪽 서브 트리가 비어있다면, 해당 노드가 오른쪽 서브 트리의 루트 노드
			}
			else {
				insert(root.right, node);
			}
		}
	}
	
	private static Node constructTree(Node[] nodes) { // 루트 노드 반환 메서드
		Node root = nodes[0]; // 루트 노드
		
		for (int i = 1; i < nodes.length; i++) { 
			insert(root, nodes[i]);
		}
		
		return root; // 이진 트리 구성 완료
	}
	
	
	// 전위 순환
	private static void pre(Node node, List<Integer> visits) {
		if (node == null) return;
		
		visits.add(node.value);
		pre(node.left, visits);
		pre(node.right, visits);
		
	}
	
	// 후위 순환
	private static void post(Node node, List<Integer> visits) {
		if (node == null) return;
		
		pre(node.left, visits);
		pre(node.right, visits);
		visits.add(node.value);
	}
	
	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		
		Node[] nodes = new Node[nodeinfo.length];
		
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node( i + 1, nodeinfo[i][0], nodeinfo[i][1]);
		}
		
		Arrays.sort(nodes, (a,b) -> b.y - a.y); // y(level) 좌표로 내림차순 정렬
		
		Node root = constructTree(nodes);
		
		List<Integer> preorder = new ArrayList<>();
		pre(root, preorder);
		
		List<Integer> postorder = new ArrayList<>();
		post(root, postorder);
		
		System.out.println(preorder);
		System.out.println(postorder);
		
	}

}
