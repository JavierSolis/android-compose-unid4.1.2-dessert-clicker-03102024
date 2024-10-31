package com.example.dessertclicker.model

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by Javier J. Solis Flores on 15/10/24.
 * @email solis.unmsm@gmail.com
 * @github https://github.com/JavierSolis
 */
class DataDessertViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(DessertClickerAppState())
    val uiState : StateFlow<DessertClickerAppState> = _uiState.asStateFlow()


    init{
        initState()
    }

    private fun initState(){
        _uiState.value = DessertClickerAppState()
        _uiState.update { currentState->
            currentState.copy(
                currentDessert = Datasource.dessertList[0]
            )
        }
    }

    fun onDessertPriceUpdate() {
        /**
        // Update the revenue
        revenue += currentDessertPrice
        dessertsSold++

        // Show the next dessert
        val dessertToShow = determineDessertToShow(desserts, dessertsSold)
        currentDessertImageId = dessertToShow.imageId
        currentDessertPrice = dessertToShow.price
        */
        val revenue = _uiState.value.revenue + _uiState.value.currentDessert.price
        val dessertSold = _uiState.value.dessertsSold+1

        val currentDessert = determineDessertToShow(Datasource.dessertList,dessertSold)

        _uiState.update { currentState->
            currentState.copy(
                revenue = revenue,
                dessertsSold = dessertSold,
                currentDessert = currentDessert
            )
        }
    }

    fun determineDessertToShow(
        desserts: List<Dessert>,
        dessertsSold: Int
    ): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }

        return dessertToShow
    }
}