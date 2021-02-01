// 균형 잡힌 세상
package algo3;

import java.util.Scanner;
import java.util.Stack;

public class Boj4949 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			String s = sc.nextLine();
			boolean chk = true;
			Stack<Integer> st = new Stack<>();
			if (s.length() == 1 && s.charAt(0) == '.')
				break;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (c == '[') {
					st.add(1);
				} else if (c == ']') {
					if (st.empty() || st.peek() != 1) {

						chk = false;
						break;
					} else
						st.pop();
				} else if (c == '(') {
					st.add(2);

				} else if (c == ')') {
					if (st.empty() || st.peek() != 2) {

						chk = false;
						break;
					} else
						st.pop();

				} else
					continue;

			}

			if (st.size() > 0)
				chk = false;

			if (chk) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		sc.close();

	}

}
