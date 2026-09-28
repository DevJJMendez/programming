# Instalar PHP en Ubuntu

- Buscar extensiones disponibles: 
```bash
apt search php8.2
```

```bash
sudo add-apt-repository ppa:ondrej/php

sudo apt install openssl php8.2 php8.2-cli php8.2-common php8.2-bcmath php8.2-curl php8.2-mbstring php8.2-mysql php8.2-tokenizer php8.2-xml php8.2-zip php8.2-dom php8.2-gd php8.2-fpm php8.2-phpdbg php8.2-cgi php8.2-xdebug libapache2-mod-php8.2 libphp8.2-embed

sudo update-alternatives --config php
```
- Instalar Composer:

```bash
php -r "copy('https://getcomposer.org/installer', 'composer-setup.php');"
php -r "if (hash_file('sha384', 'composer-setup.php') === 'dac665fdc30fdd8ec78b38b9800061b4150413ff2e3b6f88543c636f7cd84f6db9189d43a81e5503cda447da73c7e5b6') { echo 'Installer verified'; } else { echo 'Installer corrupt'; unlink('composer-setup.php'); } echo PHP_EOL;"
php composer-setup.php
php -r "unlink('composer-setup.php');"
```
```php
sudo mv composer.phar /usr/local/bin/composer
```

- problemas con php.ini:

  - agregar estas lineas en `etc/php/phpnumerodeversion`:
 
  ```php
  extension=xmlwriter.so
  extension=xml.so
  extension=xmlreader.so
  ```
como hago para especificar la version de laravel a descargar con este comando:
```php
sudo apt-get install php-xml
```