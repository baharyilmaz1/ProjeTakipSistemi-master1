package baltanesi.com.projetakipsistemi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import baltanesi.com.projetakipsistemi.Ogrenci.OgrenciAnasayfaActivity;

public class KayitActivity extends AppCompatActivity {

    EditText edtTesxtIsimSoyisim, edtTextMail, edtTextSifre, edtTextSifretekrar, edtTextTelNo;
    String textIsimSoyisim, textMail, textSifre, textSifretekrar, textTelNo;
    Button btnKayitOl;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        baslangic();
    }

    private void baslangic() {
        edtTesxtIsimSoyisim = findViewById(R.id.edtTextIsimSoyisim);
        edtTextMail = findViewById(R.id.edtTextMailAdresi);
        edtTextSifre = findViewById(R.id.edtTextSifre);
        edtTextSifretekrar = findViewById(R.id.edtTextSifreTekrar);
        edtTextTelNo = findViewById(R.id.edtTelefonNumarasi);
        btnKayitOl = findViewById(R.id.btnKayitOl);

       int durum =  verileriTextlerdenAl();
       if (durum == 0) {
           Toast.makeText(context, "Alanlar Boş Girilemez", Toast.LENGTH_SHORT).show();
       } else {
           if  (textSifre == textSifretekrar) {
               serviseBaglan();
           } else {
               Toast.makeText(context, "Şifreler uyuşmuyor", Toast.LENGTH_SHORT).show();
           }
           //Intent intent = new Intent(context , OgrenciAnasayfaActivity.class);
           //startActivity(intent);
       }

    }
    public int verileriTextlerdenAl() {

        textIsimSoyisim = edtTesxtIsimSoyisim.getText().toString().trim();
        textMail = edtTextMail.getText().toString().trim();
        textSifre = edtTextSifre.getText().toString().trim();
        textSifretekrar = edtTextSifretekrar.getText().toString().trim();
        textTelNo = edtTextTelNo.getText().toString().trim();


        if (textIsimSoyisim.equals("") || textMail.equals("") || textSifre.equals("") || textSifretekrar.equals("") || textTelNo.equals("")) {
            return  0;
        }
        else {
            return  1;
        }

    }
     private void serviseBaglan() {
         RequestQueue queue = Volley.newRequestQueue(context);
         String url = "localhost:8888/projetakipsistemi/kayit.php";
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
                 params.put("isim", textIsimSoyisim);
                 params.put("mail", textMail);
                 params.put("sifre", textSifre);
                 params.put("tel", textTelNo);
                 return params;}};
         queue.add(postRequest);


     }
}
