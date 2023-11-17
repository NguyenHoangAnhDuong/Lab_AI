package lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Enter your code here
		initPopulation();
		int k = 0;
		List<Node> newPopulation = new ArrayList<Node>();
		while (k++ < MAX_ITERATIONS) {
			for(int i = 0; i < POP_SIZE; i++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByRandomSelection();
				Node child = reproduce(x, y);
				if(rd.nextDouble() < MUTATION_RATE) {
					mutate(child);
				}
				if(child.getH() == 0) {
					return child;
				}
				newPopulation.add(child);
				
			}
			population = newPopulation;
		}
		Collections.sort(population);
		
		return population.get(0);
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
	    int randomQueen = rd.nextInt(Node.N);
	    int newRow = rd.nextInt(Node.N);

	    // Update the row of the selected random queen
	    node.setRow(randomQueen, newRow);
	}


	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		Node child = new Node();
		child.generateBoard();
		int c = rd.nextInt(Node.N);
		for(int i = 0; i < c; i++) {
			child.setRow(i, x.getRow(i));
		}
		for(int i = c+1; i < Node.N; i++) {
			child.setRow(i, y.getRow(i));
		}
		return child;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection(List<Node> population, int tournamentSize) {
	    // Ensure the tournament size is not greater than the population size
	    tournamentSize = Math.min(tournamentSize, population.size());

	    Node bestParent = null;

	    // Randomly select K individuals for the tournament
	    List<Node> tournamentParticipants = new ArrayList<>();
	    for (int i = 0; i < tournamentSize; i++) {
	        int randomIndex = rd.nextInt(population.size());
	        tournamentParticipants.add(population.get(randomIndex));
	    }

	    // Find the best individual in the tournament
	    for (Node participant : tournamentParticipants) {
	        if (bestParent == null || participant.getH() > bestParent.getH()) {
	            bestParent = participant;
	        }
	    }

	    return bestParent;
	}


	// Select a random parent from the population
	// Select a random parent from the population
	public Node getParentByRandomSelection() {
	    return population.get(rd.nextInt(POP_SIZE));
	}


}
