package tech.sree.com.asynctaskdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ananth on 4/6/2016.
 */
public class MyTask extends AsyncTask<Void,Integer,String> {
    Context context;
    TextView text;
    ProgressDialog progressDialog;
    Button button;
    MyTask(Context context,TextView text ,Button button){
        this.context = context;
        this.text = text ;
        this.button = button ;
    }
    @Override
    protected String doInBackground(Void... params) {

//        int i =  0;
//        synchronized (this){
//            while (i<10){
//                try {
//                    wait(1500);
//                    i++;
//                    publishProgress(i);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        doJob();
        return  "Download completed !!! ";
    }

    public  void  doJob(){
        int i =  0;
        synchronized (this){
            while (i<10){
                try {
                    wait(1500);
                    i++;
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onPreExecute() {
        progressDialog =  new ProgressDialog(context);
        progressDialog.setTitle("Downloading status ....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(10);
        progressDialog.setProgress(0);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String result) {
        text.setText(result);
        button.setEnabled(true);
        progressDialog.dismiss();

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Integer progress = values[0];
        progressDialog.setProgress(progress);
        text.setText("DownLoad is in progress ..... ");

    }
}
