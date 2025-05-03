package com.example.myportfolio

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CertificationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Enable edge-to-edge layout
        enableEdgeToEdge()

        // 2. Set the content view to activity_certifications layout
        setContentView(R.layout.activity_certifications)

        // 3. Set up the Toolbar with the back button
        findViewById<Toolbar>(R.id.toolbar)?.let { toolbar ->
            setSupportActionBar(toolbar)
            supportActionBar?.apply {
                title = "Certifications"  // Set the toolbar title
                setDisplayHomeAsUpEnabled(true) // Show the back button
            }
        }

        // 4. Apply window-insets padding to the root view (id="main")
        findViewById<View>(R.id.main)?.let { root ->
            ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }

    // 5. Handle the back button in the toolbar using OnBackPressedDispatcher
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed() // Using OnBackPressedDispatcher for back navigation
        return true
    }
}
