#include <iostream>

using namespace std;
int N, W;
int result = 0;
int weight[1001];
int value[1001];
bool c[1001];

void packing (int n, int m, int w, int v) {
	if (w > W) {
		return;
	}

	if (n == N) {
		return;
	}

	for (int i = m; i < N; i++) {
		if (c[i] == true) continue;
		c[i] = true;
		w = w + weight[i];
		v = v + value[i];
		if (w <= W && result < v) result = v;
		packing(n + 1, i + 1, w, v);
		c[i] = false;
		w = w - weight[i];
		v = v - value[i];

	}
}

int main(void) {
	cin >> N >> W;
	for (int i = 0; i < N; i++) {
		cin >> weight[i] >> value[i];
	}
	packing(0, 0, 0,0);
	cout << result;
}