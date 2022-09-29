CREATE TABLE Persons
(
    PersonID  int,
    LastName  varchar(255),
    FirstName varchar(255),
    Address   varchar(255),
    City      varchar(255)
);

CREATE TABLE Contacts
(
    ContactID int,
    PersonID  int,
    Phone     int(10),
    Email     varchar(255)
);

show
tables ;

drop table Contacts;

insert into Persons (PersonID, LastName, FirstName, Address, City)
VALUES (0, 'WIck', 'John', 'Street 1', 'New York');
insert into Persons (PersonID, LastName, FirstName, Address, City)
VALUES (1, 'WIck', 'John', 'Street 1', 'New York');

select *
from Persons;
select *
from Persons
where PersonID = '1';
delete
from Persons
where PersonID = '1';
update Persons
set Address = 'Street 2'
where PersonID = '0';

CREATE TABLE Persons
(
    PersonID  int NOT NULL AUTO_INCREMENT,
    LastName  varchar(255),
    FirstName varchar(255),
    Address   varchar(255),
    City      varchar(255),
    CONSTRAINT PK_Person PRIMARY KEY (PersonID),
    CONSTRAINT UC_Person UNIQUE (FirstName, LastName)
);

select *
from Persons
where City = 'London'
  and FirstName = 'Holmes';

CREATE TABLE Contacts
(
    ContactID int NOT NULL AUTO_INCREMENT,
    PersonID  int NOT NULL,
    Phone     int(10),
    Email     varchar(255),
    CONSTRAINT PK_Contact PRIMARY KEY (ContactID)
);

select p.FirstName, p.LastName, c.Email, c.Phone from Persons p
    JOIN Contacts c on p.PersonID = c.PersonID WHERE p.City = 'London';