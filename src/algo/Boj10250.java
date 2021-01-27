//ACM 호텔

package algo;

import java.util.Scanner;

public class Boj10250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		while((T--) > 0) {

			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			
			int floor = N % H;
			int no = N / H + 1;
			if(floor == 0) {
				floor = H;
				no--;
			}
			
			int roomno = floor*100 + no;
			System.out.println(roomno);
			
		}
	}

}
