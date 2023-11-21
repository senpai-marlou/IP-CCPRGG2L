
public class Array {
    
    public static void Prob1() {
/*Write a Java program that initializes an array of integers with some values and
then finds the sum of all the values in the array*/
	int[] num1 ={12,23,24,13,40};
    int sum = 0;
   for(int i = 0; i<num1.length; i++ ){        
      sum = sum + num1[i];
   }
     System.out.println("Sum of the arrays: "+ sum);
 
  }
	public static void Prob2() {
/*Write a Java program that initializes an array of strings with some values and then
finds the length of the longest string in the array.*/
	String[] num2 = {"Kurt", "Checker", "Armida", "KrazynesOverload", "sadsad"};	
	int len = 0;
	int compare = num2[0].length();
	String longest = "";
	   for(int i = 0; i<num2.length; i++) {
		   len=num2[i].length();
		   if(len>compare) {
			   compare=len;
			   longest = num2[i];
		   }
		   
	   }
	   System.out.println("Longest value: "+longest);
		
	}
    public static void Prob3(){
/*Write a Java program that initializes an array of integers with some values and
then finds the smallest value in the array.*/      
     int[]num3 = {100, 23, 50, 15, 40};
     int temp = num3[0];

       for(int i = 0; i<num3.length; i++){
          if(num3[i]<temp){
             temp = num3[i];
          }
       }
        System.out.println("Smallest value: " + temp);
    }
      public static void Prob4(){
/*Write a Java program that initializes two arrays of integers with some values and
then finds the common elements in both arrays*/  
         int[] arr1 = {23, 25, 40, 15, 30};
         int[] arr2 = {45, 50, 30, 23, 15};
         int same = 0;
          System.out.print("Common elements: ");
       for(int i = 0; i<arr1.length; i++){ 
          for(int j = 0; j<arr2.length; j++){  
            if(arr1[i] == arr2[j]){   
               same = arr1[i]; 
                System.out.print(same);
            }
        }
       }
          System.out.println(" ");
      }
        public static void Prob5(){
/* Write a Java program that initializes an array of integers with some values and
then sorts the array in descending order */           
   int arr[] = {40, 21, 50, 10, 2};
   int temp = 0;
      for(int i = 0; i<arr.length; i++ ){
        for(int j =i+1; j<arr.length; j++){
            if(arr[i]<arr[j]){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
      }        System.out.print("Descending order:");
        for(int i = 0; i<arr.length; i++){
              System.out.print(arr[i] + " ");
        }

        }
	
    public static void main(String[] args) {
        Prob1();
        Prob2();
        Prob3();
        Prob4();
        Prob5();
    }
}
