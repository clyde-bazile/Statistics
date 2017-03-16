import java.util.Random;
import java.util.Formatter;

public class Monty {

	boolean[] doors = new boolean[3];
	int n;
	boolean change;
	int guess = 0;
	int numOfPrizes = 0;

	public Monty (int n, boolean change) {
		this.n = n;
		this.change = change;
	}

	private void init() {
		
		for (int i = 0; i < doors.length; i++) {
			doors[i] = false;
		}

		Random rm = new Random();
		int prize = rm.nextInt(3);
		doors[prize] = true;
	}

	public void run(){
		for(int i = 0; i < n; i++) {
			init();
			boolean result = runSim(change);
			if (result) {
				numOfPrizes++;
			}
		}
	}

	private boolean runSim(boolean change) {
		int choice = guess;
		int open = (doors[1] == false) ? 1 : 2;
		if (change) {
			choice = (open == 1) ? 2 : 1;
		}
		return doors[choice];

	}

	@Override
	public String toString() {
		double success = numOfPrizes/((double)n) * 100.0;

		double failure = 100 - success;
		return String.format("Success: %d%%\nFailure: %d%%\n", (int)success, (int)failure);
	}

	public static void main(String[] args) {
		Monty m = new Monty(1000, true);
		m.run();
		System.out.println(m);
	}


}