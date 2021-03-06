-- tabela que sera carregada com os clientes 
create table if not exists clientes (
    id_cliente int (9) primary key,
    nome varchar(100),
    CPF varchar (11),
    data_nascimento datetime,
    genero varchar(1)
);


-- tabela que sera carregada com os produtos 
create table if not exists produtos(		
    id_produto int (9) primary key,
    nome varchar (100),
    valor varchar (20)
);

-- tabela que será carregada com as compras
create table if not exists vendas (
    id     int auto_increment primary key,
    sku_produto    int (9) ,
    codigo_cliente int(9),
    valor_venda    numeric(10,2),
    qtd_produto    int (9)
);

-- Insert's tabela clientes
insert into clientes values (123456789,'Pedro Mesquita','44455566677','19970618','M');
insert into clientes values (987654321,'Luiz Berber','64735635443','19970618','M');
insert into clientes values (123456789,'Bruna Ferreira','67823454332','19810618','F');
insert into clientes values (324534554,'Eliete Mesquita','09874632412','20000512','F');
insert into clientes values (325254353,'Oscar Antonio','09878967532','19950110','M');

-- Insert's tabela produtos
insert into produtos values (519988893, 'Sapato','100');
insert into produtos values (515554667, 'camisa','30');
insert into produtos values (516575567, 'caneta','50');
insert into produtos values (514353543, 'celular','500');
insert into produtos values (517867887, 'meia','10');
