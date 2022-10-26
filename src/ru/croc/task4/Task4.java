package ru.croc.task4;

import java.io.IOException;
import java.util.Scanner;
// first type comment - //
// second type comment - /*

public class Task4 {
     static boolean flag = false;

    public static void main(String[] args) {
        String source = """
                /*/*       hj      
                 * My first ever program in Java! // sddsdfd
                 *///// 
                 class Hello { // class body starts here
                  /* main method */ //gug
                  public /*   */static void main(String[] args/* we put command line arguments here*/) {
                    // this line prints my first greeting to the screen
                    System.out.println("Hi!"); // :)
                  } /**/ /* */ /////// 1412141343gbdfd
                } // the end
                 // to be continued...
                """;


        String noComments = removeJavaComments(source);
        System.out.println(noComments);
    }

    public static String removeJavaComments(String text) {
        String finalText = """
                      """;
        try(Scanner scanner = new Scanner(text)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (!refactorLine(line).isEmpty()){
                    finalText += refactorLine(line) + "\n";
                }
            }
        }
        return finalText;
    }

    public static String refactorLine(String lineCode) {
        String line = lineCode;

        while(line.contains("/*") && line.contains("*/") && !line.contains("/*/")) {
            int startComment = line.indexOf("/*");
            int endComment = line.indexOf("*/");

            String delLine = line.substring(startComment, endComment + 2);
            line = line.replace(delLine, "");
        }
        if (line.contains("/*")) {
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
        if (line.contains("//")) {
            int startComment = line.indexOf("//");
            int len = line.length();

            String delLine = line.substring(startComment, len);
            line = line.replace(delLine, "");
        }
        return line;
    }
}
