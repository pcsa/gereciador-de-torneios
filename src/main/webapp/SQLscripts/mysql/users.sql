CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `psw` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


create table torneios(
	id int not null auto_increment,
  owner int not null,
	title varchar(255),
  times varchar(255),
  primary key(id),
  FOREIGN KEY (owner) REFERENCES users(id)
);