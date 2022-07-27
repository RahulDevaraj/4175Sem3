package com.example.jobschedulercodingchallenge;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.AsyncTask;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.lang.ref.WeakReference;

public class MJobScheduler extends JobService {

    private MJobExecutor executor;


    @Override
    public boolean onStartJob(final JobParameters params) {

        executor = new MJobExecutor(this, params);
        executor.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        executor.cancel(true);
        return false;
    }

    private static class MJobExecutor extends AsyncTask<Void, Void, String> {
        private WeakReference<JobService> jobServiceReference;
        private JobParameters params;

        MJobExecutor(JobService jobService, JobParameters params) {
            jobServiceReference = new WeakReference<>(jobService);
            this.params = params;
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JobService jobService = jobServiceReference.get();
            if (jobService != null) {
                Intent intent = new Intent("JOB_FINISHED");
                intent.putExtra("result", "Job Executed");
                LocalBroadcastManager.getInstance(jobService).sendBroadcast(intent);
                jobService.jobFinished(params, true);
            }
        }
    }
}