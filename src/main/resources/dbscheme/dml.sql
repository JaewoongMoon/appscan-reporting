# 조회

select a.projectId,
		a.projectName,
        a.startDate,
        a.endDate,
        a.dbPath,
        a.customerId,
        a.customerName,
        a.projectUrl,
        a.note
  from project a
;


# 입력
insert into project
(projectName, startDate, endDate, dbPath, customerId, customerName, projectUrl, note)
values
('인랑 앱스캔1',date('2016-08-01'), date('2016-08-11'), 'jdbc:firebirdsql:localhost/3050:D:/resultdb/alpha-jinroh/jinroh-RESULTSDB2.FDB?encoding=UTF-8', 
1, 'hangame', 'http://alpha-hangame.net/customer', '...')
;

insert into project
(projectName, startDate, endDate, dbPath, customerId, customerName, projectUrl, note)
values
('엘소드 앱스캔1', date('2016-07-20'), date('2016-07-30'), 'jdbc:firebirdsql:localhost/3050:D:/resultdb/elsword/elsword-RESULTSDB.FDB?encoding=UTF-8', 
1, 'hangame', 'http://alpha-hangame.com/elsword', '...')
;

# 수정
commit;



# 삭제

