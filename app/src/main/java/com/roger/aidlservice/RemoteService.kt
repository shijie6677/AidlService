package com.roger.aidlservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.roger.aidlservice.data.Person

class RemoteService : Service() {
    //注意引用命名
    private val arrayList = mutableListOf<Person>()

    override fun onBind(intent: Intent?): IBinder? = iBinder

    private val iBinder = object : MyAidl.Stub() {
        override fun addPerson(person: Person) {
            arrayList.add(person)
        }

        //注意引用命名
        override fun getPersonList(): MutableList<Person> = arrayList
    }


}