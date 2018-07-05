import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        baner();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        menu();

        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();

        if (selection == 1) {
            try {
                String csvFile = "src/listMovie.csv";

                long countOfLines = Files.lines(Paths.get(new File(csvFile).getPath())).count();

                Store store = new Store ((int) countOfLines - 1);

                br = new BufferedReader(new FileReader(csvFile));

                boolean skipFirtLine = true;
                int currentLine = 0;
                load(br, cvsSplitBy, store, skipFirtLine, currentLine);

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
        }else if (selection == 2){
            try {
                String csvFile = "src/customers.csv";

                long countOfLines = Files.lines(Paths.get(new File(csvFile).getPath())).count();

                Store store = new Store ((int) countOfLines - 1);

                br = new BufferedReader(new FileReader(csvFile));

                boolean skipFirtLine = true;
                int currentLine = 0;
                customerInfo(br, cvsSplitBy, store, skipFirtLine, currentLine);

                store.showCustomers();

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

        }else if(selection == 3){
            try {
                String csvFile = "src/listMovie.csv";

                long countOfLines = Files.lines(Paths.get(new File(csvFile).getPath())).count();

                Store store = new Store ((int) countOfLines - 1);

                br = new BufferedReader(new FileReader(csvFile));

                boolean skipFirtLine = true;
                int currentLine = 0;
                load(br, cvsSplitBy, store, skipFirtLine, currentLine);

                System.out.print("Podaj ID wybranego filmu: ");
                Scanner movieSel = new Scanner(System.in);
                int movieNumber = scanner.nextInt();

                store.showMov(movieNumber - 1);

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


        }else if (selection == 4){
            try {
                String csvFile = "src/customers.csv";

                long countOfLines = Files.lines(Paths.get(new File(csvFile).getPath())).count();

                Store store = new Store ((int) countOfLines - 1);

                br = new BufferedReader(new FileReader(csvFile));

                boolean skipFirtLine = true;
                int currentLine = 0;
                customerInfo(br, cvsSplitBy, store, skipFirtLine, currentLine);

                System.out.print("Podaj ID klienta: ");
                Scanner customerSel = new Scanner(System.in);
                int customerNumber = scanner.nextInt();

                store.showCustomer(customerNumber - 1);

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

    private static void customerInfo(BufferedReader br, String cvsSplitBy, Store store, boolean skipFirtLine, int currentLine) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            if (skipFirtLine) {
                skipFirtLine = false;
                continue;
            }

            String[] string = line.split(cvsSplitBy);

            Customers customers = new Customers(
                    string[0].trim(),
                    string[1].trim(),
                    Integer.parseInt(string[2].trim()),
                    string[3].trim(),
                    Integer.parseInt(string[4].trim()),
                    string[5].trim());

            store.addCustomers(customers, currentLine);
            currentLine++;

        }
    }

    private static void load(BufferedReader br, String cvsSplitBy, Store store, boolean skipFirtLine, int currentLine) throws IOException {
        String line;
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
    }

    private static void menu() {
        System.out.println("DOKONAJ WYBORU");
        System.out.println("                                              ");
        System.out.println("(1) Wyświetl listę filmów dostępnych w wypożyczalni");
        System.out.println("(2) Wyświetl listę klientów wypożyczalni");
        System.out.println("(3) Wybierz film");
        System.out.println("(4) Wybierz klienta");
        System.out.println("                                              ");
        System.out.print("Podaj liczbę odpowiadającą wybranej funkcji: ");
    }

    private static void baner() {
        System.out.println("                                              ");
        System.out.println("==============================================");
        System.out.println("==      Program dla wypożyczalni video      ==");
        System.out.println("==              MOVIESTORE 1.0              ==");
        System.out.println("==============================================");
        System.out.println("==                Wykonali:                 ==");
        System.out.println("==      mł.asp. Marcin Brzeziński           ==");
        System.out.println("==         asp. Sylwester Brożyna           ==");
        System.out.println("==      st.asp. Piotr Bąkiewicz             ==");
        System.out.println("==============================================");
        System.out.println("                                              ");
        System.out.println("                                              ");
        System.out.println("                                              ");
    }

}