package com.example.shift.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.shift.R
import com.example.shift.databinding.FragmentUserBinding
import com.example.shift.domain.model.UserEntity
import com.squareup.picasso.Picasso

class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private lateinit var viewModel: MainViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val uuid = arguments?.getString("uuid")
        if(uuid != null) {
            showInfoByUser(uuid)
        }
    }

    private fun showInfoByUser(uuid: String) {
        viewModel.users.observe(viewLifecycleOwner) { it ->
            val user: UserEntity? = it.find { it.login.uuid == uuid }
            if (user != null) {
                Picasso.get().load(user.picture.large)
                    .placeholder(R.drawable.user)
                    .into(binding.imageUser)
                binding.gender.text = user.gender
                binding.title.text = user.name.title
                binding.firstName.text = user.name.first
                binding.lastName.text = user.name.last
                binding.email.text = user.email
                binding.phone.text = user.phone
                binding.country.text = user.location.country
                binding.state.text = user.location.state
                binding.city.text = user.location.city
                binding.streetName.text = user.location.street.name
                binding.streetNumber.text = user.location.street.number.toString()
                binding.coordinatesLatitude.text = user.location.coordinates.latitude
                binding.coordinatesLongitude.text = user.location.coordinates.longitude
                binding.timezoneOffset.text = user.location.timezone.offset
                binding.timezoneDescription.text = user.location.timezone.description
                binding.uuid.text = user.login.uuid
                binding.username.text = user.login.username
                binding.password.text = user.login.password
                binding.salt.text = user.login.salt
                binding.md5.text = user.login.md5
                binding.sha1.text = user.login.sha1
                binding.sha256.text = user.login.sha256
                binding.dobDate.text = user.dob.date
                binding.dobAge.text = user.dob.age.toString()
                binding.registeredDate.text = user.registered.date
                binding.registeredAge.text = user.registered.age.toString()
                binding.idName.text = user.id.name
                binding.idValue.text = user.id.value
                binding.cell.text = user.cell
                binding.nat.text = user.nat
            } else {
                Toast.makeText(requireContext(),"Ошибка", Toast.LENGTH_LONG).show()
            }
        }
    }
}