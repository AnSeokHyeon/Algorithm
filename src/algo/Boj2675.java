package algo;

import java.util.Scanner;

public class Boj2675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		while(true) {
			
			int R = sc.nextInt();
			String S = sc.next();
			
			for(int i = 0; i<S.length();i++) {
				for(int j = 0; j<R;j++) {
					System.out.print(S.charAt(i));
				}
			}
			System.out.println();

			
			
			
			T--;
			if(T < 1 ) break;
			
		}
	}

}
