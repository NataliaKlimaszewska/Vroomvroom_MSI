import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap; // Ważne, aby zachować kolejność pytań i opcji

public class TransportQuiz {

    // Używamy klasy wewnętrznej do przechowywania struktury pytania
    private static class Question {
        String questionText;
        Map<String, String> options;

        Question(String questionText, Map<String, String> options) {
            this.questionText = questionText;
            this.options = options;
        }
    }

    // Mapa przechowująca wszystkie pytania
    private static final Map<Integer, Question> pytania = new LinkedHashMap<>();

    // Mapa na odpowiedzi użytkownika
    private static final Map<Integer, String> odpowiedzi = new HashMap<>();

    /**
     * Metoda pomocnicza do wypełnienia mapy pytaniami.
     */
    private static void setupQuestions() {
        // Pytanie 1
        Map<String, String> ops1 = new LinkedHashMap<>();
        ops1.put("a", "Tak");
        ops1.put("b", "Nie");
        pytania.put(1, new Question("Czy masz ukończone 18 lat?", ops1));

        // Pytanie 2
        Map<String, String> ops2 = new LinkedHashMap<>();
        ops2.put("a", "Tak");
        ops2.put("b", "Nie");
        pytania.put(2, new Question("Czy posiadasz prawo jazdy?", ops2));

        // Pytanie 3
        Map<String, String> ops3 = new LinkedHashMap<>();
        ops3.put("a", "Tak, jestem z Legnicy");
        ops3.put("b", "Nie");
        ops3.put("c", "Zależy kto pyta");
        pytania.put(3, new Question("Czy jesteś uzależniony od substancji odurzających?", ops3));

        // Pytanie 4
        Map<String, String> ops4 = new LinkedHashMap<>();
        ops4.put("a", "Tak");
        ops4.put("b", "Nie");
        pytania.put(4, new Question("Czy jesteś rolnikiem?", ops4));

        // Pytanie 5
        Map<String, String> ops5 = new LinkedHashMap<>();
        ops5.put("a", "Tak");
        ops5.put("b", "Nie");
        pytania.put(5, new Question("Czy planujesz być dawcą organów?", ops5));

        // Pytanie 6
        Map<String, String> ops6 = new LinkedHashMap<>();
        ops6.put("a", "Tak");
        ops6.put("b", "Nie");
        pytania.put(6, new Question("Czy zależy Ci na dużej pojemności ładunkowej?", ops6));

        // Pytanie 7
        Map<String, String> ops7 = new LinkedHashMap<>();
        ops7.put("a", "Tak");
        ops7.put("b", "Nie");
        pytania.put(7, new Question("Czy prowadzisz aktywny tryb życia?", ops7));

        // Pytanie 8
        Map<String, String> ops8 = new LinkedHashMap<>();
        ops8.put("a", "Kobieta");
        ops8.put("b", "Mężczyzna");
        pytania.put(8, new Question("Jakiej jesteś płci?", ops8));

        // Pytanie 9
        Map<String, String> ops9 = new LinkedHashMap<>();
        ops9.put("a", "Tak, uwielbiam");
        ops9.put("b", "Nie");
        pytania.put(9, new Question("Czy lubisz samotną jazdę?", ops9));

        // Pytanie 10
        Map<String, String> ops10 = new LinkedHashMap<>();
        ops10.put("a", "Wysoki");
        ops10.put("b", "Umiarkowany");
        ops10.put("c", "Niski");
        ops10.put("d", "Zerowy");
        pytania.put(10, new Question("Jaki jest Twój miesięczny budżet na utrzymanie pojazdu?", ops10));

        // Pytanie 11
        Map<String, String> ops11 = new LinkedHashMap<>();
        ops11.put("a", "> 10km");
        ops11.put("b", "< 10 km");
        pytania.put(11, new Question("Jaka jest typowa odległość do Twojego celu (w jedną stronę)?", ops11));

        // Pytanie 12
        Map<String, String> ops12 = new LinkedHashMap<>();
        ops12.put("a", "Bardzo ważna");
        ops12.put("b", "Obojętna");
        ops12.put("c", "Nieważna");
        pytania.put(12, new Question("Jak ważna jest dla Ciebie niezależność od warunków pogodowych?", ops12));

        // Pytanie 13
        Map<String, String> ops13 = new LinkedHashMap<>();
        ops13.put("a", "Tak");
        ops13.put("b", "Nie");
        pytania.put(13, new Question("Czy Twoje zdolności motoryczne są zsynchronizowane?", ops13));

        // Pytanie 14
        Map<String, String> ops14 = new LinkedHashMap<>();
        ops14.put("a", "Czekam.");
        ops14.put("b", "Objeżdżam polem, łąką.");
        ops14.put("c", "Jadę po prostu bokiem.");
        ops14.put("d", "Zawracam i wybieram skrót");
        pytania.put(14, new Question("Co robisz, gdy droga jest zablokowana?", ops14));

        // Pytanie 15
        Map<String, String> ops15 = new LinkedHashMap<>();
        ops15.put("a", "Kot");
        ops15.put("b", "Pies");
        ops15.put("c", "Ślimak");
        ops15.put("d", "Krowa");
        pytania.put(15, new Question("Jakie jest Twoje ulubione zwierzę?", ops15));
    }


