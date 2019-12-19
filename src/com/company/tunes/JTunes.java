package com.company.tunes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JTunes extends JFrame implements ItemListener {
    private JComboBox cmbxTunes = new JComboBox();
    private JLabel lblPrice = new JLabel("Price: 0.00");

    public JTunes() throws HeadlessException {
        super();
        // Main Window
        setTitle("Tunes");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tunes
        cmbxTunes.addItem("Song 1");
        cmbxTunes.addItem("Song 2");
        cmbxTunes.addItem("Song 3");
        cmbxTunes.addItem("Song 4");
        cmbxTunes.addItem("Song 5");
        cmbxTunes.addItem("Song 6");
        cmbxTunes.addItem("Song 7");
        cmbxTunes.addItem("Song 8");
        cmbxTunes.addItem("Song 9");
        cmbxTunes.addItem("Song 10");
        cmbxTunes.addItem("Song 11");
        cmbxTunes.addItem("Song 12");
        cmbxTunes.addItemListener(this);
        add(cmbxTunes);

        // Price
        add(lblPrice);

        // Show The Window
        pack();
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        switch(cmbxTunes.getSelectedItem().toString()) {
            case "Song 1": lblPrice.setText("Price: 999.99"); break;
            case "Song 2": lblPrice.setText("Price: 899.99"); break;
            case "Song 3": lblPrice.setText("Price: 799.99"); break;
            case "Song 4": lblPrice.setText("Price: 699.99"); break;
            case "Song 5": lblPrice.setText("Price: 599.99"); break;
            case "Song 6": lblPrice.setText("Price: 499.99"); break;
            case "Song 7": lblPrice.setText("Price: 399.99"); break;
            case "Song 8": lblPrice.setText("Price: 299.99"); break;
            case "Song 9": lblPrice.setText("Price: 199.99"); break;
            case "Song 10": lblPrice.setText("Price: 99.99"); break;
            case "Song 11": lblPrice.setText("Price: 89.99"); break;
            case "Song 12": lblPrice.setText("Price: 79.99"); break;
            default: lblPrice.setText("Price: 0.00");
        }

        pack();
    }

    public static void main(String[] args) {
        JTunes window = new JTunes();
    }
}
