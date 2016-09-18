package komarica.slavko.examples.jmap;

public class Person {
	private String name;
	private String lastName;
	private int age;
	private String jmbg;	
	
	public Person() {
	}
	
	
	public Person(String name, String lastName, int age, String jmbg) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.jmbg = jmbg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	
}
