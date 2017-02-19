package me.indiandollar.apps.makemelaugh;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import me.indiandollar.Joke;
import me.indiandollar.apps.androidlib.JokeActivity;
import me.indiandollar.apps.backend.myApi.MyApi;

/**
 * Created by Indian Dollar on 2/16/2017.
 */

public class FetchJokeAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static final String TAG = "FetchJokeAsyncTask";
    private static MyApi apiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {

        if(apiService == null) {

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            apiService = builder.build();
        }

        context = params[0].first;

        Joke jokeobj = new Joke();
        String joke = jokeobj.getRandom();
        return joke;
    }


    @Override
    protected void onPostExecute(String s) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY, s);
        context.startActivity(intent);
    }
}
