CREATE DATABASE IF NOT EXISTS cbscalendar;
use cbscalendar;
SET SESSION FOREIGN_KEY_CHECKS=0;

/* Create Tables */

CREATE TABLE IF NOT EXISTS Calender
(
	CalenderID int NOT NULL AUTO_INCREMENT,
	Name varchar(255) NOT NULL,
	Active tinyint,
	CreatedBy varchar(255) NOT NULL,
	-- 1 = public
	-- 2 = private
	PrivatePublic tinyint NOT NULL COMMENT '1 = public
	2 = private',
	PRIMARY KEY (CalenderID)
);


CREATE TABLE IF NOT EXISTS dailyupdate
(
	date datetime NOT NULL UNIQUE,
	apparentTemperature double,
	summary text,
	qotd varchar(300) NOT NULL,
	msg_type varchar (100) NOT NULL,
	update_timestamp TIMESTAMP DEFAULT NOW() ON UPDATE NOW(),
	PRIMARY KEY (date)
);


CREATE TABLE IF NOT EXISTS events
(
	eventid int NOT NULL AUTO_INCREMENT,
	type int NOT NULL,
	location varchar(200),
	createdby int NOT NULL,
	startTime datetime NOT NULL,
	endTime datetime NOT NULL,
	name varchar(200) NOT NULL,
	text text NOT NULL,
	active int NOT NULL DEFAULT '1',
	-- Decides wether the event is an import-event or user created
	-- 
	customevent boolean COMMENT 'Decides wether the event is an import-event or user created
',
	CalenderID int NOT NULL,
	PRIMARY KEY (eventid)
);


CREATE TABLE IF NOT EXISTS locationdata
(
	locationdataid int NOT NULL AUTO_INCREMENT,
	longitude int NOT NULL,
	latitude int UNIQUE,
	PRIMARY KEY (locationdataid)
);


CREATE TABLE IF NOT EXISTS notes
(
	noteId int NOT NULL AUTO_INCREMENT,
	eventId int NOT NULL,
	createdBy varchar(255) NOT NULL,
	text text,
	dateTime datetime NOT NULL default NOW(),
	active int NOT NULL,
	PRIMARY KEY (noteid)
);



CREATE TABLE IF NOT EXISTS roles
(
	roleid int NOT NULL AUTO_INCREMENT,
	userid int NOT NULL,
	type varchar(200) NOT NULL,
	PRIMARY KEY (roleid)
);


CREATE TABLE IF NOT EXISTS userevents
(
	userid int NOT NULL,
	CalenderID int NOT NULL
);


CREATE TABLE IF NOT EXISTS users
(
	userid int NOT NULL AUTO_INCREMENT,
	email varchar(40) NOT NULL,
	active boolean DEFAULT '1',
	created datetime NOT NULL DEFAULT NOW(),
	password varchar(200) NOT NULL,
	PRIMARY KEY (userid)
);

/* Create Dummy Account */

INSERT INTO `cbscalendar`.`users`
(`email`,
`active`,
`password`)
VALUES
("admin@admin.dk",
true,
"d6YSr320JnLXlp8YYxUcNQ==");


/* Create dummy calendar */
INSERT INTO `cbscalendar`.`calender`
(`Name`,
`Active`,
`CreatedBy`,
`PrivatePublic`)
VALUES
("testCalendar",
1,
"Admin@admin.dk",
1);


/* create dummy event*/
INSERT INTO `cbscalendar`.`events`
(
`type`,
`createdby`,
`start`,
`end`,
`name`,
`text`,
`customevent`,
`CalenderID`)
VALUES
(
1,
1,
2014-11-01 00:00:00.000,
2014-11-02 00:00:00.000,
"test",
"beskrivelse af test event",
false,
1);



/* Create Foreign Keys */

ALTER TABLE events
	ADD FOREIGN KEY (CalenderID)
	REFERENCES Calender (CalenderID)
	ON UPDATE RESTRICT
;


ALTER TABLE userevents
	ADD FOREIGN KEY (CalenderID)
	REFERENCES Calender (CalenderID)
	ON UPDATE RESTRICT
;


ALTER TABLE notes
	ADD FOREIGN KEY (eventid)
	REFERENCES events (eventid)
	ON UPDATE RESTRICT
;


ALTER TABLE events
	ADD FOREIGN KEY (location)
	REFERENCES locationdata (locationdataid)
	ON UPDATE RESTRICT
;


