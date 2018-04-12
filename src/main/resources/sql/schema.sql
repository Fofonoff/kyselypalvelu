create table Question IF NOT EXISTS (
questionid int AUTO_INCREMENT not null,
name varchar(30) not null,
kysymys text not null,
surveyid int not null,
answerid int not null,
PRIMARY KEY (questionid)
);

create table Survey IF NOT EXISTS (
surveyid int AUTO_INCREMENT not null,
name varchar(20) not null,
questionid int not null,
PRIMARY KEY (surveyid)
);

create table Answer IF NOT EXISTS (
answerid int AUTO_INCREMENT not null,
vastaus varchar(250) not null,
PRIMARY KEY (answerid)
);

FOREIGN KEY (surveyid) REFERENCES Survey(id),
FOREIGN KEY (answerid) REFERENCES Answer(id)

insert into Question (name, kysymys, surveyid)
values (kaverita, Menitkö tapahtumiin yksin vai kavereiden kanssa?, 1);

insert into Question (name, kysymys, surveyid)
values (uusia, Tutustuitko uusiin ihmisiin?, 1)

insert into Question (name, kysymys, surveyid)
values (bestest, Mistä Helgan järjestämästä tapahtumasta olet pitänyt eniten?, 2)
