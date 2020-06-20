package com.mangat.mytestapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *
 * Main Activity class
 *
 */

public class MainActivity extends AppCompatActivity {

    /**
     *
     *
     * Initialize parameters
     *
     *
     *
     */
    EditText e1;
    TextView tv;
    TextView history;
    StringBuilder memory = new StringBuilder();
    StringBuilder screenData = new StringBuilder();
    StringBuilder partialEqResult = new StringBuilder();

    /**
     *
     * on create function for the activity
     *
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //update the button names for 10 raise x, x raise y, x square, x cube, x sqrt

        Button btn10x = (Button) findViewById(R.id.button10x);
        btn10x.setText(Html.fromHtml(getResources().getString(R.string.tenx)));

        Button btnxy = findViewById(R.id.buttonxy);
        btnxy.setText(Html.fromHtml(getResources().getString(R.string.xy)));

        Button btnxsq = (Button) findViewById(R.id.buttonsquare);
        btnxsq.setText(Html.fromHtml(getResources().getString(R.string.square)));

        Button btnxcube = (Button) findViewById(R.id.buttoncube);
        btnxcube.setText(Html.fromHtml(getResources().getString(R.string.cube)));

        Button btnpie = (Button) findViewById(R.id.buttonpie);
        btnpie.setText(Html.fromHtml(getResources().getString(R.string.pie)));

        Button btnsqrt = (Button) findViewById(R.id.button_sqrt);
        btnsqrt.setText(Html.fromHtml(getResources().getString(R.string.sqrt)));


        tv = (TextView) findViewById(R.id.tvResult);
        history = (TextView) findViewById(R.id.tvHistory);

    }

    /**
     *
     * Function to create the menu for standard, scientific, programmer menu
     *
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     *
     *
     * Function to handle the option item selection
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

      // switch to user selected calculator
        switch (item.getItemId()) {
            case R.id.action_std:
                show_standard_calculator_option();
                return true;
            case R.id.action_sci:
                show_scientific_calculator_option();
                return true;
            case R.id.action_prg:
                show_programmer_options();
                return true;

        }

        return super.onOptionsItemSelected(item);

    }

    /**
     *
     * Function to show the standard calculator
     *
     *
     */
    protected void show_standard_calculator_option() {

        getSupportActionBar().setTitle("Standard");


        //Programmer button
        findViewById(R.id.buttonHex).setClickable(false);
        findViewById(R.id.buttonOct).setClickable(false);
        findViewById(R.id.buttonBin).setClickable(false);
        findViewById(R.id.buttonDec).setClickable(false);
        findViewById(R.id.button10x).setClickable(false);


        Button b1 = (Button) findViewById(R.id.buttonHex);
        b1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b2 = (Button) findViewById(R.id.buttonOct);
        b2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b3 = (Button) findViewById(R.id.buttonBin);
        b3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b4 = (Button) findViewById(R.id.buttonDec);
        b4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b41 = (Button) findViewById(R.id.button10x);
        b41.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));


        //Scientific button

        findViewById(R.id.buttonln).setClickable(false);
        findViewById(R.id.buttonlog).setClickable(false);
        findViewById(R.id.button10x).setClickable(false);
        findViewById(R.id.buttonxy).setClickable(false);
        findViewById(R.id.buttonmod).setClickable(false);
        findViewById(R.id.buttonabs).setClickable(false);
        findViewById(R.id.buttonpie).setClickable(false);
        findViewById(R.id.buttonexp).setClickable(false);
        findViewById(R.id.buttonmod).setClickable(false);

        Button b5 = (Button) findViewById(R.id.buttonln);
        b5.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b6 = (Button) findViewById(R.id.buttonlog);
        b6.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b7 = (Button) findViewById(R.id.button10x);
        b3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b8 = (Button) findViewById(R.id.buttonxy);
        b8.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b9 = (Button) findViewById(R.id.buttonabs);
        b9.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b10 = (Button) findViewById(R.id.buttonpie);
        b10.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b91 = (Button) findViewById(R.id.buttonexp);
        b91.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b101 = (Button) findViewById(R.id.buttonmod);
        b101.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));


        //Standard button


        findViewById(R.id.buttonsquare).setClickable(true);
        findViewById(R.id.buttoncube).setClickable(true);
        findViewById(R.id.button_1_div_x).setClickable(true);
        findViewById(R.id.buttonDot).setClickable(true);
        findViewById(R.id.button_sqrt).setClickable(true);

        Button b11 = (Button) findViewById(R.id.buttonsquare);
        b11.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b12 = (Button) findViewById(R.id.buttoncube);
        b12.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b13 = (Button) findViewById(R.id.button_1_div_x);
        b13.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b14 = (Button) findViewById(R.id.buttonDot);
        b14.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b15 = (Button) findViewById(R.id.button_sqrt);
        b15.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

    }

    /**
     *
     * Function to show the scientific calculator
     *
     *
     */

    protected void show_scientific_calculator_option() {
        getSupportActionBar().setTitle("Scientific");

        //Programmer button
        findViewById(R.id.buttonHex).setClickable(false);
        findViewById(R.id.buttonDec).setClickable(false);
        findViewById(R.id.buttonOct).setClickable(false);
        findViewById(R.id.buttonBin).setClickable(false);


        Button b1 = (Button) findViewById(R.id.buttonHex);
        b1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b2 = (Button) findViewById(R.id.buttonDec);
        b2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));


        Button b3 = (Button) findViewById(R.id.buttonOct);
        b3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b4 = (Button) findViewById(R.id.buttonBin);
        b4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));


        //Scientific button

        findViewById(R.id.buttonln).setClickable(true);
        findViewById(R.id.buttonlog).setClickable(true);
        findViewById(R.id.button10x).setClickable(true);
        findViewById(R.id.buttonxy).setClickable(true);

        findViewById(R.id.buttonmod).setClickable(true);
        findViewById(R.id.buttonabs).setClickable(true);
        findViewById(R.id.buttonpie).setClickable(true);
        findViewById(R.id.buttonexp).setClickable(true);
        findViewById(R.id.buttonmod).setClickable(true);


        Button b5 = (Button) findViewById(R.id.buttonln);
        b5.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b6 = (Button) findViewById(R.id.buttonlog);
        b6.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b7 = (Button) findViewById(R.id.button10x);
        b7.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b8 = (Button) findViewById(R.id.buttonxy);
        b8.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b9 = (Button) findViewById(R.id.buttonabs);
        b9.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b10 = (Button) findViewById(R.id.buttonpie);
        b10.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b91 = (Button) findViewById(R.id.buttonexp);
        b91.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b101 = (Button) findViewById(R.id.buttonmod);
        b101.setBackgroundColor(getResources().getColor(R.color.numberActionButton));


        //Standard button

        findViewById(R.id.buttonsquare).setClickable(true);
        findViewById(R.id.buttoncube).setClickable(true);
        findViewById(R.id.button_1_div_x).setClickable(true);
        findViewById(R.id.button_sqrt).setClickable(true);
        findViewById(R.id.buttonDot).setClickable(true);

        Button b11 = (Button) findViewById(R.id.buttonsquare);
        b11.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b12 = (Button) findViewById(R.id.buttoncube);
        b12.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b13 = (Button) findViewById(R.id.button_1_div_x);
        b13.setBackgroundColor(getResources().getColor(R.color.numberActionButton));


        Button b14 = (Button) findViewById(R.id.buttonDot);
        b14.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b15 = (Button) findViewById(R.id.button_sqrt);
        b15.setBackgroundColor(getResources().getColor(R.color.numberActionButton));


    }

    /**
     *
     *
     * Function to show the programmer calculator
     *
     *
     */

    protected void show_programmer_options() {
        getSupportActionBar().setTitle("Programmer");

        //Programmer button
        findViewById(R.id.buttonHex).setClickable(true);
        findViewById(R.id.buttonOct).setClickable(true);
        findViewById(R.id.buttonBin).setClickable(true);
        findViewById(R.id.buttonDec).setClickable(true);

        Button b1 = (Button) findViewById(R.id.buttonHex);
        b1.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b2 = (Button) findViewById(R.id.buttonOct);
        b2.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b3 = (Button) findViewById(R.id.buttonBin);
        b3.setBackgroundColor(getResources().getColor(R.color.numberActionButton));

        Button b4 = (Button) findViewById(R.id.buttonDec);
        b4.setBackgroundColor(getResources().getColor(R.color.numberActionButton));


        //Scientific button

        findViewById(R.id.buttonln).setClickable(false);
        findViewById(R.id.buttonlog).setClickable(false);
        findViewById(R.id.button10x).setClickable(false);
        findViewById(R.id.buttonxy).setClickable(false);
        findViewById(R.id.buttonmod).setClickable(false);
        findViewById(R.id.buttonabs).setClickable(false);
        findViewById(R.id.buttonpie).setClickable(false);
        findViewById(R.id.buttonexp).setClickable(false);
        findViewById(R.id.buttonmod).setClickable(false);
        findViewById(R.id.button_sqrt).setClickable(false);


        Button b5 = (Button) findViewById(R.id.buttonln);
        b5.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b6 = (Button) findViewById(R.id.buttonlog);
        b6.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b7 = (Button) findViewById(R.id.button10x);
        b7.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b8 = (Button) findViewById(R.id.buttonxy);
        b8.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b9 = (Button) findViewById(R.id.buttonabs);
        b9.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b10 = (Button) findViewById(R.id.buttonpie);
        b10.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b91 = (Button) findViewById(R.id.buttonexp);
        b91.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b101 = (Button) findViewById(R.id.buttonmod);
        b101.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b102 = (Button) findViewById(R.id.button_sqrt);
        b102.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));


        //Standard button

        findViewById(R.id.buttonsquare).setClickable(false);
        findViewById(R.id.buttoncube).setClickable(false);
        findViewById(R.id.button_1_div_x).setClickable(false);
        findViewById(R.id.buttonDot).setClickable(false);

        Button b11 = (Button) findViewById(R.id.buttonsquare);
        b11.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b12 = (Button) findViewById(R.id.buttoncube);
        b12.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b13 = (Button) findViewById(R.id.button_1_div_x);
        b13.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        Button b14 = (Button) findViewById(R.id.buttonDot);
        b14.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    /**
     *
     * Function to show the numerator pressed by user on the display & history
     *
     *
     *
     * @param view
     */


    public void showNum(View view) {

        Button btn = (Button) view;

        if (!isScreenEmpty()) {
            tv.append(btn.getText());
            history.append(btn.getText());

        } else {
            tv.setText(btn.getText());
            history.setText(btn.getText());
        }

    }

    /**
     *
     * Function to clear the screen
     *
     *
     * @param view
     */

    public void clear(View view) {
        tv.setText("");
        clearHistory();

    }

    /**
     *
     * Function to clear the history
     *
     *
     */

    public void clearHistory() {
        history.setText("");
    }

    /**
     *
     *
     * Function to show the operator selected by the user
     *
     *
     * @param view
     */

    public void showOperator(View view) {
        //check if tv is not empty and last character is a digit
        if (!isScreenEmpty() &&
                (Character.isDigit(tv.getText().charAt(screenData.length() - 1))) ||
                (Character.valueOf(screenData.charAt(screenData.length() - 1)) == Character.valueOf(')'))) {
            Button btn = (Button) view;
            if (btn.getText().equals("mod")) {
                tv.append(" Mod ");
                history.append(" Mod ");
            } else {
                tv.append(" " + btn.getText() + " ");
                history.append(" " + btn.getText() + " ");
            }

        }
    }

    /**
     *
     * Function for delete operation
     *
     *
     * @param view
     */

    public void delete(View view) {
        if (!isScreenEmpty()) {
            //if last character is digit than set tv to length - 1
            if ((Character.isDigit(screenData.charAt((screenData.length() - 1)))) || (screenData.charAt(screenData.length() - 1) == '.')) {
                tv.setText(screenData.substring(0, screenData.length() - 1));
            }
            // if last character is space meaning operand than set tv to length - 3
            else if (Character.isSpaceChar(screenData.charAt(screenData.length() - 1))) {
                tv.setText(screenData.substring(0, screenData.length() - 3));
            }
        }
    }

    /**
     *
     * Function to show signed number
     *
     *
     * @param view
     */

    public void showSign(View view) {

        if (!isScreenEmpty() && Character.isDigit(screenData.charAt(tv.getText().length() - 1))) {
            Double res = 0d;
            Button btn = (Button) view;

            String tmp = "";
            String lastNumber = "";


            String[] tokens = screenData.toString().split(" ");

            // check if the number to apply sign in an equation
            if (tokens.length > 1) {
                for (int i = tokens.length - 1; i >= 0; i--) {
                    if (tokens[i].matches(".*\\d.*")) {


                        ArrayList<String> r = new ArrayList<String>(Arrays.asList(tokens));
                        lastNumber = r.remove(i);
                        tokens = r.toArray(new String[r.size()]);


                        break;

                    }

                }

            } else {
                lastNumber = tokens[0];
            }

            // if single number given & equals to 0 return

            if (lastNumber.equals('0')) {
                return;
            }


            // convert the number back to integer or decimal
            res = -1 * Double.parseDouble(lastNumber);

            if (res % 1 == 0) {
                tmp = String.valueOf((int) Math.floor(res));
            } else {
                DecimalFormat df = new DecimalFormat("#.####");
                tmp = df.format(res);
            }


            // add ( ) for negative numbers
            StringBuilder t = (new StringBuilder(TextUtils.join(" ", tokens)));


            if (res < 0) {
                tmp = "(" + tmp + ")";

            }

            if (tokens.length > 1) {
                t.append(tmp);
                tv.setText(t);
                history.setText(t);
            } else {
                tv.setText(tmp);
                history.setText(tmp);
            }


        }

    }

    /**
     *
     * Function to perform all the calculations on pressing = sign
     *
     *
     *
     * @param view
     */
    public void calculate(View view) {

        Double res = 0d;
        String screeninfo = "";

        if (!isScreenEmpty()) {
            history.append("=");
            // handle the minus sign and subtract operation
            screeninfo = screenData.toString().replaceAll("[\\p{Ps}\\p{Pe}]", "");
            screeninfo = screeninfo.toString().replaceAll("--", "+ ");
            String[] tokens = screeninfo.split(" ");


            Double tmp = 0d;
            Boolean error = false;
            Boolean needToUpdate = true;

            int count = 0;


            //if no operator present, don't perform any operation
            if (tokens.length > 1) {


                for (int i = 0; i < tokens.length; i++) {

                    if (i % 2 == 0) {
                        tmp = Double.parseDouble(tokens[i]);
                    }


                    switch (tokens[i].charAt(0)) {

                        case '+':

                            res = tmp + Double.parseDouble(tokens[i + 1]);


                            i = i + 1;
                            tmp = res;

                            break;
                        case '-':
                            if (tokens[i].length() == 1) {
                                res = tmp - Double.parseDouble(tokens[i + 1]);
                                i = i + 1;
                                tmp = res;


                            }

                            break;
                        case 'x':
                            res = tmp * Double.parseDouble(tokens[i + 1]);
                            i = i + 1;
                            tmp = res;

                            break;
                        case '/':
                            if (Double.parseDouble((tokens[i + 1])) == 0) {
                                tv.setText("cannot divide by zero");
                                error = true;
                                break;
                            }
                            res = tmp / Double.parseDouble(tokens[i + 1]);
                            i = i + 1;
                            tmp = res;

                            break;
                        case '^':
                            calculate_xy(view);

                            needToUpdate = false;
                            break;
                        case 'M':
                            calculate_mod();

                            needToUpdate = false;
                            break;


                    }
                }
            }
            if (!error) {
                formatNumberDisplayHistory(res,true);

                if(needToUpdate)
                {
                    formatNumberDisplay(res);

                }

               // clearHistory();
            }

        }


    }

    /**
     * Function to perform 1 / x
     *
     *
     * @param view
     */
    public void calculate_div_x(View view) {
        if (!isScreenEmpty()) {
            double d = Double.parseDouble(screenData.toString());

            if (d != 0) {
                double res = Math.pow(d, -1);
                formatNumberDisplay(res);
                history.append("=");
                formatNumberDisplayHistory(res,true);
            }
        }
    }

    /**
     *
     * Function to perform square root
     *
     *
     * @param view
     */

    public void calculate_sqrt(View view) {

        int res = calculatepartialeq('R');

        if(res==-1)
        {
            return;
        }

        tv.setText(partialEqResult);
        history.setText(partialEqResult);

    }

    /**
     *
     * Function to add number to memory
     *
     *
     * @param view
     */

    public void addToMemory(View view) {
        if (!isScreenEmpty()) {
            String tmp = screenData.toString().trim();

            Pattern pattern = Pattern.compile("\\d{1,3}(\\.\\d{1,3})?");

            Matcher matcher = pattern.matcher((new StringBuilder(tmp)).reverse());

            if (matcher.find()) {
                StringBuilder str = new StringBuilder(matcher.group(0));

                if (memory.length() > 0) {
                    memory.append(str.reverse());

                } else {
                    memory = str.reverse();
                }

            }

        }

    }

    /**
     *
     * Function to remove from memory
     *
     *
     * @param view
     */

    public void removeFromMemory(View view) {
        if (memory.length() > 0) {
            memory.delete(memory.length() - 2, memory.length() - 1);
        }

    }

    /**
     *
     * Function to clear the memory
     *
     *
     * @param view
     */

    public void clearMemory(View view) {
        if (memory.length() > 0) {
            memory.setLength(0);
        }
    }

    /**
     *
     * Function to recall from memory
     *
     *
     * @param view
     */

    public void recallFromMemory(View view) {
        if (memory.length() > 0) {
            Pattern pattern = Pattern.compile("\\d{1,3}(\\.\\d{1,3})?");

            Matcher matcher = pattern.matcher(memory);
            if (matcher.find()) {
                tv.setText(matcher.group(0));
            }
        }
    }

    /**
     *
     * Function to calculate the hexa decimal value
     *
     *
     * @param view
     */

    public void calculate_hex(View view) {

        if (!isScreenEmpty()) {
            int a = Integer.parseInt(screenData.toString());
            tv.setText(Integer.toHexString(a));
            history.setText(Integer.toHexString(a));
        }

    }
    /**
     *
     * Function to calculate the decimal value
     *
     *
     * @param view
     */
    public void calculate_dec(View view) {
        return;

    }
    /**
     *
     * Function to calculate the octal value
     *
     *
     * @param view
     */
    public void calculate_oct(View view) {
        if (!isScreenEmpty()) {
            int a = Integer.parseInt(screenData.toString());
            tv.setText(Integer.toOctalString(a));
            history.setText(Integer.toOctalString(a));

        }


    }
    /**
     *
     * Function to calculate the binary value
     *
     *
     * @param view
     */

    public void calculate_bin(View view) {
        if (!isScreenEmpty()) {
            int a = Integer.parseInt(screenData.toString());
            tv.setText(Integer.toBinaryString(a));
            history.setText(Integer.toBinaryString(a));
        }

    }
    /**
     *
     * Function to calculate the log e  value
     *
     *
     * @param view
     */

    public void calculate_ln(View view) {
        if (!isScreenEmpty()) {
            double res = Double.parseDouble(screenData.toString());
            res = Math.log(res);

            formatNumberDisplay(res);
            formatNumberDisplayHistory(res);

        }
    }
    /**
     *
     * Function to calculate the log value
     *
     *
     * @param view
     */

    public void calculate_log(View view) {
        if (!isScreenEmpty()) {
            double res = Double.parseDouble(screenData.toString());
            res = Math.log10(res);

            formatNumberDisplay(res);
            formatNumberDisplayHistory(res);

        }
    }
    /**
     *
     * Function to calculate the pow(10,x) value
     *
     *
     * @param view
     */

    public void calculate_10x(View view) {
        if (!isScreenEmpty()) {
            double res = Double.parseDouble(screenData.toString());
            res = Math.pow(10, res);
            formatNumberDisplay(res);
            formatNumberDisplayHistory(res);

        }
    }

    /**
     *
     * Function to calculate the pow(x,y) value
     *
     *
     * @param view
     */
    public void calculate_xy(View view) {

        if (!isScreenEmpty()) {

            String[] tokens = screenData.toString().split(" ");

            int[] positions = new int[2];
            int count = 0;
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].matches(".*\\d.*")) {
                    positions[count++] = i;

                }
            }

            if (count > 1) {
                double a = Double.parseDouble(tokens[positions[0]]);
                double b = Double.parseDouble((tokens[positions[1]]));

                double res = Math.pow(a, b);

                formatNumberDisplay(res);
                formatNumberDisplayHistory(res);
            } else {
                tv.append(" ^ ");
                history.append(" ^ ");
            }


        }
    }

    /**
     *
     * Function to calculate the square
     *
     *
     * @param view
     */

    public void calculate_square(View view) {

        int res = calculatepartialeq('S');

        if(res==-1)
        {
            return;
        }
        tv.setText(partialEqResult);
        history.setText(partialEqResult);

    }
    /**
     *
     * Function to calculate the cube
     *
     *
     * @param view
     */
    public void calculate_cube(View view) {

     int res = calculatepartialeq('C');

     if(res==-1)
     {
         return;
     }
     tv.setText(partialEqResult);
     history.setText(partialEqResult);

    }

    /**
     *
     * Function to calculate the exp value
     *
     *
     * @param view
     */

    public void calculate_exp(View view) {

        if (!isScreenEmpty()) {
            double d = Double.parseDouble(screenData.toString());
            double res = Math.exp(d);

            formatNumberDisplay(res, "%6.4e");
            formatNumberDisplayHistory(res, "%6.4e");

        }

    }
    /**
     *
     * Function to show pie value
     *
     *
     * @param view
     */

    public void calculate_pie(View view) {

        if(!isScreenEmpty())
        {
            formatNumberDisplay(Math.PI,true);
            formatNumberDisplayHistory(Math.PI,true);
        }



    }
    /**
     *
     * Function to show absolute value
     *
     *
     * @param view
     */
    public void calculate_abs(View view) {

        if (!isScreenEmpty()) {
            String tmp = screenData.toString().replaceAll("[\\p{Ps}\\p{Pe}]", "");

            double d = Double.parseDouble(tmp);
            double res = Math.abs(d);

            formatNumberDisplay(res);
            formatNumberDisplayHistory(res,true);

        }
    }
    /**
     *
     * Function to show mod
     *
     */
    public void calculate_mod() {
        if (!isScreenEmpty()) {
            String[] tokens = screenData.toString().split(" ");

            int[] positions = new int[2];
            int count = 0;
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].matches(".*\\d.*")) {
                    positions[count++] = i;

                }
            }

            if (count > 0) {
                double a = Double.parseDouble(tokens[positions[0]]);
                double b = Double.parseDouble((tokens[positions[1]]));
                double res = a % b;

                formatNumberDisplay(res);
                formatNumberDisplayHistory(res,true);
            }


        }

    }
    /**
     *
     * Function to check if the screen is empty or not
     *
     *
     */

    public boolean isScreenEmpty() {
        if (tv.getText().length() > 0) {

            screenData = new StringBuilder(tv.getText().toString());
            return false;
        }
        return true;
    }

    /**
     *
     * Function to format and display history data
     *
     *
     */
    protected void formatNumberDisplayHistory(double res) {
        if (res % 1 == 0) {
            history.setText(String.valueOf((int) Math.floor(res)));
        } else {
            DecimalFormat df = new DecimalFormat("#.####");
            history.setText(df.format(res));
        }
    }
    /**
     *
     * Function to format and display history data
     *
     *
     */
    protected void formatNumberDisplayHistory(String res) {
        history.setText(res);
    }
    /**
     *
     * Function to format and display history data with given format
     *
     *
     */
    protected void formatNumberDisplayHistory(double res, String format) {
        if (res % 1 == 0) {
            tv.setText(String.valueOf((int) Math.floor(res)));
        } else {
            tv.setText(String.format(format, res));
        }
    }
    /**
     *
     * Function to format and append history data
     *
     *
     */

    protected void formatNumberDisplayHistory(double res,Boolean append) {

        StringBuilder t;
        if (res % 1 == 0) {
            t = new StringBuilder(String.valueOf((int) Math.floor(res)));
        } else {
            DecimalFormat df = new DecimalFormat("#.####");
            t = new StringBuilder(df.format(res));
        }

        if(append)
        {
            history.append(t);
        }
    }
    /**
     *
     * Function to format and display screen data
     *
     *
     */

    protected void formatNumberDisplay(double res) {
        if (res % 1 == 0) {
            tv.setText(String.valueOf((int) Math.floor(res)));
        } else {
            DecimalFormat df = new DecimalFormat("#.####");
            tv.setText(df.format(res));
        }
    }

    /**
     *
     * Function to format and display append screen data
     *
     *
     */
    protected void formatNumberDisplay(double res,Boolean append) {

        StringBuilder t;
        if (res % 1 == 0) {
            t = new StringBuilder(String.valueOf((int) Math.floor(res)));
        } else {
            DecimalFormat df = new DecimalFormat("#.####");
            t = new StringBuilder(df.format(res));
        }

        if(append)
        {
            tv.append(t);
        }
    }


    /**
     *
     * Function to format and display screen data with given format
     *
     *
     */

    protected void formatNumberDisplay(double res, String format) {
        if (res % 1 == 0) {
            tv.setText(String.valueOf((int) Math.floor(res)));
        } else {
            tv.setText(String.format(format, res));
        }
    }

    /**
     *
     * Function to calculate partial equation
     *
     *
     * @param op
     * @return
     */

    protected int calculatepartialeq(char op) {
        partialEqResult = new StringBuilder();

        if (!isScreenEmpty()) {

            String[] tokens = screenData.toString().split(" ");
            double res = 0d;

            int[] positions = new int[2];
            int count = 0;
            String lastNumber = "";

            if (tokens.length > 1) {
                for (int i = tokens.length - 1; i >= 0; i--) {
                    if (tokens[i].matches(".*\\d.*")) {
                        ArrayList<String> r = new ArrayList<String>(Arrays.asList(tokens));
                        lastNumber = r.remove(i);
                        tokens = r.toArray(new String[r.size()]);
                        break;


                    }
                }
            } else {
                lastNumber = tokens[0];
            }

            if (lastNumber.equals("0")) {
                return -1;
            }
            //calculate square

            if (op == 'S') {
                double b = Double.parseDouble(lastNumber);

                res = Math.pow(b, 2);

            }
            //calculate cube
            else if (op == 'C') {
                double b = Double.parseDouble(lastNumber);

                res = Math.pow(b, 3);

            }
            // calculate square root
            else if (op == 'R') {
                double b = Double.parseDouble(lastNumber);

                res = Math.sqrt(b);

            }

            if(tokens.length>1)
            {
                partialEqResult = (new StringBuilder(TextUtils.join(" ", tokens)));

                if (res % 1 == 0) {
                    partialEqResult.append(" " + String.valueOf((int) Math.floor(res)));
                } else {
                    DecimalFormat df = new DecimalFormat("#.####");
                    partialEqResult.append(" " + df.format(res));
                }


            }
            else
            {
                if (res % 1 == 0) {
                    partialEqResult = new StringBuilder(String.valueOf((int) Math.floor(res)));
                } else {
                    DecimalFormat df = new DecimalFormat("#.####");

                    partialEqResult = new StringBuilder(df.format(res));
                }
            }




        }
        return 1;
    }
}

