package co.redheron.invoice.item

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.redheron.invoice.R

@Preview(showBackground = true)
@Composable
fun ItemScreenPreview() {
    AddItemScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.add_item)) },
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
                Spacer(modifier = Modifier.height(16.dp))

                NewItemCard(title = "New Item")

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Item List",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyColumn {
                    items(list) { item ->
                        ItemRow(title = item.title, subTitle = item.subTitle)
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

data class Item(val title: String, val subTitle: String)

val list = listOf(
    Item("Onions", "Sh100.00"),
    Item("Maize", "Sh 100.00"),
    Item("Sugar", "Sh 100.00"),
    Item("Computer", "Sh 100.00")
)
