package com.example.shift.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.shift.R
import com.example.shift.databinding.FragmentMainBinding
import com.example.shift.presentation.adapter.UsersAdapter

class MainFragment : Fragment(), ClickListener {

    private var _binding: FragmentMainBinding? = null
    private lateinit var viewModel: MainViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        usersObserver()
        exceptionObserver()

    }
    private fun usersObserver() {
        viewModel.users.observe(viewLifecycleOwner) {
            binding.recyclerViewItemUsers.adapter = UsersAdapter(it, this)
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun exceptionObserver() {
        viewModel.errorLiveData.observe(viewLifecycleOwner) { errorMessage ->
            errorMessage?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun infoClick(uuid: String) {
        val args = Bundle()
        args.putString("uuid", uuid)
        findNavController().navigate(R.id.userFragment, args)
    }
}