#include <iostream>
#include <queue>

using namespace std;

struct pos {
	int x;
	int y;
	int p;
	pos(int x, int y, int p) {
		this->x = x;
		this->y = y;
		this->p = p;
	}
};

int map[16][13];
int c[16][13] = {};
int N, W, H;
int result = 987654321;

int dx[] = { 0,0,1,-1 };
int dy[] = { 1,-1,0,0 };
int shot[5];


void breaking() {
	queue<pos> q;

	for (int i = 0; i < N; i++) {
		int temp = shot[i];
		for (int j = 1; j <= H; j++) {
			if (c[j][temp] == 0) continue;
			q.push(pos(j, temp, c[j][temp]));
			c[j][temp] = 0;
			break;
		}
		while (!q.empty()) {
			pos f = q.front();
			q.pop();
			int x = f.x;
			int y = f.y;
			int p = f.p;
			for (int j = 1; j < p; j++) {
				for (int k = 0; k < 4; k++) {
					int mx = x + dx[k]*j;
					int my = y + dy[k]*j;
					int mp = c[mx][my];

					if (mx < 1 || my < 1 || mx > H || my > W) continue;
					if (c[mx][my] == 0) continue;
					c[mx][my] = 0;
					q.push(pos(mx, my, mp));
				}
			}
		}

		for (int k = 1; k <= W; k++) {
			for (int j = H-1; j > 0; j--) {
				if (c[j][k] == 0) continue;

				for (int l = H; l> j; l--) {
					if (c[l][k] == 0) {
						c[l][k] = c[j][k];
						c[j][k] = 0;
						break;
					}
				}
			}
		}
	}
	int tempcnt = 0;
	for (int i = 1; i <= H; i++) {
		for (int j = 1; j <= W; j++) {
			if (c[i][j] > 0) tempcnt++;
			c[i][j] = map[i][j];
		}
	}
	if (result > tempcnt) result = tempcnt;
}

void brick(int n) {
	if (n == N) {
		breaking();
		return;
	}

	for (int i = 1; i <= W; i++) {
		
		shot[n] = i;
		brick(n + 1);

	}
}

int main(void) {
	int T;
	cin >> T;
	int Tcnt = 1;
	while (T--) {
		cin >> N >> W >> H;
		result = 987654321;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				cin >> map[i][j];
				c[i][j] = map[i][j];
			}
		}
		brick(0);
		
		cout << "#" << Tcnt++ << " " << result << endl;;
	}
}