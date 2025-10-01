@Composable
fun QueueScreen(viewModel: PlayerViewModel) {
    val queue by viewModel.playbackQueue.collectAsState()

    LazyColumn {
        itemsIndexed(queue) { index, track ->
            TrackItem(
                track = track,
                onClick = { viewModel.playTrackAt(index) },
                onRemove = { viewModel.removeFromQueue(index) }
            )
        }
    }
}
