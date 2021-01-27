package algo;

import java.util.Scanner;

public class Boj1152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
		String s = sc.nextLine();
		int cnt = 0;
		for(int i = 0; i<s.length(); i++) {
			if((i < s.length()-1) && s.charAt(i) != ' ' && (s.charAt(i+1) == ' '))
					cnt++;
			if(i == s.length()-1 && s.charAt(i) != ' ')
				cnt++;
		}
		System.out.println(cnt);
		}
	}

}
