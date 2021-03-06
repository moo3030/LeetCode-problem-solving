package Medium.BinarySearch;

/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
*/

public class Search_a_2D_Matrix {

    public static boolean isWithinArray(int[] arr, int target){
        if(arr.length == 1)
            return arr[0] == target;
        return arr[0] <= target && arr[arr.length-1] >= target;
    }

    public static boolean search(int[] arr, int target){
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == target)
                return true;
            if(arr[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(isWithinArray(matrix[mid], target)){
                if(search(matrix[mid], target))
                    return true;
            }
            if(matrix[mid][0] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(m, 0));
    }
}
