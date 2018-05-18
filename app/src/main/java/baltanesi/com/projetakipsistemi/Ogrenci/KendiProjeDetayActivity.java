package baltanesi.com.projetakipsistemi.Ogrenci;

import android.annotation.SuppressLint;
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
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import baltanesi.com.projetakipsistemi.R;

public class KendiProjeDetayActivity extends AppCompatActivity {

    Text txtProjeIsim;
    EditText edtTextProjeIcerik;
    Button btnProjeICerikYolla;
    String projeIcerik;
    Context context = this;
    String userId = "";
    String projeId = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kendi_proje_defat);

        baslangic();
    }

    @SuppressLint("WrongViewCast")
    private void baslangic() {
        txtProjeIsim = findViewById(R.id.txtProjeAdim);
        edtTextProjeIcerik = findViewById(R.id.edtTextProjeIcerikm);
        btnProjeICerikYolla = findViewById(R.id.btnHaftalikBilgiGonder);

        btnProjeICerikYolla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int durum = kontroller();
                if (durum == 1) {
                    serviseBaglan();
                //Web Servisi Çağır çalışssın
                } else {
                    Toast.makeText(context, "İçerikler Boş olamaz", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private int kontroller() {

        projeIcerik = edtTextProjeIcerik.getText().toString().trim();

        if (projeIcerik.equals("") ) {
            return  0;
        }
        else {
            return  1;
        }
    }
    private void serviseBaglan() {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "localhost:8888/projetakipsistemi/preojeicerikekleme.php";
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
                params.put("proje_id", projeId);
                params.put("proje_haftalik",projeIcerik);
                return params;}};
        queue.add(postRequest);
    }
}
