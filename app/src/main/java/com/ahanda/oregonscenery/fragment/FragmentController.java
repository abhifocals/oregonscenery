package com.ahanda.oregonscenery.fragment;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahanda.oregonscenery.R;
import com.ahanda.oregonscenery.activity.MainActivity;
import com.ahanda.oregonscenery.events.FlickResponseEvent;
import com.ahanda.oregonscenery.recyclerview.PhotoAdapter;
import com.ahanda.oregonscenery.rest.FlickrResponse;
import com.ahanda.oregonscenery.retrofit.FlickrCallback;
import com.ahanda.oregonscenery.retrofit.FlickrService;
import com.ahanda.oregonscenery.retrofit.RetrofitBuilder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Getter;

@Getter

public class FragmentController extends Fragment implements View.OnClickListener {

    FlickrCallback callback;
    FlickrService service;
    FlickrResponse flickrResponse;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView((R.id.button1))
    Button button1;

    @BindView((R.id.button2))
    Button button2;

    @BindView((R.id.button3))
    Button button3;

    PhotoAdapter photoAdapter;
    private ProgressBar progressBar;
    String keyword = "Oregon Beach";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Fetching Photos
        service = RetrofitBuilder.newInstance().create(FlickrService.class);
        callback = new FlickrCallback();
        service.searchPhotosUsingKeyword(keyword).enqueue(callback);

        // Registering class for EventBus
        EventBus.getDefault().register(this);
        setHasOptionsMenu(true);

        // Setting up Menu
        setHasOptionsMenu(true);

        // Inflating the Fragment Layout
        View view = inflater.inflate(R.layout.recycler_fragment, container, false);

        // Butterknife Binding
        ButterKnife.bind(this, view);

        // Setting up listeners for button
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


        // Set Title
        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setTitle(R.string.title);

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

        flickrResponse = flickResponseEvent.getFlickrResponse();

        setUpRecyclerView();

        // Getting rid of the Progress Bar
        MainActivity.progressBar.setVisibility(View.INVISIBLE);
    }

    private void setUpRecyclerView() {
        photoAdapter = new PhotoAdapter(getContext(), flickrResponse.photos.photo);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(photoAdapter);
    }

    @Override
    public void onClick(View v) {
        keyword = ((Button) v).getText().toString();
        service.searchPhotosUsingKeyword(keyword).enqueue(callback);
    }
}

