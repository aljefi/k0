import java.util.*;

public class Answer {
   public static void main (String[] param) {
      // TODO!!! Solutions to small problems 
      //   that do not need an independent method!

      // conversion double -> String
      double param1 = 1.11;
      String convertedToString = String.valueOf(param1);
      System.out.println(convertedToString);

      // conversion String -> int
      String param2 = "1234";
      try {
         param2 = String.valueOf(Integer.parseInt(param2));
      } catch (NumberFormatException e) {
         e.printStackTrace(System.out);
      }
      System.out.println(param2);

      // "hh:mm:ss"
      String[] a = new Date(System.currentTimeMillis()).toString().split(" ");
      System.out.println("Time: " + a[3]);

      // cos 45 deg
      double inDegrees = 45.0;
      double inRadians = Math.toRadians(inDegrees);
      System.out.println("cos45: " + Math.cos(inRadians));

      // table of square roots
      for (double i = 0; i <= 100;) {
         System.out.println(i + "\t" + Math.sqrt(i));
         i += 5;
      }


      String firstString = "ABcd12";
      String result = reverseCase (firstString);
      System.out.println ("\"" + firstString + "\" -> \"" + result + "\"");

      // reverse string
      String revS = "1234ab";
      StringBuilder sb = new StringBuilder(revS);
      sb.reverse();
      System.out.println(sb);

      String s = "How  many	 words   here";
      int nw = countWords (s);
      System.out.println (s + "\t" + String.valueOf (nw));

      // pause. COMMENT IT OUT BEFORE JUNIT-TESTING!
      long t0 = System.nanoTime();
      try {
         Thread.sleep(3000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      long t1 = System.nanoTime();
      System.out.println("Pause: " + (t1-t0) + " ns.");

      final int LSIZE = 100;
      ArrayList<Integer> randList = new ArrayList<Integer> (LSIZE);
      Random generaator = new Random();
      for (int i=0; i<LSIZE; i++) {
         randList.add (Integer.valueOf (generaator.nextInt(1000)));
      }

      // minimal element
      Integer minNum = 1000;
      for (Integer i : randList) {
         // if i < maxNum ===> -1
         if (i.compareTo(minNum) < 0)
            minNum = i;
      }
      System.out.println("Minimum: " + minNum);
      // HashMap tasks:
      //    create
      HashMap<Integer, String> hmap = new HashMap<>();
      hmap.put(1, "Maths");
      hmap.put(2, "Chemistry");
      hmap.put(3, "Foreign language");
      hmap.put(4, "Eesti keel");
      hmap.put(5, "Algebra");
      //    print all keys
      for (Integer i :
              hmap.keySet()) {
         System.out.println(i);
      }
      //    remove a key
      hmap.remove(3);
      //    print all pairs
      for (Integer i : 
              hmap.keySet()) {
         System.out.println(i + ": " + hmap.get(i));
      }

      System.out.println ("Before reverse:  " + randList);
      reverseList (randList);
      System.out.println ("After reverse: " + randList);

      System.out.println ("Maximum: " + maximum (randList));
   }

   /** Finding the maximal element.
    * @param a Collection of Comparable elements
    * @return maximal element.
    * @throws NoSuchElementException if <code> a </code> is empty.
    */
   static public <T extends Object & Comparable<? super T>>
         T maximum (Collection<? extends T> a)
            throws NoSuchElementException {
      T maxNum = (T) a.toArray()[0];
      for (T j : a) {
         // if j > maxNum ==> true
         if (j.compareTo(maxNum) > 0)
            maxNum = j;
      }
      return maxNum;
   }

   /** Counting the number of words. Any number of any kind of
    * whitespace symbols between words is allowed.
    * @param text text
    * @return number of words in the text
    */
   public static int countWords (String text) {
      StringTokenizer tokens = new StringTokenizer(text);
      return tokens.countTokens();
   }

   /** Case-reverse. Upper -> lower AND lower -> upper.
    * @param s string
    * @return processed string
    */
   public static String reverseCase (String s) {
      //converting to charArray
      char[] sToChars = s.toCharArray();
         for (int i = 0; i < sToChars.length; i++) {
            // ternary operator
            sToChars[i] = Character.isLowerCase(sToChars[i])
                    ? Character.toUpperCase(sToChars[i])
                    : Character.toLowerCase(sToChars[i]);
         }
         return new String(sToChars);
      }

   /** List reverse. Do not create a new list.
    * @param list list to reverse
    */
   public static <T extends Object> void reverseList (List<T> list)
      throws UnsupportedOperationException {
      for (int i = 0; i < list.size(); i++) {
         list.add(i, list.remove(list.size() - 1));
      }
   }
}
