package com.example.ayazkhan_androidapp_assignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ayazkhan_androidapp_assignment.data.Bank
import com.example.ayazkhan_androidapp_assignment.ui.theme.blue
import com.example.ayazkhan_androidapp_assignment.ui.theme.blueLight
import com.example.ayazkhan_androidapp_assignment.ui.theme.red
import com.example.ayazkhan_androidapp_assignment.ui.theme.redlight


val banks: List<Bank> = listOf(

    Bank(
        Bank = "PNB",
        ACNumber = "123456890",
        Type = "Saving",
        Balance = 500,
        color =getShade(red, redlight)
        ),
    Bank(
        Bank = "SBI",
        ACNumber = "0987654321",
        Type = "Current",
        Balance = 1000,
        color =getShade(blue, blueLight)
    )

)

fun getShade(startColor: Color,
             endColor: Color): Brush{
    return Brush.horizontalGradient(colors = listOf(startColor,endColor))
}
@Preview
@Composable
fun BankSection() {
    LazyRow {
        items(banks.size) { index ->
            BankItem(index)
        }
    }
}

@Composable
fun BankItem(index: Int){
    val bank = banks[index]
    var lastItemPaddinngEnd = 0.dp
    if(index == banks.size -1){
        lastItemPaddinngEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.pnb)
    if(bank.Bank == "SBI"){
        image = painterResource(id = R.drawable.sbi)
    }

    Box(modifier = Modifier.padding(start = 16.dp,end = lastItemPaddinngEnd)){
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(bank.color)
            .width(200.dp)
            .height(150.dp)
            .clickable {
            }
            .padding(vertical = 10.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween) {
            Image(painter = image, contentDescription = bank.Bank,
                modifier = Modifier.width(50.dp))
            Text(text = bank.Bank,
                color = White)
            Text(text = bank.ACNumber,
                color = White)
            Text(text = bank.Type,
                color = White)
            Text(text = " ${bank.Balance}",
                color = White)
        }
    }

}