package com.example.myapplication.features_note.domain.util

sealed class OrderType {
        object Ascending: OrderType()
        object Descending: OrderType()
}