package com.animation;

import android.app.Dialog;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Dialog m_dialog;
    private LinearLayout alert_linear;
    Button btn_alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_alert= (Button) findViewById(R.id.btn_alert);
        WifiManager wifiManager= (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiConfiguration wifiConfiguration=new WifiConfiguration();
        wifiManager.updateNetwork(wifiConfiguration);
        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showAlertDialog(MainActivity.this,"Alert Dialog","This is alert dialog animation!");
            }
        });

    }

    public  void showAlertDialog(final Context context, String headerTitle, String message) {
        m_dialog = new Dialog(context, R.style.Dialog_No_Border);
        m_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        m_dialog.getWindow().getAttributes().windowAnimations = R.style.custom_delete_dialog_animation;
//        m_dialog.getWindow().getAttributes().windowAnimations = R.style.custom_dialog_edit_animation;
        m_dialog.getWindow().getAttributes().windowAnimations = R.style.custom_dialog_add_animation;

        LayoutInflater m_inflater = LayoutInflater.from(context);
        View m_view = m_inflater.inflate(R.layout.custom_alert_dialog, null);
        alert_linear = (LinearLayout) m_view.findViewById(R.id.alert_linear);


        TextView logout_tv_title = (TextView) m_view.findViewById(R.id.alert_tv_title);
        TextView tv_custom_logout_msg = (TextView) m_view.findViewById(R.id.tv_custom_alert_msg);
        Button btn_ok_alert_dialog = (Button) m_view.findViewById(R.id.btn_ok_alert_dialog);


        logout_tv_title.setText(headerTitle);

        tv_custom_logout_msg.setText(message);


        alert_linear.setBackgroundResource(R.drawable.btn_style_roundcorner);


        View.OnClickListener m_clickListener = new View.OnClickListener() {

            @Override
            public void onClick(View p_v) {


                switch (p_v.getId()) {
                    case R.id.btn_ok_alert_dialog:
                        m_dialog.dismiss();

                        break;


                    default:
                        break;
                }
            }
        };

        btn_ok_alert_dialog.setOnClickListener(m_clickListener);


        m_dialog.setContentView(m_view);
        m_dialog.show();

    }
}
