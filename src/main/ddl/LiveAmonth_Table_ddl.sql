create table user
(
    userNO       int not null auto_increment,
    userID       varchar(20),
    userPassword varchar(20),
    userName     varchar(20),
    userNickname varchar(20),
    userEmail    varchar(50),
    userSex      boolean,
    userAge      int,
    primary key (userNO)
);

create table schedule
(
    scheduleNO        int not null auto_increment,
    scheduleSubject   varchar(20),
    scheduleLikeCount int,
    scheduleStatus    boolean,
    place             varchar(20),
    userNO            int,
    primary key (scheduleNO),
    foreign key (userNO) references user (userNO) on delete cascade
);

create table scheduleContent
(
    scheduleContentNO      int not null auto_increment,
    scheduleContentSubject varchar(100),
    scheduleContentDesc    varchar(900),
    scheduleContentDate    date,
    scheduleContentCost    int,
    scheduleNO             int,
    primary key (scheduleContentNO),
    foreign key (scheduleNO) references schedule (scheduleNO) on delete cascade
);

create table scheduleReply
(
    scheduleReplyNO    int not null auto_increment,
    scheduleReplyDesc  varchar(200),
    scheduleReplyDate  date,
    scheduleReplyRefNO int,
    userNO             int,
    scheduleNO         int,
    primary key (scheduleReplyNO),
    foreign key (scheduleReplyRefNO) references scheduleReply (scheduleReplyNO) on delete cascade,
    foreign key (userNO) references user (userNO) on delete cascade,
    foreign key (scheduleNO) references schedule (scheduleNO) on delete cascade
);

create table review
(
    reviewNO        int not null auto_increment,
    reviewCategory  varchar(10),
    reviewSubject   varchar(100),
    reviewDesc      varchar(900),
    reviewLikeCount int,
    reviewDate      date,
    reviewViewCount int,
    userNo         int,
    primary key (reviewNO),
    foreign key (userNO) references user (userNO) on delete cascade
);

create table reviewReply
(
    reviewReplyNO    int not null auto_increment,
    reviewReplyDesc  varchar(200),
    reviewReplyDate  date,
    reviewReplyRefNO int,
    userNO          int,
    reviewNO         int,
    primary key (reviewReplyNO),
    foreign key (reviewReplyRefNO) references reviewReply (reviewReplyNO) on delete cascade,
    foreign key (userNO) references user (userNO) on delete cascade,
    foreign key (reviewNO) references review (reviewNO) on delete cascade
);

create table cityInfo
(
    cityInfoNO       int not null auto_increment,
    cityInfoCategory varchar(10),
    cityInfoName     varchar(10),
    cityInfoImageURL varchar(500),
    cityInfoDesc     varchar(900),
    primary key (cityInfoNO)
);

create table oneToOneAsk
(
    oneToOneAskNO        int not null auto_increment,
    oneToOneAskCategory  varchar(10),
    oneToOneAskSubject   varchar(100),
    oneToOneAskDesc      varchar(500),
    oneToOneAskDate      date,
    oneToOneAskViewCount int,
    oneToOneAskImageURL  varchar(500),
    oneToOneAskUserEmail varchar(50),
    oneToOneAskReply     varchar(500),
    userNO               int,
    primary key (oneToOneAskNO),
    foreign key (userNO) references user (userNO) on delete cascade
);


insert into user
values (101, "hjw1111", "hjw1111", "함정원", "함정원", "hjww1121@gmail.com", true, 1997);
insert into user
values (102, "hjw2222", "hjw2222", "함정투", "함정투", "hjww1121@naver.com", true, 1950);
insert into schedule
values (201, "스케줄 1", 0, false, "SEOUL", 101);
insert into schedule
values (202, "스케줄 2", 255, true, "SEOUL", 101);
insert into schedule
values (203, "스케줄 3", 2004, true, "SEOUL", 102);
insert into scheduleContent
values (301, 11111, 123456, "2021-04-09", 30000, 201);
insert into scheduleContent
values (302, 2222, 123456, "2021-04-10", 30000, 201);
insert into scheduleContent
values (304, 4444, 123456, "2021-04-12", 30000, 202);
