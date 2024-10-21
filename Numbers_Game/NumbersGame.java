import java.util.Random;
public class NumbersGame {
    public static void main(String[] args){
        
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");
        System.out.println("Can you guess the number?");
        System.out.println("If you are not up to the task, you can always type 'q' to quit.");
        // the guess number should be before the loop 
        int answer = new Random().nextInt(0,10);
        int i = 0;
        while(true && i<3){
            String guess = System.console().readLine();
            if(guess.equals("q")){
                System.out.println("I knew you didn't have it in you.");
                System.out.println("Shutting down...");
                break;
            }
            try{
                if(Integer.parseInt(guess)<0 || Integer.parseInt(guess)>10)
                {
                    System.out.println("The number should be between 0 and 10!");
                }
                else if(Integer.parseInt(guess)==answer)
                {
                    System.out.println("Lucky guess! But can you do it again?");
                    break;
                }
                else
                {
                    System.out.println("Swing and a miss! Keep trying...");
                }

            } catch(NumberFormatException e) {

                System.out.println("A letter is not a number...");
            }
            i++;
            
        }
        System.out.println("Game over. Shutting down...");
    }

}

