import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;

public class GraficzneUI implements InterfejsUzytkownika {

    public GraficzneUI() {
        ustawWiekszaCzcionke();
    }

    @Override
    public String zadajPytanie(String prompt, String... options) {
        int wybor = JOptionPane.showOptionDialog(
                null,
                prompt,
                "Pytanie od Doradcy",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );


        if (wybor == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }

        return options[wybor];
    }

    private void ustawWiekszaCzcionke() {

        try {
            UIManager.put("Label.font", new FontUIResource(new Font("SansSerif", Font.PLAIN, 16)));
            UIManager.put("Button.font", new FontUIResource(new Font("SansSerif", Font.PLAIN, 16)));
            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("SansSerif", Font.PLAIN, 16)));
            UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("SansSerif", Font.PLAIN, 16)));
        } catch (Exception e) {
            System.err.println("Nie udało się ustawić czcionki: " + e.getMessage());
        }
    }
}