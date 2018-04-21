package com.felipe.tallerinterneti029214;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.felipe.tallerinterneti029214.Parser.Json;
import com.felipe.tallerinterneti029214.URL.HttpManager;
import com.felipe.tallerinterneti029214.models.User;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textView;

    private List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.id_progressbar);
        textView = (TextView) findViewById(R.id.id_textView);


        if(isOnline()) {
            TaskUsers taskUsers = new TaskUsers();
            taskUsers.execute("http://pastoral.iucesmag.edu.co/practica/listar.php");

        }
        else {
            Toast.makeText(this, "No hay conexion a internet", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null) {
            return true;
        }
        else {
            return false;
        }
    }


    public void processData() {
        Toast.makeText(this, String.valueOf(userList.size()), Toast.LENGTH_SHORT).show();

        for(User user  : userList) {
            textView.append(user.getNombre() + "\n");
        }
    }


    public class TaskUsers extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            String content = null;
            try {
                content = HttpManager.getData(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            processData();
        }

        
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                userList = Json.getDataJson(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            processData();
            progressBar.setVisibility(View.GONE);
        }
    }

}
