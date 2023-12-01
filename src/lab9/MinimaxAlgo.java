package lab9;

public class MinimaxAlgo {
	public void execute(Node node) {
		int v = minValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {

		if(node.isTerminal()) {
			return 0;
		}
		int maxValue = Integer.MIN_VALUE;
		for(Node child : node.getSuccessors()) {
			int childValue = minValue(child);
			maxValue = Math.max(childValue, maxValue);
		}
		return maxValue;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		if(node.isTerminal()) {
			return 1;
		}
		int minValue = Integer.MAX_VALUE;
		for(Node child : node.getSuccessors()) {
			int childValue = maxValue(child);
			minValue = Math.min(childValue, minValue);
		}
		return minValue;
	}
}
