<?php
include_once "database.php";
if (isset ($_REQUEST ['submit'])) {
    $first = mysqli_real_escape_string($conn, $_POST ['first']);

    $last = mysqli_real_escape_string($conn, $_POST ['last']);

    $email = mysqli_real_escape_string($conn, $_POST ['email']);

    $uid = mysqli_real_escape_string($conn, $_POST ['uid']);

    $pwd = mysqli_real_escape_string($conn, $_POST ['pwd']);

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
            exit();
        } else {
            $sql="SELECT * FROM users WHERE user_uid='$uid'";
            $result = mysqli_query($conn, $sql);
            $resultCheck = mysqli_num_rows($result);
            if ($resultCheck > 0) {
                header("Location: ../signup.php?signup=usertaken");
                exit();
            }else{
                $hashedPwd = password_hash($pwd, PASSWORD_DEFAULT);
                $sql = "INSERT INTO users(user_first,user_last, user_email,user_uid,user_pwd) 
                            VALUES ('$first','$last','$email','$uid','$hashedPwd');";
                mysqli_query($conn, $sql);
//                $stmt = mysqli_stmt_init($conn);
//                if (!mysqli_stmt_prepare($stmt, $sqlInsert)) {
//                    echo "SQL error";
//                    exit();
//                } else {
//                    mysqli_stmt_bind_param($stmt, "sssss", $first, $last, $email, $uid, $pwd);
//                    mysqli_stmt_execute($stmt);
//                  }
                    header("Location: ../signup.php?signup=success");
                    exit();
                }
            }
        }
} else {
    header("Location: ../signup.php");
}

