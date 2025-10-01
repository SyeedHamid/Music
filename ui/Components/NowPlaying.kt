@Composable
fun NowPlayingScreen(viewModel: PlayerViewModel) {
    val currentTrack by viewModel.currentTrack.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Album Art
        currentTrack?.albumArt?.let { art ->
            Image(
                painter = rememberImagePainter(art),
                contentDescription = null,
                modifier = Modifier.size(240.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Track Info
        Text(currentTrack?.title ?: "", style = MaterialTheme.typography.h6)
        Text(currentTrack?.artist ?: "", style = MaterialTheme.typography.body2)

        Spacer(modifier = Modifier.height(24.dp))

        // Playback Controls
        PlaybackControls(viewModel = viewModel)
    }
}
