import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anonymous.users.presentation.DeviceHolderListScreen

@Composable
fun NavigationApp(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenNames.DeviceHolderList.route
    ) {
        composable(route = ScreenNames.DeviceHolderList.route) {
            DeviceHolderListScreen(navController)
        }
        composable(route = "${ScreenNames.Details.route}/{userID}") { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("userID") ?: ""

        }
    }
}

sealed class ScreenNames(val route: String) {
    object DeviceHolderList : ScreenNames("list")
    object Details : ScreenNames("details")
}
