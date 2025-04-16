package br.fecapccp.question2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private Button button;
    private TextView textView;

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

        editText = findViewById(R.id.editTextText);

        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);

        button = findViewById(R.id.button);

        textView = findViewById(R.id.textView3);

         button.setOnClickListener(view->{
             try {
                 Double valor = Double.parseDouble(editText.getText().toString());

                 Double percentual = 0.4;
                 if(radioButton2.isChecked()){
                     percentual = 0.45;
                 }else if(radioButton3.isChecked()){
                     percentual = 0.5;
                 }
                 String resultado = "O novo salário é igual a: R$ " + valor * (percentual + 1);

                 textView.setText(resultado);
             }catch(Exception e){
                 Toast.makeText(getApplicationContext(), "Digite um salário válido!", Toast.LENGTH_LONG).show();
             }

         });

    }
}