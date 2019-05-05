package net.renakus.profilediri

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class profileactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        ambilData()
    }

    private fun ambilData() {
        val bundle = intent.extras

        val name = bundle?.getString("name")
        val gender = bundle?.getString("gender")
        val email = bundle?.getString("email")
        val telp = bundle?.getString("telp")
        val address = bundle?.getString("address")

        txtname.text = name
        txtgender.text = gender
        txtemail.text = email
        txttelp.text = telp
        txtaddress.text = address
    }
}
