<?php
include_once 'header.php';
include_once 'includes/database.php';
?>
    <section class="main-container">
        <div class="main-wrapper">
            <h2>
                Sign Up
            </h2>
            <div class="notice">
                <?php
                if (isset($_GET['signup'])) {
                    $signupCheck = $_GET['signup'];
                    if ($signupCheck == "empty") {
                        echo "<p>[ You did not fill in all the fields ]</p>";
                    } elseif ($signupCheck == "char") {
                        echo "<p>[ Please change special characters ]</p>";
                    } elseif ($signupCheck == "invalidemail") {
                        echo "<p>[ Invalide email ]</p>";
                    } elseif ($signupCheck == "usertaken") {
                        echo "<p>[ User Taken ]</p>";
                    } elseif ($signupCheck == "success") {
                        echo "<p>[ You have been signed up ]</p>";
                    }
                }
                ?>
            </div>
            <form class="signup-form" action="includes/signup.php" method="POST">
                <?php
                if (isset($_GET ['first'])) {
                    $first = $_GET ['first'];
                    echo '<input class="form-control" type="text" name="first" placeholder="First name" >' . $first . '<br> ';
                } else {
                    echo ' <input class="form-control" type="text" name="first" placeholder="First name"> <br> ';
                }
                if (isset ($_GET ['last'])) {
                    $last = $_GET ['last'];
                    echo ' <input class="form-control" type="text" name="last" placeholder="Last Name">' . $last . ' <br> ';
                } else {
                    echo ' <input class="form-control" type="text" name="last" placeholder="Last Name"> <br> ';
                }
                if (isset($_GET ['uid'])) {
                    $uid = $_GET ['uid'];
                    echo ' <input class="form-control" type="text" name="uid" placeholder="User Name">' . $uid . ' <br> ';
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
        </div>
    </section>
<?php
include_once 'footer.php';
?>