package com.android.settings.deviceinfo.aboutphone;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.dashboard.DashboardFragment;


public class Specs_base extends CardView {

    protected RelativeLayout layout;
    protected int defaultPadding = 25;
    protected int defaultRadius = 40;

    public Specs_base(@NonNull Context context) {
        super(context);
        abrir(context);
    }

    public Specs_base(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        abrir(context);
    }

    public Specs_base(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        abrir(context);
    }

    protected void abrir(Context context){
        setLayoutParams(new LayoutParams(getResources().getDimensionPixelSize(R.dimen.Card_height),getResources().getDimensionPixelSize(R.dimen.Card_width)));
        layout = new RelativeLayout(context);
        layout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        layout.setPadding((int) (defaultPadding*0.5), (int) (defaultPadding*1), (int) (defaultPadding*0.5), (int) (defaultPadding*1));
        addView(layout);
        setRadius(defaultRadius);
    }

}