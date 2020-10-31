#include <iostream>

using namespace std;

struct pos {
	int x;
	int y;
	int d;
	int n;
	pos() {
		this->x = 0;
		this->y = 0;
		this->d = 0;
		this->n = 0;
	}
};

pos h[11];

int dx[] = {0,-1,0,1 };
int dy[] = {1,0,-1,0};
int map[13][13];
int chk[13][13];
bool mv[11];

int main(void) {
	int N, K;
	cin >> N >> K;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
		}
	}
	for (int i = 0; i < K; i++) {
		int x, y, d;
		cin >> x >> y >> d;
		if (d == 1) d = 0;
		else if (d == 2) d = 2;
		else if (d == 3) d = 1;
		else d = 3;
		h[i + 1].x = x;
		h[i + 1].y = y;
		h[i + 1].d = d;
		h[i + 1].n = 1;
		chk[x][y]++;
	}
	int T= 1 ;
	int result = -1;

	while (T<1001) {
		for (int i = 1; i <= K; i++) {
			int x = h[i].x;
			int y = h[i].y;
			int d = h[i].d;
			int n = h[i].n;
			int mx = x + dx[d];
			int my = y + dy[d];
			int cnt = 0;
			int gap = n - 1;
			for (int j = 1; j <= K; j++) {
				if (x == h[j].x && y == h[j].y && h[j].n >= n) {
					//cout << j << " 번째 말 : " << h[j].x << " , " << h[j].y << " / " << h[j].n << " # " << h[j].d << endl;
					mv[j] = true;
					cnt++;
				}
			}

			if (map[mx][my] == 2 || mx < 1 || my < 1 || mx > N || my >N) {
				d = (d + 2) % 4;
				h[i].d = d;

				mx = x + dx[d];
				my = y + dy[d];

			}

			if (map[mx][my] == 0 && !(mx < 1 || my < 1 || mx > N || my >N)) {
				for (int j = 1; j <= K; j++) {
					if (mv[j] == true) {
						h[j].n = h[j].n - gap;
						h[j].n = h[j].n + chk[mx][my];
						h[j].x = mx;
						h[j].y = my;
					}
				}
				chk[x][y] -= cnt;
				chk[mx][my] += cnt;
			}

			else if (map[mx][my] == 1) {
				for (int j = 1; j <= K; j++) {
					if (mv[j] == true) {
						h[j].n = h[j].n - gap;
						h[j].n = cnt + 1 - h[j].n + chk[mx][my];
						h[j].x = mx;
						h[j].y = my;
					}
				}
				chk[x][y] -= cnt;
				chk[mx][my] += cnt;
			}
			for (int j = 1; j <= K; j++) {
				//cout << j << " 번째 말 : " << h[j].x << " , " << h[j].y << " / " << h[j].n << " # " << h[j].d << endl;
				mv[j] = false;
			}

			if (chk[mx][my] > 3) {
				result = T;
				break;
			}

		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cout << chk[i][j] << " ";
			}
			cout << endl;
		}
		T++;
		if (result != -1) break;
	}
	cout << result << endl;
}