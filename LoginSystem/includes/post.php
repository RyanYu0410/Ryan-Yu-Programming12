<?php
include_once "database.php";
if (isset ($_REQUEST ['post'])) {
    $title = mysqli_real_escape_string($conn, $_POST ['title']);

    $content = mysqli_real_escape_string($conn, $_POST ['content']);

    $u_id = mysqli_real_escape_string($conn, $_SESSION['u_id']);

    $date = strval(date("e T r"));


    if (empty($title) || empty($content)|| empty($date)|| empty($u_id)) {
        header("Location: ../post.php?post=empty");
        exit();
    } else {
        if (!preg_match("/^[a-zA-Z]*$/", $title) || !preg_match("/^[a-zA-Z]*$/", $content)) {
            header("Location: ../post.php?post=char");
            exit();
        } else {
            $sql = "SELECT * FROM users WHERE user_uid='$u_id'";
            $result = mysqli_query($conn, $sql);
            $resultCheck = mysqli_num_rows($result);
            if ($resultCheck < 0) {
                header("Location: ../post.php?post=error");
                exit();
            } else {
                $sql = "INSERT INTO posts(title,content,timedate,user_uid) 
                            VALUES ('$title','$content','$date','$u_id')";
                mysqli_query($conn, $sql);
                header("Location: ../post.php?post=success");
                exit();
            }
        }
    }
} else {
    header("Location: ../index.php");
}