package csm.czechsoilmap.ui.license;

import androidx.annotation.AnyRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import csm.czechsoilmap.R;

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
