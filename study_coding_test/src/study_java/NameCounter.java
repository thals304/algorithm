package study_java;

import java.util.HashMap;

class NameCounters{
	HashMap<String, Integer> nameCountMap = new HashMap<String, Integer>();
	
	public void countNames(String[] names) {
		for (String name : names) {
			if (nameCountMap.containsKey(name)) { // .containsKey() : 특정 키(key)가 존재하는지 확인하는 메서드
				nameCountMap.put(name, nameCountMap.get(name) + 1); //.get() : 키에 해당하는 값을 가져오는 메서드
			}
			else {
				nameCountMap.put(name, 1); // .put()
			}
			
		}
	}
	public void printCounts(){
		for (String name : nameCountMap.keySet()) {
			System.out.println(name + ":" + nameCountMap.get(name));
		}
	}
}
public class NameCounter {

	public static void main(String[] args) {
		NameCounters counter = new NameCounters();
		String[] names = {"Alice", "Bob", "Alice", "Diana", "Bob", "Alice"};
		counter.countNames(names);
		counter.printCounts();

	}

}
