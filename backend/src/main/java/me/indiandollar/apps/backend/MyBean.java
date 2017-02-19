package me.indiandollar.apps.backend;

import me.indiandollar.Joke;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private final Joke mJokes;
    private String myData;

    public MyBean() {
        mJokes = new Joke();
    }

    public String getData() {
        return mJokes.getRandom();
    }

    public void setData(String data) {

    }
}