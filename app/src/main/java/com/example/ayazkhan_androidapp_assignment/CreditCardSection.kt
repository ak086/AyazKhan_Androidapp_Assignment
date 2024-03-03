package com.example.ayazkhan_androidapp_assignment


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ayazkhan_androidapp_assignment.data.CreditCard
import com.example.ayazkhan_androidapp_assignment.ui.theme.blue
import com.example.ayazkhan_androidapp_assignment.ui.theme.blueLight
import com.example.ayazkhan_androidapp_assignment.ui.theme.red
import com.example.ayazkhan_androidapp_assignment.ui.theme.redlight
import kotlinx.coroutines.launch

val CreditCards: List<CreditCard> = listOf(
    CreditCard(Card ="Rupay",
        CardNumber = "111 2222 333 4444",
        color = getCardShade(red, redlight) )
,
CreditCard(Card ="Master",
CardNumber = "111 2222 333 4444",
color = getCardShade(blue, blueLight) )
)

fun getCardShade(startColor: Color,
             endColor: Color
): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor,endColor))
}

@Preview
@Composable
fun CreditCardSection(){
    Text(modifier = Modifier.padding(start = 10.dp),
        text = "Cards",
        color = MaterialTheme.colorScheme.onBackground,
        fontWeight = FontWeight.Bold,

    )
Spacer(modifier = Modifier.height(20.dp))
    LazyRow{
        items(CreditCards.size){
            index ->
            CreditCardItem(index)
        }
    }
}

@Composable
fun CreditCardItem(index: Int) {
    val creditCard = CreditCards[index]

    var lastItemPaddinngEnd = 0.dp
    if (index == CreditCards.size - 1) {
        lastItemPaddinngEnd = 16.dp
    }
    var cardImage = painterResource(id = R.drawable.rupey)
    if (creditCard.Card == "Master") {
        cardImage = painterResource(id = R.drawable.master)
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddinngEnd)) {
        Column(modifier = androidx.compose.ui.Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(creditCard.color)
            .width(200.dp)
            .height(150.dp)
            .clickable {}
            .padding(vertical = 10.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = cardImage, contentDescription = creditCard.Card,
                modifier = androidx.compose.ui.Modifier.width(50.dp)
            )
            Text(
                text = creditCard.Card,
                color = Color.White
            )
            Text(
                text = creditCard.CardNumber,
                color = Color.White
            )
        }
    }
}