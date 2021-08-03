--entity
create table amministratore(
    nome varchar2(30) not null,
    cognome varchar2(30) not null,
    codice int,
    constraint p_admin primary key(codice)
);

create table corsista(
    nomecorsista varchar2(30) not null,
    cognomecorsista varchar2(30) not null,
    codcorsista int,
    precedentiformativi int default 0,
    constraint p_corsista primary key(codcorsista)
);

create table docente(
    nomedocente varchar2(30) not null,
    cognomedocente varchar2(30) not null,
    cvdocente varchar2(50),
    coddocente int,
    constraint p_docente primary key(coddocente)
);

create table corso(
    codcorso int,
    nomecorso varchar2(30) not null,
    datainiziocorso date not null,
    datafinecorso date not null,
    costocorso number(8,2) not null,
    commenticorso varchar2(200),
    aulacorso varchar2(30),
    coddocente int,
    constraint p_corso primary key(codcorso),
    constraint f_docente foreign key(coddocente) references docente(coddocente) on delete cascade
);

create table corso_corsista(
    codcorso int,
    codcorsista int,
    constraint f_corso foreign key(codcorso) references corso(codcorso) on delete cascade,
    constraint f_corsista foreign key(codcorsista) references corsista(codcorsista) on delete cascade,
    constraint p_corso_corsista primary key(codcorso,codcorsista)
);

--sequences
create sequence corsista_seq;
create sequence corso_seq;