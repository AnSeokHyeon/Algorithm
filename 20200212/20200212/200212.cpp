#include <iostream>
#include <cstdio>

using namespace std;

struct pos {
	int x;
	int y;

	pos() {
		this->x = 0;
		this->y = 0;
	}
	pos(int x, int y, int ck) {
		this->x = x;
		this->y = y;
	}
};

pos start;
int map[21][21];
int chk[21][21];
int dessert[102];
int road[5000];
int dx[] = { 1,1,-1,-1 };
int dy[] = { 1,-1,-1,1 };
int N, maxR;
int T;

void fuc(int x, int y, int eat) {
	dessert[map[x][y]] = true;
	chk[x][y] = true;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < N; j++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			int meat = eat + 1;
			int md = map[mx][my];
			//if (T == 9) cout << "ÁÂÇ¥ : " << mx << my << meat << endl;
			if (mx > N || my > N) continue; 
			if (mx < 1 || my < 1) continue; 
			if (mx == start.x && my == start.y && eat > 2) {
				if (maxR < eat) maxR = eat;
				continue;
			}
			if (chk[mx][my]) continue;
			if (dessert[md]) continue;

			dessert[md] = true;
			chk[mx][my] = true; 
			x = mx;
			y = my;
			eat = meat;
		}
	}
}
int main(void) {
	freopen("input.txt", "r", stdin);
	cin >> T;
	while (T--) {
		cin >> N;
		maxR = -1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int a = 1; a <= N; a++) {
					for (int b = 1; b <= N; b++) {
						chk[a][b] = false;
					}
				}
				for (int a = 0; a < 102; a++) {
					dessert[a] = false;
				}
				start.x = i;
				start.y = j;
				fuc(i, j, 1);
			}
		}
		cout << maxR << "\n";
	}
}