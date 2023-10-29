package lab4;


public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		
		ISearchAlgo aStar = new AStar();
		Node res = aStar.execute(nodeS, nodeG.getLabel());
		System.out.println(NodeUtils.printPath(res));
		
		ISearchAlgo greedy = new GreedyBestFirst();
		Node res1 = greedy.execute(nodeS, nodeG.getLabel());
		System.out.println(NodeUtils.printPath(res1));
	}

}
