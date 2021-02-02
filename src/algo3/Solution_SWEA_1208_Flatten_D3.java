//Solution_SWEA_1208_Flatten_D3
package algo3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_1208_Flatten_D3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = 10;
		int Tcnt = 1;
		int size = 100;
		while (T-- > 0) {

			int K = sc.nextInt();
			int[] dump = new int[size];

			for (int i = 0; i < size; i++) {
				dump[i] = sc.nextInt();
			}
			Arrays.sort(dump);

			while (K-- > 0) {
				dump[0]++;
				dump[size - 1]--;

				Arrays.sort(dump);
			}

			int result = dump[size - 1] - dump[0];

			System.out.println("#" + Tcnt++ + " " + result);
		}

		sc.close();

	}
}
