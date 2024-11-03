
public class Gorilla extends Mammal{
	
	public Gorilla(int energyLevel) {
		super(energyLevel);
	}
	
	public void throwSomething() {
		System.out.println("Gorilla just throwed something, be careful!");
		energyLevel -=5;
	}
	public void eatBananas() {
		System.out.println("Gorilla is eating bananas.");
		energyLevel +=10;
	}
	public void climb() {
		System.out.println("Gorilla is climbing a tree!");
		energyLevel -=10;
	}


}
