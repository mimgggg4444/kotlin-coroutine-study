
init-football.sql
```

CREATE DATABASE IF NOT EXISTS `football`;

USE `football`;

CREATE TABLE `Matches` (
  `id` INT(10) NOT NULL,
  `competition_id` VARCHAR(50) NOT NULL,
  `season` VARCHAR(50) NOT NULL,
  `utcDate` DATETIME NOT NULL,
  `status` VARCHAR(50) NOT NULL,
  `matchday` INT(10) NULL,
  `stage` VARCHAR(50) NULL,
  `group` VARCHAR(50) NULL,
  `lastUpdated` DATETIME NOT NULL,
  `homeTeam_id` INT(10) NOT NULL,
  `awayTeam_id` INT(10) NOT NULL,
  `score_winner` VARCHAR(50) NULL,
  `score_duration` VARCHAR(50) NULL,
  `score_fullTime_home` INT(10) NULL,
  `score_fullTime_away` INT(10) NULL,
  `score_halfTime_home` INT(10) NULL,
  `score_halfTime_away` INT(10) NULL,
  PRIMARY KEY (`id`)
);
```
collection-football.sh
```
#!/bin/bash

# foot ball api - 
# url - https://api.football-data.org/v4/


# API 및 데이터베이스 설정
SERVICE_KEY="당신의 키를 입력하세요.."
BASE_URL="https://api.football-data.org/v4/"
DB_HOSTNAME="mysql-container"
DB_USER="root"
DB_PASS="my-secret-pw"
DB_NAME="house"


# 첫 페이지 요청으로 총 페이지 수 계산
per_page=10


first_response=$(curl -s "$BASE_URL?page=1&perPage=$per_page&cond%5BRESEARCH_DATE%3A%3AGTE%5D=202401&returnType=JSON&serviceKey=$SERVICE_KEY")

# jq를 이용해서 match count 갯수 / 
match_count=$(echo $first_response | jq '.matchCount')

# 7 데이터 몇개 나올지 계산 필요
total_pages=$((match_count / per_page + (match_count % per_page > 0)))

# 모든 페이지 데이터 요청
for ((page=1; page<=total_pages; page++))
do
    echo "Processing page $page"
    response=$(curl -s "$BASE_URL?page=$page&perPage=$per_page&cond%5BRESEARCH_DATE%3A%3AGTE%5D=202401&returnType=JSON&serviceKey=$SERVICE_KEY")
    
    # JSON에서 필요한 데이터 추출 및 데이터베이스 삽입
    echo $response | jq -c '.data[]' | while read -r item; do
        level_no=$(echo $item | jq -r '.LEVEL_NO')
        region_cd=$(echo $item | jq -r '.REGION_CD')
        region_nm=$(echo $item | jq -r '.REGION_NM')
        research_date=$(echo $item | jq -r '.RESEARCH_DATE')
        all_cnt=$(echo $item | jq -r '.ALL_CNT')
        deal_obj=$(echo $item | jq -r '.DEAL_OBJ')

        # MySQL 데이터베이스에 데이터 삽입
        mysql -h "$DB_HOSTNAME" -u "$DB_USER" -p"$DB_PASS" "$DB_NAME"  --default-character-set=utf8mb4 -e \
        "INSERT INTO RealEstateData (level_no, region_cd, region_nm, research_date, all_cnt, deal_obj)
        VALUES ('$level_no', '$region_cd', '$region_nm', '$research_date', $all_cnt, '$deal_obj')
        ON DUPLICATE KEY UPDATE
            all_cnt=VALUES(all_cnt);"
    done
done

echo "Data insertion complete."
```


