*DESCRIPCION: API para manejar una lista de franquicias, Una franquicia se compone por un nombre y una lista de
sucursales y, a su vez, una sucursal está compuesta por un nombre y un listado de productos ofertados en la sucursal.Un
El producto se compone de un nombre y una cantidad de Stock.

*FUNCIONES
Crear una nueva franquicia.
Obtener una lista de todas las franquicias.
Actualizar el nombre de una franquicia.
Eliminar una franquicia por su ID.
Crear Sucursal
Crear Producto
*ESQUEMA
![SCHEMA](images/1.png)
SOLUCIÓN
1. El proyecto debe ser desarrollado en Sprint Boot 
![1](images/2.png)
2. Exponer endpoint para agregar una nueva franquicia
![2](images/3.png)
![3](images/4.png)
3. Exponer endpoint para agregar una nueva sucursal a la franquicia
![4](images/5.png)
![5](images/6.png)
4. Exponer endpoint para agregar un nuevo producto a la sucursal
![6](images/7.png)
![6](images/8.png)
5. Exponer endpoint para eliminar un nuevo producto a una sucursal
![6](images/9.png)
6. Exponer endpoint para modificar un Stock de un nuevo producto
![RI9](images/10.png)
![RI9](images/11.png)
7. Exponer endpoint para agregar que permita mostrar cual es el producto que más stock 
tiene por sucursal para una 
franquicia puntual. Debe retomar un listado de productos que indiquen a que sucursal 
pertenece.
![RI9](images/12.png)
8. Utilizar sistemas de persistencia de datos como Redis, MySql, Mongo BD, Dynamo en 
algún proveedor de nube. (mysql)
![RI9](images/13.png)
9. +Plus si se expone endpoint que permita actualizar el nombre de la franquicia.
![RI9](images/14.png)
![RI9](images/15.png)
10. +Plus si se expone endpoint que permita actualizar el nombre de la sucursal.
![RI9](images/16.png)
![RI9](images/17.png)
11. +Plus si se expone endpoint que permita actualizar el nombre del producto.
![RI9](images/18.png)
![RI9](images/19.png)
12. +ELIMINAR FRANQUICIA.
![RI9](images/20.png)
12. +CONSULTAR FRANQUICIA.
![RI9](images/21.png)

PARA PROBAR:


CLONAR PROYECTO,CREAR BD,AJUSTAR application.properties con puerto y usuario

SQL.
create database franquiciasapi;
use franquiciasapi;
SELECT*FROM FRANQUICIA;
SELECT*FROM SUCURSAL;
SELECT*FROM PRODUCTO
