package com.arunk.dashboardlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    // Halaman 1: lo
                    composable("login") {
                        Loginscreen(
                            onLoginSuccess = {
                                navController.navigate("dashboard")
                            }
                        )
                    }

                    // Halaman 2: Dashboard
                    composable("dashboard") {
                        DashboardScreen(
                            onDataClick = {
                                navController.navigate("data")
                            },
                            onLogout = {
                                navController.navigate("login") {
                                    popUpTo("dashboard") {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }

                    // Halaman 3: Data Mahasiswa
                    composable("data") {
                        DataScreen(
                            onBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}
