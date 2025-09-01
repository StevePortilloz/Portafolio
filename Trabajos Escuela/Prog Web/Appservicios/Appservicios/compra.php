<?php
require 'bd.php';  

// Iniciar sesión
session_start();
if (!isset($_SESSION['usuario_id']) || $_SESSION['rol'] != 'comprador') {
    header('Location: login.php');
    exit();
}

// Procesar la compra
if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['servicio_id'])) {
    $servicio_id = (int)$_POST['servicio_id'];
    $usuario_id = $_SESSION['usuario_id'];


    try {
        $sql = "INSERT INTO compras (usuario_id, servicio_id) VALUES (:usuario_id, :servicio_id)";
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':usuario_id', $usuario_id, PDO::PARAM_INT);
        $stmt->bindParam(':servicio_id', $servicio_id, PDO::PARAM_INT);
        $stmt->execute();

        echo "Compra realizada exitosamente. <a href='servicios.php'>Volver a los servicios</a>";
    } catch (PDOException $e) {
        echo "Error al procesar la compra: " . $e->getMessage();
    }
}


if (isset($_GET['id'])) {
    $servicio_id = (int)$_GET['id'];
    try {
        $sql = "SELECT s.*, u.nombre AS vendedor FROM servicios s 
                JOIN usuarios u ON s.usuario_id = u.id 
                WHERE s.id = :servicio_id";
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':servicio_id', $servicio_id, PDO::PARAM_INT);
        $stmt->execute();
        $servicio = $stmt->fetch(PDO::FETCH_ASSOC);

        if (!$servicio) {
            echo "Error: El servicio no existe o no está disponible.";
            exit();
        }
    } catch (PDOException $e) {
        echo "Error: No se pudo obtener el servicio. Detalles: " . $e->getMessage();
        exit();
    }
} else {
    echo "Error: Servicio no especificado.";
    exit();
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Comprar Servicio</title>
    <link rel="stylesheet" href="styles.css"> 
    <link rel="stylesheet" href="styles.css?v=<?php echo time(); ?>">
</head>
<body>
    <h2>Comprar Servicio</h2>
    <?php if (isset($servicio)): ?>
        <h3><?php echo htmlspecialchars($servicio['titulo']); ?></h3>
        <p><?php echo nl2br(htmlspecialchars($servicio['descripcion'])); ?></p>
        <p>Precio: $<?php echo number_format($servicio['precio'], 2); ?></p>
        <p>Vendedor: <?php echo htmlspecialchars($servicio['vendedor']); ?></p>

    
        <form action="compra.php" method="POST">
            <input type="hidden" name="servicio_id" value="<?php echo $servicio['id']; ?>">
            <button type="submit">Confirmar Compra</button>
        </form>
    <?php else: ?>
        <p>El servicio no está disponible o ha sido eliminado.</p>
    <?php endif; ?>
</body>
</html>
