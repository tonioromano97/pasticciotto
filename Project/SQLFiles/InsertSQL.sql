																																			/* PASTICCERIA */
INSERT INTO `pasticciotto`.`Pasticceria`
(`nome`,
`indirizzo`,
`email`,
`telefono`,
`descrizione`,
`urlWebsite`,
`urlLogo`)
VALUES
('Dolci sapori', 'Via Roma, 359 84121 Salerno(SA)', 'dolci.sapori@mail.it', '0811234567','Antica pasticceria dal 1978 per assaporare i tradizionali e moderni dolci', 'http://www.dolci.sapori.it','img/dolciSapori.png');

INSERT INTO `pasticciotto`.`Pasticceria`
(`nome`,
`indirizzo`,
`email`,
`telefono`,
`descrizione`,
`urlWebsite`,
`urlLogo`)
VALUES
('DolciBuoni', 'Via Strada, 40 84121 Salerno(SA)', 'dolci.buoni@mail.it', '0811498567','Assapora i dolci con un gusto che non hai mai provato fino ad ora', 'http://www.dolci.buoni.it','img/dolciBuoni.png');

																																				/* UTENTE */

INSERT INTO `pasticciotto`.`Utente`
(`nome`,
`cognome`,
`email`,
`password`,
`telefono`,
`pasticceria`,
`ruolo`,
`numPrenotazioni`)
VALUES
('Antonio', 'Romano', 'antonio@mail.it', '123', '3471552459',1,'admin',1);


INSERT INTO `pasticciotto`.`Utente`
(`nome`,
`cognome`,
`email`,
`password`,
`telefono`,
`pasticceria`,
`ruolo`,
`numPrenotazioni`)
VALUES
('Giuseppe', 'Rossi', 'giuseppe.rossi@mail.it', '6C47D77D1C44E6A4243157B10B81E3B5', '3214567896',1,'admin',NULL);

INSERT INTO `pasticciotto`.`Utente`
(`nome`,
`cognome`,
`email`,
`password`,
`telefono`,
`pasticceria`,
`ruolo`,
`numPrenotazioni`)
VALUES
('Carlo', 'Neri', 'carlo.neri@mail.it', '25D55AD283AA400AF464C76D713C07AD', '3274367896',1,'cliente',2);

INSERT INTO `pasticciotto`.`Utente`
(`nome`,
`cognome`,
`email`,
`password`,
`telefono`,
`pasticceria`,
`ruolo`,
`numPrenotazioni`)
VALUES
('Mario', 'Verdi', 'mario.verdi@mail.it', '6C47D77D1C44E6A4243157B10B81E3B5', '3271143296',1,'magazziniere',NULL);

INSERT INTO `pasticciotto`.`Utente`
(`nome`,
`cognome`,
`email`,
`password`,
`telefono`,
`pasticceria`,
`ruolo`,
`numPrenotazioni`)
VALUES
('Pasquale', 'Bianchi', 'pasquale.bianchi@mail.it', '6C47D77D1C44E6A4243157B10B81E3B5', '3272987296',1,'pasticciere',NULL);

																																						/* ENTRATA */
                                                                                                                                                        
INSERT INTO `pasticciotto`.`Entrata`
(`descrizione`,
`data`,
`importo`,
`pasticceria`)
VALUES
('Cheesecake', '2018-12-31',30.25,'1');

INSERT INTO `pasticciotto`.`Entrata`
(`descrizione`,
`data`,
`importo`,
`pasticceria`)
VALUES
('Prenotazione cod. 1', '2019-01-11',45.50,'1');

INSERT INTO `pasticciotto`.`Entrata`
(`descrizione`,
`data`,
`importo`,
`pasticceria`)
VALUES
('Delizia al limone', '2019-01-11',15.50,'1');

INSERT INTO `pasticciotto`.`Entrata`
(`descrizione`,
`data`,
`importo`,
`pasticceria`)
VALUES
('Prenotazione cod. 2', '2019-01-21',55.80,'1');
																																
																																							/* USCITA */

