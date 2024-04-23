@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<UserResponseDto> {
        // 모든 사용자 조회
        val users = userRepository.findAll()
        return users.map { user ->
            UserResponseDto(
                id = user.id,
                name = user.name,
                email = user.email
            )
        }
    }

    fun getUserById(id: Long): UserResponseDto {
        // 특정 사용자 조회
        val user = userRepository.findById(id) ?: throw UserNotFoundException("User not found with id $id")
        return UserResponseDto(
            id = user.id,
            name = user.name,
            email = user.email
        )
    }

    fun createUser(userRequestDto: UserRequestDto): UserResponseDto {
        // 새로운 사용자 생성
        val newUser = User(
            name = userRequestDto.name,
            email = userRequestDto.email
        )
        val savedUser = userRepository.save(newUser)
        return UserResponseDto(
            id = savedUser.id,
            name = savedUser.name,
            email = savedUser.email
        )
    }

    fun updateUser(id: Long, userRequestDto: UserRequestDto): UserResponseDto {
        // 기존 사용자 전체 업데이트
        val existingUser = userRepository.findById(id) ?: throw UserNotFoundException("User not found with id $id")
        val updatedUser = existingUser.copy(
            name = userRequestDto.name,
            email = userRequestDto.email
        )
        val savedUser = userRepository.save(updatedUser)
        return UserResponseDto(
            id = savedUser.id,
            name = savedUser.name,
            email = savedUser.email
        )
    }

    fun partialUpdateUser(id: Long, userRequestDto: UserRequestDto): UserResponseDto {
        // 기존 사용자 부분 업데이트
        val existingUser = userRepository.findById(id) ?: throw UserNotFoundException("User not found with id $id")
        val updatedUser = existingUser.copy(
            name = userRequestDto.name.takeIf { it.isNotBlank() } ?: existingUser.name,
            email = userRequestDto.email.takeIf { it.isNotBlank() } ?: existingUser.email
        )
        val savedUser = userRepository.save(updatedUser)
        return UserResponseDto(
            id = savedUser.id,
            name = savedUser.name,
            email = savedUser.email
        )
    }

    fun deleteUser(id: Long) {
        // 사용자 삭제
        val existingUser = userRepository.findById(id) ?: throw UserNotFoundException("User not found with id $id")
        userRepository.delete(existingUser)
    }
}
