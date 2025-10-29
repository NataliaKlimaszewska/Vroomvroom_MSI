import java.util.Scanner;

public class QuizPojazd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Witaj w Inteligentnym Doradcy Transportowym ---");
        System.out.println("Odpowiedz na serię pytań, aby znaleźć idealny środek transportu.");
        System.out.println("Wpisuj tylko jedną z podanych opcji i naciskaj Enter.");
        System.out.println("-----------------------------------------------------");

        String rekomendacja = rozpocznijDiagnostyke(scanner);

        System.out.println("\n===================================");
        System.out.println("Twoja rekomendacja: " + rekomendacja);
        System.out.println("===================================");

        scanner.close();
    }

    private static String rozpocznijDiagnostyke(Scanner scanner) {
        String uzaleznienie = askQuestion(scanner,
                "Czy jesteś uzależniony od substancji odurzających?",
                "tak", "nie", "zalezy kto pyta");

        if (uzaleznienie.equals("tak") || uzaleznienie.equals("zalezy kto pyta")) {
            return "Transport Publiczny lub Pieszo (Prosimy nie prowadzić!)";
        }

        String dystans = askQuestion(scanner,
                "Jaka jest typowa odległość, jaką musisz pokonać w jedną stronę?",
                "krótka (< 10km)", "długa (> 10km)");

        if (dystans.equals("krótka (< 10km)")) {
            return obsluzKrotkiDystans(scanner);
        } else {
            return obsluzDlugiDystans(scanner);
        }
    }

    private static String obsluzKrotkiDystans(Scanner scanner) {
        String aktywnyTryb = askQuestion(scanner,
                "Czy prowadzisz aktywny tryb życia?",
                "tak", "nie");

        if (aktywnyTryb.equals("tak")) {
            String pogoda = askQuestion(scanner,
                    "Jak ważna jest dla Ciebie niezależność od warunków pogodowych?",
                    "ważna", "nieważna");

            if (pogoda.equals("nieważna")) {
                return "Pieszo";
            } else {
                return "Rower";
            }
        } else {
            String budzet = askQuestion(scanner,
                    "Jaki jest Twój miesięczny budżet na utrzymanie pojazdu?",
                    "zerowy", "niski", "umiarkowany");

            if (budzet.equals("zerowy")) {
                return "Transport Publiczny";
            } else {
                return "Hulajnoga Elektryczna / Skuter";
            }
        }
    }

    private static String obsluzDlugiDystans(Scanner scanner) {
        String prawoJazdy = askQuestion(scanner,
                "Czy posiadasz prawo jazdy (np. kat. B)?",
                "tak", "nie");

        if (prawoJazdy.equals("nie")) {
            return "Transport Publiczny (Autobus / Pociąg)";
        }

        String ladownosc = askQuestion(scanner,
                "Czy zależy Ci na dużej pojemności ładunkowej?",
                "tak", "nie");

        if (ladownosc.equals("tak")) {
            String rolnik = askQuestion(scanner,
                    "Czy jesteś rolnikiem?",
                    "tak", "nie");

            if (rolnik.equals("tak")) {
                return "Ciągnik";
            } else {
                return "Samochód Dostawczy / Pickup";
            }
        }

        String blokada = askQuestion(scanner,
                "Co robisz, gdy droga jest zablokowana przez stado owiec?",
                "czekam", "objeżdżam polem", "zawracam");

        if (blokada.equals("objeżdżam polem")) {
            return "Samochód Terenowy (SUV 4x4)";
        }

        if (blokada.equals("zawracam")) {
            String dawca = askQuestion(scanner,
                    "Czy planujesz być dawcą organów?",
                    "tak", "nie");

            if (dawca.equals("tak")) {
                return "Motocykl (Sportowy)";
            } else {
                return "Motocykl (Turystyczny / Cruiser)";
            }
        }

        String pasazerowie = askQuestion(scanner,
                "Ilu pasażerów zazwyczaj przewozisz?",
                "0 (solo)", "1-2", "3 lub więcej");

        if (pasazerowie.equals("3 lub więcej")) {
            return "Samochód (Van lub Duży SUV)";
        }

        String budzet = askQuestion(scanner,
                "Jaki jest Twój miesięczny budżet na utrzymanie pojazdu?",
                "niski", "umiarkowany", "wysoki");

        if (budzet.equals("niski")) {
            return "Samochód Osobowy (Ekonomiczny)";
        } else {
            String ekologia = askQuestion(scanner,
                    "Czy zależy Ci na ekologii i niskiej emisji?",
                    "tak", "nie");

            if (ekologia.equals("tak")) {
                return "Samochód Elektryczny lub Hybryda";
            } else {
                return "Samochód Osobowy (Standardowy)";
            }
        }
    }

    private static String askQuestion(Scanner scanner, String prompt, String... options) {
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