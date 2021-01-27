// 부녀 회장이 될테야
package algo;

import java.util.Scanner;

public class Boj2775 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] apt = new int[15][15];
		for(int i = 0; i<=14; i++) {
			for(int j = 1; j<=14; j++) {
				if(i == 0) {
					apt[i][j] = j;
				}
				else {
					apt[i][j] = apt[i-1][j] + apt[i][j-1];
				}
			
			}
		}
		while((T--) > 0) {
			
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			System.out.println(apt[k][n]);
			
		}

	}

}
