package com.example.listview.Model;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuario {

    private String Country;
    private String NewConfirmed;
    private String TotalConfirmed;

    public String getCountry() {
        return Country;
    }

    public String getNewConfirmed() {
        return NewConfirmed;
    }

    public String getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public void setNewConfirmed(String newconfirmed) {
        this.NewConfirmed = newconfirmed;
    }

    public void setTotalConfirmed(String totalconfirmed) {
        this.TotalConfirmed = totalconfirmed;
    }


    public Usuario(JSONObject a) throws JSONException {
        Country =  a.getString("Country").toString();
        NewConfirmed =  a.getString("NewConfirmed").toString() ;
        TotalConfirmed =  a.getString("TotalConfirmed").toString() ;


    }

    public static ArrayList<Usuario> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            usuarios.add(new Usuario(datos.getJSONObject(i)));
        }
        return usuarios;
    }
}

