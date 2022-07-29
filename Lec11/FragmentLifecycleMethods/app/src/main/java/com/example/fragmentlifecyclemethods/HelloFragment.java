package com.example.fragmentlifecyclemethods;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HelloFragment extends Fragment {
    private static final String TAG = HelloFragment.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_hello,container,false);
        Log.i(TAG,"onCreateView()");
       return view;
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG,"onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate()");
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"onStart()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"onStop()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"onResume()");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"onPause()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"onDestroyView()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"onDetach()");
    }

}
