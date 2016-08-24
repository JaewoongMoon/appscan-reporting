

create database appscan_project;

use appscan_project;


/******************************************************************************************/
# project 테이블 
drop table project;
create table project
(projectId bigint AUTO_INCREMENT ,
 projectName varchar(500),
 startDate date,
 endDate date,
 dbPath varchar(500),
 customerId bigint,
 customerName varchar(500),
 projectUrl varchar(500),
 note varchar(2000),
PRIMARY KEY (projectId)
 )
 ENGINE=InnoDB DEFAULT CHARSET=utf8
;

