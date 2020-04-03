package csm.czech_soil_map.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import csm.czech_soil_map.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        ((TextView)findViewById(R.id.soil_name_detail_id)).setText(intent.getStringExtra("soil_name"));
        ((TextView)findViewById(R.id.soil_text_detail_id)).setText(intent.getStringExtra("soil_text"));
    }
}
