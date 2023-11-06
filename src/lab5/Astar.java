package lab5;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class Astar implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		ArrayList<Node> exployed = new ArrayList<Node>();
		
		Node initialState = model.getInitialState();
		initialState.setG(0);
		initialState.setH(model.computeH2(initialState));
		
		frontier.add(initialState);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.equals(model.getGoalState())) {
				return current;
			}else {
				exployed.add(current);
				for(Node child : model.getSuccessors(current)) {
					int tentativeG = current.getG() +1;
					if(!exployed.contains(child) && !frontier.contains(child) || tentativeG < child.getG()) {
						child.setG(current.getG()+1);
						child.setH(model.computeH2(child));
						frontier.add(child);
					}
				}
			}
		}
		return null;
	}
}
