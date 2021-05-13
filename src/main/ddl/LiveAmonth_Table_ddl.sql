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
    userImage    varchar(100),
    primary key (userNO)
);

create table schedule
(
    scheduleNO        int not null auto_increment,
    scheduleSubject   varchar(20),
    scheduleStatus    boolean,
    schedulePlace     varchar(20),
    scheduleViewCount int,
    userNO            int,
    primary key (scheduleNO),
    foreign key (userNO) references user (userNO) on delete cascade
);

create table scheduleLike(
    scheduleNO int not null,
    scheduleLikeUserNO int,
    primary key (scheduleNO, scheduleLikeUserNO),
    foreign key (scheduleNO) references schedule(scheduleNO) on delete cascade,
    foreign key (scheduleLikeUserNO) references user (userNO) on delete cascade
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

create table review(
                       reviewNO int not null auto_increment,
                       reviewCategory varchar(10),
                       reviewSubject varchar(100),
                       reviewDesc varchar(900),
                       reviewDate date,
                       reviewViewCount int,
                       reviewImage varchar(100),
                       userNo int,
                       primary key (reviewNO),
                       foreign key (userNO) references user (userNO) on delete cascade
);


create table reviewLike(
    reviewNO int not null,
    reviewLikeUserNO int,
    primary key (reviewNO, reviewLikeUserNO),
    foreign key (reviewNO) references review (reviewNO) on delete cascade,
    foreign key (reviewLikeUserNO) references user (userNO) on delete cascade
);

create table reviewReply
(
    reviewReplyNO    int not null auto_increment,
    reviewReplyDesc  varchar(200),
    reviewReplyDate  dateTime,
    reviewReplyRefNO int,
    userNO           int,
    reviewNO         int,
    primary key (reviewReplyNO),
    foreign key (reviewReplyRefNO) references reviewReply (reviewReplyNO) on delete cascade,
    foreign key (userNO) references user (userNO) on delete cascade,
    foreign key (reviewNO) references review (reviewNO) on delete cascade
);


create table oneToOneAsk
(
    oneToOneAskNO        int not null auto_increment,
    oneToOneAskCategory  varchar(10),
    oneToOneAskSubject   varchar(100),
    oneToOneAskDesc      varchar(500),
    oneToOneAskDate      date,
    oneToOneAskImage     varchar(500),
    oneToOneAskUserEmail varchar(50),
    oneToOneAskReply     varchar(500),
    userNO               int,
    primary key (oneToOneAskNO),
    foreign key (userNO) references user (userNO) on delete cascade
);

create table city
(
    cityNO   int not null auto_increment,
    cityName varchar(10),
    primary key (cityNO)
);

create table cityInfo
(
    cityInfoNO       int not null auto_increment,
    cityInfoCategory varchar(10),
    cityInfoDesc     varchar(900),
    cityInfoImage    varchar(500),
    cityNo           int,
    primary key (cityInfoNO),
    foreign key (cityNO) references city (cityNO) on delete cascade
);

create table cityTransport
(
    cityTransportNO       int not null auto_increment,
    cityTransportCategory varchar(10),
    cityStationCount      int,
    cityNo                int,
    primary key (cityTransportNO),
    foreign key (cityNO) references city (cityNO) on delete cascade
);

create table cityWeather
(
    cityWeatherNO      int not null auto_increment,
    cityWeatherMonth   int,
    cityWeatherMaxTemp float,
    cityWeatherMinTemp float,
    cityWeatherAVGTemp float,
    cityNo             int,
    primary key (cityWeatherNO),
    foreign key (cityNO) references city (cityNO) on delete cascade
);