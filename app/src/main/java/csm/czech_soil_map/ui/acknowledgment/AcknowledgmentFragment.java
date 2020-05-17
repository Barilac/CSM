package csm.czech_soil_map.ui.acknowledgment;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import csm.czech_soil_map.R;

public class AcknowledgmentFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AcknowledgmentViewModel acknowledgmentViewModel = ViewModelProviders.of(this).get(AcknowledgmentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_acknowledgment, container, false);

        final TextView textView = root.findViewById(R.id.text_acknowledgment);
        textView.setMovementMethod(new ScrollingMovementMethod());
        acknowledgmentViewModel.getText().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(getString(integer));
            }
        });

        return root;
    }


}
