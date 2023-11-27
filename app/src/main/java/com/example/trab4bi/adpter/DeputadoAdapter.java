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
    private ArrayList<Deputado> lista = new ArrayList<>();

    public DeputadoAdapter(Context context, List<Deputado> deputados) {
        this.context = context;
        this.lista = new ArrayList<>(deputados);
    }

    public void add(Deputado deputado) {
        lista.add(deputado);
    }
    public void addAll(List<Deputado> deputados){
      this.lista.addAll(deputados);
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

        Deputado deputado = lista.get(i);
        List<DadosDeputados> dadosList = deputado.getDados();

        // Limpar o conteúdo anterior para evitar duplicatas
        ViewGroup itemContainer = view.findViewById(R.id.itemContainer);
        itemContainer.removeAllViews();

        // Iterar sobre a lista de dados e criar visualizações para cada deputado
        for (DadosDeputados deputadoDados : dadosList) {
            View deputadoView = LayoutInflater.from(context).inflate(R.layout.item_deputado_activity, viewGroup, false);

            TextView idDeputado = deputadoView.findViewById(R.id.tvIdDeputado);
            TextView nomeDeputado = deputadoView.findViewById(R.id.tvNomeDeputado);
            TextView partidoDeputado = deputadoView.findViewById(R.id.tvPartidoDeputado);

            idDeputado.setText(String.valueOf(deputadoDados.getId()));
            nomeDeputado.setText(deputadoDados.getNome());
            partidoDeputado.setText(deputadoDados.getSiglaPartido());

            // Adicionar a visualização do deputado ao contêiner
            itemContainer.addView(deputadoView);
        }

        return view;
    }

}
