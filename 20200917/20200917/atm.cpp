#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int money[1000];
bool chk[1000];
int t[1000];
int N;
int result = 999999;

void atm(int n) {
	if (n == N) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			cout << t[i] << " ";
			sum = sum + money[t[i]] * (N - i);
		}
		if (result > sum) result = sum;
		cout<< " sum : " << sum << endl;
		return;
	}
	for (int i = 0; i < N; i++) {
		if (chk[i] == true) continue;
		chk[i] = true;
		t[n] = i;
		atm(n + 1);
		chk[i] = false;

	}
}

int main(void) {
	cin >> N;
	vector<long long> cash;
	for (int i = 0; i < N; i++) {
		cin >> money[i];
		cash.push_back(money[i]);
	}
	sort(cash.begin(), cash.end());
	long long ans = 0;
		long long temp = 0;
		for (int i = 0; i < cash.size(); i++) {
			ans = ans + cash[i] * (N - i);
		}
	

	cout << ans << endl;
}