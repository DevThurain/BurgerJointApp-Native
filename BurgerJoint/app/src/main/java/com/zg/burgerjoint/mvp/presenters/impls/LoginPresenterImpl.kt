package com.zg.burgerjoint.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.zg.burgerjoint.mvp.presenters.LoginPresenter
import com.zg.burgerjoint.mvp.views.LoginView
import com.zg.burgerjoint.utils.Constants

class LoginPresenterImpl : LoginPresenter, BaseAppPresenterImpl<LoginView>() {
    override fun onUIReady(owner: LifecycleOwner) {}

    override fun onTapLogin(userName: String, password: String) {
        if(userName.isNotEmpty() || password.isNotEmpty()){
            mView.navigateToMainScreen()
        } else {
            mView.showErrorMessage(Constants.errorMessage)
        }
    }
}
