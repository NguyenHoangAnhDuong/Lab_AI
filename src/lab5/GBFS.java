package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GBFS implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		ArrayList<Node> exployed = new ArrayList<Node>();
		frontier.add(model.getInitialState());
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.equals(model.getGoalState())) {
				return current;
			}else {
				exployed.add(current);
				List<Node> currents = model.getSuccessors(current);
				for(Node child : currents) {
					if(!exployed.contains(child) && !frontier.contains(child)) {
						child.setG(model.computeH2(child));
						child.setH(current.getG() +1);
						frontier.add(child);
					}
				}
			}
		}
		return null;
	}

}
