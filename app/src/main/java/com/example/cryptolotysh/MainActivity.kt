package com.example.cryptolotysh

import AESEncryptor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secretKey =
            "662ede816988e58fb6d057d9d85605e0"

        var encryptor = AESEncryptor()


        crypt.setOnClickListener {
            if (text_crypt.length() >= 1) {

                val encryptedValue: String? =
                    encryptor.encrypt(text_crypt.text.toString(), secretKey)
                    text_decrypt.setText(encryptedValue.toString())
                    textView.text = encryptedValue
            } else {
                Toast.makeText(this, "введіть текст для дешифрування", Toast.LENGTH_SHORT)
                    .show()
            }

        }


        decrypt.setOnClickListener {
            if (text_decrypt.length() >= 1) {
                val decryptedValue: String? =
                    encryptor.decryptWithAES(secretKey, text_decrypt.text.toString())
                textView.text = decryptedValue
            } else {
                Toast.makeText(this, "введіть текст для дешифрування", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}