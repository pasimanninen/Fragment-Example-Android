package fi.ptm.fragmentexample;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Created by PTM on 25/10/15.
 */
public class DetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // this activity is not used in landscape mode (only fragments there), just safety.... finish
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        // activity_detail will show a fragment
        setContentView(R.layout.activity_detail);
    }
}
