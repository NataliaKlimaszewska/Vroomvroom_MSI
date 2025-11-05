public class SilnikQuizu {

    private InterfejsUzytkownika ui;

    public SilnikQuizu(InterfejsUzytkownika ui) {
        this.ui = ui;
    }

    public String rozpocznijDiagnostyke() {
        String uzaleznienie = ui.zadajPytanie(
                "Czy jesteś uzależniony od substancji odurzających?",
                "tak", "nie", "zalezy kto pyta");

        if (uzaleznienie.equals("tak") || uzaleznienie.equals("zalezy kto pyta")) {
            return "Transport Publiczny lub Pieszo (Prosimy nie prowadzić!)";
        }

        String dystans = ui.zadajPytanie(
                "Jaka jest typowa odległość, jaką musisz pokonać w jedną stronę?",
                "krótka (< 10km)", "długa (> 10km)");

        if (dystans.equals("krótka (< 10km)")) {
            return obsluzKrotkiDystans();
        } else {
            return obsluzDlugiDystans();
        }
    }

    private String obsluzKrotkiDystans() {
        String aktywnyTryb = ui.zadajPytanie(
                "Czy prowadzisz aktywny tryb życia?",
                "tak", "nie");

        if (aktywnyTryb.equals("tak")) {
            String pogoda = ui.zadajPytanie(
                    "Jak ważna jest dla Ciebie niezależność od warunków pogodowych?",
                    "ważna", "nieważna");

            if (pogoda.equals("nieważna")) {
                return "Pieszo";
            } else {
                return "Rower";
            }
        } else {
            String budzet = ui.zadajPytanie(
                    "Jaki jest Twój miesięczny budżet na utrzymanie pojazdu?",
                    "zerowy", "niski", "umiarkowany");

            if (budzet.equals("zerowy")) {
                return "Transport Publiczny";
            } else {
                return "Hulajnoga Elektryczna / Skuter";
            }
        }
    }

    private String obsluzDlugiDystans() {
        String prawoJazdy = ui.zadajPytanie(
                "Czy posiadasz prawo jazdy (np. kat. B)?",
                "tak", "nie");

        if (prawoJazdy.equals("nie")) {
            return "Transport Publiczny (Autobus / Pociąg)";
        }

        String ladownosc = ui.zadajPytanie(
                "Czy zależy Ci na dużej pojemności ładunkowej?",
                "tak", "nie");

        if (ladownosc.equals("tak")) {
            String rolnik = ui.zadajPytanie(
                    "Czy jesteś rolnikiem?",
                    "tak", "nie");

            if (rolnik.equals("tak")) {
                return "Ciągnik";
            } else {
                return "Samochód Dostawczy / Pickup";
            }
        }

        String blokada = ui.zadajPytanie(
                "Co robisz, gdy droga jest zablokowana przez stado owiec?",
                "czekam", "objeżdżam polem", "zawracam");

        if (blokada.equals("objeżdżam polem")) {
            return "Samochód Terenowy (SUV 4x4)";
        }

        if (blokada.equals("zawracam")) {
            String dawca = ui.zadajPytanie(
                    "Czy planujesz być dawcą organów?",
                    "tak", "nie");

            if (dawca.equals("tak")) {
                return "Motocykl (Sportowy)";
            } else {
                return "Motocykl (Turystyczny / Cruiser)";
            }
        }

        String pasazerowie = ui.zadajPytanie(
                "Ilu pasażerów zazwyczaj przewozisz?",
                "0 (solo)", "1-2", "3 lub więcej");

        if (pasazerowie.equals("3 lub więcej")) {
            return "Samochód (Van lub Duży SUV)";
        }

        String budzet = ui.zadajPytanie(
                "Jaki jest Twój miesięczny budżet na utrzymanie pojazdu?",
                "niski", "umiarkowany", "wysoki");

        if (budzet.equals("niski")) {
            return "Samochód Osobowy (Ekonomiczny)";
        } else {
            String ekologia = ui.zadajPytanie(
                    "Czy zależy Ci na ekologii i niskiej emisji?",
                    "tak", "nie");

            if (ekologia.equals("tak")) {
                return "Samochód Elektryczny lub Hybryda";
            } else {
                return "Samochód Osobowy (Standardowy)";
            }
        }
    }
}