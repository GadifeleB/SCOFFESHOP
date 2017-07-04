package com.example.brenda.geescoffeshop;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.EditText;


import static android.R.id.edit;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.brenda.geescoffeshop.R.id.radCappucino;
import static com.example.brenda.geescoffeshop.R.id.textView;
import static com.example.brenda.geescoffeshop.R.id.txtAmountDue;
import static com.example.brenda.geescoffeshop.R.id.txtTotalCap;
import static com.example.brenda.geescoffeshop.R.id.txtTotalEspress;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //declaring variables

    static TextView txtCaPrice,txtEsPrice,txtCafPrice,txtMocPrice,TxtCaTotal,txtEsTotal,txtCafTotal,txtAmountTotal;
    static EditText edtItem1,edtItem2, edtItem3, edtTopping1, edtTopping2,edtTopping3;
     Button btnAmount, btnOrderr,  btnClearr,btnNext;
     static RadioButton RadCap, RadCoff, RadExpr;
    static Double total;
    static Double var , quantity;
    static String topping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // assigning values
        //Prices
        txtCaPrice=(TextView)findViewById(R.id.txtPrice1 );
        txtEsPrice=(TextView)findViewById(R.id.txtprice2 );
        txtCafPrice =(TextView)findViewById(R.id.txtprice3  );


        //ITEMS

        edtItem1=(EditText) findViewById(R.id.item1 );
        edtItem2=(EditText) findViewById(R.id.item2  );
        edtItem3 =(EditText) findViewById(R.id.item3  );

        //toppings
        edtTopping1=(EditText) findViewById(R.id.editText1);
        edtTopping2=(EditText) findViewById(R.id.editText2 );
        edtTopping3= (EditText) findViewById(R.id.editText3);


      //Totals

        TxtCaTotal=(TextView) findViewById(R.id.txtTotalCap );
        txtEsTotal=(TextView) findViewById(R.id.txtTotalEspress  );
        txtCafTotal =(TextView) findViewById(R.id.txtTotalCaffe  );


        //AmountDue
        txtAmountTotal =(TextView) findViewById(txtAmountDue);

        //RadioButton
        RadCap = (RadioButton)findViewById(R.id.radCappucino);
        RadCoff = (RadioButton)findViewById(R.id.radCaffeLatte);
        RadExpr = (RadioButton)findViewById(R.id.radEspresso);





        //Buttons
        btnAmount = (Button)findViewById(R.id.button2);
        btnOrderr=(Button)findViewById(R.id.button);
        btnClearr=(Button)findViewById(R.id.btnClear);
        btnNext= (Button) findViewById(R.id.btnnext );

        btnAmount.setOnClickListener(this);
        btnOrderr.setOnClickListener(this);
        btnClearr.setOnClickListener(this);
        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnnext:

                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
                break;

            case R.id.btnClear:

                edtItem1.setText("");
                edtItem2.setText("");
                edtItem3.setText("");

                edtTopping1.setText("");
                edtTopping2.setText("");
                edtTopping3.setText("");

                txtCafTotal.setText("");
                txtEsTotal.setText("");
                TxtCaTotal.setText("");

                txtAmountTotal.setText("");
                txtEsTotal.setText("");
                break;


            case R.id.button:

                        if (RadCap.isChecked()) {

                            var = Double.valueOf(txtCaPrice.getText().toString());
                            quantity = Double.valueOf(edtItem1.getText().toString());

                            total = var * quantity;
                            TxtCaTotal.setText(Double.toString(total));
                        }
                        if (RadExpr.isChecked()) {
                            var = Double.valueOf(txtEsPrice.getText().toString());
                            quantity = Double.valueOf(edtItem2.getText().toString());
                            total = var * quantity;
                            txtEsTotal.setText(Double.toString(total));

                        }

                        if (RadCoff.isChecked()) {
                            var = Double.valueOf(txtCafPrice.getText().toString());
                            quantity = Double.valueOf(edtItem3.getText().toString());
                            total = var * quantity;
                            txtCafTotal.setText(Double.toString(total));

                        }


                        if (RadCap.isChecked() && RadExpr.isChecked()) {
                            var = Double.valueOf(txtEsPrice.getText().toString());
                            quantity = Double.valueOf(edtItem2.getText().toString());
                            total = var * quantity;
                            txtEsTotal.setText(Double.toString(total));

                            var = Double.valueOf(txtCaPrice.getText().toString());
                            quantity = Double.valueOf(edtItem1.getText().toString());
                            total = var * quantity;
                            TxtCaTotal.setText(Double.toString(total));
                            break;
                        }



            case R.id.button2:

                Double capppacino = Double.valueOf(TxtCaTotal.getText().toString());
                Double expresso = Double.valueOf(txtEsTotal.getText().toString());
                Double caffe = Double.valueOf(txtCafTotal.getText().toString());

                total = capppacino + expresso + caffe;
                txtAmountTotal.setText(Double.toString(total));
                break;

        }





        }


    }


