// 단어 정렬
package algo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Boj1181 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Word> words = new ArrayList<Word>();
		for (int i = 0; i < N; i++) {
			Word w = new Word();
			w.str = br.readLine();
			w.len = w.str.length();
			words.add(w);
		}
		MyComparator myComparator = new MyComparator();
		Collections.sort(words, myComparator);
		for (int i = 0; i < N; i++) {
			if(i> 0&& words.get(i).str.equals(words.get(i-1).str)) continue;
			System.out.println(words.get(i).str);
		}

	}

	static class Word {
		int len;
		String str;
	}

	static class MyComparator implements Comparator<Word> {
		@Override
		public int compare(Word w1, Word w2) {
			if (w1.len > w2.len) {
				return 1;
			} else if (w1.len == w2.len) {
				return w1.str.compareTo(w2.str);

			}
			return -1;
		}
	}
}
