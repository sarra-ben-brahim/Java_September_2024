
public class Mammal {
	protected int energyLevel;
	
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	protected void displayEnergy() {
		System.out.println("Energy level is : "+ energyLevel);
	}
}
