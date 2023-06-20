package csm.czechsoilmap.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import csm.czechsoilmap.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        String[] names = getResources().getStringArray(R.array.soil_names);
        String[] texts = getResources().getStringArray(R.array.soil_texts);

        CustomListAdapter cla = new CustomListAdapter(this.getActivity(), names, texts);
        listView = (ListView) root.findViewById(R.id.soil_list);
        listView.setAdapter(cla);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GalleryFragment.this.getContext(), DetailActivity.class);
                intent.putExtra("soil_name", names[position]);
                intent.putExtra("soil_text", texts[position]);
                startActivity(intent);
            }
        });

        return root;
    }
}