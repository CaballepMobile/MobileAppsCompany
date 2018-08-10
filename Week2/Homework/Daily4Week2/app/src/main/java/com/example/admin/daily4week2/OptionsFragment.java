package com.example.admin.daily4week2;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OptionsFragment extends Fragment {

    ListView lvOptions;
    ArrayList<Celebrity> celebrities;

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Celebrity celebrity);
    }

    private OnFragmentInteractionListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() +
                    " must implement OnFragmentInteractionListener.");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        celebrities = new ArrayList<>();
        celebrities.add(new Celebrity("Emilia Clarke", "Emilia Clarke is an English actress. Clarke studied at the Drama Centre London and appeared in a number of stage productions. Her television debut came in 2009 with a guest appearance in an episode of the British soap opera Doctors. ", "emilia"));
        celebrities.add(new Celebrity("Tom Holland", "Thomas Stanley Holland is an English actor and dancer. He is best known for playing Spider-Man in the Marvel Cinematic Universe films Captain America: Civil War, Spider-Man: Homecoming, and Avengers: Infinity War.", "tom"));
        celebrities.add(new Celebrity("Linus Torvalds", "Linus Torvalds is the world's most famous computer programmer and also its most famous Finn. He is the founder and coordinator of Linux, the Unix-like operating system that is beginning to revolutionize the computer industry and possibly much else as well. His is truly one of the great tales in the history of the computers.", "linus"));
        celebrities.add(new Celebrity("Dennis Ritchie", "Dennis MacAlistair Ritchie was an American computer scientist. He created the C programming language and, with long-time colleague Ken Thompson, the Unix operating system.", "dennis"));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.options_fragment, container, false);
        lvOptions = view.findViewById(R.id.lvCelebrities);

        CelebrityArrayAdapter adapter = new CelebrityArrayAdapter(view.getContext(), celebrities);
        lvOptions.setAdapter(adapter);

        lvOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long i) {

                Celebrity selectedFromList = (Celebrity)(lvOptions.getItemAtPosition(position));
                mListener.onFragmentInteraction(selectedFromList);
            }

        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lvOptions = view.findViewById(R.id.lvCelebrities);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}