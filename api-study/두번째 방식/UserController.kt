@RestController
@RequestMapping("api/v1/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAllUsers(): List<UserResponseDto> = userService.getAll()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): UserResponseDto = userService.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody userRequestDto: UserRequestDto): UserResponseDto = userService.create(userRequestDto)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Long) = userService.remove(id)

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Long,
        @RequestBody userRequestDto: UserRequestDto
    ): UserResponseDto = userService.update(id, userRequestDto)
}
