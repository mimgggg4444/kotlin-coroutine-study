###

---

Firestore 사용 backend 같이

DB (데이터가 저장되는 공간)

-backend
App client<-api->server<->db

-인피니티 스크롤


Server + db = firebase

---



container <- controller -> screen


props - screen이 넘어갈때 넘겨주는 데이터 모두

``` tsx
export default({user, onSingout, onEditImage}:Props)

```

최대한 앱 안에서 모든 기능 구현

### 권한설정

``` tsx
onPress:()=>Linking.openSettings()

  // pick an image from the phone library.
  async function pickImageFromLibrary() {
    const result = await ImagePicker.launchImageLibraryAsync({
      aspect: [4, 3],
      allowsEditing: true,
      quality: 1,
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
    });

Alert.alert
```




로직
이미지를 고른 후 서버에 업데이트
  이미지 정상적으로 선택된 경우
  이미지가 선택되지 않은 경우


List, Array, Queue, Stack

0,1,2,3
[a,b,c,d]


uri uniform resource idenfier > url uniform resource locator

if(!result.canceled) if (result.assets && result.assets.length)


userId -> Storage, Profile -> userid.png

1. firebase에 저장할 위치 설정
  1. 유저 아이디
     1. const userId = auth.currentUser?.uid
  3. 저장 경로


firebase에 업로드

1. 내 이미지를 Blob(BinaryLargeData변환)

2. 변환된 데이터를 파이어베이스에 업로드

스크린에서 나의 프로필 바뀐 이미지로 새로고침

---
---

``` tsx
    const storageRef = ref(
      storage,
      `images/${userRef}/${new Date().getTime()}`
    );
```

``` tsx
    const storageRef = ref(
      storage,
      `images/${userRef}/${new Date().getTime()}`
    );

```

/**
*
*assets => blob 데이터로 변환
*
*/

---
---


cons blob = await assetToBlob(uri);
uploadBytes(firebasePath, blob)

const uploadTask = await uploadBytes(firebasePath, blob);


firebase에 업로드된 이미지의 uri 가져오기


export type MyUser = {name:string; email: string; creationTime:string;photoURL:string;}
const[user,setUser]=useState<MyUser>();

1. 스크린에서 나의 프로필 바뀐 이미지로 새로고침
  1. 서버에서의 나의 프로필 이미지 업데이트
     1.  await updateProfile(auth.currentUser,{photoURL:photoUrl})
     2.  
  3. 로컬화면에서 나의 프로필 이미지 갱신

setUser({name:auth.currentUser.displayName, email:auth.currentUser.email, cretionTime:auth.currentUser.metadata.creationTime,photoURL,});


firebase , profile info




