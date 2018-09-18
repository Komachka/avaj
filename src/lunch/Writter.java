package src.lunch;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.File;

public class Writter {

    private static PrintWriter writer;
    private static File file;

    public Writter(String fileName) throws IOException, FileNotFoundException, UnsupportedEncodingException {
        if(writer == null) {
            file = new File(fileName);
            file.createNewFile();
            writer = new PrintWriter(file); 
        }
    }

    public static void printLine(String line)
    {
        writer.println(line);
        //System.out.println(line);
    }

    public static void close()
    {
        writer.close();
    }

}
