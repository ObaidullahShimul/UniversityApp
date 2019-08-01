package www.siit.com.university;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //public static int web=0;

    SearchView searchView;
    RecyclerView listshowrcy;
    List<Item> productlists = new ArrayList<>();
    MainActivityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //adding product name and image in array list of Item type
        productlists.add(new Item("Daffodil International University", R.drawable.diu));
        productlists.add(new Item("BRAC University", R.drawable.brac_logo));
        productlists.add(new Item("North South University", R.drawable.north_south));
        productlists.add(new Item("East West Univerisy", R.drawable.east_west));
        productlists.add(new Item("Ahsanullah University of Science & Technology", R.drawable.ahsanullah));
        productlists.add(new Item("American International University", R.drawable.american));
        productlists.add(new Item("Shanto Mariam University of Creative Technology", R.drawable.shantol));
        productlists.add(new Item("BGMEA University of Fashion & Technology", R.drawable.buft_logo));
        productlists.add(new Item("Independent University Bangladesh", R.drawable.iub));
        productlists.add(new Item("International University of Business Agriculture and Technology", R.drawable.iubat_u));

        productlists.add(new Item("Southeast University", R.drawable.southeast));
        productlists.add(new Item("Northern University Bangladesh", R.drawable.northern));
        productlists.add(new Item("Atish Dipankar University of Science & Technology", R.drawable.atish));
        productlists.add(new Item("Manarat International University", R.drawable.manarat));
        productlists.add(new Item("ASA University Bangladesh", R.drawable.asa));
        productlists.add(new Item("Asian University of Bangladesh", R.drawable.asian));
        productlists.add(new Item("Bangladesh University", R.drawable.bangladesh_u));
        productlists.add(new Item("Bangladesh University of Business and Technology", R.drawable.bubt_logo));
        productlists.add(new Item("Dhaka International University", R.drawable.dhaka));
        productlists.add(new Item("Estern University Bangladesh", R.drawable.estern));

        productlists.add(new Item("Premier University Chittagong", R.drawable.premier));
        productlists.add(new Item("Green University of Bangladesh", R.drawable.green));
        productlists.add(new Item("University of Asia Pacific (UAP)", R.drawable.uap_logo));
        productlists.add(new Item("University of Information Technology & Sciences", R.drawable.uits));
        productlists.add(new Item("University of Liberal Arts Bangladesh", R.drawable.ulab));
        productlists.add(new Item("United International University (UIU)", R.drawable.united));
        productlists.add(new Item("World University of Bangladesh", R.drawable.world));
        productlists.add(new Item("Royal University of Dhaka", R.drawable.royal));
        productlists.add(new Item("Uttara University", R.drawable.uttara));

        productlists.add(new Item("Canadian University of Bangladesh", R.drawable.canadian));
        productlists.add(new Item("City University", R.drawable.city));
        productlists.add(new Item("Presidency University", R.drawable.precidency));
        productlists.add(new Item("Primeasia University", R.drawable.priasia));
        productlists.add(new Item("Sonargaon University", R.drawable.sonargaon));
        productlists.add(new Item("Stamford University Bangladesh", R.drawable.stamport));
        productlists.add(new Item("State University of Bangladesh", R.drawable.state_uni));
        productlists.add(new Item("University of South Asia", R.drawable.u_south_asia));
        productlists.add(new Item("European University of Bangladesh", R.drawable.european));
        productlists.add(new Item("IBAIS University", R.drawable.ibaisu));

        listshowrcy = (RecyclerView) findViewById(R.id.listshow);
        listshowrcy.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listshowrcy.setLayoutManager(linearLayoutManager);
        adapter = new MainActivityAdapter(productlists, MainActivity.this);
        listshowrcy.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        final MenuItem myActionMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) myActionMenuItem.getActionView();
        changeSearchViewTextColor(searchView);
        ((EditText) searchView.findViewById(
                android.support.v7.appcompat.R.id.search_src_text)).setHintTextColor(getResources().getColor(R.color.white));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                final  List<Item> filtermodelist=filter(productlists,newText);
                adapter.setfilter(filtermodelist);
                return true;
            }
        });
        return true;
    }
    private List<Item> filter(List<Item> pl,String query)
    {
        query=query.toLowerCase();
        final List<Item> filteredModeList=new ArrayList<>();
        for (Item model:pl)
        {
            final String text=model.getName().toLowerCase();
            if (text.startsWith(query))
            {
                filteredModeList.add(model);
            }
        }
        return filteredModeList;
    }
    //for changing the text color of searchview
    private void changeSearchViewTextColor(View view) {
        if (view != null) {
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(Color.WHITE);
            return;
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                changeSearchViewTextColor(viewGroup.getChildAt(i));
            }
        }
        }
    }
}

