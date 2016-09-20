package ballot;

import java.util.Random;
import java.util.Vector;

public class BallotSystem {
	private Vector<Integer> lots;
	private boolean putBack;

	public BallotSystem(int size, boolean putBack) {
		this.lots = new Vector<Integer>(size);
		this.putBack = putBack;
		for (int i = 1; i <= size; i++) {
			lots.add(new Integer(i));
		}
	}

	public void takeLot(int cnt) {
		if (this.putBack == false && cnt > this.lots.size()) {
			System.out.println("Input number less than the lots size.");
			return;
		}
		for (int i = 0; i < cnt; i++) {
			int lotSize = this.lots.size();
			Random random = new Random();
			int lotNum = random.nextInt(lotSize);
			System.out.println(this.lots.get(lotNum));
			if (this.putBack == false) {
				this.lots.remove(lotNum);
			}
		}
	}

	public static void main(String[] args) {
		BallotSystem bs = new BallotSystem(100, false);
		bs.takeLot(5);
	}
}
