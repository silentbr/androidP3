package com.example.fibonacci;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText EtFibo;
    Button calcular;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtFibo = findViewById(R.id.EtFibo);
        calcular = findViewById(R.id.calcular);
        textView = findViewById(R.id.textView);

        calcular.setOnClickListener(v -> {
            String entrada = EtFibo.getText().toString();

            if (entrada.isEmpty()) {
                textView.setText(getString(R.string.erro_digite_numero));
                return;
            }

            int n;
            try {
                n = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                textView.setText(getString(R.string.erro_numero_invalido));
                return;
            }

            if (n <= 0 || n >= 20) {
                textView.setText(getString(R.string.erro_intervalo));
                return;
            }

            StringBuilder resultado = new StringBuilder();
            int a = 0, b = 1;

            for (int i = 0; i < n; i++) {
                resultado.append(a);
                if (i < n - 1) {
                    resultado.append(", ");
                }
                int temp = a + b;
                a = b;
                b = temp;
            }

            textView.setText(getString(R.string.resultado, resultado.toString()));
        });
    }
}
