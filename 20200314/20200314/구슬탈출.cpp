#include <iostream>
#include <queue>

using namespace std;

struct pos {
	int x;
	int y;
	pos() {
		this->x = 0;
		this->y = 0;
	}
};

pos red; 
pos hall;
pos blue;
char map[11][11];
int chk[11][11];
int dx[] = {1,-1,0,0 };
int dy[] = {0,0,1,-1 };
bool result = false;
int ans = 987654321;

int N, M;
void move(pos a, pos b, int d) {

	while (1) {
		cout << "µé¾î¿È " << endl;
		bool mva = false;
		bool mvb = false;

		int ax = a.x + dx[d];
		int ay = a.y + dy[d];

		if (ax < 1 || ay < 1 || ax >N || ay >M ) {
		
		}
		else {
			if (ax == b.x && ay == b.y) {

			}
			else if (map[ax][ay] == '#'){

			}
			else if (map[ax][ay] == '0'){
				ax = 0;
				ay = 0;
				result = true;
			} 
			else {
				a.x = ax;
				a.y = ay;
				mva = true;
			}

		}
		int bx = b.x + dx[d];
		int by = b.y + dy[d];


		if (bx < 1 || by < 1 || bx >N || by >M) {

		}
		else {
			if (bx == a.x && by == a.y) {

			}
			else if (map[bx][by] == '#') {

			}
			else if (map[bx][by] == '0') {
				bx = 0;
				by = 0;
				result = false;
			}
			else {
				b.x = bx;
				b.y = by;
				mvb = true;
			}

		}

		if (mva == false && mvb == false) break;
	}
	

	for (int j = 1; j <= N; j++) {
		for (int k = 1; k <= M; k++) {
			if (j == a.x && k == a.y) cout << "R";
			else if (j == b.x && k == b.y) cout << "B";
			else cout << map[j][k];
		}
		cout << endl;
	}
}


void dfs(int n, int m, pos a, pos b) {

	if (m > 10) return;
	if (result == true) {
		if (ans > m) ans = m;
		return;
	}

	for (int i = 0; i < 4; i++) {
		if (i == n) continue;

		move(a, b, i);
		for (int j = 1; j <= N; j++) {
			for (int k = 1; k <= M; k++) {
				if (j == a.x && k == a.y) cout << "R";
				else if (j == b.x && k == b.y) cout << "B";
				else cout << map[j][k];
			}
			cout << endl;
		}
		dfs(i, m + 1, a, b);
		a = a;
		b = b;
	}

}

int main(void) {
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> map[i][j];
			if (map[i][j] == 'O') {
				hall.x = i;
				hall.y = j;
			}
			if (map[i][j] == 'R') {
				red.x = i;
				red.y = j;
				map[i][j] = '.';
			}
			if (map[i][j] == 'B') {
				blue.x = i;
				blue.y = j;
				map[i][j] = '.';
			}
		}
	}
	dfs(-1, 0, red, blue);
	if (ans == 987654321) ans = -1;
	cout << ans << endl;

}