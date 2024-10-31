package src;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureConverterGUI converter = new TemperatureConverterGUI();
            converter.setVisible(true);
        });
    }
}