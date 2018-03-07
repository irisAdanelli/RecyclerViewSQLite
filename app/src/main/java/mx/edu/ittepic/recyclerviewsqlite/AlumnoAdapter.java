package mx.edu.ittepic.recyclerviewsqlite;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by OEM on 01/03/2018.
*/

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {

    private Context mainContext;
    private List<Alumno> items;

    public AlumnoAdapter(List<Alumno> items, Context contexto) {
        this.mainContext = contexto;
        this.items = items;
    }
    static class AlumnoViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        protected TextView id;
        protected TextView nombre;
        protected TextView domicilio;
        protected TextView edad;


        public AlumnoViewHolder(View v) {
            super(v);

            this.id = (TextView) v.findViewById(R.id.tv_curso_id);
            this.nombre = (TextView) v.findViewById(R.id.tv_curso_nombre);
            this.domicilio = (TextView) v.findViewById(R.id.tv_curso_descripcion);
            this.edad = (TextView) v.findViewById(R.id.tv_curso_precio);

        }
    }
    @Override
    public AlumnoViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_alumno, viewGroup, false);

        return new AlumnoViewHolder(v);
    }
    @Override
    public void onBindViewHolder(AlumnoViewHolder viewHolder, int position) {
        Alumno item = items.get(position);
        viewHolder.itemView.setTag(item);

        viewHolder.id.setText("Nº: "+item.getId());
        viewHolder.nombre.setText("Nombre: " +  item.getNombre());
        viewHolder.domicilio.setText("Domicilio: " +  item.getDomicilio());
        viewHolder.edad.setText("Edad: " + item.getEdad());


    }
    @Override
    public int getItemCount() {
        return items.size();
    }
}
