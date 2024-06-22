package com.example.apis_in_android

import android.os.Parcel
import android.os.Parcelable


data class Product  (
    val availabilityStatus: String,
    val brand: String,
    val category: String,
    val description: String,
    val dimensions: Dimensions,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val meta: Meta,
    val minimumOrderQuantity: Int,
    val price: Double,
    val rating: Double,
    val returnPolicy: String,
    val reviews: List<Review>,
    val shippingInformation: String,
    val sku: String,
    val stock: Int,
    val tags: List<String>,
    val thumbnail: String,
    val title: String,
    val warrantyInformation: String,
    val weight: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readParcelable(Dimensions::class.java.classLoader) !!,
        parcel.readDouble(),
        parcel.readInt(),
        parcel.createStringArrayList() ?: emptyList(),
        parcel.readParcelable(Meta::class.java.classLoader) !!,
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString() ?: "",
        parcel.createTypedArrayList(Review) ?: emptyList(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.createStringArrayList() ?: emptyList(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )
    {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(availabilityStatus)
        parcel.writeString(brand)
        parcel.writeString(category)
        parcel.writeString(description)
        parcel.writeParcelable(dimensions, flags)
        parcel.writeDouble(discountPercentage)
        parcel.writeInt(id)
        parcel.writeStringList(images)
        parcel.writeParcelable(meta, flags)
        parcel.writeInt(minimumOrderQuantity)
        parcel.writeDouble(price)
        parcel.writeDouble(rating)
        parcel.writeString(returnPolicy)
        parcel.writeTypedList(reviews)
        parcel.writeString(shippingInformation)
        parcel.writeString(sku)
        parcel.writeInt(stock)
        parcel.writeStringList(tags)
        parcel.writeString(thumbnail)
        parcel.writeString(title)
        parcel.writeString(warrantyInformation)
        parcel.writeInt(weight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}