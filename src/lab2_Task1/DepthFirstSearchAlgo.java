package lab2_Task1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
public class DepthFirstSearchAlgo implements ISearchAlgo{
	
	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<Node>(); 
		// TODO Auto-generated method stub
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node children = frontier.pop();
			if (children.getLabel().equals(goal)) {
				return children;

			}
			explored.add(children);
			List<Node> child = children.getChildrenNodes();
			Collections.reverse(child);
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
