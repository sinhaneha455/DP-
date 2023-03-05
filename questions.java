////////////////////////////////LIS//////////////////////////////////

class Solution {
    public int lengthOfLIS(int[] nums) {
       int[] le = new int[nums.length];
       le[0] = nums[0];
        int len = 1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]>le[len-1]){
                le[len] = nums[i];
                len++;
            }
            else{
                int idx = binarySearch(le , 0 , len-1 , nums[i]);
                le[idx] = nums[i];
            }
        }
        
        return len;
    }
    
    public int binarySearch(int[] le , int si , int ei , int item){
        int low = si;
        int high = ei;
        while(low<=high){
            int mid = (low+high)/2;
            if(item>le[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        
        return low;
    }
}




class Solution {
    public int lengthOfLIS(int[] nums) {
        int n =nums.length;
        int ans = solve(nums , n);
        return ans;
    }
    
    public static int solve(int[] arr , int n ){
        int[] strg = new int[n];
        int maxans=0;
        for(int i=0;i<strg.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    max=Math.max(max,strg[j]);
                }
            }
            
            strg[i]=max+1;
            maxans= Math.max(maxans, strg[i]);
        }
        
        return maxans;
    }
}







///////////////////////////////////////////////////////////////////////////////////




//User function Template for Java

class Solution
{
	 
	 public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int dp[] = new int[n];
	    
	    for(int i=0 ; i<n ; i++){
	        
	        dp[i] = arr[i];
	        
	        for(int j=0 ; j<i ; j++){
	            if(arr[i] > arr[j])
	                dp[i] = Math.max(dp[i] , dp[j] + arr[i]);
	        }
	    }
	    int ans = 0;
	    for(int i=0 ; i<n ; i++){
	        ans = Math.max(ans , dp[i]);
	    }
	    
	      return ans;
	}  
}




///////////////////////////////////////////////////////////////////////////////////////


class Solution
{
    public int LongestBitonicSequence(int[] nums)
    
    {
        int n =nums.length;
       int[] lis= solve(nums,n);
       int[] lds = solve2(nums,n);
        int[] res = new int[n];
        for(int i=0;i<nums.length;i++){
            res[i] = lis[i]+(lds[i]-1);
        }
        int maxans = Integer.MIN_VALUE;
        
       for(int k=0;k<res.length;k++){
           maxans = Math.max(maxans , res[k]);
       }
       return maxans;
       
    }
    
     public static int[] solve(int[] arr , int n ){
        int[] strg = new int[n];
        int maxans=0;
        for(int i=0;i<strg.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    max=Math.max(max,strg[j]);
                }
            }
            
            strg[i]=max+1;
           
        }
        // for(int k=0;k<strg.length;k++){
        // System.out.print(strg[k]+" ");
        // }
        
        return strg;
    }
    
    public static int[] solve2(int[] arr , int n){
        int[] strg = new int[n];
        for(int i=n-1;i>=0;i--){
            int max=0;
            for(int j=n-1;j>i;j--){
                if(arr[j]<arr[i]){
                    max= Math.max(max , strg[j]);
                }
                
            }
            
            strg[i]= max+1;
        }
        return strg;
    }
}










//////////////////////////////////////////////////////////////////////////////////////


class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int length= nums.length;
        int canbeans=LongestBitonicSequence(nums);
        int ans = length-canbeans;
        return ans;
    }
    public  static int LongestBitonicSequence(int[] nums)
     
    {
        int n =nums.length;
       int[] lis= solve(nums,n);
       int[] lds = solve2(nums,n);
        int[] res = new int[n];
        for(int i=0;i<nums.length;i++){
            if(lis[i]>1&&lds[i]>1)
            res[i] = lis[i]+(lds[i]-1);
        }
        int maxans = Integer.MIN_VALUE;
        
       for(int k=0;k<res.length;k++){
        //   System.out.print(res[k]+" ");
          maxans = Math.max(maxans , res[k]);
       }
       return maxans;
       
    }
    public static int[] solve2(int[] arr , int n){
        int[] strg = new int[n];
        for(int i=n-1;i>=0;i--){
            int max=0;
            for(int j=n-1;j>i;j--){
                if(arr[j]<arr[i]){
                    max= Math.max(max , strg[j]);
                }
                
            }
            
            strg[i]= max+1;
        }
        return strg;
    }
      public static int[] solve(int[] arr , int n ){
        int[] strg = new int[n];
        int maxans=0;
        for(int i=0;i<strg.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    max=Math.max(max,strg[j]);
                }
            }
            
            strg[i]=max+1;
           
        }
        // for(int k=0;k<strg.length;k++){
        // System.out.print(strg[k]+" ");
        // }
        
        return strg;
    }
}







///////////////////////////////////////////////////////////////////////////////////


