package csm.czechsoilmap.ui.acknowledgment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import csm.czechsoilmap.R;

public class AcknowledgmentViewModel extends ViewModel {

    private MutableLiveData<Integer> mText;

    public AcknowledgmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(R.string.acknowledgment_text);
    }

    public LiveData<Integer> getText() {
        return mText;
    }

}
