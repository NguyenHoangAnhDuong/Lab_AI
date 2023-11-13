package lab6;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Queen queen1 = new Queen(0, 1);
		Queen queen2 = new Queen(0, 2);
		Queen queen3 = new Queen(0, 3);
		Queen queen4 = new Queen(0, 4);
		Queen queen5 = new Queen(0, 5);
		Queen queen6 = new Queen(0, 6);
		Queen queen7 = new Queen(0, 7);
		Queen queen8 = new Queen(0, 0);
		Queen[] state = {queen1,queen2,queen3,queen4,queen5,queen6,queen7,queen8};
		Node node = new Node(state);
		node.execute(node);
		node.displayBoard();
		
		
	}
	

}
