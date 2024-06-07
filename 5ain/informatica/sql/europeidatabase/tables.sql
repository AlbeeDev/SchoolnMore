create table nazionali(
    id_nazionale int primary key auto_increment,
    nome varchar(50)
)

europei2024> create table giocatori(
                 id_giocatore int primary key auto_increment,
                 nome_cognome varchar(50),
                 gol_totali int,
                 id_nazione int,
                 foreign key (id_nazione) REFERENCES nazionali(id_nazionale) 
             )

europei2024> create table partita(
                 id_partita int primary key auto_increment,
                 data date,
                 stadio varchar(50),
                 tipo varchar(50),
                 id_nazione1 int,
                 id_nazione2 int,
                 foreign key (id_nazione1) REFERENCES nazionali(id_nazionale),
                 foreign key (id_nazione2) REFERENCES nazionali(id_nazionale) 
             )

europei2024> create table gol(
                 id_gol int primary key auto_increment,
                 minuto int,
                 id_giocatore int,
                 id_partita int,
                 foreign key (id_giocatore) references giocatori(id_giocatore),
                 foreign key (id_partita) references  partita(id_partita)
             )