package com.example.jetpackcomposecatalog.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalog.ui.CheckInfo


/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val options = getOptions(titles = listOf("Pikachu", "Charizar", "Pico"))

                    Column(modifier = Modifier.fillMaxSize()) {
                        options.forEach{
                            MyCheckBoxTextWithCheckInfo(checkInfo = it)
                        }
                    }
                }
            }
        }
    }
}

 */

@Preview(showBackground = true)
@Composable
fun MyTriStatusCheckBox(){
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(state = status, onClick = {
        status = when(status){
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun MyCheckBoxTextWithCheckInfo(checkInfo: CheckInfo) {
    Row(
        modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(title = it, selected = status, onCheckedChange = { value -> status = value })
    }
}

@Composable
fun MyCheckBoxText() {

    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Check this")
    }
}

@Composable
fun MyCheckBox() {

    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Checkbox(
        checked = state, onCheckedChange = { state = !state }, colors = CheckboxDefaults.colors(
            checkedColor = Color.Red, uncheckedColor = Color.Cyan, checkmarkColor = Color.Blue
        )
    )
}

@Composable
fun MySwitch() {

    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Switch(
        checked = state, onCheckedChange = { state = !state }, colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Cyan,
            uncheckedThumbColor = Color.Red,

            checkedTrackColor = Color.Magenta,
            uncheckedTrackColor = Color.Blue,
        )
    )
}



