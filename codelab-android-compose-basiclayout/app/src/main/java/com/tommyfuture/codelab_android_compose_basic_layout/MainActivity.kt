package com.tommyfuture.codelab_android_compose_basic_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tommyfuture.codelab_android_compose_basic_layout.data.BodyData
import com.tommyfuture.codelab_android_compose_basic_layout.ui.theme.CodelabandroidcomposebasiclayoutTheme

private val alignYourBodyData = listOf(
    BodyData(R.drawable.exam_image1, R.string.ab1_inversions),
    BodyData(R.drawable.exam_image1, R.string.ab1_inversions),
    BodyData(R.drawable.exam_image1, R.string.ab1_inversions),
    BodyData(R.drawable.exam_image1, R.string.ab1_inversions),
    BodyData(R.drawable.exam_image1, R.string.ab1_inversions),
    BodyData(R.drawable.exam_image1, R.string.ab1_inversions),
    BodyData(R.drawable.exam_image1, R.string.ab1_inversions),
    BodyData(R.drawable.exam_image1, R.string.ab1_inversions),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodelabandroidcomposebasiclayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SearchBar()
                }
            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
        ),
        placeholder = {
            Text(
                stringResource(R.string.placeholder_search),
                color = Color.Gray
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CodelabandroidcomposebasiclayoutTheme {
        SearchBar()
    }
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0XFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview() {
    CodelabandroidcomposebasiclayoutTheme {
//        AlignYourBodyElement(
//            text = R.string.ab1_inversions,
//            drawable = R.drawable.exam_image1,
//            modifier = Modifier.padding(8.dp)
//        )
        AlignYourBodyRow(modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp),
            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)

    ) {
        items(alignYourBodyData) { item ->
            FavoriteCollectionCard(item.drawable, item.text)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0XFFF5F0EE)
@Composable
fun FavoriteCollectionCardPreview() {
    CodelabandroidcomposebasiclayoutTheme {
        FavoriteCollectionsGrid(
            modifier = Modifier.padding(8.dp)
        )
    }
}