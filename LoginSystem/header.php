<?php session_start();?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Login System</title>
    <link href="reset.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
</head>
<body>
<header>
    <nav>
        <div class="main-wrapper">
            <ul>
                <li><a href="index.php">Home</a></li>
                <li><a href="signup.php">Sign Up</a></li>
                <li><a href="post.php">Post</a></li>
            </ul>
            <div class="nav-login">
                <?php
                if (isset($_SESSION['u_uid'])) {
                    echo '<form  class="nav-login" action="includes/logout.php" method="POST">
                        <button type="submit" name="logout">Log Out</button>                   
                    </form>';

                   echo "<div>welcome&nbsp;".$_SESSION['u_uid']."</div>";
                }else{
                    echo '<form class="nav-login" action="includes/login.php" method="POST">
                            <input type="text" name="uid" placeholder="Username/email">
                            <input type="password" name="pwd" placeholder="Password">
                            <button type="submit" name="login">Login</button>
                            </form>';
                }
                ?>
            </div>
        </div>
    </nav>
</header>