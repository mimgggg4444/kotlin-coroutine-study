@Service
class UserService(private val userRepository: UserRepository) {

    fun getAll(): List<UserResponseDto> = userRepository.findAll().map { user ->
        UserResponseDto(
            id = user.id,
            name = user.name,
            email = user.email
        )
    }

    fun getById(id: Long): UserResponseDto =
        userRepository.findByIdOrNull(id)?.let { user ->
            UserResponseDto(
                id = user.id,
                name = user.name,
                email = user.email
            )
        } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun create(userRequestDto: UserRequestDto): UserResponseDto {
        val newUser = User(
            name = userRequestDto.name,
            email = userRequestDto.email
        )
        return userRepository.save(newUser).let { savedUser ->
            UserResponseDto(
                id = savedUser.id,
                name = savedUser.name,
                email = savedUser.email
            )
        }
    }

    fun remove(id: Long) {
        if (userRepository.existsById(id)) userRepository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun update(id: Long, userRequestDto: UserRequestDto): UserResponseDto {
        return if (userRepository.existsById(id)) {
            val updatedUser = User(
                id = id,
                name = userRequestDto.name,
                email = userRequestDto.email
            )
            userRepository.save(updatedUser).let { savedUser ->
                UserResponseDto(
                    id = savedUser.id,
                    name = savedUser.name,
                    email = savedUser.email
                )
            }
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}
