#include <iostream>
#include <queue>

using namespace std;
struct pos {
	int x;
	int y;
	pos(int x, int y) {
		this->x = x;
		this->y = y;
	}
};

int R, C;
int map[101][101];
int chk[101][101];
queue<pos> q;
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int dis;
int inf[101];
void down(int n) {
	//cout << " 내려가기 들어옴 " << endl;
	int mv = 987654321;
	for (int j = 1; j <= C; j++) {
		int temp = 999999;
		for (int i = R; i > 0; i--) {
			if (map[i][j] != n) continue;
			temp = 0;
			inf[j] = 1;
			for (int k = i+1; k <= R; k++) {
				if (map[k][j] == 0) temp++;
				else break;
			}
			break;
		}
		if (mv > temp) mv = temp;
	}
	for (int j = 1; j <= C; j++) {
		if (inf[j] == 0) continue;
		for (int i = R; i > 0; i--) {
			if (map[i][j] == n) {
				map[i+ mv][j] = n;
				map[i][j] = 0;
			}
		}
	}

}

bool check(int n) {
	bool result = false;
	while (!q.empty()){
		pos f = q.front();
		q.pop();
		int x = f.x;
		if (x == R) result = true;
		int y = f.y;

		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx > R || my > C || mx < 1 || my < 1) continue;
			if (map[mx][my] != 1) continue;
			q.push(pos(mx, my));
			map[mx][my] = n;
		}
	}
	return result;
}

void attack(int n, int d) {
	if (d % 2 == 1) {
		for (int i = 1; i <= C; i++) {
			if (map[R - n + 1][i] == 0) continue;
			map[R - n + 1][i] = 0;
			break;
		}
	}
	else {
		for (int i =C; i >0; i--) {
			if (map[R - n + 1][i] == 0) continue;
			map[R - n + 1][i] = 0;
			break;
		}
	}
	int cnt = 2;
	bool bk = true;
	for (int i = 1; i <= R; i++) {
		for (int j = 1; j <= C; j++) {
			if (map[i][j] != 1) continue;
			q.push(pos(i, j));
			map[i][j] = cnt;
			bool result = check(cnt);
			if (result == false) { 
				down(cnt); 
				bk = false;
				break;
			}
			cnt++;
		}
		if (bk == false) break;
	}
}
int main(void) {

	cin >> R >> C;
	for (int i = 1; i <= R; i++) {
		for (int j = 1; j <= C; j++) {
			char temp;
			cin >> temp;
			if (temp == '.') map[i][j] = 0;
			else map[i][j] = 1;
		}
	}
	int T, Tcnt = 1;
	cin >> T;
	while (T--) {
		int n;
		cin >> n;
		dis = 99999;
		attack(n, Tcnt);

		//cout << Tcnt << "차 결과 @@@@@@@@@@@@2" << endl;

		//for (int i = 1; i <= R; i++) {
		//	for (int j = 1; j <= C; j++) {
		//		cout << map[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << endl;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] > 0) map[i][j] = 1;
			}
		}
		for (int i = 0; i <= C; i++) {
			inf[i] == 0;
		}
		Tcnt++;
	}
	for (int i = 1; i <= R; i++) {
		for (int j = 1; j <= C; j++) {
			if (map[i][j] == 0) cout << ".";
			else cout << "x";
		}
		cout << endl;
	}
}