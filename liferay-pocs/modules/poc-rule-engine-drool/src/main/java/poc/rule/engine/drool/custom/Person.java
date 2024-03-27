package poc.rule.engine.drool.custom;

public class Person {
	private String name;
	private int age;
	private double discount;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
