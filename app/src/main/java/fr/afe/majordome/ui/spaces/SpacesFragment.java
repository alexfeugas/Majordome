package fr.afe.majordome.ui.spaces;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import fr.afe.majordome.ItemClickSupport;
import fr.afe.majordome.MajordomeActivity;
import fr.afe.majordome.NewSpaceActivity;
import fr.afe.majordome.R;
import fr.afe.majordome.SpaceActivity;
import fr.afe.majordome.entities.SpaceEntity;
import fr.afe.majordome.ui.share.ShareViewModel;

import static android.app.Activity.RESULT_OK;

public class SpacesFragment extends Fragment {
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private static final int DISPLAY_SPACE_ACTIVITY_REQUEST_CODE = 2;

    private SpacesViewModel spacesViewModel;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.v("SpacesFrgment", "into Create View");
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        recyclerView = root.findViewById(R.id.recyclerview);

        // Get a new or existing ViewModel from the ViewModelProvider.
        spacesViewModel = ViewModelProviders.of(this).get(SpacesViewModel.class);
        final SpacesListAdapter adapter = new SpacesListAdapter(getContext(), spacesViewModel);

        spacesViewModel.getAllSpaces().observe(this, new Observer<List<SpaceEntity>>() {
            @Override
            public void onChanged(List<SpaceEntity> spaceEntities) {
                // Update the cached copy of the words in the adapter.
                adapter.setSpaces(spaceEntities);
            }
        });


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        configureOnClickRecyclerView();


        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewSpaceActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });

        return root;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            SpaceEntity space = new SpaceEntity();
            space.spaceName = data.getStringExtra(NewSpaceActivity.EXTRA_REPLY);
            spacesViewModel.insert(space);
        } else {
            Toast.makeText(
                    getContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(recyclerView, R.layout.fragment_slideshow)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        SpacesListAdapter adapter = (SpacesListAdapter) recyclerView.getAdapter();
                        Log.e("TAG", "Position : "+position + " " + adapter.getSpace(position).spaceName);
                        Intent intent = new Intent(getActivity(), SpaceActivity.class);
                        intent.putExtra("SPACE", adapter.getSpace(position));
                        startActivityForResult(intent, DISPLAY_SPACE_ACTIVITY_REQUEST_CODE);
                    }
                });
    }

}