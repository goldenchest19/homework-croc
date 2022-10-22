package ru.croc.task4;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
// first type comment - //
// second type comment - /*

public class Task4 {
    static int startSecondTypeComment = 0;
    static boolean flag = false;


    public static void main(String[] args) throws IOException {
        String text = """
                /*
                 * My first ever program in Java!
                 */
                class Hello { // class body starts here
                
                  /* main method */
                  public /*   */static void main(String[] args/* we put command line arguments here*/) {
                    // this line prints my first greeting to the screen
                    System.out.println("Hi!"); // :)
                  } /* */ /* */
                } // the end
                 // to be continued...
                """;

        String finalText= """
                """;
        /*

         */
        try(Scanner scanner = new Scanner(text)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!deleteComment(line).isEmpty()){
                    finalText += deleteComment(line) + "\n";
                }
            }
        }

        System.out.println(finalText);
    }

    /**

     @param line
     @return
     */



    public static String deleteComment(String line) {
        if (line.contains("//")) {
            int startComment = line.indexOf("//");
            int len = line.length();

            String delLine = line.substring(startComment, len);
            line = line.replace(delLine, "");
        } else if (line.contains("/*") && line.contains("*/")) {
            while(line.contains("/*") && line.contains("*/")) {
                int startComment = line.indexOf("/*");
                int endComment = line.indexOf("*/");

                String delLine = line.substring(startComment, endComment + 2);
                line = line.replace(delLine, "");
            }
        } else if (line.contains("/*")) {
            line = "";
            flag = true;
        } else if (!line.contains("*/") && flag) {
            line = "";
        } else if (line.contains("*/")) {
            int startComment = 0;
            int endComment = line.indexOf("*/");

            String delLine = line.substring(startComment, endComment + 2);
            line = line.replace(delLine, "");
            flag=false;
        }

        return line;
    }

}
