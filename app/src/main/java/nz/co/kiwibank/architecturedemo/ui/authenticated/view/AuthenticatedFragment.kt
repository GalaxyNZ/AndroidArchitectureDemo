package nz.co.kiwibank.architecturedemo.ui.authenticated.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import nz.co.kiwibank.architecturedemo.NavGraphDirections
import nz.co.kiwibank.architecturedemo.databinding.FragmentAuthenticatedBinding

class AuthenticatedFragment : Fragment() {

    private lateinit var binding:FragmentAuthenticatedBinding

    private val args: AuthenticatedFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAuthenticatedBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.back.setOnClickListener {
            this.findNavController().navigateUp()
        }

        binding.textView.text = args.username
    }
}