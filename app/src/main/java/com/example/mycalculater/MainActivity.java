package com.example.mycalculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView inputText , outputText;

    private String input , output , newOutput;

    private Button button0 , button1 , button2 ,button3 ,button4 ,button5 ,button6 , button7 ,button8 ,button9 , buttonAdd , buttonSubs , buttonDivision,buttonMultiply, buttonPoint, buttonPersent , buttonPower , buttonEqual  ,buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputtext);
        outputText = findViewById(R.id.outputtext);

        button0=findViewById(R.id.zero_btn);
        button1=findViewById(R.id.one_btn);
        button2=findViewById(R.id.two_btn);
        button3=findViewById(R.id.three_btn);
        button4=findViewById(R.id.fuor_btn);
        button5=findViewById(R.id.five_btn);
        button6=findViewById(R.id.six_btn);
        button7=findViewById(R.id.seven_btn);
        button8=findViewById(R.id.eight_btn);
        button9=findViewById(R.id.nine_btn);
        buttonAdd=findViewById(R.id.adition_btn);
        buttonDivision=findViewById(R.id.division_btn);
        buttonMultiply=findViewById(R.id.multiplication_btn);
        buttonClear=findViewById(R.id.clear_btn);
        buttonEqual=findViewById(R.id.equl_btn);
        buttonPower=findViewById(R.id.power_btn);
        buttonPoint=findViewById(R.id.dort_btn);
        buttonPersent=findViewById(R.id.persentage_btn);
        buttonSubs=findViewById(R.id.subraction_btn);
    }
    public void onButtonClick(View view){

        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data){
            case "C":
                input=null;
                output=null;
                outputText.setText("");
                break;

            case "^":
                input+="^";
                input= input + "^";
                solve();
                break;

            case "*":
                input+="*";
                solve();
                break;

            case "=":
                solve();
                break;
            case "%":
                input+="%";
                double d =Double.parseDouble(inputText.getText().toString())/100;
                outputText.setText(String.valueOf(d));
                break;
            default:
                if(input==null){
                    input="";
                }
                if(data.equals("+")||data.equals("/")||data.equals("-")){

                    solve();
                }
                input+=data;
        }

        inputText.setText(input);
    }
    private void solve(){

        if(input.split("\\+").length==2){
            String numbers[] = input.split("\\+");
            try{
                double d =  Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d+"";
            }
            catch (Exception e){
                outputText.setError(e.getMessage().toString());

            }
        }
        if(input.split("\\*").length==2){
            String numbers[] = input.split("\\*");
            try{
                double d =  Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d+"";
            }
            catch (Exception e){
                outputText.setError(e.getMessage().toString());

            }
        }
        if(input.split("\\/").length==2){
            String numbers[] = input.split("\\/");
            try{
                double d =  Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d+"";
            }
            catch (Exception e){
                outputText.setError(e.getMessage().toString());

            }
        }
        if(input.split("\\^").length==2){
            String numbers[] = input.split("\\^");
            try{
                double d;
                d = Math.pow(Double.parseDouble(numbers[0]) , Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d+"";
            }
            catch (Exception e){
                outputText.setError(e.getMessage().toString());

            }
        }
        if(input.split("\\-").length==2){
            String numbers[] = input.split("\\-");

            try{

                if(Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){

                    double d =  Double.parseDouble(numbers[1])-Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputText.setText("-"+newOutput);
                    input = d+"";
                }
                else {
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputText.setText(newOutput);
                    input = d + "";
                }
            }
            catch (Exception e){
                outputText.setError(e.getMessage().toString());

            }
        }
    }
    private String cutDecimal(String number){

        String n [] = number.split("//.");
        if(n.length>1){
            if(n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }
}