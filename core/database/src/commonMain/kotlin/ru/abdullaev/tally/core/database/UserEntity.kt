package ru.abdullaev.tally.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.abdullaev.tally.core.domain.model.User

private const val USER_ID = 1L

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: Long = USER_ID,
    val weight: Double,
    val height: Double,
)

fun UserEntity.toDomain() = User(weight = weight, height = height)

fun User.toEntity() = UserEntity(weight = weight, height = height)