ALTER TABLE events
	ADD FOREIGN KEY (createdby)
	REFERENCES users (userid)
	ON UPDATE RESTRICT
;


ALTER TABLE roles
	ADD FOREIGN KEY (userid)
	REFERENCES users (userid)
	ON UPDATE RESTRICT
;


ALTER TABLE userevents
	ADD FOREIGN KEY (userid)
	REFERENCES users (userid)
	ON UPDATE RESTRICT
;


ALTER TABLE notes
	ADD FOREIGN KEY (createdby)
	REFERENCES users (userid)
	ON UPDATE RESTRICT
;


CREATE DATABASE IF NOT EXISTS cbscalendar;
use cbscalendar;
SET SESSION FOREIGN_KEY_CHECKS=0;

/* Create Tables */

CREATE TABLE IF NOT EXISTS Calender
(
	CalenderID int NOT NULL AUTO_INCREMENT,
	Name varchar(255) NOT NULL,
	Active tinyint,
	CreatedBy varchar(255) NOT NULL,
	-- 1 = public
	-- 2 = private
	PrivatePublic tinyint NOT NULL COMMENT '1 = public
	2 = private',
	PRIMARY KEY (CalenderID)
);


CREATE TABLE IF NOT EXISTS dailyupdate
(
	date datetime NOT NULL UNIQUE,
	apparentTemperature double,
	summary text,
	windspeed double,
	qotd varchar(300) NOT NULL,
	PRIMARY KEY (date)
);


CREATE TABLE IF NOT EXISTS events
(
	eventid int NOT NULL AUTO_INCREMENT,
	type int NOT NULL,
	location int,
	createdby int NOT NULL,
	start datetime NOT NULL,
	end datetime NOT NULL,
	name varchar(0) NOT NULL,
	text text NOT NULL,
	-- Decides wether the event is an import-event or user created
	-- 
	customevent boolean COMMENT 'Decides wether the event is an import-event or user created
',
	CalenderID int NOT NULL,
	PRIMARY KEY (eventid)
);


CREATE TABLE IF NOT EXISTS locationdata
(
	locationdataid int NOT NULL AUTO_INCREMENT,
	longitude int NOT NULL,
	latitude int UNIQUE,
	PRIMARY KEY (locationdataid)
);


CREATE TABLE IF NOT EXISTS notes
(
	noteid int NOT NULL AUTO_INCREMENT,
	eventid int NOT NULL,
	createdby int NOT NULL,
	text text,
	created datetime NOT NULL,
	PRIMARY KEY (noteid)
);


CREATE TABLE IF NOT EXISTS roles
(
	roleid int NOT NULL AUTO_INCREMENT,
	userid int NOT NULL,
	type varchar(200) NOT NULL,
	PRIMARY KEY (roleid)
);


CREATE TABLE IF NOT EXISTS userevents
(
	userid int NOT NULL,
	CalenderID int NOT NULL
);


CREATE TABLE IF NOT EXISTS users
(
	userid int NOT NULL AUTO_INCREMENT,
	email varchar(40) NOT NULL,
	active boolean DEFAULT '1',
	created datetime,
	password varchar(200) NOT NULL,
	PRIMARY KEY (userid)
);



/* Create Foreign Keys */

ALTER TABLE events
	ADD FOREIGN KEY (CalenderID)
	REFERENCES Calender (CalenderID)
	ON UPDATE RESTRICT
;


ALTER TABLE userevents
	ADD FOREIGN KEY (CalenderID)
	REFERENCES Calender (CalenderID)
	ON UPDATE RESTRICT
;


ALTER TABLE notes
	ADD FOREIGN KEY (eventid)
	REFERENCES events (eventid)
	ON UPDATE RESTRICT
;


ALTER TABLE events
	ADD FOREIGN KEY (location)
	REFERENCES locationdata (locationdataid)
	ON UPDATE RESTRICT
;


ALTER TABLE events
	ADD FOREIGN KEY (createdby)
	REFERENCES users (userid)
	ON UPDATE RESTRICT
;


ALTER TABLE roles
	ADD FOREIGN KEY (userid)
	REFERENCES users (userid)
	ON UPDATE RESTRICT
;


ALTER TABLE userevents
	ADD FOREIGN KEY (userid)
	REFERENCES users (userid)
	ON UPDATE RESTRICT
;


ALTER TABLE notes
	ADD FOREIGN KEY (createdby)
	REFERENCES users (userid)
	ON UPDATE RESTRICT
;
