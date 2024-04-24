---
---



1. **React Native 기본 구조**
   - `App.tsx`: 애플리케이션의 진입점으로, 앱의 루트 컴포넌트를 렌더링합니다.
   - `NavigationContainer`: 네비게이션 기능을 제공하는 컴포넌트입니다.
   - `createStackNavigator`: 스택 기반의 네비게이션을 생성하는 함수입니다.

2. **Firebase 인증**
   - `auth`: Firebase Authentication 인스턴스입니다.
   - `onAuthStateChanged`: 사용자의 인증 상태 변화를 감지하는 메서드입니다.
   - `signInWithEmailAndPassword`: 이메일과 비밀번호로 로그인하는 메서드입니다.
   - `createUserWithEmailAndPassword`: 이메일과 비밀번호로 신규 계정을 생성하는 메서드입니다.

3. **화면 구성 및 네비게이션**
   - `AuthStack`: 인증 관련 화면(로그인, 회원가입)을 묶은 네비게이션 스택입니다.
   - `MainStack`: 메인 화면들을 묶은 네비게이션 스택입니다.
   - `LoadingScreen`: 로딩 중일 때 표시되는 화면입니다.

4. **Styled Components**
   - `styled`: React Native에서 스타일링을 위해 사용되는 라이브러리입니다.
   - 컴포넌트별로 스타일을 정의하고 재사용할 수 있습니다.

5. **상태 관리**
   - `useState`: 컴포넌트 내부에서 상태를 관리하기 위해 사용되는 React Hook입니다.
   - 이메일, 비밀번호, 오류 메시지 등의 상태를 관리합니다.

6. **이벤트 처리**
   - `onChangeText`: TextInput 컴포넌트에서 텍스트 변경 시 호출되는 이벤트 핸들러입니다.
   - `onSubmit`: 로그인 또는 회원가입 버튼 클릭 시 호출되는 이벤트 핸들러입니다.

7. **화면 이동**
   - `useNavigation`: 네비게이션 객체를 가져오기 위해 사용되는 React Hook입니다.
   - `navigate`: 다른 화면으로 이동하는 메서드입니다.


---

1. **React 기본 요소**
   - `import React, { useEffect, useState } from 'react'`: React 라이브러리와 useEffect, useState 훅을 불러옵니다.
   - `export default function App() {...}`: 기본 내보내기로 App 컴포넌트를 정의합니다.

2. **React Native 기본 요소**
   - `import { StyleSheet, Text, View } from 'react-native'`: React Native의 스타일, 텍스트, 뷰 컴포넌트를 불러옵니다.
   - `<View>`: 레이아웃을 구성하는 컨테이너 역할을 합니다.
   - `<Text>`: 텍스트를 렌더링합니다.
   - `StyleSheet.create({...})`: 스타일 객체를 정의합니다.

3. **네비게이션**
   - `import { NavigationContainer } from '@react-navigation/native'`: 네비게이션 컨테이너를 불러옵니다.
   - `import { createStackNavigator } from '@react-navigation/stack'`: 스택 네비게이션을 생성하는 함수를 불러옵니다.
   - `const Stack = createStackNavigator()`: 스택 네비게이터를 생성합니다.
   - `<NavigationContainer>`: 네비게이션 계층 구조의 루트 컨테이너입니다.

4. **Firebase 인증**
   - `import { auth } from './firebaseConfig'`: Firebase 인증 인스턴스를 불러옵니다.
   - `import * as Firebase from 'firebase/auth'`: Firebase 인증 모듈을 불러옵니다.
   - `auth.onAuthStateChanged((userState) => {...})`: 사용자 인증 상태 변화를 감지하는 메서드입니다.
   - `signInWithEmailAndPassword(auth, email, password)`: 이메일과 비밀번호로 로그인하는 메서드입니다.
   - `createUserWithEmailAndPassword(auth, email, password)`: 이메일과 비밀번호로 신규 계정을 생성하는 메서드입니다.

5. **스택 및 화면**
   - `import AuthStack from './stacks/AuthStack'`: 인증 관련 스택을 불러옵니다.
   - `import MainStack from './stacks/MainStack'`: 메인 화면 스택을 불러옵니다.
   - `import LoadingScreen from './screens/loading-screen'`: 로딩 화면 컴포넌트를 불러옵니다.

