package baltanesi.com.projetakipsistemi.Ogretmen;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.w3c.dom.Text;

import baltanesi.com.projetakipsistemi.R;

public class HerOgrenciProjeDetayActivity extends AppCompatActivity {

    Text ogrenciAdi, ogrenciProjeAdi;
    ListView ogrenciHaftalikTumList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_her_ogrenci_proje_detay);

        baslangic();
    }

    @SuppressLint("WrongViewCast")
    private void baslangic() {

        ogrenciAdi = findViewById(R.id.ogrenciAdi);
        ogrenciProjeAdi = findViewById(R.id.ogrenciProjeAdi);
        ogrenciHaftalikTumList = findViewById(R.id.ogrenciHaftalıkProjeListesi);
        ogrenciHaftalikTumList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
