package algo6;

//팩토리얼 0의 개수
import java.util.Scanner;

public class Boj1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;

		long result = 1;
		int num = 1;
		while (num <= N) {
			int mul = num;
			while (mul % 10 == 0) {
				mul /= 10;
				cnt++;
			}
			result *= mul;
			while (result % 10 == 0) {
				result /= 10;

				cnt++;
			}
			result %= 100000000;
			num++;
		}
		System.out.println(cnt);

		sc.close();

	}
}