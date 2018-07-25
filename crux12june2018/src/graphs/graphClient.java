package graphs;

public class graphClient {

	public static void main(String[] args) {

		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "B", 10);
		graph.addEdge("B", "C", 10);
		graph.addEdge("C", "D", 10);
		graph.addEdge("A", "D", 10);
		graph.addEdge("D", "E", 10);
		graph.addEdge("E", "F", 10);
		graph.addEdge("E", "G", 10);
		graph.addEdge("G", "F", 10);
		graph.display();
		graph.removeEdge("D", "E");

		graph.display();
//
//		System.out.println(graph.isConn());
//		System.out.println(graph.isCyclic());
		System.out.println(graph.connCompo());
	}

}
