
필기로 쉘 스크립트를 손으로 작성.

쉘 스크립트 여태까지 한것들, 깃헙에 올라와 있는거 정리, 외우기


---
---

객관식 문제:
1. 현재 디렉토리의 파일 목록을 출력하는 명령어는?
   (a) pwd (b) cd (c) ls (d) mkdir
   답: (c) ls

2. 홈 디렉토리로 이동하는 명령어는?
   (a) cd ~ (b) cd / (c) cd .. (d) cd -
   답: (a) cd ~

3. 빈 파일을 생성하는 명령어는?
   (a) cat (b) touch (c) echo (d) >
   답: (b) touch

4. /etc 디렉토리로 이동하는 명령어는?
   (a) cd etc (b) cd /etc (c) cd ./etc (d) cd ../etc
   답: (b) cd /etc

5. 파일의 내용을 화면에 출력하는 명령어는?
   (a) ls (b) cat (c) echo (d) print
   답: (b) cat

6. 환경 변수의 값을 출력하는 명령어는? 
   (a) env (b) set (c) export (d) echo $환경변수
   답: (d) echo $환경변수

7. alias 명령어의 역할은?
   (a) 명령어 단축 (b) 명령어 히스토리 (c) 명령어 자동완성 (d) 명령어 취소
   답: (a) 명령어 단축

8. 쉘 스크립트에서 주석 처리하는 기호는?
   (a) // (b) /* */ (c) # (d) %
   답: (c) #

9. 쉘 스크립트의 첫 줄에 들어가는 내용은?
   (a) #/bin/bash (b) #!/bin/sh (c) !#/bin/sh (d) /bin/sh
   답: (b) #!/bin/sh

10. 쉘 스크립트 실행 권한을 주는 명령어는?
    (a) ./script.sh (b) sh script.sh (c) chmod +x script.sh (d) run script.sh
    답: (c) chmod +x script.sh

11. 현재 디렉토리를 깨끗하게 정리해주는 명령어는?
    (a) clean (b) clear (c) cls (d) clr
    답: (b) clear

12. 파일의 소유자를 변경하는 명령어는?
    (a) chown (b) chmod (c) chgrp (d) ls -l
    답: (a) chown

13. 파일의 퍼미션을 변경하는 명령어는?  
    (a) chown (b) chmod (c) chgrp (d) ls -l
    답: (b) chmod

14. 파일의 마지막 5줄을 출력하는 명령어는?
    (a) head -5 (b) tail -5 (c) last -5 (d) end -5
    답: (b) tail -5

15. 명령어의 실행 결과를 파일로 저장하는 기호는?
    (a) > (b) < (c) | (d) &
    답: (a) >

16. 파일의 내용을 페이지 단위로 화면에 출력하는 명령어는?
    (a) cat (b) more (c) less (d) tail
    답: (b) more

17. 파일의 내용을 검색할 때 사용하는 명령어는?
    (a) search (b) grep (c) find (d) lookup 
    답: (b) grep

18. 시스템의 현재 날짜와 시간을 출력하는 명령어는?
    (a) time (b) date (c) now (d) clock
    답: (b) date

19. 디렉토리의 용량을 확인하는 명령어는?
    (a) du (b) df (c) ls -l (d) size
    답: (a) du

20. 프로세스를 강제 종료시키는 명령어는?
    (a) kill (b) stop (c) exit (d) quit
    답: (a) kill

21. 쉘 스크립트에서 if문의 기본 구조는?
    (a) if [조건] then 명령어 endif
    (b) if [조건] 명령어 fi 
    (c) if [조건]; then 명령어; fi
    (d) if [조건] then 명령어 fi
    답: (d) if [조건] then 명령어 fi

22. 산술 비교 연산자 중 "같지 않다"를 나타내는 것은?
    (a) -eq (b) -ne (c) -lt (d) -ge
    답: (b) -ne

23. 파일이 디렉토리인지 확인하는 조건은?
    (a) -e (b) -f (c) -d (d) -s
    답: (c) -d

24. 파일이 읽기 가능한지 확인하는 조건은?  
    (a) -r (b) -w (c) -x (d) -s
    답: (a) -r

25. 쉘 스크립트에서 AND 연산자는?
    (a) & (b) | (c) -a (d) &&
    답: (d) &&

26. 쉘 스크립트에서 OR 연산자는?
    (a) & (b) | (c) -o (d) ||
    답: (d) ||

27. case문에서 조건의 끝을 나타내는 기호는?
    (a) ; (b) ;; (c) : (d) :;
    답: (b) ;;

28. for문의 기본 구조는?
    (a) for 변수 in 값; do 명령어; done
    (b) for 변수 in 값 do 명령어 done
    (c) for (변수 in 값) do 명령어 done
    (d) for 변수 in (값) do 명령어 done
    답: (a) for 변수 in 값; do 명령어; done

