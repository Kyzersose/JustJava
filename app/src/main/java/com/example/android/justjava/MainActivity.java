package com.example.android.justjava;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        boolean hasWhippedCream = ((CheckBox) findViewById(R.id.whipped_cream_checkbox)).isChecked();
        boolean hasChocolate = ((CheckBox) findViewById(R.id.chocolate_checkbox)).isChecked();
        String priceMessage = createOrderSummary(calculatePrice(), hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    /**
     * Creates a summary of the order
     *
     * @param orderTotal        number passed should be the quantity
     * @param whippedCreamCheck tells whether the checkbox is checked
     * @param chocolateCheck    passes the state of the chocolate checkbox
     * @return String with order summary
     */
    private String createOrderSummary(int orderTotal, boolean whippedCreamCheck, boolean chocolateCheck) {
        String priceMessage = "Name: Sarah Shaeffer";
        priceMessage += "\nAdd whipped cream? " + whippedCreamCheck;
        priceMessage += "\nAdd chocolate? " + chocolateCheck;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + orderTotal;        ;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * Calculates the price of the order.
     *
     * @return returns the total price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    //This method is called when the + button is pressed
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    //This method is called with the - button is pressed
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}