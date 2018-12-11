package no.finn.techday2018.taskuievents;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import no.finn.techday2018.R;

public class UiEventsActivity extends AppCompatActivity {
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_events);

        // to interact with any view components in Android the view must be casted to different types like button, text and layouts
        final Button changeColorButton = findViewById(R.id.changeColorButton);
        final Button resetButton = findViewById(R.id.resetButton);
        final Button longPressButton = findViewById(R.id.longPressButton);
        final Button playJingleButton = findViewById(R.id.playJingleButton);

        //text view binding
        final TextView headerText = findViewById(R.id.headerText);
        final TextView bodyText = findViewById(R.id.bodyText);

        //we can now use button objects to add event listener also we can use this do some manipulation of button likes enable/disable etc..
        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here you can write what you want to do with the click
                headerText.setTextColor(Color.GREEN);
                bodyText.setTextColor(Color.BLUE);

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recreating the activity to reset everything
                if (mPlayer != null)
                    mPlayer.stop();
                finish();
                startActivity(getIntent());
            }
        });

        //long press click listener
        longPressButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longPressButton.setBackgroundColor(Color.RED);
                return false;
            }
        });

        playJingleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer = MediaPlayer.create(UiEventsActivity.this, R.raw.jingle1);
                mPlayer.start();
            }
        });
    }


}
