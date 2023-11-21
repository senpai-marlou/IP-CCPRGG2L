
import java.util.Arrays;


public class twoDArrays {
    public static void prob1(){
/*Write a Java program that initializes a 2D array of integers with some values and
then finds the sum of all the values in the array*/       
   int[][] arr = {
       {1, 2, 3, 4},
       {5, 6, 7, 8},
       {9, 10}
   };
    int sum = 0;
        for(int i = 0; i<arr.length; i++){
         for(int j = 0; j<arr[i].length; j++){   
             sum += arr[i][j];
         }
        }
              System.out.println("Sum of the 2D array: " + sum);
    }
     public static void prob2(){
/* Write a Java program that initializes a 2D array of integers with some values and
then finds the maximum value in the array. */        
     int[][] arr = {
       {12, 23, 34, 4},
       {5, 67, 17, 80},
       {92, 10}
   };
     // Finds the maximum value in the array
       int max = arr[0][0];
    for(int i = 0; i<arr.length; i++){   
       for(int j = 0; j<arr[i].length; j++){
           if(arr[i][j]> max){
               max = arr[i][j];
           }
         }
       }   
      System.out.println("Maximum value in the array: " + max);
    }
    public static void prob3(){
/*Write a Java program that initializes two 2D arrays of integers with some values
and then finds the product of the two arrays.*/        
      // Create the first 2D array of integers with 3 rows and 4 columns
        int[][] arr1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        // Create the second 2D array of integers with 4 rows and 3 columns
        int[][] arr2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        // Create a new 2D array to store the product of the two arrays
        int[][] product = new int[arr1.length][arr2[0].length];

        // Find the product of the two arrays
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    product[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        // Print the product of the two arrays
        System.out.println("Product of the two arrays:");
        for (int i = 0; i < product.length; i++) {
            for (int j = 0; j < product[i].length; j++) {
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    public static void prob4(){
/*Write a Java program that initializes a 2D array of integers with some values and
then sorts each row of the array in ascending order*/        
      int[][] arr = {
                {30, 10, 20},
                {42, 50, 65},
                {75, 18, 59},
                {200, 117, 122}
        };
         // Sort each row of the array in ascending order
        for (int i = 0; i < arr.length; i++) {
            Arrays.sort(arr[i]);
        }

        // Print the sorted 2D array
        System.out.println("Sorted 2D array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
      
    }
     public static void prob5(){
/* Write a Java program that initializes a 2D array of integers with some values and
then finds the transpose of the array. */         
        // Create the 2D array of integers with 3 rows and 4 columns
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        // Create a new 2D array to hold the transposed values
        int[][] transposedArr = new int[arr[0].length][arr.length];

        // Transpose the array by swapping rows and columns
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                transposedArr[j][i] = arr[i][j];
            }
        }

        // Print the original and transposed arrays
        System.out.println("Original 2D array:");
        print2DArray(arr);

        System.out.println("Transposed 2D array:");
        print2DArray(transposedArr);
    }

    // A helper method to print a 2D array
    private static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
      
     }
    
    public static void main(String[] args) {
         prob1();
         prob2();
         prob3();
         prob4();
         prob5();

    }
}
