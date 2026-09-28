# Pull Requets
Una Pull Request (PR) es una solicitud para fusionar cambios de una rama a otra en un repositorio. Se usa en GitHub, GitLab y Bitbucket para revisión de código, asegurando calidad y colaboración antes de integrar cambios en la rama principal (main o develop).

## Creando una Pull Request en GitHub
1. Crear una rama de trabajo
```bash
git checkout -b feature/nueva-funcionalidad
```
Siempre trabaja en una rama separada para cambios específicos.

2. Hacer commits con los cambios
```bash
git add .
git commit -m "Añadiendo la nueva funcionalidad X"
```

3. Subir los cambios al repositorio remoto
```bash
git push origin feature/nueva-funcionalidad
```