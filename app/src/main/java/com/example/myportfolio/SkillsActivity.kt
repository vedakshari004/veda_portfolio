package com.example.myportfolio

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SkillsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Enable edge-to-edge layout
        enableEdgeToEdge()

        // 2. Set the content view
        setContentView(R.layout.activity_skills)

        // 3. If you add a Toolbar to activity_skills.xml with id="@+id/toolbar", you can hook it up:
        findViewById<Toolbar>(R.id.toolbar)?.let { toolbar ->
            setSupportActionBar(toolbar)
            supportActionBar?.title = "Skills"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        // 4. Apply window-insets padding to the root view (must have id="@+id/main")
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
        // Using the new OnBackPressedDispatcher instead of deprecated onBackPressed()
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
