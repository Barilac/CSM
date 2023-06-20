package csm.czechsoilmap.ui.license;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import csm.czechsoilmap.R;
import csm.czechsoilmap.ui.gallery.GalleryViewModel;

public class LicenseFragment extends Fragment {

    private LicenseViewModel  licenseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        licenseViewModel =
                ViewModelProviders.of(this).get(LicenseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_license, container, false);

        final TextView textView = root.findViewById(R.id.text_license);
        textView.setMovementMethod(new ScrollingMovementMethod());
        licenseViewModel.getText().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(getString(integer));
            }
        });

        return root;
    }

}
