package com.example.trab4bi.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trab4bi.R;
import com.example.trab4bi.model.DadosDeputados;
import com.example.trab4bi.model.DadosPartido;
import com.example.trab4bi.model.Deputado;
import com.example.trab4bi.model.Partido;

import java.util.ArrayList;
import java.util.List;

public class PartidoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Partido> lista = new ArrayList<>();

    public PartidoAdapter(Context context, List<Partido> partido) {
        this.context = context;
        this.lista = new ArrayList<>(partido);
    }

    public void add(Partido partido) {
        lista.add(partido);
    }
    public void addAll(List<Partido> partido){
        this.lista.addAll(partido);
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
            view = LayoutInflater.from(context).inflate(R.layout.item_partidos_activity, viewGroup, false);
        }

        Partido partido = lista.get(i);

        if (partido != null) {
            List<DadosPartido> dadosList = partido.getDados();

            // Limpar o conteúdo anterior para evitar duplicatas
            ViewGroup itemContainer = view.findViewById(R.id.itemContainerPartido);
            itemContainer.removeAllViews();

            // Iterar sobre a lista de dados e criar visualizações para cada deputado
            for (DadosPartido dadosPartido : dadosList) {
                View partidoView = LayoutInflater.from(context).inflate(R.layout.item_partidos_activity, viewGroup, false);

                TextView idPartido = partidoView.findViewById(R.id.tvIdPartido);
                TextView siglaPartido = partidoView.findViewById(R.id.tvSiglaPartido);
                TextView nomePartido = partidoView.findViewById(R.id.tvNomePartido);

                idPartido.setText(String.valueOf(dadosPartido.getId()));
                nomePartido.setText(dadosPartido.getNome());
                siglaPartido.setText(dadosPartido.getSigla());

                // Adicionar a visualização do partido ao contêiner
                itemContainer.addView(partidoView);
            }
        }

        return view;
    }

}
