
public class Bat extends Mammal{
	
	public Bat(int energyLevel) {
		super(energyLevel);
	}
	
	public void fly() {
		System.out.println("Bat is flying, be careful!");
		energyLevel -=50;
	}
	
	public void eatHumans() {
		System.out.println("Bat just ate a human, he's very satisfied!");
		energyLevel +=50;
	}
	
	public void attackTown() {
		System.out.println("Bat attacking the town, be careful!");
		energyLevel -=100;
	}
	
	

}
