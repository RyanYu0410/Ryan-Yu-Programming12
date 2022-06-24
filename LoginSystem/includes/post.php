<?php
include_once "database.php";
session_start();

if (isset ($_POST ['post'])) {
    $title = mysqli_real_escape_string($conn, $_POST ['title']);

    $content = mysqli_real_escape_string($conn, $_POST ['content']);

    $date = strval(date("e T r"));

    $uid = $_SESSION['u_uid'];

    if (empty($title) || empty($content) || empty($date) || empty($uid)) {
        header("Location: ../post.php?post=empty");
        exit();
    } else {
        $sql = "SELECT * FROM users WHERE user_uid='$uid'";
        $result = mysqli_query($conn, $sql);
        $resultCheck = mysqli_num_rows($result);
        if ($resultCheck < 0) {
            header("Location: ../post.php?post=error");
            exit();
        } else {
            $sql = "INSERT INTO posts (title,content,timedate,user_uid) 
                            VALUES ('$title','$content','$date','$uid');";
            mysqli_query($conn, $sql);
            header("Location: ../index.php?post=success");
            exit();
        }
    }
} else {
    header("Location: ../post.php");
}