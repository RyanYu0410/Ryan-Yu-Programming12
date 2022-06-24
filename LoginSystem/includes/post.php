<?php
include_once "database.php";

if (isset ($_POST ['post'])) {
    $title = mysqli_real_escape_string($conn, $_POST ['title']);

    $content = mysqli_real_escape_string($conn, $_POST ['content']);

    $date = strval(date("e T r"));


    if (empty($title) || empty($content) || empty($date) || empty($login_uid)) {
        header("Location: ../post.php?post=empty");
        exit();
    } else {
        $sql = "SELECT * FROM users WHERE user_uid='$login_uid'";
        $result = mysqli_query($conn, $sql);
        $resultCheck = mysqli_num_rows($result);
        if ($resultCheck < 0) {
            header("Location: ../post.php?post=error");
            exit();
        } else {
            $sql = "INSERT INTO posts (title,content,timedate,user_uid) 
                            VALUES ('$title','$content','$date','$login_uid');";
            mysqli_query($conn, $sql);
            header("Location: ../post.php?post=success");
            exit();
        }
    }
} else {
    header("Location: ../post.php");
}