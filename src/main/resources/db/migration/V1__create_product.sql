CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    image_url VARCHAR(255) NOT NULL
);

/*
CREATE TABELE          TABLE을 만들어라
product             TABLE 이름

id          칸 이름 / private Long id; 와 짝임
BIGINT          큰 정수 타입 / 자바 Long과 짝임(약 900경까지)
AUTO_INCREMENT          번호를 DB가 자동으로 1, 2, 3....으로 매김 /
PRIMATY KEY         이 칸이 번호표(기본 키) / 중복 안 되고 비어 있을 수 없음 / 자바 @Id와 짝

name
VARCHAR(255)
NOT NULL

price
INT
NOT NULL

image_url
VARCHAR(255)
NOT NULL
 */