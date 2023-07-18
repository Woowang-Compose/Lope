/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    GreetingImage(message = "안녕", from = "하세요")
                }
            }
        }
    }
}

// 7. 텍스트 정렬 및 패딩 추가
@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    // Create a column so that texts don't overlap
    Column {
        Text(text = message, fontSize = 20.sp)
        Text(text = from)
    }
}

// 5. Box 레이아웃 추
@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
}

@Composable
fun GreetingImage(message: String, from: String) {
    val image = painterResource(id = R.drawable.ic_puppy)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )
        GreetingText(message, from, modifier = Modifier.fillMaxSize().padding(8.dp))
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp),
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.background(color = Color.Green)
                .padding(all = 16.dp)
                .align(alignment = Alignment.End),
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp), textAlign = TextAlign.Justify
        )
    }
}

// 4. 이미지 컴포저블 추가
@Preview(showBackground = false, showSystemUi = true)
@Composable
private fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(message = "안녕", from = "하세요")
    }
}
