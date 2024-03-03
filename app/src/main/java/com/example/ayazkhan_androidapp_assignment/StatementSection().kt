package com.example.ayazkhan_androidapp_assignment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ayazkhan_androidapp_assignment.data.Statement
import com.example.ayazkhan_androidapp_assignment.ui.theme.Purple40
import com.example.ayazkhan_androidapp_assignment.ui.theme.Purple80

val Statements: List<Statement> = listOf(
    Statement(icon = Icons.Rounded.CheckCircle,
        name ="Card\nTransation",
        background = Purple40),
    Statement(icon = Icons.Rounded.CheckCircle,
        name ="Bank\nTransation",
        background = Purple80)
)
@Preview
@Composable
fun StatementSection(){
    Column {
        Text(
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
            text = "Statements",
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            )
    }
    LazyRow{
        items(Statements.size){
            index ->
            StatementItem(index)
        }
    }
    
}

@Composable
fun StatementItem(index: Int){
    val statement = Statements[index]
    var lastPaddingEnd = 0.dp
    if(index == Statements.size - 1){
        lastPaddingEnd = 16.dp
    }
    Box(modifier = Modifier.padding(start = 10.dp)){
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .size(100.dp)
            .clickable { }
            .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .padding(5.dp)){
                Icon(imageVector = statement.icon, contentDescription = statement.name)

            }
            Text(text = statement.name,
                fontWeight = FontWeight.SemiBold)
        }
    }

}