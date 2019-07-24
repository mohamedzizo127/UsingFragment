package com.ps.mohamed.usingfragment.Activities;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ps.mohamed.usingfragment.Fragments.MainFragment;
import com.ps.mohamed.usingfragment.Fragments.PickPowerFragment;
import com.ps.mohamed.usingfragment.R;

public class MainActivity extends  AppCompatActivity
        implements MainFragment.MainFragmentInteractionListener
,                  PickPowerFragment.OnPickPowerFragmentInteractionListener{

    private FragmentManager mFragmentManager;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create fragment manager
        mFragmentManager = getSupportFragmentManager();
        //find the container of fragment
        mFragment = mFragmentManager.findFragmentById(R.id.fragment_container);
        //create our main Fragment
        if (mFragment == null){//if it is null create one and added it by fragment manager
            mFragment = new MainFragment();
            mFragmentManager.beginTransaction().add(R.id.fragment_container, mFragment).commit();


        }

     }
 public void loadPickPowerFragment(){
     // create one and added it by fragment manager
         mFragment = new PickPowerFragment();
         mFragmentManager.beginTransaction().replace(R.id.fragment_container, mFragment)
                 .addToBackStack(null).commit();


 }

    @Override
    public void onMAinFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerFragmentInteraction(Uri uri) {

    }
    
    //updating commit from github to try
}
