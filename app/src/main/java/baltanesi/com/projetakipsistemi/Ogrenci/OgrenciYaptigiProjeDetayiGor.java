package baltanesi.com.projetakipsistemi.Ogrenci;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.w3c.dom.Text;

import  baltanesi.com.projetakipsistemi.R;
public class OgrenciYaptigiProjeDetayiGor extends AppCompatActivity {

    Text txtProjeAdi, txtProjeIcerik, txtProjeTarih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_yaptigi_proje_detayi_gor);
        baslangic();
    }

    @SuppressLint("WrongViewCast")
    private void baslangic() {
        txtProjeAdi = findViewById(R.id.detayProjeAdi);
        txtProjeIcerik = findViewById(R.id.detayProjeICerik);
        txtProjeTarih = findViewById(R.id.detayProjeTarih);
    }
}