    /**
     * Metoda obliczająca i wyświetlająca KONKRETNY wynik.
     */
    private static void printResult() {
        // --- ALGORYTM OCENY ---
        Map<String, Integer> punkty = new HashMap<>();
        punkty.put("samochod", 0);
        punkty.put("rower", 0);
        punkty.put("nogi", 0);
        punkty.put("rolniczy", 0);
        punkty.put("motor", 0);

        // Pytanie 1 & 2 (Wiek i Prawo Jazdy)
        if (odpowiedzi.get(1).equals("b") || odpowiedzi.get(2).equals("b")) {
            punkty.compute("samochod", (k, v) -> v - 100);
            punkty.compute("motor", (k, v) -> v - 100);
        } else {
            punkty.compute("samochod", (k, v) -> v + 2);
            punkty.compute("motor", (k, v) -> v + 2);
        }

        // Pytanie 3 (Uzależnienie)
        if (odpowiedzi.get(3).equals("a")) { // Legnica
            punkty.compute("rolniczy", (k, v) -> v + 1);
        } else if (odpowiedzi.get(3).equals("c")) { // Zależy kto pyta
            punkty.compute("motor", (k, v) -> v + 1);
        }

        // Pytanie 4 (Rolnik)
        if (odpowiedzi.get(4).equals("a")) {
            punkty.compute("rolniczy", (k, v) -> v + 10);
        } else {
            punkty.compute("rolniczy", (k, v) -> v - 10);
        }

        // Pytanie 6 (Pojemność)
        if (odpowiedzi.get(6).equals("a")) {
            punkty.compute("samochod", (k, v) -> v + 3);
            punkty.compute("rolniczy", (k, v) -> v + 3);
        } else {
            punkty.compute("rower", (k, v) -> v + 2);
            punkty.compute("nogi", (k, v) -> v + 1);
            punkty.compute("motor", (k, v) -> v + 2);
        }

        // Pytanie 7 (Aktywny tryb życia)
        if (odpowiedzi.get(7).equals("a")) {
            punkty.compute("rower", (k, v) -> v + 3);
            punkty.compute("nogi", (k, v) -> v + 3);
        } else {
            punkty.compute("samochod", (k, v) -> v + 1);
            punkty.compute("motor", (k, v) -> v + 1);
        }

        // Pytanie 9 (Samotna jazda)
        if (odpowiedzi.get(9).equals("a")) {
            punkty.compute("motor", (k, v) -> v + 4);
        } else {
            punkty.compute("samochod", (k, v) -> v + 1);
        }

        // Pytanie 10 (Budżet)
        switch (odpowiedzi.get(10)) {
            case "a": // Wysoki
                punkty.compute("samochod", (k, v) -> v + 2);
                punkty.compute("rolniczy", (k, v) -> v + 1);
                break;
            case "b": // Umiarkowany
                punkty.compute("samochod", (k, v) -> v + 1);
                punkty.compute("motor", (k, v) -> v + 1);
                break;
            case "c": // Niski
                punkty.compute("rower", (k, v) -> v + 2);
                break;
            case "d": // Zerowy
                punkty.compute("nogi", (k, v) -> v + 5);
                break;
        }

        // Pytanie 11 (Odległość)
        if (odpowiedzi.get(11).equals("a")) { // > 10km
            punkty.compute("samochod", (k, v) -> v + 2);
            punkty.compute("motor", (k, v) -> v + 2);
            punkty.compute("rolniczy", (k, v) -> v + 1);
        } else { // < 10km
            punkty.compute("rower", (k, v) -> v + 2);
            punkty.compute("nogi", (k, v) -> v + 2);
        }

        // Pytanie 12 (Pogoda)
        switch (odpowiedzi.get(12)) {
            case "a": // Bardzo ważna
                punkty.compute("samochod", (k, v) -> v + 3);
                break;
            case "b": // Obojętna
                punkty.compute("motor", (k, v) -> v + 1);
                punkty.compute("rolniczy", (k, v) -> v + 1);
                break;
            case "c": // Nieważna
                punkty.compute("rower", (k, v) -> v + 2);
                punkty.compute("nogi", (k, v) -> v + 2);
                break;
        }

        // Pytanie 13 (Zdolności motoryczne)
        if (odpowiedzi.get(13).equals("a")) {
            punkty.compute("motor", (k, v) -> v + 3);
        } else {
            punkty.compute("motor", (k, v) -> v - 3);
        }

        // Pytanie 14 (Zablokowana droga)
        switch (odpowiedzi.get(14)) {
            case "a": // Czekam
                punkty.compute("samochod", (k, v) -> v + 1);
                break;
            case "b": // Objeżdżam polem
                punkty.compute("rolniczy", (k, v) -> v + 5);
                break;
            case "c": // Jadę bokiem
                punkty.compute("motor", (k, v) -> v + 2);
                break;
            case "d": // Zawracam
                punkty.compute("rower", (k, v) -> v + 1);
                punkty.compute("nogi", (k, v) -> v + 1);
                break;
        }

        // Pytanie 15 (Zwierzę)
        switch (odpowiedzi.get(15)) {
            case "a": // Kot
                punkty.compute("motor", (k, v) -> v + 1);
                break;
            case "b": // Pies
                punkty.compute("samochod", (k, v) -> v + 1);
                break;
            case "c": // Ślimak
                punkty.compute("nogi", (k, v) -> v + 2);
                break;
            case "d": // Krowa
                punkty.compute("rolniczy", (k, v) -> v + 2);
                break;
        }

        // --- ZAKOŃCZENIE I WYNIK ---

        // Mapowanie kluczy technicznych na polskie nazwy (dla punktacji)
        Map<String, String> mapaNazw = Map.of(
                "samochod", "Samochód",
                "rower", "Rower",
                "nogi", "Nogi",
                "rolniczy", "Pojazd rolniczy",
                "motor", "Motor"
        );

        // Znalezienie klucza (np. "samochod") z najwyższą wartością punktową
        String najlepszyKlucz = "";
        int maxPunkty = Integer.MIN_VALUE; // Najmniejsza możliwa wartość int

        for (Map.Entry<String, Integer> entry : punkty.entrySet()) {
            if (entry.getValue() > maxPunkty) {
                maxPunkty = entry.getValue();
                najlepszyKlucz = entry.getKey();
            }
        }

        // --- WYŚWIETLANIE KONKRETNEJ ODPOWIEDZI ---
        System.out.println("\n--- WYNIK QUIZU ---");

        if (maxPunkty < -10) {
            System.out.println("Hmm, wygląda na to, że na razie żaden pojazd nie pasuje.");
            System.out.println("Najbardziej zbliżasz się do: Nogi");
            System.out.println("\nTwoja konkretna odpowiedź:");
            System.out.println("Jesteś osobą twardo stąpającą po ziemi, która ceni niezależność finansową i aktywność. Najlepszym i najtańszym rozwiązaniem dla Ciebie są po prostu... Twoje własne nogi! Idealne na krótkie trasy. 🚶‍♀️🚶‍♂️");

        } else {
            // Używamy instrukcji switch do wygenerowania konkretnej odpowiedzi
            switch (najlepszyKlucz) {
                case "samochod":
                    System.out.println("Twój idealny środek transportu to: Samochód 🚗");
                    System.out.println("\nTwoja konkretna odpowiedź:");
                    System.out.println("Wygląda na to, że potrzebujesz niezależności i komfortu. Cenisz sobie możliwość dotarcia do celu bez względu na pogodę i zależy Ci na przestrzeni. Idealnym rozwiązaniem dla Ciebie będzie samochód, który zapewni Ci osłonę przed deszczem i pozwoli wygodnie pokonywać dłuższe dystanse.");
                    break;
                case "rower":
                    System.out.println("Twój idealny środek transportu to: Rower 🚲");
                    System.out.println("\nTwoja konkretna odpowiedź:");
                    System.out.println("Cenisz sobie zdrowie, aktywność i ekologię. Twój idealny środek transportu to rower. Świetnie sprawdzi się na krótszych dystansach (poniżej 10 km), pozwoli Ci ominąć korki, a przy okazji zadbasz o kondycję. Niski budżet na utrzymanie to dodatkowy atut!");
                    break;
                case "nogi":
                    System.out.println("Twój idealny środek transportu to: Nogi 🚶");
                    System.out.println("\nTwoja konkretna odpowiedź:");
                    System.out.println("Jesteś osobą twardo stąpającą po ziemi, która ceni niezależność finansową (zerowy budżet!) i aktywny tryb życia. Najlepszym i najtańszym rozwiązaniem dla Ciebie są po prostu... Twoje własne nogi! Idealne na krótkie trasy i zupełnie niewrażliwe na blokady drogowe.");
                    break;
                case "rolniczy":
                    System.out.println("Twój idealny środek transportu to: Pojazd rolniczy 🚜");
                    System.out.println("\nTwoja konkretna odpowiedź:");
                    System.out.println("Twoje odpowiedzi wskazują, że masz bardzo konkretne potrzeby. Zablokowana droga to nie problem, bo po prostu objeżdżasz ją polem! Najwyraźniej najbardziej przyda Ci się solidny pojazd rolniczy, który poradzi sobie w każdych warunkach i pomieści duży ładunek.");
                    break;
                case "motor":
                    System.out.println("Twój idealny środek transportu to: Motor 🏍️");
                    System.out.println("\nTwoja konkretna odpowiedź:");
                    System.out.println("Cenisz sobie wolność, adrenalinę i lubisz poczuć wiatr we włosach. Idealnym wyborem dla Ciebie będzie motor. Pozwoli Ci sprawnie przemieszczać się po mieście, przeciskać się w korkach i czerpać radość z samotnej jazdy. Świetna koordynacja ruchowa jest tu kluczowa!");
                    break;
                default:
                    System.out.println("Nie udało się ustalić konkretnej odpowiedzi.");
            }
        }

        // Opcjonalnie: Pokaż pełną punktację (teraz używamy mapaNazw)
        System.out.println("\nSzczegółowa punktacja:");
        for (Map.Entry<String, Integer> entry : punkty.entrySet()) {
            System.out.println("  " + mapaNazw.get(entry.getKey()) + ": " + entry.getValue() + " pkt.");
        }
    }


