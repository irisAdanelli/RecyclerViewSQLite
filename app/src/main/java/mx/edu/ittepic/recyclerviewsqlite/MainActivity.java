package mx.edu.ittepic.recyclerviewsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public int i;

    private Button btnInsertar,btnActualizar, btnBorrar,btnConsultar;

    private BaseDatosAlumno managerAlumno;
    private RecyclerView recycler;
    private AlumnoAdapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<Alumno> listaItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        managerAlumno= new BaseDatosAlumno(this);
        adViews();

        inicializarRecicler();
    }

    private void adViews() {


    }



    public void inicializarRecicler() {

        listaItems = managerAlumno.getAlumnosList();



        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.recyclerview);
        recycler.setHasFixedSize(true);


        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        //recycler.setLayoutManager(lManager);


        // Crear un nuevo adaptador
        adapter = new AlumnoAdapter(listaItems, this);

        //recycler.setAdapter(adapter);


        //recycler.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onClick(View v) { }

    private void recargarRecicler() {
        //cargar datos
        listaItems = managerAlumno.getAlumnosList();
        // Crear un nuevo adaptador
        adapter = new AlumnoAdapter(listaItems, this);
        //recycler.setAdapter(adapter);
        //recycler.setItemAnimator(new DefaultItemAnimator());

    }


    @Override
    protected void onDestroy() {

        managerAlumno.cerrar();

        super.onDestroy();
    }
}
