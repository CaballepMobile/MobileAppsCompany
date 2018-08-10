package com.example.admin.daily4week2;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OptionsFragment.OnFragmentInteractionListener {

    TextView tvName, tvDescription;
    ImageView ivCelebrity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvDescription = findViewById(R.id.tvSummary);
        ivCelebrity = findViewById(R.id.ivCelebrity);
    }

    @Override
    public void onFragmentInteraction(Celebrity celebrity) {
        Toast.makeText(this, celebrity.getName(), Toast.LENGTH_SHORT).show();
        tvName.setText(celebrity.getName());
        tvDescription.setText(celebrity.getName());
        SetImage(celebrity);
    }

    private void SetImage(Celebrity celebrity){
        /*
        Resources resource = getResources();
        String mDrawableName = celebrity.getPictureResFile();
        int resId = resource.getIdentifier(mDrawableName , "drawable", this.getPackageName());
        Drawable drawable = this.getDrawable(resId);
        ivCelebrity.setImageDrawable(drawable);*/
    }
}
