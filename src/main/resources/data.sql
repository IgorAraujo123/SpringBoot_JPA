create table tb_cidade(
   id_cidade bigint not null primary key,
   nome varchar(50) not null,
   qtd_habitantes bigint
);

insert into tb_cidade
   (id_cidade,nome,qtd_habitantes)
values
   (1, 'São Paulo', 213123123),
   (2, 'Rio de Janeiro', 12321331),
   (3, 'Fortaleza', 123213),
   (4, 'Salvador', 7575675),
   (5, 'Belo Horizonte', 978538),
   (6, 'Porto Alegre', 162074),
   (7, 'Porto Velho', 695477),
   (8, 'Palmas', 6785309),
   (9, 'Recife', 335454222),
   (10, 'Natal', 8788644),
   (11, 'Brasilia', 097890955)
   ;