-- 1. 보호소 Center table
drop table center;
create table center(
	cNum number constraint center_pk primary key, -- pr_key, 게시판 내부 번호
	cPetName varchar2(100), -- 강아지 이름
	cGender varchar2(100) not null, -- 강아지 성별
	cType varchar2(100),-- 강아지 종류
	cArea varchar2(100), -- 발견 장소
	cName varchar2(100) not null, -- 보호소 이름
	cPhoto varchar2(100), -- 강아지 사진
	cYn varchar2(100) not null, -- 분양 유무
	cEtc varchar2(1000), -- 기타 특이사항
	cId varchar2(100) not null, -- 회원 ID
	cPwd varchar2(100) not null -- 회원 PWD
) SEGMENT creation IMMEDIATE;
select * from CENTER;
create sequence center_num;
drop sequence center_num;
select * from (select rownum rnum, a.* from (select * from center where regexp_like(cpetname, 'k') order by cnum desc) a ) where rnum between 1 and 3
-- 2. 개인 Home table
drop table home;
create table home (
	hNum number constraint home_pk primary key, -- pr_key, 게시판 내부 번호
	hId varchar2(100) not null, -- 회원 ID
	hPwd varchar2(100) not null, -- 회원 비밀번호
	hPetName varchar2(100) not null, -- 강아지 이름
	hType varchar2(100) not null, -- 강아지 종류
	hGender varchar2(100) not null, -- 강아지 성별
	hPhoto varchar2(100), -- 강아지 사진
	hYn varchar2(100) not null, -- 분양 유무
	hEtc varchar2(1000) -- 기타 특이사항
) SEGMENT creation IMMEDIATE;

create sequence home_num;
drop sequence home_num;

-- 3. 신고 및 제보 (SOS)
drop table sos;
create table sos(
	sNum number constraint sos_pk primary key, -- pr_key, 게시판 내부 번호
	sArea varchar2(100) not null, -- 신고 지역
	sTitle varchar2(100) not null, -- 제목
	sTell varchar2(100) not null, -- 제보자 연락처
	sDate date, -- 글쓴시간
	sWriter varchar2(100), -- 글쓴사람
	sEtc varchar2(1000), -- 기타 특이사항
	sCount number -- 글 조회수
) SEGMENT creation IMMEDIATE;

create sequence sos_num;
drop sequence sos_num;
select * from sos;
-- 4. 강아지 찾아요
drop table find;
create table find (
	fNum number constraint find_pk primary key, -- pr_key, 게시판 내부 번호
	fPetName varchar2(100) not null, -- 강아지 이름
	fType varchar2(100) not null, -- 강아지 종류
	fGender varchar2(100) not null, -- 강아지 성별
	fDate date not null, -- 잃어버린 날짜
	fArea varchar2(100) not null, -- 잃어버린 지역
	fId varchar2(100) not null, -- 주인 ID
	fPwd varchar2(100) not null, -- 주인 Password
	fTel varchar2(100) not null, -- 주인 연락처
	fPhoto varchar2(100), -- 강아지 사진
	fEtc varchar2(1000) -- 기타 특이사항
) SEGMENT creation IMMEDIATE;

create sequence find_num;
drop sequence find_num;

insert into find(fNum, fPetName, fType, fGender, fDate, fArea, fTel, fPhoto, fEtc)
	values(find_num.nextval, '행복이', '시츄', '수컷', '17-01-15', '부산', '010-2345-5673', '','사례금 500만원');

select * from find;

-- 5. 회원
drop table member;
create table member (
	mId varchar2(100) constraint member_pk primary key, -- pr_key 유저 아이디
	mPwd varchar2(100) not null, -- 비밀번호
	mName varchar2(100) not null, -- 성명
	mTel varchar2(100) not null, -- 전화번호
	mAddr varchar2(1000) not null, -- 주소
	mEmail varchar2(100) -- 이메일
) SEGMENT creation IMMEDIATE;

select * from member;

-- 6. 보호소 지도
drop table map;
create table map (
	mCenterName varchar2(100) not null, -- 보호소 이름
	mMapX varchar2(100) not null, -- x좌표
	mMapY varchar2(100) not null, -- y좌표
	mArea varchar2(100) not null, -- 보호소 위치
	mEtc varchar2(1000) not null -- 특이사항
) SEGMENT creation IMMEDIATE;

-- 경기도
insert into map(mCenterName, mMapX, mMapY, mArea, mEtc)
	values('유기견에게사랑을주세요', '37.375424', '126.874275', '경기도', '장소 : 경기도 화성시 매송면 송라리 전화 : 031-298-6289');

insert into map(mCenterName, mMapX, mMapY, mArea, mEtc)
	values('한국동물구조관리협회', '37.870951', '126.982239', '경기도', '장소 : 경기도 양주시 남면 상수리 410-1 전화 : 031-868-2851');

-- 대전
insert into map(mCenterName, mMapX, mMapY, mArea, mEtc)
	values('대전동물보호소', '36.365322', '127.286964', '대전광역시', '장소 : 대전광역시 유성구 갑동 327-56 전화 : 042-825-1118');

-- 서울특별시
insert into map(mCenterName, mMapX, mMapY, mArea, mEtc)
   values('이다종합동물병원', '37.535649', '127.066136', '서울특별시', '장소 : 서울특별시 광진구 자양동 553-15 전화 : 02-463-7075');

insert into map(mCenterName, mMapX, mMapY, mArea, mEtc)
   values('한국유기견사랑연합회', '37.597467', '126.910059', '서울특별시', '장소 : 서울특별시 은평구 신사동 29-98 전화 : 070-8683-8860');

insert into map(mCenterName, mMapX, mMapY, mArea, mEtc)
   values('구호동물 입양센터', '37.563057', '127.002922', '서울특별시', '장소 : 서울특별시 중구 동호로 320 전화 : 070-4159-8886');

insert into map(mCenterName, mMapX, mMapY, mArea, mEtc)
   values('잠실 강아지분양 고양이분양 도그마루', '37.505136', '127.088881', '서울특별시', '장소 : 서울특별시 송파구 삼전로 72 전화 : 070-4117-7411');

delete map where mCenterName = '대전동물보호';
select * from map;

-- 7. 광고
drop table ad;
create table ad (
	aEnterName varchar2(1000) default '익명', -- 기업 이름 (기본값 익명)
	aMoney number not null, -- 기부 금액
	aDate date not null, -- 기부 날짜
	aEtc varchar2(1000) default '내용없음'-- 특이사항
) SEGMENT creation IMMEDIATE;

insert into ad(aEnterName, aMoney, aDate, aEtc) values('삼성', 20000, '17-01-15', '');
insert into ad(aEnterName, aMoney, aDate, aEtc) values('LG', 300, '17-01-12', '');
insert into ad(aEnterName, aMoney, aDate, aEtc) values('KT', 10000, '17-02-7', '동물을 사랑해요');
insert into ad(aEnterName, aMoney, aDate, aEtc) values('SK', 30000, '16-10-19', '난 기부 천사');
select * from ad;
SELECT distinct aentername FROM AD

--8. 리플(댓글)
drop table reply;
create table reply(
	renum  number constraint renum_pk primary key,   -- 글의 순서
	id varchar2(100), -- 입력한 사람
	content varchar2(1000), -- 댓글 내용
	Rdate date, -- 댓글 시간 입력
	ref number, --어느 게시글에 달렸는지 (snum 대입)
	board varchar2(100)
);

create sequence reply_num;
drop sequence reply_num;