!
```
val intent = Intent(this, DetailActivity::class.java)
intent._____("KEY_MESSAGE", "Hello, DetailActivity!")
startActivity(intent)
//putExtra
```

```
val message = intent._____("KEY_MESSAGE") ?: ""
//getStringExtra
```

---
---

```
val intent = Intent(this, SecondActivity::class.java)
___(intent)
정답: startActivity
```


```
private lateinit var binding: ActivityMainBinding

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.___(layoutInflater)
    setContentView(binding.root)
}
정답: inflate


```

```
class MyFragment : ___() {
    ...
}
정답: Fragment


```

```
override fun ___(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    // View 초기화 작업
}
정답: onViewCreated


```

```
supportFragmentManager.beginTransaction()
    .___(R.id.container, MyFragment())
    .commit()
정답: replace


```

```
val builder = _____
    .Builder(context, CHANNEL_ID)
    .setSmallIcon(R.drawable.notification_icon)
    .setContentTitle("My Notification")
    .setContentText("Hello, World!")
    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
정답: NotificationCompat
```


```
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    val name = getString(R.string.channel_name)
    val descriptionText = getString(R.string.channel_description)
    val importance = NotificationManager.IMPORTANCE_DEFAULT
    val channel = _____(CHANNEL_ID, name, importance).apply {
        description = descriptionText
    }
    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(channel)
}
정답: NotificationChannel
```


```
with(NotificationManagerCompat.from(context)) {
    _____(NOTIFICATION_ID, builder.build())
}
정답: notify
```

```
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    view.findViewById<Button>(R.id.button)._____({
        // 버튼 클릭 이벤트 처리
    })
}
정답: setOnClickListener
```

```
val builder = NotificationCompat.Builder(context, CHANNEL_ID)
    .setSmallIcon(R.drawable.notification_icon)
    .setContentTitle("My Notification")
    .setContentText("Hello, World!")
    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
with(NotificationManagerCompat.from(context)) {
    _____(NOTIFICATION_ID, builder.build())
}
```

```
val intent = Intent(this, SecondActivity::class.java).apply {
    _____(KEY_MESSAGE, "Hello from FirstActivity")
}
startActivity(intent)
```

```
private lateinit var adapter: MyAdapter

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
    adapter = MyAdapter(data)
    recyclerView._____(adapter)
}
정답: adapter
```

```
private lateinit var viewModel: MyViewModel

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
    viewModel.data.observe(viewLifecycleOwner, {
        // 데이터 업데이트
        adapter._____(it)
    })
}
정답: submitList
```

```
private fun createNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES._____) {
        val name = getString(R.string.channel_name)
        val descriptionText = getString(R.string.channel_description)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}
정답: O
```

### sharedpreferences
```
val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
val editor = sharedPreferences.edit()
editor.putString("userName", "John")
editor._____()

val userName = sharedPreferences._____("userName", "")
정답: apply, getString

```

```
FragmentManager를 사용하여 Fragment를 전환하는 코드를 작성하세요.
정답:

kotlin supportFragmentManager.beginTransaction()
    .replace(R.id.container, MyFragment())
    .addToBackStack(null)
    .commit()
```

```
Fragment에서 ViewModel을 사용하여 데이터를 공유하는 방법을 설명하고, 코드로 구현하세요.
정답:

kotlin class MyViewModel : ViewModel() {
    val data = MutableLiveData<String>()
}

class MyFragment : Fragment() {
    private lateinit var viewModel: MyViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        viewModel.data.observe(viewLifecycleOwner, {
            // 데이터 업데이트
        })
    }
}
```

```
Notification 채널을 생성하고, 알림을 표시하는 코드를 작성하세요.
정답:

kotlin private fun createNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = getString(R.string.channel_name)
        val descriptionText = getString(R.string.channel_description)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}

private fun showNotification() {
    val builder = NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.notification_icon)
        .setContentTitle("My Notification")
        .setContentText("Hello, World!")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    with(NotificationManagerCompat.from(this)) {
        notify(NOTIFICATION_ID, builder.build())
    }
}
```

```
Intent를 사용하여 Activity 간에 데이터를 전달하는 코드를 작성하세요.
정답:

kotlin // FirstActivity
val intent = Intent(this, SecondActivity::class.java)
intent.putExtra("message", "Hello from FirstActivity")
startActivity(intent)

// SecondActivity
val message = intent.getStringExtra("message")
```

```
View Binding을 사용하여 RecyclerView에 데이터를 표시하는 코드를 작성하세요.
정답:

kotlin private lateinit var binding: ActivityMainBinding
private lateinit var adapter: MyAdapter

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    adapter = MyAdapter(data)
    binding.recyclerView.adapter = adapter
}
```


---
---

### Fragment 
```
class MyFragment : Fragment() {
    override fun _____(_____: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_my, container, false)
    }
}
정답: onCreateView, inflater


```

