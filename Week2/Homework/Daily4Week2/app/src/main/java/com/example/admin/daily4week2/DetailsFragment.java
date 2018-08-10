package com.example.admin.daily4week2;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    Celebrity celebrity;

    TextView tvName, tvSummary;
    ImageView ivCelebrity;

    public static DetailsFragment newInstance(Celebrity celebrity) {

        DetailsFragment thisFragment = new DetailsFragment();
        Bundle bundle = new Bundle();

        bundle.putParcelable("KEY", celebrity);

        thisFragment.setArguments(bundle);

        return thisFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            celebrity = getArguments().getParcelable("KEY");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvName = view.findViewById(R.id.tvName);
        tvSummary = view.findViewById(R.id._tvSummary);
        ivCelebrity = view.findViewById(R.id.ivCelebrity);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public void SetCelebrity(){

        tvName.setText(celebrity.getName());
        tvSummary.setText(celebrity.getDescription());
        SetImage();

    }

    private void SetImage(){
        Resources resource = getResources();
        String mDrawableName = celebrity.getPictureResFile();
        int resId = resource.getIdentifier(mDrawableName , "drawable", getContext().getPackageName());
        Drawable drawable = getContext().getDrawable(resId);
        ivCelebrity.setImageDrawable(drawable);
    }
}