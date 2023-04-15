package com.example.blankapp;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.blankapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private Scene scene1;
    private ViewGroup mSceneRoot;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        assert view != null;
        mSceneRoot = (ViewGroup) view.findViewById(R.id.scene_root);
        scene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene1, getActivity());

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        TransitionManager.go(scene1);
        return binding.getRoot();
        //ImageView IconsIcon = (ImageView) findViewById(R.id.IconsIcon);
        //IconsIcon.setImageResource(R.drawable.backdrops);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NavHostFragment.findNavController(SecondFragment.this)
                  //      .navigate(R.id.action_SecondFragment_to_FirstFragment);
                Intent intent = new Intent(Intent.ACTION_MAIN, null);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                final ComponentName cn = new ComponentName("com.teslacoilsw.launcher", "com.teslacoilsw.launcher.IconThemePrompt");
                intent.setComponent(cn);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try
                {
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    assert true;
                }
            }
        });

        binding.IconsIcon.setImageResource(R.drawable.backdrops);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}