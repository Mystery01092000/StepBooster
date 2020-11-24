package com.pranav.stepbooster;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.fragment.app.FragmentActivity;

import com.pranav.stepbooster.ui.Fragment_Overview;
import com.pranav.stepbooster.ui.Fragment_Settings;

public class Activity_Main extends FragmentActivity {

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStackImmediate();
        } else {
            finish();
        }
    }

    @Override
    protected void onCreate(final Bundle b) {
        super.onCreate(b);
        startService(new Intent(this, SensorListener.class));
        if (b == null) {

            Fragment newFragment = new Fragment_Overview();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.replace(android.R.id.content, newFragment);

            transaction.commit();
        }
    }

    public boolean optionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getFragmentManager().popBackStackImmediate();
                break;
            case R.id.action_settings:
                getFragmentManager().beginTransaction()
                        .replace(android.R.id.content, new Fragment_Settings()).addToBackStack(null)
                        .commit();
                break;
        }
        return true;
    }
}