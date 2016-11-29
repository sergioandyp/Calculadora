package com.company.sap.calculadora;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    public Button btnPunto, btnSuma, btnResta, btnDiv, btnMulti, btnPot, btnRaiz, btnIgual;
    public Button btnDel;

    public EditText txtResultado;
    public TextView txtPrevCalc;

    public HorizontalScrollView txtScroll;

    public double num1;
    public char op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);

        btnPunto = (Button) findViewById(R.id.btnPunto);
        btnSuma = (Button) findViewById(R.id.btnSuma);
        btnResta = (Button) findViewById(R.id.btnResta);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnPot = (Button) findViewById(R.id.btnPot);
        btnRaiz = (Button) findViewById(R.id.btnRaiz);
        btnIgual = (Button) findViewById(R.id.btnIgual);

        btnDel = (Button) findViewById(R.id.btnDel);

        txtResultado = (EditText) findViewById(R.id.txtResultado);
        txtPrevCalc = (TextView) findViewById(R.id.txtPrevCalc);

        txtScroll = (HorizontalScrollView) findViewById(R.id.txtScroll);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtResultado.getText().insert(txtResultado.getSelectionStart(), "1");

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtResultado.getText().insert(txtResultado.getSelectionStart(), "2");

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtResultado.getText().insert(txtResultado.getSelectionStart(), "3");

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtResultado.getText().insert(txtResultado.getSelectionStart(), "4");

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtResultado.getText().insert(txtResultado.getSelectionStart(), "5");

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtResultado.getText().insert(txtResultado.getSelectionStart(), "6");

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtResultado.getText().insert(txtResultado.getSelectionStart(), "7");

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtResultado.getText().insert(txtResultado.getSelectionStart(), "8");

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtResultado.getText().insert(txtResultado.getSelectionStart(), "9");

            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtResultado.getText().insert(txtResultado.getSelectionStart(), "0");

            }
        });


        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!txtResultado.getText().toString().contains(".")) {

                    if (txtResultado.getSelectionStart() == 0) {

                        txtResultado.getText().insert(txtResultado.getSelectionStart(), "0.");

                    }
                    else {

                        txtResultado.getText().insert(txtResultado.getSelectionStart(), ".");

                    }

                }

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtResultado.getSelectionStart() == 0 && op != 0) {

                    txtPrevCalc.setText(txtPrevCalc.getText().toString().substring(0, txtPrevCalc.length() - 1));
                    op = 0;

                } else if (TextUtils.isEmpty(txtResultado.getText())) {

                    txtPrevCalc.setText("");
                    num1 = 0;
                    op = 0;

                } else if (txtResultado.getSelectionStart() > 0) {

                    txtResultado.getText().delete(txtResultado.getSelectionStart() - 1, txtResultado.getSelectionStart());

                }

            }
        });

        btnDel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                txtResultado.setText("");
                txtPrevCalc.setText("");
                num1 = 0;
                op = 0;

                return true;
            }
        });

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(txtResultado.getText().toString()) && !txtResultado.getText().toString().equals("-")) {

                    doRoot();

                    switchOP();

                }

                roundnum1("+");

                txtResultado.setText("");

                txtScroll.smoothScrollTo(txtScroll.getMaxScrollAmount(), 0);

                op = 1;


            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!txtResultado.getText().toString().equals("-") ) {

                    if (txtResultado.getSelectionStart() > 0) {

                        doRoot();

                        switchOP();

                        roundnum1("-");

                        txtResultado.setText("");

                        op = 2;

                    }
                    else if (!txtResultado.getText().toString().contains("-")) {

                        if (TextUtils.isEmpty(txtResultado.getText()) && op == 0 && !TextUtils.isEmpty(txtPrevCalc.getText())) {

                            roundnum1("-");

                            op = 2;

                            txtScroll.smoothScrollTo(txtScroll.getMaxScrollAmount(), 0);

                        }
                        else {

                            txtResultado.setText(String.valueOf("-" + txtResultado.getText()));
                            txtResultado.setSelection(1);

                        }

                    }

                }

            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(txtResultado.getText().toString()) && !txtResultado.getText().toString().equals("-")) {

                    doRoot();

                    switchOP();

                }

                roundnum1("x");

                txtResultado.setText("");

                txtScroll.smoothScrollTo(txtScroll.getMaxScrollAmount(), 0);

                op = 3;

            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(txtResultado.getText().toString()) && !txtResultado.getText().toString().equals("-")) {

                    doRoot();

                    switchOP();

                }

                roundnum1("÷");

                txtResultado.setText("");

                txtScroll.smoothScrollTo(txtScroll.getMaxScrollAmount(), 0);

                op = 4;

            }
        });

        btnPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(txtResultado.getText().toString()) && !txtResultado.getText().toString().equals("-")) {

                    doRoot();

                    switchOP();

                }

                roundnum1("^");

                txtResultado.setText("");

                txtScroll.smoothScrollTo(txtScroll.getMaxScrollAmount(), 0);

                op = 5;

            }
        });

        btnRaiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(txtResultado.getText().toString()) && !txtResultado.getText().toString().equals("-")) {

                    if (!txtResultado.getText().toString().contains("√") && !txtResultado.getText().toString().contains("∛")) {

                        if (op == 0 && txtResultado.getText().toString().startsWith("-")) {
                            op = 1;
                        }

                        switch (op) {

                            case 0:

                                num1 = Math.sqrt(Double.valueOf(txtResultado.getText().toString()));

                                break;

                            case 1:

                                num1 += Math.sqrt(Double.valueOf(txtResultado.getText().toString()));

                                break;

                            case 2:

                                num1 -= Math.sqrt(Double.valueOf(txtResultado.getText().toString()));

                                break;

                            case 3:

                                num1 *= Math.sqrt(Double.valueOf(txtResultado.getText().toString()));

                                break;

                            case 4:

                                num1 /= Math.sqrt(Double.valueOf(txtResultado.getText().toString()));

                                break;

                            case 5:

                                num1 = Math.pow(num1, Math.sqrt(Double.valueOf(txtResultado.getText().toString())));

                                break;

                            default:
                                break;

                        }

                        roundnum1("");

                        txtResultado.setText("");

                    }

                } else {

                    txtResultado.setText(String.valueOf(txtResultado.getText().toString() + "√"));
                    txtResultado.setSelection(txtResultado.length());

                }

            }
        });

        btnRaiz.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (!TextUtils.isEmpty(txtResultado.getText().toString()) && !txtResultado.getText().toString().equals("-")) {

                    if (!txtResultado.getText().toString().contains("√") && !txtResultado.getText().toString().contains("∛")) {

                        if (op == 0 && txtResultado.getText().toString().startsWith("-")) {
                            op = 1;
                        }

                        switch (op) {

                            case 0:

                                num1 = Math.cbrt(Double.valueOf(txtResultado.getText().toString()));

                                break;

                            case 1:

                                num1 += Math.cbrt(Double.valueOf(txtResultado.getText().toString()));

                                break;

                            case 2:

                                num1 -= Math.cbrt(Double.valueOf(txtResultado.getText().toString()));

                                break;

                            case 3:

                                num1 *= Math.cbrt(Double.valueOf(txtResultado.getText().toString()));

                                break;

                            case 4:

                                num1 /= Math.cbrt(Double.valueOf(txtResultado.getText().toString()));

                                break;

                            case 5:

                                num1 = Math.pow(num1, Math.cbrt(Double.valueOf(txtResultado.getText().toString())));

                                break;

                            default:
                                break;

                        }

                        roundnum1("");

                        txtResultado.setText("");

                    }

                } else {


                    txtResultado.setText(String.valueOf(txtResultado.getText().toString() + "∛"));
                    txtResultado.setSelection(txtResultado.length());

                }

                return true;
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(txtResultado.getText().toString())) {
                    txtResultado.setText(String.valueOf(num1));
                } else if (txtResultado.getText().toString().equals("-")) {
                    txtResultado.setText(String.valueOf(-num1));
                }

                doRoot();

                switchOP();

                roundnum1("");

                txtResultado.setText("");

                txtScroll.scrollTo(0, 0);

                op = 0;

            }
        });

        btnIgual.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(MainActivity.this, "Desarrollador: Sergio Peralta", Toast.LENGTH_SHORT).show();

                return true;
            }
        });

        txtResultado.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (!TextUtils.isEmpty(txtResultado.getText())) {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    clipboard.setPrimaryClip(ClipData.newPlainText("simple text", txtResultado.getText()));
                    Toast.makeText(MainActivity.this, "Copiado al portapapeles", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        txtPrevCalc.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (!TextUtils.isEmpty(txtPrevCalc.getText())) {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    clipboard.setPrimaryClip(ClipData.newPlainText("simple text", txtPrevCalc.getText()));
                    Toast.makeText(MainActivity.this, "Copiado al portapapeles", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

        txtResultado.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().contains("-.")) {

                    s.insert(s.toString().indexOf("."), "0");

                }

                if (s.toString().contains("√") || s.toString().contains("∛")) {

                    if (s.toString().contains("√.") || s.toString().contains("∛.")) {

                        s.insert(s.toString().indexOf("."), "0");

                    }

                    if (!(s.toString().startsWith("-√") || s.toString().startsWith("-∛"))) {

                        if (!(s.toString().startsWith("√") || s.toString().startsWith("∛"))) {

                            if (s.toString().contains("√")) {

                                s.delete(0, s.toString().indexOf("√"));

                            } else if (s.toString().contains("∛")) {

                                s.delete(0, s.toString().indexOf("∛"));

                            }
                        }

                    }
                }
                else if (s.toString().equals(".")) {

                    txtResultado.setText("0.");

                }
            }
        });
    }


    public void switchOP() {

        if (op == 0 && txtResultado.getText().toString().startsWith("-")) {
            op = 1;
        }

        switch (op) {

            case 0:

                num1 = Double.valueOf(txtResultado.getText().toString());

                break;

            case 1:

                num1 += Double.valueOf(txtResultado.getText().toString());

                break;

            case 2:

                num1 -= Double.valueOf(txtResultado.getText().toString());

                break;

            case 3:

                num1 *= Double.valueOf(txtResultado.getText().toString());

                break;

            case 4:

                num1 /= Double.valueOf(txtResultado.getText().toString());

                break;

            case 5:

                num1 = Math.pow(num1, Double.valueOf(txtResultado.getText().toString()));

                break;

            default:
                break;

        }

    }

    public void doRoot() {

        if (txtResultado.getText().toString().equals("√")) {
            txtResultado.setText(String.valueOf(Math.sqrt(num1)));
        } else if (txtResultado.getText().toString().equals("-√")) {
            txtResultado.setText(String.valueOf(-Math.sqrt(num1)));
        } else if (txtResultado.getText().toString().equals("∛")) {
            txtResultado.setText(String.valueOf(Math.cbrt(num1)));
        } else if (txtResultado.getText().toString().equals("-∛")) {
            txtResultado.setText(String.valueOf(-Math.cbrt(num1)));
        } else if (txtResultado.getText().toString().startsWith("√")) {
            txtResultado.setText(String.valueOf(Math.sqrt(Double.valueOf(txtResultado.getText().toString().substring(txtResultado.getText().toString().indexOf("√") + 1, txtResultado.length())))));
        } else if (txtResultado.getText().toString().startsWith("-√")) {
            txtResultado.setText(String.valueOf(-Math.sqrt(Double.valueOf(txtResultado.getText().toString().substring(txtResultado.getText().toString().indexOf("√") + 1, txtResultado.length())))));
        } else if (txtResultado.getText().toString().startsWith("∛")) {
            txtResultado.setText(String.valueOf(Math.cbrt(Double.valueOf(txtResultado.getText().toString().substring(txtResultado.getText().toString().indexOf("∛") + 1, txtResultado.length())))));
        } else if (txtResultado.getText().toString().startsWith("-∛")) {
            txtResultado.setText(String.valueOf(-Math.cbrt(Double.valueOf(txtResultado.getText().toString().substring(txtResultado.getText().toString().indexOf("∛") + 1, txtResultado.length())))));
        }

    }


    public void roundnum1(String signo) {

        if (String.valueOf(num1).endsWith(".0")) {

            txtPrevCalc.setText(String.valueOf(String.valueOf(num1).substring(0, String.valueOf(num1).indexOf(".")) + signo));

        } else {

            txtPrevCalc.setText(String.valueOf(num1 + signo));

        }

    }

}