6. **Styled Components**
   - `import styled from 'styled-components'`: Styled Components 라이브러리를 불러옵니다.
   - `const Container = styled(View)` ```: 스타일을 적용한 뷰 컴포넌트를 정의합니다.

7. **이벤트 처리**
   - `import { NativeSyntheticEvent, TextInputChangeEventData } from 'react-native'`: 이벤트 관련 타입을 불러옵니다.
   - `import { TextInput } from 'react-native-gesture-handler'`: 텍스트 입력 컴포넌트를 불러옵니다.
   - `onChangeText={(e) => {...}}`: 텍스트 변경 이벤트 핸들러입니다.
   - `onPress={() => {...}}`: 버튼 클릭 이벤트 핸들러입니다.

8. **기타**
   - `import { useNavigation } from '@react-navigation/native'`: 네비게이션 훅을 불러옵니다.
   - `import { Alert } from 'react-native'`: 경고 대화상자를 불러옵니다.
   - `import { FirebaseError } from 'firebase/app'`: Firebase 오류 객체를 불러옵니다.



---

1. `import`: 외부 모듈이나 라이브러리를 불러오는 구문입니다.
2. `React`: React 라이브러리의 핵심 모듈입니다.
3. `useEffect`: React Hook으로, 컴포넌트가 렌더링된 후 특정 작업을 수행하도록 합니다.
4. `useState`: React Hook으로, 함수 컴포넌트에서 상태를 관리할 수 있게 해줍니다.
5. `StyleSheet`: React Native에서 스타일을 정의하는 API입니다.
6. `Text`: React Native에서 텍스트를 렌더링하는 컴포넌트입니다.
7. `View`: React Native에서 레이아웃을 구성하는 컨테이너 역할의 컴포넌트입니다.
8. `NavigationContainer`: React Navigation 라이브러리에서 네비게이션 계층 구조의 루트 컨테이너 역할을 합니다.
9. `createStackNavigator`: React Navigation에서 스택 기반 네비게이션을 생성하는 함수입니다.
10. `auth`: Firebase Authentication 인스턴스입니다.
11. `Firebase`: Firebase 관련 모듈과 함수를 포함하는 네임스페이스입니다.
12. `onAuthStateChanged`: Firebase에서 사용자 인증 상태 변화를 감지하는 메서드입니다.
13. `signInWithEmailAndPassword`: Firebase에서 이메일과 비밀번호로 로그인하는 메서드입니다.
14. `createUserWithEmailAndPassword`: Firebase에서 이메일과 비밀번호로 신규 계정을 생성하는 메서드입니다.
15. `AuthStack`: 인증 관련 화면들을 묶은 네비게이션 스택입니다.
16. `MainStack`: 메인 화면들을 묶은 네비게이션 스택입니다.
17. `LoadingScreen`: 로딩 중일 때 표시되는 화면 컴포넌트입니다.
18. `styled`: Styled Components 라이브러리에서 스타일을 적용하는 함수입니다.
19. `NativeSyntheticEvent`: React Native에서 발생하는 이벤트 객체의 타입입니다.
20. `TextInputChangeEventData`: TextInput 컴포넌트에서 발생하는 텍스트 변경 이벤트 데이터의 타입입니다.
21. `TextInput`: React Native에서 텍스트 입력을 받는 컴포넌트입니다.
22. `useNavigation`: React Navigation에서 네비게이션 객체를 가져오는 Hook입니다.
23. `Alert`: React Native에서 경고 대화상자를 띄우는 API입니다.
24. `FirebaseError`: Firebase에서 발생하는 오류 객체의 타입입니다.
25. `NativeStackNavigationProp`: React Navigation에서 Native Stack 네비게이션의 prop 타입입니다.
26. `ImageBackground`: React Native에서 이미지를 배경으로 렌더링하는 컴포넌트입니다.
27. `TouchableOpacity`: React Native에서 터치 이벤트를 처리하고 불투명도를 조절할 수 있는 컴포넌트입니다.
28. `Image`: React Native에서 이미지를 렌더링하는 컴포넌트입니다.
29. `require`: 외부 리소스(이미지, 폰트 등)를 불러오는 함수입니다.
30. `ActivityIndicator`: React Native에서 로딩 중임을 나타내는 인디케이터 컴포넌트입니다.



---
---
오픈북인데 gpt사용금지. 검색만 가능. 즉, 내가 내용을 정리해서 가져갈 수 있음.


시험전 세팅

기본적 문법 및 키워드 파악.

어플리케이션 어떻게 개발하는지 로직. 큰 틀에 대한 이해
