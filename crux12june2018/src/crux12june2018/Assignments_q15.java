package crux12june2018;

public class Assignments_q15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int	N=3-1;
	int	M=3-1;
		
		System.out.println(mazePath_DCount(0, 0, N,M,""));;

	}

	public static int mazePath_DCount(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int h = mazePath_DCount(cr, cc + 1, er, ec, ans + "H");
		int v = mazePath_DCount(cr + 1, cc, er, ec, ans + "V");
		int d = mazePath_DCount(cr + 1, cc + 1, er, ec, ans + "D");

		return h + v + d;

	}

}
