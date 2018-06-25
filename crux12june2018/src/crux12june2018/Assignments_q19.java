package crux12june2018;

public class Assignments_q19 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int k = 4, i, j;
		int a[] = { 2, 5, -1, 7 ,- 3, -1, -2 };

		int startidx = 0;
		int endidx = k -1;

		Stack s1 = new Stack(7);
		Stack s2 = new Stack(7);

		while (endidx <= (a.length - 1)) {
			
			s1.push(a[startidx]);
			s2.push(a[startidx]);

			for (i = startidx + 1; i <= endidx; i++) {

				

				while ((!s1.isEmpty()) && (a[i] > s1.peek())) {
					s1.pop();
				}

				while ((!s2.isEmpty()) && (a[i] < s2.peek())) {
					s2.pop();
				}

				s1.push(a[i]);
				s2.push(a[i]);

			}
			int tempm = 0, tempmin = 0;
			while (s1.isEmpty() != true) {
				tempm = s1.pop();

			}

			while (s2.isEmpty() != true) {
				tempmin = s2.pop();

			}

			System.out.print((tempm + tempmin) + " ,");
			

			startidx++;
			endidx++;
		}
	}

}
