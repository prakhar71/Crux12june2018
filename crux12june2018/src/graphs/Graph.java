package graphs;

import java.util.ArrayList;

import generic_hashmap_and_heap.HeapGeneric;
import java.util.HashMap;
import java.util.LinkedList;

//import demo_crux12june.Graph.BFPair;
import extra_class.Heap_Generic;
import generic_hashmap_and_heap.Heap;

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vertices = new HashMap<>();

	public int numVertex() {

		return vertices.size();
	}

	public boolean containsVertex(String vname) {

		Vertex v = vertices.get(vname);

		if (v == null) {
			return false;
		}
		return true;

	}

	public void addVertex(String vname) {

		Vertex v = new Vertex();

		vertices.put(vname, v);

	}

	public void removeVertex(String vname) {

		Vertex v = vertices.get(vname);

		for (String nbs : v.nbrs.keySet()) {

			Vertex nbrvtx = vertices.get(nbs);
			nbrvtx.nbrs.remove(vname);
		}

	}

	public int numEdges() {

		int sum = 0;

		for (String v : vertices.keySet()) {

			Vertex vtx = vertices.get(v);
			sum += vtx.nbrs.size();
		}

		return sum / 2;

	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex v1 = vertices.get(vname1);
		Vertex v2 = vertices.get(vname2);

		if (v1 == null || v2 == null) {
			return false;
		} else if (v1.nbrs.containsKey(vname2) && v2.nbrs.containsKey(vname1)) {

			return true;
		}
		return false;

	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex v1 = vertices.get(vname1);
		Vertex v2 = vertices.get(vname2);

		if (v1 != null && v2 != null && !v1.nbrs.containsKey(vname2) && !v2.nbrs.containsKey(vname1)) {

			v1.nbrs.put(vname2, cost);
			v2.nbrs.put(vname1, cost);
		}

	}

	public void removeEdge(String vname1, String vname2) {

		Vertex v1 = vertices.get(vname1);
		Vertex v2 = vertices.get(vname2);

		if (v1 != null && v2 != null && v1.nbrs.containsKey(vname2) && v2.nbrs.containsKey(vname1)) {

			v1.nbrs.remove(vname2);
			v2.nbrs.remove(vname1);
		}

	}

	public void display() {

		System.out.println("----------------------");

		for (String keys : vertices.keySet()) {

			System.out.println(keys + "->" + vertices.get(keys).nbrs);
		}

		System.out.println("------------------");
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {

		processed.put(src, true);

		// de

		if (containsEdge(src, dst)) {
			return true;
		}

		Vertex v = vertices.get(src);
		for (String keys : v.nbrs.keySet()) {

			if (processed.get(keys) == false && hasPath(keys, dst, processed)) {
				return true;
			}
		}

		return false;

	}

	private class Pair {
		String vname;
		Vertex vtx;
		String psf;
	}

	public boolean BFS(String src, String dst) {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		Pair sp = new Pair();
		sp.vname = src;
		sp.vtx = vertices.get(src);
		sp.psf = sp.vname;
		queue.addLast(sp);

		while (!queue.isEmpty()) {

			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			processed.put(rp.vname, true);
			if (containsEdge(rp.vname, dst)) {
				System.out.println(dst + "via" + rp.psf + dst);
				return true;
			}

			// 2E
			for (String keys : rp.vtx.nbrs.keySet()) {
				if (!processed.containsKey(keys)) {
					Pair np = new Pair();
					np.vname = keys;
					np.vtx = vertices.get(keys);
					np.psf = sp.psf + keys;

					queue.addLast(np);

				}
			}

		}

		return false;

	}

	public boolean DFS(String src, String dst) {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		sp.vtx = vertices.get(src);
		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			processed.put(rp.vname, true);
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			for (String keys : sp.vtx.nbrs.keySet()) {
				Pair np = new Pair();
				np.vname = keys;
				np.vtx = vertices.get(keys);
				np.psf = sp.psf + dst;

				stack.addFirst(np);
			}

		}

		return false;

	}

	public void BFT() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String keys : vertices.keySet()) {

			if (processed.containsKey(keys)) {
				continue;
			}
			Pair sp = new Pair();
			sp.vname = keys;
			sp.vtx = vertices.get(keys);
			sp.psf = keys;
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {

					continue;
				}

				processed.put(rp.vname, true);
				System.out.println(rp.vname + " via " + rp.psf);

				for (String nbrs : sp.vtx.nbrs.keySet()) {
					Pair np = new Pair();
					np.vname = nbrs;
					np.vtx = vertices.get(nbrs);
					np.psf = sp.psf + nbrs;

					queue.addLast(np);
				}

			}

		}

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
			sp.vtx = vertices.get(keys);
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					flag++;
					return true;
				}

				processed.put(rp.vname, true);

				for (String nbrs : rp.vtx.nbrs.keySet()) {
					Pair np = new Pair();
					np.vname = nbrs;
					np.vtx = vertices.get(nbrs);
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

	public boolean isConn() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		int flag = 0;
		for (String keys : vertices.keySet()) {

			if (processed.containsKey(keys)) {

				continue;
			}

			// make a new pair
			flag++;

			Pair sp = new Pair();
			sp.vname = keys;
			sp.psf = keys;
			sp.vtx = vertices.get(keys);
			queue.addLast(sp);
			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				for (String nbrs : rp.vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbrs)) {
						Pair np = new Pair();
						np.vname = nbrs;
						np.vtx = vertices.get(nbrs);
						np.psf = rp.psf + nbrs;

						queue.addLast(np);
					}
				}

			}

		}

		if (flag > 1) {
			return false;
		} else {
			return true;
		}
	}

	public ArrayList<ArrayList<String>> connCompo() {

		ArrayList<ArrayList<String>> list = new ArrayList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String keys : vertices.keySet()) {

			if (processed.containsKey(keys)) {
				continue;
			}

			// make a new pair
			// it is region where distinct set of cyclic elements occours
			// like every time it finds new group it comes here
			ArrayList<String> l1 = new ArrayList<>();

			Pair sp = new Pair();
			sp.vname = keys;
			sp.psf = keys;
			sp.vtx = vertices.get(keys);
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);
				l1.add(rp.vname);

				for (String nbrs : rp.vtx.nbrs.keySet()) {

					if (!processed.containsKey(nbrs)) {
						Pair np = new Pair();
						np.vname = nbrs;
						np.vtx = vertices.get(nbrs);
						np.psf = rp.psf + nbrs;

						queue.addLast(np);
					}
				}
			}

			list.add(l1);

		}

		return list;
	}

	public boolean isTree() {

		return isConn() && !isCyclic();

	}

	private class PrimsPair implements Comparable<PrimsPair> {
		String vname;
		int cost;
		String disvtx;

		@Override
		public int compareTo(PrimsPair o) {

			return o.cost - this.cost;
		}
	}

	public Graph prims() {

		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();
		HashMap<String, PrimsPair> processed = new HashMap<>();

		Graph mst = new Graph();

		for (String keys : vertices.keySet()) {

			PrimsPair np = new PrimsPair();
			np.cost = Integer.MAX_VALUE;
			np.disvtx = null;
			np.vname = keys;

			heap.insert(np);
			processed.put(keys, np);
		}

		while (!heap.isEmpty()) {

			PrimsPair rp = heap.remove();
			processed.remove(rp.vname);

			if (rp.disvtx == null) {
				mst.addVertex(rp.vname);
			} else {

				mst.addVertex(rp.vname);
				mst.addEdge(rp.vname, rp.disvtx, rp.cost);
			}

			// nbrs
			for (String nbr : vertices.get(rp.vname).nbrs.keySet()) {

				if (processed.containsKey(nbr)) {

					int oc = processed.get(nbr).cost;

					int nc = vertices.get(rp.vname).nbrs.get(nbr);

					if (nc < oc) {

						processed.get(nbr).disvtx = rp.vname;
						processed.get(nbr).cost = nc;

						heap.updatePriority(processed.get(nbr));
					}

				}

			}

		}

		return mst;

	}

	private class DijkstraPair implements Comparable<DijkstraPair> {

		String vname;
		String psf;
		int cost;

		@Override
		public int compareTo(DijkstraPair o) {

			return o.cost - this.cost;
		}

	}

	public void dijkstra(String src) {

		HeapGeneric<DijkstraPair> heap = new HeapGeneric<>();

		HashMap<String, DijkstraPair> processed = new HashMap<>();

		for (String keys : vertices.keySet()) {

			DijkstraPair np = new DijkstraPair();
			np.cost = Integer.MAX_VALUE;
			np.psf = "";
			np.vname = keys;

			heap.insert(np);
			processed.put(keys, np);
		}

		while (!heap.isEmpty()) {

			DijkstraPair rp = heap.remove();
			processed.remove(rp.vname);

			if(rp.vname == src) {
				rp.psf=src;
				rp.cost=0;
			}
			// nbrs
			for (String nbr : vertices.get(rp.vname).nbrs.keySet()) {

				if (processed.containsKey(nbr)) {

					int oc = processed.get(nbr).cost;

					int nc = vertices.get(rp.vname).nbrs.get(nbr);

					if (nc < oc) {

						processed.get(nbr).psf = rp.psf + nbr;
						processed.get(nbr).cost = nc + rp.cost;

						heap.updatePriority(processed.get(nbr));
					}

				}

			}

		}

	}
	
	protected class BFPair {

		String v1;
		String v2;
		int cost;
	}

	public ArrayList<BFPair> BFList() {

		ArrayList<BFPair> list = new ArrayList<>();

		for (String keys : vertices.keySet()) {

			for (String nbrvtx : vertices.get(keys).nbrs.keySet()) {

				BFPair np = new BFPair();
				np.v1 = keys;
				np.v2 = nbrvtx;
				np.cost = vertices.get(keys).nbrs.get(nbrvtx);

				list.add(np);
			}

		}

		return list;

	}

	public HashMap<String, Integer> BellmanFord(String src) throws Exception {

		HashMap<String, Integer> map = new HashMap<>();

		if (!vertices.containsKey(src)) {
			throw new Exception("unkown token");
		}

		for (String keys : vertices.keySet()) {

			map.put(keys, Integer.MAX_VALUE);
		}

		map.put(src, 0);

		ArrayList<BFPair> list = BFList();
		int V = vertices.size();
		
		for(int i = 0; i<=V-1;i++ ) {
			
			for (BFPair p : list) {

				int oc = map.get(p.v2);

				if (map.get(p.v1) != Integer.MAX_VALUE) {
					int nc = map.get(p.v1) + p.cost;

					if (nc < oc) {
						map.put(p.v2, nc);
					}
				}

			}
		}
		
		for (BFPair p : list) {

			int oc = map.get(p.v2);

			if (map.get(p.v1) != Integer.MAX_VALUE) {
				int nc = map.get(p.v1) + p.cost;

				if (nc < oc) {
					throw new Exception("-ve wt cycle is present");
				}
			}

		}
		
		
		return map;

	}
	
	
	

}
