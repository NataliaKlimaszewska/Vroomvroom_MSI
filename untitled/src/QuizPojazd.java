import javax.swing.JOptionPane;

public class QuizPojazd {

    public static void main(String[] args) {

        InterfejsUzytkownika mojeUI = new GraficzneUI();

        SilnikQuizu silnik = new SilnikQuizu(mojeUI);

        String rekomendacja = silnik.rozpocznijDiagnostyke();

        JOptionPane.showMessageDialog(
                null,
                "Twoja rekomendacja:\n\n" + rekomendacja,
                "Wynik Diagnostyki",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}