29. while문의 기본 구조는? 
    (a) while [조건] do 명령어 done
    (b) while [조건]; do 명령어; done
    (c) while 조건 do 명령어 done
    (d) while (조건) do 명령어 done
    답: (b) while [조건]; do 명령어; done

30. break문의 역할은?
    (a) 루프 건너뛰기 (b) 루프 중단 (c) 루프 반복 (d) 루프 재개
    답: (b) 루프 중단

31. continue문의 역할은? 
    (a) 루프 건너뛰기 (b) 루프 중단 (c) 루프 반복 (d) 루프 재개
    답: (a) 루프 건너뛰기

32. 스크립트 실행을 중단하고 종료하는 명령어는?
    (a) quit (b) stop (c) exit (d) return
    답: (c) exit

33. 함수에서 값을 반환할 때 사용하는 명령어는?
    (a) back (b) get (c) revert (d) return
    답: (d) return

34. 아규먼트로 받은 값들의 총 개수를 나타내는 변수는?
    (a) $@ (b) $# (c) $* (d) $$
    답: (b) $#

35. 현재 쉘 스크립트의 프로세스 ID를 나타내는 변수는?
    (a) $@ (b) $! (c) $$ (d) $?
    답: (c) $$

36. 프로세스의 상태를 보여주는 명령어는?
    (a) ps (b) kill (c) top (d) jobs
    답: (a) ps

37. 시스템 정보를 출력하는 명령어는?
    (a) info (b) status (c) uname (d) sysinfo
    답: (c) uname

38. 디스크 사용량을 출력하는 명령어는?
    (a) diskuse (b) df (c) du (d) diskfree
    답: (b) df

39. 메모리 사용량을 출력하는 명령어는?
    (a) memory (b) free (c) meminfo (d) usage
    답: (b) free

40. 시스템의 실행 시간을 보여주는 명령어는?
    (a) runtime (b) uptime (c) systime (d) pstime
    답: (b) uptime

41. CPU 정보를 자세히 출력하는 명령어는?
    (a) cpuinfo (b) lscpu (c) cpustat (d) cputype
    답: (b) lscpu

42. 파일의 마지막 수정 시간을 변경하는 명령어는?
    (a) touch (b) time (c) date (d) modify
    답: (a) touch

43. 디렉토리와 그 하위 디렉토리를 삭제하는 옵션은?
    (a) -r (b) -f (c) -d (d) -a
    답: (a) -r

44. 파일의 내용을 역순으로 출력하는 명령어는?
    (a) inverse (b) reverse (c) tac (d) invert
    답: (c) tac

45. 파일의 특정 행부터 출력하는 명령어의 옵션은?
    (a) -n (b) -l (c) -f (d) -p
    답: (a) -n

46. 소유자에게 실행 권한을 부여하는 문자는?
    (a) r (b) x (c) w (d) t
    답: (b) x

47. 그룹에게 읽기 권한을 부여하는 문자는?
    (a) r (b) x (c) w (d) g
    답: (a) r

48. 파일 종류를 보여주는 명령어는?
    (a) type (b) kind (c) file (d) class
    답: (c) file

49. 파일 내용을 검색하고 라인 번호를 출력하는 명령어의 옵션은? 
    (a) -n (b) -l (c) -f (d) -i
    답: (a) -n

50. 용량이 큰 디렉토리 순으로 출력하는 명령어는?
    (a) du -h | sort -h (b) du | sort 
    (c) du -h | sort -n (d) du -h | sort -r
    답: (a) du -h | sort -h

서술형 문제:
1. 쉘 스크립트에서 사용자로부터 두 개의 숫자를 입력받아 그 합을 출력하는 스크립트를 작성하시오.
   
   ``` bash
   #!/bin/sh
   echo "첫 번째 숫자를 입력하세요:"
   read num1
   echo "두 번째 숫자를 입력하세요:"
   read num2
   sum=$((num1 + num2))
   echo "두 숫자의 합은 $sum 입니다."
   exit 0
   ```

2. 현재 디렉토리에 있는 모든 txt 파일의 내용을 하나의 파일로 합쳐 result.txt로 저장하는 스크립트를 작성하시오.
   
   ```bash
   #!/bin/sh
   cat *.txt > result.txt
   echo "모든 txt 파일의 내용이 result.txt로 합쳐졌습니다."
   exit 0
   ```

3. 1부터 100까지의 숫자 중에서 3의 배수이면서 5의 배수인 숫자들의 합을 구하는 스크립트를 작성하시오.
   
   ```bash
   #!/bin/sh
   sum=0
   for i in $(seq 1 100); do
       if [ $((i % 3)) -eq 0 ] && [ $((i % 5)) -eq 0 ]; then
           sum=$((sum + i))
       fi
   done
   echo "1부터 100까지의 숫자 중 3과 5의 공배수의 합은 $sum 입니다."
   exit 0
   ```

