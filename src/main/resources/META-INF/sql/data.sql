

INSERT INTO user (id, username, password, passwordConfirm, status, firstName, lastName, email, phoneNumber) VALUES (1,'john', '$2a$10$4bMJX7eR2fd2xiUSo/gtr.kci.jPY06N0THDnhjW/uB/jI7cKYetm', 'testtest','A' ,'john','Kebab', 'dupa@dup.dup', '65465465');
INSERT INTO user (id, username,	password, passwordConfirm, status, firstName, lastName, email, phoneNumber) VALUES (2,'userrole', '$2a$10$4bMJX7eR2fd2xiUSo/gtr.kci.jPY06N0THDnhjW/uB/jI7cKYetm', 'as','N','test','test', 'test@dusp.dsup', '65465465');


INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);

