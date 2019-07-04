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
      ArrayList<Object> log = application.getList();
      
      for (int i = 0; i < log.size(); i++) {
         if (i % 2 == 0) {
            String name = (String) log.get(i);
            System.out.printf("%s\t", name);
         }
         else {
            Long score = (Long) log.get(i);
            System.out.printf("%d\n", score);
         }
      }
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