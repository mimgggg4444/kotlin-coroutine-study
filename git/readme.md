저장소 클론하기

git clone https://github.com/scadasystems/Daelim-Univ.git

저장소 디렉토리로 이동하기

cd Daelim-Univ

파일트리 출력하기

git ls-tree -r main --name-only


예시: lib 디렉토리의 모든 파일 코드 출력

find lib -type f -exec cat {} +
