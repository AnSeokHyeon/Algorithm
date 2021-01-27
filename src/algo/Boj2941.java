// 크로아티아 알파벳
package algo;

import java.util.Scanner;

public class Boj2941 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			
		String s = sc.next();
		int cnt = 0;
		
		for(int i = 0; i < s.length();i++) {
			if(i<s.length()-2 && 
					s.charAt(i) == 'd' &&
					s.charAt(i+1) == 'z' &&
					s.charAt(i+2) == '=') {
				i = i+2;
				//System.out.println(i + " , " + cnt + " | " + "dz=");
			}
			else if(i<s.length()-1 &&
					s.charAt(i) == 'c' &&
					s.charAt(i+1) == '=') {
				i++;
				//System.out.println(i + " , " + cnt + " | " + "c=");
			}

			else if(i<s.length()-1 &&
					s.charAt(i) == 'c' &&
					s.charAt(i+1) == '-') {
				i++;
				//System.out.println(i + " , " + cnt + " | " + "c-");
			}

			else if(i<s.length()-1 &&
					s.charAt(i) == 'd' &&
					s.charAt(i+1) == '-') {
				i++;
				//System.out.println(i + " , " + cnt + " | " + "d-");
			}

			else if(i<s.length()-1 &&
					s.charAt(i) == 'l' &&
					s.charAt(i+1) == 'j') {
				i++;
				//System.out.println(i + " , " + cnt + " | " + "lj");
			}

			else if(i<s.length()-1 &&
					s.charAt(i) == 'n' &&
					s.charAt(i+1) == 'j') {
				i++;
				//System.out.println(i + " , " + cnt + " | " + "nj");
			}

			else if(i<s.length()-1 &&
					s.charAt(i) == 's' &&
					s.charAt(i+1) == '=') {
				i++;
				//System.out.println(i + " , " + cnt + " | " + "s=");
			}

			else if(i<s.length()-1 &&
					s.charAt(i) == 'z' &&
					s.charAt(i+1) == '=') {
				i++;
				//System.out.println(i + " , " + cnt + " | " + "z=");
			}
			//else
				//System.out.println(i + " , " + cnt + " | " + s.charAt(i));

			cnt++;

		}
		System.out.println(cnt);}
	}

}
