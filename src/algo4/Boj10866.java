/* 10866번 덱
정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여덟 가지이다.

push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

 */

package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<Integer>();

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			String S = st.nextToken();
			if (S.equals("push_front")) {
				dq.addFirst(Integer.parseInt(st.nextToken()));

			} else if (S.equals("push_back")) {
				dq.addLast(Integer.parseInt(st.nextToken()));

			} else if (S.equals("pop_front")) {
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else
					sb.append(dq.pollFirst() + "\n");

			} else if (S.equals("pop_back")) {
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else
					sb.append(dq.pollLast() + "\n");

			} else if (S.equals("size")) {
				sb.append(dq.size() + "\n");

			} else if (S.equals("empty")) {
				if (dq.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}

			} else if (S.equals("front")) {
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.peekFirst() + "\n");
				}

			} else if (S.equals("back")) {
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.peekLast() + "\n");
				}
			}

		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
