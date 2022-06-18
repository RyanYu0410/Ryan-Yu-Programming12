<?php
include_once "database.php";
if (isset ($_POST ['submit'])) {
    include_once "database.php";
    $first = mysqli_real_escape_string($conn, $_POST ['first']);
    echo $first;
    $last = mysqli_real_escape_string($conn, $_POST ['last']);
    echo $last;
    $email = mysqli_real_escape_string($conn, $_POST ['email']);
    echo $email;
    $uid = mysqli_real_escape_string($conn, $_POST ['uid']);
    echo $uid;
    $pwd = mysqli_real_escape_string($conn, $_POST ['pwd']);
    echo $pwd;

    if (empty($first) || empty($last) || empty($email) || empty($uid) || empty($pwd)) {
        header("Location: ../signup.php?signup=empty");
        exit();
    } else {
        if (!preg_match("/^[a-zA-Z]*$/", $first) || !preg_match("/^[a-zA-Z]*$/", $last)) {
            header("Location: ../signup.php?signup=char");
            exit();
        }
        if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
            header("Location: ../signup.php?signup=invalidemail");
        } else {
            $sqlInsert = "INSERT INTO users(user_first,user_last, user_email,user_uid,user_pwd) 
                            VALUES (?,?,?,?,?);";
            $stmt = mysqli_stmt_init($conn);
            if (!mysqli_stmt_prepare($stmt, $sqlInsert)) {
                echo "SQL error";
            } else {
                mysqli_stmt_bind_param($stmt, "sssss", $first, $last, $email, $uid, $pwd);
                mysqli_stmt_execute($stmt);
            }
            header("Location: ../signup.php?signup=success");
        }
    }
} else {
    header("Location: ../signup.php?signup=error");
}
