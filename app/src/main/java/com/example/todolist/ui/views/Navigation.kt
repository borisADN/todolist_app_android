package com.example.todolist.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todolist.Start
import com.example.todolist.ui.views.screen.authentication.ForgottenPassword
import com.example.todolist.ui.views.screen.authentication.NewPassword
import com.example.todolist.ui.views.screen.authentication.OTPCode
import com.example.todolist.ui.views.screen.authentication.SignIn
import com.example.todolist.ui.views.screen.user.Home
import com.example.todolist.ui.views.screens.authentication.Registration

@Composable
fun Navigation(
    startDestination: String = StartRouteScreens.StartScreen.path
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = StartRouteScreens.StartScreen.path){
            Start(navController = navController)
        }
        composable(route = AuthRouteScreens.RegistrationScreen.path){
            Registration(navController = navController)
        }
        composable(route = AuthRouteScreens.SignInScreen.path) {
            SignIn(navController = navController)
        }
        composable(route = AuthRouteScreens.ForgottenPasswordScreen.path) {
            ForgottenPassword(navController = navController)
        }
        composable(route = "${AuthRouteScreens.OTPCodeScreen.path}/{email}",
            arguments = listOf(navArgument("email") { type = NavType.StringType })
        ) {
            val email = it.arguments?.getString("email") ?: ""
            OTPCode(navController = navController, email = email)
        }
        composable(route = AuthRouteScreens.NewPasswordScreen.path) {
            NewPassword(navController = navController)
        }
        composable(route = MainRouteScreens.HomeScreen.path) {
            Home(navController = navController)
        }
    }
}