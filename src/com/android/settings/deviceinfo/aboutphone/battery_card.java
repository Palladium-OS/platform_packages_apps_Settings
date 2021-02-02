package com.android.settings.deviceinfo.aboutphone;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.dashboard.DashboardFragment;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.os.SystemProperties;

public class battery_card extends Specs_base{
    public battery_card(@NonNull Context context) {
        super(context);
        abrir(context,null,0);
    }

    public battery_card(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        abrir(context,attrs,0);
    }

    public battery_card(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        abrir(context,null,defStyleAttr);
    }

    protected void abrir(Context context, AttributeSet attrs, int defStyleAttr){
        super.abrir(context);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.palladium_name, defStyleAttr, 0);
        setLayoutParams(new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams pl = new LinearLayout.LayoutParams(new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setLayoutParams(pl);
        ImageView logo = new ImageView(context);
        logo.setMaxWidth(10);
        logo.setMaxHeight(10);
        logo.setImageResource(R.drawable.ic_homepage_battery);
        LinearLayout.LayoutParams logop = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        logop.gravity = Gravity.CENTER;
        logop.setMargins(0,10,0,0);
        logo.setLayoutParams(logop);
        TextView card_title = new TextView(context);
        TextView card_summary = new TextView(context);
        if(SystemProperties.get("ro.palladium.build.status").equals("OFFICIAL")){
            card_title.setText("Battery");
            card_title.setTextSize(13);
            card_title.setGravity(Gravity.CENTER);
            card_title.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            card_summary.setText(SystemProperties.get("ro.palladiumdevice.battery"));

            if(!(SystemProperties.get("ro.palladium.device").equals("miatoll"))){
                card_summary.setText(SystemProperties.get("ro.palladiumdevice.battery"));
            }
            else{
                if(SystemProperties.get("ro.boot.hwname").equals("gram")){
                    card_summary.setText("5000mAh");
                }
                else{
                    card_summary.setText("5020mAh");
                }
            }
            card_summary.setGravity(Gravity.CENTER);
            card_summary.setTextSize(10);
        }    
        else 
        {
            card_title.setText("Unknown");
            card_title.setTextSize(15);
            card_title.setGravity(Gravity.CENTER);
            card_title.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            card_summary.setText("Unknown");
            card_summary.setGravity(Gravity.CENTER);
            card_summary.setTextSize(11);
        }    
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(0,10,0,0);
        card_summary.setLayoutParams(params);
        setElevation(10);
        linearLayout.addView(logo);
        linearLayout.addView(card_title);
        linearLayout.addView(card_summary);
        layout.addView(linearLayout);
        a.recycle();
    }

}