
public class Gorilla extends Mammal {

    public void throwSomething() {
        System.out.println("The gorilla threw some banana peels");
        this.setEnergyLevel(this.getEnergyLevel() - 5);
    }

    public void eatBanana() {
        System.out.println("The gorilla seems satisfied as it finished eating banana");
        this.setEnergyLevel(this.getEnergyLevel() + 10);
    }

    public void climb() {
        System.out.println("WOW, the gorilla is climbing the building");
        this.setEnergyLevel(this.getEnergyLevel() - 10);
    }

}