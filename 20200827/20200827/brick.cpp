#include <iostream>
#include <queue>
#include <cstdio>

using namespace std;
struct pos {
	int x;
	int y;
	int n;
	pos() {
		this->x = 0;
		this->y = 0;
		this->n = 0;
	}
	pos(int x, int y, int n) {
		this->x = x;
		this->y = y;
		this->n = n;
	}
};
int map[17][14];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int N, W, H;
int brick = 987654321;
int cnt = 0;
queue<pos> q;
void find(int n, int a[][14]) {
	if (n == N) {
		int cnt = 0;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				//cout << a[i][j] << " ";
				if (a[i][j] != 0) cnt++;
			}
			//cout << endl;
		}
		if (brick > cnt) brick = cnt;
		return;
	}
	int copy[17][14];
	int high = 0;

	for (int i = 1; i <= W; i++) {
		high = i;
		for (int j = 1; j <= H; j++) {
			for (int k = 1; k <= W; k++) {
				copy[j][k] = a[j][k];
			}
		}

		for (int j = 1; j <= H; j++) {
			if (a[j][high] != 0) {
				q.push(pos(j, high, copy[j][high]));
				copy[j][high] = 0;
				break;
			}
		}

		while (!q.empty()) {
			pos f = q.front();
			cnt++;
			q.pop();
			int x = f.x;
			int y = f.y;
			int n = f.n;
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < n; k++) {
					int mx = x + dx[j] * k;
					int my = y + dy[j] * k;
					if (mx > H || my > W || mx < 1 || my < 1) continue;
					if (copy[mx][my] == 0) continue;
					q.push(pos(mx, my, copy[mx][my]));
					copy[mx][my] = 0;

				}
			}

		}

		for (int k = 1; k <= W; k++) {
			for (int j = H; j > 0; j--) {
				if (copy[j][k] == 0) continue;
				for (int l = H; l > j; l--) {
					if (copy[l][k] != 0) continue;
					int temp = copy[j][k];
					copy[j][k] = copy[l][k];
					copy[l][k] = temp;
					break;
				}
			}
		}

		find(n + 1, copy);
	}
}

int main(void) {
	int T, Tcnt = 1;
	//freopen("sample_input.txt", "r", stdin);
	cin >> T;
	while (T--) {
		cin >> N >> W >> H;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				cin >> map[i][j];
			}
		}
		brick = 98762;
		find(0, map);
		cout << cnt << endl;
		cout << "#" << Tcnt++ << " " << brick << endl;
	}
}