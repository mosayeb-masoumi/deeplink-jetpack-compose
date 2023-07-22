package com.example.deeplinkjetpack

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.deeplinkjetpack.screens.DeepLinkScreen
import com.example.deeplinkjetpack.screens.HomeScreen
import com.example.deeplinkjetpack.ui.theme.DeepLinkJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeepLinkJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)


                    // http://example.com/123    click on this link outside the app and the login page will be open
                }
            }
        }
    }
}


sealed class Destination(var route: String) {
    object Home : Destination("home")
    object DeepLink : Destination("deeplink")
}


@Composable
fun NavigationAppHost(navController: NavHostController) {

    val ctx = LocalContext.current
    // startDestination = "home"
    NavHost(navController = navController, startDestination = Destination.Home.route) {
        composable(Destination.Home.route) { HomeScreen(navController) }

        composable(
            Destination.DeepLink.route,
            deepLinks = listOf(
                navDeepLink {
//                    uriPattern = "http://deeplink.com/{id}/{age}"
                    uriPattern = "http://mydeeplink.com/{id}"
                    action = Intent.ACTION_VIEW
                }
            ), arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = -1
                },

//                navArgument("age") {
//                    type = NavType.IntType
//                    defaultValue = -1
//                }
            )
        ) { entry ->
            val id = entry.arguments?.getInt("id")
            val age = entry.arguments?.getInt("age")
            DeepLinkScreen(id ,age)
        }


    }
}

