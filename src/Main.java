import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        String csvFile = "src/listMovie.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";


        try {
            long countOfLines = Files.lines(Paths.get(new File(csvFile).getPath())).count();

            Store store = new Store ((int) countOfLines - 1);

            br = new BufferedReader(new FileReader(csvFile));

            boolean skipFirtLine = true;
            int currentLine = 0;
            while ((line = br.readLine()) != null) {
                if (skipFirtLine) {
                    skipFirtLine = false;
                    continue;
                }

                String[] string = line.split(cvsSplitBy);

                Movie movie = new Movie(
                        string[0].trim(),
                        string[1].trim(),
                        string[2].trim(),
                        Integer.parseInt(string[3].trim()),
                        string[4].trim(),
                        string[5].trim());

                store.addMovie(movie, currentLine);
                currentLine++;

            }

            store.showStore();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
