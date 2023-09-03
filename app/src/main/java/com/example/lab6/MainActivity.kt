package com.example.lab6

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab6.ui.theme.Lab6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Lab6Theme {
        LoginScreen()
    }
}

@Composable
fun LoginScreen() {
    Box (modifier = Modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(id = R.drawable.concrete_texture),
            contentDescription = "app background",
            contentScale = ContentScale.FillBounds,
            alpha = 0.5F,
            modifier = Modifier.matchParentSize()
        )

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.kaiju_text),
                contentDescription = "App title",
                alpha = 0.8F
            )

            Image(painter = painterResource(id = R.drawable.art_rend),
                contentDescription = "Art font",
                alpha = 0.8F,
                modifier = Modifier.height(80.dp)
            )

            Image(painter = painterResource(id = R.drawable.gallery_rend),
                contentDescription = "Gallery font",
                alpha = 0.8F,
                modifier = Modifier
                    .height(100.dp)
            )

            LoginForm()

            Image(
                painter = painterResource(id = R.drawable.kaiju_logo),
                contentDescription = "app logo",
                alpha = 0.8F,
                colorFilter = ColorFilter.tint(Color.Black)
            )
        }

    }
}

data class Credentials(var login: String = "", var password: String="", var remember: Boolean = false) {
    fun isNotEmpty(): Boolean {
        return login.isNotEmpty() && password.isNotEmpty()
    }
}

fun checkCredentials(creds: Credentials, context: Context){
    if (creds.isNotEmpty() && creds.login == "admin" && creds.password == "123admin"){
        context.startActivity(Intent(context, ArtGallery::class.java))
        (context as Activity).finish()
    }
    else{
        Toast.makeText(context, "Wrong Credentials", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun LoginForm(){

    val context = LocalContext.current
    var credentials by remember { mutableStateOf(Credentials())}

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 30.dp)
    ){
        UserField(
            value = credentials.login,
            onChange = {data -> credentials = credentials.copy(login = data) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        PasswordField(
            value = credentials.password,
            onChange = {data -> credentials = credentials.copy(password = data)},
            submit = { checkCredentials(credentials, context) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        RememberMe(
            label = "Remember Me",
            onCheckChanged = { credentials = credentials.copy(remember = !credentials.remember) },
            checked = credentials.remember
        )

        Button(
            onClick = {checkCredentials(credentials, context)},
            enabled = credentials.isNotEmpty(),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }
}

@Composable
fun RememberMe(
    label: String,
    onCheckChanged:() -> Unit,
    checked: Boolean
){
    Row (
        modifier = Modifier
            .clickable(onClick = onCheckChanged)
            .padding(4.dp))
    {
        Checkbox(checked = checked, onCheckedChange = null)
        Spacer(modifier = Modifier.size(6.dp))
        Text(label)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserField(
    value : String,
    onChange : (String)->Unit,
    modifier: Modifier = Modifier,
    label: String = "User",
    placeholder: String = "Enter your User"
){
    val focusManager = LocalFocusManager.current

    val leadingIcon = @Composable{
        Icon(
            Icons.Default.Person,
            contentDescription = "User icon"
        )
    }

    TextField(
        value = value,
        onValueChange = {newValue-> if (newValue.length <= 10) onChange(newValue)},
        modifier = modifier,
        leadingIcon = leadingIcon,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = {focusManager.moveFocus(FocusDirection.Down)}
        ),
        placeholder = {Text(placeholder)},
        label = { Text(label)},
        singleLine = true,
        visualTransformation = VisualTransformation.None
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(
    value : String,
    onChange : (String)->Unit,
    modifier: Modifier = Modifier,
    label : String = "Password",
    submit : ()->Unit,
    placeholder: String = "Enter your Password"
){
    var passwordVisible by remember { mutableStateOf(false) }

    val leadingIcon = @Composable{
        Icon(
            Icons.Default.Key,
            contentDescription = "Password icon"
        )
    }

    val trailingIcon = @Composable{
        IconButton(onClick = { passwordVisible = !passwordVisible}) {
            Icon(
                if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                contentDescription = "Password Visibility icon"
            )
        }
    }

    TextField(
        value = value,
        onValueChange = {newValue-> if (newValue.length <= 8) onChange(newValue)},
        modifier = modifier,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Password),
        keyboardActions = KeyboardActions(
            onDone = {submit()}
        ),
        placeholder = {Text(placeholder)},
        label = { Text(label)},
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}