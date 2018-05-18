package baltanesi.com.projetakipsistemi;

import android.content.Context;
import android.content.Intent;
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

import baltanesi.com.projetakipsistemi.Ogrenci.OgrenciAnasayfaActivity;
import baltanesi.com.projetakipsistemi.Ogretmen.OgretmenAnasayfaActivty;

public class GirisActivity extends AppCompatActivity {

    EditText edtTextMailAdresi, edtTextSifre;
    Button btnOgretmenGirisi, btnOgrenciGirisi, btnKaiytOl;
    String textMail, textSifre;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        baslangic();
    }

    private void baslangic() {
        edtTextMailAdresi = findViewById(R.id.edtTextGirisMail);
        edtTextSifre = findViewById(R.id.edtTextGirisSifre);
        btnOgretmenGirisi = findViewById(R.id.btnOgretmenGiris);
        btnOgrenciGirisi = findViewById(R.id.btnOgrenciGiris);
        btnKaiytOl = findViewById(R.id.btnKayit);


        btnKaiytOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kayitSayfasinaGit = new Intent(context,KayitActivity.class);
                startActivity(kayitSayfasinaGit);
            }
        });

        btnOgretmenGirisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             int degerlerBoşmu =   verileriTextlerdenAl();

             if (degerlerBoşmu == 0) {
                 Toast.makeText(context, "Değerler Boş Girilemez", Toast.LENGTH_SHORT).show();
                } else {
                 if (textMail.equals("muhammetbaykara@gmail.com") && textSifre.equals("123456")) {
                     Intent ogretmenAnasayfasınaGit = new Intent(context, OgretmenAnasayfaActivty.class);
                     startActivity(ogretmenAnasayfasınaGit);
                 } else {
                     Toast.makeText(context, "Değerler Yanlış", Toast.LENGTH_SHORT).show();
                 }
             }
            }

        });

        btnOgrenciGirisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int degerlerBoşmu =   verileriTextlerdenAl();
                if (degerlerBoşmu == 0) {
                    Toast.makeText(context, "Değerler Boş Girilemez", Toast.LENGTH_SHORT).show();
                } else {
                    serviseBaglan();
                   // Intent ogrenciAnasayfasınaGit = new Intent(context,OgrenciAnasayfaActivity.class);
                   // startActivity(ogrenciAnasayfasınaGit);
                }
            }
        });
    }

    public int verileriTextlerdenAl() {
            textMail = edtTextMailAdresi.getText().toString().trim();
            textSifre = edtTextSifre.getText().toString().trim();
          if (textSifre.equals("") || textMail.equals("")) {
              return  0;
        }
         else {
              return  1;
          }
    }

    private void serviseBaglan() {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "localhost:8888/projetakipsistemi/giris.php";
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
                params.put("mail", textMail);
                params.put("sifre", textSifre);
                return params;}};
        queue.add(postRequest);
    }

}
