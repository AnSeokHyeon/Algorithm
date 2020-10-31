#include <iostream>

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
pos start;
int N, X;
int map[21][21];
int chk[21][21];
int cnt;
int mx, my, hgap;
double airx[21];
double airy[21];
d//void up(int a, int b, int n, int m) {
//	if (a < 1 || b < 1) return;
//	if (m == X) {
//		cout << "올라가는 경사로 완성" << endl;
//		cout << a << " " << b << endl;
//		chk[start.x][start.y] = true;
//		return;
//	}
//	if (n == 1) {
//		gap = map[a][b] - map[a - 1][b];
//		if (gap == 0) up(a - 1, b, n, m + 1);
//		else return;
//	}
//	else if (n == 2) {
//		gap = map[a][b] - map[a][b - 1];
//		if (gap == 0) up(a, b - 1, n, m + 1);
//		else return;
//	}
//};
//void down(int a, int b, int n, int m) {
//	cout << a << b << endl;
//	if (a > N || b > N) return;
//	if (m == X) {
//		cout << "내려가는  경사로 완성" << endl;
//		cout << a << " " << b << endl;
//		chk[start.x][start.y] = true;
//		return;
//	}
//	if (n == 1) {
//		gap = map[a][b] - map[a + 1][b];
//		if (gap == 0) down(a + 1, b, n, m + 1);
//		else return;
//	}
//	else if (n == 2) {
//		gap = map[a][b] - map[a][b + 1];
//		if (gap == 0) down(a, b + 1, n, m + 1);
//		else return;
//	}
//}
//void road(int a, int b) {
//
//	if (a == 1 && b == 1) {
//		for (int i = 1; i < N; i++) {
//			my = b + i;
//			if (my > N) continue;
//			hgap = map[a][my] - map[a][my - 1];
//			if (hgap == 0) continue;
//			if (hgap == 1) up(a, my - 1, 2, 0);
//			if (hgap == -1) down(a, my, 2, 0);
//		}
//		for (int i = 1; i < N; i++) {
//			mx = a + i;
//			if (mx > N) continue;
//			hgap = map[mx][b] - map[mx - 1][b];
//			if (hgap == 0)continue;
//			if (hgap == 1) up(mx - 1, b, 1, 0);
//			if (hgap == -1) down(mx, b, 1, 0);
//		}
//	}
//	else if (a == 1) {
//		for (int i = 1; i < N; i++) {
//			mx = a + i;
//			if (mx > N) continue;
//			hgap = map[mx][b] - map[mx - 1][b];
//			if (hgap == 0) continue;
//			if (hgap == 1) up(mx - 1, b, 1, 0);
//			if (hgap == -1) down(mx, b, 1, 0);
//		}
//	}
//
//	else if (b == 1) {
//		for (int i = 1; i < N; i++) {
//			my = b + i;
//			if (mx > N) continue;
//			hgap = map[a][my] - map[a][my - 1];
//			if (hgap == 0)continue;
//			if (hgap == 1) up(a, my - 1, 2, 0);
//			if (hgap == -1) down(a, my, 2, 0);
//		}
//	}
//
//
//}

bool up(double a[], int n, double gap, int m, int l) {
	cout << "저에서 고로" << endl;
	if (m == 0) {
		cout << "@@@@@경사로 생성 완료@@@@@" << endl;
		return true;
	}
	for (int i = n; i > 0; i--) {
		if (a[i] - a[i - 1] == 0) {
			a[i] = a[l] - gap;
			up(a, i - 1, gap, m - 1, l);
			return true;
		}
		else return false;
	}
}
bool down(double a[], int n, double gap, int m, int l) {
	
	cout << "고에서 저로" << endl;
	if (m == 0) { 
		cout << "@@@@@경사로 생성 완료@@@@@" << endl;
		return true;
	}
	for (int i = n; i < N; i++) {
		if (a[i] - a[i + 1] == 0) {
			a[i] = a[l] - gap;
			cout << "요때 " << a[i] << " gap은 " << gap << " m " << m << endl;
			down(a, i + 1, gap, m - 1, l);
			return true;
		}
		else {
			cout << "경사로 생성 실패" << endl;
			return false;
		}
	}
}

bool updown(double a[]) {
	cout << endl;
	cout << " 들어올때 지형" << endl;
	for (int i = 1; i <= N; i++) {
		cout << a[i] << " ";
	}
	double t = 0.5;
	cout << endl;
	for (int i = 1; i < N; i++) {

		int gap = a[i] - a[i + 1];
		
		if (gap == 0) continue;
		if (gap == 1) {

			bool result = down(a, i + 1, t, X, i);
			if (result) { 
				i = i + X; 
			}
			else {
				cout << "down 실패" << endl;
				return false; 
			}
		}
		if (gap == -1) {
			bool result = up(a, i, t, X, i+1);
			if (!result) {
				return false;
				cout << "up 실패" << endl;
			}
		}
		else break;
	}
	cout << "경사로 설치 후" << endl;
	for (int i = 1; i <= N; i++) {
		cout << a[i] << " ";
	}
	cout << endl;
	for (int i = 1; i <= N; i++) {
		int gap = a[i] - a[i + 1];
		if (gap > 1 || gap < -1) return false;
	}
}


int main(void) {

	int T;
	cin >> T;
	while (T--) {
		cin >> N >> X;
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				airx[j] = map[i][j];
				airy[j] = map[j][i];
			}
			updown(airx);
			updown(airy);
		}

		/*cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i > 1 && j > 1)continue;
				cout << "진입 : " << i << " " << j << endl;
				start.x = i;
				start.y = j;
				road(i, j);
			}
		}
		cout << " 확인 해보자 " << endl;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (chk[i][j]) {
					cout << i << " " << j << endl;
					cnt++;

				}
			}
		}
		cout << "총 경우의 수 : " << cnt << endl;*/
	}
}
