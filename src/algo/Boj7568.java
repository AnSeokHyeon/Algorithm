package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Boj7568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] w = new int[51];
		int[] h = new int[51];
		int[] r = new int[51];
		Arrays.fill(r, 1);
		int N = sc.nextInt();
		for(int i = 0; i<N;i++) {
			w[i] = sc.nextInt();
			h[i] = sc.nextInt();
		}
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				
				if(i == j) continue;
				if(w[j] > w[i] && h[j] > h[i]) {
					r[i]++;
				}
			}
		}
		for(int i = 0; i<N;i++) {
			System.out.print(r[i]+ " ");
		}
	}
}