```
class MyFragment : Fragment() {
    companion object {
        fun newInstance(message: String): MyFragment {
            val fragment = MyFragment()
            val args = Bundle()
            args.putString(_____, message)
            fragment._____ = args
            return fragment
        }
    }
}
정답: "KEY_MESSAGE", arguments


```

```
class MyFragment : Fragment() {
    override fun onAttach(context: Context) {
        super._____(_____) 
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }
}
정답: onAttach, context


```

```
class MyFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            (_____ as? OnButtonClickListener)?.onButtonClick()
        }
    }
}
정답: activity


```

```
class MyFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMyBinding._____
        return binding._____
    }
}
정답: inflate(inflater, container, false), root


```

```
class MyFragment : Fragment() {
    private lateinit var viewModel: MyViewModel
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(_____::class.java)
    }
}
정답: MyViewModel


```

```
class MyFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(_____, _____, _____)
        // ...
        return view
    }
}
정답: inflater, container, savedInstanceState


```

```
        recyclerView.layoutManager = LinearLayoutManager(_____)
정답: context 또는 requireContext()



```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```


### intent

- intent.data = Uri._____("https://www.example.com")
- parse

-    _____ = "Hello, this is a shared text!"
- putExtra(Intent.EXTRA_TEXT, "Hello, this is a shared text!")

```
if (emailIntent.resolveActivity(packageManager) != null) {
    _____
}
startActivity(emailIntent)
```

```
val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
    data = Uri.fromParts("package", packageName, null)
}
_____
startActivity(intent)
```

```
val intent = Intent(this, MyIntentService::class.java)
intent.putExtra("KEY_DATA", "Extra data")
_____
startService(intent)
```




### View Binding

- buildFeatures { viewBinding true }

- binding = ActivityMainBinding._____
- inflate(layoutInflater)


- binding.recyclerView._____ = adapter
- adapter

- class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding._____)
- root

### Data Binding

- binding._____ = User("John", 30)
- user


### Notification 

```
val builder = NotificationCompat.Builder(context, CHANNEL_ID)
    .setSmallIcon(R.drawable.ic_notification)
    .setContentTitle("My Notification")
    .setContentText("This is a notification.")
    ._____
setPriority(NotificationCompat.PRIORITY_DEFAULT)
```

```
val notificationManager = NotificationManagerCompat.from(context)
notificationManager.notify(_____, builder.build())
NOTIFICATION_ID
```

```
val name = context.getString(R.string.channel_name)
   val descriptionText = context.getString(R.string.channel_description)
   val importance = NotificationManager.IMPORTANCE_DEFAULT
   val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
       description = descriptionText
   }
   val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
   notificationManager._____
createNotificationChannel(channel)
}
```

### 기본문법
```
___ name = "John"
___ age = 25
정답: val, var
```

```
val score = 85
___ (score >= 90) {
    println("A")
} ___ (score >= 80) {
    println("B")
} ___ {
    println("C")
}
정답: if, else if, else
```

```
___ (i in 1..5) {
    println(i)
}
정답: for


```

```
___ square(x: Int): Int {
    return x * x
}
정답: fun


```

```
___ Person(val name: String, val age: Int)
정답: data class


```

```
val numbers = listOf(1, 2, 3, 4, 5)
val evenNumbers = numbers._____ { it % 2 == 0 }
정답: filter


```

```
val map = mapOf("a" to 1, "b" to 2, "c" to 3)
val value = map._____("b")
정답: get 또는 []


```

```
val text: String? = null
val length = text___?.length ?: 0

```

```
val square: (Int) -> Int = { x -> _____ }
정답: x * x


```

```
fun String._____(): String {
    return this.toUpperCase()
}
정답: toUpperCase


```

```
val length = text?.let {
    _____._____
} ?: 0
정답: it, length


```

```
val result = with(numbers) {
    _____ + _____
}
정답: first(), last()


```

```
val person = Person("Alice", 20)._____ {
    _____ = "Alice Smith"
}
정답: apply, name


```

```
data class User(val name: String, val age: Int)
val user = User("John", 25)
val (_____, _____) = user
정답: name, age


```

```
data class Book(val id: Int, val title: String)
val books = listOf(
    Book(1, "Book 1"),
    Book(2, "Book 2"),
    Book(3, "Book 3")
)
val booksById = books._____(_____::_____)
정답: associateBy, Book, id


```

```
val numbers = listOf(1, 2, 3, 4, 5, 6)
val evenOdd = numbers._____{ _____ % 2 == 0 }
정답: groupBy, it


```

```
val numbers = sequenceOf(1, 2, 3, 4, 5)
val result = numbers
    .map { it * 2 }
    .filter { it > 5 }
    ._____
정답: toList()


```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```

```
```


```
```
