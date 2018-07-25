package demo_crux12june;

import demo_crux12june.Graph.BFPair;

public class GraphClient {

	public static void main(String[] args) throws Exception {

		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		

		graph.addEdge("A", "B", 6);
		graph.addEdge("A", "E", 5);
		graph.addEdge("A", "D", 4);
		graph.addEdge("E", "F", 4);
		graph.addEdge("D", "E", -3);
		graph.addEdge("B", "C", 2);
		graph.addEdge("C", "F", 1);
		graph.addEdge("F", "C", 2);
		// graph.display();

//		System.out.println(graph.DFS("A", "F"));
//		System.out.println(graph.BFS("A", "F"));

		// System.out.println(graph.connCompo());

		//System.out.println(graph.B);
		graph.display();
		
//		for(BFPair p : graph.BFList()) {
//			System.out.println(p.v1 + "->" + p.v2 + "." + p.cost);
//		}
		
		System.out.println(graph.BellmanFord("A"));
	}

}
