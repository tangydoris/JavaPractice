

public class PermuteString {
  public static void main(String args[]) {
    permuteString("", "String");
    System.out.println(" ");
    
    //ArrayList<String> myStrings = myPermuteString("", "String");
    //System.out.println(myStrings);
    
  }

  public static void permuteString(String beginningString, String endingString) {
    if (endingString.length() <= 1) {
      System.out.println(beginningString + endingString);
      System.out.println(" ");
    }
    else
      for (int i = 0; i < endingString.length(); i++) {
        try {
          String newString = endingString.substring(0, i) + endingString.substring(i + 1);
          System.out.println(beginningString + endingString.charAt(i));
          System.out.println(newString);
          permuteString(beginningString + endingString.charAt(i), newString);

        } catch (StringIndexOutOfBoundsException exception) {
          exception.printStackTrace();
      }
    }
  }

  /*
  public static ArrayList<String> myPermuteString(String prefix, String str) {
    // Game Plan:
    // Look at the first character. Fix it.
    // Look at the rest of the string. Permute it

    // Keep looking at ending part of the String without the first character.
    // When we get to the end (two characters left), swap them.

    if (str.length() <= 1)
      ArrayList.add(prefix+str);

    else {
      for (int i = 0; i < str.length(); i++) {

      }
    }
    return new ArrayList<String>();
  }
  */
}