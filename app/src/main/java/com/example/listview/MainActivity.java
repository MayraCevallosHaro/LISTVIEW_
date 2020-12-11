package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.listview.Adapter.AdaptadorUsuario;
import com.example.listview.Model.Usuario;
import com.example.listview.WebService.Asynchtask;
import com.example.listview.WebService.WebService;
public class MainActivity extends AppCompatActivity implements Asynchtask
{
    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstOpciones = (ListView)findViewById(R.id.lstListaUsuario);

        View header = getLayoutInflater().inflate(R.layout.activity_ly_header, null);
        lstOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://api.covid19api.com/summary",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");



    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Usuario> lstUsuarios = new ArrayList<Usuario> ();

        try {

            JSONObject JSONlista =  new JSONObject(result);
            JSONArray JSONlistaUsuarios=  JSONlista.getJSONArray("data");

            lstUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);

            AdaptadorUsuario adapatorUsuario = new AdaptadorUsuario(this, lstUsuarios);

            lstOpciones.setAdapter(adapatorUsuario);

        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }


    }
}