<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calend�rio</title>
</head>
<body>
    <h1>Calend�rio</h1>
    <form action="CalendarioServlet" method="get">
        <label for="ano">Ano:</label>
        <input type="text" id="ano" name="ano" required>
        <label for="mes">M�s:</label>
        <input type="text" id="mes" name="mes" required>
        <input type="submit" value="Mostrar Calend�rio">
    </form>
</body>
</html>
