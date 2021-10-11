-- create users table script
CREATE TABLE USERS
(
	USER_ID   NUMBER(16) 	NOT NULL,
	USER_NAME VARCHAR2(100) NOT NULL,
	PASSWORD  VARCHAR2(100) NOT NULL
);

-- create users table script
CREATE TABLE USER_INFO
(
	USER_ID   NUMBER(16) 	NOT NULL,
	NAME 	  VARCHAR2(100) NOT NULL,
	SURNAME   VARCHAR2(100) NOT NULL,
	USER_TYPE NUMBER(1)     NOT NULL
);


-- create sequence
CREATE SEQUENCE AUDIT_TABLE_SEQUENCE START WITH 1 INCREMENT BY 1;
-- create audit log table script
CREATE TABLE AUDIT_LOG
(
	AUDIT_ID      NUMBER(16) 	NOT NULL,
	USER_ID       NUMBER(16) 	NOT NULL,
	NAME     	  VARCHAR2(100) NOT NULL,
	LOGIN_DATE    DATE
);

---------------------------------------------------------------------------------------------------

-- create sequence
CREATE SEQUENCE QUESTIONS_TABLE_SEQUENCE START WITH 1 INCREMENT BY 1;
-- create question table script
CREATE TABLE QUESTIONS
(
	QUESTION_ID   NUMBER(16) 	NOT NULL,
	QUESTION_TEXT VARCHAR2(200) NOT NULL
);

---------------------------------------------------------------------------------------------------
-- create sequence
CREATE SEQUENCE ANSWERS_TABLE_SEQUENCE START WITH 1 INCREMENT BY 1;
-- create answer table script
CREATE TABLE ANSWERS
(
	QUESTION_ID   NUMBER(16) 	NOT NULL,
	ANSWER_ID     NUMBER(16) 	NOT NULL,
	ANSWER_TEXT   VARCHAR2(200) NOT NULL
);
----------------------------------------------------------------------------------------------------
-- create sequence
CREATE SEQUENCE QUESTIONS_ANSWERED_TABLE_SEQUENCE START WITH 1 INCREMENT BY 1;
-- create questions_answered table script
CREATE TABLE QUESTIONS_ANSWERED
(
	ID            NUMBER(16)    NOT NULL,
	QUESTION_ID   NUMBER(16) 	NOT NULL,
	ANSWER_ID     NUMBER(16) 	NOT NULL,
	USER_ID		  NUMBER(16)    NOT NULL,
	ANSWERED_DATE DATE
);