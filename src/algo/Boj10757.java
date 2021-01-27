// 큰수 A+B
package algo;

import java.util.Scanner;

public class Boj10757 {

	public static void main(String[] args) {
		/*
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//9223372036854775807 9223372036854775808
		while(true) {
		String S1 = sc.next();
		String S2 = sc.next();
		// length 19
		int MAX = (S1.length() > S2.length())?S1.length():S2.length();
		int[] A= new int[MAX+1];
		int[] B = new int[MAX+1];
		int[] C = new int[MAX+1];
		int[] result = new int[MAX+1];
		String S = new String();
		
		for(int i = 0; i<S1.length();i++ ) {
			A[i] = S1.charAt(S1.length()-1-i) - '0';
		}

		for(int i = 0; i<S2.length();i++ ) {

			B[i] = S2.charAt(S2.length()-1-i) - '0';
			
		}
		for(int i = 0; i<=MAX;i++) {
			result[i] = A[i] + B[i] + C[i];
			if(result[i]>9) {
				C[i+1] = 1;
				result[i] -= 10;
			}
		}


		for(int i = MAX;i>-1;i--) {
			if(i == MAX && result[i] == 0) continue;
			char c = (char)( result[i] + '0');
			S += c;
		}
		
		System.out.println(S.trim());
		
		
		
		}

*/	

		Scanner s = new Scanner(System.in);
		System.out.print(s.nextBigInteger().add(s.nextBigInteger()));
	}
}


