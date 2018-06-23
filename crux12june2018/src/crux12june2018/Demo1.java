package crux12june2018;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		/*
		 * Scanner sc = new Scanner(System.in); System.out.println("enter ur name");
		 * String name = sc.nextLine(); char ch = sc.nextLine().charAt(0);
		 * System.out.println("enter ur roll");
		 * 
		 * int rollno=sc.nextInt();
		 * 
		 * System.out.println(name); System.out.println(ch); System.out.println(rollno);
		 * 
		 * 
		 */
		// printPattern(0, 0, 10);
		
		/*Queue q = new Queue();
		q.Add(10);
		q.Add(20);
		q.Add(30);
		q.Add(40);
		q.Add(50);
		q.remove();
		q.remove();
		q.remove();
		q.remove();
		q.remove();
		q.remove();
		q.display();*/
		
		 Scanner sc = new Scanner(System.in);
	        int n =sc.nextInt(); // row
	        int m = sc.nextInt();// col
	        
	         System.out.println(mazePathCount(0,0,n-1,m-1,""));
	         mazePath(0,0,n-1,m-1,"");
		

	}
	
	 public static int mazePathCount(int cr, int cc, int er, int ec, String ans) {

			int counth = 0, countv = 0;

			if (cr == er && cc == ec) {
			//System.out.println("vcxs");
				return 1;
			}

			if (cr > er || cc > ec) {
				
				return 0;
			}

			counth = mazePathCount(cr, cc + 1, er, ec, ans + "V");
			countv = mazePathCount(cr + 1, cc, er, ec, ans + "H");

			return counth + countv;

		}
		
		public static int mazePath(int cr, int cc, int er, int ec, String ans) {

			int counth = 0, countv = 0;

			if (cr == er && cc == ec) {
				System.out.print(ans + " ");
				return 1;
			}

			if (cr > er || cc > ec) {
				return 0;
			}

			counth = mazePath(cr, cc + 1, er, ec, ans + "V");
			countv = mazePath(cr + 1, cc, er, ec, ans + "H");

			return counth + countv;

		}
	    

}
