package com.example.tinerpets

import android.provider.ContactsContract.Contacts.Photo

public class UserData(val phone: String, val email: String, val password: String) {

}
public class CatData(val name: String, val age: Int, val breed: String, val photo: List<Photo>){

}
public class DogData(val name: String, val age: Int, val breed: String, val photo: List<Photo>){

}