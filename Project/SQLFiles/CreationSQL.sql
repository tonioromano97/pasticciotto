CREATE DATABASE pasticciotto;

USE pasticciotto;


CREATE TABLE Pasticceria
(
	id int primary key auto_increment,
	nome varchar(30) not null,
    indirizzo varchar(100) not null,
    email varchar(30),
    telefono varchar(12),
    descrizione varchar(500),
    urlWebsite varchar(60)
);

CREATE TABLE Utente
(
	nome varchar(30) not null,
    cognome varchar(30) not null,
    email varchar(30) primary key,
    password varchar(100) not null,
    telefono varchar(12),
    pasticceria int,
    ruolo varchar(20) not null,
    numPrenotazioni int,
    foreign key(pasticceria) references Pasticceria(id)
);

CREATE TABLE Entrata
(
	id int primary key auto_increment,
    descrizione varchar (50),
    data date,
    importo decimal(10,2),
    pasticceria int,
    foreign key(pasticceria) references Pasticceria(id)
);

CREATE TABLE Uscita
(
	id int primary key auto_increment,
    descrizione varchar (50),
    data date,
    importo decimal(10,2),
    tipo varchar(30),
    pasticceria int,
    foreign key(pasticceria) references Pasticceria(id)
);

CREATE TABLE Prenotazione
(
	codice varchar(10) primary key,
    dataPrenotazione datetime not null,
    dataRitiro datetime not null,
    note varchar(100),
    effettuata boolean not null,
    utente varchar(30),
    foreign key(utente) references Utente(email)
);

CREATE TABLE Prodotto
(
	codice varchar(10) primary key,
    nome varchar(60) not null,
    quantita int not null,
    minScorta int, 
    prezzo decimal(10,2),
    pasticceria int,
    foreign key(pasticceria) references Pasticceria(id)
);

CREATE TABLE Ricetta
(
	nome varchar(30) primary key,
    tempoMedio time not null,
    prezzoVendita decimal (10,2),
    prezzoAcquisto decimal(10,2)
);

CREATE TABLE Prodotto_Ricetta
(
	ricetta varchar(30),
    prodotto varchar(10),
    quantita decimal(5,1) not null,
    primary key (ricetta,prodotto),
    foreign key(ricetta) references Ricetta(nome),
    foreign key(prodotto) references Prodotto(codice)
);

CREATE TABLE Ricetta_Prenotazione
(
	prenotazione varchar(10),
    ricetta varchar(30),
    primary key(prenotazione,ricetta),
    foreign key (prenotazione) references Prenotazione(codice),
    foreign key (ricetta) references Ricetta(nome)
);