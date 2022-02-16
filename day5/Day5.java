package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Vent
{
	public int x1,x2,y1,y2;
	public String toString() {
		return x1 + "," + y1 + " -> " + x2 + "," + y2;
	}
};

public class Day5 {
	
	static List<Vent> vents = new ArrayList<Vent>();
	static final int size = 1000;
	static String[][] diagram = new String[size][size];
	static int result = 0;
	
	static void fillDiagram() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				diagram[i][j] = ".";
			}
		}
	}
	
	static void showDiagram() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(diagram[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	static void readFromFile(String filename) {
		String data = "";
		String[] v;
		try {
		      File myObj = new File(filename);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {	    	
		    		data += myReader.nextLine();
		    		data += "\n";		    	
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred");
		      e.printStackTrace();
		    }
			v = data.trim().split("\\W+");
			int index = 0;
			int x1,x2,y1,y2;
			for(int i = 0; i < v.length; i += 4) {
				y1 = Integer.parseInt(v[index]);
				x1 = Integer.parseInt(v[index+1]);
				y2 = Integer.parseInt(v[index+2]);
				x2 = Integer.parseInt(v[index+3]);
				if(x1 == x2 || y1 == y2) {
					Vent vent = new Vent();
					vent.x1 = x1;
					vent.x2 = x2;
					vent.y1 = y1;
					vent.y2 = y2;
					vents.add(vent);
				}
				index += 4;
			}
//			for(Vent ve : vents) {
//				System.out.println(ve.toString());
//			}
//			System.out.println();
	}
	
	static void updateDiagram() {
		for(Vent v : vents) {
			if(v.x1 == v.x2) {
				if(v.y1 > v.y2) {
					for(int i = v.y2; i <= v.y1; i++) {
						if(diagram[v.x1][i] == ".") diagram[v.x1][i] = "1";
						else if (diagram[v.x1][i] == "1") {
							diagram[v.x1][i] = diagram[v.x1][i] = "2";
							result += 1;
						}
						else {
							diagram[v.x1][i] = String.valueOf(Integer.parseInt(diagram[v.x1][i]) + 1);
						}
					}
				}
				else {
					for(int i = v.y1; i <= v.y2; i++) {
						if(diagram[v.x1][i] == ".") diagram[v.x1][i] = "1";
						else if (diagram[v.x1][i] == "1") {
							diagram[v.x1][i] = diagram[v.x1][i] = "2";
							result += 1;
						}
						else {
							diagram[v.x1][i] = String.valueOf(Integer.parseInt(diagram[v.x1][i]) + 1);
						}
					}
				}
			}
			else if(v.y1 == v.y2) {
				if(v.x1 > v.x2) {
					for(int i = v.x2; i <= v.x1; i++) {
						if(diagram[i][v.y1] == ".") diagram[i][v.y1] = "1";
						else if (diagram[i][v.y1] == "1") {
							diagram[i][v.y1] = diagram[i][v.y1] = "2";
							result += 1;
						}
						else {
							diagram[i][v.y1] = String.valueOf(Integer.parseInt(diagram[i][v.y1]) + 1);
						}
					}
				}
				else {
					for(int i = v.x1; i <= v.x2; i++) {
						if(diagram[i][v.y1] == ".") diagram[i][v.y1] = "1";
						else if (diagram[i][v.y1] == "1") {
							diagram[i][v.y1] = diagram[i][v.y1] = "2";
							result += 1;
						}
						else {
							diagram[i][v.y1] = String.valueOf(Integer.parseInt(diagram[i][v.y1]) + 1);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		readFromFile("data/input.txt");
		fillDiagram();
		updateDiagram();
		//showDiagram();
		System.out.println(result);
	}
	
}
