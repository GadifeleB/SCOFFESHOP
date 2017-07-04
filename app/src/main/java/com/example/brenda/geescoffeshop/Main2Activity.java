package com.example.brenda.geescoffeshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.order;
import static android.R.attr.x;
import static com.example.brenda.geescoffeshop.MainActivity.edtTopping1;
import static com.example.brenda.geescoffeshop.MainActivity.edtTopping2;
import static com.example.brenda.geescoffeshop.MainActivity.edtTopping3;
import static com.example.brenda.geescoffeshop.MainActivity.total;
import static com.example.brenda.geescoffeshop.R.id.item1;

public class Main2Activity extends AppCompatActivity {

    TextView yourOrder, message,thankYou;

    MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2)
        ;

        yourOrder = (TextView) findViewById(R.id.textView2);
        message = (TextView) findViewById(R.id.textView3);
        thankYou=(TextView)findViewById(R.id.txtThankYou);

        myOrder();
    }

    void myOrder() {
        String flavour1 = main.RadCap.getText().toString();
        String flavour2 = main.RadExpr.getText().toString();
        String flavour3 = main.RadCoff.getText().toString();
        String Amount = main.txtAmountTotal.getText().toString();


        //Quantity
        String item1 = main.edtItem1.getText().toString();
        String item2 = main.edtItem2.getText().toString();
        String item3 = main.edtItem3.getText().toString();

        //Total1
        String total1 = main.TxtCaTotal.getText().toString();
        String total2 = main.txtEsTotal.getText().toString();
        String total3 = main.txtCafPrice.getText().toString();


        //Toppings
        String top1 = edtTopping1.getText().toString();
        String top2 = edtTopping2.getText().toString();
        String top3 = edtTopping3.getText().toString();
        //  \n -> New Line
        //  \t -> Tab Space



        //radio button 1

        if((edtTopping1.getText().toString()).equals("03"))
        {
            top1="Chocolate";

        }else if (edtTopping1.getText().toString().equals("02"))

            top1="Caramel Cream";
        else
            top1="cinnamon";


        //radioButton 2

        if((edtTopping2.getText().toString()).equals("03"))
        {
            top2="Chocolate";

        }else if (edtTopping2.getText().toString().equals("02"))

            top2="Caramel Cream";
        else
            top2="cinnamon";



            // radioButton3

        if((edtTopping3.getText().toString()).equals("03"))
        {
            top3="Chocolate";

        }else if (edtTopping3.getText().toString().equals("02"))

            top3="Caramel Cream";
        else
            top3="cinnamon";

        //summary display
        message.setText("You have ordered");

        if (main.RadCap.isChecked() && (main.RadExpr.isChecked() && (main.RadCoff.isChecked()))) {
            message.setText( item1+ flavour1 +" " + "with"+  " " + top1  + " " +"R"+ total1 + "\n"+ item2 + flavour2 +" " + "with" + " " + top2 +" " +"R"+ total2 + " \n" + " "+ item3+  flavour3 +" "+" " + "with"+ " "+top3+ " "+"R"+total3 + ""

                    + "\n\nAmount due :" + " R"  +"" + Amount );

        }else if (main.RadCap.isChecked() && (main.RadExpr .isChecked())){
            message.setText(  item1+ flavour1 +" "+"with"+" "+top1 + " "+ "R"+ total1  + " \n "+ item2 + flavour2+ " " +"with"+ top2 +"R"+ total2 +" " +"\n\nAmount due :" + " R"  +"" + Amount );
        }else if (main.RadExpr.isChecked() && (main.RadCoff.isChecked())){

          message.setText  ( item2 + flavour2+" "+"with"+top2  +" " +"R"+ total2 + " \n"  +  item3+  flavour3 +" "+"with"+top3 +" "+ "R"+total3 + "\n\nAmount due :" + " R"  +"" + Amount );

        }else if (main.RadCoff.isChecked()&& main.RadCap .isChecked()){
           message.setText( item1+ flavour1 +" "  +"with"+" " + top1+ " " + "R"+ total1 + "\n" +  item3+  flavour3 +" "+"with"+" "+ top3 +" "+ "R"+total3 + "\n\nAmount due :" + " R"  +"" + Amount );
        } else if (main.RadCap.isChecked()){

            message.setText(  item1+ flavour1 +" "+"with" +  " " + top1+" " +"R"+ total1 +" "+ " "  +"\n\nAmount due :" + " R"  +"" + Amount );
        }else if (main.RadExpr.isChecked()){
            message.setText(item2 + flavour2+" "+"with"+ " "+ top2 +" " +"R"+ total2 +" "  + "\n\nAmount due :" + " R"  +"" + Amount );

        }else

              message.setText( item3+  flavour3+" "+"with"+ top3+ " "+ "R"+total3  + " "+"\n\nAmount due :" + " R"  +"" + Amount );

        thankYou.setText("Thank you for your order , please call again!!!!");
    }


}


