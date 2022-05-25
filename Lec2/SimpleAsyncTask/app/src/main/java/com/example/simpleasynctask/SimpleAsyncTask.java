package com.example.simpleasynctask;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void,Integer,String> {
    private WeakReference<TextView> mTextView;
    ProgressBar progressBar;
    int s;


    public SimpleAsyncTask(TextView textView,ProgressBar progressBar) {
        mTextView = new WeakReference<>(textView);
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Random random = new Random();
        int n = random.nextInt(11);
        s = n * 200;
        progressBar.setMax(s);
    }



    @Override
    protected String doInBackground(Void... voids) {




        try {

            for(int i=0;i<=10;i++)
            {
                Thread.sleep((s/10));
                //publishProgress(i*(s/10));
                progressBar.setProgress(i*(s/10));
            }

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return "Awake at last after sleeping for " + s + " milliseconds!";
    }


    @Override
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }

    @SuppressLint("WrongThread")
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        //progressBar.setProgress(values[0]);
        publishProgress(values[0]);

    }
}
