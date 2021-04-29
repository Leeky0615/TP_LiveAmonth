-- City
INSERT INTO city (cityNo, cityName) VALUES (1, '서울');
INSERT INTO city (cityNo, cityName) VALUES (2, '강릉');
INSERT INTO city (cityNo, cityName) VALUES (3, '경주');
INSERT INTO city (cityNo, cityName) VALUES (4, '부산');
INSERT INTO city (cityNo, cityName) VALUES (5, '여수');
INSERT INTO city (cityNo, cityName) VALUES (6, '제주');

-- City Info [INTRO]
insert into cityInfo (cityInfoCategory, cityNO, cityInfoImage, cityInfoDesc)
VALUES ('INTRO', 1, 'INTRO_SE.png',
        '서울! 서울은 우리나라의 과거, 현재, 미래를 고스란히 간직하고 있어요. 아름다운 한강을 중심으로 역사가 흐르는 세계적인 도시랍니다. 같이 따릉이 타고 야경을 바라보며 한강 운동 가지 않으실래요? 경복궁, 창경궁, 창덕궁 등 멋진 궁궐들과 롯데타워, 더현대, DDP같은 현대 건물들, 그리고 감성이 숨쉬는 젊은이들의 거리 연남동, 망리단길, 이태원과 같이 너무나도 매력적인 요소들이 많은 도시랍니다. 서울에서 산다면 지루할 일은 없을거에요! 유명한 음식점도 많고, 볼거리도 넘치거든요. ');
insert into cityInfo (cityInfoCategory, cityNO, cityInfoImage, cityInfoDesc)
VALUES ('INTRO', 2, 'INTRO_GN.png',
        '상쾌한 바다향과 솔향, 은은한 커피향이 풍기는 강릉으로 놀러오세요~! 아름다운 동해바다와 소나무 숲의 풍경을 보며 즐기는 드라이브코스는 강릉만이 가진 천혜의 관광 자원이에요. 다양한 문화유산이 있고, 최근에는 커피의 도시로 자리매김하면서 사계절 여행 마니아들의 사랑을 받는 곳이 되었어요. 또한 싱싱한 해산물과 다양한 향토 음식이 여행객을 입을 즐겁게 해주는 도시이죠. 강릉으로 떠난다면 둘러볼 만한 곳을 소개합니다~~!');
insert into cityInfo (cityInfoCategory, cityNO, cityInfoImage, cityInfoDesc)
VALUES ('INTRO', 3, 'INTRO_KJ.png',
        '도시 전체가 살아있는 박물관이라는 신라시대의 역사를 담고있는 경주를 소개합니다! 유네스코 선정 세계10대 유적지이기도 한 경주를 여행하다 보면 익히 알고 있는 유적과 유물 외에도 숨겨진 다채로운 볼거리에 놀랄 수 밖에 없을거에요! 최근 경주는 복고적 감성과 사진 찍기를 좋아하는 대학생들에게 특히 인기 있는 여행지예요. 천년 유적과 주변 경관이 한 폭의 그림처럼 펼쳐진 광경을 곳곳에서 만날 수 있어요. 안반데기의 신비로운 야경은 오랫동안 잊지 못할 추억이 될 거예요. 매년4월 벚꽃 필 무렵이면 화사하게 핀 벚꽃이 도시를 덮는 장관을 볼 수 있어요. 한달살기에도 적합한 경주를 소개합니다!');
insert into cityInfo (cityInfoCategory, cityNO, cityInfoImage, cityInfoDesc)
VALUES ('INTRO', 4, 'INTRO_BS.png',
        '아름다운 바다를 가지고 있는 부산은 사계절 볼거리와 즐길거리가 풍성해요. 해운대, 광안리, 송도는 여름이면 전국에서 온 피서객으로 붐빈답니다. 밤이면 해운대와 광안리 일대에 환상적인 야경이 펼쳐져요. 자갈치시장과 국제시장을 구경할 수도 있고, 이국적 풍경의 감천문화마을과 이기대수변공원에서는 멋진 인생사진을 남길 수 있어요. 광안리카페거리는 연인과 대학생들이 많이 오는 훌륭한 데이트 코스예요. 복국, 비빔당면, 대게, 씨앗호떡은 부산에서 꼭 맛봐야 할 대표 먹거리랍니다. 한달살기에도 적합한 부산을 소개합니다!');
