#include <iostream>
#include <ctime>

using namespace std;

char map[22][22];

int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

int main(void) {
	srand((unsigned int)time(0));
	int T;

	freopen("input.txt", "r", stdin);
	cin >> T;
	int R, C;
	int Tcnt = 0;
	while (T--) {
		Tcnt++;
		cin >> R >> C;
		int m = 0;
		int mv = 0;
		int x = 1;
		int y = 1;
		int cnt = 0;
		bool exe = false;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				cin >> map[i][j];
				if (map[i][j] == '@') {
					exe = true;
				}
			}
		}

		if (Tcnt == 28) {
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					cout << map[i][j];
				}
				cout << endl;
			}
		}


		if (exe == false) {
			cout << "#" << Tcnt << " " << "NO" << endl;
			continue;
		}

		char temp = map[x][y];

		while (1) {
			if (temp == '^') {
				mv = 2;
			}
			else if (temp == 'v') {
				mv = 3;
			}
			else if (temp == '>') {
				mv = 0;
			}
			else if (temp == '<') {
				mv = 1;
			}
			else if (temp == '_') {
				if (m == 0) mv = 0;
				else mv = 1;
			}
			else if (temp == '|') {
				if (m == 0) mv = 3;
				else mv = 2;
			}
			else if (temp == '@') {

				cout << "#" << Tcnt << " " << "YES" << endl;
				break;
			}
			else if (temp > 47 && temp < 58) {
				m = temp - 48;
			}
			else if (temp == '+') {
				if (m == 15) m = 0;
				else m++;
			}
			else if (temp == '-') {
				if (m == 0) m = 15;
				else m--;
			}
			else if (temp == '?') {
				int temp = rand() % 4;
				mv = temp;
				cout<< "랜덤값 : " << mv;
			}
			if(Tcnt == 28 && cnt < 100) cout << cnt + 1 << " 번째  " << x << " , " << y << " 값 : " << map[x][y] << "  m은?" << m<< endl;
			int mx = x + dx[mv];
			int my = y + dy[mv];
			if (mx == R + 1) mx = 1;
			if (my == C + 1) my = 1;
			if (mx == 0) mx = R;
			if (my == 0) my = C;
			temp = map[mx][my];
			x = mx; 
			y = my;
			cnt++;
			if (cnt == 1000) {				cout<< "#" << Tcnt << " " << "NO" << endl; break; }
		}
	}
}