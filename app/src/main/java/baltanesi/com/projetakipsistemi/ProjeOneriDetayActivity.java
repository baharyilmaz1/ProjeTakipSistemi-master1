package baltanesi.com.projetakipsistemi;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

public class ProjeOneriDetayActivity extends AppCompatActivity {

    Text txtProjeBaslik, txtProjeİcerik, txtProjeOneren;
    Button btnProjeyiAl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proje_oneri_detay);

        baslangic();
    }

    @SuppressLint("WrongViewCast")
    private void baslangic() {
        txtProjeBaslik = findViewById(R.id.txtProjeAdi);
        txtProjeİcerik = findViewById(R.id.txtProjeDetayı);
        btnProjeyiAl = findViewById(R.id.btnProjeyiSec);
        txtProjeOneren = findViewById(R.id.projeOneren);

        btnProjeyiAl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Proje seçildi
            }
        });
    }
}
