# aplicacionweb1
Aplicación web sencilla usada como ejemplo para la materia **Desarrollo de Aplicaciones de Escritorio y Web Usando Java** de la **Escuela de Ingeniería de Telecomunicaciones de la UCAB**

## Comenzando
Estas instrucciones le permitirán tener una copia del proyecto realizado en clase, para que pueda manipularlo en su propia máquina, con propósito de estudiarlo, modificarlo o mejorarlo. Ver las notas de despliegue de cómo hacerlo funcionar en el Payara Server.

### Instalación
Para tener el proyecto en su máquina de forma local, debe hacer lo siguiente:
* Usar la dirección indicada para descargar el proyecto en formato zip
* A continuación descomprima el archivo descargado en el directorio de su elección
* Abrir Netbeans y con la opción usar la opción New Project -> Web -> Web Application with Existing Sources
* Darle <next> hasta que complete todos los pasos
* A continuación abra su gestor de MySQL (MySQL workbench o PHPmyAdmin)
* Cree una base de datos llamada **aplicacion**
* Ubique en la carpeta **docs** de proyecto descargado un archivo llamado **aplicacion.sql**
* Use la opción importar de su gestor de base de datos e importe este archivo, así tendrá disponible los datos de la base de datos del proyecto
* Ubique el sitio donde tiene instalado el servidor Payara y busque la carpeta **bin**, desde alli abrá una ventana de comando y ejecute el comado:
```
asadmin start-domain
```
de esta manera estará ejecutando el arranque del servidor
* Una vez que el servidor haya arrancado, en el navegador vaya a la dirección *http://localhost:4848*, de esta manera se abrirá la consola del administrador del servidor
* En el menú de administración del Payara ubique la opción **Resources**, e importe el archivo **glassfish-resources.xml** que se encuentra en la carpeta *web/WEB_INF* del proyecto descargado. Al ejecutarlo tendrá definido el *JDBC connectionPool* y el *JDBC Resource* que necesita para que Payara administre las conexiones a la base de datos del proyecto.
* Ahora registre el servidor Payara en el Netbeans, tal como se hizo en la clase
* Por último despliegue la aplicación usando la opción del menú contextual **Deploy** (para tener acceso al menú contextual haga click derecho sobre el proyecto cargado en Netbeans y este aparecerá)
* Listo dirígase al navegador y coloque la dirección *http://localhost:8080/aplicacionweb1* y ya debería ver l aforma de ingreso a la misma.

## Licencia
Este proyecto está licenciado bajo la licencia MIT license - ver el archivo [LICENSE.md](LICENSE.md) para detalles
