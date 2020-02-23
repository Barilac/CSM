package csm.czech_soil_map.ui.home;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import csm.czech_soil_map.R;

public class HomeFragment extends Fragment {

    private WebView mWebView;
    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Setup Webview
        mWebView = (WebView) root.findViewById(R.id.activity_main_webview);
        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        return root;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Enable Javascript
                    WebSettings webSettings = mWebView.getSettings();
                    // Brower niceties -- pinch / zoom, follow links in place
                    webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
                    webSettings.setBuiltInZoomControls(false);
                    // Below required for geolocation
                    webSettings.setJavaScriptEnabled(true);
                    webSettings.setGeolocationEnabled(true);
                    webSettings.setGeolocationDatabasePath("/data/data/testWebClient");
                    mWebView.setWebViewClient(new WebViewClient());
                    mWebView.setWebChromeClient(new WebChromeClient() {
                        public void onGeolocationPermissionsShowPrompt(final String origin,
                                                                       final GeolocationPermissions.Callback callback) {
                            // Always grant permission since the app itself requires location
                            // permission and the user has therefore already granted it
                            callback.invoke(origin, true, false);
                        }
                    });

                    mWebView.loadUrl("file:///android_asset/191215leaflet.html");
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}