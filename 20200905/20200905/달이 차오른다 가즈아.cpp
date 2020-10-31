#include <iostream>
#include <queue>
using namespace std;

struct pos {
	int x;
	int y;
	int n;
	int t;

	pos() {
		this->x = 0;
		this->y = 0;
		this->n = 0;
		this->t = 0;
	}
	pos(int x, int y, int n, int t) {
		this->x = x;
		this->y = y;
		this->n = n;
		this->t = t;
	}
};
pos key[6];
queue <pos> q;
char map[51][51];
int chk[51][51];
int door[6];
int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};

int main(void) {

	int N, M;
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> map[i][j];
			if (map[i][j] == '0') {
				q.push(pos(i, j, 0, 1));
				chk[i][j] = 1;
			}
			else if (map[i][j] >= 'A' && map[i][j] <= 'F') {
				int temp = map[i][j] - 'A';
				door[temp] = 1;
			}
		}
	}
	bool result = false;
	int num = 0;
	while (!q.empty()) {
		pos f = q.front();
		int x = f.x;
		int y = f.y;
		int n = f.n;
		int t = f.t;

		if (map[x][y] == '1') {
			result = true;
			num = n;
			break;
		}

		q.pop();
		cout << x << " , "<< y<<" / " << n << " : " << t << endl;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				cout << chk[i][j] << " ";
			}
			cout << endl;
		}
		for (int i = 0; i < 4; i++)
		{
			int mx = x + dx[i];
			int my = y + dy[i];
			int mn = n + 1;
			if (mx > N || my > M || mx < 1 || my < 1) continue;
			if (map[mx][my] == '#') continue;
			if (chk[mx][my] == t) continue;
			if (map[mx][my] >= 'A' && map[mx][my] <= 'F') {
				int temp = map[mx][my] - 'A';
				if (key[temp].n == 1 && t >= chk[key[temp].x][key[temp].y]) {
					map[mx][my] = '.';
					t++;
				}
				else {
					continue;
				}
			}
			if (map[mx][my] >= 'a' && map[mx][my] <= 'f') {
				int temp = map[mx][my] - 'a';
				key[temp].n = 1;
				key[temp].x = mx;
				key[temp].y = my;
				map[mx][my] = '.';

				q.push(pos(mx, my, mn, t+1));
				chk[mx][my] = t+1;
			}
			else{

				q.push(pos(mx, my, mn, t));
				chk[mx][my] = t;
			}
		}
		if (result == true) break;
	}
	
	
	if (result == false) num = -1;
	cout << num << endl;
	
}