package facci.pm.ta2.poo.pra1;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import facci.pm.ta2.poo.datalevel.DataException;
import facci.pm.ta2.poo.datalevel.DataObject;
import facci.pm.ta2.poo.datalevel.DataQuery;
import facci.pm.ta2.poo.datalevel.GetCallback;

public class DetailActivity extends AppCompatActivity {
    TextView precio, ladescripcion, nombre;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("PR1 :: Detail");


        // INICIO - CODE6

        //Pregunta 3.3

        precio = (TextView)findViewById(R.id.precio);
        ladescripcion = (TextView)findViewById(R.id.ladescripcion);
        nombre = (TextView)findViewById(R.id.nombre);

        image = (ImageView)findViewById(R.id.thumbnail);


        final DataQuery query = DataQuery.get("item");
        String parametro = getIntent().getExtras().getString("prueba");
        query.getInBackground(parametro, new GetCallback<DataObject>() {
            @Override
            public void done(DataObject object, DataException e) {
                if (e==null){

                    String prais = (String) object.get("price");
                    String descripshon = (String) object.get("description");
                    String neim = (String) object.get("name");
                    Bitmap bitmap = (Bitmap) object.get("image");

                    precio.setText("$"+prais);
                    precio.setTextColor(getColor(R.color.precioRojo));
                    ladescripcion.setText(descripshon);
                    nombre.setText(neim);
                    image.setImageBitmap(bitmap);

                }else {

                }
            }
        });

        // se tomó el control de los textview creados con anterioridad para recibir parámetros.



        // FIN - CODE6

    }

}
