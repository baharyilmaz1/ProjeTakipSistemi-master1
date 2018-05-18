package baltanesi.com.projetakipsistemi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ProjeOnermeActivity extends AppCompatActivity {

    EditText edtTextProjeBaslik, edtTextProjeIcerik;
    Button btnProjeOlustur;
    String textProjeBaslik, textProjeIcerik;
    Context context = this;
    String userId = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proje_onerme);
        baslangic();
    }

    private void baslangic() {

        edtTextProjeBaslik = findViewById(R.id.edtTextProjeAdi);
        edtTextProjeIcerik = findViewById(R.id.edtTextProjeİcerigi);
        btnProjeOlustur = findViewById(R.id.btnProjeOlustur);

        btnProjeOlustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (kontroller() == 0 ) {
                 Toast.makeText(context, "Alanlar boş girilemez", Toast.LENGTH_SHORT).show();
             } else {
                 serviseBaglan();
                 //Proje başarıyla oluştu ve yolladı
             }
            }
        });
    }

    private int kontroller() {

        textProjeBaslik = edtTextProjeBaslik.getText().toString().trim();
        textProjeIcerik = edtTextProjeIcerik.getText().toString().trim();

        if (textProjeBaslik.equals("") || textProjeIcerik.equals("")) {
            return  0;
        }
        else {
            return  1;
        }
    }

    private void serviseBaglan() {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "localhost:8888/projetakipsistemi/projeonerme.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }}) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user_id", userId);
                params.put("proje_baslik", textProjeBaslik);
                params.put("proje_icerik", textProjeIcerik);
                return params;}};
        queue.add(postRequest);
    }
}
