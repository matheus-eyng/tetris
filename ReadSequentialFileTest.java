import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Testing class ReadSequentialFile.

public class ReadSequentialFileTest
{
   public static void main( String[] args )
   {
      ReadSequentialFile application = new ReadSequentialFile();

      application.openFile();
      application.readRecords();
      ArrayList<String> log = application.getList();
      
      // Ordenando com regex
      ArrayList<Long> num = new ArrayList<Long>();
      for (int i = 0; i < log.size(); i++) {
         System.out.printf("%s\n", log.get(i));
         Pattern p = Pattern.compile("\\d+");
         Matcher m = p.matcher(log.get(i));
         while(m.find()) {
            num.add(Long.parseLong(m.group()));
         }
      }
      num.sort(null);
      System.out.println(num);

      application.closeFile();

   } // end main
} // end class ReadSequentialFileTest

/*************************************************************************
* (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
* Pearson Education, Inc. All Rights Reserved.                           *
*                                                                        *
* DISCLAIMER: The authors and publisher of this book have used their     *
* best efforts in preparing the book. These efforts include the          *
* development, research, and testing of the theories and programs        *
* to determine their effectiveness. The authors and publisher make       *
* no warranty of any kind, expressed or implied, with regard to these    *
* programs or to the documentation contained in these books. The authors *
* and publisher shall not be liable in any event for incidental or       *
* consequential damages in connection with, or arising out of, the       *
* furnishing, performance, or use of these programs.                     *
*************************************************************************/