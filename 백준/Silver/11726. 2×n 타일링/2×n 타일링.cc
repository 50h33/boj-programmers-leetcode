#include <bits/stdc++.h>
using namespace std;
int n, dp[1004];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i-1] + dp[i-2]) % 10007;
    }

    cout << dp[n] % 10007 << "\n";
}