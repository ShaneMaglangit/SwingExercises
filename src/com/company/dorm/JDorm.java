package com.company.dorm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JDorm extends JFrame implements ItemListener {
    // Const
    private final String PRIVATE = "Private";
    private final String INTERNET = "Internet Connection";
    private final String CABLE = "TV Cable Connection";
    private final String FRIDGE = "Fridge";
    private final String MICROWAVE = "Microwave";
    private final String POOL = "Swimming Pool";

    // Options
    private JPanel pnlOptions = new JPanel();
    private JLabel lblOptions = new JLabel("Dormitory Options");
    private JCheckBox cbxPrivate = new JCheckBox(PRIVATE);
    private JCheckBox cbxInternet = new JCheckBox(INTERNET);
    private JCheckBox cbxCable = new JCheckBox(CABLE);
    private JCheckBox cbxFridge = new JCheckBox(FRIDGE);
    private JCheckBox cbxMicrowave = new JCheckBox(MICROWAVE);
    private JCheckBox cbxSwimmingPool = new JCheckBox(POOL);

    // Unselected
    private JTextArea txtaUnselected = new JTextArea();

    // Log
    private JTextArea txtaLog = new JTextArea();
    private JScrollPane spLog = new JScrollPane(txtaLog);

    public JDorm() throws HeadlessException {
        super();
        // Main Window
        setTitle("Dorm");
        setLayout(new GridLayout(3, 1));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Options
        pnlOptions.setLayout(new GridLayout(4, 2, 2, 2));
        pnlOptions.add(lblOptions);
        pnlOptions.add(new JLabel());
        pnlOptions.add(cbxPrivate);
        pnlOptions.add(cbxInternet);
        pnlOptions.add(cbxCable);
        pnlOptions.add(cbxFridge);
        pnlOptions.add(cbxMicrowave);
        pnlOptions.add(cbxSwimmingPool);
        this.add(pnlOptions);

        // Unselected
        setUnselectedTextArea();
        txtaUnselected.setBackground(Color.LIGHT_GRAY);
        txtaUnselected.setEditable(false);
        this.add(txtaUnselected);

        // Log
        txtaLog.setBackground(Color.LIGHT_GRAY);
        txtaLog.setEditable(false);
        this.add(spLog);

        // Listener
        cbxPrivate.addItemListener(this);
        cbxCable.addItemListener(this);
        cbxInternet.addItemListener(this);
        cbxFridge.addItemListener(this);
        cbxMicrowave.addItemListener(this);
        cbxSwimmingPool.addItemListener(this);

        // Show The Window
        pack();
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();

        if(e.getStateChange() == ItemEvent.SELECTED) {
            if(source == cbxPrivate) txtaLog.append("Selected " + PRIVATE + "\n");
            else if (source == cbxInternet) txtaLog.append("Selected " + INTERNET + "\n");
            else if (source == cbxCable) txtaLog.append("Selected " + CABLE + "\n");
            else if (source == cbxFridge) txtaLog.append("Selected " + FRIDGE + "\n");
            else if (source == cbxMicrowave) txtaLog.append("Selected " + MICROWAVE + "\n");
            else if (source == cbxSwimmingPool) txtaLog.append("Selected " + POOL + "\n");
        } else if(e.getStateChange() == ItemEvent.DESELECTED) {
            if(source == cbxPrivate) txtaLog.append("Deselected " + PRIVATE + "\n");
            else if (source == cbxInternet) txtaLog.append("Deselected " + INTERNET + "\n");
            else if (source == cbxCable) txtaLog.append("Deselected " + CABLE + "\n");
            else if (source == cbxFridge) txtaLog.append("Deselected " + FRIDGE + "\n");
            else if (source == cbxMicrowave) txtaLog.append("Deselected " + MICROWAVE + "\n");
            else if (source == cbxSwimmingPool)txtaLog.append("Deselected " + POOL + "\n");
        }

        setUnselectedTextArea();
    }

    private void setUnselectedTextArea() {
        String tempText = "Unselected Options:";

        if(!cbxPrivate.isSelected()) tempText += "\n" + PRIVATE;
        if(!cbxInternet.isSelected()) tempText += "\n" + INTERNET;
        if(!cbxCable.isSelected()) tempText += "\n" + CABLE;
        if(!cbxFridge.isSelected()) tempText += "\n" + FRIDGE;
        if(!cbxMicrowave.isSelected()) tempText += "\n" + MICROWAVE;
        if(!cbxSwimmingPool.isSelected()) tempText += "\n" + POOL;

        txtaUnselected.setText(tempText);
    }

    public static void main(String[] args) {
        JDorm window = new JDorm();
    }
}
