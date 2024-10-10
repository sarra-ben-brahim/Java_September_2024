
public class Bat extends Mammal {
	public Bat() {
		this.setEnergyLevel(300);
	}
	
	public void fly() {
		System.out.println("Dracula spread its wings and is flying");
		this.setEnergyLevel(this.getEnergyLevel() - 100);
	}
	
	public void eatHumans() {
		System.out.println("Dracula Eats humans! Run awaaaay!!!");
		this.setEnergyLevel(this.getEnergyLevel() + 25);
	}
	
	public void attackTown() {
		System.out.println("We are being attacked!");
		this.setEnergyLevel(this.getEnergyLevel() - 50);
	}

}