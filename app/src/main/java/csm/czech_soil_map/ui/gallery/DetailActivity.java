package csm.czech_soil_map.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import csm.czech_soil_map.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        setTitle(intent.getStringExtra("soil_name"));
        ImageView iv = null;
        ((TextView)findViewById(R.id.soil_text_detail_id)).setText(intent.getStringExtra("soil_text"));
    }
}
