package baltanesi.com.projetakipsistemi.Ogretmen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import baltanesi.com.projetakipsistemi.R;

public class ProjeIstekleriActivity extends AppCompatActivity {

    ListView tumProjeIStekleriListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proje_istekleri);
        tumProjeIStekleriListview = findViewById(R.id.tumProjeIStekleriListView);

        tumProjeIStekleriListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

}
