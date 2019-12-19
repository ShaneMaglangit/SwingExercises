package com.company.dorm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JDorm2 extends JFrame implements ItemListener {
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

    // Selected
    private JTextArea txtaSelected = new JTextArea();
    private JScrollPane spSelected = new JScrollPane(txtaSelected);

    public JDorm2() throws HeadlessException {
        super();
        // Main Window
        setTitle("Dorm");
        setLayout(new GridLayout(1, 3, 2, 2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Options
        pnlOptions.setLayout(new BoxLayout(pnlOptions, BoxLayout.Y_AXIS));
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
        txtaUnselected.setBackground(Color.LIGHT_GRAY);
        txtaUnselected.setEditable(false);
        this.add(txtaUnselected);

        // Selected
        txtaSelected.setBackground(Color.LIGHT_GRAY);
        txtaSelected.setEditable(false);
        this.add(spSelected);

        // Listener
        cbxPrivate.addItemListener(this);
        cbxCable.addItemListener(this);
        cbxInternet.addItemListener(this);
        cbxFridge.addItemListener(this);
        cbxMicrowave.addItemListener(this);
        cbxSwimmingPool.addItemListener(this);

        // Show The Window
        setSelectedTextArea();
        setUnselectedTextArea();
        pack();
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        setUnselectedTextArea();
        setSelectedTextArea();
    }

    private void setSelectedTextArea() {
        String tempText = "Selected Options:";

        if(cbxPrivate.isSelected()) tempText += "\n" + PRIVATE;
        if(cbxInternet.isSelected()) tempText += "\n" + INTERNET;
        if(cbxCable.isSelected()) tempText += "\n" + CABLE;
        if(cbxFridge.isSelected()) tempText += "\n" + FRIDGE;
        if(cbxMicrowave.isSelected()) tempText += "\n" + MICROWAVE;
        if(cbxSwimmingPool.isSelected()) tempText += "\n" + POOL;

        txtaSelected.setText(tempText);
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
        JDorm2 window = new JDorm2();
    }
}
