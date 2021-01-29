// 블랙잭
package algo2;

import java.util.Scanner;

public class Boj2798 {
	static int n = 0;
	static int M = 0;
	static int[] card;
	static int[] pick = new int[3];
	static int jackpot = 0;
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		M = sc.nextInt();
		card = new int[n];
		
		for(int i = 0; i<n;i++) {
			card[i] = sc.nextInt();
		}
		
		blackjack(0, 0);
		System.out.println(jackpot);
	}
	public static void blackjack(int a, int b) {
		if(b == 3) {
			int sum = 0;
			for(int i = 0; i<b;i++) {
				sum+= pick[i];
			}
			if(sum <= M && sum > jackpot) jackpot = sum;
			return;
		}
		for(int i = a; i < n; i++) {
			pick[b] = card[i];
			blackjack(i+1, b+1);
		}
		
	}

}
