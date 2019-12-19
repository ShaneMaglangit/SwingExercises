package com.company.vacation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JVacationRental extends JFrame implements ActionListener{
    // Const
    private final double PARKSIDE_PRICE = 600;
    private final double POOLSIDE_PRICE = 750;
    private final double LAKESIDE_PRICE = 825;
    private final double ROOM_PRICE = 150;
    private final double MEAL_PRICE = 200;

    // Location Components
    private JPanel pnlLocation = new JPanel();
    private JLabel lblLocation = new JLabel("Location");
    private ButtonGroup bgLocation = new ButtonGroup();
    private JRadioButton rbtnParkside = new JRadioButton("Parkside");
    private JRadioButton rbtnPoolside = new JRadioButton("Poolside");
    private JRadioButton rbtnLakeside = new JRadioButton("Lakeside");

    // Bedroom Components
    private JPanel pnlBedroom = new JPanel();
    private JLabel lblBedroom = new JLabel("Bedrooms");
    private ButtonGroup bgBedroomCount = new ButtonGroup();
    private JRadioButton rbtnOneBedroom = new JRadioButton("One");
    private JRadioButton rbtnTwoBedroom = new JRadioButton("Two");
    private JRadioButton rbtnThreeBedroom = new JRadioButton("Three");

    // Meal Components
    private JPanel pnlMeals = new JPanel();
    private JLabel lblMeals = new JLabel("Include Meals");
    private ButtonGroup bgMeal = new ButtonGroup();
    private JRadioButton rbtnWithMeal = new JRadioButton("Yes");
    private JRadioButton rbtnNoMeal = new JRadioButton("No");

    // Total Components
    private JLabel lblCost = new JLabel();

    // Other Components
    private JButton btnRent = new JButton("Rent");

    public JVacationRental() throws HeadlessException {
        super();
        // Main Window
        setTitle("Vacation Rental");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Location
        pnlLocation.setLayout(new BoxLayout(pnlLocation, BoxLayout.Y_AXIS));
        pnlLocation.add(lblLocation);
        pnlLocation.add(rbtnParkside);
        pnlLocation.add(rbtnPoolside);
        pnlLocation.add(rbtnLakeside);
        bgLocation.add(rbtnParkside);
        bgLocation.add(rbtnPoolside);
        bgLocation.add(rbtnLakeside);
        this.add(pnlLocation);

        // Bedroom
        pnlBedroom.setLayout(new BoxLayout(pnlBedroom, BoxLayout.Y_AXIS));
        pnlBedroom.add(lblBedroom);
        pnlBedroom.add(rbtnOneBedroom);
        pnlBedroom.add(rbtnTwoBedroom);
        pnlBedroom.add(rbtnThreeBedroom);
        bgBedroomCount.add(rbtnOneBedroom);
        bgBedroomCount.add(rbtnTwoBedroom);
        bgBedroomCount.add(rbtnThreeBedroom);
        this.add(pnlBedroom);

        // Meals
        pnlMeals.setLayout(new BoxLayout(pnlMeals, BoxLayout.Y_AXIS));
        pnlMeals.add(lblMeals);
        pnlMeals.add(rbtnWithMeal);
        pnlMeals.add(rbtnNoMeal);
        pnlMeals.add(btnRent);
        bgMeal.add(rbtnWithMeal);
        bgMeal.add(rbtnNoMeal);
        this.add(pnlMeals);

        // Listeners
        btnRent.addActionListener(this);

        // Show The Window
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double totalCost = 0;

        if(rbtnParkside.isSelected()) totalCost += PARKSIDE_PRICE;
        else if(rbtnPoolside.isSelected()) totalCost += POOLSIDE_PRICE;
        else if(rbtnLakeside.isSelected()) totalCost += LAKESIDE_PRICE;

        if(rbtnOneBedroom.isSelected()) {
            if(rbtnWithMeal.isSelected()) totalCost += ROOM_PRICE + MEAL_PRICE;
            else totalCost += ROOM_PRICE;
        } else if(rbtnTwoBedroom.isSelected()) {
            if(rbtnWithMeal.isSelected()) totalCost += ROOM_PRICE + MEAL_PRICE * 2;
            else totalCost += ROOM_PRICE * 2;
        } else if(rbtnThreeBedroom.isSelected()) {
            if(rbtnWithMeal.isSelected()) totalCost += ROOM_PRICE + MEAL_PRICE * 3;
            else totalCost += ROOM_PRICE * 3;
        }

        JOptionPane.showMessageDialog(null, String.format("Total Rent Cost: %.2f", totalCost));
    }

    public static void main(String[] args) {
        JVacationRental window = new JVacationRental();
    }
}
