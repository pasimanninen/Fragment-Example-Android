package fi.ptm.fragmentexample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by PTM on 25/10/15.
 */
public class MainActivity extends Activity implements EmployeesListFragment.OnItemSelectedListener {
    public static final String PREFS_NAME = "MY_PREFERENCES";
    EmployeesData employeesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // generate some dummy data
        employeesData = new EmployeesData(this);
        // portrait or landscape layout
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemSelected(int index) {
        // save selected person index to shared preferences
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("index", index);
        editor.commit();

        // item selected from ListFragment (some name)
        DetailFragment fragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
        // landscape
        if (fragment != null && fragment.isInLayout()) {
            fragment.showData();
        } else {
            // portrait -> start a new activity
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            startActivity(intent);
        }
    }

}
