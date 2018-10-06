package org.test.utils

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

fun CharSequence.toast(context: Context, length: Int = Toast.LENGTH_SHORT) = Toast
        .makeText(context, this, length)
        .show()

fun Throwable.log() {
    Log.e(Thread.currentThread().name, message, this)
}

fun View.hideKeyboard() = context
        .getSystemService(InputMethodManager::class.java)!!
        .hideSoftInputFromWindow(windowToken, 0)

fun ViewGroup.inflate(@LayoutRes layourId: Int, attachToRoot: Boolean = false) = LayoutInflater
        .from(context)
        .inflate(layourId, this, attachToRoot)!!

var TextView.textOrHide: CharSequence?
    get() = text
    set(value) {
        text = value
        isVisible = !value.isNullOrBlank()
    }

fun Fragment.replaceWith(other: Fragment, tag: String? = null, addToBackStack: Boolean = false) = fragmentManager!!
        .beginTransaction()
        .replace(id, other, tag)
        .apply { if (addToBackStack) addToBackStack(null) }
        .commit()

fun <R> doAsync(onResult: (R) -> Unit, onError: (Throwable) -> Unit = { throw it }, action: () -> R) =
        object : AsyncTask<Unit, Unit, R>() {
            var error: Throwable? = null

            override fun doInBackground(vararg params: Unit?): R? {
                return try {
                    action.invoke()

                } catch (t: Throwable) {
                    error = t
                    null
                }
            }

            override fun onPostExecute(result: R) =
                    error?.let(onError::invoke) ?: onResult.invoke(result)

        }.execute()!!
