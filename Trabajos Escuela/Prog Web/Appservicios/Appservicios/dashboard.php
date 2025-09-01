<?php
require 'bd.php';
session_start();

if (!isset($_SESSION['usuario_id'])) {
    header('Location: login.php'); 
    exit;
}

$usuario_id = $_SESSION['usuario_id'];

try {
    $sql = "SELECT rol FROM usuarios WHERE id = :usuario_id";
    $stmt = $conn->prepare($sql);
    $stmt->bindParam(':usuario_id', $usuario_id);
    $stmt->execute();
    $usuario = $stmt->fetch(PDO::FETCH_ASSOC);
    $rol = $usuario['rol'];
} catch (PDOException $e) {
    echo "Error: " . $e->getMessage();
    exit;
}

if ($rol === 'vendedor' && $_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['accion']) && $_POST['accion'] === 'agregar') {
    $titulo = htmlspecialchars($_POST['titulo']);
    $descripcion = htmlspecialchars($_POST['descripcion']);
    $precio = $_POST['precio'];
    $categoria = htmlspecialchars($_POST['categoria']);
    $imagen = '';

    if (!empty($_FILES['imagen']['name'])) {
        $upload_dir = 'uploads/';
        $imagen = $upload_dir . basename($_FILES['imagen']['name']);
        move_uploaded_file($_FILES['imagen']['tmp_name'], $imagen);
    }

    try {
        $sql = "INSERT INTO servicios (titulo, descripcion, precio, categoria, usuario_id, imagen, estado) 
                VALUES (:titulo, :descripcion, :precio, :categoria, :usuario_id, :imagen, 'disponible')";
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':titulo', $titulo);
        $stmt->bindParam(':descripcion', $descripcion);
        $stmt->bindParam(':precio', $precio);
        $stmt->bindParam(':categoria', $categoria);
        $stmt->bindParam(':usuario_id', $usuario_id);
        $stmt->bindParam(':imagen', $imagen);
        $stmt->execute();

        echo "Servicio agregado exitosamente.";
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
}

if ($rol === 'vendedor' && $_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['accion']) && $_POST['accion'] === 'eliminar') {
    $servicio_id = $_POST['servicio_id'];
    try {
        $sql = "DELETE FROM servicios WHERE id = :servicio_id AND usuario_id = :usuario_id";
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':servicio_id', $servicio_id);
        $stmt->bindParam(':usuario_id', $usuario_id);
        $stmt->execute();

        echo "Servicio eliminado exitosamente.";
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
}

try {
    if ($rol === 'vendedor') {
        // Vendedores ven solo sus servicios
        $sql = "SELECT * FROM servicios WHERE usuario_id = :usuario_id";
    } else {
        // Compradores ven todos los servicios disponibles
        $sql = "SELECT servicios.*, usuarios.nombre AS vendedor 
                FROM servicios 
                INNER JOIN usuarios ON servicios.usuario_id = usuarios.id
                WHERE servicios.estado = 'disponible'";
    }
    $stmt = $conn->prepare($sql);
    if ($rol === 'vendedor') {
        $stmt->bindParam(':usuario_id', $usuario_id);
    }
    $stmt->execute();
    $servicios = $stmt->fetchAll(PDO::FETCH_ASSOC);
} catch (PDOException $e) {
    echo "Error: " . $e->getMessage();
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Servicios</title>
    <link rel="stylesheet" href="styles.css?v=<?php echo time(); ?>">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
</head>
<body>
    <h2><?php echo ($rol === 'vendedor') ? "Mis Servicios" : "Servicios Disponibles"; ?></h2>

    <div style="text-align: center; margin-bottom: 20px;">
        <a href="logout.php">
            <button style="background-color: #dc3545; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer;">
                Cerrar Sesión
            </button>
        </a>
    </div>

    <div class="container">
        <?php if ($rol === 'vendedor'): ?>
            <form action="dashboard.php" method="POST" enctype="multipart/form-data">
                <input type="hidden" name="accion" value="agregar">
                <label for="titulo">Título:</label>
                <input type="text" name="titulo" required>
                <label for="descripcion">Descripción:</label>
                <textarea name="descripcion" required></textarea>
                <label for="precio">Precio:</label>
                <input type="number" name="precio" step="0.01" required>
                <label for="categoria">Categoría:</label>
                <input type="text" name="categoria" required>
                <label for="imagen">Imagen:</label>
                <input type="file" name="imagen">
                <button type="submit">Agregar Servicio</button>
            </form>
        <?php endif; ?>

        <ul>
            <?php foreach ($servicios as $servicio): ?>
                <li>
                    <strong><?php echo $servicio['titulo']; ?></strong> - $<?php echo $servicio['precio']; ?><br>
                    <p><?php echo $servicio['descripcion']; ?></p>
                    <small>Categoría: <?php echo $servicio['categoria']; ?></small><br>
                    <?php if (!empty($servicio['imagen'])): ?>
                        <img src="<?php echo $servicio['imagen']; ?>" alt="Imagen del servicio">
                    <?php endif; ?>
                    <?php if ($rol === 'comprador'): ?>
                        <small>Vendedor: <?php echo $servicio['vendedor']; ?></small><br>
                        <a href="compra.php?id=<?php echo $servicio['id']; ?>">
                            <button>Comprar</button>
                        </a>
                    <?php endif; ?>
                    <?php if ($rol === 'vendedor'): ?>
                        <form action="dashboard.php" method="POST">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="servicio_id" value="<?php echo $servicio['id']; ?>">
                            <button class="eliminar" type="submit">Eliminar</button>
                        </form>
                    <?php endif; ?>
                </li>
            <?php endforeach; ?>
        </ul>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 Cashi2 | Todos los derechos reservados</p>
    </footer>
</body>
</html>
