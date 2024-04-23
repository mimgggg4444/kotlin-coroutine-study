// UserRequestDto.kt
data class UserRequestDto(
    val name: String,
    val email: String
)

// UserResponseDto.kt
data class UserResponseDto(
    val id: Long,
    val name: String,
    val email: String
)
