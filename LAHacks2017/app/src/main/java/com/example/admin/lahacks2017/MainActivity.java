package com.example.admin.lahacks2017;

import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Random;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    final String CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";
    final String[] urls =
            {"https://en.wikipedia.org/wiki/List_of_Eiffel_Tower_replicas",
                    "https://en.wikipedia.org/wiki/Gravity_hill",
                    "https://en.wikipedia.org/wiki/List_of_tautological_place_names",
                    "https://en.wikipedia.org/wiki/Pizza_farm",
                    "https://en.wikipedia.org/wiki/Nail_house",
                    "https://en.wikipedia.org/wiki/Leaning_Tower_of_Suurhusen",
                    "https://en.wikipedia.org/wiki/Centralia,_Pennsylvania",
                    "https://en.wikipedia.org/wiki/Florence_Y%27all_Water_Tower",
                    "https://en.wikipedia.org/wiki/Michigan_left",
                    "https://en.wikipedia.org/wiki/Ragged_Ass_Road_(street)",
                    "https://en.wikipedia.org/wiki/Rough_and_Ready,_California",
                    "https://en.wikipedia.org/wiki/World%27s_littlest_skyscraper",
                    "https://en.wikipedia.org/wiki/Winchester_Mystery_House"
            };
    final String[] toastMessages =
            {
                    "Hope this helps!",
                    "Don't get too sucked in!",
                    "This article may be weird!",
                    "Is the other person gone yet?"
            };
    int urlNum;

    CustomTabsClient mCustomTabsClient;
    CustomTabsSession mCustomTabsSession;
    CustomTabsServiceConnection mCustomTabsServiceConnection;
    CustomTabsIntent mCustomTabsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCustomTabsServiceConnection = new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                mCustomTabsClient = customTabsClient;
                mCustomTabsClient.warmup(0L);
                mCustomTabsSession = mCustomTabsClient.newSession(null);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mCustomTabsClient = null;
            }
        };

        CustomTabsClient.bindCustomTabsService(this, CUSTOM_TAB_PACKAGE_NAME, mCustomTabsServiceConnection);

        mCustomTabsIntent = new CustomTabsIntent.Builder(mCustomTabsSession)
                .setShowTitle(true)
                .build();
    }

    public void chromeCustomTab(View view) {
        Random rand = new Random();
        urlNum = rand.nextInt(urls.length);

        mCustomTabsIntent.launchUrl(this, Uri.parse(urls[urlNum]));
        Context context = getApplicationContext();
        CharSequence text = toastMessages[rand.nextInt(toastMessages.length)];
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}