package nz.co.kiwibank.architecturedemo.ui.meh.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import nz.co.kiwibank.architecturedemo.NavGraphDirections
import nz.co.kiwibank.architecturedemo.ui.base.BaseViewModel

class MehViewModel : BaseViewModel() {

    fun loginClicked() {
        Log.d("MehViewModel", "Login Clicked")
        navigate(NavGraphDirections.actionGlobalAuthenticatedFragment("Meow"))
    }
}