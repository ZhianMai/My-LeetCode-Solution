/**
* Problem #887
*/
class SuperEggDrop {
public int superEggDrop(int K, int N) {
    int[][] memo =  new int[K+1][N+1];
    return dp(K,N,memo);
  }
  int dp(int k,int n,int[][] memo){
    if(n==0) return 0;
    if(k==1) return n;
    if(memo[k][n]!=0) return memo[k][n];

    int ans=n;
    int lo=1;
    int hi=n;

    while(lo<=hi){
      int mid=(hi-lo)/2+lo;

      int left=dp(k-1,mid-1,memo); //if the egg brokes at ith floor
      int right=dp(k,n-mid,memo); //the egg not brokes at ith floot

      ans=Math.min(ans,Math.max(left,right)+1);

      //here is the trick
      //when we find the answer, all the floors under it, the eggs will not be broken.
      //when the floors upper to it, the eggs will be broken. 
      //So, we need to check each floor, they are same steps.
      if(left==right) break;
      else if(left<right) lo=mid+1;
      else hi=mid-1;
    }

    memo[k][n]=ans;

    return ans;
  }
}