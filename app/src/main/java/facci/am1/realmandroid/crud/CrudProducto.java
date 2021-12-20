package facci.am1.realmandroid.crud;

import android.util.Log;

import java.util.List;

import facci.am1.realmandroid.model.Producto;
import io.realm.Realm;
import io.realm.RealmResults;

public class CrudProducto {

    private final static int calculateIndex(){
        Realm realm = Realm.getDefaultInstance();
        Number currentIdNum = realm.where(Producto.class).max("id");
        int nextId;
        if(currentIdNum == null){
            nextId = 0;
        }else{
            nextId = currentIdNum.intValue()+1;
        }
        return nextId;
    }
    public final static void addProducto(final Producto producto){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int index = CrudProducto.calculateIndex();
                Producto realmProducto = realm.createObject(Producto.class, index);
                realmProducto.setName(producto.getName());
                realmProducto.setTipo(producto.getTipo());
            }
        });
    }

    public final static List<Producto> getAllproducto(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Producto> productos  = realm.where(Producto.class).findAll();
        for(Producto producto: productos){
            Log.d("TAG", "id"+producto.getId()+"Producto:"+producto.getName() + "Tipo:" + producto.getTipo());
    }
    return productos;
    }
}
