package com.example.marco.luna;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Marco on 7/4/2016.
 */
public class FragmentTabs extends AppCompatActivity {
    private FragmentTabHost myHost;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);
        myHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        myHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        myHost.addTab(
                myHost.newTabSpec("tab1").setIndicator("Tab 1", null),
                Orden.class, null);

        myHost.addTab(
                myHost.newTabSpec("tab2").setIndicator("Tab 2", null),
                FormOrden.class, null);

        myHost.addTab(
                myHost.newTabSpec("tab3").setIndicator("Tab 3", null),
                OrdenPagada.class, null);

        myHost.addTab(
                myHost.newTabSpec("tab4").setIndicator("Tab 4", null),
                VentasTotales.class, null);


    }
}
