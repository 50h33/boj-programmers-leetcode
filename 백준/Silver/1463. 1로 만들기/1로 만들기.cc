#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int n;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
	int dp[n+4];
	fill(dp, dp + n + 4, INF);
	dp[1] = 0;
	for (int i = 2; i <= n; i++) {
		if (i % 3 == 0) dp[i] = min(dp[i], dp[i/3] + 1);
		if (i % 2 == 0) dp[i] = min(dp[i], dp[i/2] + 1);
		dp[i] = min(dp[i], dp[i-1] + 1);
	}
	cout << dp[n] << "\n";
}