Select * from Question;

Select question from Question where id=?;

Insert into Question (name, question) Values(?,?);

Delete * Question;

Delete question from Question where id=?;

Select * from Survey;

Select name from Survey where id=?;

Insert into Survey (name) Value(?);

Delete * Survey;

Delete name from Survey where id=?;

Select * from  Question q Join Survey s On s.surveyeid=q.id;

Select q.question from Question q Join Survey s On s.surveyid=q.id where q.id=?;