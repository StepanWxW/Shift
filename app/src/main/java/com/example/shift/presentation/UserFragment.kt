package com.example.shift.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
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
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val viewModel: MainViewModel by viewModel()
    private val binding get() = _binding!!
    private var userUI: UserEntity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val uuid = arguments?.getString("uuid")
        if(uuid != null) {
            showInfoByUser(uuid)
        }
        phoneClickListener()
        emailClickListener()
        locationClickListener()
    }

    private fun locationClickListener() {
        binding.cnstrLocation.setOnClickListener {
            if (userUI != null) {
                val latitude = userUI!!.location.coordinates.latitude
                val longitude = userUI!!.location.coordinates.longitude

                val geoUri = "geo:$latitude,$longitude"
                val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
                val chooser = Intent.createChooser(mapIntent, getString(R.string.choose_app))
                startActivity(chooser)
            } else {
                showError()
            }
        }
    }

    private fun emailClickListener() {
        binding.cnstrEmail.setOnClickListener {
            if (userUI != null) {
                val emailAddress = "mailto:" + userUI!!.email
                val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse(emailAddress))
                val chooser = Intent.createChooser(emailIntent, getString(R.string.choose_email))
                startActivity(chooser)
            } else {
                showError()
            }
        }
    }

    private fun phoneClickListener() {
        binding.cnstrPhone.setOnClickListener {
            if (userUI != null) {
                val phoneNumber = "tel:" + userUI!!.phone
                val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))
                val chooser = Intent.createChooser(dialIntent, getString(R.string.choose_app))
                startActivity(chooser)
            } else {
                showError()
            }
        }
    }

    private fun showInfoByUser(uuid: String) {
        viewModel.users.observe(viewLifecycleOwner) { it ->
            userUI = it.find { it.login.uuid == uuid }
            if (userUI != null) {
                Picasso.get().load(userUI!!.picture.large)
                    .placeholder(R.drawable.user)
                    .into(binding.imageUser)
                binding.gender.text = userUI!!.gender
                binding.title.text = userUI!!.name.title
                binding.firstName.text = userUI!!.name.first
                binding.lastName.text = userUI!!.name.last
                binding.email.text = userUI!!.email
                binding.phone.text = userUI!!.phone
                binding.country.text = userUI!!.location.country
                binding.state.text = userUI!!.location.state
                binding.city.text = userUI!!.location.city
                binding.streetName.text = userUI!!.location.street.name
                binding.streetNumber.text = userUI!!.location.street.number.toString()
                binding.coordinatesLatitude.text = userUI!!.location.coordinates.latitude
                binding.coordinatesLongitude.text = userUI!!.location.coordinates.longitude
                binding.timezoneOffset.text = userUI!!.location.timezone.offset
                binding.timezoneDescription.text = userUI!!.location.timezone.description
                binding.uuid.text = userUI!!.login.uuid
                binding.username.text = userUI!!.login.username
                binding.password.text = userUI!!.login.password
                binding.salt.text = userUI!!.login.salt
                binding.md5.text = userUI!!.login.md5
                binding.sha1.text = userUI!!.login.sha1
                binding.sha256.text = userUI!!.login.sha256
                binding.dobDate.text = userUI!!.dob.date
                binding.dobAge.text = userUI!!.dob.age.toString()
                binding.registeredDate.text = userUI!!.registered.date
                binding.registeredAge.text = userUI!!.registered.age.toString()
                binding.idName.text = userUI!!.id.name
                binding.idValue.text = userUI!!.id.value
                binding.cell.text = userUI!!.cell
                binding.nat.text = userUI!!.nat
            } else {
                showError()
            }
        }
    }
    private fun showError(){
        Toast.makeText(requireContext(),"Ошибка", Toast.LENGTH_LONG).show()
    }
}