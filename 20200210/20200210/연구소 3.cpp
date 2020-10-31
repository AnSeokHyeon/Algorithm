#include <iostream>
#include <queue>

using namespace std;
struct pos {
	int x;
	int y;
	int time;
	pos() {
		this->x = 0;
		this->y = 0;
		this->time = 0;
	}

	pos(int x, int y, int time) {

		this->x = x;
		this->y = y;
		this->time = time;
	}
};


pos offVirusPos[10];
pos onVirusPos[3];
int virusN;
int map[51][51];
int chk[51][51];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int minVirus[1000000];
int N, M, bfsn = 0;
int cnt = -1;
int minSec = 10000;

void bfs() {

	cnt++;

	for (int a = 1; a <= N; a++) {
		for (int b = 1; b <= N; b++) {
			if (map[a][b] == 1) chk[a][b] = 1;
			else chk[a][b] = 0;
		}
	}
	queue<pos> q;

	for (int i = 0; i < virusN; i++) {
		int x = offVirusPos[i].x;
		int y = offVirusPos[i].y;
		chk[x][y] = -1;
	}

	for (int i = 0; i < M; i++) {
		int x = onVirusPos[i].x;
		int y = onVirusPos[i].y;
		chk[x][y] = 0;
		q.push(pos(x, y, 0));
	}
	int temp = 0;
	while (!q.empty()) {
		pos f = q.front();
		q.pop();
		int x = f.x;
		int y = f.y;
		int time = f.time;
		if (time > temp) temp = time;
			if(cnt==143){
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j]==2 && chk[i][j]==0)  cout << 0;
					else if(map[i][j]==1 && chk[i][j]==1)  cout << "-";
					else if(chk[i][j] == -1) cout << "*";
					else cout << chk[i][j];
				}
				cout << endl;
			}
			cout << x << ", " << y << ", " << time << endl;
			cout << "@@@@@@@@@@@@@@@@@@@@@@@@@@@" << endl;
			cout << endl;
			}
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			int mtime = time + 1;
			//cout << x<< " " << y << endl;
			if (mx > N || my > N) continue;
			if (mx < 1 || my < 1) continue;
			if (chk[mx][my] > 0) continue;
			if (chk[mx][my] == -1) {
				q.push(pos(mx, my, mtime));
				chk[mx][my] = mtime;
			}
			if (map[mx][my] == 0) {
				q.push(pos(mx, my, mtime));
				chk[mx][my] = mtime;
			}
		}
	}

	minVirus[cnt] = temp;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (chk[i][j] == 0 && map[i][j] == 0) {
				minVirus[cnt] = -1;
				break;
			}
		}
	}

	cout << cnt + 1 << "¹øÂ° bfs :  " << minVirus[cnt] << endl;
}
void position(int x, int y) {
	if (y == M) {
		bfs();
		return;
	}
	for (int i = x; i < virusN; i++) {
		onVirusPos[y].x = offVirusPos[i].x;
		onVirusPos[y].y = offVirusPos[i].y;
		position(i + 1, y + 1);
	}
}

int main(void) {
	cin >> N >> M;
	virusN = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			int num;
			cin >> num;
			map[i][j] = num;
			if (num == 2) {
				offVirusPos[virusN].x = i;
				offVirusPos[virusN].y = j;
				virusN++;
			}
		}
	}
	position(0, 0);
	for (int i = 0; i < cnt; i++) {
		if (minVirus[i] > -1 && minSec > minVirus[i]) minSec = minVirus[i];
		cout << i << " " << minSec << endl;
	}
	if (minSec == 10000) cout << -1;
	else cout << minSec << endl;
}