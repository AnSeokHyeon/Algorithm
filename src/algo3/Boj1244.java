// 스위치 켜고 끄기 
// 예지님 의견 : break를 합치는게 좋은것 같아요
package algo3;

import java.util.Scanner;

public class Boj1244 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		boolean[] s = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
			int temp = sc.nextInt();

			if (temp == 0) {
				s[i] = false;
			} else {
				s[i] = true;
			}

		}
		int T = sc.nextInt();
		while (T-- > 0) {
			int student = sc.nextInt();
			int num = sc.nextInt();

			if (student == 1) {
				for (int i = num; i < N + 1; i += num) {
					s[i] = (s[i]) ? false : true;
				}

			} else {
				int cnt = 0;
				while (true) {
					int left = num - cnt;
					int right = num + cnt;
					if (left < 1 || right > N || (s[left] != s[right]))
						break;
					s[left] = s[right] = (s[right]) ? false : true;
					cnt++;
				}

			}

		}

		for (int i = 1; i < N + 1; i++) {
			if (s[i]) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}

			if (i % 20 == 0)
				System.out.println();

		}
		sc.close();

	}

}
