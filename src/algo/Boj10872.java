// 팩토리얼 
package algo;

import java.util.Scanner;

public class Boj10872 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long result = fact(n, 1);
		
		System.out.println(result);
		
	}
	
	public static long fact (int n, int gop) {
		
		if(n == 1 || n == 0) return gop;
		else {
			gop = gop * n;
			return fact(n-1, gop);
		}
	}
}
/*
public class Boj10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int result = 1;
		for(int i = 1; i<=n;i++) {
			result *= i;
		}
		System.out.println(result);
		
	}

}
*/