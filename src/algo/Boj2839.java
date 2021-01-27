// 설탕배달
package algo;

import java.util.Scanner;

public class Boj2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		while (true) {

			int n = sc.nextInt();
			int s5 = n / 5+1;
			int s3 = n / 3+1;
			int min = 10000;
			for(int i = 0; i <= s5 ;i++ ) {
				
				for(int j = 0;j <= s3; j++ ) {
					
					int total = 5*i + 3*j;
					
					if( total == n) {
						if(min > (i+j))
							min = i+j;
					}
				}
				
			}
			
			if(min == 10000) System.out.println(-1);
			else System.out.println(min);
			
		}
	}

}
