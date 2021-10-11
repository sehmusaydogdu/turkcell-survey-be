-- insert sample user
INSERT INTO USERS (USER_ID, USER_NAME, PASSWORD) VALUES (1, 'admin',    'admin');
INSERT INTO USERS (USER_ID, USER_NAME, PASSWORD) VALUES (2, 'standart', 'standart');
INSERT INTO USERS (USER_ID, USER_NAME, PASSWORD) VALUES (3, 'ali',      '12345');
INSERT INTO USERS (USER_ID, USER_NAME, PASSWORD) VALUES (4, 'ayse',     '12345');

-- insert sample user info
INSERT INTO USER_INFO (USER_ID, NAME, SURNAME, USER_TYPE) VALUES (1, 'Hakan', 'Yıldırım', 0);
INSERT INTO USER_INFO (USER_ID, NAME, SURNAME, USER_TYPE) VALUES (2, 'Hilal', 'Uzun', 1);
INSERT INTO USER_INFO (USER_ID, NAME, SURNAME, USER_TYPE) VALUES (3, 'Ali',   'Kaya', 1);
INSERT INTO USER_INFO (USER_ID, NAME, SURNAME, USER_TYPE) VALUES (4, 'Ayşe',  'Kaplan', 1);;


-- insert sample question
INSERT INTO QUESTIONS (QUESTION_ID, QUESTION_TEXT) VALUES (QUESTIONS_TABLE_SEQUENCE.nextval, 'Kaç yıllık deneyimin var?');
INSERT INTO QUESTIONS (QUESTION_ID, QUESTION_TEXT) VALUES (QUESTIONS_TABLE_SEQUENCE.nextval, 'IK politikalarından memnun musun?');
INSERT INTO QUESTIONS (QUESTION_ID, QUESTION_TEXT) VALUES (QUESTIONS_TABLE_SEQUENCE.nextval, 'Müşteri memnuniyetiniz nedir?');

-- insert sample answer
-- example ## 1
INSERT INTO ANSWERS (QUESTION_ID, ANSWER_ID, ANSWER_TEXT) VALUES (1, ANSWERS_TABLE_SEQUENCE.nextval, '0-2');
INSERT INTO ANSWERS (QUESTION_ID, ANSWER_ID, ANSWER_TEXT) VALUES (1, ANSWERS_TABLE_SEQUENCE.nextval, '2-4');
INSERT INTO ANSWERS (QUESTION_ID, ANSWER_ID, ANSWER_TEXT) VALUES (1, ANSWERS_TABLE_SEQUENCE.nextval, '4-6');
INSERT INTO ANSWERS (QUESTION_ID, ANSWER_ID, ANSWER_TEXT) VALUES (1, ANSWERS_TABLE_SEQUENCE.nextval, '6-8');
INSERT INTO ANSWERS (QUESTION_ID, ANSWER_ID, ANSWER_TEXT) VALUES (1, ANSWERS_TABLE_SEQUENCE.nextval, '8-10');
INSERT INTO ANSWERS (QUESTION_ID, ANSWER_ID, ANSWER_TEXT) VALUES (1, ANSWERS_TABLE_SEQUENCE.nextval, '10 ve üzeri');

-- example ## 2
INSERT INTO ANSWERS (QUESTION_ID, ANSWER_ID, ANSWER_TEXT) VALUES (2, ANSWERS_TABLE_SEQUENCE.nextval, 'Evet');
INSERT INTO ANSWERS (QUESTION_ID, ANSWER_ID, ANSWER_TEXT) VALUES (2, ANSWERS_TABLE_SEQUENCE.nextval, 'Kısmen');
INSERT INTO ANSWERS (QUESTION_ID, ANSWER_ID, ANSWER_TEXT) VALUES (2, ANSWERS_TABLE_SEQUENCE.nextval, 'Hayır');

