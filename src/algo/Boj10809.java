// 알파벳찾기
package algo;

import java.util.Scanner;

public class Boj10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		int[] a = new int[26];
		for(int i = 0; i<S.length();i++) {
			int temp = S.charAt(i) - 'a';
			if(a[temp] == 0) a[temp] = i+1;
		}

		for(int i = 0; i<a.length;i++) {
			System.out.print(a[i]-1 + " ");
		}
		
	}

}
