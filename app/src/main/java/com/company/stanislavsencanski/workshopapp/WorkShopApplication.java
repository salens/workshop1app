package com.company.stanislavsencanski.workshopapp;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Sasa on 4/29/2017.
 */

public class WorkShopApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // initialize Fresco library
        Fresco.initialize(this);

    }
}
