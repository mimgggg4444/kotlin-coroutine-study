// UserController.kt
@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAllUsers(): List<UserResponseDto> {
        return userService.getAllUsers()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): UserResponseDto {
        return userService.getUserById(id)
    }

    @PostMapping
    fun createUser(@RequestBody userRequestDto: UserRequestDto): UserResponseDto {
        return userService.createUser(userRequestDto)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userRequestDto: UserRequestDto): UserResponseDto {
        return userService.updateUser(id, userRequestDto)
    }

    @PatchMapping("/{id}")
    fun partialUpdateUser(@PathVariable id: Long, @RequestBody userRequestDto: UserRequestDto): UserResponseDto {
        return userService.partialUpdateUser(id, userRequestDto)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        userService.deleteUser(id)
    }
}
