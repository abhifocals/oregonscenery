package com.ahanda.flickrclientnew.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ahanda.flickrclientnew.R;
import com.ahanda.flickrclientnew.activity.MainActivity;
import com.ahanda.flickrclientnew.events.FlickResponseEvent;
import com.ahanda.flickrclientnew.recyclerview.PhotoAdapter;
import com.ahanda.flickrclientnew.rest.FlickrResponse;
import com.ahanda.flickrclientnew.retrofit.FlickrCallback;
import com.ahanda.flickrclientnew.retrofit.FlickrService;
import com.ahanda.flickrclientnew.retrofit.RetrofitBuilder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Getter;

@Getter

public class FragmentController extends Fragment {

    FlickrCallback callback;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    PhotoAdapter photoAdapter;
    private ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Fetching Photos
        FlickrService service = RetrofitBuilder.newInstance().create(FlickrService.class);
        callback = new FlickrCallback();
        service.searchPhotosUsingKeyword("canon beach").enqueue(callback);

        // Registering class for EventBus
        EventBus.getDefault().register(this);

        // Butterknife Binding
        View view = inflater.inflate(R.layout.recycler_fragment, container, false);
        ButterKnife.bind(this, view);

        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search, menu);

        SearchView item = (SearchView) menu.findItem(R.id.action_search).getActionView();
        
        item.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                // Getting Search by keyword
                FlickrService service = RetrofitBuilder.newInstance().create(FlickrService.class);
                callback = new FlickrCallback();
                service.searchPhotosUsingKeyword(query).enqueue(callback);


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                System.out.println("tap");
                return false;
            }
        });
    }

    @Subscribe
    public void getResponse(FlickResponseEvent flickResponseEvent) {
        FlickrResponse flickrResponse = flickResponseEvent.getFlickrResponse();

        // Set-up recycler view
        photoAdapter = new PhotoAdapter(getContext(), flickrResponse.photos.photo);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(photoAdapter);

        // Getting rid of the Progress Bar
        MainActivity.progressBar.setVisibility(View.INVISIBLE);
    }


}
