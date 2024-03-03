package com.example.ayazkhan_androidapp_assignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun ClickPNBBankAccount(navController: NavHostController ) {

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            Image(painter = painterResource(id = R.drawable.pnb), contentDescription = null)
            Spacer(modifier = Modifier.height(15.dp))
           Button(onClick ={ navController.navigate("second_screen") }) {
               HomeScreen()
               
           }
        }
}