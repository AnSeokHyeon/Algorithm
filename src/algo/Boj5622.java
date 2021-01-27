// 다이얼
package algo;

import java.util.Scanner;

public class Boj5622 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int sum = 0;
		for(int i = 0; i<s.length();i++) {
			char c = s.charAt(i);
			int n = c - 'A';
			int t = 0;
			if(n<15) {
				t = n/3 + 2;
			}
			else if(n < 19) {
				t = 7;
			}
			else if(n < 22) {
				t = 8;
			}
			else 
				t = 9;
			
			sum += (t+1);
			
			
		}
		System.out.println(sum);

	}

}
