
// Fig. 17.17: CreateSequentialFile.java
// Writing objects sequentially to a file with class ObjectOutputStream.
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class CreateSequentialFile
{
   private ObjectOutputStream output; // outputs data to file
   private ReadSequentialFile reader;
   private ArrayList<String> log;

   // allow user to specify file name
   public void openFile()
   {
      try // open file
      {
         File file = new File("highScore.ser");
         reader = new ReadSequentialFile();

         if (file.exists()) {
            reader.openFile();
            reader.readRecords();
            log = reader.getList();
            reader.closeFile();
         }
         output = new ObjectOutputStream(new FileOutputStream("highScore.ser"));
      } // end try
      catch ( IOException ioException )
      {
         System.err.println( "Error opening file." );
      } // end catch
   } // end method openFile

   // add records to file
   public void addRecords(String name, int score)
   {
      String finalScore = String.format("%s\t%d", name, score);

      try // output values to file
      {
         if (log != null) {
            for (int i = 0; i < log.size(); i++) {
               output.writeObject(log.get(i));
            }
         }
         output.writeObject(finalScore); // output record
      } // end try

      catch (IOException ioException) {
         System.err.println("Error writing to file.");
         return;
      } // end catch
      catch (NoSuchElementException elementException) {
         System.err.println("Invalid input. Please try again.");
      } // end catch

   } // end method addRecords

   // close file and terminate application 
   public void closeFile() 
   {
      try // close file
      {
         if ( output != null )
            output.close();
      } // end try
      catch ( IOException ioException )
      {
         System.err.println( "Error closing file." );
         System.exit( 1 );
      } // end catch
   } // end method closeFile
} // end class CreateSequentialFile

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