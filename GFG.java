// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] t;
    static int matrixMultiplication(int N, int arr[])
    {
        t = new int[N][N];
        for(int i=0;i<N;i++)
            for(int j =0;j<N;j++)
                t[i][j]=-1;
        return solve(arr,0,N-1);
    }
    
    static int solve(int[] arr, int beg, int end){
        if(t[beg][end]!=-1)
            return t[beg][end];
        if(end==beg+1)  
            return 0;
        int minValue=Integer.MAX_VALUE;
        for(int k =beg+1;k<end;k++){
            int lValue=solve(arr,beg,k);
            int rValue=solve(arr,k,end);
            int tempAns = arr[beg]*arr[k]*arr[end]+lValue+rValue;
            if(tempAns<minValue)
                minValue=tempAns;
        }
        t[beg][end]=minValue;
        return minValue;
    }
}
