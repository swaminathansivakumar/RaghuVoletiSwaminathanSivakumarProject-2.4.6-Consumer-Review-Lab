import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<>();
  private static ArrayList<String> posAdjectives = new ArrayList<>();
  private static ArrayList<String> negAdjectives = new ArrayList<>();
  
  static {
    // Read sentiment values
    try (Scanner input = new Scanner(new File("cleanSentiment.csv"))) {
      while (input.hasNextLine()) {
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0], Double.parseDouble(temp[1]));
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing cleanSentiment.csv: " + e.getMessage());
    }
  
    // Read positive adjectives
    try (Scanner input = new Scanner(new File("positiveAdjectives.txt"))) {
      while (input.hasNextLine()) {
        posAdjectives.add(input.nextLine().trim());
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing positiveAdjectives.txt: " + e.getMessage());
    }   
 
    // Read negative adjectives
    try (Scanner input = new Scanner(new File("negativeAdjectives.txt"))) {
      while (input.hasNextLine()) {
        negAdjectives.add(input.nextLine().trim());
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing negativeAdjectives.txt: " + e.getMessage());
    }   
  }
  
  /** 
   * Returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString(String fileName) {  
    StringBuilder temp = new StringBuilder();
    try (Scanner input = new Scanner(new File(fileName))) {
      while (input.hasNext()) {
        temp.append(input.next()).append(" ");
      }
    } catch (Exception e) {
      System.out.println("Unable to locate " + fileName + ": " + e.getMessage());
    }
    return temp.toString().trim();
  }
  
  /**
   * Returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
 