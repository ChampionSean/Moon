package com.example.marco.luna;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class Tabbs extends AppCompatActivity implements Orden.OnFragmentInteractionListener, FormOrden.OnFragmentInteractionListener, OrdenPagada.OnFragmentInteractionListener, VentasTotales.OnFragmentInteractionListener {
    private FragmentTabHost myHost;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);
        myHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        myHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        myHost.addTab(
                myHost.newTabSpec("tab1").setIndicator("Ordenes", null),
                Orden.class, null);

        myHost.addTab(
                myHost.newTabSpec("tab2").setIndicator("Crear Orden", null),
                FormOrden.class, null);

        myHost.addTab(
                myHost.newTabSpec("tab3").setIndicator("Ordenes Pagadas", null),
                OrdenPagada.class, null);

        myHost.addTab(
                myHost.newTabSpec("tab4").setIndicator("Ventas Totales", null),
                VentasTotales.class, null);

        for(int i=0;i<myHost.getTabWidget().getChildCount();i++)
        {
            myHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.CYAN);
        }

        myHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#00C3FF"));

        myHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            public void onTabChanged(String arg0) {
                for (int i = 0; i < myHost.getTabWidget().getChildCount(); i++) {
                    myHost.getTabWidget().getChildAt(i)
                            .setBackgroundColor(Color.CYAN); // unselected
                }
                myHost.getTabWidget().getChildAt(myHost.getCurrentTab())
                        .setBackgroundColor(Color.parseColor("#00C3FF")); // selected

            }
        });


    }

    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }


}
