package com.example.hellojetpackcompose
import android.os.Parcel
import android.os.Parcelable

data class Contact(val id: Int = 1, val name: String = "Name", val phoneNumber: String = "Phone Number"): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(phoneNumber)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contact> {

        val contacts = (1..100).map {
            Contact(it, "Name $it", "Phone Number $it")
        }

        override fun createFromParcel(parcel: Parcel): Contact {
            return Contact(parcel)
        }

        override fun newArray(size: Int): Array<Contact?> {
            return arrayOfNulls(size)
        }
    }
}