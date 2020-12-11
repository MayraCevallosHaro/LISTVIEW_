package com.example.listview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview.Model.Usuario;
import com.example.listview.R;

import java.util.ArrayList;

public class AdaptadorUsuario extends ArrayAdapter<Usuario> {
    public AdaptadorUsuario(Context context, ArrayList<Usuario> datos) {
    super(context, R.layout.activity_ly_item, datos);
}

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.activity_ly_item, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
        TextView lblemail = (TextView)item.findViewById(R.id.lblEmail);
        TextView lblweb = (TextView)item.findViewById(R.id.lblweb);

        lblNombre.setText(getItem(position).getCountry());
        lblemail.setText(getItem(position).getNewConfirmed());
        lblweb.setText(getItem(position).getTotalConfirmed());

        return(item);
    }

}

