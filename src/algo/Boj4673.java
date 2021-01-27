//셀프넘버
package algo;

public class Boj4673 {
	public static void main(String[] args) {

		boolean[] chk = new boolean[10001];

		for (int i = 1; i <= 10000; i++) {
			int a = i / 1000;
			int b = (i / 100) % 10;
			int c = (i / 10) % 10;
			int d = i % 10;

			int next = a + b + c + d + i;
			if (next > 10000)
				continue;
			chk[next] = true;

		}

		for (int i = 1; i <= 10000; i++) {
			if (!chk[i])
				System.out.println(i);

		}
	}

}
