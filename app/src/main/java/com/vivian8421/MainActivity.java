package com.vivian8421;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.vivian8421.mipushEnhance.R;

import de.robv.android.xposed.XposedBridge;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Switch kgzm_sw;
    private Switch kgljgn_sw;
    private TextView kgzm_tv,kgljgn_tv,count_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLauncherIcon(false);
        setContentView(R.layout.activity_main);
//        showLauncherIcon(false);
//        kgzm_tv = (TextView) findViewById(R.id.kgzm_tv);;
//        kgzm_sw = (Switch) findViewById(R.id.kgzm_sw);
//        kgzm_sw.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.e("11111","11111"+isChecked);
        switch (buttonView.getId()){
            case R.id.kgzm_sw:
                if(isChecked){
                    showLauncherIcon(false);
                }else {
                    showLauncherIcon(true);
                }
                break;

//            case R.id.kgljgn_tv:
//                if(isChecked){
//                    kgljgn_tv.setText("开");
//                }else {
//                    kgljgn_tv.setText("关");
//                }
//                break;
//            default:
//                break;
        }
    }

       public void showLauncherIcon(boolean isShow){
           PackageManager packageManager = this.getPackageManager();
           int show = isShow? PackageManager.COMPONENT_ENABLED_STATE_ENABLED : PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
           packageManager.setComponentEnabledSetting(getAliseComponentName(), show , PackageManager.DONT_KILL_APP);
       }
    private ComponentName getAliseComponentName(){
        return new ComponentName(MainActivity.this, "com.vivian8421.MainActivityAlias");
    }
    }


