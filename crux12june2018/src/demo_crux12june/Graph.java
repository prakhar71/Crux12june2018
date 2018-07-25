package demo_crux12june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import generic_hashmap_and_heap.HeapGeneric;
//import graphs.Graph.Pair;

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vertices = new HashMap<>();

	public int numVertex() {

		return vertices.size();
	}

	public boolean containsVertex(String vname) {

		return vertices.containsKey(vname);
	}

	public void addVertex(String vname) {

		Vertex vtx = new Vertex();
		vertices.put(vname, vtx);
	}

	public int numEdges() {

		int sum = 0;
		for (String key : vertices.keySet()) {
			sum += vertices.get(key).nbrs.size();
		}

		return sum / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		if (vertices.get(vname1) == null || vertices.get(vname2) == null) {
			return false;
		}

		if (vertices.get(vname1).nbrs.containsKey(vname2)) {
			return true;
		}

		return false;

	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
// vtx2.nbrs.put(vname1, cost);

	}

	public void removeEdge(String vname1, String vname2) {

		if (vertices.get(vname1) != null || vertices.get(vname2) != null) {
			vertices.get(vname1).nbrs.remove(vname2);
			vertices.get(vname2).nbrs.remove(vname1);

		}
	}

	public void display() {
		System.out.println("-------------------");
		for (String key : vertices.keySet()) {

			System.out.println(key + "->" + vertices.get(key).nbrs);
		}

		System.out.println("-------------------");
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {

		processed.put(src, true);

		if (containsEdge(src, dst)) {
			return true;
		}

		for (String nbrvtx : vertices.get(src).nbrs.keySet()) {
			if (!processed.get(nbrvtx)) {
				boolean ans = hasPath(nbrvtx, dst, processed);
				return ans;
			}
		}

		return false;

	}

	private class Pair {
		String vname;
		Vertex v;
		String psf;
	}

	public boolean BFS(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		// processed.put(src, true);

		Pair sp = new Pair();
		sp.vname = src;
		sp.v = vertices.get(sp.vname);
		sp.psf = sp.vname;

		queue.addLast(sp);

		while (!queue.isEmpty()) {

			Pair rp = queue.removeFirst();
			if (processed.containsKey(rp.vname)) {
				// if u come in this block again i.e if u use continue statement then
				// there r 2 same ele. in the que so cycle is present
				continue;
			}

			processed.put(rp.vname, true);

			if (containsEdge(rp.vname, dst)) {
				System.out.println(dst + " via" + rp.psf + dst);
				return true;
			}

			for (String nbrvtx : rp.v.nbrs.keySet()) {

				if (!processed.containsKey(nbrvtx)) {
					Pair np = new Pair();
					np.vname = nbrvtx;
					np.v = vertices.get(nbrvtx);
					np.psf = rp.psf + nbrvtx;

					queue.addLast(np);
				}

			}
		}

		return false;
	}

	public boolean DFS(String src, String dst) {

		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		// processed.put(src, true);

		Pair sp = new Pair();
		sp.vname = src;
		sp.v = vertices.get(sp.vname);
		sp.psf = sp.vname;

		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) {
				// if u come in this block again i.e if u use continue statement then
				// there r 2 same ele. in the que so cycle is present
				continue;
			}

			processed.put(rp.vname, true);

			if (containsEdge(rp.vname, dst)) {
				System.out.println(dst + " via" + rp.psf + dst);
				return true;
			}

			for (String nbrvtx : rp.v.nbrs.keySet()) {

				if (!processed.containsKey(nbrvtx)) {
					Pair np = new Pair();
					np.vname = nbrvtx;
					np.v = vertices.get(nbrvtx);
					np.psf = rp.psf + nbrvtx;

					stack.addFirst(np);
				}

			}
		}

		return false;
	}

	public boolean isCyclic() {

		int flag = 0;
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String keys : vertices.keySet()) {

			if (processed.containsKey(keys)) {
				continue;
			}

			// make a new pair

			Pair sp = new Pair();
			sp.vname = keys;
			sp.psf = keys;
			sp.v = vertices.get(keys);
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					flag++;
					return true;
				}

				processed.put(rp.vname, true);

				for (String nbrs : rp.v.nbrs.keySet()) {
					Pair np = new Pair();
					np.vname = nbrs;
					np.v = vertices.get(nbrs);
					np.psf = rp.psf + nbrs;

					queue.addLast(np);
				}

			}

		}

		if (flag > 1) {
			return true;
		} else {
			return false;
		}

	}

	private class DigkstraPair implements Comparable<DigkstraPair> {
		String vname;
		String psf;
		int cost;

		@Override
		public int compareTo(DigkstraPair oth) {
			// TODO Auto-generated method stub
			return oth.cost - this.cost;
		}
	}

	public void digikstraPair(String src) {

		HashMap<String, DigkstraPair> map = new HashMap<>();
		HeapGeneric<DigkstraPair> heap = new HeapGeneric<>();

		for (String keys : vertices.keySet()) {

			DigkstraPair np = new DigkstraPair();
			np.vname = keys;
			np.psf = "";
			np.cost = Integer.MAX_VALUE;

			heap.insert(np);
			map.put(keys, np);

		}

		while (!heap.isEmpty()) {
			DigkstraPair rp = heap.remove();
			map.remove(rp);

			if (rp.vname == src) {
				rp.psf = src;
				rp.cost = 0;
			}

			for (String nbrvtx : vertices.get(rp.vname).nbrs.keySet()) {

				if (map.containsKey(nbrvtx)) {
					int oc = map.get(nbrvtx).cost;
					String psf = map.get(nbrvtx).psf;

					int nc = vertices.get(rp.vname).nbrs.get(nbrvtx);

					if (nc < oc) {

						map.get(nbrvtx).cost = rp.cost + nc;
						map.get(nbrvtx).psf = rp.psf + nbrvtx;

						heap.updatePriority(map.get(nbrvtx));
					}
				}

			}

		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
