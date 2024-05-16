###

container <- controller -> screen


props - screen이 넘어갈때 넘겨주는 데이터 모두

``` type script
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













