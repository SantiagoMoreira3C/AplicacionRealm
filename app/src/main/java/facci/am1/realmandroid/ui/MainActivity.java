package facci.am1.realmandroid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import facci.am1.realmandroid.R;
import facci.am1.realmandroid.crud.CrudProducto;
import facci.am1.realmandroid.model.Producto;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private EditText nombreEt, tipoEt;
    private Button saveBT, leerTodoBt;
    private Producto producto;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
    }
    private void configView(){
        producto = new Producto();
        nombreEt = findViewById(R.id.mainActivityEtNombre);
        tipoEt = findViewById(R.id.mainActivityEtTipo);
        saveBT = findViewById(R.id.mainActivityBtnSave);
        saveBT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                producto.setName(nombreEt.getText().toString());
                producto.setTipo(tipoEt.getText().toString());
                CrudProducto.addProducto(producto);
            }
        });
        leerTodoBt = findViewById(R.id.mainActivityBtnReadAll);
        leerTodoBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                CrudProducto.getAllproducto();
            }
        });
    }
}