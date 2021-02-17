package algo6;
//마지막 팩토리얼 수
import java.util.Scanner;

public class Boj2553 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {

			int N = sc.nextInt();

			if(N > 20000) break;
			long result = 1;
			int num = 1;
			while (num <= N) {
				int mul = num;
				while(mul%10 == 0) {
					mul /= 10;
				}
				result *= mul;
				while(result%10 == 0) {
					result/=10;
				}
				result %= 100000000;
				num++;
			}
			System.out.println(result % 10);

		}

		sc.close();

	}
}