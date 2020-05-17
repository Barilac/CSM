package csm.czech_soil_map.ui.gallery;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import csm.czech_soil_map.R;

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the list of soils
    private final String[] nameArray;

    //to store the list of soils
    private final String[] infoArray;


    public CustomListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam){

        super(context, R.layout.listview_row , nameArrayParam);
        this.context = context;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater(); //najde inflater ktery vytvori nadpisy na zaklade xml
        View rowView = inflater.inflate(R.layout.listview_row, null, true); //vytvor view_row

        TextView subheaderTextView = (TextView) rowView.findViewById(R.id.soil_name);
        TextView textTextView = (TextView) rowView.findViewById(R.id.soil_text);
        TextView first_letter = (TextView) rowView.findViewById(R.id.first_letter);

        subheaderTextView.setText(nameArray[position]);
        textTextView.setText(infoArray[position]);
        first_letter.setText(nameArray[position].charAt(0)); //najde prvni pismeno ve slove
        return rowView;
    }
}
