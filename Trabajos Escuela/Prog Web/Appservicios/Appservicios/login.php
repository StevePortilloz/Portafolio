<?php
require 'bd.php';
session_start();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    
    $correo = filter_var($_POST['email'], FILTER_SANITIZE_EMAIL);  
    $password = $_POST['password'];

    try {
       
        $sql = "SELECT * FROM usuarios WHERE email = :correo";  
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':correo', $correo);
        $stmt->execute();
        $usuario = $stmt->fetch(PDO::FETCH_ASSOC);  

        
        if ($usuario) {
            
            if (password_verify($password, $usuario['password'])) {
                // Iniciar sesión
                $_SESSION['usuario_id'] = $usuario['id'];  
                $_SESSION['user_name'] = $usuario['nombre']; 
                $_SESSION['rol'] = $usuario['rol'];  

                // Redirigir al dashboard según el rol
                if ($_SESSION['rol'] === 'vendedor') {
                    header('Location: dashboard.php');  
                } else {
                    header('Location: dashboard.php');  
                }
                exit();  
            } else {
                
                echo "<p style='color: red;'>Correo o contraseña incorrectos.</p>";
            }
        } else {
            
            echo "<p style='color: red;'>Correo o contraseña incorrectos.</p>";
        }
    } catch (PDOException $e) {
        
        echo "<p style='color: red;'>Ha ocurrido un error al intentar iniciar sesión. Intente más tarde.</p>";
        
    }
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="styles.css?v=<?php echo time(); ?>"> 
</head>
<body>
    <h2>Iniciar Sesión</h2>
    <form action="login.php" method="POST">
        <label for="email">Correo electrónico:</label>
        <input type="email" name="email" required><br>

        <label for="password">Contraseña:</label>
        <input type="password" name="password" required><br>

        <button type="submit">Iniciar Sesión</button>
    </form>
    <p>¿No tienes una cuenta? <a href="registro.php">Regístrate aquí</a></p>
</body>
</html>
