																																			/* PASTICCERIA */

INSERT INTO `pasticciotto`.`Pasticceria`
(`nome`,
`indirizzo`,
`email`,
`telefono`,
`descrizione`,
`urlWebsite`)
VALUES
('Dolci sapori', 'Via Roma, 359 84121 Salerno(SA)', 'dolci.sapori@mail.it', '0811234567','Antica pasticceria dal 1978 per assaporare i tradizionali e moderni dolci', 'http://www.dolci.sapori.it');

INSERT INTO `pasticciotto`.`Pasticceria`
(`nome`,
`indirizzo`,
`email`,
`telefono`,
`descrizione`,
`urlWebsite`)
VALUES
('DolciBuoni', 'Via Strada, 40 84121 Salerno(SA)', 'dolci.buoni@mail.it', '0811498567','Assapora i dolci con un gusto che non hai mai provato fino ad ora', 'http://www.dolci.buoni.it');

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
(`codice`,
`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('P00001', 'Farina 1Kg', '30', '10', 0.50,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`codice`,
`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('P00002', 'Uova', '70', '20', 0.25,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`codice`,
`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('P00003', 'Burro 250gr', '45', '10', 0.45,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`codice`,
`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('P00004', 'Zucchero 500gr', '85', '10', 0.64,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`codice`,
`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('P00005', 'Lievito 25gr', '115', '10', 0.30,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`codice`,
`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('P00006', 'Cacao 500gr', '34', '5', 0.44,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`codice`,
`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('P00007', 'Limone', '25', '12', 1.00,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`codice`,
`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('P00008', 'Mascarpone 500gr', '12', '15', 0.67,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`codice`,
`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('P00009', 'Vaniglia 10gr', '125', '30', 1.55,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`codice`,
`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('P00010', 'Latte 5 lt', '35', '15', 3.40,1);

INSERT INTO `pasticciotto`.`Prodotto`
(`codice`,
`nome`,
`quantita`,
`minScorta`,
`prezzo`,
`pasticceria`)
VALUES
('P00011', 'Formaggio 200 gr', '37', '5', 1.50,1);

																																							/* RICETTA */

INSERT INTO `pasticciotto`.`Ricetta`
(`nome`,
`tempoMedio`,
`prezzoVendita`,
`prezzoAcquisto`)
VALUES
('Cheesecake','02:30:00',15.50,7.82);

INSERT INTO `pasticciotto`.`Ricetta`
(`nome`,
`tempoMedio`,
`prezzoVendita`,
`prezzoAcquisto`)
VALUES
('Delizia al limone','01:30:00',18.10,8.80);

INSERT INTO `pasticciotto`.`Ricetta`
(`nome`,
`tempoMedio`,
`prezzoVendita`,
`prezzoAcquisto`)
VALUES
('Pingui','02:00:00',10.00,6.07);

																																				/* PRODOTTO-RICETTA */
																																			
INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Cheesecake','P00001',2);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Cheesecake','P00002',5);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Cheesecake','P00003',2);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Cheesecake','P00004',0.5);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Cheesecake','P00008',1);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Cheesecake','P00010',0.2);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Cheesecake','P00011',2);
																										/*----------------------------------------------------------------*/
INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Delizia al limone','P00001',1);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Delizia al limone','P00002',3);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Delizia al limone','P00004',0.5);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Delizia al limone','P00007',5);


INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Delizia al limone','P00010',0.2);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Delizia al limone','P00009',1);

																										/*----------------------------------------------------------------*/
                                                                                                        
INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Pingui','P00001',2.5);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Pingui','P00002',5);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Pingui','P00003',1);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Pingui','P00004',1);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Pingui','P00008',1);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES
('Pingui','P00010',0.2);

INSERT INTO `pasticciotto`.`Prodotto_Ricetta`
(`ricetta`,
`prodotto`,
`quantita`)
VALUES('Pingui','P00006',2);

																																/* PRENOTAZIONE */																																			

INSERT INTO `pasticciotto`.`Prenotazione`
(`codice`,
`dataPrenotazione`,
`dataRitiro`,
`note`,
`effettuata`,
`utente`)
VALUES
('00001','2018-12-24T14:32:00','2018-12-27T20:00:00','Scrivere auguri Fabio',true,'carlo.neri@mail.it');

INSERT INTO `pasticciotto`.`Prenotazione`
(`codice`,
`dataPrenotazione`,
`dataRitiro`,
`note`,
`effettuata`,
`utente`)
VALUES
('00002','2019-01-23T10:02:00','2019-01-31T20:00:00','Da consegnare a domicilio',false,'carlo.neri@mail.it');

																														/* RICETTA_PRENOTAZIONE */
                                                                                                                        
INSERT INTO `pasticciotto`.`Ricetta_Prenotazione`
(`prenotazione`,
`ricetta`)
VALUES
('00001','Pingui');
                                                                                                                        
INSERT INTO `pasticciotto`.`Ricetta_Prenotazione`
(`prenotazione`,
`ricetta`)
VALUES
('00002','Delizia al limone');		

INSERT INTO `pasticciotto`.`Ricetta_Prenotazione`
(`prenotazione`,
`ricetta`)
VALUES
('00002','Cheesecake');																																				