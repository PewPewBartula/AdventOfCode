package day4;

import java.util.*;
import day4.Bingo;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class Day4 {
	
	private static final int size = 5;
	private static List<Bingo> bingos = new ArrayList<Bingo>();
	private static String[] bingoData;
	private static String[] numbers;
	private static int lines = 0;
	
	private static void readFromFile(String filename) {
		
		String data = "";
		String numData = "";
		
		try {
		      File myObj = new File(filename);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	if(lines == 0) {
		    		numData += myReader.nextLine();
		    		numbers = numData.split("\\W+");
		    		lines += 1;
		    	}
		    	else {
		    		data += myReader.nextLine();
		    		data += "\n";
		    	}
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred");
		      e.printStackTrace();
		    }
		
		bingoData = data.trim().split("\\W+");
		int numberOfBingos = bingoData.length/25;
		int index = 0;
		for(int i = 0; i < numberOfBingos; i++) {
			Bingo b = new Bingo();
			for(int j = 0; j < size; j++ ) {
				for(int k = 0; k < size; k++) {
					b.bingo[j][k] = bingoData[index];
					index += 1; 
				}
			}
			bingos.add(b);
		}
	}

	
	public static void main(String[] args) {
		readFromFile("data/input.txt");
		for(int i = 0; i < numbers.length; i++) {
			for(Bingo b : bingos) {
				b.update(numbers[i]);
				b.showBingo();
				if(b.winner) {
					System.out.println(b.countWinner());
					return;
				}
			}
		}
	}
	
}
