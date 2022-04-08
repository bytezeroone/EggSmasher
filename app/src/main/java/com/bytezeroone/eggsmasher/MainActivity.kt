package com.bytezeroone.eggsmasher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bytezeroone.eggsmasher.ui.theme.EggSmasherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EggSmasherTheme {
                val counter = rememberSaveable {
                    mutableStateOf(0)
                }
                var text = "Break that egg by smashing it!"
                val text2 = "You've done it!\nSmash again to ready another one!"
                var painter = painterResource(id = R.drawable.egg)
                val brokenEgg = painterResource(id = R.drawable.broken_egg)

                when (counter.value) {
                    10 -> {
                        painter = brokenEgg
                        text = text2
                    }
                    11 -> {
                        counter.value = 0
                    }
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = text,
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp,
                            modifier = Modifier
                                .align(TopCenter)
                                .padding(8.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = CenterHorizontally,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Text(
                                text = "${counter.value}",
                                modifier = Modifier
                                    .padding(8.dp)
                            )
                            Image(
                                painter = painter,
                                modifier = Modifier
                                    .size(96.dp)
                                    .clickable {
                                        counter.value++
                                    },
                                contentDescription = "egg",
                            )
                        }
                    }
                }
            }
        }
    }
}