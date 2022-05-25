package com.example.screenorientation2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.screenorientation2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    TextView textView;
    Button btn;
    EditText editText;
    ImageView imageView;

    @Override
    protected void onSaveInstanceState( Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"On savedInstanceState");
        savedInstanceState.putString("message",textView.getText().toString());
        savedInstanceState.putString("btn_text",btn.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"On onRestoreInstanceState");

        if(savedInstanceState!=null)
        {
            btn.setText(savedInstanceState.getString("btn_text"));
            textView.setText(savedInstanceState.getString("message"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        textView = binding.textView;
        btn = binding.button;
        editText = binding.editText;
        imageView = binding.imageView;

        btn.setOnClickListener((View view) -> {
        btn.setText("Log Out");
        textView.setText(editText.getText().toString());

        });

        Log.i(TAG,"On Create");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            imageView.setImageResource(R.drawable.b);
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            imageView.setImageResource(R.drawable.a);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG,"On Restart");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG,"On Start");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG,"On Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG,"On Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG,"On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG,"On Destroy");
    }
}