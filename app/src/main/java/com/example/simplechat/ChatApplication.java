package com.example.simplechat;

import android.app.Application;

import com.parse.Parse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ChatApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // use for monitoring parse network traffic
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        // Can be Level.BASIC, Level.HEADERS, or Level.BODY
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("simplechat-client") // Replaced `myAppId`
                .clientKey(null)  // set explicitly unless clientKey is explicitly configured on Parse server
                .clientBuilder(builder) // this builder comes from the OkHttpClient.
                .server("https://codepath-chat-lab.herokuapp.com/parse/").build()); // Replace https://my-parse-app-url.herokuapp.com/parse

    }
}
