INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('michaeldelcore@bigbadcorp.ca', '$2a$10$1ltibqiyyBJMJQ4hqM7f0OusP6np/IHshkYc4TjedwHnwwNChQZCy', 1);

INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('johnjoe@bigbadcorp.ca', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

 
INSERT INTO sec_role (roleName)
VALUES ('ROLE_ADMIN');
 
INSERT INTO sec_role (roleName)
VALUES ('ROLE_USER');
 

 
INSERT INTO user_role (userId, roleId)
VALUES (1, 1);
 
INSERT INTO user_role (userId, roleId)
VALUES (1, 2);
 
INSERT INTO user_role (userId, roleId)
VALUES (2, 2);

INSERT INTO discussion (email, userdiscussion, discussiondate, discussiontime) VALUES
	('michaeldelcore@bigbadcorp.ca', 'Welcome to the new Big Bad Corp discussion website! If there is any feedback
		or features that you would like to see, feel free to post here!', '2020-11-29', '08:12:33'),
	('johnjoe@bigbadcorp.ca', 'It would be nice to be able to save important threads and get notifications when 
		someone posts in them.', '2020-11-29', '09:16:10'),
	('michaeldelcore@bigbadcorp.ca', 'Coming soon to a website near you!', '2020-11-29', '09:24:50');