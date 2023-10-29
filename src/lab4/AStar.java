package lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AStar implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		ArrayList<Node> exployed = new ArrayList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				exployed.add(current);
				List<Edge> currents = current.getChildren();
				for(Edge child : currents) {
					Node end = child.getEnd();
					double newPathCost = current.getPathCost() + child.getWeight();
					if(!exployed.contains(end) && !frontier.contains(end)) {
						end.setParent(current);
						end.setPathCost(newPathCost);
						frontier.add(end);
					}else if(frontier.contains(end) && end.getPathCost() > newPathCost) {
						frontier.remove(end);
						end.setPathCost(newPathCost);
						end.setParent(current);
						frontier.add(end);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	class NodeComparatorByHn implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			Double h1 = o1.getH();
			Double h2 = o2.getH();
			int result = h1.compareTo(h2);
			if (result == 0)
				return o1.getLabel().compareTo(o2.getLabel());
			else
				return result;
		}
	}

}
