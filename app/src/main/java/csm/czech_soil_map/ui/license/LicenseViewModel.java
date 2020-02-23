package csm.czech_soil_map.ui.license;

import androidx.annotation.AnyRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import csm.czech_soil_map.R;

public class LicenseViewModel extends ViewModel {

    private MutableLiveData<Integer> mText;

    public LicenseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(R.string.license_text);
    }

    public LiveData<Integer> getText() {
        return mText;
    }

}
