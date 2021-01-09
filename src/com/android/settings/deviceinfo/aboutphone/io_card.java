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
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.dashboard.DashboardFragment;

import android.os.SystemProperties;
import android.os.StatFs;
import android.os.Environment;

import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.lang.Math;
import java.util.*;

public class io_card extends Specs_base{
    public io_card(@NonNull Context context) {
        super(context);
        abrir(context,null,0);
    }

    public io_card(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        abrir(context,attrs,0);
    }

    public io_card(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        abrir(context,null,defStyleAttr);
    }

    public int getRam()
    {
        RandomAccessFile reader;
        String load;
        DecimalFormat td = new DecimalFormat("#.##");
        double totRam;
        String ram = "";
        int ramSz=0;
        try {
            reader = new RandomAccessFile("/proc/meminfo", "r");
            load = reader.readLine();
            Pattern p = Pattern.compile("(\\d+)");
            Matcher m = p.matcher(load);
            String value = "";
            while (m.find()) {
                value = m.group(1);
            }
            reader.close();
            totRam = Double.parseDouble(value);
            totRam = totRam / 1048576.0;
            ramSz =(int)Math.ceil(totRam);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ramSz;
    }    

   public int getStorage()
    {
        StatFs stat =new StatFs(Environment.getDataDirectory().getAbsolutePath());
        double bytes;
        bytes = stat.getBlockSizeLong() * stat.getBlockCountLong();
        double storageSz = bytes / Math.pow(1024, 3);
        double size=0;
        if(storageSz > 4 && storageSz <9){
            size=8;
        }
        else if(storageSz > 8 && storageSz <17){
            size=16;
        }
        else if(storageSz > 16 && storageSz <33){
            size=32;
        }
        else if(storageSz > 32 && storageSz <65){
            size=64;
        }
        else if(storageSz > 64 && storageSz <129){
            size=128;
        }
        else if(storageSz > 128 && storageSz <257){
            size=256;
        }
        else if(storageSz > 256 && storageSz <513){
            size=512;
        }
        int fSz = (int) size;
        return fSz;
    }
    protected void abrir(Context context, AttributeSet attrs, int defStyleAttr){
        super.abrir(context);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.palladium_name, defStyleAttr, 0);
        setLayoutParams(new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams pl = new LinearLayout.LayoutParams(new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setLayoutParams(pl);
        ImageView logo = new ImageView(context);
        logo.setMaxWidth(10);
        logo.setMaxHeight(10);
        logo.setImageResource(R.drawable.ic_homepage_storage);
        logo.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        TextView card_title = new TextView(context);
        TextView card_summary = new TextView(context);
        if(SystemProperties.get("ro.palladium.build.status").equals("OFFICIAL")){
            card_title.setText("Storage");
            card_title.setTextSize(13);
            card_title.setGravity(Gravity.CENTER);
            card_title.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            String contentVal= String.valueOf(getRam()) + "GB"+" "+"RAM"+ " " + "+" + " " + String.valueOf(getStorage()) + "GB" + " " + "ROM"; 
            card_summary.setText(contentVal);
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
