import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Files {
    public static void makingAtxtFile(){
   Scanner sc = new Scanner(System.in);  
                         //directory must change
      String filename = "C:\\Users\\pc\\Desktop\\file.txt";
        try{
            FileWriter writer = new FileWriter(filename);
           
 String text = ("Holabels!\nMay kwento akizkis gorabels ang lola nyey sa nyinistop");            
 String text2 = ("\npara mag buyla ng mga meslu at nyogig\nsyempre kailangan ko mag-breakfastlu diba! ");
              writer.write(text);
              writer.write(text2);
              writer.close();
           System.out.println("File succesfully created: " + filename);
        } catch(IOException e){
             System.out.println("An error occured.");  
        }
    }
      public static void prob1(){
/*Write a Java program that reads a text file and prints out the contents of the file*/        
           String filename = "C:\\Users\\pc\\Desktop\\file.txt";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        } catch(IOException e){
              System.out.println("An error occured.");  
              e.printStackTrace();
        }
      }
       public static void prob2(){          
/*Write a Java program that reads a text file and counts the number of lines in the
file.*/           
      String filename = "C:\\Users\\pc\\Desktop\\file.txt";
      int lines = 0;
       try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null){
                line = reader.readLine();
                lines ++;
            }
        } catch(IOException e){
              System.out.println("An error occured.");  
        }
           System.out.println("Lines in the txt file: " + lines);
       }
       public static void prob3(){
/*Write a Java program that reads a text file and counts the number of words in the
file.*/
       String filename = "C:\\Users\\pc\\Desktop\\file.txt";
      int numOfWords = 0;
      try{
      BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
             String[] words = line.split("\\s+");
             numOfWords += words.length;
          }
       System.out.println("Number of words in the file: " + numOfWords);
        } catch(IOException e){
              System.out.println("An error occured.");  
        }
       }
       public static void prob4(){
//Write a Java program that reads a text file and finds the longest word in the file.   
    String filename = "C:\\Users\\pc\\Desktop\\file.txt";
    String longestWord = "";
         try {
     BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
            while (line != null) {
              String[] words = line.split("\\s+");
            for (String word : words) {
              if (word.length() > longestWord.length()) {
                longestWord = word;
               }
            }
            line = reader.readLine();
         }
            System.out.println("Longest word: " + longestWord);
        } catch (IOException e) {
            System.out.println("An error occurred.");
           }
       }
       
       public static void prob5(){          
/*Write a Java program that reads a text file and finds the frequency of each word
in the file.*/          
     String filename = "C:\\Users\\pc\\Desktop\\file.txt";
        Map<String, Integer> wordCount = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
            }
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
       }
    public static void main(String[] args) {
        makingAtxtFile();
        prob1();
        prob2();
        prob3();
        prob4();
        prob5();
    }
}
