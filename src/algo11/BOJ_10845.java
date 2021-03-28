package algo11;
// 10845 큐

/*
 * 
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10845 {

	static final int MAX = 10000;
	static int top;

	static int queue[] = new int[MAX];

	static void Init() {
		top = 0;
	}

	static void push(int value) {
		queue[top++] = value;
	}

	static int pop() {
		if (top == 0) {
			return -1;
		}

		int temp = queue[0];

		for (int i = 0; i < top; i++) {
			queue[i] = queue[i + 1];
		}

		queue[--top] = 0;
		return temp;
	}

	static int size() {
		return top;
	}

	static int empty() {
		if (top == 0) {
			return 1;
		} else
			return 0;
	}

	static int front() {
		if (top == 0) {
			return -1;
		}
		return queue[0];
	}

	static int back() {
		if (top == 0) {
			return -1;
		}
		return queue[top - 1];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Init();
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			String s = st.nextToken();

			if (s.equals("push")) {
				int n = Integer.parseInt(st.nextToken());
				push(n);
			} else if (s.equals("pop")) {
				sb.append(pop() + "\n");
			} else if (s.equals("size")) {
				sb.append(size() + "\n");
			}

			else if (s.equals("empty")) {
				sb.append(empty() + "\n");
			}

			else if (s.equals("front")) {
				sb.append(front() + "\n");
			}

			else if (s.equals("back")) {
				sb.append(back() + "\n");
			}

		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}