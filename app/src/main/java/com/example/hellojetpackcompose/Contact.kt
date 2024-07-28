package com.example.hellojetpackcompose

data class Contact(val id: Int = 1, val name: String = "Name", val phoneNumber: String = "Phone Number"){
    companion object{
        val contacts = (1..100).map {
            Contact(it, "Name $it", "Phone Number $it")
        }
    }
}