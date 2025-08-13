package com.kedokato.lession6.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.compose.getCurrentColorScheme
import com.kedokato.lession6.R
import com.kedokato.lession6.presentation.home.HomeState

@Composable
fun TopTracks(modifier: Modifier = Modifier) {
//    LazyColumn {
//        item{
//            Title(
//                modifier = modifier.padding(top = 8.dp),
//                title = "Top Tracks"
//            )
//        }
//
//        item{
//            TopTracksContent(
//                modifier = modifier
//                    .background(getCurrentColorScheme().background)
//            )
//        }
//    }

}

@Composable
fun TopTracksContent(modifier: Modifier = Modifier, state: HomeState) {
    LazyRow(
        modifier = modifier
            .background(getCurrentColorScheme().background)
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(minOf(5,state.tracks.size)) {index ->
            val color = if (index < trackColors.size) {
                trackColors[index]
            } else {
                getCurrentColorScheme().surface
            }
            TrackItem(
                modifier = Modifier.size(160.dp),
                color = color,
                imageUrl = state.tracks[index].imageUrl,
                trackName = state.tracks[index].name,
                listenerCount = state.tracks[index].countListeners,
                albumName = state.tracks[index].artist
            )
        }
    }
}

@Composable
fun TrackItem(
    modifier: Modifier = Modifier,
    color: Color = Color.Blue,
    imageUrl: String? = null,
    trackName: String = "Track Name",
    listenerCount: String = "1M",
    albumName: String = "Album Name",
) {

    Box {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Track Image",
            placeholder = painterResource(id = R.drawable.catset_img),
            error = painterResource(id = R.drawable.apple_music),
            modifier = modifier
                .size(160.dp)
                .background(color)
        )

        Text(
            text = trackName,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            maxLines = 1,
            softWrap = true,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(start = 8.dp, top = 8.dp)
                .align(Alignment.TopStart)
                .size(140.dp)
        )

        Column(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 10.dp, start = 8.dp)
                .align(Alignment.BottomStart),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.Start
        ) {
            TrackInformation(
                modifier = Modifier.padding(top = 8.dp),
                icon = R.drawable.ear_listen,
                title = listenerCount
            )

            TrackInformation(
                modifier = Modifier.padding(top = 4.dp),
                icon = R.drawable.user_check,
                title = albumName
            )
        }

        LightColor(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            color = color
        )

    }
}

@Composable
fun TrackInformation(modifier: Modifier = Modifier, icon: Int, title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = "Icon",
            modifier = modifier.size(16.dp),
            tint = Color.White
        )

        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.White,
            modifier = modifier
                .padding(start = 8.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
fun LightColor(modifier: Modifier = Modifier, color: Color) {
    Box(
        modifier = modifier
            .width(160.dp)
            .height(8.dp)
            .background(color)
    ){}
}

@Preview(showBackground = true)
@Composable
private fun TopTracksPreview() {
   TopTracks(
         modifier = Modifier
             .background(getCurrentColorScheme().background)
             .padding(8.dp)
   )
}

//@Preview(showBackground = true)
//@Composable
//private fun TrackInformationPreview() {
//    TrackInformation(modifier = Modifier, R.drawable.ear_listen, "323232")
//}

val trackColors = listOf(
    Color(0xFFFF7777), // RedSoft
    Color(0xFFFFFA77), // YellowSoft
    Color(0xFF4462FF), // BlueBright
    Color(0xFF14FF00), // GreenNeon
    Color(0xFFE231FF), // PurpleBright
    Color(0xFF00FFFF), // CyanBright
    Color(0xFFFB003C), // PinkDeep
    Color(0xFFF2A5FF)  // PurpleLight
)
