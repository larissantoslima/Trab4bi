package com.example.trab4bi.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trab4bi.R;
import com.example.trab4bi.model.DadosDeputados;
import com.example.trab4bi.model.DadosDespesa;

import java.util.ArrayList;
import java.util.List;

public class DespesaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DadosDespesa> lista;

    public DespesaAdapter(Context context, List<DadosDespesa> despesas) {
        this.context = context;
        this.lista = new ArrayList<>(despesas);
    }

    public void add(List<DadosDespesa> dadosDespesas) {
        lista.addAll(dadosDespesas);
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
            view = LayoutInflater.from(context).inflate(R.layout.item_despesa_deputado_activity, viewGroup, false);
        }
//tvTipoDespesa
//        tvFornecedor
//        tvValor
        DadosDespesa dadosDespesa = lista.get(i); // Pega o deputado na posição i

        TextView tvTipoDespesa = view.findViewById(R.id.tvTipoDespesa);
        TextView tvFornecedor = view.findViewById(R.id.tvFornecedor);
        TextView tvValor = view.findViewById(R.id.tvValor);

        tvTipoDespesa.setText(dadosDespesa.getTipoDespesa());
        tvFornecedor.setText(dadosDespesa.getNomeFornecedor());
        tvValor.setText(String.valueOf (dadosDespesa.getValorLiquido()));

        return view;
    }

}
