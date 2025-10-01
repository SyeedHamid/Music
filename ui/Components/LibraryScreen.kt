@Composable
fun LibraryScreen(viewModel: LibraryViewModel) {
    val allTracks by viewModel.allTracks.collectAsState()
    val query by viewModel.searchQuery.collectAsState()

    Column {
        TextField(
            value = query,
            onValueChange = { viewModel.updateSearchQuery(it) },
            placeholder = { Text("Search tracks...") },
            modifier = Modifier.fillMaxWidth()
        )

        TrackList(tracks = allTracks, onTrackClick = { viewModel.playTrack(it) })
    }
}
