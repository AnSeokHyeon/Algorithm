// 팩토리얼
package algo3;

import java.util.Scanner;

public class Boj7489 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (T-- > 0) {
			int N = sc.nextInt();
			int result = 1;
			while (N > 0) {
				result *= N;
				while (true) {
					if (result % 10 == 0)
						result /= 10;
					else {
						result %= 1000;
						break;
					}
				}
				N--;
			}
			System.out.println(result%10);

		}
		sc.close();

	}
}
