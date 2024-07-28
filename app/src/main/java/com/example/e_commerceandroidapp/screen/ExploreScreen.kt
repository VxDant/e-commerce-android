package com.example.e_commerceandroidapp.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Color




@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar()
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            item { BannerCarousel() }
            item { CategoryGrid() }
            item { AdvertisementBanner() }
            item { BrandsOfTheDay() }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var searchQuery by remember { mutableStateOf("") }
    TextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        placeholder = {
            Text("Search for products")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp)),
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search,
            keyboardType = KeyboardType.Text
        ),
        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = Color.Black,
            disabledTextColor = Color.Gray,

            cursorColor = Color.Black,
            errorCursorColor = Color.Red,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Gray,
            errorIndicatorColor = Color.Red,
            focusedPlaceholderColor = Color.Gray,
            disabledPlaceholderColor = Color.Gray,
            errorPlaceholderColor = Color.Red
        )

    )
}


@Composable
fun BannerCarousel() {
    val bannerItems = listOf(
        "https://via.placeholder.com/600x200.png?text=Banner+1",
        "https://via.placeholder.com/600x200.png?text=Banner+2",
        "https://via.placeholder.com/600x200.png?text=Banner+3"
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(bannerItems) { item ->
            Image(
                painter = rememberImagePainter(data = item),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillParentMaxWidth()
                    .aspectRatio(16 / 9f)
                    .background(Color.LightGray)
            )
        }
    }
}

@Composable
fun CategoryGrid() {
    val categories = listOf(
        "Sale and Live", "Mobiles", "Electronics",
        "Fashion", "TV and Appliances", "Home and Furniture"
    )
    val chunkedCategories = categories.chunked(5)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        chunkedCategories.forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                rowItems.forEach { category ->
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(category, fontSize = 12.sp, color = Color.Black)
                    }
                }
            }
        }
    }
}

@Composable
fun AdvertisementBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.LightGray, shape = RectangleShape)
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text("Sponsor: Noise", fontSize = 16.sp, color = Color.Black)
    }
}

@Composable
fun BrandsOfTheDay() {
    val brands = listOf(
        "Samsung", "Sony", "JBL"
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(brands) { brand ->
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(brand, fontSize = 14.sp, color = Color.Black)
            }
        }
    }}