class Solution {
    public int longestMountain(int[] arr) {
        int ans = LongestBitonicSequence(arr);
        return ans;
    }
     public static int LongestBitonicSequence(int[] nums)
     
    {
        int n =nums.length;
       int[] lis= solve(nums,n);
         // for(int l=0;l<n;l++){
         //     System.out.print(lis[l]+" ");
         // }
         
       int[] lds = solve2(nums,n);
//          System.out.println("ohhhooo");
//           for(int l=0;l<n;l++){
//              System.out.print(lds[l]+" ");
//          }
        
        int[] res = new int[n];
        for(int i=0;i<nums.length;i++){
            if(lis[i]>1&&lds[i]>1)
            res[i] = lis[i]+(lds[i]-1);
        } 
         //  System.out.println("ohhhooo");
         // for(int l=0;l<n;l++){
         //     System.out.print(res[l]+" ");
         // }
         
        int maxans = Integer.MIN_VALUE;
        
       for(int k=0;k<res.length;k++){
        //   System.out.print(res[k]+" ");
          maxans = Math.max(maxans , res[k]);
       }
       return maxans;
       
    }
    public static int[] solve2(int[] arr , int n){
        int[] strg = new int[n];
      Arrays.fill(strg,1);
        for(int i=n-2;i>=0;i--){
            int j=i+1;
            if(arr[i]>arr[j]){
                strg[i]= strg[j]+1;
            }
        }
        return strg;
    }
      public static int[] solve(int[] arr , int n ){
        int[] strg = new int[n];
          Arrays.fill(strg,1);
        for(int i=1;i<n;i++){
            int j=i-1;
            if(arr[j]<arr[i]){
                strg[i]= strg[j]+1;
            }
        }
        return strg;
    }
}

class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length < 3){
            return 0;
        }
        return solve(arr);
    }

    private int solve(int[] arr){
        int start = -1;
        int end = -1;
        int ans = 0;
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i+1] > arr[i]){
                if(end != -1){
                    start = -1;
                    end = -1;
                }
                if(start == -1){
                    start = i;
                }
            }
            else{
                if(arr[i+1]<arr[i]){
                    if(start !=-1){
                        end = i+1;
                    }
                    if(start != -1 && end != -1){
                        ans = Math.max(ans , end - start+1);
                    }
                    
                }
                else{
                        start = -1;
                        end = -1;
                }
            }
        }

        if(start != -1 && end != -1){
            ans = Math.max(ans , end-start+1);
        }

        return ans;
    }
}




//////////////////////////////////////////////////////////////////////////////////

class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int max = 1;
        int[] count = new int[n];
        int[] length = new int[n];

        for(int i=0;i<n;i++){
            count[i] = 1;
            length[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    if(length[j]+1 > length[i]){
                        length[i] = length[j]+1;
                        count[i] = count[j];
                    }
                    if(length[j]+1 == length[i]){
                        count[i] = count[i]+count[j];
                    }
                }
                
            }
            max = Math.max(max , length[i]);

        }

        for(int i=0;i<n;i++){
            if(length[i] == max){
                ans+=count[i];
            }
        }

        return ans;
    }
}





//////////////////////////////////////////////////////////////////////////////////////////


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
         if(envelopes == null || envelopes.length == 0 
       || envelopes[0] == null || envelopes[0].length != 2)
        return 0;
    Arrays.sort(envelopes, new Comparator<int[]>(){
        public int compare(int[] arr1, int[] arr2){
           
               if(arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
       } 
    });
        int maxans =0;
        int n =envelopes.length;
        int[] strg = new int[n];
        for(int i=0;i<strg.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                // 0 - width 1-height
                if(envelopes[j][1]<envelopes[i][1]){
                    max = Math.max(max , strg[j]);
                }
            }
            strg[i]= max+1;
            maxans = Math.max(maxans , strg[i]);
        }
        
        return maxans;
        
    }
}





/////////////////////////////////////////////////////////////////////////////////////////

// https://leetcode.com/problems/longest-string-chain/description/


class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->a.length() - b.length());
       

        int[] strg = new int[words.length];
        int maxAns = 0;
        for(int i=0;i<words.length;i++){
            strg[i] = 1;
            for(int j=0;j<i;j++){
                if(compare(words[i] , words[j])){
                    strg[i] = Math.max(strg[i] , strg[j]+1);
                }

            }
            
            maxAns = Math.max(maxAns , strg[i]);
        }


        return maxAns;

    }

    private boolean compare(String s1, String s2){
    if(s1.length() != s2.length() + 1) return false;
    
    int first = 0;
    int second = 0;
    
    while(first < s1.length()){
        if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
            first ++;
            second ++;
        }
        else first ++;
    }
    if(first == s1.length() && second == s2.length()) return true;
    else return false; 
}



}