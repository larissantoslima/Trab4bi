package com.example.trab4bi.adpter;

import android.content.Context;
import android.sax.TextElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trab4bi.R;
import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.view.ListaDeputadosActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DeputadoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Deputado> lista;

    public DeputadoAdapter(ListaDeputadosActivity listaDeputadosActivity, List<Deputado> deputados) {

    }

    public Context getContext(){
        return context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_deputado_activity, viewGroup, false);
        }
        Deputado deputado = lista.get(i);
        TextView idDeputado = view.findViewById(R.id.tvIdDeputado);
        TextView nomeDeputado = view.findViewById(R.id.tvNomeDeputado);
        TextView partidoDeputado = view.findViewById(R.id.tvPartidoDeputado);

        idDeputado.setText(Math.toIntExact(deputado.getDados().get(0).getId()));
        nomeDeputado.setText(deputado.getDados().get(0).getNome());
        partidoDeputado.setText(deputado.getDados().get(0).getSiglaPartido());

        return view;

    }
}
