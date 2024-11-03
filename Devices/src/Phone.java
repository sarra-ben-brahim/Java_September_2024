
public class Phone extends Device {
	
	public void makeCall() {
		if(battery > 10) {
		System.out.println("You are making a call.");
		battery -=5;
		status();
		} else {
			System.out.println("You have to urgently charge your phone before it goes down!!");
		}
		
	}
	public void playGame() {
		if(battery > 25) {
		System.out.println("You are playing a game.");
		battery -=20;
		status();
		} else {
			System.out.println("Your battery is under 25%, you're not allowed to play games, charge and come back :)");
		}
	}
	public void charge() {
		System.out.println("You are cahrging your phone.");
		battery +=50;
		status();
	}
}
