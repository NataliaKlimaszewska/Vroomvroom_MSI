import java.util.Scanner;

public class KonsoloweUI implements InterfejsUzytkownika {

    private Scanner scanner;

    public KonsoloweUI(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String zadajPytanie(String prompt, String... options) {
        System.out.println("\n" + prompt);
        String opcjeWyswietlane = "[" + String.join(" / ", options) + "]";
        System.out.println(opcjeWyswietlane);

        while (true) {
            System.out.print("> ");
            String odpowiedz = scanner.nextLine().trim().toLowerCase();

            for (String option : options) {
                if (option.equals(odpowiedz)) {
                    return odpowiedz;
                }
            }

            System.out.println("Nierozpoznana opcja. Wybierz jedną z: " + opcjeWyswietlane);
        }
    }
}