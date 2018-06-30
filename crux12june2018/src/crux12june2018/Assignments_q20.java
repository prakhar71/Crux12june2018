package crux12june2018;

import java.util.LinkedList;

public class Assignments_q20 {

	// find max of window of size k
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int[] a = { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 };
		int k = 3;

		java.util.LinkedList<Integer> l = new LinkedList<>();

		for (int i = 0; i < k; i++) {

			while (l.size() != 0 && a[i] > a[l.getLast()]) {
				l.removeLast();
			}

			l.addLast(i);

		}

		int count = 0;

		for (int i = k; i < a.length; i++) {

			System.out.println(a[l.getFirst()] + " ");

			count++;

			// remove useless elements
			if (count > l.getFirst()) {
				l.removeFirst();
			}

			while ((l.size() != 0) && (a[i] > a[l.getLast()])) {
				l.removeLast();
			}

			l.addLast(i);
		}

	}

}
