package com.segid.bnote;

/**
 * Created by User on 11/20/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.segid.bnote.Object.Global;
import com.segid.bnote.Object.User;

public class splashscreen extends Activity {

    //Set waktu lama splashscreen
    private static int splashInterval = 2000;
    final Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Object user = ObjectRW.readObject(splashscreen.this, Global.FILE_NAME_USER);

                Intent intent = null;
                if(user == null) {
                    if (Global.user == null) {
                        Global.user = new User();
                        intent = new Intent(splashscreen.this, LoginActivity.class);
                    }
                } else {
                    Global.user = (User)user;
                    bundle.putString("userid", Global.user.getUserId());
                    intent = new Intent(splashscreen.this, MainActivity.class);
                    intent.putExtras(bundle);
                }

                startActivity(intent);

                //jeda selesai Splashscreen
                this.finish();
            }

            private void finish() {
                // TODO Auto-generated method stub
            }
        }, splashInterval);
    };
}