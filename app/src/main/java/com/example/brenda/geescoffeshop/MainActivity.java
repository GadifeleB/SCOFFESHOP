package com.example.brenda.geescoffeshop;

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

public class MainActivity extends AppCompatActivity {


    //declaring variables

    private TextView txtCaPrice,txtEsPrice,txtCafPrice,txtMocPrice,TxtCaTotal,txtEsTotal,txtCafTotal,txtMocTotal,txtAmountTotal;
    private EditText edtitem1,edtitem2, edtitem3,edtitem4;
    private Button btnAmount, btnorderr,  btnclearr;
    private RadioButton chkCap, chkCoff, chkMoc, chkExpr;
    Double total;
    Double var , quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigning values
        //Prices
        txtCaPrice=(TextView)findViewById(R.id.txtPrice1 );
        txtEsPrice=(TextView)findViewById(R.id.txtprice2 );
        txtCafPrice =(TextView)findViewById(R.id.txtprice3  );
        txtMocPrice =(TextView)findViewById(R.id.txtprice4);

        //ITEMS

        edtitem1=(EditText) findViewById(R.id.item1 );
        edtitem2=(EditText) findViewById(R.id.item2  );
        edtitem3 =(EditText) findViewById(R.id.item3  );
        edtitem4 =(EditText) findViewById(R.id.item4 );

      //Totals

        TxtCaTotal=(TextView) findViewById(R.id.txtTotalCap );
        txtEsTotal=(TextView) findViewById(R.id.txtTotalEspress  );
        txtCafTotal =(TextView) findViewById(R.id.txtTotalCaffe  );
        txtMocTotal =(TextView) findViewById(R.id.txtTotalMochaL );

        //AmountDue
        txtAmountTotal =(TextView) findViewById(txtAmountDue);

        //RadioButton
        chkCap = (RadioButton)findViewById(R.id.radCappucino);
        chkCoff = (RadioButton)findViewById(R.id.radCaffeLatte);
        chkMoc = (RadioButton)findViewById(R.id.radMochaLatte);
        chkExpr = (RadioButton)findViewById(R.id.radEspresso);

        //Buttons
        btnAmount = (Button)findViewById(R.id.button);
        btnorderr=(Button)findViewById(R.id.button2);
        btnclearr=(Button)findViewById(R.id.btnClear);

        // calculations
        btnAmount.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (chkCap.isChecked()) {
                    var = Double.valueOf(txtCaPrice.getText().toString());
                    quantity = Double.valueOf(edtitem1.getText().toString());
                    total = var * quantity;
                    TxtCaTotal.setText(Double.toString(total));
                }
                if (chkExpr.isChecked()) {
                    var = Double.valueOf(txtEsPrice.getText().toString());
                    quantity = Double.valueOf(edtitem2.getText().toString());
                    total = var * quantity;
                    txtEsTotal.setText(Double.toString(total));


                }

                if (chkCoff.isChecked()) {
                    var = Double.valueOf(txtCafPrice.getText().toString());
                    quantity = Double.valueOf(edtitem3.getText().toString());
                    total = var * quantity;
                    txtCafTotal.setText(Double.toString(total));

            }


                if(chkMoc.isChecked()) {
                    var = Double.valueOf(txtMocPrice .getText().toString());
                    quantity = Double.valueOf(edtitem4.getText().toString());
                    total = var * quantity;
                    txtMocTotal.setText(Double.toString(total));

                }
                if(chkCap.isChecked() && chkExpr.isChecked()){
                    var = Double.valueOf(txtEsPrice.getText().toString());
                    quantity = Double.valueOf(edtitem2.getText().toString());
                    total = var * quantity;
                    txtEsTotal.setText(Double.toString(total));

                    var = Double.valueOf(txtCaPrice.getText().toString());
                    quantity = Double.valueOf(edtitem1.getText().toString());
                    total = var * quantity;
                    TxtCaTotal.setText(Double.toString(total));
                }


            }
        });

        btnorderr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double capppacino = Double.valueOf(TxtCaTotal.getText().toString());
                Double expresso = Double.valueOf(txtEsTotal.getText().toString());
                Double caffe = Double.valueOf(txtCafTotal.getText().toString());
                Double moch = Double.valueOf(txtMocTotal.getText().toString());
                total = capppacino + expresso + caffe + moch;
                txtAmountTotal.setText(Double.toString(total));
            }
        });

        chkCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!chkCap.isChecked()){
                    edtitem1.setVisibility(View.INVISIBLE);
                }else{
                    edtitem1.setVisibility(View.VISIBLE);
                }
            }
        });

        chkExpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!chkExpr.isChecked()){
                    edtitem2.setVisibility(View.INVISIBLE);
                }else{
                    edtitem2.setVisibility(View.VISIBLE);
                }
            }
        });

        chkCoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!chkCoff.isChecked()){
                    edtitem3.setVisibility(View.INVISIBLE);
                }else{
                    edtitem3.setVisibility(View.VISIBLE);
                }
            }
        });

        chkMoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!chkMoc.isChecked()){
                    edtitem4.setVisibility(View.INVISIBLE);
                }else{
                    edtitem4.setVisibility(View.VISIBLE);
                }
            }

        });

        // clearing views
        btnclearr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtitem1.setText("");
                edtitem2.setText("");
                edtitem3 .setText("");
                edtitem4 .setText("");

                txtCafTotal .setText("");
                txtMocTotal .setText("");
                txtEsTotal.setText("");
                TxtCaTotal.setText("");

                txtAmountTotal .setText("");
                txtEsTotal.setText("");

            }
        });
    }
}

