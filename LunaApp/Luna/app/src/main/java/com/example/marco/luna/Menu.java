package com.example.marco.luna;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;

import com.example.marco.luna.Controller.Database;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Resources res = getResources();
        final TabHost tab = (TabHost)findViewById(R.id.tabHost2);
        tab.setup();

        TabHost.TabSpec spec = tab.newTabSpec("mitad1");
        Intent intent = new Intent();
        //intent.setClass(this, Ordenf.class);
        spec.setContent(intent);
        spec.setIndicator("Ordenes pendientes", res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tab.addTab(spec);


        spec = tab.newTabSpec("mitad2");
        spec.setContent(R.id.tabb2);
        spec.setIndicator("Crear orden", res.getDrawable(android.R.drawable.ic_dialog_alert));
        tab.addTab(spec);

        spec = tab.newTabSpec("mitad3");
        spec.setContent(R.id.tabb3);
        spec.setIndicator("Ordenes pagadas", res.getDrawable(android.R.drawable.ic_dialog_alert));
        tab.addTab(spec);

        spec = tab.newTabSpec("mitad4");
        spec.setContent(R.id.tabb4);
        spec.setIndicator("Total de venta", res.getDrawable(android.R.drawable.ic_dialog_alert));
        tab.addTab(spec);
        for(int i=0;i<tab.getTabWidget().getChildCount();i++)
        {
            tab.getTabWidget().getChildAt(i).setBackgroundColor(Color.CYAN);
        }

        tab.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#00C3FF"));

        tab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            public void onTabChanged(String arg0) {
                for (int i = 0; i < tab.getTabWidget().getChildCount(); i++) {
                    tab.getTabWidget().getChildAt(i)
                            .setBackgroundColor(Color.CYAN); // unselected
                }
                tab.getTabWidget().getChildAt(tab.getCurrentTab())
                        .setBackgroundColor(Color.parseColor("#00C3FF")); // selected

            }
        });
tab.setCurrentTab(0);
    }
    public void proof(View view) {
        Database db = new Database(getBaseContext());
        SQLiteDatabase dB = db.getWritableDatabase();
        String querry = "SELECT * FROM ingredientes;";
        Log.d(Database.TAG, querry);
        Cursor c = dB.rawQuery(querry, null);
        c.moveToFirst();
        String k = c.getString(1);
        String[] a = c.getColumnNames();
        System.out.println(a.length);
        for (int j = 0; j<a.length; j++){
         System.out.println(a[j]);
        }

        //comentario.setText(k);
    }

}