    /**
     * Główna metoda programu (Main)
     */
    public static void main(String[] args) {
        // Używamy try-with-resources, aby Scanner został automatycznie zamknięty
        try (Scanner scanner = new Scanner(System.in)) {

            // Wypełnij pytania
            setupQuestions();

            System.out.println("--- Rozpocznij Quiz ---");
            System.out.println("Wpisz literę (a, b, c...) odpowiadającą Twojej odpowiedzi i naciśnij Enter.\n");

            // Pętla zadająca pytania
            for (Map.Entry<Integer, Question> entry : pytania.entrySet()) {
                int numer = entry.getKey();
                Question q = entry.getValue();

                System.out.println("Pytanie " + numer + ": " + q.questionText);

                // Wyświetlanie opcji
                for (Map.Entry<String, String> option : q.options.entrySet()) {
                    System.out.println("  " + option.getKey() + ") " + option.getValue());
                }

                // Pętla walidacyjna - pobiera odpowiedź, dopóki nie będzie poprawna
                while (true) {
                    System.out.print("Twoja odpowiedź: ");
                    String odp = scanner.nextLine().trim().toLowerCase();

                    if (q.options.containsKey(odp)) {
                        odpowiedzi.put(numer, odp); // Zapisz odpowiedź
                        break; // Wyjdź z pętli walidacyjnej
                    } else {
                        // String.join łączy elementy kolekcji
                        String dostepneOpcje = String.join(", ", q.options.keySet());
                        System.out.println("Błędna opcja. Wybierz jedną z: " + dostepneOpcje);
                    }
                }
                System.out.println("--------------------"); // Separator
            }

            // Oblicz i wyświetl wynik
            printResult();

        } catch (Exception e) {
            System.err.println("Wystąpił nieoczekiwany błąd: " + e.getMessage());
            e.printStackTrace();
        }
    }
}