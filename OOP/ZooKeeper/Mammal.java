
public class Mammal {

	private int energyLevel = 100;

	public Mammal() {
	}

	public int displayEnergy() {
		System.out.println(this.energyLevel);

		return energyLevel;

	}

	public int getEnergyLevel() {
		return this.energyLevel;
	}

	public void setEnergyLevel(int energy) {
		this.energyLevel = energy;
	}
}