package cn.zaofeng.nfc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.zaofeng.R;


public class ConfigActivity extends Activity {

    private EditText address_edit, ip_edit, port_edit;

    private Button buttonCancel, buttonSave;

    private Context context;

    String ip = null;
    String port = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_set);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        address_edit = (EditText) findViewById(R.id.address_edit);

        ip_edit = (EditText) findViewById(R.id.ip_edit);

        port_edit = (EditText) findViewById(R.id.port_edit);

        address_edit.setKeyListener(DigitsKeyListener.getInstance("01"));


        buttonSave = (Button) findViewById(R.id.buttonSave);
        String path = null;

        try {
            path = SpUtil.getString(context, "touxiang_set", "0");

            ip = ShareReferenceSaver.getData(context, "nfc_ip");

            port = ShareReferenceSaver.getData(context, "nfc_port");

            if (null == ip || "".equals(ip)) {
                ip = "153.99.44.246";
            }

            if (null == port || "".equals(port)) {
                port = "9977";
            }


        } catch (Exception ex) {

        }
        address_edit.setText(path);
        ip_edit.setText(ip);
        port_edit.setText(port);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != address_edit.getText().toString() && !"".equals(address_edit.getText().toString().trim())) {
                    String data = address_edit.getText().toString().trim();
                    SpUtil.putString(context, "touxiang_set", data);
                    Toast.makeText(context, "保存成功", Toast.LENGTH_SHORT).show();

                    try {
                        String ip = ip_edit.getText().toString().trim();
                        ShareReferenceSaver.saveData(context, "nfc_ip", ip);
                    } catch (Exception ex) {

                    }

                    try {
                        String port = port_edit.getText().toString().trim();
                        ShareReferenceSaver.saveData(context, "nfc_port", port);
                    } catch (Exception ex) {

                    }

                    finish();
                } else {
                    Toast.makeText(context, "请设置头像解析方式", Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });


        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
