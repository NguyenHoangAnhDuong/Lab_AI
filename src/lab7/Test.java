package lab7;

public class Test {
	public static void main(String[] args) {
		GA ga = new GA();
		Node solution = ga.execute();
		solution.displayBoard();
		System.out.println(solution.getH());
		
	}

}
