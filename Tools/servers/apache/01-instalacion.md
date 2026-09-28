## Instalación

  ```bash
  apt install apache2
  ```
## Iniciarlo
  ```bash
  sudo systemctl enable apache2
  sudo systemctl start apache2
  ```
## Detenerlo
  ```bash
  sudo systemctl stop apache2
  sudo systemctl status apache2
  ```

- **Directorio de configuracion de Apache**:
  ```bash
  cd /etc/apache2
  ```
- **Directorio raiz para archivos de contenido web que seran servidor por apache**
  ```bash
  cd /var/www/html
  ```
- **Otorgar permisos**:
  ```bash
  sudo chown -R yourUserName:yourUserName directorio
  sudo chmod 755 -R directorio
  ```