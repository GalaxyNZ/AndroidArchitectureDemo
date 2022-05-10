package nz.co.kiwibank.architecturedemo.ui.meh.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import nz.co.kiwibank.architecturedemo.NavGraphDirections
import nz.co.kiwibank.architecturedemo.databinding.MehFragmentBinding
import nz.co.kiwibank.architecturedemo.ui.base.BaseFragment
import nz.co.kiwibank.architecturedemo.ui.meh.viewmodel.MehViewModel

class MehFragment : BaseFragment<MehFragmentBinding, MehViewModel>() {

    override val viewModel: MehViewModel by viewModels()
    override lateinit var binding: MehFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MehFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            viewModel.loginClicked()
        }

        binding.usernameInput.editText?.addTextChangedListener(
            onTextChanged = { username, _, _, _ ->
                viewModel.updateUsername(username.toString())
            }
        )
        binding.passwordInput.editText?.addTextChangedListener(
            onTextChanged = { password, _, _, _ ->
                viewModel.updatePassword(password.toString())
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()

        viewModel.updateUsername("")
        viewModel.updatePassword("")
    }

    override fun onReady(savedInstanceState: Bundle?) {

    }

}