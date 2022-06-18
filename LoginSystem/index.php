<?php
include_once 'header.php';
?>
    <section class="main-container">
        <div class="main-wrapper">
            <h2>Home Page</h2>
            <?php
            if (isset($_SESSION['u_id'])) {
                echo $_SESSION['u_id'];
            }
            ?>
            <div class="index-info">
                <div class="post-container">
                    <div class="post-innerContainer">
                        <h4 class="post-title">
                            Title
                        </h4>
                        <p class="post-content">
                            popopopoppopopopop
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