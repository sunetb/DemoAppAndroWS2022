package dk.stbn.myfirstapp;

import android.os.AsyncTask;

import java.util.ArrayList;

public class FetchUserList extends AsyncTask {


        @Override
        protected Object doInBackground(Object[] objects) {
            int i = 23;
            publishProgress(4);

            return i;

        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
            System.out.println(values[0]);
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            int j = (int) o;
            System.out.println(j);
        }


}
