# Instalaciones necesarias:

- php
- laragon / xaamp
- composer
- npm (nvm recomendado)

# Creación de una aplicación Laravel


* **Usando Composer**

    ```bash
    composer create-project laravel/laravel nombre_del_proyecto
    ```

* Version especifica:
    
    ```bash
    composer create-project laravel/laravel:^10.0 nombre_del_proyecto
    ```    

* levantar servidor:

    ```bash
    php artisan serve
    ```

* **Usando Artisan (Opcional)**

  * Instalacion global de Laravel: este comando de utiliza una sola vez_

    ```bash
    composer global require laravel/installer
    ```

* Crear un Nuevo Proyecto Laravel:

    ```bash
    laravel new nombre_del_proyecto
    ```

    ```bash
    php artisan serve
    ```


### Sail

- IR AL DIRECTORIO DEL PROYECTO Y CONFIGURE LOS PERMISOS CORRECTOS:
```bash
cd /var/www/html/project
sudo chown -R www-data:www-data .
sudo chmod -R 775 storage/
```

- CREAR ARCHIVO DE HOST VIRTUAL DE APACHE
```bash
cd /etc/apache2/sites-available/
```
```bash
sudo gedit laravel.conf
```

- Estructura
```bash
<VirtualHost *:80>
ServerName @localhost
DocumentRoot /var/www/html/project/public

<Directory /var/www/html/project>
AllowOverride All
</Directory>

ErrorLog ${APACHE_LOG_DIR}/error.log
CustomLog ${APACHE_LOG_DIR}/access.log combined

</VirtualHost>
```

- HABILITE LA CONFIGURACION DE APACHE PARA LARAVEL.
```bash
sudo a2ensite laravel.conf
```

- VERIFICAMOS LA SINTAXIS
```bash
sudo apachectl -t
```

REINICIAR EL SERVICIO DE APACHE 

sudo systemctl reload apache2