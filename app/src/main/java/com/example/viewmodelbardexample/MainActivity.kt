package com.example.viewmodelbardexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.viewmodelbardexample.ui.theme.ViewModelBardExampleTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelBardExampleTheme {
                ViewModelApp()
            }
        }

    }
}

@Composable
fun ViewModelApp() {
    Counter(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
       )

}

class CounterViewModel : ViewModel() {

    val count = mutableStateOf(0)

    fun increment() {
        count.value++
    }

    fun decrement() {
        count.value--
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {

    val viewModel = remember { CounterViewModel() }

    val count by viewModel.count

    Column (
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = "Count: $count")
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { viewModel.increment() }) {
            Text("Increment")
        }
        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { viewModel.decrement() }) {
            Text("Decrement")
        }
    }
}