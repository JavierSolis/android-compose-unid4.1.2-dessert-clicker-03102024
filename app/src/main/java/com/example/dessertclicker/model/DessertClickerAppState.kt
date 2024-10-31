package com.example.dessertclicker.model

/**
 * Created by Javier J. Solis Flores on 15/10/24.
 * @email solis.unmsm@gmail.com
 * @github https://github.com/JavierSolis
 */

/**
var revenue by rememberSaveable { mutableStateOf(0) }
var dessertsSold by rememberSaveable { mutableStateOf(0) }

val currentDessertIndex by rememberSaveable { mutableStateOf(0) }

var currentDessertPrice by rememberSaveable {
mutableStateOf(desserts[currentDessertIndex].price)
}
var currentDessertImageId by rememberSaveable {
mutableStateOf(desserts[currentDessertIndex].imageId)
}
 */
data class DessertClickerAppState(
    val revenue:Int = 0,
    val dessertsSold:Int = 0,
    val currentDessertIndex:Int = 0,

    val currentDessert : Dessert = Dessert(0,0,0)
    //val currentDessertPrice:Int = 0,
    //val currentDessertImageId:Int = 0
)