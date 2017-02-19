package me.indiandollar.apps.makemelaugh;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.content.Context;
import android.util.Pair;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Indian Dollar on 2/18/2017.
 */

@RunWith(AndroidJUnit4.class)
public class NonEmptyStringTest {

    private static final String LOG_TAG = "NonEmptyStringTest";

    @Test
    public void test() {
        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        Log.v("NonEmptyStringTest", "Running NonEmptyStringTest test");
        String result = null;
        //Context context = MainActivityFragment.getContext();
        FetchJokeAsyncTask endpointsAsyncTask = new FetchJokeAsyncTask();
        endpointsAsyncTask.execute(new Pair<Context, String>(InstrumentationRegistry.getTargetContext(), null));
        try {
            result = endpointsAsyncTask.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(result);
    }
}

