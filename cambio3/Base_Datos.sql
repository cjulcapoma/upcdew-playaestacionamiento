Create Table Cliente(
	Id_Cliente Varchar(18) Primary Key,
	Dni_Cliente Varchar(18),
	Nombre Varchar(50),
	Direccion Varchar(50),
	Telefono Varchar(50),
	Tipo_Cliente Varchar(1),
	Estado Varchar(2), 
	Password Varchar(30)
)
;
Create Table Tarjeta(
    Id_Tarjeta Varchar(18) Primary Key,
    Nro_Tarjeta Varchar(18) not null,
    Saldo_Disponible Numeric(9,2),
    Id_Cliente Varchar(18)
)
;

Create Table Local(
    Id_Local Varchar(18) Primary Key,
    Nombre Varchar(50),
    Direccion Varchar(50),
    Telefono Varchar(50),
    Cantidad_Espacios Int,
    Tolerancia Int,
    Precio_x_Hora Numeric(9,2),
    Porc_Desc_Tarjeta Numeric(9,2)
)
;
Create Table Espacio(
    Id_Espacio Varchar(18),
    Estado Varchar(2),
    Descripcion Varchar(20),
    Id_Local Varchar(18)
)
;

Create Table Alquiler(
    Id_Alquiler Varchar(18),
    Fecha Date,
    Hora_Inicio Varchar(5),
    Hora_Fin Varchar(5),
    Placa Varchar(10),
    Importe Numeric(9,2),
    Id_Local Varchar(18),
	Id_Tarjeta Varchar(18)
)
;
Create Table Abono(
    Id_Abono Varchar(18) Primary Key,
    Monto Numeric(9,2),
    Fecha_Inicio Date,
    Fecha_Fin Date,
    Id_Cliente Varchar(18) ,
    Id_Espacio Varchar(18),
    Tipo_Abono  Varchar(1)
)
;
Create Table Usuario(
    Id_Usuario Varchar(18) Primary Key,
    Nombre Varchar(18),
    Password Varchar(18)
)
;

create view Consulta_saldos
as
select c.id_cliente,c.nombre,t.nro_tarjeta,a.MONTO
,a.FECHA_INICIO,a.FECHA_FIN
from tarjeta t, cliente c,abono a
where a.ID_CLIENTE=c.id_cliente
and c.id_cliente=t.id_cliente
;

create  view consulta_ingresosalida
as
select l.id_local,l.nombre nombre_local, e.id_cliente, e.id_tarjeta, e.nombre_cliente,
a.fecha, a.hora_inicio,a.hora_fin, a.placa,e.nro_tarjeta,a.id_alquiler, a.importe
from alquiler a  left join (
select c.id_cliente, t.id_tarjeta, c.nombre nombre_cliente,t.nro_tarjeta
from tarjeta t, cliente c
where t.id_cliente=c.id_cliente) e on e.ID_tarjeta=a.id_tarjeta
,local l
where l.id_local=a.ID_LOCAL
;

create view consulta_movimientos
as
select c.id_cliente,c.nombre,t.nro_tarjeta,a.MONTO
,a.FECHA_INICIO,a.FECHA_FIN
from tarjeta t, cliente c,abono a
where a.ID_CLIENTE=c.id_cliente
and c.id_cliente=t.id_cliente
;


-- INSERT --

-- INSERT
INSERT INTO DEW.LOCAL values ('1', 'LOCAL SAN BORJA', 'SAN BORJA NORTE 1020', '444-4444',50,15,9,0.15);

-- insert usuarios
insert into DEW.USUARIO values ('omonroy','omonroy','omonroy',1);
insert into DEW.USUARIO values ('oalvarez','oalvarez','oalvarez',1 );
insert into DEW.USUARIO values ('cjulcapoma','cjulcapoma','cjulcapoma',1 );

-- insert cliente
insert into DEW.CLIENTE values ('1', '43633724', 'Yomaira Monroy', 'Callao', '4534985','P','A','123');

--INSERT TARJETA
INSERT INTO DEW.TARJETA VALUES ('1','123456789123456789', 149.8,'1');

-- INSERT ESPACIO
INSERT INTO DEW.ESPACIO VALUES ( '1', '2','ESPACIO 1','1');
--INSERT ABONO
INSERT INTO DEW.ABONO VALUES ('1',100, '2010-06-01', '2010-06-30','1','1','1');