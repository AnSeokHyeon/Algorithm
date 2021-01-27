// 베르트랑 공준
package algo;

import java.util.Scanner;

public class Boj4948 {
	public static boolean[] prime;

	// TODO Auto-generated method stub
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = 1000000;
		make_prime(N);
		int T = sc.nextInt();
		while((T--) > 0) {

			int a = sc.nextInt();
			
			for (int i = a/2; i > 1; i--) {
				if (prime[i] == false && prime[a-i] == false) {

					System.out.println(i + " " + (a-i));
					break;
				}
			}
		
		}

	}

	public static void make_prime(int N) {
			
			prime = new boolean[N+1];
			prime[0] = prime[1] = true;
			for(int i = 2; i<=Math.sqrt(N);i++) {
				if(prime[i] == true) {
					continue;
				}
				
				for(int j = i*i; j<prime.length; j = j+i) {
					prime[j] = true;
				}
			}

	}

}
