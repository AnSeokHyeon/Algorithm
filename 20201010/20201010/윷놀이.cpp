#include <iostream>

using namespace std;

int h[5] = { 0 };
int mv[11];
int line[130] = { 0 };
int chk[130] = {0};
int A[10] = { 10,13,16,19,25,0,0,0,0,0 };
int B[10] = { 20,22,24,25,0,0,0,0,0,0 };
int C[10] = { 30,28,27,26,25,0,0,0,0,0 };
int D[10] = { 25,30,35,40,0,0,0,0,0,0 };
int E[10] = { 40,50,50,50,50,50,50,50,50,50 };
int result = 0;
int ans = 0;

int move(int n, int d) {
	int next = mv[n] + d;
	int gap = 0;
	if (next < 30) {
		if (next == 5) next = 30;
		else if (next == 10) next = 50;
		else if (next == 15) next = 70;
		else if (next >= 20) {
			gap = next - 20;
			next = 110 + gap;
		}
	}
	if (next > 33 && next < 50) {
		gap = next - 34;
		next = 90 + gap;
	}
	if (next > 52 && next < 70) {
		gap = next - 53;
		next = 90 + gap;
	}
	if (next > 73 && next < 90) {
		gap = next - 74;
		next = 90 + gap;
	}
	if (next > 92 && next < 110) {
		gap = next - 93;
		next = 110 + gap;
	}
	if (line[next] < 50 && chk[next] > 0) next = -1;
	return next;
}

void dfs(int n) {
	/*cout << " µé¾î¿È " << endl;

	for (int i = 1; i < 7; i++) {
		int start = (i - 1) * 20;
		int end = i * 20;
		for (int j = start + 1; j <= end; j++) {
			printf("%3d", line[j]);
		}
		cout << endl;
		for (int j = start + 1; j <= end; j++) {
			printf("%3d", chk[j]);
		}
		cout << endl;
		cout << endl;

	}*/
	if (n == 11) {
		if (result > ans) ans = result;


		/*cout << " µé¾î¿È " << endl;

		for (int i = 1; i < 7; i++) {
			int start = (i - 1) * 20;
			int end = i * 20;
			for (int j = start + 1; j <= end; j++) {
				printf("%3d", line[j]);
			}
			cout << endl;
			for (int j = start + 1; j <= end; j++) {
				printf("%3d", chk[j]);
			}
			cout << endl;
			cout << endl;

		}

		cout << " »óÅÂÁ¤º¸ " << endl;
		for (int i = 1; i < 5; i++) {
			cout<< i << " : "  << h[i] << " / ";
		}
		cout << endl;*/

		return;
	}

	for (int i = 1; i < 5; i++) {
		if (line[h[i]] > 45) continue;
		int tp = move(n, h[i]);
		int tp2 = h[i];
		if (tp == -1) continue;
		chk[tp2]--;
		h[i] = tp;
		chk[tp]++;
		if (line[tp] < 45) {
			result += line[tp];
		}

		dfs(n + 1);

		chk[tp]--;
		h[i] = tp2;
		chk[tp2]++;

		if (line[tp] < 45) {
			result -= line[tp];
		}


	}

}

int main(void) {
	for (int i = 1; i < 11; i++) {
		cin >> mv[i];
	}
	for (int i = 0; i < 120; i++) {
		if (i < 21) {
			line[i] = i * 2;
		}
		if (i / 10 == 3) {
			line[i] = A[i % 30];
		}
		if (i / 10 == 5) {
			line[i] = B[i % 50];
		}
		if (i / 10 == 7) {
			line[i] = C[i % 70];
		}
		if (i / 10 == 9) {
			line[i] = D[i % 90];
		}
		if (i / 10 == 11) {
			line[i] = E[i % 110];
		}

	}

	//for (int i = 1; i < 7; i++) {
	//	int start = (i-1) * 20;
	//	int end = i * 20;
	//	for (int j = start+1; j <=  end; j++) {
	//		printf("%3d", line[j]);
	//	}
	//	cout << endl;
	//	for (int j = start+1; j <=  end; j++) {
	//		printf("%3d", chk[j]);
	//	}
	//	cout << endl;
	//	cout << endl;

	//}

	dfs(1);
	cout << ans << endl;

}