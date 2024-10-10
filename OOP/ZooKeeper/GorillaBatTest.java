public class GorillaBatTest {
    public static void main(String[] args) {
        Gorilla gorilla = new Gorilla();
        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.eatBanana();
        gorilla.eatBanana();
        gorilla.climb();

		System.out.print("Gorilla's enery level is: ");
        gorilla.displayEnergy();

		Bat dracula = new Bat();
		
		dracula.attackTown();
		dracula.attackTown();
		dracula.attackTown();

		dracula.eatHumans();
		dracula.eatHumans();
		
		dracula.fly();
		dracula.fly();
		
		System.out.print("Dracula's enery level is: ");
		dracula.displayEnergy();
    }
}
