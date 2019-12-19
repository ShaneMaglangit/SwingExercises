package com.company.insurance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JInsurance extends JFrame implements ItemListener {
    // Const
    private JPanel pnlInsurance = new JPanel();
    private final String HMO = "Health Maintenance Organization";
    private final String PPO = "Preferred Provider Organization";
    private final String DENTAL = "Dental Coverage";
    private final String VISION = "Vision Care";
    private final double HMO_PRICE = 1200.00;
    private final double PPO_PRICE = 1200.00;
    private final double DENTAL_PRICE = 1200.00;
    private final double VISION_PRICE = 1200.00;

    // Insurance Types
    private JLabel lblType = new JLabel("Insurance Type");
    private ButtonGroup bgType = new ButtonGroup();
    private JCheckBox cbxHmo = new JCheckBox("HMO");
    private JCheckBox cbxPpo = new JCheckBox("PPO");
    private JLabel lblOtherCoverage = new JLabel("Other Coverage");
    private JCheckBox cbxDental = new JCheckBox("Dental Insurance");
    private JCheckBox cbxVision = new JCheckBox("Vision Insurance");

    // Cost
    private JPanel pnlCost = new JPanel();
    private JLabel lblName = new JLabel("Name:");
    private JLabel lblPrice = new JLabel("Price:");

    public JInsurance() throws HeadlessException {
        super();
        // Main Window
        setTitle("Insurance");
        setSize(215, 220);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Insurance Options
        pnlInsurance.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlInsurance.setLayout(new BoxLayout(pnlInsurance, BoxLayout.Y_AXIS));
        bgType.add(cbxHmo);
        bgType.add(cbxPpo);
        pnlInsurance.add(lblType);
        pnlInsurance.add(cbxHmo);
        pnlInsurance.add(cbxPpo);
        pnlInsurance.add(lblOtherCoverage);
        pnlInsurance.add(cbxDental);
        pnlInsurance.add(cbxVision);
        this.add(pnlInsurance);

        // Cost
        pnlCost.setLayout(new BoxLayout(pnlCost, BoxLayout.Y_AXIS));
        pnlCost.setBackground(Color.LIGHT_GRAY);
        pnlCost.setPreferredSize(new Dimension(190, 50));
        pnlCost.add(lblName);
        pnlCost.add(lblPrice);
        this.add(pnlCost);

        // Listeners
        cbxHmo.addItemListener(this);
        cbxPpo.addItemListener(this);
        cbxDental.addItemListener(this);
        cbxVision.addItemListener(this);

        // Show The Window
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            if(e.getSource() == cbxHmo) {
                lblName.setText(HMO);
                lblPrice.setText(String.format("PHP%.2f per month", HMO_PRICE));
            } else if (e.getSource() == cbxPpo) {
                lblName.setText(PPO);
                lblPrice.setText(String.format("PHP%.2f per month", PPO_PRICE));
            } else if (e.getSource() == cbxDental) {
                lblName.setText(DENTAL);
                lblPrice.setText(String.format("PHP%.2f per month", DENTAL_PRICE));
            } else if(e.getSource() == cbxVision) {
                lblName.setText(VISION);
                lblPrice.setText(String.format("PHP%.2f per month", VISION_PRICE));
            }
        } else {
            lblName.setText("");
            lblPrice.setText("");
        }
    }

    public static void main(String[] args) {
        JInsurance window = new JInsurance();
    }
}
