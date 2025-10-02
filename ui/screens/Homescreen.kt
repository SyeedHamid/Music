
@Composable
fun MainScreen(navController: NavHostController, playerViewModel: PlayerViewModel) {
    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.LibraryMusic, contentDescription = null) },
                    selected = navController.currentDestination?.route == "library",
                    onClick = { navController.navigate("library") }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.QueueMusic, contentDescription = null) },
                    selected = navController.currentDestination?.route == "queue",
                    onClick = { navController.navigate("queue") }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.PlayCircleFilled, contentDescription = null) },
                    selected = navController.currentDestination?.route == "nowplaying",
                    onClick = { navController.navigate("nowplaying") }
                )
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "library",
            modifier = Modifier.padding(padding)
        ) {
            composable("library") { LibraryScreen(viewModel = playerViewModel.libraryViewModel) }
            composable("queue") { QueueScreen(viewModel = playerViewModel) }
            composable("nowplaying") { NowPlayingScreen(viewModel = playerViewModel) }
        }
    }
}