insert into cityInfo (cityInfoCategory, cityNO, cityInfoImage, cityInfoDesc)
VALUES ('INTRO', 5, 'INTRO_YS.png',
        '여수밤바다~ 라는 버스커버스커의 노래는 다들 어디에선가 들어보셨을거에요. 여수 밤바다로 한번 떠나볼까요? 인심 좋은 아주머니들의 한정식과 시원하게 펼쳐진 남해가 있어요. 맛있기로 유명한 전라도 음식도 매일 경험하고,  혼자, 연인과 함께, 그리고 가족과 함께 바닷바람 맞으며 같이 걸어요. 아름다운 섬 오동도와 함께 낭만의 도시 여수에서 힐링하는건 어떠신가요?');
insert into cityInfo (cityInfoCategory, cityNO, cityInfoImage, cityInfoDesc)
VALUES ('INTRO', 6, 'INTRO_JJ.png',
        '대한민국의 대표적인 관광지 제주도는 섬이라는 특색을 가지고 있어요. 항상 따뜻한 날씨와 특색있는 지역 문화가 기다리고 있습니다. 아름다운 해수욕장으로 유명한 애월이 있는 제주시, 여러가지 박물관과 쇼핑센터가 있는 서귀포시, 그리고 제주 모든 곳에 있는 걷기 좋은 올레길 까지. 여유롭게 산책하며 제주 특유의 감성을 느껴봐요. 제주도에 간다면 전복죽, 흑돼지, 감귤, 땅콩 아이스크림 등 대표 먹거리를 꼭 드셔보세요. 시장에 가서 군것질하며 정취를 느껴보시는 것을 추천해요.');

-- City Info [FOOD]
INSERT INTO cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (1, 'FOOD', 'M_SE1.png', '광장시장육회');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (1, 'FOOD', 'M_SE2.png', '광장시장칼국수');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (1, 'FOOD', 'M_SE3.png', '성수갈비골목');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (1, 'FOOD', 'M_SE4.png', '용산부대찌개');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (1, 'FOOD', 'M_SE5.png', '왕십리곱창');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (1, 'FOOD', 'M_SE6.png', '장충동족발');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (1, 'FOOD', 'M_SE7.png', '종로생선구이');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (1, 'FOOD', 'M_SE8.png', '이태원세계음식');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (2, 'FOOD', 'M_KN1.png', '순두부젤라또');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (2, 'FOOD', 'M_KN2.png', '수제어묵고로케');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (2, 'FOOD', 'M_KN3.png', '모자호떡');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (2, 'FOOD', 'M_KN4.png', '오징어순대');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (2, 'FOOD', 'M_KN5.png', '장칼국수');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (2, 'FOOD', 'M_KN6.png', '물회');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (2, 'FOOD', 'M_KN7.png', '자연산 막회');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (2, 'FOOD', 'M_KN8.png', '꼬막비빔밥');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (3, 'FOOD', 'M_KJ1.png', '경주빵(황남빵)');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (3, 'FOOD', 'M_KJ2.png', '첨성대 라떼');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (3, 'FOOD', 'M_KJ3.png', '경주 밀면');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (3, 'FOOD', 'M_KJ4.png', '경주 떡갈비');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (3, 'FOOD', 'M_KJ5.png', '묵해장국');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (3, 'FOOD', 'M_KJ6.png', '교리김밥');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (3, 'FOOD', 'M_KJ7.png', '한우물회');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (4, 'FOOD', 'M_BS1.png', '돼지국밥');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (4, 'FOOD', 'M_BS2.png', '부산어묵');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (4, 'FOOD', 'M_BS3.png', '씨앗호떡');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (4, 'FOOD', 'M_BS4.png', '비빔당면');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (4, 'FOOD', 'M_BS5.png', '유부주머니');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (4, 'FOOD', 'M_BS6.png', '생선구이');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (4, 'FOOD', 'M_BS7.png', '장어양념구이');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (4, 'FOOD', 'M_BS8.png', '금정산성 막걸리');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (4, 'FOOD', 'M_BS9.png', '회국수');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (5, 'FOOD', 'M_YS1.png', '갓김치');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (5, 'FOOD', 'M_YS2.png', '게장정식');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (5, 'FOOD', 'M_YS3.png', '회');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (5, 'FOOD', 'M_YS4.png', '바게트버거');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (5, 'FOOD', 'M_YS5.png', '굴구이');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (5, 'FOOD', 'M_YS6.png', '아구찜');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (5, 'FOOD', 'M_YS7.png', '서대회');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (5, 'FOOD', 'M_YS8.png', '장어구이');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (6, 'FOOD', 'M_JJ1.png', '흑돼지');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (6, 'FOOD', 'M_JJ2.png', '오분자기');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (6, 'FOOD', 'M_JJ3.png', '옥돔구이');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (6, 'FOOD', 'M_JJ4.png', '갈치구이');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (6, 'FOOD', 'M_JJ5.png', '고기국수');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (6, 'FOOD', 'M_JJ6.png', '감귤');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (6, 'FOOD', 'M_JJ7.png', '땅콩아이스크림');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (6, 'FOOD', 'M_JJ8.png', '오메기떡');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (6, 'FOOD', 'M_JJ9.png', '방어');
insert into cityInfo (cityNo, cityInfoCategory, cityInfoImage, cityInfoDesc)
VALUES (6, 'FOOD', 'M_JJ10.png', '보리빵');


