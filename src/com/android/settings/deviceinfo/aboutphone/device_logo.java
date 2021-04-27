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

public class device_logo extends androidx.appcompat.widget.AppCompatImageView{


    public device_logo(@NonNull Context context) {
        super(context);
        abrir(context,null,0);
    }

    public device_logo(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        abrir(context,attrs,0);
    }

    public device_logo(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        abrir(context,attrs,defStyleAttr);
    }

    protected void abrir(Context context,AttributeSet attrs, int defStyleAttr)
    {
        setImageResource(R.drawable.ic_device_unofficial);
        if(SystemProperties.get("ro.palladium.build.status").equals("OFFICIAL")){
            if(SystemProperties.get("ro.palladium.device").equals("phoenix")){
                setImageResource(R.drawable.ic_device_phoenix);
            }
            if(SystemProperties.get("ro.palladium.device").equals("raphael")){
                setImageResource(R.drawable.ic_device_raphael);
            }
            if(SystemProperties.get("ro.palladium.device").equals("RMX1801")){
                setImageResource(R.drawable.ic_device_RMX1801);
            }
            if(SystemProperties.get("ro.palladium.device").equals("X00TD")){
                setImageResource(R.drawable.ic_device_X00TD);
            }
            if(SystemProperties.get("ro.palladium.device").equals("miatoll")){
                setImageResource(R.drawable.ic_device_miatoll);
            }
            if(SystemProperties.get("ro.palladium.device").equals("whyred")){
                setImageResource(R.drawable.ic_device_whyred);
            }
            if(SystemProperties.get("ro.palladium.device").equals("davinci")){
                setImageResource(R.drawable.ic_device_davinci);
            }
            if(SystemProperties.get("ro.palladium.device").equals("tulip")){
                setImageResource(R.drawable.ic_device_tulip);
            }
            if(SystemProperties.get("ro.palladium.device").equals("RMX1971")){
                setImageResource(R.drawable.ic_device_RMX1971);
            }
            if(SystemProperties.get("ro.palladium.device").equals("tissot")){
                setImageResource(R.drawable.ic_device_tissot);
            }
            if(SystemProperties.get("ro.palladium.device").equals("surya")){
                setImageResource(R.drawable.ic_device_surya);
            }
            if(SystemProperties.get("ro.palladium.device").equals("lavender")){
                setImageResource(R.drawable.ic_device_lavender);
            }
        }
        setMaxWidth(100);
        setMaxHeight(200);
    }

}