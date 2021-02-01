// 제로
package algo3;

import java.util.Scanner;
import java.util.Stack;

public class Boj10773 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> s = new Stack<>();

		while (K-- > 0) {
			int n = sc.nextInt();

			if (n == 0) {
				if (!s.isEmpty())
					s.pop();
			} else {
				s.add(n);
			}
		}
		int sum = 0;
		while (!s.isEmpty()) {

			sum += s.peek();
			s.pop();
		}
		System.out.println(sum);
		sc.close();
	}
}
