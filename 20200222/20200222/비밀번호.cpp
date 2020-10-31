#include <iostream>
#include <cmath>
#include <cstdio>

using namespace std;

int num[28];
int sec[28];
int box[7];
int turn;
int N, K;
int sum;
int cnt;

void key(int n) {
	if (n == turn) {
		return;
	}
	//cout << "현재 상태는  : " << n + 1 << " 번째  입니다." << endl;
	for (int i = 0; i < N; i++) {
		box[i % turn] = num[i];
		//cout << " i%turn 값은 무엇? " << i % turn << "현재 박스값 : " << box[i % turn] << endl;
		sum = 0;
		if (i % turn == turn - 1 && i > 0) {
			for (int j = 0; j < turn; j++) {
				//cout << "들어가기전 합 : " << sum << " 이때 박스값 : " << box[j] << endl;
				sum = sum + box[j] * pow(16, (turn - 1 - j));
			}
			for (int j = 0; j < N; j++) {
				if (sum == sec[j]) break;
				if (sec[j] == 0) {
					sec[j] = sum;
					cnt++;
					break;
				}
			}
		}
		//cout << sum << endl;
	}
	for (int i = N - 1; i > 0; i--) {
		int temp = num[i];
		num[i] = num[i - 1];
		num[i - 1] = temp;
	}
	//cout << n + 1 << "번째 @@@@@@@@" << endl;

	//for (int i = 0; i < N; i++) {
	//	printf("%x ", num[i]);
	//}
	//cout << endl;

	key(n + 1);
}

int main(void) {
	int T;
	//freopen("sample_input.txt", "r", stdin);
	cin >> T;
	int Tcnt = 0;
	while (T--) {
		cin >> N >> K;
		turn = N / 4;
		cnt = 0;
		Tcnt++;
		for (int i = 0; i < N; i++) {
			sec[i] = 0;
		}
		for (int i = 0; i < N; i++) {
			scanf("%1x", &num[i]);
		}

		//for (int i = 0; i < N; i++) {
		//	printf("%x ", num[i]);
		//}
		//cout << endl;

		key(0);
		//for (int i = 0; i < cnt; i++) {
		//	printf("%d ", sec[i]);
		//}
		//cout << endl;
		for (int i = 0; i < cnt; i++) {
			for (int j = i + 1; j < cnt; j++) {
				if (sec[i] < sec[j]) {
					int temp = sec[j];
					sec[j] = sec[i];
					sec[i] = temp;
				}
			}
		}

		//for (int i = 0; i < cnt; i++) {
		//	printf("%d ", sec[i]);
		//}
		//cout << endl;

		cout << "#" << Tcnt << " "  << sec[K - 1] << endl;
	}
}