import java.util.ArrayList;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println("\n\n random generated Array :");
		System.out.println(randomRolls);
        System.out.println("\n\n random generated letter :");
        generator.getRandomLetter();
        System.out.println("\n\n random generated password :");
    	generator.generatePassword();
        System.out.println("\n\n List of random generated passwords :");
        generator.getNewPasswordSet(6);
	}
}
