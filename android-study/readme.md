!


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
