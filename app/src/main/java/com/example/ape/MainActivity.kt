package com.example.ape

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var u_call: Button
    private lateinit var u_sms: Button
    private lateinit var u_web: Button
    private lateinit var u_photo: Button
    private lateinit var u_email: Button
    private lateinit var u_mpesa: Button
    private lateinit var u_youtube: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        u_call = findViewById(R.id.uscall)
        u_sms = findViewById(R.id.ussms)
        u_web = findViewById(R.id.usweb)
        u_photo = findViewById(R.id.usphoto)
        u_email = findViewById(R.id.usemail)
        u_mpesa = findViewById(R.id.usmpesa)
        u_youtube = findViewById(R.id.btnYT)

        //this apply to when you want to open an article.
        //  u_youtube.setOnClickListener  sets up click listener for u_youtube
        //line val youTubeIntent to ))) This line creates an Intent object. Intents in Android are messages that can be used to request an action from another component of the Android system,
        // like opening a web page, starting a new activity, etc.
         //startActivity(youTubeIntent)
        // This line starts the activity specified by the youtubeIntent. In this case, it will open a web browser or
        // the YouTube app (if installed) to view the YouTube video with the specified URL.

        u_youtube.setOnClickListener {
            val youTubeIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=E-o-q9FFp70"))
            startActivity(youTubeIntent)

        }

        u_mpesa.setOnClickListener {
            Toast.makeText(this, "thank you", Toast.LENGTH_SHORT).show()
            val simToolKit =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKit?.let { startActivity(it) }

        }
        u_email.setOnClickListener {
            Toast.makeText(this, "thank you", Toast.LENGTH_SHORT).show()
            val emailIntent =
                Intent(
                    Intent.ACTION_SENDTO,
                    Uri.fromParts("mailto", "abc@gmail.com", null)
                )
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }

        u_photo.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }

        u_web.setOnClickListener {

            Toast.makeText(this, "thank you", Toast.LENGTH_SHORT).show()
        }

        u_sms.setOnClickListener {

            val uri = Uri.parse("smsto:444333")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("Hello", "I need help!")

            startActivity(intent)



            Toast.makeText(this, "thanks for texting", Toast.LENGTH_SHORT).show()
        }

        u_call.setOnClickListener {

            var phone = "+2540706231"
            var intent = Intent(
                Intent.ACTION_DIAL, Uri.fromParts(
                    "tel",
                    phone, null
                )
            )
            startActivity(intent)


            Toast.makeText(this, "thanks for calling", Toast.LENGTH_SHORT).show()
        }

    }
}