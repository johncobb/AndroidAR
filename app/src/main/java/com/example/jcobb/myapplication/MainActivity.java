package com.example.jcobb.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.jcobb.myapplication.ConnectivityListener.ConnectivityReceiverListener;

public class MainActivity extends AppCompatActivity implements ConnectivityReceiverListener {

    private static String TAG = "MainActivity";

    Button buttonCheckConnection;
    TextView textViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Tell it to use activity_main as the layout
        setContentView(R.layout.activity_main);

        buttonCheckConnection = (Button) findViewById(R.id.buttonCheckConnection);
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);

        buttonCheckConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnection();
            }
        });
        checkConnection();
    }

    private void checkConnection() {
        boolean connected = ConnectivityListener.isConnected();
        showStatus(connected);
    }

    private void showStatus(boolean connected) {

        textViewStatus.setText("connected (" + connected + ")");
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.getInstance().setConnectivityListener(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        Log.d(TAG, "connected (" + isConnected + ")");
        showStatus(isConnected);
    }

}
