package algo;

import java.util.Scanner;

public class Boj11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		
		int N = sc.nextInt();
		String S = sc.next();
		char[] c = new char[N];
		int sum = 0;
		for(int i = 0; i<N; i++) {
			int temp = S.charAt(i) - '0';
			sum += temp;
		}
		
		/*
		 * 
		for(int i = 0; i<N;i++) {
			char c = S(i);
			int temp = c - '0';
			sum += temp;
			System.out.println(i + " , " + sum);
		}
		*/
		System.out.println(sum);
		
	}
}
