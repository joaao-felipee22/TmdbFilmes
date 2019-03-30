package com.example.tmdbfilmes.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.example.tmdbfilmes.R;
import com.example.tmdbfilmes.adapter.AdapterViewPage;
import com.example.tmdbfilmes.fragments.EvaluatedFragment;
import com.example.tmdbfilmes.fragments.FragmentNewFeed;
import com.example.tmdbfilmes.fragments.FragmentRanking;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);

        viewPager = (ViewPager) findViewById(R.id.viewoager);

        AdapterViewPage adapter = new AdapterViewPage(getSupportFragmentManager());


        //add fragment
        adapter.AddFragment(new FragmentNewFeed(), "Mais Recentes");
        adapter.AddFragment(new FragmentRanking(),"Ranking Filmes");
        adapter.AddFragment(new EvaluatedFragment(),"Avaliados");


        //configuração do adapter
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }



}