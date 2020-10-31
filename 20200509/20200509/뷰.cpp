#include <iostream>
#include <cstdio>

using namespace std;

int bd[1001];

int main(void) {
	int T=10, Tcnt = 0;
	freopen("input (1).txt", "r", stdin);

	while (T--) {
		Tcnt++;
		int n;
		cin >> n;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			cin >> bd[i];
		}
		for (int i = 2; i < n-2; i++) {
			int temp = 0;
			if (bd[i] == 0) continue;
			if (bd[i] <= bd[i - 1]) continue;
			if (bd[i - 1] > temp) temp = bd[i - 1];
			if (bd[i] <= bd[i - 2]) continue;
			if (bd[i - 2] > temp) temp = bd[i - 2];
			if (bd[i] <= bd[i + 1]) continue;
			if (bd[i + 1] > temp) temp = bd[i + 1];
			if (bd[i] <= bd[i + 2]) continue;
			if (bd[i + 2] > temp) temp = bd[i + 2];
			sum = sum + bd[i] - temp;
			i = i + 2;
		}

		cout<< "#" << Tcnt << " " << sum << endl;
	}
	
}