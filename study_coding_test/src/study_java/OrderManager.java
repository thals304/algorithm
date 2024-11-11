package study_java;

import java.util.LinkedList;
import java.util.Queue;

class Order {
	private int orderId;
	private String product;
	private int quantity;
	
	public Order(int orderId, String product, int quantity) {
		this.orderId = orderId;
		this.product = product;
		this.quantity = quantity;
	}
	
	public int getOderId() {
		return orderId;
	}
	
	public String getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
}
class OrderManagers {
	
	private Queue<Order> orderQueue;
	
	public OrderManagers() {
		this.orderQueue = new LinkedList<>(); // quque는 linkedlist로
	}
	
	public void placeOrder(int orderId, String product, int quantity) {
		Order newOrder = new Order(orderId, product, quantity);
		orderQueue.offer(newOrder); // 큐에 요소 추가
	}
	public void processOrder() {
		Order order = orderQueue.poll(); // 큐에서 가장 앞에 있는 요소를 제거하고 반환
		if (order != null) {
			System.out.println(order.getOderId() + "," + order.getProduct() + "," + order.getQuantity());
		}
		else {
			System.out.println("No orders to process");
		}
	}
	public int getTotalOrders() {
		return orderQueue.size();
	}
}
public class OrderManager {

	public static void main(String[] args) {
		OrderManagers manager = new OrderManagers();
		manager.placeOrder(1, "Laptop", 2);
		manager.placeOrder(2, "Phone", 1);
		manager.processOrder(); // Output: Order 1 for Laptop with quantity 2 processed.
		System.out.println(manager.getTotalOrders()); // Output: 1

	}

}