4. 주어진 파일에서 특정 단어가 포함된 라인의 수를 세는 스크립트를 작성하시오. 파일명과 검색할 단어는 사용자로부터 입력받습니다.
   
   ```bash
   #!/bin/sh
   echo "파일명을 입력하세요:"
   read file
   echo "검색할 단어를 입력하세요:"
   read word
   count=$(grep -c "$word" "$file")
   echo "$file 파일에서 '$word'가 포함된 라인의 수는 $count 입니다."
   exit 0
   ```

5. 사용자로부터 디렉토리명을 입력받아, 해당 디렉토리 내의 모든 파일과 디렉토리의 이름을 알파벳 역순으로 정렬하여 출력하는 스크립트를 작성하시오.
   
   ```bash
   #!/bin/sh
   echo "디렉토리명을 입력하세요:"
   read dir
   echo "$dir 디렉토리 내의 파일과 디렉토리 목록을 알파벳 역순으로 출력합니다."
   ls -r "$dir"
   exit 0
   ```

네, 선생님. 앞에서 작성한 내용에 이어서 나머지 서술형 문제와 쉘 프로그래밍 문법 문제에 대한 답 또는 해설을 작성하겠습니다.

서술형 문제 (계속):
6. 현재 시스템의 CPU 사용률과 메모리 사용량을 출력하는 스크립트를 작성하시오.
   
   ```bash
   #!/bin/sh
   cpu_usage=$(top -bn1 | grep "Cpu(s)" | awk '{print $2 + $4}')
   memory_usage=$(free -m | awk 'NR==2{printf "%.2f%%\n", $3*100/$2 }')
   echo "CPU 사용률: $cpu_usage%"
   echo "메모리 사용량: $memory_usage"
   exit 0
   ```

7. 사용자로부터 파일명을 입력받아, 해당 파일의 크기를 사람이 읽기 쉬운 형식(KB, MB, GB)으로 출력하는 스크립트를 작성하시오.
   
   ```bash
   #!/bin/sh
   echo "파일명을 입력하세요:"
   read file
   size=$(du -h "$file" | cut -f1)
   echo "$file의 크기는 $size 입니다."
   exit 0
   ```

8. 1부터 사용자가 입력한 숫자까지의 팩토리얼을 계산하여 출력하는 스크립트를 작성하시오.
   
   ```bash
   #!/bin/sh
   echo "숫자를 입력하세요:"
   read num
   fact=1
   for i in $(seq 1 $num); do
       fact=$((fact * i))
   done
   echo "$num의 팩토리얼은 $fact 입니다."
   exit 0
   ```

9. 주어진 파일에서 가장 긴 라인의 길이와 해당 라인의 내용을 출력하는 스크립트를 작성하시오.
   
   ```bash
   #!/bin/sh
   echo "파일명을 입력하세요:"
   read file
   max_length=0
   longest_line=""
   while read line; do
       length=${#line}
       if [ $length -gt $max_length ]; then
           max_length=$length
           longest_line="$line"
       fi
   done < "$file"
   echo "가장 긴 라인의 길이는 $max_length 입니다."
   echo "가장 긴 라인의 내용은 다음과 같습니다:"
   echo "$longest_line"
   exit 0
   ```

10. 사용자로부터 디렉토리 경로를 입력받아, 해당 디렉토리와 그 하위 디렉토리까지 포함된 모든 파일의 개수를 세는 스크립트를 작성하시오.
    
    ```bash
    #!/bin/sh
    echo "디렉토리 경로를 입력하세요:"
    read dir
    count=$(find "$dir" -type f | wc -l)
    echo "$dir 디렉토리와 그 하위 디렉토리에 포함된 파일의 개수는 $count 개 입니다."
    exit 0
    ```

쉘 프로그래밍 문법 문제:
1. if문의 기본 구조에 대해 설명하고, 예시 코드를 제시하시오.
   
   if문은 주어진 조건이 참인 경우에 특정 명령어를 실행하는 조건문입니다. 기본 구조는 다음과 같습니다.

   ```bash
   if [ 조건 ]; then
       명령어
   fi
   ```

   예시 코드:
   ```bash
   #!/bin/sh
   num=10
   if [ $num -gt 5 ]; then
       echo "$num은 5보다 큽니다."
   fi
   exit 0
   ```

2. for문을 사용하여 1부터 10까지의 숫자를 출력하는 쉘 스크립트를 작성하시오.

   ```bash
   #!/bin/sh
   for i in {1..10}; do
       echo $i
   done
   exit 0
   ```

