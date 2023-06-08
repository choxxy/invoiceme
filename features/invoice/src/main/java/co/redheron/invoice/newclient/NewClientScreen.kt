package co.redheron.invoice.newclient

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.redheron.invoice.BusinessDetailsScreen
import co.redheron.invoice.R
import co.redheron.invoice.shared.views.TextInput
import com.dsc.form_builder.BaseState
import com.dsc.form_builder.FormState
import com.dsc.form_builder.TextFieldState

@Preview(showBackground = true)
@Composable
fun NewClientPreview() {
    val formState: FormState<BaseState<*>> = FormState(
        listOf(
            TextFieldState("username"),
            TextFieldState("email"),
            TextFieldState("number")
        )
    )
    BusinessDetailsScreen(formState)
}

@Composable
fun NewClientCard(title: String) {
    Card(shape = RoundedCornerShape(4.dp), elevation = CardDefaults.cardElevation(8.dp)) {
        Row(
            modifier = Modifier
                .height(72.dp)
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Text(
                text = title,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W700)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewClientScreen(formState: FormState<BaseState<*>>) {
    val usernameState: TextFieldState = formState.getState("username")
    val emailState: TextFieldState = formState.getState("email")
    val numberState: TextFieldState = formState.getState("number")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.new_client)) },
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
            Card(shape = RoundedCornerShape(8.dp), elevation = CardDefaults.cardElevation(8.dp)) {
                Column(Modifier.padding(16.dp)) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Client Details",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Image(
                        alignment = Alignment.Center,
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = ""
                    )

                    TextInput(label = "Business Name", state = usernameState)

                    Spacer(modifier = Modifier.height(10.dp))

                    TextInput(label = "Email Address", state = emailState)

                    Spacer(modifier = Modifier.height(10.dp))

                    TextInput(label = "Phone Number", state = numberState)

                    Spacer(modifier = Modifier.height(10.dp))

                    TextInput(label = "Billing Address", state = usernameState)

                    Spacer(modifier = Modifier.height(10.dp))

                    TextInput(label = "", state = emailState)

                    Spacer(modifier = Modifier.height(10.dp))

                    TextInput(label = "Business Website", state = numberState)

                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    }
}
