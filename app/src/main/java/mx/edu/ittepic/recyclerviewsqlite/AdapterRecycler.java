package mx.edu.ittepic.recyclerviewsqlite;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by OEM on 28/02/2018.


public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolderDatos> {


    ArrayList<String> listDatos;

    public AdapterRecycler(ArrayList<String> listDatos) {
        this.listDatos = listDatos;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_alumno,null,false);
        return new ViewHolderDatos(view);
        //ocupar el contexto con parent
        //crear referencia
        //inflater el layout que "ocupamos" item_list
        //instanciar un objeto View
        //retornar el objeto de tipo ViewHolderDatos
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        //holder.asignarDatos(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView dato;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            dato=itemView.findViewById(R.id.idDato);

        }

        public void asignarDatos(Cursor cursor) {
            dato.setText(""+cursor);

        }
    }

}*/
