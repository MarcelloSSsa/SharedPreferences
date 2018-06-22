package sharedpreferences.app.com.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textoNome;
    private Button salvar;
    private TextView resultado;

    private static final String ARQUIVO_PREFERENCIAS = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNome = findViewById(R.id.textoNomeId);
        salvar = findViewById(R.id.botaoId);
        resultado = findViewById(R.id.respostaId);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAS, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (textoNome.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Favor preencher o nome!", Toast.LENGTH_SHORT).show();
                }else {
                    editor.putString("nome", textoNome.getText().toString());
                    editor.commit();
                    resultado.setText("Olá, "+textoNome.getText().toString());
                }
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAS, 0);
        if (sharedPreferences.contains("nome")){
            String nomeUsuario = sharedPreferences.getString("nome", "usuário não definido");
            resultado.setText("Olá, "+nomeUsuario);
        }else {
            resultado.setText("Olá, usuário não definido!");
        }
    }
}
