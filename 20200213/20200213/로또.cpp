#include <iostream>

using namespace std;
int S[13];
int jotto[6];
int k;

void lotto(int a, int b) {
	if (b == 6) {
		for (int i = 0; i < 6; i++) {
			cout << jotto[i] << " ";
		}
		cout << endl;
		return;
	}
	for (int i = a; i < k; i++) {
		jotto[b] = S[i];
		lotto(i + 1, b + 1);
	}
}

int main(void) {
	int T = 1;
	while (T) {
		cin >> k;
		if (k == 0) T=0;
		for (int i = 0; i < k; i++) {
			cin >> S[i];
		}
		lotto(0, 0);
		cout << endl;
	}
}