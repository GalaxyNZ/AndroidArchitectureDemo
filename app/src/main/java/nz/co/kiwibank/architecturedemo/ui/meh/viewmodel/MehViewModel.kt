package nz.co.kiwibank.architecturedemo.ui.meh.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nz.co.kiwibank.architecturedemo.NavGraphDirections
import nz.co.kiwibank.architecturedemo.ui.authenticated.model.User
import nz.co.kiwibank.architecturedemo.ui.base.BaseViewModel
import nz.co.kiwibank.architecturedemo.ui.meh.model.MehModel

class MehViewModel : BaseViewModel() {

    private val _user = MutableLiveData<MehModel>()
    val user get() = _user

    init {
        _user.value = MehModel("","")
    }

    fun loginClicked() {
        navigate(NavGraphDirections.actionGlobalAuthenticatedFragment(user.value?.username ?: "", user.value?.password ?: ""))
    }

    fun updateUsername(username: String) {
        _user.value?.username = username
    }

    fun updatePassword(password: String) {
        _user.value?.password = password
    }
}