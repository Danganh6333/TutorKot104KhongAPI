package com.dangchph33497.fpoly.tutorkot104khongapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

class Home : ComponentActivity() {

    data class Flower(val id: Int, val name: String, val price: String, val url: String)

    //Tạo danh sách dữ liệu
    val flowerList = listOf(
        Flower(1, "Hoa Hồng 1", "20.000VND", "https://picsum.photos/200"),
        Flower(2, "Hoa Hồng 2", "28.000VND", "https://picsum.photos/200"),
        Flower(3, "Hoa Hồng 3", "30.000VND", "https://picsum.photos/200"),
        Flower(4, "Hoa Hồng 4", "90.000VND", "https://picsum.photos/200"),
        Flower(5, "Hoa Hồng 7", "120.000VND", "https://picsum.photos/200"),
        Flower(9, "Hoa Hồng 15", "10.000VND", "https://picsum.photos/200"),
        Flower(6, "Hoa Hồng 8", "30.000VND", "https://picsum.photos/200"),
        Flower(7, "Hoa Hồng 9", "80.000VND", "https://picsum.photos/200"),
        Flower(8, "Hoa Hồng 10", "120.000VND", "https://picsum.photos/200")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var selectedFlower by remember {
                mutableStateOf<Flower?>(null)
            }
            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                items(flowerList.size) { index ->
                    val flower = flowerList.get(index)
                    Column {
                        AsyncImage(
                            model = flower.url,
                            contentDescription = "",
                            modifier = Modifier.size(90.dp, 90.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(text = "${flower.id}")
                        Text(text = "${flower.name}")
                        Text(text = "${flower.price}")
                        Button(onClick = {
                            selectedFlower = flower
                            //1.Mở Dialog
                            //2.Mở Màn Hình Mới
                            //3.Hiển thị thông tin bằng Toast
                        }) {
                            Text(text = "Chi Tiết")
                        }
                    }
                }
            }
            selectedFlower?.let {
                //Khai báo dialog
                AlertDialog(
                    onDismissRequest = {
                        selectedFlower = null
                    }, confirmButton = {

                    },
                    text = {
                        AsyncImage(
                            model = it.url,
                            contentDescription = "",
                            modifier = Modifier.size(90.dp, 150.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "${it.name}"
                        )
                    }
                )
            }
        }
    }
}
