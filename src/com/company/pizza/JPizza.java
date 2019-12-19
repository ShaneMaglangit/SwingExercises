package com.company.pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JPizza extends JFrame implements ItemListener {
    // Conts
    private final double PIZZA_SMALL_PRICE = 75;
    private final double PIZZA_MEDIUM_PRICE = 95;
    private final double PIZZA_LARGE_PRICE = 120;
    private final double PIZZA_EXTRALARGE_PRICE = 180;
    private final double TOPPINGS_PRICE = 40;

    // Size
    private JPanel pnlSize = new JPanel();
    private JLabel lblSize = new JLabel("Size");
    private ButtonGroup bgSize = new ButtonGroup();
    private JRadioButton rbtnSmall = new JRadioButton("Small");
    private JRadioButton rbtnMedium = new JRadioButton("Medium");
    private JRadioButton rbtnLarge = new JRadioButton("Large");
    private JRadioButton rbtnExtraLarge = new JRadioButton("Extra Large");

    // Topping
    private JPanel pnlToppings = new JPanel();
    private JLabel lblTopping = new JLabel("Toppings");
    private JLabel lblPlaceholder = new JLabel("");
    private JCheckBox cbxBacon = new JCheckBox("Bacon");
    private JCheckBox cbxHam = new JCheckBox("Ham");
    private JCheckBox cbxPineapple = new JCheckBox("Pineapple");
    private JCheckBox cbxMushroom = new JCheckBox("Mushroom");
    private JCheckBox cbxPepperoni = new JCheckBox("Pepperoni");
    private JCheckBox cbxOlives = new JCheckBox("Olives");
    private JCheckBox cbxPepper = new JCheckBox("Pepper");
    private JCheckBox cbxCheese = new JCheckBox("Cheese");

    // Checkout
    private JPanel pnlCheckout = new JPanel();
    private JLabel lblCheckout = new JLabel("Checkout Price");
    private JLabel lblPrice = new JLabel("0.00");

    public JPizza() throws HeadlessException {
        super();
        // Main Window
        setTitle("Pizza");
        setLayout(new GridLayout(1, 3));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Size
        pnlSize.setLayout(new BoxLayout(pnlSize, BoxLayout.Y_AXIS));
        pnlSize.add(lblSize);
        pnlSize.add(rbtnSmall);
        pnlSize.add(rbtnMedium);
        pnlSize.add(rbtnLarge);
        pnlSize.add(rbtnExtraLarge);
        bgSize.add(rbtnSmall);
        bgSize.add(rbtnMedium);
        bgSize.add(rbtnLarge);
        bgSize.add(rbtnExtraLarge);
        this.add(pnlSize);

        // Topping
        pnlToppings.setLayout(new GridLayout(5, 2));
        pnlToppings.add(lblTopping);
        pnlToppings.add(lblPlaceholder);
        pnlToppings.add(cbxBacon);
        pnlToppings.add(cbxHam);
        pnlToppings.add(cbxPepperoni);
        pnlToppings.add(cbxMushroom);
        pnlToppings.add(cbxPineapple);
        pnlToppings.add(cbxPepper);
        pnlToppings.add(cbxOlives);
        pnlToppings.add(cbxCheese);
        this.add(pnlToppings);

        // Checkout
        pnlCheckout.setLayout(new BoxLayout(pnlCheckout, BoxLayout.Y_AXIS));
        pnlCheckout.setBackground(Color.LIGHT_GRAY);
        pnlCheckout.add(lblCheckout);
        pnlCheckout.add(lblPrice);
        this.add(pnlCheckout);

        // Listener
        rbtnSmall.addItemListener(this);
        rbtnMedium.addItemListener(this);
        rbtnLarge.addItemListener(this);
        rbtnExtraLarge.addItemListener(this);
        cbxBacon.addItemListener(this);
        cbxCheese.addItemListener(this);
        cbxHam.addItemListener(this);
        cbxMushroom.addItemListener(this);
        cbxOlives.addItemListener(this);
        cbxPepper.addItemListener(this);
        cbxPepperoni.addItemListener(this);
        cbxPineapple.addItemListener(this);

        // Modification
        lblSize.setAlignmentX(Component.CENTER_ALIGNMENT);
        rbtnSmall.setAlignmentX(Component.CENTER_ALIGNMENT);
        rbtnMedium.setAlignmentX(Component.CENTER_ALIGNMENT);
        rbtnLarge.setAlignmentX(Component.CENTER_ALIGNMENT);
        rbtnExtraLarge.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblCheckout.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPrice.setFont(new Font("Arial", Font.BOLD, 50));

        // Show The Window
        pack();
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        double cost = 0;

        if(rbtnSmall.isSelected()) cost += PIZZA_SMALL_PRICE;
        else if(rbtnMedium.isSelected()) cost += PIZZA_MEDIUM_PRICE;
        else if(rbtnLarge.isSelected()) cost += PIZZA_LARGE_PRICE;
        else if(rbtnExtraLarge.isSelected()) cost += PIZZA_EXTRALARGE_PRICE;

        if(cbxPineapple.isSelected()) cost += TOPPINGS_PRICE;
        if(cbxPepperoni.isSelected()) cost += TOPPINGS_PRICE;
        if(cbxPepper.isSelected()) cost += TOPPINGS_PRICE;
        if(cbxOlives.isSelected()) cost += TOPPINGS_PRICE;
        if(cbxMushroom.isSelected()) cost += TOPPINGS_PRICE;
        if(cbxHam.isSelected()) cost += TOPPINGS_PRICE;
        if(cbxBacon.isSelected()) cost += TOPPINGS_PRICE;

        lblPrice.setText(String.format("%.2f", cost));
    }

    public static void main(String[] args) {
        JPizza window = new JPizza();
    }
}
