package org.test.utils;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;

public final class ViewUtils {

    public static void hideKeyboard(@NonNull View view) {
        view.getContext()
                .getSystemService(InputMethodManager.class)
                .hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private ViewUtils() {
    }

}