INSERT INTO `pasticciotto`.`Uscita`
(`descrizione`,
`data`,
`importo`,
`tipo`,
`pasticceria`)
VALUES
('Acqua', '2018-10-22', 120.40, 'bolletta',1);

INSERT INTO `pasticciotto`.`Uscita`
(`descrizione`,
`data`,
`importo`,
`tipo`,
`pasticceria`)
VALUES
('Gas', '2018-11-10', 240.40, 'bolletta',1);

INSERT INTO `pasticciotto`.`Uscita`
(`descrizione`,
`data`,
`importo`,
`tipo`,
`pasticceria`)
VALUES
('Ordine A402', '2018-08-15', 780.40, 'fornitura',1);

																																						/* PRODOTTO */

INSERT INTO `pasticciotto`.`Prodotto`
(`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('Farina 1Kg', '30', '10', 0.50,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('Uova', '70', '20', 0.25,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('Burro 250gr', '45', '10', 0.45,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('Zucchero 500gr', '85', '10', 0.64,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('Lievito 25gr', '115', '10', 0.30,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('Cacao 500gr', '34', '5', 0.44,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('Limone', '25', '12', 1.00,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('Mascarpone 500gr', '12', '15', 0.67,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('Vaniglia 10gr', '125', '30', 1.55,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('Latte 5 lt', '35', '15', 3.40,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('Formaggio 200 gr', '37', '5', 1.50,1);

																																							/* RICETTA */

INSERT INTO `pasticciotto`.`Ricetta`
(`nome`,
`ore`,
`minuti`,
`prezzoVendita`,
`prezzoAcquisto`,
`pasticceria`
)
VALUES
('Millefoglie',2,30,15.50,7.82,1);

INSERT INTO `pasticciotto`.`Ricetta`
(`nome`,
`ore`,
`minuti`,
`prezzoVendita`,
`prezzoAcquisto`,
`pasticceria`)
VALUES
('Panna e nutella',1,30,18.10,8.80,1);

INSERT INTO `pasticciotto`.`Ricetta`
(`nome`,
`ore`,
`minuti`,
`prezzoVendita`,
`prezzoAcquisto`,
`pasticceria`)
VALUES
('Delizia al limone',2,0,10.00,6.07,2);

																																				/* PRODOTTO-RICETTA */
																																			
INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(1,1,2);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(1,2,5);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(1,3,2);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(1,4,0.5);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(1,8,1);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(1,10,0.2);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(1,11,2);
																										/*----------------------------------------------------------------*/
INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(2,1,1);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(2,2,3);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(2,4,0.5);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(2,7,5);


INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(2,10,0.2);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(2,9,1);

																										/*----------------------------------------------------------------*/
                                                                                                        
INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(3,1,2.5);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(3,2,5);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(3,3,1);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(3,4,1);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(3,8,1);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
(3,10,0.2);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES(3,6,2);

																																/* PRENOTAZIONE */																																			

INSERT INTO `pasticciotto`.`Prenotazione`
(`dataPrenotazione`,
`dataRitiro`,
`note`,
`effettuata`,
`utente`)
VALUES
('2018-12-24T14:32:00','2018-12-27T20:00:00','Scrivere auguri Fabio',true,'carlo.neri@mail.it');

INSERT INTO `pasticciotto`.`Prenotazione`
(`dataPrenotazione`,
`dataRitiro`,
`note`,
`effettuata`,
`utente`)
VALUES
('2019-01-23T10:02:00','2019-01-31T20:00:00','Da consegnare a domicilio',false,'carlo.neri@mail.it');

																														/* RICETTA_PRENOTAZIONE */
                                                                                                                        
INSERT INTO `pasticciotto`.`Ricetta_Prenotazione`
(`prenotazione`,
`ricetta`)
VALUES
(1,3);
                                                                                                                        
INSERT INTO `pasticciotto`.`Ricetta_Prenotazione`
(`prenotazione`,
`ricetta`)
VALUES
(2,2);		

INSERT INTO `pasticciotto`.`Ricetta_Prenotazione`
(`prenotazione`,
`ricetta`)
VALUES
(2,1);																																				