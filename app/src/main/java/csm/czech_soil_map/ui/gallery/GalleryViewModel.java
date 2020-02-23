package csm.czech_soil_map.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> mDragons;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");

        mDragons  = new MutableLiveData<>();
        mDragons.setValue("Beware...\n\n\nHere be dragons");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> getDragons() {
        return mDragons;
    }
}