package com.company.stanislavsencanski.workshopapp.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.company.stanislavsencanski.workshopapp.R;
import com.company.stanislavsencanski.workshopapp.model.User;
import com.company.stanislavsencanski.workshopapp.protocol.UserSelectedListener;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Sasa on 4/29/2017.
 */

public class UserItemView extends RelativeLayout {

    private User user;
    private final TextView firstName;
    private final TextView lastName;
    private final SimpleDraweeView thumbnail;


    public UserItemView(Context context, final UserSelectedListener userSelectedListener) {
        super(context);
        inflate(context, R.layout.item_view_user, this);

        // get references to all views
        final CardView cardView = (CardView) findViewById(R.id.card);
        firstName = (TextView) findViewById(R.id.first_name);
        lastName = (TextView) findViewById(R.id.last_name);
        thumbnail = (SimpleDraweeView) findViewById(R.id.thumbnail);


        // add listener to card view
        cardView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                userSelectedListener.userSelected(user);
            }
        });
    }

    /**
     * Populate all views in card view
     * */

    public void bind(User user) {

        this.user = user;
        thumbnail.setImageURI(user.getIconUrl());
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
    }
}
