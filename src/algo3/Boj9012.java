//괄호

package algo3;

import java.util.Scanner;
import java.util.Stack;

public class Boj9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		while (K-- > 0) {
			String s = sc.next();
			boolean result = true;
			Stack<Integer> st = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(') {
					st.add(1);
				}

				else {
					if (!st.empty()) {
						st.pop();
					} else {
						result = false;
						break;
					}
				}
			}

			if (!st.empty())
				result = false;

			if (result)
				System.out.println("YES");
			else
				System.out.println("NO");

		}
		sc.close();

	}

}
