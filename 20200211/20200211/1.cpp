#include <iostream>
#include <limits>

using namespace std;
int num[100];
int arr[100];
int cnt = 0;
int chk[100] = { 0 };
int N;
int math[4];
int mathN[100];
int minTotal = INT_MAX;
int maxTotal = INT_MIN;

void four() {
	int total = num[0];
	for (int i = 0; i < N - 1; i++) {
		if (arr[i] == 10) {
			total = total + num[i + 1];
		}
		else if (arr[i] == 20) {
			total = total - num[i + 1];
		}
		else if (arr[i] == 30) {
			total = total * num[i + 1];

		}
		else if (arr[i] == 40) {
			total = total / num[i + 1];
		}
	}
	if (total > maxTotal) maxTotal = total;
	if (total < minTotal) minTotal = total;

}

void ans(int y) {

	if (y == N - 1) {
		four();
		return;
	}

	for (int i = 0; i < N - 1; i++) {
		if (chk[i] == 0) {
			arr[y] = mathN[i];
			chk[i] = 1;
			ans(y + 1);
			chk[i] = 0;
		}
	}
}
int main(void) {
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> num[i];
	}
	for (int i = 0; i < 4; i++)
	{
		cin >> math[i];
	}
	for (int i = 0; i < N - 1; i++) {
		if (math[0] != 0) {
			mathN[i] = 10;
			math[0]--;
		}
		else if (math[1] != 0) {
			mathN[i] = 20;
			math[1]--;
		}
		else if (math[2] != 0) {
			mathN[i] = 30;
			math[2]--;
		}
		else if (math[3] != 0) {
			mathN[i] = 40;
			math[3]--;
		}
	}
	ans(0);
	cout << maxTotal << endl;
	cout << minTotal << endl;
}