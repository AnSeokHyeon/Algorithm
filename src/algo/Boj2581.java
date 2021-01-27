// 소수
package algo;

import java.util.Scanner;

public class Boj2581 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int min = 100000;
		int sum = 0;
		
		for(int i = M;i<=N;i++) {
			if(i == 1) continue;
			boolean chk = true;
			for(int j = 2; j<=i/2;j++) {
				if(i % j == 0) {
					chk = false;
					break;
				}
			}
			
			if(chk) {
				if( min > i) min = i;
				sum += i;
			}
			
			
		}
		if(sum == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
			System.out.println(min);
		}

	}

}
