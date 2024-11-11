package study_java;

import java.util.ArrayList;
import java.util.List;

class Student{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() { // Student의 매개변수가 private일 때
		return name;
	}
	
	public int getScore() {
		return score;
	}
}

class StudentManagers {
	List<Student> students;
	
	public StudentManagers() {
		this.students = new ArrayList<>();
	}
	
	public void addStudent(String name, int score) {
		students.add(new Student(name, score));
	}
	
	public Integer getStudentScore(String name) {
		for (Student student : students) {
			if (student.getName() != null && student.getName().equals(name)) { // 문자열 비교
				return student.getScore();
			}
		}
		return -1;
	}
	
	public List<String> getTopScorer() {
		List<String> topScoreStd = new ArrayList<String>();
		int maxScore = 0;
		for (Student student : students) {
			if (student.getScore() > maxScore) {
				maxScore = student.getScore();
			}
		}
		
		for (Student student : students) {
			if (student.getScore() == maxScore) {
				topScoreStd.add(student.getName());
			}
		}
		
		return topScoreStd;
	}
	
	public List<String> getSortedScores() {
		students.sort((a,b) -> b.getScore() - a.getScore()); // 리스트 내림차순 정렬 // 배열의 정렬은 Arrays.sort()로 가능
		List<String> sortedScores = new ArrayList<>();
		for (Student student : students) {
			sortedScores.add(student.getName() + "-" + student.getScore());
		}
		return sortedScores;
	}
}


public class StudentManager {

	public static void main(String[] args) {
		StudentManagers manager = new StudentManagers();
		manager.addStudent("Alice", 85);
		manager.addStudent("Bob", 90);
		manager.addStudent("Charlie", 78);
		manager.addStudent("Diana", 90);
		
		System.out.println(manager.getStudentScore("Bob")); // 90
		System.out.println(manager.getTopScorer()); // Bob, Diana
		System.out.println(manager.getSortedScores()); // [Diana - 90, Bob - 90, Alice - 85, Charlie - 78]

	}

}
