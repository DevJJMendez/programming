- Actualizar sistema
```bash
sudo apt update
sudo apt upgrade
```
- Instalar
```bash
sudo apt install mysql-server
```

- Comprobar funcionamiento
```bash
sudo systemctl status mysql.service
```
- Iniciar el servicio
```bash
sudo systemctl start mysql.service
sudo systemctl enable mysql.service
```
- Establecer Usuario y Contraseña
```bash
sudo mysql

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'CONTRASEÑA';

exit;
```
- Instalar paquete de seguridad
```bash
sudo mysql_secure_installation
```
- Ingresar con usuario y contraseña
```bash
mysql -u root -p
```
- Creacion de prueba:
```mysql
CREATE DATABASE (base);
CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'contraseña';
GRANT ALL PRIVILEGES ON base.* TO 'usuario'@'localhost';
show databases;
```