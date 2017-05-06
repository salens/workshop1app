package com.company.stanislavsencanski.workshopapp.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.company.stanislavsencanski.workshopapp.generic.RecyclerViewAdapterBase;
import com.company.stanislavsencanski.workshopapp.generic.ViewWrapper;
import com.company.stanislavsencanski.workshopapp.model.User;
import com.company.stanislavsencanski.workshopapp.protocol.UserSelectedListener;
import com.company.stanislavsencanski.workshopapp.view.UserItemView;

import java.util.List;

/**
 * Created by Sasa on 4/29/2017.
 */

public class UserAdapter extends RecyclerViewAdapterBase<User, UserItemView> {
    private final UserSelectedListener userSelectedListener;

    public UserAdapter(Context context, List<User> items, UserSelectedListener userSelectedListener) {
        super(context, items);
        this.userSelectedListener = userSelectedListener;
    }

    @Override
    protected UserItemView onCreateItemView(ViewGroup parent, int viewType) {
        return new UserItemView(context, userSelectedListener);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<UserItemView> holder, int position) {
        final UserItemView view = holder.getView();
        final User user = items.get(position);

        view.bind(user);
    }
}

