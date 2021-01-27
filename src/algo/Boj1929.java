// 소수 구하기
// https://st-lab.tistory.com/84 참고
package algo;

import java.util.Scanner;

public class Boj1929 {
	
	public static boolean[] prime;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = 1000000;
		make_prime(N);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i = a; i<=b;i++) {
			if(prime[i] == false) {
				System.out.println(i);
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
