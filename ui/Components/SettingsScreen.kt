@Composable
fun SettingsScreen(viewModel: SettingsViewModel) {
    val isDarkTheme by viewModel.isDarkTheme.collectAsState()
    val sleepTimer by viewModel.sleepTimerMinutes.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Dark Theme")
            Switch(checked = isDarkTheme, onCheckedChange = { viewModel.toggleTheme() })
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Sleep Timer: $sleepTimer min")
        Slider(
            value = sleepTimer.toFloat(),
            onValueChange = { viewModel.setSleepTimer(it.toInt()) },
            valueRange = 0f..120f
        )
    }
}
