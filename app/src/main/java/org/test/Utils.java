package org.test;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;

public final class Utils {

    public static void hideKeyboard(@NonNull View view) {
        view.getContext()
                .getSystemService(InputMethodManager.class)
                .hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private Utils() {
    }

}