-- City Info [VIEW]
insert into cityInfo (cityInfoCategory, cityInfoName, cityInfoImageURL, cityInfoDesc)
VALUES ('VIEW', '서울', 'B_SE1.png', '연남동');
insert into cityInfo (cityInfoCategory, cityInfoName, cityInfoImageURL, cityInfoDesc)
VALUES ('VIEW', '서울', 'B_SE2.png', '망리단길');
insert into cityInfo (cityInfoCategory, cityInfoName, cityInfoImageURL, cityInfoDesc)
VALUES ('VIEW', '서울', 'B_SE3.png', '이태원');
insert into cityInfo (cityInfoCategory, cityInfoName, cityInfoImageURL, cityInfoDesc)
VALUES ('VIEW', '서울', 'B_SE4.png', 'DDP');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 1, 'B_SE1.png', '연남동');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 1, 'B_SE2.png', '망리단길');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 1, 'B_SE3.png', '이태원');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 1, 'B_SE4.png', 'DDP');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 1, 'B_SE5.png', '경복궁');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 1, 'B_SE6.png', '롯데타워');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 1, 'B_SE7.png', '롯데월드');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 1, 'B_SE8.png', '광장시장');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 2, 'B_KN1.png', '하슬라 아트월드');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 2, 'B_KN2.png', '헌화로 드라이브코스');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 2, 'B_KN3.png', '산책로 바우길');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 2, 'B_KN4.png', '안반데기');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 2, 'B_KN5.png', '복사꽃마을');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 2, 'B_KN6.png', '정동진해수욕장');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 2, 'B_KN7.png', '강릉중앙시장');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 2, 'B_KN8.png', '강문해변');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 2, 'B_KN9.png', '오죽헌');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 2, 'B_KN10.png', '주문진해수욕장');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 3, 'B_KJ1.png', '보문콜로세움');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 3, 'B_KJ2.png', '황리단길_도깨비명당');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 3, 'B_KJ3.png', '동궁과 월지');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 3, 'B_KJ4.png', '도리마을');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 3, 'B_KJ5.png', '화랑의 언덕');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 3, 'B_KJ6.png', '대릉원');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 3, 'B_KJ7.png', '보문호수');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 3, 'B_KJ8.png', '교촌마을');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 3, 'B_KJ9.png', '황룡사지 청보리밭');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 3, 'B_KJ10.png', '솔거미술관');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 3, 'B_KJ11.png', '경주월드');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 4, 'B_BS1.png', '절영해안산책로');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 4, 'B_BS2.png', '다대포해수욕장');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 4, 'B_BS3.png', '죽성드림성당');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 4, 'B_BS4.png', '호천마을');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 4, 'B_BS5.png', '삼락생태공원');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 4, 'B_BS6.png', '아홉산숲');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 4, 'B_BS7.png', '우암동도시숲');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 4, 'B_BS8.png', '블루라인파크');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 5, 'B_YS1.png', '오동도');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 5, 'B_YS2.png', '여수밤바다');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 5, 'B_YS3.png', '해상케이블카');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 5, 'B_YS4.png', '아쿠아플라넷');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 5, 'B_YS5.png', '만성리검은모래해변');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 5, 'B_YS6.png', '고소동벽화마을');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 5, 'B_YS7.png', '스카이타워');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 5, 'B_YS8.png', '낭만포차거리');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 6, 'B_JJ1.png', '애월해수욕장');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 6, 'B_JJ2.png', '쇠소깍');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 6, 'B_JJ3.png', '비자림');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 6, 'B_JJ4.png', '새별오름');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 6, 'B_JJ5.png', '우도');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 6, 'B_JJ6.png', '사려니숲길');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 6, 'B_JJ7.png', '한라산');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 6, 'B_JJ8.png', '제주민속촌');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 6, 'B_JJ9.png', '올레길7코스');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 6, 'B_JJ10.png', '1100고지');
insert into cityInfo (cityInfoCategory, cityNo, cityInfoImage, cityInfoDesc)
VALUES ('VIEW', 6, 'B_JJ11.png', '마라도');

