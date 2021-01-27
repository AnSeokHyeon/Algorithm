//  단어공부
package algo;

import java.util.Scanner;

public class Boj1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		int[] a = new int[26];
		//int temp1 = 'A'; // 65
		//int temp12 = 'Z'; // 90

		//int temp2 = 'a'; // 97
		//int temp22 = 'z'; // 122
		
		
		for(int i = 0; i<S.length(); i++) {
			int temp = 0;
			char c = S.charAt(i);
			if(c < 95) temp = c - 'A';
			else temp = c - 'a';
			a[temp]++;
		}
		int tempmax = 0;
		for(int i = 0; i<a.length; i++) {
			if(a[i] > tempmax) tempmax = a[i];
		}
		int cnt = 0;
		int max = 0;
		for(int i = 0; i<a.length; i++) {
			if(a[i] == tempmax) {
				cnt++;
				max = i;
			}
		}
		if( cnt == 1) {
			int c = max + 'A';
			System.out.println((char)c);
		}
		else System.out.println("?");
	}
}
