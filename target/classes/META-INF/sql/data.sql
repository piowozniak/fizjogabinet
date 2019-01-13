

INSERT INTO user (id, username, password, passwordConfirm, status, firstName, lastName, email, phoneNumber) VALUES (1,'john', '$2a$10$4bMJX7eR2fd2xiUSo/gtr.kci.jPY06N0THDnhjW/uB/jI7cKYetm', 'testtest','A' ,'john','Kebab', 'dupa@dup.dup', '65465465');


INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');


INSERT INTO user_role (user_id, role_id) VALUES (1, 1);

INSERT INTO therapist (id, firstName, lastName) VALUES (1, "Piotr", "Durzynski");
INSERT INTO therapist (id, firstName, lastName) VALUES (2, "John", "Kebab");
INSERT INTO therapist (id, firstName, lastName) VALUES (3, "Stasiu", "Hue");
INSERT INTO therapist (id, firstName, lastName) VALUES (4, "Kazimierz", "Wielki");


