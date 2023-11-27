package com.example.trab4bi.adpter;

import android.content.Context;
import android.sax.TextElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trab4bi.R;
import com.example.trab4bi.model.DadosDeputados;
import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.view.ListaDeputadosActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DeputadoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DadosDeputados> lista;

    public DeputadoAdapter(Context context, List<DadosDeputados> deputados) {
        this.context = context;
        this.lista = new ArrayList<>(deputados);
    }

    public void add(List<DadosDeputados> dadosDeputados) {
        lista.addAll(dadosDeputados);
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
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_deputado_activity, viewGroup, false);
        }

        DadosDeputados deputadoDados = lista.get(i); // Pega o deputado na posição i

        TextView idDeputado = view.findViewById(R.id.tvIdDeputado);
        TextView nomeDeputado = view.findViewById(R.id.tvNomeDeputado);
        TextView partidoDeputado = view.findViewById(R.id.tvPartidoDeputado);

        idDeputado.setText(String.valueOf(deputadoDados.getId()));
        nomeDeputado.setText(deputadoDados.getNome());
        partidoDeputado.setText(deputadoDados.getSiglaPartido());

        return view;
    }


}
