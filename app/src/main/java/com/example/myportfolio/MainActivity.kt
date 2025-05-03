package com.example.myportfolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myportfolio.ui.theme.MyPortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            // ✅ Safe inside @Composable block
            val systemDark = isSystemInDarkTheme()
            var isDark by rememberSaveable {
                mutableStateOf(systemDark)
            }

            MyPortfolioTheme(useDarkTheme = isDark) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        isDark = isDark,
                        onToggleTheme = {
                            isDark = !isDark
                            AppCompatDelegate.setDefaultNightMode(
                                if (isDark) AppCompatDelegate.MODE_NIGHT_YES
                                else AppCompatDelegate.MODE_NIGHT_NO
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(isDark: Boolean, onToggleTheme: () -> Unit) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))

            // Profile
            Image(
                painter = painterResource(id = R.drawable.me_vit),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Yeruva Vedakshari",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Student",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(24.dp))

            // About section
            Text(
                text = "About: Aspiring computer science engineer with practical experience in developing real-world solutions through internships and projects in data science, machine learning, and web development. Skilled in Python, Java, and SQL, with a proven ability to solve complex problems and build functional applications.",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Skills & Education buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    context.startActivity(Intent(context, SkillsActivity::class.java))
                }) {
                    Text("Skills")
                }

                Button(onClick = {
                    context.startActivity(Intent(context, EducationActivity::class.java))
                }) {
                    Text("Education")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Projects
            Button(
                onClick = {
                    context.startActivity(Intent(context, ProjectsActivity::class.java))
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Projects")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Certifications & Participations
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        context.startActivity(Intent(context, CertificationsActivity::class.java))
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Certifications")
                }

                Button(
                    onClick = {
                        context.startActivity(Intent(context, ParticipationsActivity::class.java))
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Participations")
                }
            }

            Spacer(modifier = Modifier.height(64.dp))
        }

        // Top-right theme toggle
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Text(
                text = if (isDark) "Dark Mode" else "Light Mode",
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
            )
            Switch(
                checked = isDark,
                onCheckedChange = { onToggleTheme() }
            )
        }

        // Bottom-left email & LinkedIn
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 12.dp)
        ) {
            Text(
                text = "Email: vedakshari2999@gmail.com",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:vedakshari2999@gmail.com")
                    }
                    context.startActivity(intent)
                }
            )
            Text(
                text = "LinkedIn: linkedin.com/in/yeruvavedakshari",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://linkedin.com/in/yeruvavedakshari"))
                    context.startActivity(intent)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyPortfolioTheme(useDarkTheme = false) {
        MainScreen(isDark = false, onToggleTheme = {})
    }
}
