package nz.co.kiwibank.architecturedemo.ui.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import nz.co.kiwibank.architecturedemo.ui.base.util.Event
import nz.co.kiwibank.architecturedemo.ui.base.util.NavigationCommand

abstract class BaseViewModel: ViewModel() {

    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> get() = _navigation

    fun navigate(navDirections: NavDirections) {
        Log.d("BaseViewModel", "attempting navigation")
        _navigation.value = Event(NavigationCommand.ToDirection(navDirections))
        Log.d("BaseViewModel", "navigation success?")
    }

    fun navigateBack() {
        _navigation.value = Event(NavigationCommand.Back)
    }
}