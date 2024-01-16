package com.example.peoplecounter.domain.roomusecases

import com.example.peoplecounter.data.source.local.model.roomrepo.RoomRepo
import com.example.peoplecounter.data.source.local.model.roomrepo.RoomRepoImpl

object RoomRepoInstance {
    val roomRepoInstance: RoomRepo by lazy { RoomRepoImpl() }
}