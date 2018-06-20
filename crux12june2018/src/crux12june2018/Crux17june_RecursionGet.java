package crux12june2018;

import java.util.ArrayList;

public class Crux17june_RecursionGet {

	public static void main(String[] args) {

		System.out.println(coinToss(3));

		System.out.println(mazePath(0, 0, 2, 2));
	}

	// public static ArrayList<String> getSS(String str) {
	//
	// }

	public static ArrayList<String> coinToss(int n) {

		ArrayList<String> mr = new ArrayList<String>();
		if (n == 0) {
			mr.add("");
			return mr;
		}

		ArrayList<String> rr = coinToss(n - 1);

		for (String rrs : rr) {
			mr.add("H" + rrs);
			mr.add("T" + rrs);

		}

		return mr;

	}

	public static ArrayList<String> mazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;

		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<String>();

			return br;
		}

		ArrayList<String> mr = new ArrayList<String>();

		ArrayList<String> rrv = mazePath(cr, cc + 1, er, ec);

		for (String rrs : rrv) {
			mr.add("V" + rrs);

		}

		ArrayList<String> rrh = mazePath(cr + 1, cc, er, ec);

		for (String rrs : rrh) {
			mr.add("H" + rrs);

		}

		return mr;

	}

}
