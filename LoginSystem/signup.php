<?php
include_once 'header.php';
include_once 'includes/database.php'
?>
<section class="main-container">
    <div class="main-wrapper">
        <h2>
            Sign Up
        </h2>
        <form class="signup-form" action="includes/signup.php" method="POST">
            <?php
            if (isset($_GET ['first'])) {
                $first = $_GET ['first'];
                echo '<input class="form-control" type="text" name="first" placeholder="First name" value=' . $first . '> <br> ';
            } else {
                echo ' <input class="form-control" type="text" name="first" placeholder="First name"> <br> ';
            }
            if (isset ($_GET ['last'])) {
                $last = $_GET ['last'];
                echo ' <input class="form-control" type="text" name="last" placeholder="Last Name" value=' . $last . '> <br> ';
            } else {
                echo ' <input class="form-control" type="text" name="last" placeholder="Last Name"> <br> ';
            }

            if (isset($_GET ['uid'])) {
                $uid = $_GET ['uid'];
                echo ' <input class="form-control" type="text" name="uid" placeholder="User Name" value=' . $uid . '> <br> ';
            } else {
                echo ' <input class="form-control" type="text" name="uid" placeholder="User Name"> <br> ';
            }
            echo '<input class="form-control" type="text" name="email" placeholder="E-mail">' . '
    <br>' . '
    <input class="form-control" type="password" name="pwd" placeholder="Password">' . '
    <br>' . '
    <button type="submit" name="submit">Sign Up</button>';
            ?>
        </form>

        <?php
        if (!isset($_GET['submit'])) {
            exit();
        } else {
            $signupCheck = $_GET['submit'];
            if ($signupCheck == "empty") {
                echo "<p>[ You did not fill in all the fields ]</p>";
                exit();
            } elseif ($signupCheck == "char") {
                echo "<p>[ Please change special characters ]</p>";
                exit();
            } elseif ($signupCheck == "invalidemail") {
                echo "<p>[ Invalide email ]</p>";
                exit();
            } elseif ($signupCheck == "success") {
                echo "<p>[ You have been signed up ]</p>";
                $sql = "SELECT * FROM users;";
                $result = mysqli_query($conn, $sql);
                $resultCheck = mysqli_num_rows($result);
                if ($resultCheck > 0) {
                    while ($row = mysqli_fetch_assoc($result)) {
                        echo 'Welcome,' . ' ' . $row['user_uid'] . '<br>';
                    }
                }
                exit();
            }
        }
        ?>
    </div>
</section>
<?php
include_once 'footer.php';
?>