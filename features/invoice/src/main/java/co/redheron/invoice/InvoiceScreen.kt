package co.redheron.invoice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InvoiceScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .weight(1f)
                .padding(16.dp)
        ) {
            InvoiceHeader()

            Spacer(modifier = Modifier.size(8.dp))

            Card(shape = RoundedCornerShape(4.dp), elevation = CardDefaults.cardElevation(8.dp)) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ) {
                    InvoiceItem("Invoice Language")
                    InvoiceItem("Templates")
                    InvoiceItem("Custom Mode")
                }
            }

            Spacer(modifier = Modifier.size(8.dp))

            Card(shape = RoundedCornerShape(4.dp), elevation = CardDefaults.cardElevation(8.dp)) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ) {
                    InvoiceItem("From")
                    InvoiceItem("Invoice To")
                }
            }

            Spacer(modifier = Modifier.size(8.dp))

            Card(shape = RoundedCornerShape(4.dp), elevation = CardDefaults.cardElevation(8.dp)) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ) {
                    InvoiceItem("Items")
                    InvoiceItem("Add item")
                    InvoiceItem("Subtotal")
                    InvoiceItem("Discount")
                    InvoiceItem("Tax")
                    InvoiceItem("Total")
                }
            }

            Spacer(modifier = Modifier.size(8.dp))

            Card(shape = RoundedCornerShape(4.dp), elevation = CardDefaults.cardElevation(8.dp)) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ) {
                    InvoiceItem("Terms and Conditions")
                    InvoiceItem("Payment Method")
                }
            }

            Spacer(modifier = Modifier.size(8.dp))

            Card(shape = RoundedCornerShape(4.dp), elevation = CardDefaults.cardElevation(8.dp)) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ) {
                    InvoiceItem("Attachment")
                }
            }

            Spacer(modifier = Modifier.size(8.dp))
        }

        Row(
            modifier = Modifier
                .height(92.dp)
                .background(Color.White)
                .fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.End

        ) {
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Preview")
            }

            Spacer(modifier = Modifier.size(8.dp))

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Save")
            }
        }
    }
}

@Composable
fun InvoiceHeader() {
    Card(shape = RoundedCornerShape(4.dp), elevation = CardDefaults.cardElevation(8.dp)) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp, start = 8.dp, end = 8.dp),
                text = "INV00002",
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.W200)
            )
            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 2.dp, start = 8.dp, end = 8.dp),
                text = "Created on 15/12/2022",
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.W200)
            )
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 2.dp, start = 8.dp, bottom = 8.dp, end = 8.dp),
                text = "Due on 15/12/2022",
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.W200)
            )
        }
    }
}

@Composable
fun InvoiceItem(title: String) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W300,
                    textAlign = TextAlign.Start
                ),
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "more",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InvoiceHeaderPreview() {
    InvoiceScreen()
}
