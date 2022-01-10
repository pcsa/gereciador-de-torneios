create table USERS(
	id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
	psw VARCHAR(255) NOT NULL
)

create table Torneios(
	id SERIAL PRIMARY KEY,
	owner INT references USERS (id),
	title varchar(255),
    times varchar(255)
);