package com.example.ui_compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.example.ui_compose.R
import com.example.ui_compose.component.ButtonSend
import com.example.ui_compose.component.ChatAppTopBar
import com.example.ui_compose.component.HintOnlyTextField
import com.example.ui_compose.helper.noRippleClickable
import com.example.ui_compose.model.LanguageOptionModel

class ChatScreen() : Screen{

    @Composable
    override fun Content() {
        val focusManager = LocalFocusManager.current
        val keyboardController = LocalSoftwareKeyboardController.current

        Scaffold(
            modifier = Modifier.noRippleClickable(
                onClick = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                }
            ),
            containerColor = Color.Transparent,
            topBar = {
                ChatAppTopBar()
            },
            bottomBar = {
                BottomSection(
                    modifier = Modifier
                        .imePadding(),
                    selectedCountry = {},
                    onSubmit = {}
                )
            },
            content = { innerPadding ->
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .background(color = Color.White)
                ) {
                    items(50){
                        Text(
                            text = "Item ${it.toString()}"
                        )
                    }
                }
            }
        )
    }
}


@Composable
private fun BottomSection(
    modifier: Modifier = Modifier,
    selectedCountry : (String) -> Unit,
    onSubmit : () -> Unit
){
    var commandTxt by remember { mutableStateOf("") }

    Box(
        modifier = modifier.background(color = Color.White)
    ){
        Box(
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .padding(top = 20.dp)
                .dropShadow(shape = RoundedCornerShape(25.dp), shadow = Shadow(
                    radius = 10.dp,
                    spread = 0.5.dp,
                    color = Color.Black.copy(0.2f),
                    offset = DpOffset(x = 0.dp, (-5).dp),
                ))
                .background(color = Color.White, shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .padding(10.dp)
        ){
            Column {
                HintOnlyTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = commandTxt,
                    onValueChange = { newTxt ->
                        commandTxt = newTxt
                    },
                    hint = "Ask me anything"
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    SelectLanguage {  }
                    ButtonSend {  }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectLanguage(
    selectedLang: (String) -> Unit
) {
    val listOption = listOf(
        LanguageOptionModel(1, "English", R.drawable.ic_language_en_in),
        LanguageOptionModel(2, "Khmer", R.drawable.ic_language_kh_in)
    )

    var expanded by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf(listOption.first()) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {

        Box(
            modifier = Modifier
                .menuAnchor()
                .height(50.dp)
                .width(200.dp)
                .border(
                    1.dp,
                    Color.Black.copy(0.1f),
                    RoundedCornerShape(25.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            LanguageMenuItem(selectedLanguage.iconName)
        }

        ExposedDropdownMenu(
            containerColor = Color.White,
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            listOption.forEach { model ->
                DropdownMenuItem(
                    text = {
                        LanguageMenuItem(model.iconName, isDropDown = false)
                    },
                    onClick = {
                        selectedLanguage = model
                        selectedLang(model.title)
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}


@Composable
fun LanguageMenuItem(
    iconName : Int,
    isDropDown : Boolean= true
){
    Row (
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Image(
            modifier = Modifier.size(35.dp),
            painter = painterResource(iconName),
            contentDescription = "Icon Lang"
        )
        Text(
            text = "Language",
            style = MaterialTheme.typography.bodyMedium
        )
        if (isDropDown){
            Image(
                modifier = Modifier.size(20.dp),
                painter = painterResource(R.drawable.arrow_down),
                contentDescription = "Arrow Down"
            )
        } else{
            Box(modifier = Modifier.size(20.dp))
        }
    }
}