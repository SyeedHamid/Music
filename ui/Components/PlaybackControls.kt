@Composable
fun PlaybackControls(viewModel: PlayerViewModel) {
    val isPlaying by viewModel.isPlaying.collectAsState()
    val currentPosition by viewModel.currentPosition.collectAsState()
    val duration by viewModel.duration.collectAsState()
    val repeatMode by viewModel.repeatMode.collectAsState()
    val isShuffling by viewModel.isShuffling.collectAsState()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Playback Control Row
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Shuffle Toggle
            IconButton(onClick = { viewModel.toggleShuffle() }) {
                Icon(
                    imageVector = Icons.Default.Shuffle,
                    tint = if (isShuffling) Color.White else Color.Gray,
                    contentDescription = "Shuffle"
                )
            }

            // Previous Track
            IconButton(onClick = { viewModel.skipToPrevious() }) {
                Icon(
                    imageVector = Icons.Default.SkipPrevious,
                    contentDescription = "Previous"
                )
            }

            // Play/Pause
            IconButton(onClick = { viewModel.togglePlayPause() }) {
                Icon(
                    imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = "Play/Pause"
                )
            }

            // Next Track
            IconButton(onClick = { viewModel.skipToNext() }) {
                Icon(
                    imageVector = Icons.Default.SkipNext,
                    contentDescription = "Next"
                )
            }

            // Repeat Mode Toggle
            IconButton(onClick = { viewModel.toggleRepeatMode() }) {
                Icon(
                    imageVector = when (repeatMode) {
                        RepeatMode.NONE -> Icons.Default.Repeat
                        RepeatMode.ONE -> Icons.Default.RepeatOne
                        RepeatMode.ALL -> Icons.Default.Repeat
                    },
                    tint = if (repeatMode == RepeatMode.NONE) Color.Gray else Color.White,
                    contentDescription = "Repeat Mode"
                )
            }
        }

        // Time Display
        Text("${formatTime(currentPosition)} / ${formatTime(duration)}")

        // SeekBar
        Slider(
            value = currentPosition.toFloat(),
            onValueChange = { viewModel.seekTo(it.toLong()) },
            valueRange = 0f..duration.toFloat()
        )
    }
}
