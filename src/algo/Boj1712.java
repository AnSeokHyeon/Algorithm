// 손익분기점
package algo;

import java.util.Scanner;

public class Boj1712 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		if(B>=C)
			System.out.println(-1);
		else {

			int N = A/(C-B);
			System.out.println(N+1);
		}
		

	}

}
