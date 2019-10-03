import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ClientInfoStatus;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ListTasks {

  public static void main(String[] args) {

    Path filePath = Paths.get("todoapp.txt");
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("Can't read file");
    }

    if (args.length > 0) {
      if (args[0].equals("-l")) {
        if (lines.size() == 0) {
          System.out.println("No todos for today! :)");
        } else {

          for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
          }
        }

      } else if (args[0].equals("-a")) {
          lines.add(args[1]);
          try {
              Files.write(filePath, lines);
          } catch (IOException e) {
          }
      }
    }
  }
}

