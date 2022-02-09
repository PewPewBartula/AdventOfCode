package day4;

public class Bingo {
	
	private static final int size = 5;
	String[][] bingo;
	String last;
	Boolean winner;
	
	public Bingo() {
		bingo = new String[size][size];
		winner = false;
	}
	
	void update(String num) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(bingo[i][j].equals(num)) {
					last = bingo[i][j];
					bingo[i][j] += "x";
				}
			}
		}
		int win = 0;
		for(int i = 0; i < size; i++) {
			win = 0;
			for(int j = 0; j < size; j++) {
				if(bingo[i][j].contains("x")) {
					win += 1;
					if(win == 5) {
						winner = true;
					}
				}
			}
		}
		for(int i = 0; i < size; i++) {
			win = 0;
			for(int j = 0; j < size; j++) {
				if(bingo[j][i].contains("x")) {
					win += 1;
					if(win == 5) {
						winner = true;
					}
				}
			}
		}
	}
	
	int countWinner() {
		if(winner) {
			int sum = 0;
			int recent = 0;
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(!bingo[i][j].contains("x")) {
						sum += Integer.parseInt(bingo[i][j]);
					}
				}		
			}
			recent = Integer.parseInt(last);
			return sum*recent;
		}
		return -1;
	}
	
	void showBingo() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(bingo[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
}
