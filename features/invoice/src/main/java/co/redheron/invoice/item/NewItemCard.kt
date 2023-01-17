package co.redheron.invoice.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.redheron.invoice.R

@Preview(showBackground = true)
@Composable
fun NewItemCardPreview() {
    NewItemCard("New Item")
}

@Composable
fun NewItemCard(title: String) {
    Card(shape = RoundedCornerShape(8.dp), elevation = CardDefaults.cardElevation(8.dp)) {
        Row(
            modifier = Modifier
                .height(64.dp)
                .background(Color.White)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_add_circle_24),
                contentDescription = "New Item",
                modifier = Modifier
                    .padding(start = 16.dp, end = 8.dp)
                    .size(16.dp)
                    .clip(CircleShape)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(bottom = 4.dp)
            )
        }
    }
}
