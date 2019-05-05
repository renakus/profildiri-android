package net.renakus.profilediri

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var nameInput: String = ""
    var emailInput: String = ""
    var telpInput: String = ""
    var addressInput: String = ""
    var genderInput: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsave.setOnClickListener {
            validasiInput()
        }
        setDataSpinnerGener()
    }

    private fun setDataSpinnerGener() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.gender_list,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnergender.adapter = adapter
    }

    private fun validasiInput() {
        nameInput = editname.text.toString()
        emailInput = editemail.text.toString()
        telpInput = edittelp.text.toString()
        addressInput = editaddress.text.toString()
        genderInput = spinnergender.selectedItem.toString()

        when {
            nameInput.isEmpty() -> editname.error = "Nama tidak boleh kosong"
            genderInput.equals("Gender") -> tampilToast("Select gender")
            emailInput.isEmpty() -> editemail.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> edittelp.error = "Telp tidak boleh kosong"
            addressInput.isEmpty() -> editaddress.error = "Alamat tidak boleh kosong"

            else -> {
                tampilToast("Profil Diri")
                navigasiKeProfilDiri()
            }
        }
    }

    private fun navigasiKeProfilDiri() {
        val intent = Intent(this, profileactivity::class.java)

        val bundle = Bundle()
        bundle.putString("name", nameInput)
        bundle.putString("gender", genderInput)
        bundle.putString("email", emailInput)
        bundle.putString("telp", telpInput)
        bundle.putString("address", addressInput)

        intent.putExtras(bundle)

        startActivity(intent)

    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
