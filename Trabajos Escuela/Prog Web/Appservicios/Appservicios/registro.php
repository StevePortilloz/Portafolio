<?php
require 'bd.php'; 

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    
    $nombre = htmlspecialchars(trim($_POST['nombre']));
    $email = filter_var(trim($_POST['email']), FILTER_SANITIZE_EMAIL);
    $password = password_hash(trim($_POST['password']), PASSWORD_DEFAULT); // Encriptación de la contraseña
    $rol = $_POST['rol']; 

   
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        echo "El correo electrónico no es válido.";
        exit;
    }

    try {
       
        $sql = "SELECT * FROM usuarios WHERE email = :email";
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':email', $email);
        $stmt->execute();

        if ($stmt->rowCount() > 0) {
            echo "Este correo ya está registrado.";
        } else {
           
            $sql = "INSERT INTO usuarios (nombre, email, password, rol) VALUES (:nombre, :email, :password, :rol)";
            $stmt = $conn->prepare($sql);
            
       
            $stmt->bindParam(':nombre', $nombre);
            $stmt->bindParam(':email', $email);
            $stmt->bindParam(':password', $password); 
            $stmt->bindParam(':rol', $rol);
            
            $stmt->execute();

            echo "Registro exitoso. <a href='login.php'>Iniciar sesión</a>";
        }
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro - Contraseña</title>
    <link rel="stylesheet" href="styles.css"> 
</head>
<body>
    <h2>Registro</h2>
    <form action="registro.php" method="POST">
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" required><br>

        <label for="email">Correo electrónico:</label>
        <input type="email" name="email" required><br>

        <label for="password">Contraseña:</label>
        <input type="password" name="password" required><br>

        <label for="rol">Rol:</label>
        <select name="rol" required>
            <option value="vendedor">Vendedor</option>
            <option value="comprador">Comprador</option>
        </select><br>

        <button type="submit">Registrarse</button>
    </form>
</body>
<footer>
        <p>&copy; 2024 Cashi2| Todos los derechos reservados</p>
    </footer>
</html>
