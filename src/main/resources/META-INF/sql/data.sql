

INSERT INTO user (id, username, password, passwordConfirm, status, firstName, lastName, email, phoneNumber) VALUES (1,'john', '$2a$10$4bMJX7eR2fd2xiUSo/gtr.kci.jPY06N0THDnhjW/uB/jI7cKYetm', 'testtest','A' ,'john','Kebab', 'dupa@dup.dup', '65465465');


INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);

INSERT INTO therapist (id, firstName, lastName) VALUES (1, "Piotr", "Durzynski");
INSERT INTO therapist (id, firstName, lastName) VALUES (2, "John", "Kebab");
INSERT INTO therapist (id, firstName, lastName) VALUES (3, "Stasiu", "Hue");
INSERT INTO therapist (id, firstName, lastName) VALUES (4, "Kazimierz", "Wielki");

INSERT INTO patient (id, firstName, lastName, dateOfBirth, phoneNumber) VALUES (1, "John", "Kebab", "12-12-2007", "66666666");
INSERT INTO patient (id, firstName, lastName, dateOfBirth, phoneNumber) VALUES (2, "Pawel", "Cizemski", "01-12-1998", "77777777");
INSERT INTO patient (id, firstName, lastName, dateOfBirth, phoneNumber) VALUES (3, "Tomek", "Mariolski", "03-01-1995", "55555555");
INSERT INTO patient (id, firstName, lastName, dateOfBirth, phoneNumber) VALUES (4, "Mariusz", "Twardowski", "01-12-1985", "66666666");


INSERT INTO medicalHistory (id, patient_id, date, medication, treatment) VALUES (1, 1, "12-12-2018", "Ibuprofen, Apap", "Leczyc okladami");
INSERT INTO medicalHistory (id, patient_id, date, medication, treatment) VALUES (2, 1, "12-12-2018", "Strzykawka, Apap", "Operacja");

INSERT INTO visits (id, patient_id, therapist_id, date, type) VALUES (1, 1, 1, "12-12-2018", "Gabinet");
INSERT INTO visits (id, patient_id, therapist_id, date, type) VALUES (2, 1, 1, "12-12-2019", "Domowa");

INSERT INTO hypothesis (id, description, medicalHistory_id) VALUES (1, "Rak", 1);
INSERT INTO hypothesis (id, description, medicalHistory_id) VALUES (2, "Niewiadomo", 1);
INSERT INTO hypothesis (id, description, medicalHistory_id) VALUES (3, "Migrena", 2);
INSERT INTO hypothesis (id, description, medicalHistory_id) VALUES (4, "Acl", 2);
