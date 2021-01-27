// 직각삼각형
package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Boj4153 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int[] n = new int[3];
			for(int i = 0; i<3; i++) {
				n[i] = sc.nextInt();
			}
			if(n[0] == 0 && n[1] == 0 && n[2] ==0) break;
			
			Arrays.sort(n);
			
			int c = n[2] * n[2];
			int b = n[1] * n[1];
			int a = n[0] * n[0];
			
			if(c == (a + b))System.out.println("right");
			else System.out.println("wrong");
			
		}
		

	}

}
