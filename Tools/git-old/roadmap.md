# Nivel 1: Fundamentos de Git (Principiante)
* Conceptos clave: Repositorio, commit, branch, merge, remote, tracking.
* Instalación y configuración: git config --global user.name "Tu Nombre"
* Comandos básicos:

  * git init → Inicializar un repositorio
  * git clone <repo> → Clonar un repositorio
  * git status → Ver cambios en el repositorio
  * git add . → Añadir cambios al área de staging
  * git commit -m "Mensaje" → Confirmar cambios
  * git log → Ver historial
  * git diff → Ver diferencias

Objetivo: Ser capaz de inicializar un repositorio, hacer commits y entender el historial de cambios.


# Nivel 2: Trabajo con Ramas (Intermedio)
git branch <nombre> → Crear una nueva rama
git checkout <nombre> → Cambiar de rama
git checkout -b <nombre> → Crear y cambiar de rama
git branch -d <nombre> → Eliminar una rama

🔹 Fusión de ramas (Merging & Rebasing):
git merge <branch> → Fusionar ramas
git rebase <branch> → Reaplicar cambios sobre otra rama

🔹 Resolución de conflictos:
Identificar conflictos
Editar archivos manualmente
git add . && git commit para confirmar la resolución

Objetivo: Ser capaz de trabajar con múltiples ramas y resolver conflictos de merge.

# Nivel 3: Git Avanzado
🔹 Git Reset vs Git Revert
git reset --hard <commit> → Deshacer cambios (peligroso)
git reset --soft <commit> → Mantener cambios en staging
git revert <commit> → Crear un commit inverso

🔹 Cherry-picking y Stashing
git cherry-pick <commit> → Aplicar un commit específico en otra rama
git stash / git stash pop → Guardar/restaurar cambios temporales

🔹 Tags y Versioning
git tag -a v1.0 -m "Versión 1.0"
git push origin --tags

Objetivo: Dominar la manipulación de commits y aprender técnicas avanzadas de Git.

# Nivel 4: Git en un Entorno Profesional (GitHub & Workflows)
🔹 Trabajo con remotos (GitHub, GitLab, Bitbucket)
git remote add origin <URL>
git push -u origin main
git pull origin main

🔹 GitFlow (Flujo de ramas profesional)
main → Producción
develop → Desarrollo
feature/* → Nuevas funcionalidades
release/* → Versiones listas para producción
hotfix/* → Correcciones urgentes

🔹 Pull Requests & Code Reviews
Crear un Pull Request (PR) en GitHub
Realizar un Code Review
Hacer un Squash & Merge

Objetivo: Dominar GitHub y aprender a colaborar en proyectos grandes con GitFlow y revisiones de código.

# Nivel 5: Git en CI/CD & Automación (DevOps)
🔹 GitHub Actions
Crear workflows automáticos con .github/workflows
Ejecutar CI/CD en cada push
Integración con Docker, Kubernetes, Terraform

🔹 Hooks de Git
pre-commit, pre-push → Automatizar validaciones

🔹 Monorepos y Submódulos
git submodule add <repo>
Monorepos en equipos grandes

Objetivo: Integrar Git en pipelines de CI/CD y optimizar workflows con GitHub Actions y hooks.