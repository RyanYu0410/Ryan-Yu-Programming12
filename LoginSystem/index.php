<?php
include_once 'header.php';
?>
    <section class="main-container">
        <div class="main-wrapper">
            <h2>Home Page</h2>
            <?php
            if (isset($_SESSION['u_id'])) {
                for ($i = 1; $i < 5; $i++) {
                    echo "<p>asd</p>";
                }



            }
            ?>
            <div class="index-info">
                <div class="post-container">
                    <div class="post-innerContainer">
                        <h4 class="post-title">
                            It's nice to meet you
                        </h4>
                        <p class="post-content">
                            Please go to "signup" to see all the contents
                            <br>
                        </p>
                        <div class="post-direct">
                            >See full content here
                            <p class="post-user">User name</p>
                        </div>
                    </div>
                    <div class="post-time">
                        PST 000nbfs
                    </div>
                </div>
            </div>
        </div>
    </section>
<?php
include_once 'footer.php';
?>