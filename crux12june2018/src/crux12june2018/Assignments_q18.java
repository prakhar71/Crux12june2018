package crux12june2018;

public class Assignments_q18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int j, i, startidx, endidx, sum, max = 0;
		int a[] = { 8, -8, 9, -9, 10, -11, 12 };

		int b[] = new int[2 * (a.length)];
		b = circularCopy(a, b);

		for (i = 0; i < a.length; i++) {
			for (j = i; j <= i + a.length - 1; j++) {

				startidx = i;
				endidx = j;
				sum = sumOfArray(b, startidx, endidx);
				if (sum > max) {
					max = sum;
				}

			}
		}

		System.out.println(max);

	}

	public static int[] circularCopy(int a[], int b[]) {
		// TODO Auto-generated method stub

		int c = 0;
		for (int i = a.length; i < (2 * a.length); i++) {
			b[i] = a[c];
			c++;
		}

		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}

		return b;
	}

	public static int sumOfArray(int a[], int start, int end) {

		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum = sum + a[i];

		}
		return sum;
	}

}
