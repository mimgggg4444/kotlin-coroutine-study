###

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

firebase에 저장할 위치 설정

firebase에 업로드

1. 내 이미지를 Blob(BinaryLargeData변환)

2. 변환된 데이터를 파이어베이스에 업로드

스크린에서 나의 프로필 바뀐 이미지로 새로고침



