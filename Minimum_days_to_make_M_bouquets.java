package BinarySearchProblems.BinarySearch6;
public class Minimum_days_to_make_M_bouquets {
    public static boolean possible(int arr[] , int day , int m , int k){
        int n = arr.length;  //size of the array
        int cnt = 0;
        int numOfB = 0; //count the num of array
        for(int i = 0 ; i < n ;i++){
            if(arr[i] <= day){
                cnt++;
            }
            else{
                numOfB += (cnt / k);
                cnt = 0;
            }
        }numOfB += (cnt / k);
        return numOfB >= m;
    }
    public static int garden(int arr[] , int k , int m){
        long val = (long) m * k;
        int n = arr.length; // Size of the array
        if (val > n) return -1; // Impossible case as days are less than product of bouquets & adjacent flowers
        //find min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            min = Math.min(min , arr[i]);
            max = Math.max(max , arr[i]);
        }
        //binary search
        int low = min ; 
        int high = max;
        while( low <= high ){
            int mid  =( low + high )/2;
            if(possible(arr, mid,m, k)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int ans = garden(arr, k, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }    
}