3. while문을 사용하여 사용자가 'quit'을 입력할 때까지 계속해서 입력을 받는 쉘 스크립트를 작성하시오.

   ```bash
   #!/bin/sh
   while true; do
       echo "메시지를 입력하세요 (종료: quit):"
       read input
       if [ "$input" = "quit" ]; then
           break
       fi
       echo "입력한 메시지: $input"
   done
   echo "스크립트를 종료합니다."
   exit 0
   ```

4. case문의 기본 구조에 대해 설명하고, 예시 코드를 제시하시오.

   case문은 여러 개의 조건을 비교하여 해당하는 명령어를 실행하는 조건문입니다. 기본 구조는 다음과 같습니다.

   ```bash
   case 변수 in
       패턴1)
           명령어1
           ;;
       패턴2)
           명령어2
           ;;
       *)
           기본 명령어
           ;;
   esac
   ```

   예시 코드:
   ```bash
   #!/bin/sh
   echo "1부터 3까지의 숫자 중 하나를 입력하세요:"
   read num
   case $num in
       1)
           echo "1을 입력하셨습니다."
           ;;
       2)
           echo "2를 입력하셨습니다."
           ;;
       3)
           echo "3을 입력하셨습니다."
           ;;
       *)
           echo "1부터 3까지의 숫자만 입력 가능합니다."
           ;;
   esac
   exit 0
   ```

5. 함수의 정의와 호출 방법에 대해 설명하고, 간단한 예시 코드를 제시하시오.

   함수는 특정 작업을 수행하는 코드 블록으로, 반복되는 작업을 간편하게 처리할 수 있습니다. 함수의 정의는 다음과 같이 합니다.

   ```bash
   함수명() {
       명령어
   }
   ```

   함수를 호출할 때는 함수명을 사용합니다.

   예시 코드:
   ```bash
   #!/bin/sh
   hello() {
       echo "Hello, $1!"
   }
   
   hello "John"
   hello "Alice"
   exit 0
   ```

6. 쉘 스크립트에서 산술 연산을 수행하는 방법에 대해 설명하고, 예시 코드를 제시하시오.

   쉘 스크립트에서는 $(( 산술식 )) 형태로 산술 연산을 수행할 수 있습니다.

   예시 코드:
   ```bash
   #!/bin/sh
   a=10
   b=20
   sum=$((a + b))
   echo "$a + $b = $sum"
   exit 0
   ```

7. 쉘 스크립트에서 문자열을 비교하는 방법에 대해 설명하고, 예시 코드를 제시하시오.

   쉘 스크립트에서는 [ 문자열1 연산자 문자열2 ] 형태로 문자열을 비교할 수 있습니다. 주로 사용되는 연산자는 =, !=, -z, -n 등이 있습니다.

   예시 코드:
   ```bash
   #!/bin/sh
   str1="hello"
   str2="world"
   if [ "$str1" = "$str2" ]; then
       echo "두 문자열은 같습니다."
   else
       echo "두 문자열은 다릅니다."
   fi
   exit 0
   ```

8. 쉘 스크립트에서 파일의 존재 여부를 확인하는 방법에 대해 설명하고, 예시 코드를 제시하시오.

   쉘 스크립트에서는 [ -e 파일명 ] 형태로 파일의 존재 여부를 확인할 수 있습니다.

   예시 코드:
   ```bash
   #!/bin/sh
   file="example.txt"
   if [ -e "$file" ]; then
       echo "$file 파일이 존재합니다."
   else
       echo "$file 파일이 존재하지 않습니다."
   fi
   exit 0
   ```

9. break문과 continue문의 차이점에 대해 설명하고, 각각의 사용 예시 코드를 제시하시오.

   break문은 반복문을 즉시 종료하고 반복문 밖으로 빠져나옵니다. continue문은 현재 반복을 건너뛰고 다음 반복으로 넘어갑니다.

   break문 예시 코드:
   ```bash
   #!/bin/sh
   for i in {1..10}; do
       if [ $i -eq 5 ]; then
           break
       fi
       echo $i
   done
   echo "반복문 종료"
   exit 0
   ```

   continue문 예시 코드:
   ```bash
   #!/bin/sh
   for i in {1..10}; do
       if [ $i -eq 5 ]; then
           continue
       fi
       echo $i
   done
   echo "반복문 종료"
   exit 0
   ```

10. 쉘 스크립트에서 명령행 인수를 처리하는 방법에 대해 설명하고, 예시 코드를 제시하시오.

    쉘 스크립트에서는 $1, $2, ... 형태로 명령행 인수를 받아올 수 있습니다. $0은 스크립트 파일명을 나타냅니다.

    예시 코드:
    ```bash
    #!/bin/sh
    echo "스크립트 파일명: $0"
    echo "첫 번째 인수: $1"
    echo "두 번째 인수: $2"
    exit 0
    ```

