--create table

create TABLE "CLIENT"
   (	"ID" VARCHAR2(45) PRIMARY KEY,
	"LOGIN" VARCHAR2(45 CHAR) NOT NULL,
	"PASSWORD" VARCHAR2(45 CHAR) NOT NULL,
	"NAME" VARCHAR2(45 CHAR) NOT NULL,
    "LAST_NAME" VARCHAR2(45 CHAR) NOT NULL,
    "MIDDLE_NAME" VARCHAR2(45 CHAR) NOT NULL,
    "ROLE" VARCHAR2(45 CHAR) NOT NULL
   );


--create my account
insert into CLIENT (ID, LOGIN,PASSWORD,NAME,LAST_NAME,MIDDLE_NAME,ROLE) values ('0','dmitriy.skibin','123','Dima','Skibin','Vova','Employee');
