package com.example.marco.luna.Controller;

/**
 * Created by Marco on 6/20/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.accessibility.AccessibilityManager;


import java.net.FileNameMap;
import java.util.LinkedList;
public class Database extends SQLiteOpenHelper {

    public static final String BASE_DE_DATOS = "luna_base";
    public static final int VERSION = 1;

    public static final String TEXT = " TEXT, ";
    public static final String TAG = "tag";
    public static final String INT = " INT, ";


    //tabla cuentas
    public static final String CUENTA_TABLA = "cuentas";
    public static final String CUENTA_ID = "id";
    public static final String CUENTA_NOMBRE = "nombre_cliente";
    public static final String CUENTA_FECHA = "fecha";
    public static final String CUENTA_PAGADA = "pagada";

    //tabla alimentos
    public static final String ALIMENTO_TABLA = "alimentos";
    public static final String ALIMENTO_ID = "id";
    public static final String ALIMENTO_NOMBRE = "nombre";
    public static final String ALIMENTO_PRECIO = "precio";

    //tabla guarnicion
    public static final String GUARNICION_TABLA = "guarniciones";
    public static final String GUARNICION_ID = "id";
    public static final String GUARNICION_NOMBRE = "nombre";
    public static final String GUARNICION_CANTIDAD = "cantidad";

    //tabla ingredientes
    public static final String INGREDIENTE_TABLA = "ingredientes";
    public static final String INGREDIENTE_ID = "id";
    public static final String INGREDIENTE_NOMBRE = "nombre";

    //tabla sopes y gorditas
    public static final String SG_TABLA = "sg";
    public static final String SG_ID = "id";
    public static final String SG_QUESILLO = "quesillo";
    public static final String SG_NOMBRE = "nombre";
    public static final String SG_PRECIO ="precio";


    //tabla bebidas
    public static final String BEBIDA_TABLA = "bebidas";
    public static final String BEBIDA_ID = "id";
    public static final String BEBIDA_CANTIDAD = "cantidad";
    public static final String BEBIDA_TAMA = "tamanio";
    public static final String BEBIDA_NOMBRE = "nombre";
    public static final String BEBIDA_PRECIO = "precio";

    //*****relaciones******

    //cuenta bebidas
    public static final String CUENTA_BEBIDA_TABLA = "cuenta_bebidas";
    public static final String CUENTA_BEBIDA_CUENTAID = "cuenta_id";
    public static final String CUENTA_BEBIDA_BEBIDAID = "bebida_id";

    //cuenta alimentos
    public static final String CUENTA_ALIMENTOS_TABLA = "cuenta_alimentos";
    public static final String CUENTA_ALIMENTOS_CUENTAID = "cuenta_id";
    public static final String CUENTA_ALIMENTOS_ALIMENTOID = "alimento_id";

    //alimentos guarnicion
    public static final String ALIMENTOS_GUARNICION_TABLA = "alimentos_guarnicion";
    public static final String ALIMENTOS_GUARNICION_ALIMENTOID = "alimento_id";
    public static final String ALIMENTO_GUARNICION_GUARNICIONID = "guarnicion_id";

    //alimentos ingredientes
    public static final String ALIMENTOS_INGREDIENTES_TABLA = "alimentos_ingredientes";
    public static final String ALIMENTOS_INGREDIENTES_ALIMENTOSID = "alimentos_id";
    public static final String ALIMENTOS_INGREDIENTES_INGREDIENTEID = "ingrediente_id";

    //SG ingredientes
    public static final String SG_INGREDIENTES_TABLA = "sg_ingredientes";
    public static final String SG_INGREDIENTES_SGID = "sg_id";
    public static final String SG_INGREDIENTES_INGREDIENTESID = "ingredientes_id";

    //SG guarnicion
    public static final String SG_GUARNICION_TABLA = "sg_guarnicion";
    public static final String SG_GUARNICION_SGID = "sg_id";
    public static final String SG_GUARNICION_GUARNICIONID = "guarnicion_id";


    //SQL
    //CREATE TABLES
    public static final String SQL_CREATE_CUENTA = "CREATE TABLE " + CUENTA_TABLA + "(" + CUENTA_ID +" INT PRIMARY KEY, "+ CUENTA_NOMBRE + TEXT + CUENTA_PAGADA + INT + CUENTA_FECHA + " TEXT )";
    public static final String SQL_CREATE_ALIMENTOS = "CREATE TABLE " + ALIMENTO_TABLA + "(" + ALIMENTO_ID +" INT PRIMARY KEY, "+ ALIMENTO_NOMBRE + TEXT + ALIMENTO_PRECIO + " INT )";
    public static final String SQL_CREATE_BEBIDAS = "CREATE TABLE " + BEBIDA_TABLA + "(" + BEBIDA_ID+" INT PRIMARY KEY, "+ BEBIDA_NOMBRE + TEXT + BEBIDA_CANTIDAD + INT + BEBIDA_PRECIO + INT + BEBIDA_TAMA + " INT )";
    public static final String SQL_CREATE_GUARNICION = "CREATE TABLE " + GUARNICION_TABLA + "(" + GUARNICION_ID +" INT PRIMARY KEY, " + GUARNICION_NOMBRE + TEXT + GUARNICION_CANTIDAD + " INT )";
    public static final String SQL_CREATE_INGREDIENTES = "CREATE TABLE " + INGREDIENTE_TABLA + "(" + INGREDIENTE_NOMBRE + TEXT + INGREDIENTE_ID +" INT PRIMARY KEY )";
    public static final String SQL_CREATE_SG = "CREATE TABLE " + SG_TABLA + "(" + SG_ID+" INT PRIMARY KEY, "+ SG_NOMBRE + TEXT + SG_PRECIO + INT + SG_QUESILLO + " INT )";

    //CREATE RELATIONSHIPS
    public static final String SQL_CREATE_CUENTA_BEBIDA = "CREATE TABLE " + CUENTA_BEBIDA_TABLA + "(" + CUENTA_BEBIDA_BEBIDAID + INT + CUENTA_BEBIDA_CUENTAID + " INT, FOREIGN KEY(cuenta_id) REFERENCES cuentas(id), FOREIGN KEY(bebida_id) REFERENCES bebidas(id))";
    public static final String SQL_CREATE_CUENTA_ALIMENTO = "CREATE TABLE " + CUENTA_ALIMENTOS_TABLA + "(" + CUENTA_ALIMENTOS_ALIMENTOID + INT + CUENTA_ALIMENTOS_CUENTAID + " INT, FOREIGN KEY(cuenta_id) REFERENCES cuentas(id), FOREIGN KEY(alimento_id) REFERENCES alimentos(id))";
    public static final String SQL_CREATE_ALIMENTO_GUARNICION = "CREATE TABLE " + ALIMENTOS_GUARNICION_TABLA + "(" + ALIMENTO_GUARNICION_GUARNICIONID + INT + ALIMENTOS_GUARNICION_ALIMENTOID + " INT, FOREIGN KEY(alimento_id) REFERENCES alimentos(id), FOREIGN KEY(guarnicion_id) REFERENCES guarniciones(id))";
    public static final String SQL_CREATE_ALIEMENTO_INGREDIENTE = "CREATE TABLE " + ALIMENTOS_INGREDIENTES_TABLA + "(" + ALIMENTOS_INGREDIENTES_ALIMENTOSID + INT + ALIMENTOS_INGREDIENTES_INGREDIENTEID + " INT, FOREIGN KEY(alimentos_id) REFERENCES alimentos(id), FOREIGN KEY(ingrediente_id) REFERENCES ingredientes(id))";
    public static final String SQL_CREATE_SG_GUARNICION = "CREATE TABLE " + SG_GUARNICION_TABLA + "(" + SG_GUARNICION_GUARNICIONID + INT + SG_GUARNICION_SGID + " INT, FOREIGN KEY(sg_id) REFERENCES sg(id), FOREIGN KEY(guarnicion_id) REFERENCES guarniciones(id))";
    public static final String SQL_CREATE_SG_INGREDIENTE = "CREATE TABLE " + SG_INGREDIENTES_TABLA + "(" + SG_INGREDIENTES_INGREDIENTESID + INT + SG_INGREDIENTES_SGID + " INT, FOREIGN KEY(sg_id) REFERENCES sg(id), FOREIGN KEY(ingredientes_id) REFERENCES ingredientes(id))";



    //SQL INSERT ingredientes
    public static final String PAPA = "INSERT INTO ingredientes VALUES(1, 'papa')";
    public static final String QUESO ="INSERT INTO ingredientes VALUES(2, 'queso')";
    public static final String PANZA = "INSERT INTO ingredientes VALUES(3, 'panza')";
    public static final String JAMON ="INSERT INTO ingredientes VALUES(4, 'jamon')";
    public static final String CARNE = "INSERT INTO ingredientes VALUES(5, 'carne')";
    public static final String PICADILLO ="INSERT INTO ingredientes VALUES(6, 'picadillo')";
    public static final String POLLO = "INSERT INTO ingredientes VALUES(7, 'pollo')";
    public static final String SESOS ="INSERT INTO ingredientes VALUES(8, 'sesos')";
    public static final String CHICHARRON = "INSERT INTO ingredientes VALUES(9, 'chicharron')";
    public static final String TINGA ="INSERT INTO ingredientes VALUES(10, 'tinga')";
    public static final String CHAMPINONES = "INSERT INTO ingredientes VALUES(11, 'champinon')";

    //SQL INSERT bebidas
    public static final String coca600 = "INSERT INTO bebidas VALUES (1, 1, 600, 'coca desechable', 13)";
    public static final String cocaVidrio ="INSERT INTO bebidas VALUES (2, 1, 500, 'coca vidrio', 13)";
    public static final String sidral = "INSERT INTO bebidas VALUES (3, 1, 500, 'sidral', 13)";
    public static final String boing = "INSERT INTO bebidas VALUES (4, 1, 500, 'boing', 13)";
    public static final String jarrito ="INSERT INTO bebidas VALUES (5, 1, 600, 'jarrito', 13)";


    //SQL INSERT guarnicion

    public static final String salsav = "INSERT INTO guarniciones VALUES(1, 'salsa verde', 'verde')";
    public static final String salsar = "INSERT INTO guarniciones VALUES (2, 'salsa roja', 'verde')";
    public static final String lechuga = "INSERT INTO guarniciones VALUES (3, 'lechuga', 'lechuga')";
    public static final String crema = "INSERT INTO guarniciones VALUES (4, 'crema', 'crema')";
    public static final String queso = "INSERT INTO guarniciones VALUES (5, 'queso', 'queso')";

    public Database(Context context){
        super(context, BASE_DE_DATOS, null, VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CUENTA);
        db.execSQL(SQL_CREATE_ALIMENTOS);
        db.execSQL(SQL_CREATE_BEBIDAS);
        db.execSQL(SQL_CREATE_GUARNICION);
        db.execSQL(SQL_CREATE_INGREDIENTES);
        db.execSQL(SQL_CREATE_SG);
        db.execSQL(SQL_CREATE_CUENTA_BEBIDA);
        db.execSQL(SQL_CREATE_CUENTA_ALIMENTO);
        db.execSQL(SQL_CREATE_ALIMENTO_GUARNICION);
        db.execSQL(SQL_CREATE_ALIEMENTO_INGREDIENTE);
        db.execSQL(SQL_CREATE_SG_GUARNICION);
        db.execSQL(SQL_CREATE_SG_INGREDIENTE);
        db.execSQL(PAPA);
        db.execSQL(QUESO);
        db.execSQL(PANZA);
        db.execSQL(JAMON);
        db.execSQL(CARNE);
        db.execSQL(PICADILLO);
        db.execSQL(POLLO);
        db.execSQL(SESOS);
        db.execSQL(CHICHARRON);
        db.execSQL(TINGA);
        db.execSQL(CHAMPINONES);
        db.execSQL(coca600);
        db.execSQL(cocaVidrio);
        db.execSQL(sidral);
        db.execSQL(boing);
        db.execSQL(jarrito);
        db.execSQL(salsav);
        db.execSQL(salsar);
        db.execSQL(lechuga);
        db.execSQL(crema);
        db.execSQL(queso);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
