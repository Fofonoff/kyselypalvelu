create table Question (
id int AUTO_INCREMENT not null,
name varchar(30) not null,
question text not null,
surveyid int not null,
answerid int not null,
PRIMARY KEY (id)
);

create table Survey (
id int autoincrement not null,
name varchar(20) not null,
questionid int not null,

);

FOREIGN KEY (surveyid) REFERENCES Survey(id),
FOREIGN KEY (answerid) REFERENCES Answer(id)
