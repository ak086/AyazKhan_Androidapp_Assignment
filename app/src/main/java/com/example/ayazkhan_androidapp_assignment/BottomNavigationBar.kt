package com.example.ayazkhan_androidapp_assignment

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ayazkhan_androidapp_assignment.data.BottomNavigation

    val items = listOf(
        BottomNavigation(title = "Account",
            icon = Icons.Rounded.AccountCircle)
    ,

        BottomNavigation(title = "Setting",
          icon = Icons.Rounded.Settings)
           ,
        BottomNavigation(title = "Notification",
           icon = Icons.Rounded.Notifications),

         BottomNavigation(title = "Logout",
             icon = Icons.Rounded.ExitToApp)
    )
@Preview
    @Composable
    fun BottomNavigationBar(){
        NavigationBar {
            Row (modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseOnSurface)){
                items.forEach{item ->
                    NavigationBarItem(selected = true,
                        onClick = { /*TODO*/ },
                        icon = { androidx.compose.material3.Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        ) },
                        label = {
                            Text(text = item.title,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    )

                }
            }
        }
    }
