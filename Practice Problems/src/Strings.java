
import java.util.Arrays;


public class Strings {
    public static void prob1(){
/*Write a Java program that takes a string as input and prints out the string in
reverse order.*/       
     String raw = "Krazy";
     String reverse = " ";
      
        for(int i = raw.length() - 1; i >=0; i-- ){
            reverse = reverse + raw.charAt(i);
        }
        System.out.println("Reversed string: " + reverse);
    }
     public static void prob2(){
/*Write a Java program that takes two strings as input and checks if they are
anagrams of each other.*/        
       String str1 = ("listen");
       String str2 = ("silent");
       
       // Convert strings to lowercase and remove spaces
       str1 = str1.toLowerCase().replaceAll("\\s", "");
       str2 = str2.toLowerCase().replaceAll("\\s", "");
       
       // Convert strings to char arrays and sort them
       char[] charArray1 = str1.toCharArray();
       Arrays.sort(charArray1);

       char[] charArray2 = str2.toCharArray();
       Arrays.sort(charArray2);
       
       // Compare sorted char arrays to check for anagram
       boolean isAnagram = Arrays.equals(charArray1, charArray2);
       if (isAnagram) {
            System.out.println("The two strings are anagrams of each other.");
        } else {
            System.out.println("The two strings are not anagrams of each other.");
        }

     }
     public static void prob3(){
 /*Write a Java program that takes a string as input and removes all the vowels from
the string.*/        
         //string with vowels
       String str = "wawayue";
       
         // Remove all vowels from string
        str = str.replaceAll("[aeiouAEIOU]", "");

        // Output result
        System.out.println("New string without vowels: " + str);

     }
      public static void prob4(){
  //Write a Java program that takes a string as input and checks if it is a palindrome.      
        String str = "rotator";

        // Reverse the string
        String reversedStr = new StringBuilder(str).reverse().toString();

        // Compare the original and reversed strings
        boolean isPalindrome = str.equals(reversedStr);

        // Output result
        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

  
      }
      public static void prob5(){
/*Write a Java program that takes a string as input and counts the number of
words in the string.*/          
        String str = "ubuevuevue";
        
        int length = str.length();
        
          System.out.println("Word length: " + length);
      }
    public static void main(String[] args) {
        prob1();
        prob2();
        prob3();
        prob4();
        prob5();
    }
 
}
