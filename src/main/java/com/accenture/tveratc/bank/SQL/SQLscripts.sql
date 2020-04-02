--create table client

create TABLE "CLIENT"
   (	"ID" VARCHAR2(45) PRIMARY KEY,
	"LOGIN" VARCHAR2(45 CHAR) NOT NULL,
	"PASSWORD" VARCHAR2(45 CHAR) NOT NULL,
	"NAME" VARCHAR2(45 CHAR) NOT NULL,
    "LAST_NAME" VARCHAR2(45 CHAR) NOT NULL,
    "MIDDLE_NAME" VARCHAR2(45 CHAR) NOT NULL,
    "ROLE" VARCHAR2(45 CHAR) NOT NULL
   );

   --create table global settings
   create TABLE "GLOBAL_SETTING"
      (	"code" VARCHAR2(45 CHAR) PRIMARY KEY,
   	"value" VARCHAR2(45 CHAR) NOT NULL,
      );


      create TABLE "CLIENTJPA"
         (	"ID" UUID PRIMARY KEY,
      	"LOGIN" VARCHAR2(45 CHAR) NOT NULL,
      	"PASSWORD" VARCHAR2(45 CHAR) NOT NULL,
      	"NAME" VARCHAR2(45 CHAR) NOT NULL,
          "LAST_NAME" VARCHAR2(45 CHAR) NOT NULL,
          "MIDDLE_NAME" VARCHAR2(45 CHAR) NOT NULL,
          "ROLE" VARCHAR2(45 CHAR) NOT NULL
         );



--create my account
insert into CLIENT (ID, LOGIN,PASSWORD,NAME,LAST_NAME,MIDDLE_NAME,ROLE) values ('0','dmitriy.skibin','123','Dima','Skibin','Vova','Employee');
insert into CLIENT (ID, LOGIN,PASSWORD,NAME,LAST_NAME,MIDDLE_NAME,ROLE) values ('0','dmitriy.skibin','123','Dima','Skibin','Vova','Employee');
--create field for global-setting
insert into GLOBAL_SETTING ("CODE","VALUE") values ('DEPOSIT_RATE','6.5');

