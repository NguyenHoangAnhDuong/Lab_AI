package lab2_Task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node children = frontier.poll();
			if (children.getLabel().equals(goal)) {
				return children;

			}
			explored.add(children);
			List<Node> child = children.getChildrenNodes();
			for (Node ch : child) {
				if (!frontier.contains(ch) && !explored.contains(ch)) {
					frontier.add(ch);
					ch.setParent(children);
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

}
