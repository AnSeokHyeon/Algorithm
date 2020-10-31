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

	pos(int x, int y) {

		this->x = x;
		this->y = y;
	}
};
pos offVirusPos[10];
pos onVirusPos[3];
int virusN;
int map[51][51];
int chk[51][51];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int minVirus = 3000;
int N, M;

void bfs() {
	queue<pos> q;
	queue<int> q2;
	for (int i = 0; i < virusN; i++) {
		int x = offVirusPos[i].x;
		int y = offVirusPos[i].y;
		chk[x][y] = 1;
	}
	for (int i = 0; i < M; i++) {
		int x = onVirusPos[i].x;
		int y = onVirusPos[i].y;
		q.push(pos(x, y));
		q2.push(0);
	}
	int temp = 0;
	while (!q.empty()) {
		pos f = q.front();
		int x = f.x;
		int y = f.y;
		int n = q2.front(); 
		temp = n;
		q2.pop();
		q.pop();
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			int mn = n + 1;
			//cout << x<< " " << y << endl;
			if (mx > N || my > N) continue;
			if (mx < 1 || my < 1) continue;
			if (chk[mx][my] == 1) continue;
			if (map[mx][my] == 0) {
				q.push(pos(mx, my));
				chk[mx][my] = 1;
				q2.push(mn);
			}
		}
	}
	if (minVirus > temp) minVirus = temp;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (chk[i][j] == 0 && map[i][j] == 0) {
				minVirus = -1;
				break;
			}
			chk[i][j] = 0;
		}
	}
	cout<<"bfs :  " << minVirus << endl;

}

void position(int x, int y) {
	if (y == M) {
		bfs();
		cout << " ?? " << endl;
		return;
	}
	for (int i = x; i < virusN; i++) {
			onVirusPos[y].x = offVirusPos[x].x;
			onVirusPos[y].y = offVirusPos[x].y;
			position(i+1, y + 1);
	}
}

int main(void) {
	cin >> N >> M;
	virusN = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N;j++) {
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
	cout << minVirus;
}