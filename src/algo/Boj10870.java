// 피보나치수
package algo;

import java.math.BigDecimal;
import java.util.Scanner;

public class Boj10870 {
	
	static int[] num = new int[1001];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//int result = p(N);
		//System.out.println(result);
		p2(N);
		System.out.println(num[N]);

	}
	/*
	public static int p(int n) {
		if(n == 0) return 0;
		else if(n == 1) return 1;
		else
			return p(n-1) + p(n-2);
		
		
	}
	*/
	
	public static void p2(int n) {
		num[0] = 0;
		num[1] = 1;
		for(int i = 2; i<=n;i++) {
			num[i] = num[i-1] + num[i-2];
		}
	}
}
