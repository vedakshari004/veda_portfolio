package com.example.myportfolio

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EducationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge layout
        enableEdgeToEdge()

        // Inflate the layout
        setContentView(R.layout.activity_education)

        // Hook up the Toolbar
        findViewById<Toolbar>(R.id.toolbar).also { toolbar ->
            setSupportActionBar(toolbar)
            supportActionBar?.apply {
                title = "Education"
                setDisplayHomeAsUpEnabled(true)
            }
        }

        // Apply system-bar insets padding to the root view (id="main")
        findViewById<View>(R.id.main)?.let { root ->
            ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
                val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
                insets
            }
        }
    }

    // Handle the toolbar’s Up button by finishing the activity
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
