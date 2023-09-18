<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calendário</title>
</head>
<body>
    <h1>Calendário</h1>
    <form action="CalendarioServlet" method="get">
        <label for="ano">Ano:</label>
        <input type="text" id="ano" name="ano" required>
        <label for="mes">Mês:</label>
        <input type="text" id="mes" name="mes" required>
        <input type="submit" value="Mostrar Calendário">
    </form>
</body>
</html>
