package www.siit.com.university;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Daffodil_Main extends AppCompatActivity {

    ViewPager daffo_viewPager;
    TabLayout daffo_tabLayout;

    //ImageView slideImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daffodil__main);

        daffo_viewPager=(ViewPager) findViewById(R.id.daffo_viewPagerId);
        daffo_tabLayout=(TabLayout) findViewById(R.id.daffo_tabLayoutId);

        //slideImg=(ImageView) findViewById(R.id.daffo_slideImg);
        //String url="https://www.google.com/search?safe=active&tbm=isch&sa=1&ei=1WBRXKqQIpWmwgP54JrQBg&q=daffodil+university&oq=daffodil+u&gs_l=img.1.0.0l10.2218.6884..9702...1.0..0.373.1443.5j5j0j1......0....1..gws-wiz-img.......0i67.c1JVJnFrr9c#imgrc=tGIWcP28FutIRM:";
        //Picasso.get().load(url).into(slideImg);

        daffo_viewPager.setAdapter(new mypagerAdapter(getSupportFragmentManager()));
        daffo_tabLayout.setupWithViewPager(daffo_viewPager);

        //--------for tablayout Selected Listener------------
        daffo_tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                daffo_viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    //---------------interface----------------
    class mypagerAdapter extends FragmentPagerAdapter {

        String[] daffo_program={"Undergraduate Programs"," Graduate\nPrograms  "};



        public mypagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            if (i==0){
                return new Daffo_UnderProgram();
            }

            if (i==1){

                return new Daffo_GraduProgram();
            }
            return null;
        }

        @Override
        public int getCount() {
            return daffo_program.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            return daffo_program[position];
        }
    }


}
