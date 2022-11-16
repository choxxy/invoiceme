package co.redheron.invoice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun AttachmentDefaultPreview() {
    AttachmentDashboard(list, list2)
}

@Composable
fun AttachmentDashboardCard(title: String, subTitle: String) {
    Card(shape = RoundedCornerShape(4.dp), elevation = CardDefaults.cardElevation(8.dp)) {
        Row(modifier = Modifier
            .height(72.dp)
            .background(Color.White)
            .fillMaxWidth()) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Center) {
                Text(text = title,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W700))
                Text(text = subTitle,
                    style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.W200))
            }
        }
    }
}

@Composable
fun AttachmentRecentListItem(title: String, subTitle: String) {
    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxWidth()
        .padding(vertical = 8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title,
                style = TextStyle(fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Start),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f))
            Text(text = subTitle,
                style = TextStyle(fontSize = 14.sp,
                    fontWeight = FontWeight.W200,
                    textAlign = TextAlign.End), modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f))
        }
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "KES 5,0000",
                style = TextStyle(fontSize = 12.sp,
                    fontWeight = FontWeight.W200,
                    textAlign = TextAlign.Start),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f))
            Text(text = "Paid",
                style = TextStyle(fontSize = 12.sp,
                    fontWeight = FontWeight.W200,
                    textAlign = TextAlign.End), modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttachmentDashboard(list: List<DashboardItem>, list2: List<DashboardItem>) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.dummy_name)) },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }

            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }, content = {
                Icon(Icons.Filled.Add, null)
            })
        }
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {

            Column(Modifier.padding(16.dp)) {
                LazyVerticalGrid(columns = GridCells.Fixed(2),
                    // content padding for the grid
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(list) { item ->
                        AttachmentDashboardCard(title = item.title, subTitle = item.subTitle)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card(shape = RoundedCornerShape(4.dp)) {
                    Column(modifier = Modifier.background(Color.White)) {
                        Row(modifier = Modifier
                            .height(36.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Recent Invoice",
                                style = TextStyle(fontSize = 14.sp,
                                    textAlign = TextAlign.Center), modifier = Modifier
                                    .fillMaxWidth())
                        }

                        Divider(thickness = 0.5.dp, color = Color.LightGray)

                        LazyColumn(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                            items(list2) { item ->
                                AttachmentRecentListItem(title = item.title,
                                    subTitle = item.subTitle)
                            }
                        }

                        Divider(thickness = 0.5.dp, color = Color.LightGray)

                        Row(modifier = Modifier
                            .height(36.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "See More",
                                style = TextStyle(fontSize = 14.sp, textAlign = TextAlign.Center),
                                modifier = Modifier
                                    .fillMaxWidth())
                        }
                    }
                }
            }

        }
    }

}