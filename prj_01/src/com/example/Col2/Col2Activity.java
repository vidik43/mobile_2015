package com.example.Col2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Col2Activity extends Activity {
    boolean isdotclicked = false;
    TextView t1, t2, s;
    Button one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, plmin, multi, dev, c, del, eq, dot, avtor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        s = (TextView) findViewById(R.id.sign);
        t1.setText("0");
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        c = (Button) findViewById(R.id.C);
        del = (Button) findViewById(R.id.del);
        zero = (Button) findViewById(R.id.zero);
        dot = (Button) findViewById(R.id.dot);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        plmin = (Button) findViewById(R.id.plmin);
        multi = (Button) findViewById(R.id.multi);
        dev = (Button) findViewById(R.id.dev);
        eq = (Button) findViewById(R.id.EQ);
        avtor = (Button) findViewById(R.id.avtor);
    }
    public void StartAnimation1(View v) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        v.startAnimation(animation);
    }
    public void Click1(View v) {
        StartAnimation1(one);
        if (!(t1.getText().toString().equals(""))) {
            if (t1.getText().toString().equals("0")) {
                t1.setText("1");
            } else
                t1.setText(t1.getText().toString() + "1");
        } else {
            t1.setText("1");
        }
    }

    public void Click2(View v) {
        StartAnimation1(two);
        if (!(t1.getText().toString().equals(""))) {
            if (t1.getText().toString().equals("0")) {
                t1.setText("2");
            } else
                t1.setText(t1.getText().toString() + "2");
        } else {
            t1.setText("2");
        }
    }

    public void Click3(View v) {
        StartAnimation1(three);
        if (!(t1.getText().toString().equals(""))) {
            if (t1.getText().toString().equals("0")) {
                t1.setText("3");
            } else
                t1.setText(t1.getText().toString() + "3");
        } else {
            t1.setText("3");
        }
    }

    public void Click4(View v) {
        StartAnimation1(four);
        if (!(t1.getText().toString().equals(""))) {
            if (t1.getText().toString().equals("0")) {
                t1.setText("4");
            } else
                t1.setText(t1.getText().toString() + "4");
        } else {
            t1.setText("4");
        }
    }

    public void Click5(View v) {
        StartAnimation1(five);
        if (!(t1.getText().toString().equals(""))) {
            if (t1.getText().toString().equals("0")) {
                t1.setText("5");
            } else
                t1.setText(t1.getText().toString() + "5");
        } else {
            t1.setText("5");
        }
    }

    public void Click6(View v) {
        StartAnimation1(six);
        if (!(t1.getText().toString().equals(""))) {
            if (t1.getText().toString().equals("0")) {
                t1.setText("6");
            } else
                t1.setText(t1.getText().toString() + "6");
        } else {
            t1.setText("6");
        }
    }

    public void Click7(View v) {
        StartAnimation1(seven);
        if (!(t1.getText().toString().equals(""))) {
            if (t1.getText().toString().equals("0")) {
                t1.setText("7");
            } else
                t1.setText(t1.getText().toString() + "7");
        } else {
            t1.setText("7");
        }
    }

    public void Click8(View v) {
        StartAnimation1(eight);
        if (!(t1.getText().toString().equals(""))) {
            if (t1.getText().toString().equals("0")) {
                t1.setText("8");
            } else
                t1.setText(t1.getText().toString() + "8");
        } else {
            t1.setText("8");
        }
    }

    public void Click9(View v) {
        StartAnimation1(nine);
        if (!(t1.getText().toString().equals(""))) {
            if (t1.getText().toString().equals("0")) {
                t1.setText("9");
            } else
                t1.setText(t1.getText().toString() + "9");
        } else {
            t1.setText("9");
        }
    }

    public void Click0(View v) {
        StartAnimation1(zero);
        if (!(t1.getText().toString().equals(""))) {
            if (t1.getText().toString().equals("0")) {
                t1.setText("0");
            } else
                t1.setText(t1.getText().toString() + "0");
        } else {
            t1.setText("0");
        }
    }

    public void ClickC(View v) {
        StartAnimation1(c);
        isdotclicked = false;
        t1.setText("0");
        t2.setText("");
        s.setText("");
    }

    public void ClickDel(View v) {
        StartAnimation1(del);
        if (!(t1.getText().toString().equals("")) && t1.getText().toString().length() != 1) {
            if (t1.getText().toString().length() != 0) {
                String str = t1.getText().toString();
                if (str.charAt(str.length() - 1) == '.') {
                    isdotclicked = false;
                }
                str = str.substring(0, str.length() - 1);
                if (str == "0" || str == "")
                    t1.setText("0");
                else
                    t1.setText(str);
            }
        } else t1.setText("0");
    }
    public void ClickPlusMinus(View v) {
        StartAnimation1(plmin);
        if (!(t1.getText().toString().equals(""))) {
            double value = Double.parseDouble(t1.getText().toString()) * -1;
            if (value == (int) value)
                t1.setText(Integer.toString((int) value));
            else
                t1.setText(Double.toString(value));
        }
    }

    public void ClickDot(View v) {
        StartAnimation1(dot);
        if (!isdotclicked) {
            if (!(t1.getText().toString().equals(""))) {
                t1.setText(t1.getText().toString() + ".");
            } else {
                t1.setText("0.");
            }
        }
        isdotclicked = true;
    }

    public void ClickPlus(View v) {
        StartAnimation1(plus);
        isdotclicked = false;
        if (!t1.getText().toString().equals("")) {
            if (!s.getText().toString().equals("")) {
                double a = Double.parseDouble(t2.getText().toString());
                double b = Double.parseDouble(t1.getText().toString());
                double value = 0;
                switch (s.getText().toString()) {
                    case "+":
                        value = a + b;
                        break;
                    case "-":
                        value = a - b;
                        break;
                    case "/":
                        value = a / b;
                        break;
                    case "*":
                        value = a * b;
                        break;
                }
                if (value == (int) value) {
                    t2.setText(Integer.toString((int) value));
                } else {
                    t2.setText(Double.toString(value));
                }
            } else {
                t2.setText(t1.getText().toString());

            }
            s.setText("+");
            t1.setText("0");
        }
    }

    public void ClickMinus(View v) {
        StartAnimation1(minus);
        isdotclicked = false;
        if (!t1.getText().toString().equals("")) {
            if (!s.getText().toString().equals("")) {
                double a = Double.parseDouble(t2.getText().toString());
                double b = Double.parseDouble(t1.getText().toString());
                double value = 0;
                switch (s.getText().toString()) {
                    case "+":
                        value = a + b;
                        break;
                    case "-":
                        value = a - b;
                        break;
                    case "/":
                        value = a / b;
                        break;
                    case "*":
                        value = a * b;
                        break;
                }

                if (value == (int) value) {
                    t2.setText(Integer.toString((int) value));
                } else {
                    t2.setText(Double.toString(value));
                }
            } else {
                t2.setText(t1.getText().toString());
            }
            s.setText("-");
            t1.setText("0");
        }
    }


    public void ClickMulti(View v) {
        StartAnimation1(multi);
        isdotclicked = false;
        if (!t1.getText().toString().equals("")) {
            if (!s.getText().toString().equals("")) {
                double a = Double.parseDouble(t2.getText().toString());
                double b = Double.parseDouble(t1.getText().toString());
                double value = 0;
                switch (s.getText().toString()) {
                    case "+":
                        value = a + b;
                        break;
                    case "-":
                        value = a - b;
                        break;
                    case "/":
                        value = a / b;
                        break;
                    case "*":
                        value = a * b;
                        break;
                }
                if (value == (int) value) {
                    t2.setText(Integer.toString((int) value));
                } else {
                    t2.setText(Double.toString(value));
                }
            } else {
                t2.setText(t1.getText().toString());

            }
            s.setText("*");
            t1.setText("0");
        }
    }

    public void ClickDev(View v) {
        StartAnimation1(dev);
        isdotclicked = false;
        if (!t1.getText().toString().equals("")) {
            if (!s.getText().toString().equals("")) {
                double a = Double.parseDouble(t2.getText().toString());
                double b = Double.parseDouble(t1.getText().toString());

                double value = 0;
                if (t1.getText().toString() != "") {
                    switch (s.getText().toString()) {
                        case "+":
                            value = a + b;
                            break;
                        case "-":
                            value = a - b;
                            break;
                        case "/":
                            if (b != 0) {
                                value = a / b;
                            } else {
                                Toast toast = Toast.makeText(getApplicationContext(), "Can not divide by 0", Toast.LENGTH_SHORT);
                                toast.show();

                            }
                            break;
                        case "*":
                            value = a * b;
                            break;
                    }
                    if (value == (int) value) {
                        t2.setText(Integer.toString((int) value));
                    } else {
                        t2.setText(Double.toString(value));
                    }
                }
            } else {
                t2.setText(t1.getText().toString());

            }
            s.setText("/");
            t1.setText("0");
        }
    }

    public void ClickEq(View v) {
        StartAnimation1(eq);
        if (t2.getText().toString() != "" && t1.getText().toString() != "" && s.getText().toString() != "") {
            double a = Double.parseDouble(t2.getText().toString());
            double b = Double.parseDouble(t1.getText().toString());
            switch (s.getText().toString()) {
                case "+":
                    if (a + b == (int) (a + b))
                        t1.setText(Integer.toString((int) (a + b)));
                    else t1.setText(Double.toString(a + b));
                    s.setText("");
                    t2.setText("");
                    break;
                case "-":
                    if (a - b == (int) (a - b))
                        t1.setText(Integer.toString((int) (a - b)));
                    else t1.setText(Double.toString(a - b));
                    s.setText("");
                    t2.setText("");
                    break;
                case "/":
                    if (b != 0) {
                        if (a / b == (int) (a / b)) {
                            t1.setText(Integer.toString((int) (a / b)));
                            s.setText("");
                            t2.setText("");
                        } else {
                            t1.setText(Double.toString(a / b));
                            s.setText("");
                            t2.setText("");
                        }
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Can not divide by 0", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    break;
                case "*":
                    if (a * b == (int) (a * b))
                        t1.setText(Integer.toString((int) (a * b)));
                    else t1.setText(Double.toString(a * b));
                    s.setText("");
                    t2.setText("");
                    break;
            }

        }
    }
    public void ClickAvtor(View v) {
        StartAnimation1(avtor);

    }

}