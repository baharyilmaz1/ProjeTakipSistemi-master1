package baltanesi.com.projetakipsistemi.Ogretmen;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

import baltanesi.com.projetakipsistemi.R;

public class ProjeIstekleriDetayActivity extends AppCompatActivity {

    Text projeIstegiYollayan, projeIstegiBaslik, projeIstegiIcerik;
    Button btnProjeOnayla, btnProjeIptalEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proje_istekleri_detay);

        baslangic();
    }

    @SuppressLint("WrongViewCast")
    private void baslangic() {
        projeIstegiYollayan = findViewById(R.id.txtProjeYollayan);
        projeIstegiBaslik = findViewById(R.id.txtProjeBaslik);
        projeIstegiIcerik = findViewById(R.id.txtProjeIcerigi);
        btnProjeOnayla = findViewById(R.id.onerilenProjeyiOnayla);
        btnProjeIptalEt = findViewById(R.id.onerilenProjeyiIptalEt);

        btnProjeIptalEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnProjeOnayla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
