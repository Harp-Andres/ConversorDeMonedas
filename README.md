# Proyecto: Conversor de Monedas Online

## Descripción
Este proyecto es una aplicación de consola en Java que permite realizar conversiones de monedas utilizando una API de tasas de cambio. Los usuarios pueden:
- Consultar tasas de cambio de una moneda base.
- Especificar una moneda objetivo y un monto a convertir.
- Ver las monedas disponibles para la conversión.
- Guardar los resultados de las conversiones en un archivo JSON.

## Características
1. **Interfaz interactiva**: El usuario ingresa los códigos de las monedas y el monto para realizar las conversiones.
2. **Consumo de API HTTP**: Obtiene tasas de cambio en tiempo real utilizando peticiones HTTP.
3. **Manejo de JSON**: Procesa respuestas en formato JSON utilizando la librería Gson.
4. **Generación de archivos**: Guarda los datos de las conversiones en archivos JSON.

## Requisitos
- **Java 11** o superior.
- Librerías:
  - `java.net.http` (para manejar peticiones HTTP).
  - Gson (para manejar JSON).
- Conexión a Internet para acceder a la API.

## Estructura del Proyecto
### Clase Principal: `Principal`
Esta clase gestiona el flujo principal de la aplicación:
1. Solicita al usuario el código de la moneda base.
2. Realiza una petición HTTP para obtener las tasas de cambio.
3. Muestra las monedas disponibles y solicita la moneda objetivo.
4. Solicita el monto a convertir y calcula el resultado.
5. Guarda los resultados en un archivo JSON.

### Clases Auxiliares
1. **`SolicitudClienteHTTP`**: Construye y envía solicitudes HTTP a la API.
2. **`RespuestaHTTP`**: Procesa las respuestas HTTP y convierte el JSON en objetos Java.
3. **`ConversionMoneda`**: Modelo que representa la estructura del JSON recibido.
4. **`ConversionEspecificaDos`**: Realiza la conversión específica entre dos monedas.
5. **`GeneradorDeArchivo`**: Genera archivos JSON para guardar los resultados.

## Flujo de Uso
1. Al iniciar, el programa muestra un mensaje de bienvenida:
   ```
   Bienvenido a su conversor de monedas Online!!!
   ```
2. Solicita al usuario el código de la moneda base:
   ```
   Escriba el codigo de la moneda base que quiere convertir:
   ```
3. Realiza una petición a la API y muestra las monedas disponibles para la conversión.
4. Solicita la moneda objetivo y el monto a convertir.
5. Muestra el resultado y permite guardar los datos en un archivo JSON.
6. Permite continuar con otra conversión o salir de la aplicación escribiendo "Salir".

## Ejemplo de Uso
Entrada:
```
Escriba el codigo de la moneda base que quiere convertir:
USD
Monedas de cambio disponibles para la conversion: [EUR, JPY, GBP, ...]
Escriba el codigo de la moneda a la que quiere convertir:
EUR
Indique el valor a convertir:
100
Si desea continuar en el conversor de monedas presione enter de lo contrario ingrese salir:
```
Salida:
```
Resultado: 100 USD = 92.75 EUR
Datos guardados en archivo JSON.
```

## Errores Comunes
1. **Código de moneda no válido**:
   El programa lanza una excepción si el código de moneda ingresado no es reconocido por la API.
2. **Conexión fallida**:
   Asegúrate de tener acceso a Internet y que la URL de la API esté correctamente configurada.

## Tecnologías Usadas
- **Java 11**
- **Gson** para parseo y manipulación de JSON
- **java.net.http** para manejo de solicitudes HTTP

## Instalación y Ejecución
1. Clonar el repositorio:
   ```bash
   https://github.com/Harp-Andres/ConversorDeMonedas.git
   ```
2. Importar el proyecto en un IDE como IntelliJ IDEA o Eclipse.
3. Asegurarse de agregar Gson al classpath.
4. Ejecutar la clase `Principal`.

## Contribución
Si deseas contribuir:
1. Haz un fork del repositorio.
2. Crea una nueva rama para tu función o arreglo de bug.
3. Realiza un pull request describiendo tus cambios.

## Autor
Hardware Andres Rodriguez

---

Este proyecto es un ejemplo educativo para aprender sobre el consumo de APIs en Java y el manejo de datos en formato JSON.


