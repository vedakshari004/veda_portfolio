package com.example.myportfolio

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ParticipationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Enable edge-to-edge
        enableEdgeToEdge()

        // 2. Inflate the participations layout
        setContentView(R.layout.activity_participations)

        // 3. Hook up the Toolbar (if present in XML with id="@+id/toolbar")
        findViewById<Toolbar>(R.id.toolbar)?.let { toolbar ->
            setSupportActionBar(toolbar)
            supportActionBar?.title = "Participations"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        // 4. Apply window-insets padding to the root view (must have id="@+id/main")
        findViewById<View>(R.id.main)?.let { root ->
            ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
                val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
                insets
            }
        }
    }

    // 5. Handle the toolbar’s Up button via OnBackPressedDispatcher
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
