package algo;

import java.util.Scanner;

public class Boj1018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] c = new char[n][m];

		for (int i = 0; i < n; i++) {
			String S = sc.next();
			for (int j = 0; j < m; j++) {
				c[i][j] = S.charAt(j);
			}
		}
		int B = 0;
		int A = 0;
		int min = 10000;
		for (int x = 0; x <= n - 8; x++) {
			for (int y = 0; y <= m - 8; y++) {
				A = 0;
				B = 0;
				for (int i = x; i < x+8; i++) {
					for (int j = y; j < y+8; j++) {
						int sum = i + j;
						if (sum % 2 == 0) {
							if (c[i][j] == 'B')
								A++;
							else
								B++;
						} else {
							if (c[i][j] == 'B')
								B++;
							else
								A++;
						}
					}
				}

				int result = (A > B) ? B : A;
				if( min > result) min = result;
			}
		}
		System.out.println(min);
	}

}