-- example ## 3
INSERT INTO ANSWERS (QUESTION_ID, ANSWER_ID, ANSWER_TEXT) VALUES (3, ANSWERS_TABLE_SEQUENCE.nextval, 'Kötü');
INSERT INTO ANSWERS (QUESTION_ID, ANSWER_ID, ANSWER_TEXT) VALUES (3, ANSWERS_TABLE_SEQUENCE.nextval, 'Orta');
INSERT INTO ANSWERS (QUESTION_ID, ANSWER_ID, ANSWER_TEXT) VALUES (3, ANSWERS_TABLE_SEQUENCE.nextval, 'İyi');

-- insert sample questions answered
INSERT INTO QUESTIONS_ANSWERED (ID, USER_ID, QUESTION_ID, ANSWER_ID, ANSWERED_DATE) VALUES (QUESTIONS_ANSWERED_TABLE_SEQUENCE.nextval, 1, 1, 1, '2021-10-10');
INSERT INTO QUESTIONS_ANSWERED (ID, USER_ID, QUESTION_ID, ANSWER_ID, ANSWERED_DATE) VALUES (QUESTIONS_ANSWERED_TABLE_SEQUENCE.nextval, 1, 2, 1, '2021-10-10');
INSERT INTO QUESTIONS_ANSWERED (ID, USER_ID, QUESTION_ID, ANSWER_ID, ANSWERED_DATE) VALUES (QUESTIONS_ANSWERED_TABLE_SEQUENCE.nextval, 1, 3, 2, '2021-10-10');

INSERT INTO QUESTIONS_ANSWERED (ID, USER_ID, QUESTION_ID, ANSWER_ID, ANSWERED_DATE) VALUES (QUESTIONS_ANSWERED_TABLE_SEQUENCE.nextval, 2, 1, 2, '2021-10-10');
INSERT INTO QUESTIONS_ANSWERED (ID, USER_ID, QUESTION_ID, ANSWER_ID, ANSWERED_DATE) VALUES (QUESTIONS_ANSWERED_TABLE_SEQUENCE.nextval, 2, 2, 2, '2021-10-10');
INSERT INTO QUESTIONS_ANSWERED (ID, USER_ID, QUESTION_ID, ANSWER_ID, ANSWERED_DATE) VALUES (QUESTIONS_ANSWERED_TABLE_SEQUENCE.nextval, 2, 3, 3, '2021-10-10');

INSERT INTO QUESTIONS_ANSWERED (ID, USER_ID, QUESTION_ID, ANSWER_ID, ANSWERED_DATE) VALUES (QUESTIONS_ANSWERED_TABLE_SEQUENCE.nextval, 3, 1, 3, '2021-10-10');
INSERT INTO QUESTIONS_ANSWERED (ID, USER_ID, QUESTION_ID, ANSWER_ID, ANSWERED_DATE) VALUES (QUESTIONS_ANSWERED_TABLE_SEQUENCE.nextval, 3, 2, 3, '2021-10-10');
INSERT INTO QUESTIONS_ANSWERED (ID, USER_ID, QUESTION_ID, ANSWER_ID, ANSWERED_DATE) VALUES (QUESTIONS_ANSWERED_TABLE_SEQUENCE.nextval, 3, 3, 1, '2021-10-10');

INSERT INTO QUESTIONS_ANSWERED (ID, USER_ID, QUESTION_ID, ANSWER_ID, ANSWERED_DATE) VALUES (QUESTIONS_ANSWERED_TABLE_SEQUENCE.nextval, 4, 1, 2, '2021-10-10');
INSERT INTO QUESTIONS_ANSWERED (ID, USER_ID, QUESTION_ID, ANSWER_ID, ANSWERED_DATE) VALUES (QUESTIONS_ANSWERED_TABLE_SEQUENCE.nextval, 4, 2, 3, '2021-10-10');
INSERT INTO QUESTIONS_ANSWERED (ID, USER_ID, QUESTION_ID, ANSWER_ID, ANSWERED_DATE) VALUES (QUESTIONS_ANSWERED_TABLE_SEQUENCE.nextval, 4, 3, 1, '2021-10-10');