#include <iostream>

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
};
pos cctv[9];
int N, M;
int map[9][9];
int chk[9][9];
int dx[] = {0,1,0,-1 };
int dy[] = {1,0,-1,0 };
int cnt = 0;
int dir[9] = { 0 };
int result = 9999999;
void dfs(int n) {
	if (n == cnt) {
		for (int i = 0; i < cnt; i++) {
			int temp = dir[i];
			int x = cctv[i].x;
			int y = cctv[i].y;
			int n = cctv[i].n;
			int d[4] = {0};
			d[temp] = 1;
			if (n == 2) {
				d[(temp + 2) % 4] = 1;
			}
			else if(n == 3){
				d[(temp + 1) % 4] = 1;
			}
			else if (n == 4) {
				d[(temp + 1) % 4] = 1;
				d[(temp + 2) % 4] = 1;

			}
			else if (n == 5)
			{
				d[(temp + 1) % 4] = 1;
				d[(temp + 2) % 4] = 1;
				d[(temp + 3) % 4] = 1;
			}
			for (int j = 0; j < 4; j++) {
				if (d[j] == 0) continue;
				int num = 1;
				while (1) {
					int mx = x + dx[j] * num;
					int my = y + dy[j] * num;
					if (mx < 1 || my < 1 || mx >N || my> M) break;
					if (chk[mx][my] == 6) break;
					num++;
					if (chk[mx][my] != 0) continue;
					chk[mx][my] = 9;
				}

			}
		}
		int temp = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				//if (chk[i][j] == 9) cout << "# ";
				//else cout << chk[i][j] << " ";
				if (chk[i][j] == 0) temp++;
				chk[i][j] = map[i][j];
			}
			//cout << endl;
		}
		//cout << endl;
		if (result > temp) result = temp;
		return;
	}
	if (cctv[n].n == 5) {
		dfs(n + 1);
	}
	else {
		for (int i = 0; i < 4; i++) {
			dir[n] = i;
			dfs(n + 1);

		}
	}
}

int main(void) {

	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> map[i][j];
			chk[i][j] = map[i][j];
			if (map[i][j] > 0 && map[i][j] < 6) {
				cctv[cnt].x = i;
				cctv[cnt].y = j;
				cctv[cnt].n = map[i][j];
				cnt++;
			}
		}
	}

	dfs(0);
	cout << result << endl;

}