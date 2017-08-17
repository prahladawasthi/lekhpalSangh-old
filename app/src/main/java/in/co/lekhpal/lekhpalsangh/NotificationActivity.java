package in.co.lekhpal.lekhpalsangh;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Notification Window", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView notificationTitle = (TextView) findViewById(R.id.notificationTitle);
        TextView notificationMessageBody = (TextView) findViewById(R.id.notificationMessageBody);
        TextView notificationDetailMessage = (TextView) findViewById(R.id.notificationDetailMessage);

        Bundle data = getIntent().getExtras();

         if (null != data) {

            if (null != data.get("heading")) {
                notificationTitle.setText(String.valueOf(data.get("heading")));
            }

            if (null != data.get("smallHeading")) {
                notificationMessageBody.setText(String.valueOf(data.get("smallHeading")));
            }

            if (null != data.get("detailMessage")) {
                notificationDetailMessage.setText(String.valueOf(data.get("detailMessage")));
            }
        }
    }

}
