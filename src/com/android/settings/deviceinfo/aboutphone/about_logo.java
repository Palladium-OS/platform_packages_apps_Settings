package com.android.settings.deviceinfo.aboutphone;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.dashboard.DashboardFragment;
import android.os.SystemProperties;
import java.lang.*;  

public class about_logo extends androidx.appcompat.widget.AppCompatImageView{


    public about_logo(@NonNull Context context) {
        super(context);
        abrir(context,null,0);
    }

    public about_logo(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        abrir(context,attrs,0);
    }

    public about_logo(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        abrir(context,attrs,defStyleAttr);
    }

    protected void abrir(Context context,AttributeSet attrs, int defStyleAttr)
    {
        // String mDeviceName = "unofficial";
        // if(SystemProperties.get("ro.palladium.build.status").equals("OFFICIAL")){
        //      mDeviceName = SystemProperties.get("ro.palladium.device");

        // }
        setImageResource(R.drawable.ic_about_logo);
        setMaxWidth(100);
        setMaxHeight(200);
    }

}