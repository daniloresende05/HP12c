package com.example.hp12c;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnC;
    private Button btnBackSpace;
    private Button btnVirgula;
    private Button btnMais;
    private Button btnMenos;
    private Button btnVezes;
    private Button btnDivisao;
    private Button btnEnter;

    private EditText visor;
    private Calculadora calculadora = new Calculadora();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn0 = findViewById(R.id.btnZero);
        btn1 = findViewById(R.id.btnUm);
        btn2 = findViewById(R.id.btnDois);
        btn3 = findViewById(R.id.btnTres);
        btn4 = findViewById(R.id.btnQuatro);
        btn5 = findViewById(R.id.btnCinco);
        btn6 = findViewById(R.id.btnSeis);
        btn7 = findViewById(R.id.btnSete);
        btn8 = findViewById(R.id.btnOito);
        btn9 = findViewById(R.id.btnNove);
        btnBackSpace = findViewById(R.id.btnBackSpace);
        btnEnter = findViewById(R.id.btnEnter);
        btnC = findViewById(R.id.btnClear);
        btnVirgula = findViewById(R.id.btnVirgula);
        btnMais = findViewById(R.id.btnAdicao);
        btnMenos = findViewById(R.id.btnSubtracao);
        btnDivisao = findViewById(R.id.btnDivisao);
        btnVezes = findViewById(R.id.btnMultiplicacao);



        visor = findViewById(R.id.editTextNumber);
        visor.setShowSoftInputOnFocus(false);

        btn0.setOnClickListener(botaoclick("0"));
        btn1.setOnClickListener(botaoclick("1"));
        btn2.setOnClickListener(botaoclick("2"));
        btn3.setOnClickListener(botaoclick("3"));
        btn4.setOnClickListener(botaoclick("4"));
        btn5.setOnClickListener(botaoclick("5"));
        btn6.setOnClickListener(botaoclick("6"));
        btn7.setOnClickListener(botaoclick("7"));
        btn8.setOnClickListener(botaoclick("8"));
        btn9.setOnClickListener(botaoclick("9"));
        btnVirgula.setOnClickListener(botaoclick("."));

        btnC.setOnClickListener((v)->{
            visor.setText("");
            calculadora = new Calculadora();
        });

        btnBackSpace.setOnClickListener((v) -> {
            int inicioSelecao = visor.getSelectionStart() - 1;
            inicioSelecao = Math.max(inicioSelecao,0);
            int finalSelecao = visor.getSelectionEnd();
            visor.getText().delete(inicioSelecao, finalSelecao);
        });

        btnEnter.setOnClickListener((v)->{
            double valor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valor);
            calculadora.enter();
            visor.setText("");
        });

        btnMais.setOnClickListener((v)->{
            double valorDoVisor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valorDoVisor);
            calculadora.soma();
            String valor = String.valueOf(calculadora.getNumero());
            visor.setText(valor);
        });

        btnMenos.setOnClickListener((v)->{
            double valorDoVisor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valorDoVisor);
            calculadora.subtracao();
            String valor = String.valueOf(calculadora.getNumero());
            visor.setText(valor);
        });

        btnVezes.setOnClickListener((v)->{
            double valorDoVisor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valorDoVisor);
            calculadora.multiplicacao();
            String valor = String.valueOf(calculadora.getNumero());
            visor.setText(valor);
        });

        btnDivisao.setOnClickListener((v)->{
            double valorDoVisor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valorDoVisor);
            calculadora.divisao();
            String valor = String.valueOf(calculadora.getNumero());
            visor.setText(valor);
        });

        btnVezes.setOnClickListener((v)->{
            double valorDoVisor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valorDoVisor);
            calculadora.multiplicacao();
            String valor = String.valueOf(calculadora.getNumero());
            visor.setText(valor);
        });

    }

    public View.OnClickListener botaoclick(final String s) {
        return (v) -> {
            int inicioSelecao = visor.getSelectionStart();
            int finalSelecao = visor.getSelectionEnd();
            visor.getText().replace(inicioSelecao,finalSelecao,s);
        };
    }
}