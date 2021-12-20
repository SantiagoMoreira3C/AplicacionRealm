package facci.am1.realmandroid.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Producto extends RealmObject {
    @PrimaryKey

    private int id;
    private String name;
    private String tipo;
    private RealmList<Proveedor> proveedores;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public RealmList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(RealmList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
}
