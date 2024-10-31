package src;

import java.awt.*;
import javax.swing.*;

public class TemperatureConverterGUI extends JFrame {
    private JTextField temperatureField;
    private JComboBox<String> unitComboBox;
    private JLabel resultLabel;

    public TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Création du panel principal avec un fond gris foncé
        JPanel contentPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        contentPanel.setBackground(new Color(51, 51, 51)); // Gris foncé
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Labels en blanc
        JLabel tempLabel = new JLabel("Temperature:");
        tempLabel.setForeground(Color.WHITE);
        contentPanel.add(tempLabel);

        // Champ de température
        temperatureField = new JTextField();
        contentPanel.add(temperatureField);

        // Label pour l'unité en blanc
        JLabel unitLabel = new JLabel("Unit:");
        unitLabel.setForeground(Color.WHITE);
        contentPanel.add(unitLabel);

        // Combo box pour les unités
        unitComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        contentPanel.add(unitComboBox);

        // Label pour le résultat en blanc
        JLabel convertedLabel = new JLabel("Converted Temperature:");
        convertedLabel.setForeground(Color.WHITE);
        contentPanel.add(convertedLabel);

        // Label pour afficher le résultat en blanc
        resultLabel = new JLabel();
        resultLabel.setForeground(Color.WHITE);
        contentPanel.add(resultLabel);

        // Bouton de conversion
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(e -> convertTemperature());
        
        // Panel pour le bouton
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(51, 51, 51)); // Même gris foncé
        buttonPanel.add(convertButton);

        // Ajout des panels au frame
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void convertTemperature() {
        try {
            double temperature = Double.parseDouble(temperatureField.getText());
            String selectedUnit = (String) unitComboBox.getSelectedItem();

            double convertedTempC = 0;
            double convertedTempF = 0;
            double convertedTempK = 0;

            switch (selectedUnit) {
                case "Celsius":
                    convertedTempC = temperature;
                    convertedTempF = (temperature * 9 / 5) + 32;
                    convertedTempK = temperature + 273.15;
                    break;
                case "Fahrenheit":
                    convertedTempC = (temperature - 32) * 5 / 9;
                    convertedTempF = temperature;
                    convertedTempK = (temperature - 32) * 5 / 9 + 273.15;
                    break;
                case "Kelvin":
                    convertedTempC = temperature - 273.15;
                    convertedTempF = (temperature - 273.15) * 9 / 5 + 32;
                    convertedTempK = temperature;
                    break;
            }

            resultLabel.setText(String.format("%.2f°C = %.2f°F = %.2fK", 
                convertedTempC, convertedTempF, convertedTempK));

        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number");
        }
    }
}